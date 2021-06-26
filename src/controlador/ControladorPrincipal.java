package controlador;

import modelo.Triqui;
import vista.InterfazPrincipal;

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
        interfazPrincipal.getPanelOpciones().mostrarAcercaDe(triqui.cadenaAcercaDe());
    }

    public void guardarResultadoControlador()
    {

    }

    public void nuevoJuegoControlador()
    {
        configurarArchivo();
        interfazPrincipal.getDialogoJugador().setVisible(true);

    }

    public void marcarCasillaControlador(int posFila, int posColumna)
    {
        triqui.marcarCasilla(posFila, posColumna);

    }

    private void configurarArchivo()
    {
        File archivo = interfazPrincipal.escogerArchivo().getSelectedFile( );

        if( archivo != null )
        {
            try
            {
                triqui.cargarTablero(archivo);
                interfazPrincipal.getPanelTablero().crearTablero(triqui.getFilas(), triqui.getColumnas());

            } catch(Exception e)
            {
                interfazPrincipal.ventanaInformacion("Error al cargar el tablero. \n" + e.getMessage());
            }
        }
        else
        {
            interfazPrincipal.ventanaInformacion("Error al cargar el archivo: formato no válido.");
        }
    }

    public void configurarJugadores(String pNombreJugador1, String pFiguraJugador1, String pNombreJugador2, String pFiguraJugador2)
    {
        triqui.añadirJugadores(pNombreJugador1, pFiguraJugador1, pNombreJugador2, pFiguraJugador2);
        interfazPrincipal.getPanelInformacion().actualizarInformacion(pNombreJugador1, pNombreJugador2);
    }

    public static void main (String[] args)
    {
        ControladorPrincipal controlador = getInstance();
    }
}
