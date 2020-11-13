package project.oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enter1 extends JPanel  {
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("Battleground4.png"));
    private ImageIcon    fire = new ImageIcon(this.getClass().getResource("Fire5.gif"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("1start.png"));
    JButton start1 = new JButton(start);
    Enter1(){
        setLayout(null);
        start1.setBounds(200, 200, 800, 300);
        start1.setBorderPainted(false);
        start1.setBorder(null);
        start1.setOpaque(false);
        start1.setContentAreaFilled(false);
        add(start1);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(fire.getImage(), 102, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 184, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 252, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 332, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 412, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 492, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 572, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 652, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 732, 210, 300, 160, this);
        g.drawImage(fire.getImage(), 788, 210, 300, 160, this);
    }
}
