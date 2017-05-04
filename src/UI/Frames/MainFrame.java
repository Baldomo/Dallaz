package UI.Frames;

import GruppoGUI.FinestraDomanda;
import Utilities.StoryNode;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Leonardo Baldin on 29/04/17.
 */

public class MainFrame {

    private JFrame root = new JFrame();

    private JPanel currentPanel = null;

    private MainMenuPanel menu;

    public MainFrame(@Nullable String title) {
        super();

        SwingUtilities.invokeLater(() -> {
            root.setTitle(title);
            root.setResizable(false);
            root.setSize(1280, 720);
            root.setLocationRelativeTo(null);
            root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //root.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //root.setUndecorated(true);

            try {
                menu = new MainMenuPanel(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentPanel = menu;
            root.add(currentPanel);
            CustomTextPanel prova = new CustomTextPanel(root, root.getWidth(), root.getHeight(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis lacus at mauris vehicula blandit. Cras sapien lectus, congue in sollicitudin mattis, lacinia quis ex. Nam eu justo porttitor, dapibus eros id, ornare leo. Quisque at sodales ex. Ut sollicitudin nisi vitae dolor congue laoreet. Integer elementum justo nec sapien malesuada, ut posuere neque lacinia. Cras ut mi at ligula venenatis semper. Aenean id suscipit purus, facilisis semper arcu. Nunc tincidunt lorem bibendum ipsum eleifend condimentum. Sed iaculis maximus quam, id pellentesque dui feugiat at. ");
            FinestraDomanda fd = new FinestraDomanda();

            menu.btn1.addActionListener(e -> {
                menu.stopMusic();
                //swapToChoicePanel(fd);
                swapToTextPanel(prova);
            });

            root.setVisible(true);
        });

    }

    public void swapToChoicePanel(FinestraDomanda newPanel) {
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


    public class StoryManager {

        private StoryNode currentStoryNode;

        public FinestraDomanda loadNextDomanda(StoryNode storyNode, int scelta) {
            currentStoryNode = storyNode.getNextStoryNode(scelta);
            return new FinestraDomanda(currentStoryNode);
        }

        public CustomTextPanel loadNextStory(StoryNode storyNode, int scelta) {
            return new CustomTextPanel(root, root.getWidth(), root.getHeight(), currentStoryNode.getNextStoryText(scelta));
        }

        public StoryNode getCurrentStoryNode() {
            return currentStoryNode;
        }

    }
}
