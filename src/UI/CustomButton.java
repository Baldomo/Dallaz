package UI;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 26/04/17.
 */

public class CustomButton extends JPanel {

    private static final String FONT_FILE = "MotionPicture.ttf";
    private final float FONT_SIZE = 40f;

    private Color textColor = Color.WHITE;

    private CustomButton() {}

    public CustomButton(int larghezza, int altezza, @Nullable String testo) {
        super();
        setSize(new Dimension(larghezza, altezza));
        _initBackground(new Color(0, 0, 0, 120));
        try {
            setLayout(_initLayout(_initLabel(testo)));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

    }

    private JLabel _initLabel(String text) throws IOException, FontFormatException {
        JLabel btnText = new JLabel("Manca il testo qui!");

        if(text != null) btnText.setText(text);

        Font textFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
        btnText.setFont(textFont.deriveFont(Font.PLAIN, FONT_SIZE));

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
