package UI.Frames;

import UI.Elements.CustomButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonardo Baldin on 28/04/17.
 */

public class MainMenu extends JFrame {

    private JFrame root = new JFrame();

    public MainMenu(String title) {
        super();

        SwingUtilities.invokeLater(() -> {
            root.setTitle(title);
            root.setResizable(false);
            root.setSize(600, 350);
            root.setLocationRelativeTo(null);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            root.add(new MainPanel());
            root.setVisible(true);
        });

    }

    class MainPanel extends JPanel {

        private MainPanel() {
            super();
            setBackground(Color.YELLOW);
            _initPanel();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Polygon side = new Polygon();
            side.addPoint(0, 0);
            side.addPoint((int) root.getWidth()/5, 0);
            side.addPoint((int) root.getWidth()/7, (int) root.getHeight());
            side.addPoint(0, (int) root.getHeight());

            g.setColor(new Color(0, 0, 0, 175));
            g.fillPolygon(side);
        }

        private void _initPanel() {
            JButton btn1 = new CustomButton(100, 25, "Prova 1");
            JButton btn2 = new CustomButton(100, 25, "Prova 1");
            JButton btn3 = new CustomButton(100, 25, "Prova 1");
            JButton btn4 = new CustomButton(100, 25, "Prova 1");

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);

            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addComponent(btn1)
                            .addComponent(btn2)
                            .addComponent(btn3)
                            .addComponent(btn4)
            );

            layout.setHorizontalGroup(
                    layout.createParallelGroup()
                            .addComponent(btn1)
                            .addComponent(btn2)
                            .addComponent(btn3)
                            .addComponent(btn4)

            );
        }

    }

}
