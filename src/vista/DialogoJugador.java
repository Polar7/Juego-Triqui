package vista;

import controlador.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoJugador extends JDialog implements ActionListener
{

    private static final String ACEPTAR = "Aceptar";
    private static final String CANCELAR = "Cancelar";

    private JTextField jTxtNombreJugador1;
    private JComboBox<String> jComboBoxFigurasJugador1;

    private JTextField jTxtNombreJugador2;
    private JComboBox<String> jComboBoxFigurasJugador2;

    private JButton btnAceptar, btnCancelar;

    public DialogoJugador()
    {
        setSize(800,200);
        setTitle("Jugadores");
        setLocationRelativeTo( null );
        setLayout(new GridLayout(3,3));

        String figuras[] = { "EQUIS", "CIRCULO", "TRIANGULO", "ESTRELLA"};

        jTxtNombreJugador1 = new JTextField();
        jComboBoxFigurasJugador1 = new JComboBox<String>(figuras);

        jTxtNombreJugador2 = new JTextField();
        jComboBoxFigurasJugador2 = new JComboBox<String>(figuras);

        btnAceptar = new JButton("Jugar");
        btnAceptar.setActionCommand(ACEPTAR);
        btnAceptar.addActionListener(this);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);


        add(new JLabel("Ingrese el nombre del jugador 1: "));
        add(jTxtNombreJugador1);
        add(jComboBoxFigurasJugador1);
        add(new JLabel("Ingrese el nombre del jugador 2: "));
        add(jTxtNombreJugador2);
        add(jComboBoxFigurasJugador2);
        add(btnAceptar);
        add(new JLabel());
        add(btnCancelar);

    }

    public JTextField getjTxtNombreJugador1() {
        return jTxtNombreJugador1;
    }

    public JComboBox<String> getjComboBoxFigurasJugador1() {
        return jComboBoxFigurasJugador1;
    }

    public JTextField getjTxtNombreJugador2() {
        return jTxtNombreJugador2;
    }

    public JComboBox<String> getjComboBoxFigurasJugador2() {
        return jComboBoxFigurasJugador2;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals(ACEPTAR))
        {
            ControladorPrincipal.getInstance().configurarJugadores(jTxtNombreJugador1.getText(), jComboBoxFigurasJugador1.getSelectedItem().toString(), jTxtNombreJugador2.getText(),jComboBoxFigurasJugador2.getSelectedItem().toString() );
            dispose();
        } else if (e.getActionCommand().equals(CANCELAR))
        {
            dispose();
        }
    }
}
