package UI.Frames;

import UI.Elements.CustomButton;
import Utilities.ImageResizer;
import Utilities.StoryNode;
import com.sun.istack.internal.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 29/04/17.
 */

public class ChoicesPanel extends JPanel {
    
    private StoryNode storyNode;

    private JFrame root;

    public CustomButton btn1;
    public CustomButton btn2;

    private static final String FONT_FILE = "Resources/Cutrims.otf";
    private Color FONT_COLOR = Color.WHITE;
    private float fontSize = 36f;
    private Font font;

    private Image BACKGROUND_IMAGE = null;
    private String IMAGE_NAME = "/Resources/saloon.png";

    public ChoicesPanel(@NotNull JFrame rootFrame, StoryNode storyNode) {
        super();
        this.storyNode = storyNode;
        root = rootFrame;

        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
            BACKGROUND_IMAGE = ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void _initText() {
        JLabel testoh = new JLabel(storyNode.getDomanda());
        testoh.setBackground(new Color(0, 0, 0, 175));
    }

    private void _initButtons() {
        btn1 = new CustomButton(0, 0, storyNode.getScelta1());
        btn2 = new CustomButton(0, 0, storyNode.getScelta2());
    }

    private void _initPanel() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.linkSize(SwingConstants.HORIZONTAL, btn1, btn2);
        layout.linkSize(SwingConstants.VERTICAL, btn1, btn2);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(BACKGROUND_IMAGE, 0, 0, null);
    }

}
