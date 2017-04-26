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
        frame.add(new CustomButton(200, 60, "Prova"));
        frame.add(initContainer());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JPanel initContainer() {
        //SpringLayout layout = new SpringLayout();

        JPanel root = new JPanel();
        root.setBackground(Color.YELLOW);
        return root;
    }

}