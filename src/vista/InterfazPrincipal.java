package vista;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal extends JFrame
{
    private PanelBanner panelBanner;
    private PanelOpciones panelOpciones;
    private PanelTablero panelTablero;

    public InterfazPrincipal ()
    {
        setTitle( "Triqui" );
        setSize( 550, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( true );
        setLocationRelativeTo( null );
        setLayout(new BorderLayout());

        panelBanner = new PanelBanner();
        panelOpciones = new PanelOpciones();
        panelTablero = new PanelTablero();

        add(panelBanner, BorderLayout.NORTH);
        add(panelTablero, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.SOUTH);
    }

    public static void main(String [] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfazPrincipal ui = new InterfazPrincipal();
            ui.setVisible(true);
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
