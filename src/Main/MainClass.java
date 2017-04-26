package Main;

import UI.CustomButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonardo Baldin on 26/04/17.
 */

public class MainClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new CustomButton(50, 10));
        frame.add(initContainer());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JPanel initContainer() {
        JPanel root = new JPanel(new FlowLayout());
        root.setBackground(Color.YELLOW);
        return root;
    }

}