
package project.oop;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Boss {
    public ImageIcon bigboss = new ImageIcon(this.getClass().getResource("Boss.png"));
    public ImageIcon bigbossrun = new ImageIcon(this.getClass().getResource("BossRun.png"));
    
    public int ak = 10;
    public int HP = 200;
    public int x = 600;
    public int y = 363;
    public boolean alive = true;
    int distanceP;
    public boolean back = false;
}
