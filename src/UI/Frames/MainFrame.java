package UI.Frames;

import com.sun.istack.internal.Nullable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by Leonardo Baldin on 29/04/17.
 */

public class MainFrame extends JFrame {

    private JFrame root = new JFrame();

    private JPanel currentPanel = null;
    private JPanel previousPanel;
    
    private MainMenuPanel menu;

    public MainFrame(@Nullable String title) {
        super();

        SwingUtilities.invokeLater(() -> {
            root.setTitle(title);
            root.setResizable(false);
            root.setSize(1280, 720);
            root.setLocationRelativeTo(null);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            menu = new MainMenuPanel(root);
            //root.add(menu);
            StoryTextPanel prova = new StoryTextPanel(root, "Prooooooova");
            root.add(prova);

            root.setVisible(true);
        });
        
        

    }

    public void swapPanel(Object newPanel) {

        SwingUtilities.invokeLater(() -> {
            root.remove(currentPanel);
            root.add((JPanel) newPanel);
            root.revalidate();
            root.repaint();
        });
    }

}
