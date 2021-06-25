package vista;

import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel
{
    private JButton prueba;

    public PanelTablero ()
    {
        setBorder(BorderFactory.createTitledBorder("Tablero"));
        setLayout(new GridLayout(1,2));

        prueba = new JButton("Prueba1");

        add(prueba);
        add(new JLabel("Prueba2"));
    }
}
