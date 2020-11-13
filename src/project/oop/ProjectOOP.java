package project.oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class ProjectOOP extends JFrame implements ActionListener {
    Enter1 t = new Enter1();  
    howtoplay play = new howtoplay();
    Map1 m = new Map1();
    Map2 Map2 = new Map2();
    Map3 Map3 = new Map3();
    
    public ProjectOOP(){
        this.setSize(1024,700);
        this.add(t);
        t.requestFocusInWindow();
        t.start1.addActionListener(this);
        play.start.addActionListener(this);
        m.level1.addActionListener(this);
        Map2.level2.addActionListener(this);
        
    }
    
    
    
    public static void main(String[] args) {
        JFrame gui = new ProjectOOP();
        gui.setSize(1200,700);
        gui.setVisible(true);
        gui.setTitle("The Adventures of Robin");
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == t.start1){
            this.setLocationRelativeTo(null);
            this.remove(t);
            this.setSize(1200,700);
            this.setTitle("How to play");
            this.add(play);
            play.requestFocusInWindow();
        }
        else if(e.getSource() == play.start){
            this.setLocationRelativeTo(null);
            this.remove(play);
            this.setSize(1200,700);
            this.setTitle("The Adventures of Robin Map 1");
            this.add(m);
            m.timeee = 120;
            m.requestFocusInWindow();
        }
        else if(e.getSource() == m.level1){
            this.setLocationRelativeTo(null);
            this.remove(m);
            this.setSize(1200,700);
            this.setTitle("The Adventures of Robin Map 2");
            add(Map2);
            Map2.score = m.score;
            Map2.poppe = 120;
            Map2.requestFocusInWindow();
  
        }
        else if(e.getSource() == Map2.level2){
            this.setLocationRelativeTo(null);
            this.remove(Map2);
            this.setSize(1200,700);
            this.setTitle("The Adventures of Robin Map 3");
            add(Map3);
            Map3.score = Map2.score;
            Map3.team = 120;
            Map3.requestFocusInWindow();
  
        }
        

        this.validate();
        this.repaint();
    }
    
}
