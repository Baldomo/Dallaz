/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GruppoGUI;

import UI.Elements.CustomButton;
import Utilities.StoryNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author marco
 */
public class FinestraDomanda extends JPanel implements ActionListener {

    private int responso = 0;

    private JTextArea domanda = new JTextArea();
    private CustomButton ris1 = new CustomButton(300, 100, "");
    private CustomButton ris2 = new CustomButton(300, 100, "");
    private JLabel mission = new JLabel();
    private ImageIcon backgroundImage = new ImageIcon("img/background7.jpeg");
    private JLabel background = new JLabel(backgroundImage);

    private Font stampact = null;
    private Font goldenage = null;


    public FinestraDomanda() {
        _initFont();
        setLayout(new BorderLayout());
        add(background);
        background.setLayout(null);

        mission.setFont(stampact);
        mission.setForeground(new Color(58, 32, 16));
        background.add(mission);
        mission.setBounds(74, 10, 972, 100);

        domanda.setBorder(null);
        domanda.setBackground(new Color(0, 0, 0, 100));
        domanda.setFont(goldenage);
        domanda.setForeground(new Color(241, 218, 194));
        background.add(domanda);
        domanda.setEditable(false);
        domanda.setBounds(74, 120, 972, 280);

        /*ris1.setIcon(b1);
        ris1.setHorizontalTextPosition(JButton.CENTER);
        ris1.setVerticalTextPosition(JButton.CENTER);
        ris1.setFont(stampact);
        ris1.setForeground(new Color(58,32,16));*/
        background.add(ris1);
        ris1.setBounds(74, 450, 300, 100);


        /*ris2.setIcon(b1);
        ris2.setHorizontalTextPosition(JButton.CENTER);
        ris2.setVerticalTextPosition(JButton.CENTER);
        ris2.setFont(stampact);
        ris2.setForeground(new Color(58,32,16));*/
        background.add(ris2);
        ris2.setBounds(746, 450, 300, 100);

        ris1.addActionListener(this);
        ris2.addActionListener(this);
    }

    public FinestraDomanda(StoryNode storyNode) {
        this();
        domanda.setText(storyNode.getDomanda());
        ris1.setText(storyNode.getScelta1());
        ris2.setText(storyNode.getScelta2());
    }

    private void _initFont() {
        try {
            stampact = Font.createFont(Font.TRUETYPE_FONT, new File("src/Resources/STAMPACT.TTF")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(stampact);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        try {
            goldenage = Font.createFont(Font.TRUETYPE_FONT, new File("src/Resources/Golden Age Regular.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(goldenage);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public int getResponso() {
        return responso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        String risposta1 = ris1.getText();
        String risposta2 = ris2.getText();

        if (azione.equals(risposta1)) {
            domanda.setText(risposta1);
            domanda.setBackground(new Color(0, 0, 0, 100));
            responso = 1;
        }

        if (azione.equals(risposta2)) {
            domanda.setText(risposta2);
            domanda.setBackground(new Color(0, 0, 0, 100));
            responso = 2;
        }

    }
}
