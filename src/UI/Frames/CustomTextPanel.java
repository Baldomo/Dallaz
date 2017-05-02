package UI.Frames;

import Utilities.ImageResizer;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 02/05/17.
 */

public class CustomTextPanel extends JPanel {

    private static final Color OVERLAY_COLOR = new Color(0, 0, 0, 120);

    private JLabel testoh = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(0, 0, 0, 0));
            super.paintComponent(g);
        }
    };
    private JFrame root;

    private static final String FONT_FILE = "Resources/Cutrims.otf";
    private Color FONT_COLOR = Color.WHITE;
    private float fontSize = 36f;
    private Font font;

    private Image BACKGROUND_IMAGE = null;
    private String IMAGE_NAME = "/Resources/saloon.png";

    public CustomTextPanel(@NotNull JFrame rootFrame, int larghezza, int altezza, @Nullable String testo) {
        super();
        root = rootFrame;

        _initTesto(testo);
        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBorder(new EmptyBorder(new Insets(this.getHeight()/6, this.getWidth()/7, 0, this.getWidth()/7)));

        setMinimumSize(new Dimension(larghezza, altezza));
    }

    private void _initTesto(String testo) {
        testoh.setText(testo);
        testoh.setForeground(FONT_COLOR);
        testoh.setOpaque(false);
        add(testoh);

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
            font = font.deriveFont(Font.PLAIN, fontSize);
            testoh.setFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
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

    public void setFontSize(float newSize) {
        fontSize = newSize;
        font = font.deriveFont(fontSize);
        testoh.setFont(font);
    }

    public void setNewText(String newText) {
        testoh.setText(newText);
    }

    public void setTextColor(Color newColor) {
        FONT_COLOR = newColor;
        testoh.setForeground(newColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Polygon fill = new Polygon();
        fill.addPoint(getX(), getY());
        fill.addPoint(this.getWidth(), getY());
        fill.addPoint(this.getWidth(), this.getHeight());
        fill.addPoint(getX(), this.getHeight());

        g.drawImage(ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true), 0, 0, null);
        g.setColor(OVERLAY_COLOR);
        g.fillPolygon(fill);
    }
}