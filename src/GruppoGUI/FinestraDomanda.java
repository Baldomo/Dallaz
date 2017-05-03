/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * @author marco
 */
public class FinestraDomanda extends JPanel implements ActionListener{
    
    private int responso = 0;
    
    JTextArea domanda = new JTextArea();
    ImageIcon b1=new ImageIcon("img/bottone.png");
    CustomButton ris1 = new CustomButton(300,100,"");
    CustomButton ris2 = new CustomButton(300,100,"");
    JLabel mission = new JLabel();
    ImageIcon backWall = new ImageIcon("img/background7.jpeg");
    JLabel bcg = new JLabel(backWall);
    
    public FinestraDomanda(){
    Font stampact = null;   
       try {
    stampact = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/STAMPACT.TTF")).deriveFont(30f);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(stampact);
    } catch (IOException e) {
    e.printStackTrace();
    } catch(FontFormatException e) {
    e.printStackTrace();
    }
       Font goldenage = null;   
       try {
    goldenage = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/Golden Age Regular.ttf")).deriveFont(25f);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(goldenage);
    } catch (IOException e) {
    e.printStackTrace();
    } catch(FontFormatException e) {
    e.printStackTrace();
    }
       setLayout(new BorderLayout());
       add(bcg);
       bcg.setLayout(null);
       
       mission.setFont(stampact);
       mission.setForeground(new Color(58,32,16));
       bcg.add(mission);
       mission.setBounds(74, 10, 972, 100);
       
       domanda.setBorder(null);
       domanda.setBackground(new Color(0,0,0,100));
       domanda.setFont(goldenage);
       domanda.setForeground(new Color(241,218,194));
       bcg.add(domanda);
       domanda.setEditable(false);
       domanda.setBounds(74, 120, 972, 280);
       
       /*ris1.setIcon(b1);
       ris1.setHorizontalTextPosition(JButton.CENTER);
       ris1.setVerticalTextPosition(JButton.CENTER);
       ris1.setFont(stampact); 
       ris1.setForeground(new Color(58,32,16));*/
       bcg.add(ris1);
       ris1.setBounds(74, 450, 300, 100);
       
       
       /*ris2.setIcon(b1);
       ris2.setHorizontalTextPosition(JButton.CENTER);
       ris2.setVerticalTextPosition(JButton.CENTER);
       ris2.setFont(stampact);
       ris2.setForeground(new Color(58,32,16));*/
       bcg.add(ris2);
       ris2.setBounds(746, 450, 300, 100);
       
       ris1.addActionListener(this);
       ris2.addActionListener(this);
       
       
       
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
            domanda.setBackground(new Color(0,0,0,100));
            responso = 1;
        }
        
        if (azione.equals(risposta2)){
            domanda.setText(risposta2);
            domanda.setBackground(new Color(0,0,0,100));
            responso = 2;
        }
        
    }
    
}
