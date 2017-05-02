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

    private static final Color DEFAULT_COLOR = new Color(0, 0, 0, 120);

    private JLabel testoh = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(0, 0, 0, 0));
            super.paintComponent(g);
        }
    };
    private JFrame root;

    private static final String FONT_FILE = "Resources/Cutrims.otf";
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

        setFocusable(false);
        setMinimumSize(new Dimension(larghezza, altezza));
    }

    private void _initTesto(String testo) {
        testoh.setText(testo);
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

    public void setCustomText(String newText) {
        testoh.setText(newText);
    }

    public void setTextColor(Color newColor) {
        testoh.setForeground(newColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Polygon fill = new Polygon();
        fill.addPoint(this.getX(), this.getY());
        fill.addPoint(this.getX(), this.getWidth());
        fill.addPoint(this.getWidth(), this.getHeight());
        fill.addPoint(this.getHeight(), this.getY());

        g.setColor(DEFAULT_COLOR);
        g.drawImage(ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true), 0, 0, null);
        g.fillPolygon(fill);
        super.paintComponent(g);
    }
}
