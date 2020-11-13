
package project.oop;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class skull3 {
    public ImageIcon skull3 = new ImageIcon(this.getClass().getResource("keep.png"));
    public ImageIcon skull3walk = new ImageIcon(this.getClass().getResource("keepRun.png"));
    
    
    public int ak = 17;
    public int x = 450;
    public int y = 75;
    public boolean alive = true;
    int distanceP;
    public boolean back = false;
}
