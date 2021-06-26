package vista;

import controlador.ControladorPrincipal;
import modelo.Casilla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTablero extends JPanel implements ActionListener
{

    private JPanel panelTableroTriqui;

    private JButton[][] botonesCasillas;

    public PanelTablero ()
    {
        setBorder(BorderFactory.createTitledBorder("Tablero"));
        setLayout(new GridLayout(1,1));
        panelTableroTriqui = new JPanel();
        add(panelTableroTriqui);
    }

    public JButton[][] getBotonesCasillas()
    {
        return botonesCasillas;
    }

    public void crearTablero(int pFilas, int pColumnas )
    {
        panelTableroTriqui.setLayout(new GridLayout(pFilas, pColumnas));
        botonesCasillas = new JButton[pFilas][pColumnas];

        for (int i = 0; i < pFilas; i++)
        {
            for (int j = 0; j < pColumnas; j++)
            {
                botonesCasillas[ i ][ j ] = new JButton( );
                botonesCasillas[ i ][ j ].addActionListener( this );
                botonesCasillas[ i ][ j ].setActionCommand( i + "," + j );
                botonesCasillas[ i ][ j ].setSize(100,100);
                botonesCasillas[ i ][ j ].setBackground(Color.CYAN);
                ImageIcon icono = new ImageIcon( "data/imagenes/circulo.png" );
                botonesCasillas[ i ][ j ].setIcon(new ImageIcon(icono.getImage().getScaledInstance(botonesCasillas[ i ][ j ].getWidth(), botonesCasillas[ i ][ j ].getHeight(),Image.SCALE_SMOOTH)));
                botonesCasillas[ i ][ j ].revalidate();
                botonesCasillas[ i ][ j ].repaint();

                panelTableroTriqui.add(botonesCasillas[ i ][ j ]);
            }
        }

        panelTableroTriqui.revalidate();
        panelTableroTriqui.repaint();

    }

    public void actualizarTablero ( )
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand( );

        String[] coordenada = comando.split( "," );
        int i = Integer.parseInt( coordenada[ 0 ] );
        int j = Integer.parseInt( coordenada[ 1 ] );

        ControladorPrincipal.getInstance().marcarCasillaControlador(i,j);
    }
}
