package Main;

import UI.Frames.MainFrame;
import UI.Frames.MainMenuPanel;

/**
 * Created by Leonardo Baldin on 26/04/17.
 */

public class MainClass {

    public static void main(String[] args) {

        MainFrame menu = new MainFrame("Menu");
        MainMenuPanel menuPanel = new MainMenuPanel(menu);

    }

}