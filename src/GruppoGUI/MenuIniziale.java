/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GruppoGUI;

import UI.Elements.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author marco
 */
public class MenuIniziale extends JPanel implements ActionListener{
   
    ImageIcon backWall = new ImageIcon("img/far2.jpeg");
    ImageIcon logo = new ImageIcon("img/logo Dalla small.png");
    ImageIcon start = new ImageIcon("img/Bottone Gioca.png");
     ImageIcon video = new ImageIcon("img/videofarwest.gif");
    /*JLabel title1 = new JLabel("CHOOSE Y");
    JLabel title2 = new JLabel("UR WAY");*/
    ImageIcon title = new ImageIcon("img/titolo sml.png");
    JLabel titlep= new JLabel(title);
    CustomButton startButton = new CustomButton(134,41,"Gioca");
    JLabel background = new JLabel(backWall);
    JLabel background2 = new JLabel(video);
    JLabel logop = new JLabel(logo);
    
public MenuIniziale(){
    
    setLayout(new BorderLayout());
    add(background);
    background.setLayout(null);
    
    /*title1.setFont(title1.getFont().deriveFont(Font.BOLD, 85));
    title2.setFont(title2.getFont().deriveFont(Font.BOLD, 85));
    background.add(title1);
    title1.setBounds(74,88, 448, 65);
    background.add(logop);
    logop.setBounds(524,20, 128, 190);
    background.add(title2);
    title2.setBounds(653,88, 400, 65);*/
    background.add(titlep);
    titlep.setBounds(74, 88, 855, 197);
    background.add(startButton);
    startButton.setBounds(485,541, 150, 50);
    setVisible(true);
    startButton.addActionListener(this);
    
    
    
}

public void SecondMenu(){
    
    setLayout(new BorderLayout());
    add(background2);
    background2.setLayout(null);
    
    /*title1.setFont(title1.getFont().deriveFont(Font.BOLD, 85));
    title2.setFont(title2.getFont().deriveFont(Font.BOLD, 85));
    background2.add(title1);
    title1.setBounds(74,88, 448, 65);
    background2.add(logop);
    logop.setBounds(524,20, 128, 190);
    background2.add(title2);
    title2.setBounds(653,88, 400, 65);*/
    background.add(titlep);
    titlep.setLocation(74, 88);
    background2.add(startButton);
    startButton.setBounds(493,550, 134, 54);
    
    startButton.addActionListener(this);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        String pulsante1 = e.getActionCommand();
        background.setVisible(false);
        SecondMenu();
    
        
         
    }
    
    
}
