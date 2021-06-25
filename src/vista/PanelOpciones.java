package vista;

import javax.swing.*;
import java.awt.*;

public class PanelOpciones extends JPanel
{
    private JButton btnNuevoJuego, btnGuardarResultado, btnAcercaDe;

    public PanelOpciones ()
    {

        setBorder(BorderFactory.createTitledBorder("Opciones"));
        setLayout(new GridLayout(1,3));


        btnNuevoJuego = new JButton("Nueva Partida");
        btnGuardarResultado = new JButton("Guardar Resultado");
        btnAcercaDe = new JButton("Acerca de");

        add(btnNuevoJuego);
        add(btnGuardarResultado);
        add(btnAcercaDe);
    }
}
