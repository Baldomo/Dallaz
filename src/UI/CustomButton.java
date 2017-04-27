package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by danielamonesi on 27/04/17.
 */
public class CustomButton extends JButton {

    private static final Color DEFAULT_COLOR = new Color(0, 0, 0, 120);
    private static final Color PRESSED_COLOR = Color.WHITE;
    private static final Color HOVER_COLOR = new Color(0, 0, 0, 180);

    public CustomButton(int larghezza, int altezza, String testo) {
        super(testo);

        setSize(larghezza, altezza);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isRollover()) g.setColor(HOVER_COLOR);
        else if (getModel().isArmed()) g.setColor(PRESSED_COLOR);
        else g.setColor(DEFAULT_COLOR);

        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {}

}
