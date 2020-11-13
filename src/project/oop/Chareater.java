package project.oop;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Chareater {
    public ImageIcon robin = new ImageIcon(this.getClass().getResource("WalkswordRight.png"));
    public ImageIcon robin2 = new ImageIcon(this.getClass().getResource("WalkswordLeft.png"));
    public ImageIcon robinrunright = new ImageIcon(this.getClass().getResource("RunswordRight.png"));
    public ImageIcon robinrunleft = new ImageIcon(this.getClass().getResource("RunswordLeft.png"));
    public ImageIcon robinrunleftkill = new ImageIcon(this.getClass().getResource("manKillLeftt.png"));
    public ImageIcon robinrunRightkill = new ImageIcon(this.getClass().getResource("manKillRight.png"));
    
    
    public int ATK = 25;
    public boolean alive = true;
    public int HP = 100;
    public int swow = 65;
    public int swoh = 65;
    public int x = 0;
    public int y = 472;
    public int x3 = 0;
    public int y3 = 370;
    public int count = 0;
    public int checkfloor = 0;
    public int checkattacker = 0;
    public int distanceP =0;
    Chareater(){}
    
}
