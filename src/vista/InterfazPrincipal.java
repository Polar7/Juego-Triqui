package vista;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal extends JFrame
{
    private PanelBanner panelBanner;
    private PanelOpciones panelOpciones;
    private PanelTablero panelTablero;
    private PanelInformacion panelInformacion;
    private DialogoJugador dialogoJugador;

    public InterfazPrincipal ()
    {
        setTitle( "Triqui" );
        setSize( 900, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );
        setLocationRelativeTo( null );
        setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch( Exception e )
        {
            e.printStackTrace( );
        }

        panelBanner = new PanelBanner();
        panelOpciones = new PanelOpciones();
        panelTablero = new PanelTablero();
        panelInformacion = new PanelInformacion();
        dialogoJugador = new DialogoJugador();


        add(panelBanner, BorderLayout.NORTH);
        add(panelTablero, BorderLayout.CENTER);
        add(panelInformacion, BorderLayout.WEST);
        add(panelOpciones, BorderLayout.SOUTH);

        setVisible(true);
    }

    public PanelBanner getPanelBanner() {
        return panelBanner;
    }

    public PanelOpciones getPanelOpciones() {
        return panelOpciones;
    }

    public PanelTablero getPanelTablero() {
        return panelTablero;
    }

    public PanelInformacion getPanelInformacion()
    {
        return panelInformacion;
    }

    public DialogoJugador getDialogoJugador ()
    {
        return dialogoJugador;
    }

    public JFileChooser escogerArchivo()
    {
        JFileChooser fileChooser = new JFileChooser("./data");
        fileChooser.setDialogTitle("Seleccionar archivo");
        fileChooser.showOpenDialog(null);

        return fileChooser;
    }

    public void ventanaInformacionError(String pMensaje)
    {
        JOptionPane.showMessageDialog(null, pMensaje, "Cargar juego", JOptionPane.ERROR_MESSAGE);
    }

    public void ventanaInformacionBD(String pMensaje, String pTitulo)
    {
        JOptionPane.showMessageDialog(null, pMensaje, pTitulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarAcercaDe(String pMensaje)
    {
        JOptionPane.showMessageDialog(null, pMensaje, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }
}
