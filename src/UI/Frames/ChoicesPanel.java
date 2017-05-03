package UI.Frames;

import UI.Elements.CustomButton;
import Utilities.StoryNode;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonardo Baldin on 29/04/17.
 */

public class ChoicesPanel extends JPanel {
    
    private StoryNode storyNode;

    public ChoicesPanel(@NotNull JFrame rootFrame, StoryNode storyNode) {
        super();
        this.storyNode = storyNode;
    }

    private void _initText() {
        JLabel testoh = new JLabel(storyNode.getDomanda());
        testoh.setBackground(new Color(0, 0, 0, 175));
    }

    private void _initButtons() {
        CustomButton btn1 = new CustomButton(0, 0, storyNode.getScelta1());
        CustomButton btn2 = new CustomButton(0, 0, storyNode.getScelta2());
    }

}
