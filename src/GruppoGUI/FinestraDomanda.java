/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GruppoGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marco
 */
public class FinestraDomanda extends JFrame implements ActionListener{
    
    private int responso = 0;
    
    JTextArea domanda = new JTextArea();
    ImageIcon b1=new ImageIcon("img/bottone.png");
    JButton ris1 = new JButton();
    JButton ris2 = new JButton();
    JLabel mission = new JLabel();
    ImageIcon backWall = new ImageIcon("img/background7.jpeg");
    JLabel bcg = new JLabel(backWall);
    
    public FinestraDomanda(){
        
       setLayout(new BorderLayout());
       add(bcg);
       bcg.setLayout(null);
       
       mission.setFont(new Font ("Stamp Act",Font.BOLD,30));
       mission.setForeground(new Color(58,32,16));
       bcg.add(mission);
       mission.setBounds(74, 10, 972, 100);
       
       domanda.setBorder(null);
       domanda.setBackground(new Color(255,255,255,100));
       domanda.setFont(new Font("American Typewriter",Font.PLAIN,20));
       bcg.add(domanda);
       domanda.setEditable(false);
       domanda.setBounds(74, 120, 972, 280);
       
       ris1.setIcon(b1);
       ris1.setHorizontalTextPosition(JButton.CENTER);
       ris1.setVerticalTextPosition(JButton.CENTER);
       ris1.setFont(new Font("Stamp Act",Font.BOLD,60)); 
       ris1.setForeground(new Color(58,32,16));
       bcg.add(ris1);
       ris1.setBounds(74, 450, 449, 150);
       
       ris2.setIcon(b1);
       ris2.setHorizontalTextPosition(JButton.CENTER);
       ris2.setVerticalTextPosition(JButton.CENTER);
       ris2.setFont(new Font("Stamp Act",Font.PLAIN,60));
       ris2.setForeground(new Color(58,32,16));
       bcg.add(ris2);
       ris2.setBounds(597, 450, 449, 150);
       
       ris1.addActionListener(this);
       ris2.addActionListener(this);
       
       setSize(1120, 700);
       setLocation(600,200);
       setResizable(false);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
    public void setParameters(String name, String doma, String risp1, String risp2){
        mission.setText(name);
        domanda.append(doma);
        ris1.setText(risp1);
        ris2.setText(risp2); 
        responso = 0;
    }
    
    public int getResponso(){
        return responso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        String risposta1 = ris1.getText();
        String risposta2 = ris2.getText();
        
        if (azione.equals(risposta1)){
            domanda.setText(risposta1);
            responso = 1;
        }
        
        if (azione.equals(risposta2)){
            domanda.setText(risposta2);
            responso = 2;
        }
        
    }
    
}
