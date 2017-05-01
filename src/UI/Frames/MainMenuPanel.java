package UI.Frames;

import UI.Elements.CustomButton;
import Utilities.ImageResizer;
import com.sun.istack.internal.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 28/04/17.
 */


public class MainMenuPanel extends JPanel {

    private static Image BACKGROUND_IMAGE = null;
    private static final String IMAGE_NAME = "/Resources/saloon.png";

    private JFrame root = null;
    
    public CustomButton btn1;

    public MainMenuPanel(@NotNull JFrame rootFrame) {
        super();
        this.root = rootFrame;

        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        btn1 = new CustomButton(root.getWidth()/5, root.getHeight()/8, "Gioca");
        CustomButton btn2 = new CustomButton(root.getWidth()/6, root.getHeight()/11, "Impostazioni");
        CustomButton btn3 = new CustomButton(root.getWidth()/6, root.getHeight()/11, "Crediti");
        CustomButton btn4 = new CustomButton(root.getWidth()/6, root.getHeight()/11, "Esci");

        btn2.setFontSize(26f);
        btn3.setFontSize(30f);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.linkSize(SwingConstants.HORIZONTAL, btn2, btn3, btn4);
        layout.linkSize(SwingConstants.VERTICAL, btn2, btn3, btn4);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(root.getWidth()/20)
                        .addComponent(btn2)
                        .addComponent(btn3)
                        .addComponent(btn4)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup())
                            .addComponent(btn2)
                            .addComponent(btn3)
                            .addComponent(btn4)
        );

        this.setBorder(new EmptyBorder(new Insets(root.getHeight()/18, root.getWidth()/20, 0, 0)));
    }

}
