package controlador;

import modelo.*;
import vista.InterfazPrincipal;

import java.awt.*;
import java.io.File;

public class ControladorPrincipal
{

    private Triqui triqui;

    private InterfazPrincipal interfazPrincipal;

    private static ControladorPrincipal controladorPrincipal = null;

    private ControladorPrincipal (Triqui pTriqui, InterfazPrincipal pInterfaz)
    {
        triqui = pTriqui;
        interfazPrincipal = pInterfaz;
    }


    public static ControladorPrincipal getInstance()
    {
        if (controladorPrincipal == null)
        {
            Triqui mundo = new Triqui();
            InterfazPrincipal ui = new InterfazPrincipal();
            controladorPrincipal = new ControladorPrincipal(mundo, ui);
        }
        return controladorPrincipal;
    }


    public void acercaDeControlador()
    {
        interfazPrincipal.mostrarAcercaDe(triqui.cadenaAcercaDe());
    }

    public void guardarResultadoControlador()
    {
        String nombreJ1 = triqui.getJugadores().get(0).getNombre();
        String nombreJ2 = triqui.getJugadores().get(1).getNombre();;
        String nombreGanador = triqui.darNombreGanador();

        Historial_partidasDTO historialPartidasDto = new Historial_partidasDTO(nombreJ1, nombreJ2, nombreGanador);
        Historial_partidasDAO historialPartidasDao = new Historial_partidasDAO();

        String sql = historialPartidasDao.insert(historialPartidasDto);

        boolean centinela = ConexionBD.getInstance().runExecuteUpdate(sql);

        if(centinela)
        {
            interfazPrincipal.ventanaInformacionBD("Se ha guardado correctamente", "Resultado conexion");
            interfazPrincipal.getPanelOpciones().getBtnGuardarResultado().setEnabled(false);
        }
        else
        {
            interfazPrincipal.ventanaInformacionBD("No se ha podido guardar correctamente", "Resultado conexion");
        }
    }

    public void nuevoJuegoControlador()
    {
        File archivo = interfazPrincipal.escogerArchivo().getSelectedFile( );

        if( archivo != null )
        {
            try
            {
                triqui.cargarTablero(archivo);
                interfazPrincipal.getPanelTablero().crearTablero(triqui.getFilas(), triqui.getColumnas());
                interfazPrincipal.getPanelOpciones().getBtnGuardarResultado().setEnabled(false);
                interfazPrincipal.getPanelInformacion().getTxtGanador().setText("");
                interfazPrincipal.getPanelInformacion().getTxtNombreJugador1().setText("");
                interfazPrincipal.getPanelInformacion().getTxtNombreJugador2().setText("");
                interfazPrincipal.getPanelInformacion().getTxtNombreJugador1().setBackground(Color.WHITE);
                interfazPrincipal.getPanelInformacion().getTxtNombreJugador2().setBackground(Color.WHITE);
                interfazPrincipal.getDialogoJugador().setVisible(true);

            } catch(Exception e)
            {
                interfazPrincipal.ventanaInformacionError("Error al cargar el tablero. \n" + e.getMessage());
            }
        }
        else
        {
            interfazPrincipal.ventanaInformacionError("Error al cargar el archivo: formato no válido.");
        }


    }

    public void reiniciarJuegoControlador()
    {
        interfazPrincipal.getPanelTablero().limpiarTablero();
        interfazPrincipal.getPanelInformacion().getTxtGanador().setText("");
        interfazPrincipal.getPanelInformacion().cambiarTurno(0);
        interfazPrincipal.getPanelOpciones().getBtnGuardarResultado().setEnabled(false);
        triqui.limpiarTablero();
    }

    public void marcarCasillaControlador(int posFila, int posColumna)
    {
        interfazPrincipal.getPanelTablero().marcarCasillaTablero(triqui.marcarCasilla(posFila, posColumna), posFila, posColumna);


        if(triqui.getJuegoTerminado())
        {
            interfazPrincipal.getPanelTablero().activarTablero(false);
            interfazPrincipal.getPanelInformacion().getTxtGanador().setText(triqui.darNombreGanador());
            pintarCasillasLineaCompletadaControlador();
            interfazPrincipal.getPanelOpciones().getBtnGuardarResultado().setEnabled(true);
        }
        else
        {
            interfazPrincipal.getPanelInformacion().cambiarTurno(triqui.darTurnoActual());
        }

    }

    public void pintarCasillasLineaCompletadaControlador()
    {
        Casilla[][] casillasCompletadas = triqui.getCasillasTableroTriqui();

        for( int i = 0; i < triqui.getFilas(); i++ )
        {
            for( int j = 0; j < triqui.getColumnas(); j++ )
            {
                if( casillasCompletadas[ i ][ j ].getEstado() == Casilla.Estado.LINEACOMPLETADA)
                {
                    interfazPrincipal.getPanelTablero().pintarCasillasLineaCompletada(i, j);
                }
            }
        }

    }



    public void configurarJugadores(String pNombreJugador1, String pFiguraJugador1, String pNombreJugador2, String pFiguraJugador2)
    {
        if(pNombreJugador1.equals("") || pNombreJugador2.equals(""))
        {
            interfazPrincipal.ventanaInformacionError("Error al cargar los jugadores: No pueden haber nombres vacios");

        }
        else if (pFiguraJugador1.equals(pFiguraJugador2))
        {
            interfazPrincipal.ventanaInformacionError("Error al cargar los jugadores: No pueden tener las mismas figuras");

        }
        else if(pNombreJugador1.equals(pNombreJugador2))
        {
            interfazPrincipal.ventanaInformacionError("Error al cargar los jugadores: Los nombres no pueden ser iguales");

        }
        else
        {
            triqui.añadirJugadores(pNombreJugador1, pFiguraJugador1, pNombreJugador2, pFiguraJugador2);
            interfazPrincipal.getPanelInformacion().actualizarInformacion(triqui.getJugadores().get(0).getNombre(), triqui.getJugadores().get(1).getNombre());
            interfazPrincipal.getPanelTablero().activarTablero(true);
            interfazPrincipal.getDialogoJugador().dispose();
            interfazPrincipal.getPanelInformacion().cambiarTurno(0);
            interfazPrincipal.getPanelOpciones().getBtnReiniciarJuego().setEnabled(true);
        }
    }

    public static void main (String[] args)
    {
        ControladorPrincipal controlador = getInstance();
    }
}
