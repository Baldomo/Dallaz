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
        _initBackground(new Color(0, 0, 0, 120));
        setLayout(_initLayout(_initLabel("Prova")));

    }

    private Color textColor = Color.WHITE;

    private JLabel _initLabel(String btnText) {
        JLabel text = new JLabel(btnText);
        text.setFont(Font.getFont(Font.SERIF));
        text.setForeground(textColor);
        add(text);
        return text;
    }

    private void _initBackground(Color bgColor) {
        setBackground(bgColor);
    }

    private SpringLayout _initLayout(JLabel btnText) {
        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnText, 0, SpringLayout.VERTICAL_CENTER, this);
        layout.putConstraint(SpringLayout.WEST, btnText, 10, SpringLayout.WEST, this);
        return layout;
    }

}
