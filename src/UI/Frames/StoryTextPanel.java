package UI.Frames;

import Utilities.ImageResizer;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Polygon;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Leonardo Baldin
 */

public class StoryTextPanel extends JScrollPane {
    
    private Image BACKGROUND_IMAGE = null;
    private String IMAGE_NAME = "/Resources/storybg.png";
    
    private JFrame root = null;
    
    private JPanel textContainer = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Polygon background = new Polygon();
            background.addPoint(0, 0);
            background.addPoint(root.getWidth(), 0);
            background.addPoint(root.getWidth(), root.getHeight());
            background.addPoint(0, root.getHeight());

            setBackground(Color.YELLOW);
            g.drawImage(ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true), 0, 0, null);
            g.setColor(new Color(0, 0, 0, 175));
            g.fillPolygon(background);
            super.paintComponent(g);
        }
    };
    
    public StoryTextPanel(@NotNull JFrame rootFrame, @Nullable String testo) {
        super();
        
        root = rootFrame;
        
        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        setBackground(new Color(0, 0, 0, 175));
        _initTesto(testo);
        this.add(textContainer);
    }
    
    private void _initTesto(String testo) {
        JLabel testoh = new JLabel(testo);
        textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.PAGE_AXIS));
        textContainer.setBorder(new EmptyBorder(new Insets(root.getHeight()/5, root.getWidth()/7, root.getHeight()/5, root.getWidth()/7)));
        textContainer.setBackground(new Color(0, 0, 0, 175));
        textContainer.add(testoh);
        testoh.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    public void setBackgroundImage(String path) {
        IMAGE_NAME = path;
        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Polygon background = new Polygon();
        background.addPoint(0, 0);
        background.addPoint(root.getWidth(), 0);
        background.addPoint(root.getWidth(), root.getHeight());
        background.addPoint(0, root.getHeight());
        
        setBackground(Color.YELLOW);
        g.drawImage(ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true), 0, 0, null);
        g.setColor(new Color(0, 0, 0, 175));
        g.fillPolygon(background);
    }
    
}
