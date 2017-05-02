package UI.Elements;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 27/04/17.
 */

public class CustomButton extends JButton {

    // Costanti dei vari colori del pulsante
    private static final Color DEFAULT_COLOR = new Color(0, 0, 0, 120);
    private static final Color PRESSED_COLOR = Color.WHITE;
    private static final Color HOVER_COLOR = new Color(0, 0, 0, 210);

    // Costanti del font del pulsante
    private static final String FONT_FILE = "Resources/Cutrims.otf";
    private static final Color DEFAULT_FONT_COLOR = Color.WHITE;
    private static final Color PRESSED_FONT_COLOR = Color.BLACK.brighter();
    private float fontSize = 40f;
    private Font font;

    public CustomButton(int larghezza, int altezza, @Nullable String testo) {
        super();
        _initFont();
        this.setText(testo);

        this.setPreferredSize(new Dimension(larghezza, altezza));
        this.setSize(larghezza, altezza);

        setFocusable(false);
        setContentAreaFilled(false);
    }

    /*
    *  _initFont() inizializza la variabile font dal file di font indicato in FONT_FILE e cambia la font del pulsante
    */
    private void _initFont() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
            font = font.deriveFont(Font.PLAIN, fontSize);
            setFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setFontSize(float newSize) {
        fontSize = newSize;
        font = font.deriveFont(fontSize);
        setFont(font);
    }

    /*
    *  paintComponent(Graphics) si occupa di disegnare il JButton sullo schermo. Con @Override, è possibile
    *  cambiare il comportamento del pulsante nei vari casi.
    *
    *  isArmed: true quando il pulsante del mouse è premuto nell'area del JButton
    *  isRollover: true quando il cursore è sopra l'area del JButton
    */
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
