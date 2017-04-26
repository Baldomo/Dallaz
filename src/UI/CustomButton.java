package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonardo Baldin on 26/04/17.
 */

public class CustomButton extends JPanel {

    private CustomButton() {}

    public CustomButton(int larg, int alt) {
        super();
        setSize(new Dimension(larg, alt));
        setLayout(new SpringLayout());
        _initLabel("Prova");
        _initBackground(new Color(0, 0, 0, 120));

    }

    private Color textColor = Color.WHITE;

    private void _initLabel(String labelText) {
        JLabel text = new JLabel(labelText);
        text.setFont(Font.getFont(Font.SERIF));
        text.setForeground(textColor);
        add(text);
    }

    private void _initBackground(Color bgColor) {
        setBackground(bgColor);
    }

}
