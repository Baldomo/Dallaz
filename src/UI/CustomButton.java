package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 27/04/17.
 */

public class CustomButton extends JButton {

    private static final Color DEFAULT_COLOR = new Color(0, 0, 0, 120);
    private static final Color PRESSED_COLOR = Color.WHITE;
    private static final Color HOVER_COLOR = new Color(0, 0, 0, 180);

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private static final String FONT_FILE = "MotionPicture.ttf";
    private static final Color DEFAULT_FONT_COLOR = Color.WHITE;
    private static final Color PRESSED_FONT_COLOR = Color.BLACK.brighter();
    private static final float FONT_SIZE = 40f;

    public CustomButton(int larghezza, int altezza, String testo) {
        super();
        _initFont();
        setText(testo);

        setSize(larghezza, altezza);

        setFocusable(false);
        setContentAreaFilled(false);
    }

    private void _initFont() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
            font = font.deriveFont(Font.PLAIN, FONT_SIZE);
            ge.registerFont(font);
            setFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()){
            g.setColor(PRESSED_COLOR);
            setForeground(PRESSED_FONT_COLOR);
        }
        else if (getModel().isRollover()){
            g.setColor(HOVER_COLOR);
            setForeground(DEFAULT_FONT_COLOR);
        }
        else {
            g.setColor(DEFAULT_COLOR);
            setForeground(DEFAULT_FONT_COLOR);
        }

        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    //@Override
    protected void paintBorder(Graphics g) {}

}
