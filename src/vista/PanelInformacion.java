package vista;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel
{
    private JTextField txtTiempo, txtNombreJugador1, txtNombreJugador2;

    public PanelInformacion ()
    {
        setBorder(BorderFactory.createTitledBorder("Informacion del juego"));
        setLayout(new GridLayout(3,2));

        txtTiempo = new JTextField();
        txtNombreJugador1 = new JTextField();
        txtNombreJugador1.setEditable(false);
        txtNombreJugador2 = new JTextField();
        txtNombreJugador2.setEditable(false);

        add(new JLabel("Tiempo de juego: "));
        add(txtTiempo);
        add(new JLabel("Jugador 1: "));
        add(txtNombreJugador1);
        add(new JLabel("Jugador 2: "));
        add(txtNombreJugador2);
    }

    public JTextField getTxtTiempo() {
        return txtTiempo;
    }

    public JTextField getTxtNombreJugador1() {
        return txtNombreJugador1;
    }

    public JTextField getTxtNombreJugador2() {
        return txtNombreJugador2;
    }

    public void actualizarInformacion(String pNombreJugador1, String pNombreJugador2)
    {
        txtNombreJugador1.setText(pNombreJugador1);
        txtNombreJugador2.setText(pNombreJugador2);
    }
}
