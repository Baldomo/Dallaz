package UI.Frames;

import com.sun.istack.internal.Nullable;

import javax.swing.*;

/**
 * Created by Leonardo Baldin on 29/04/17.
 */

public class MainFrame extends JFrame {

    private JFrame root = new JFrame();

    private JPanel currentPanel = null;
    private JPanel previousPanel;

    public MainFrame(@Nullable String title) {
        super();

        SwingUtilities.invokeLater(() -> {
            root.setTitle(title);
            root.setResizable(false);
            root.setSize(1280, 720);
            root.setLocationRelativeTo(null);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            root.add(new MainMenuPanel(root));

            root.setVisible(true);
        });

    }

    public void swapPanel(JPanel newPanel) {
        previousPanel = currentPanel;
        currentPanel = newPanel;

        SwingUtilities.invokeLater(() -> {
            root.remove(previousPanel);
            root.add(currentPanel);
            root.revalidate();
            root.repaint();
        });
    }

}
