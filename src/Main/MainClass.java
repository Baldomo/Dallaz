package Main;

import UI.CustomButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonardo Baldin on 26/04/17.
 */

public class MainClass {

    public static void main(String[] args) {

        JButton btnProva = new CustomButton(200, 50, "Prova");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test");
            frame.setResizable(false);
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setBackground(Color.YELLOW);

            frame.add(btnProva);

            //frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}