package UI.Frames;

import UI.Elements.CustomButton;
import Utilities.Choice;
import com.sun.istack.internal.NotNull;
import java.awt.Color;

import javax.swing.*;

/**
 * Created by Leonardo Baldin on 29/04/17.
 */

public class ChoicesPanel extends JPanel {
    
    private Choice choice;

    public ChoicesPanel(@NotNull JFrame rootFrame, Choice choice) {
        super();
        this.choice = choice;
    }

    private void _initText() {
        JLabel testoh = new JLabel(choice.getDomanda());
        testoh.setBackground(new Color(0, 0, 0, 175));
    }

    private void _initButtons() {
        CustomButton btn1 = new CustomButton(0, 0, choice.getScelta1());
        CustomButton btn2 = new CustomButton(0, 0, choice.getScelta2());
    }

}
