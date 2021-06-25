package vista;

import javax.swing.*;
import java.awt.*;

public class PanelBanner extends JPanel
{
    private JLabel lblImage;

    public PanelBanner ()
    {
        lblImage = new JLabel();
        lblImage.setSize(550,150);

        ImageIcon imagen = new ImageIcon("data/imagenes/2584.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
        lblImage.setIcon(icono);

        add(lblImage);
    }
}
