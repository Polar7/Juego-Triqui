package vista;

import controlador.ControladorPrincipal;
import modelo.Casilla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTablero extends JPanel implements ActionListener
{

    private static final String RUTA_FIGURA_EQUIS = "data/imagenes/equis.png";

    private static final String RUTA_FIGURA_CIRCULO = "data/imagenes/circulo.png";

    private static final String RUTA_FIGURA_TRIANGULO = "data/imagenes/triangulo.png";

    private static final String RUTA_FIGURA_ESTRELLA = "data/imagenes/estrella.png";

    private JPanel panelTableroTriqui;

    private JButton[][] botonesCasillas;

    private int filasBotones;
    private int columnasBotones;

    public PanelTablero ()
    {
        setBorder(BorderFactory.createTitledBorder("Tablero"));
        setLayout(new GridLayout(1,1));
        panelTableroTriqui = new JPanel();
        add(panelTableroTriqui);
        filasBotones = 0;
        columnasBotones = 0;
    }

    public JButton[][] getBotonesCasillas()
    {
        return botonesCasillas;
    }

    public void crearTablero(int pFilas, int pColumnas )
    {
        panelTableroTriqui.removeAll();
        panelTableroTriqui.setLayout(new GridLayout(pFilas, pColumnas));
        botonesCasillas = new JButton[pFilas][pColumnas];
        filasBotones = pFilas;
        columnasBotones = pColumnas;

        for (int i = 0; i < pFilas; i++)
        {
            for (int j = 0; j < pColumnas; j++)
            {
                botonesCasillas[ i ][ j ] = new JButton( );
                botonesCasillas[ i ][ j ].addActionListener( this );
                botonesCasillas[ i ][ j ].setActionCommand( i + "," + j );
                botonesCasillas[ i ][ j ].setSize(100,100);
                botonesCasillas[ i ][ j ].setBackground(Color.WHITE);
                botonesCasillas[ i ][ j ].revalidate();
                botonesCasillas[ i ][ j ].repaint();

                panelTableroTriqui.add(botonesCasillas[ i ][ j ]);

            }
        }

        panelTableroTriqui.revalidate();
        panelTableroTriqui.repaint();

        activarTablero(false);
    }

    public void limpiarTablero ( )
    {
        panelTableroTriqui.removeAll();
        panelTableroTriqui.setLayout(new GridLayout(filasBotones, columnasBotones));
        botonesCasillas = new JButton[filasBotones][columnasBotones];

        for (int i = 0; i < filasBotones; i++)
        {
            for (int j = 0; j < columnasBotones; j++)
            {
                botonesCasillas[ i ][ j ] = new JButton( );
                botonesCasillas[ i ][ j ].addActionListener( this );
                botonesCasillas[ i ][ j ].setActionCommand( i + "," + j );
                botonesCasillas[ i ][ j ].setSize(100,100);
                botonesCasillas[ i ][ j ].setBackground(Color.WHITE);
                botonesCasillas[ i ][ j ].revalidate();
                botonesCasillas[ i ][ j ].repaint();

                panelTableroTriqui.add(botonesCasillas[ i ][ j ]);

            }
        }

        panelTableroTriqui.revalidate();
        panelTableroTriqui.repaint();

        activarTablero(true);
    }

    public void activarTablero(boolean pActivado)
    {
        for (int i = 0; i < filasBotones; i++)
        {
            for (int j = 0; j < columnasBotones; j++)
            {
                botonesCasillas[i][j].setEnabled(pActivado);
            }
        }
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

    public void marcarCasillaTablero(String pFigura, int pPosFila, int pPosColumna)
    {
        if(pFigura.equals("EQUIS"))
        {
            ImageIcon icono = new ImageIcon( RUTA_FIGURA_EQUIS );
            botonesCasillas[ pPosFila ][ pPosColumna ].setIcon(new ImageIcon(icono.getImage().getScaledInstance(botonesCasillas[ pPosFila ][ pPosColumna ].getWidth(), botonesCasillas[ pPosFila ][ pPosColumna ].getHeight(),Image.SCALE_SMOOTH)));
        }
        else if (pFigura.equals("CIRCULO"))
        {
            ImageIcon icono = new ImageIcon( RUTA_FIGURA_CIRCULO );
            botonesCasillas[ pPosFila ][ pPosColumna ].setIcon(new ImageIcon(icono.getImage().getScaledInstance(botonesCasillas[ pPosFila ][ pPosColumna ].getWidth(), botonesCasillas[ pPosFila ][ pPosColumna ].getHeight(),Image.SCALE_SMOOTH)));
        }
        else if (pFigura.equals("TRIANGULO"))
        {
            ImageIcon icono = new ImageIcon( RUTA_FIGURA_TRIANGULO);
            botonesCasillas[ pPosFila ][ pPosColumna ].setIcon(new ImageIcon(icono.getImage().getScaledInstance(botonesCasillas[ pPosFila ][ pPosColumna ].getWidth(), botonesCasillas[ pPosFila ][ pPosColumna ].getHeight(),Image.SCALE_SMOOTH)));
        }
        else if (pFigura.equals("ESTRELLA"))
        {
            ImageIcon icono = new ImageIcon( RUTA_FIGURA_ESTRELLA );
            botonesCasillas[ pPosFila ][ pPosColumna ].setIcon(new ImageIcon(icono.getImage().getScaledInstance(botonesCasillas[ pPosFila ][ pPosColumna ].getWidth(), botonesCasillas[ pPosFila ][ pPosColumna ].getHeight(),Image.SCALE_SMOOTH)));
        }

        botonesCasillas[ pPosFila ][ pPosColumna ].setEnabled(false);
    }

    public void pintarCasillasLineaCompletada(int pPosFila, int pPosColumna)
    {
        botonesCasillas[pPosFila][ pPosColumna ].setBackground(Color.GREEN);
    }


}
