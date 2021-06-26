package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Triqui
{
    public enum EstadoJuego
    {
        JUEGO_GANADO, CONTINUA_JUEGO
    }

    private Casilla[][] casillasTableroTriqui;

    private int columnas;


    private int filas;


    private EstadoJuego estadoJuego;


    private long tiempoInicio;


    private long tiempoFinal;

    private ArrayList<Jugador> jugadores;

    public Triqui()
    {
        filas = 0;
        columnas = 0;
        jugadores = new ArrayList<Jugador>();
    }

    public Casilla[][] getCasillasTableroTriqui() {
        return casillasTableroTriqui;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public ArrayList<Jugador> getJugadores()
    {
        return jugadores;
    }


    public void añadirJugadores(String pNombreJugador1, String pFiguraJugador1, String pNombreJugador2, String pFiguraJugador2)
    {
        Jugador jugador1 = new Jugador(pNombreJugador1, pFiguraJugador1);
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador(pNombreJugador1, pFiguraJugador1);
        jugadores.add(jugador2);
    }
    public boolean verificarSiHayGanador (Casilla.Valor pValor)
    {
        boolean centinela = false;

        if(verificarPorFila(pValor))
        {
            centinela = true;
        }
        else if (verificarPorColumna(pValor))
        {
            centinela = true;
        }
        else if (verificarPorDiagonal(pValor))
        {
            centinela = true;
        }
       return centinela;
    }


    public void cargarTablero(File pArchivoTablero) throws Exception
    {

        Properties propiedadesTriqui = new Properties( );
        InputStream inputLetras = new FileInputStream( pArchivoTablero );
        propiedadesTriqui.load( inputLetras );

        filas = Integer.parseInt( propiedadesTriqui.getProperty( "triqui.filas" ) );
        columnas = Integer.parseInt( propiedadesTriqui.getProperty( "triqui.columnas" ) );

        casillasTableroTriqui = new Casilla[filas][columnas];

        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas; j++ )
            {
                casillasTableroTriqui[ i ][ j ] = new Casilla();
                casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.VACIA);
            }
        }
    }

    public void marcarCasilla (int pPosFila, int pPosColumna)
    {
       // casillasTableroTriqui[pPosFila][pPosColumna].setValor();
    }

    public int darTurnoActual()
    {
        if( jugadores.get(0).isEsSuTurno())
        {
            return 0;
        }else
        {
            return 1;
        }
    }

    public String cadenaAcercaDe()
    {
        String mensaje = "Juego creado por:\n" + " Jean Michael Lozano Cardoso";

        return mensaje;
    }



    private boolean verificarPorFila (Casilla.Valor pValor)
    {
        boolean centinela = false;

        for( int i = 1; i <= filas; i++ )
        {
            for( int j = 1; j <= columnas - 2 ; j++ )
            {
                if (casillasTableroTriqui[ i ][ j ].getValor() == pValor &&
                        casillasTableroTriqui[ i ][ j+1 ].getValor() == pValor &&
                        casillasTableroTriqui[ i ][ j+2 ].getValor() == pValor)
                {
                    centinela = true;
                    casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ i ][ j+1 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ i ][ j+2 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    break;
                }

            }
        }

        return centinela;
    }

    private boolean verificarPorColumna (Casilla.Valor pValor)
    {
        boolean centinela = false;

        for( int j = 1; j <= columnas; j++ )
        {
            for( int i = 1; i <= filas - 2 ; i++ )
            {
                if (casillasTableroTriqui[ j ][ i ].getValor() == pValor &&
                        casillasTableroTriqui[ j ][ i+1 ].getValor() == pValor &&
                        casillasTableroTriqui[ j ][ i+2 ].getValor() == pValor)
                {
                    centinela = true;
                    casillasTableroTriqui[ j ][ i ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ j ][ i+1 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ j ][ i+2 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    break;
                }

            }
        }

        return centinela;
    }

    private boolean verificarPorDiagonal(Casilla.Valor pValor)
    {
        boolean centinela = false;

        for( int i = 1; i <= filas; i++ )
        {
            for( int j = 1; j <= columnas - 2 ; j++ )
            {
                if(casillasTableroTriqui[ i ][ j ].getValor() == pValor &&
                        casillasTableroTriqui[ i+1 ][ j+1 ].getValor() == pValor &&
                        casillasTableroTriqui[ i+2 ][ j+2 ].getValor() == pValor)
                {
                    centinela = true;
                    casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ i+1 ][ j+1 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ i+2 ][ j+2 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    break;
                }
            }
        }

        return centinela;
    }
}
