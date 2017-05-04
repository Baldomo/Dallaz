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

    private int charCounter = 0;

    private static final Color OVERLAY_COLOR = new Color(0, 0, 0, 120);

    private JTextArea testoh = new JTextArea();
    private JFrame root;
    private EmptyBorder border = null;

    private static final String FONT_FILE = "Resources/Cutrims.otf";
    private Color FONT_COLOR = Color.WHITE;
    private float fontSize = 36f;
    private Font font;

    private Image BACKGROUND_IMAGE = null;
    private String IMAGE_NAME = "/Resources/saloon.png";

    public CustomTextPanel(@NotNull JFrame rootFrame, int larghezza, int altezza, @Nullable String testo) {
        super();
        root = rootFrame;

        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

        border = new EmptyBorder(new Insets(root.getHeight()/6, root.getWidth()/7, 0, root.getWidth()/7));
        this.setBorder(border);
        this.setLayout(new BorderLayout());
        _initTesto(testo);

        setMinimumSize(new Dimension(larghezza, altezza));
    }

    private void _initTesto(String testo) {
        //testoh.setText(testo);
        _animateText(testo);
        testoh.setForeground(FONT_COLOR);

        testoh.setEditable(false);
        testoh.getCaret().deinstall(testoh);
        testoh.setLineWrap(true);
        testoh.setWrapStyleWord(true);
        testoh.setOpaque(false);
        testoh.setAlignmentX(SwingConstants.LEFT);
        add(testoh, BorderLayout.CENTER);

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(FONT_FILE));
            font = font.deriveFont(Font.PLAIN, fontSize);
            testoh.setFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void _animateText(String testo) {
        testoh.setText(null);
        Timer timer = new Timer(50, actionEvent -> {
            if (charCounter < testo.length()) {
                testoh.append(Character.toString(testo.charAt(charCounter)));
                charCounter++;
            } else {
                ((Timer) actionEvent.getSource()).stop();
            }
        });
        timer.start();
        charCounter = 0;
    }

    public void setBackgroundImage(String path) {
        IMAGE_NAME = path;
        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
            BACKGROUND_IMAGE = ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true);
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
        g.drawImage(BACKGROUND_IMAGE, 0, 0, null);
        g.setColor(OVERLAY_COLOR);
        g.fillPolygon(fill);
    }
}
