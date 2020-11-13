
package project.oop;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class skull1 {
    public ImageIcon skull1 = new ImageIcon(this.getClass().getResource("keep.png"));
    public ImageIcon skull1walk = new ImageIcon(this.getClass().getResource("keepRun.png"));
    
    public int ak = 15;
    public int x = 500;
    public int y = 472;
    public boolean alive = true;
    int distanceP;
    public boolean back = false;
}
