
package project.oop;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MiniBosss {
    public ImageIcon miniboss = new ImageIcon(this.getClass().getResource("Mini.png"));
    
    
    public int ak = 5;
    public int HP = 100;
    public int x = 500;
    public int y = 465;
    public boolean alive = true;
    int distanceP;
    public boolean back = false;
    
}
