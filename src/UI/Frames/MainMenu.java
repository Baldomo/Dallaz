package UI.Frames;

import UI.Elements.CustomButton;
import Utilities.ImageResizer;
import com.sun.istack.internal.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 28/04/17.
 */

public class MainMenu extends JFrame {

    private static Image BACKGROUND_IMAGE = null;
    private static final String IMAGE_NAME = "/Resources/background.png";

    private JFrame root = new JFrame();

    public MainMenu(@Nullable String title) {
        super();

        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            root.setTitle(title);
            root.setResizable(false);
            root.setSize(1200, 720);
            root.setLocationRelativeTo(null);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            root.add(new MainPanel());
            root.setVisible(true);
        });

    }

    class MainPanel extends JPanel {

        private MainPanel() {
            super();
            _initPanel();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Polygon side = new Polygon();
            side.addPoint(0, 0);
            side.addPoint(root.getWidth() /5, 0);
            side.addPoint(root.getWidth() /7, root.getHeight());
            side.addPoint(0, root.getHeight());

            g.drawImage(ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true), 0, 0, null);
            g.setColor(new Color(0, 0, 0, 175));
            setBackground(Color.YELLOW);
            g.fillPolygon(side);
        }

        private void _initPanel() {
            JButton btn1 = new CustomButton(100, 25, "Prova 1");
            JButton btn2 = new CustomButton(100, 25, "Prova 1");
            JButton btn3 = new CustomButton(100, 25, "Prova 1");
            JButton btn4 = new CustomButton(50, 25, "Prova 1");

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);

            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addGap(root.getHeight()/10)
                            .addComponent(btn1)
                            .addComponent(btn2)
                            .addComponent(btn3)
                            .addComponent(btn4)
            );

            layout.setHorizontalGroup(
                    layout.createParallelGroup()
                            .addGap(root.getWidth()/15)
                            .addComponent(btn1)
                            .addComponent(btn2)
                            .addComponent(btn3)
                            .addComponent(btn4)

            );

        }

    }

}
