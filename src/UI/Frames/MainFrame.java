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
    
    private MainMenuPanel menu;

    public MainFrame(@Nullable String title) {
        super();

        SwingUtilities.invokeLater(() -> {
            root.setTitle(title);
            root.setResizable(false);
            root.setSize(1280, 720);
            root.setLocationRelativeTo(null);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            root.setExtendedState(JFrame.MAXIMIZED_BOTH);
            root.setUndecorated(true);

            menu = new MainMenuPanel(root);
            currentPanel = menu;
            root.add(currentPanel);
            CustomTextPanel prova = new CustomTextPanel(root, root.getWidth(), root.getHeight(), "Provaaaaa");

            menu.btn1.addActionListener(e -> {
                swapToTextPanel(prova);
            });

            root.setVisible(true);
        });
        
        

    }

    public void swapToChoicePanel(ChoicesPanel newPanel) {
        SwingUtilities.invokeLater(() -> {
            root.getContentPane().removeAll();
            root.getContentPane().invalidate();
            root.getContentPane().add(newPanel);
            root.getContentPane().revalidate();
        });
    }

    private void swapToTextPanel(CustomTextPanel newPanel) {
        SwingUtilities.invokeLater(() -> {
            root.getContentPane().removeAll();
            root.getContentPane().invalidate();
            root.getContentPane().add(newPanel);
            root.getContentPane().revalidate();
        });
    }

}
