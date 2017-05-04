package UI.Frames;

import UI.Elements.CustomButton;
import Utilities.ImageResizer;
import com.sun.istack.internal.NotNull;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 28/04/17.
 */


public class MainMenuPanel extends JPanel {

    private static Image BACKGROUND_IMAGE = null;
    private static final String IMAGE_NAME = "/Resources/background.jpg";

    private JFrame root = null;

    private Clip mainMenuMusic;
    
    public CustomButton btn1;

    private Polygon side = new Polygon();

    public MainMenuPanel(@NotNull JFrame rootFrame) throws IOException {
        super();
        this.root = rootFrame;

        setOpaque(false);
        side.addPoint(0, 0);
        side.addPoint(root.getWidth() /5, 0);
        side.addPoint(root.getWidth() /7, root.getHeight());
        side.addPoint(0, root.getHeight());

        try {
            BACKGROUND_IMAGE = ImageIO.read(getClass().getResource(IMAGE_NAME));
            BACKGROUND_IMAGE = ImageResizer.resizeImage(BACKGROUND_IMAGE, root.getWidth(), root.getHeight(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        _initPanel();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(BACKGROUND_IMAGE, 0, 0, null);
        g.setColor(new Color(0, 0, 0, 175));
        g.fillPolygon(side);
        super.paint(g);
    }

    private void _initPanel() throws IOException {
        btn1 = new CustomButton(root.getWidth()/5, root.getHeight()/8, "Gioca");
        CustomButton btn2 = new CustomButton(root.getWidth()/6, root.getHeight()/11, "Impostazioni");
        CustomButton btn3 = new CustomButton(root.getWidth()/6, root.getHeight()/11, "Crediti");
        CustomButton btn4 = new CustomButton(root.getWidth()/6, root.getHeight()/11, "Esci");

        musicStart();

        btn2.setFontSize(26f);

        btn3.setFontSize(30f);

        btn4.addActionListener(e -> System.exit(0));

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

    public void musicStart() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Resources/mainMenuSong.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(6);
            mainMenuMusic = clip;
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
        }
    }

    public void stopMusic(){
        mainMenuMusic.stop();
    }
}
