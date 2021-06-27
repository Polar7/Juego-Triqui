package vista;

import controlador.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel implements ActionListener
{

    private static final String ACERCA_DE = "Acerca de";

    private static final String GUARDAR_RESULTADO = "Guardar resultado";

    private static final String NUEVO_JUEGO = "Nuevo juego";

    private static final String REINICIAR_JUEGO = "Reiniciar juego";

    private JButton btnNuevoJuego, btnReiniciarJuego, btnGuardarResultado, btnAcercaDe;

    public PanelOpciones ()
    {

        setBorder(BorderFactory.createTitledBorder("Opciones"));
        setLayout(new GridLayout(1,4));


        btnNuevoJuego = new JButton("Nueva Partida");
        btnGuardarResultado = new JButton("Guardar Resultado");
        btnAcercaDe = new JButton("Acerca de");
        btnReiniciarJuego = new JButton("Reiniciar partida actual");

        btnAcercaDe.setActionCommand(ACERCA_DE);
        btnAcercaDe.addActionListener(this);
        btnGuardarResultado.setActionCommand(GUARDAR_RESULTADO);
        btnGuardarResultado.addActionListener(this);
        btnNuevoJuego.setActionCommand(NUEVO_JUEGO);
        btnNuevoJuego.addActionListener(this);
        btnReiniciarJuego.setActionCommand(REINICIAR_JUEGO);
        btnReiniciarJuego.addActionListener(this);

        btnGuardarResultado.setEnabled(false);
        btnReiniciarJuego.setEnabled(false);

        add(btnNuevoJuego);
        add(btnReiniciarJuego);
        add(btnGuardarResultado);
        add(btnAcercaDe);
    }

    public JButton getBtnNuevoJuego() {
        return btnNuevoJuego;
    }

    public JButton getBtnGuardarResultado() {
        return btnGuardarResultado;
    }

    public JButton getBtnAcercaDe() {
        return btnAcercaDe;
    }

    public JButton getBtnReiniciarJuego(){
        return btnReiniciarJuego;
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {

        switch (e.getActionCommand())
        {
            case ACERCA_DE:
                ControladorPrincipal.getInstance().acercaDeControlador();
                break;
            case GUARDAR_RESULTADO:
                ControladorPrincipal.getInstance().guardarResultadoControlador();
                break;
            case NUEVO_JUEGO:
                ControladorPrincipal.getInstance().nuevoJuegoControlador();
                break;
            case REINICIAR_JUEGO:
                ControladorPrincipal.getInstance().reiniciarJuegoControlador();
                break;
        }

    }
}
