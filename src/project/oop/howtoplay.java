
package project.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class howtoplay extends JPanel{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("howtoplay.png"));
    private ImageIcon start2 = new ImageIcon(this.getClass().getResource("strat2.png"));
    
    JButton start = new JButton(start2);
    
    howtoplay(){
        setLayout(null);
        start.setBounds(900, 500, 200, 80);
        start.setBorderPainted(false);
        start.setBorder(null);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        add(start);
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        
    }
    
    
}
