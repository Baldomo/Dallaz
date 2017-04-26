package UI;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 26/04/17.
 */

public class CustomButton extends JPanel {

    private static final String FONT_FILE = "MotionPicture.ttf";
    private static final float FONT_SIZE = 40f;

    private static final Color DEFAULT_COLOR = new Color(0, 0, 0, 120);
    private static final Color PRESSED_COLOR = Color.WHITE;
    private static final Color HOVER_COLOR = new Color(0, 0, 0, 180);

    private JLabel btnText = new JLabel("Manca il testo qui!");

    private Color textColor = Color.WHITE;

    private CustomButton() {}

    public CustomButton(int larghezza, int altezza, @Nullable String testo) {
        super();
        setSize(new Dimension(larghezza, altezza));
        _initBackground(DEFAULT_COLOR);
        try {
            setLayout(_initLayout(_initLabel(testo)));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(PRESSED_COLOR);
                btnText.setForeground(Color.BLACK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(DEFAULT_COLOR);
                btnText.setForeground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(HOVER_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(DEFAULT_COLOR);
            }
        });
        setFocusable(false);
    }

    private JLabel _initLabel(String text) throws IOException, FontFormatException {
        if(text != null) btnText.setText(text);

        Font textFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
        btnText.setFont(textFont.deriveFont(Font.PLAIN, FONT_SIZE));
        //btnText.setFont(Font.getFont("SansSerif"));

        btnText.setForeground(textColor);
        add(btnText);
        return btnText;
    }

    private void _initBackground(Color bgColor) {
        setBackground(bgColor);
    }

    private SpringLayout _initLayout(JLabel btnText) {
        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnText, 0, SpringLayout.VERTICAL_CENTER, this);

        // Più è grande il testo, più è distanziato dal bordo sinistro del pulsante --> cambiare se necessario
        layout.putConstraint(SpringLayout.WEST, btnText, (int) FONT_SIZE/2, SpringLayout.WEST, this);
        return layout;
    }
}
