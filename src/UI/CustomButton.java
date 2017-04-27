package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by danielamonesi on 27/04/17.
 */

public class CustomButton extends JButton {

    private static final Color DEFAULT_COLOR = new Color(0, 0, 0, 120);
    private static final Color PRESSED_COLOR = Color.WHITE;
    private static final Color HOVER_COLOR = new Color(0, 0, 0, 180);

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private static final String FONT_FILE = "MotionPicture.ttf";
    private static final String FONT_NAME = "MotionPicture";
    private static final float FONT_SIZE = 40f;

    public CustomButton(int larghezza, int altezza, String testo) {
        super();
        _initFont();
        setText("<html> <font face=\"MotionPicture\">" + testo + "</font> </html>");

        setSize(larghezza, altezza);

        setContentAreaFilled(false);
    }

    private void _initFont() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
            font = font.deriveFont(Font.PLAIN, 12f);
            ge.registerFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isRollover()){
            g.setColor(HOVER_COLOR);
            System.out.println("Rollover");
        }
        else if (getModel().isArmed()) g.setColor(PRESSED_COLOR);
        else g.setColor(DEFAULT_COLOR);

        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {}

}
