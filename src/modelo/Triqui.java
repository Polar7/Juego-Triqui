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


    private boolean juegoTerminado;

    private long tiempoInicio;


    private long tiempoFinal;

    private ArrayList<Jugador> jugadores;

    public Triqui()
    {
        filas = 0;
        columnas = 0;
        jugadores = new ArrayList<Jugador>();
        juegoTerminado = false;
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

    public boolean getJuegoTerminado()
    {
        return juegoTerminado;
    }


    public void añadirJugadores(String pNombreJugador1, String pFiguraJugador1, String pNombreJugador2, String pFiguraJugador2)
    {
        jugadores.removeAll(jugadores);
        Jugador jugador1 = new Jugador(pNombreJugador1, pFiguraJugador1);
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador(pNombreJugador2, pFiguraJugador2);
        jugadores.add(jugador2);

        jugador1.setEsSuTurno(true);

        jugador1.asignarFigura(pFiguraJugador1);
        jugador2.asignarFigura(pFiguraJugador2);
    }


    public boolean verificarSiHayGanador (Casilla.Figura pFigura)
    {
        boolean centinela = false;

        if(verificarPorFila(pFigura))
        {
            centinela = true;
        }
        else if (verificarPorColumna(pFigura))
        {
            centinela = true;
        }
        else if (verificarPorDiagonalPrincipal(pFigura))
        {
            centinela = true;
        }
        else if (verificarPorDiagonalInvertida(pFigura))
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

        juegoTerminado = false;
    }

    public String marcarCasilla (int pPosFila, int pPosColumna)
    {
        String figuraCasilla = "";

        if(darTurnoActual() == 0)
        {
            if(casillasTableroTriqui[ pPosFila ][ pPosColumna ].getEstado() == Casilla.Estado.VACIA)
            {
                casillasTableroTriqui[pPosFila][pPosColumna].setValor(jugadores.get(0).getFigura());
                casillasTableroTriqui[ pPosFila ][ pPosColumna ].setEstado(Casilla.Estado.OCUPADA);

                figuraCasilla = jugadores.get(0).getCadenaFigura();

                if(verificarSiHayGanador(jugadores.get(0).getFigura()) )
                {
                    juegoTerminado = true;
                    jugadores.get(0).setEsGanador(true);
                }
            }



        } else
        {
            casillasTableroTriqui[pPosFila][pPosColumna].setValor(jugadores.get(1).getFigura());



            figuraCasilla = jugadores.get(1).getCadenaFigura();

            if(verificarSiHayGanador(jugadores.get(1).getFigura()) )
            {
                juegoTerminado = true;
                jugadores.get(1).setEsGanador(true);
            }
        }


        cambiarTurno();

        return figuraCasilla;
    }

    public int darTurnoActual()
    {
        int centinela = 0;

        if( jugadores.get(0).isEsSuTurno())
        {
            centinela = 0;

        }else if(jugadores.get(1).isEsSuTurno())
        {
            centinela = 1;
        }

        return centinela;
    }

    public void cambiarTurno()
    {
        if( jugadores.get(0).isEsSuTurno())
        {
            jugadores.get(0).setEsSuTurno(false);
            jugadores.get(1).setEsSuTurno(true);
        }
        else if( jugadores.get(1).isEsSuTurno() )
        {
            jugadores.get(1).setEsSuTurno(false);
            jugadores.get(0).setEsSuTurno(true);
        }
    }

    public void limpiarTablero()
    {
        casillasTableroTriqui = new Casilla[filas][columnas];

        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas; j++ )
            {
                casillasTableroTriqui[ i ][ j ] = new Casilla();
                casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.VACIA);
            }
        }

        juegoTerminado = false;

        jugadores.get(0).setEsGanador(false);
        jugadores.get(1).setEsGanador(false);
        jugadores.get(0).setEsSuTurno(true);
        jugadores.get(1).setEsSuTurno(false);
    }

    public String darNombreGanador()
    {
        String cadena = "";

        if(jugadores.get(0).isEsGanador())
        {
            cadena = jugadores.get(0).getNombre();
        }
        else if( jugadores.get(1).isEsGanador() )
        {
            cadena = jugadores.get(1).getNombre();
        }
        return cadena;
    }

    public String cadenaAcercaDe()
    {
        String mensaje = "Juego creado por:\n" + "Jean Michael Lozano Cardoso";

        return mensaje;
    }



    private boolean verificarPorFila (Casilla.Figura pFigura)
    {
        boolean centinela = false;

        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas - 2 ; j++ )
            {
                if(casillasTableroTriqui[ i ][ j ].getValor() != null &&
                        casillasTableroTriqui[ i ][ j+1 ].getValor() != null &&
                        casillasTableroTriqui[ i ][ j+2 ].getValor() != null)
                {
                    if (casillasTableroTriqui[ i ][ j ].getValor() == pFigura &&
                            casillasTableroTriqui[ i ][ j+1 ].getValor() == pFigura &&
                            casillasTableroTriqui[ i ][ j+2 ].getValor() == pFigura)
                    {
                        centinela = true;
                        casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        casillasTableroTriqui[ i ][ j+1 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        casillasTableroTriqui[ i ][ j+2 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        break;
                    }
                }


            }
        }

        return centinela;
    }

    private boolean verificarPorColumna (Casilla.Figura pFigura)
    {
        boolean centinela = false;

        for( int j = 0; j < columnas; j++ )
        {
            for( int i = 0; i < filas - 2 ; i++ )
            {
                if (casillasTableroTriqui[ i ][ j ].getValor() != null &&
                        casillasTableroTriqui[ i+1 ][ j ].getValor() != null &&
                        casillasTableroTriqui[ i+2 ][ j ].getValor() != null)
                {
                    if (casillasTableroTriqui[ i ][ j ].getValor() == pFigura &&
                            casillasTableroTriqui[ i+1 ][ j ].getValor() == pFigura &&
                            casillasTableroTriqui[ i+2 ][ j ].getValor() == pFigura)
                    {
                        centinela = true;
                        casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        casillasTableroTriqui[ i+1 ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        casillasTableroTriqui[ i+2 ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        break;
                    }
                }


            }
        }

        return centinela;
    }

    private boolean verificarPorDiagonalPrincipal(Casilla.Figura pFigura)
    {
        boolean centinela = false;

        for( int i = 0; i < filas - 2; i++ )
        {
            for( int j = 0; j < columnas - 2 ; j++ )
            {
                if(casillasTableroTriqui[ i ][ j ].getValor() != null &&
                        casillasTableroTriqui[ i+1 ][ j+1 ].getValor() != null &&
                        casillasTableroTriqui[ i+2 ][ j+2 ].getValor() != null)
                {
                    if(casillasTableroTriqui[ i ][ j ].getValor() == pFigura &&
                            casillasTableroTriqui[ i+1 ][ j+1 ].getValor() == pFigura &&
                            casillasTableroTriqui[ i+2 ][ j+2 ].getValor() == pFigura)
                    {
                        centinela = true;
                        casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        casillasTableroTriqui[ i+1 ][ j+1 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        casillasTableroTriqui[ i+2 ][ j+2 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                        break;
                    }
                }
            }
        }

        return centinela;
    }

    private boolean verificarPorDiagonalInvertida(Casilla.Figura pFigura)
    {
        boolean centinela = false;

        for( int i = 0; i < filas - 2; i++ )
        {
            for( int j = columnas - 1; j >= 2 ; j-- )
            {
                if(casillasTableroTriqui[ i ][ j ].getValor() == pFigura &&
                        casillasTableroTriqui[ i+1 ][ j-1 ].getValor() == pFigura &&
                        casillasTableroTriqui[ i+2 ][ j-2 ].getValor() == pFigura)
                {
                    centinela = true;
                    casillasTableroTriqui[ i ][ j ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ i+1 ][ j-1 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    casillasTableroTriqui[ i+2 ][ j-2 ].setEstado(Casilla.Estado.LINEACOMPLETADA);
                    break;
                }
            }
        }

        return centinela;
    }
}
