package project.oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
public class Map1 extends JPanel implements ActionListener {
    
    Chareater ro = new Chareater();
    skull1 sku = new skull1();
    skull2 scim = new skull2();
    skull3 skill = new skull3();
    
    
    
    boolean timestart = true;
    int checkbackorfront = 0;
    public int checkattacker = 0;
    public int checkenemysonw = 0;
    
    
    private Timer timer = new Timer(1000, new Listener());
    
    
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("Map1_V_final.png"));
    private ImageIcon lose = new ImageIcon(this.getClass().getResource("Lose.png"));
    private ImageIcon doro = new ImageIcon(this.getClass().getResource("doro.png"));
    private ImageIcon doorrr = new ImageIcon(this.getClass().getResource("door.png"));
    private ImageIcon swordRight = new ImageIcon(this.getClass().getResource("swordright.png"));
    private ImageIcon wal = new ImageIcon(this.getClass().getResource("background.png"));
    private ImageIcon next1 = new ImageIcon(this.getClass().getResource("Next level.png"));
    
    JButton level1 = new JButton(next1);
    
    
    public int timeee = 120 ;
    private Timer timee = new Timer(1000, new Listener());
    
    
    public int keyx = 40;
    
    public boolean checkgameover = false;
    
    boolean checknextlevel = false;
   
    
    public int alive;
    public int checknearskull = 0;
    int checkbacktofront = 0;
    public int score = 0;
    
    
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{                          
 
                    if(ro.x == 1010 && ro.checkfloor == 0 && sku.alive == false && scim.alive == false && skill.alive == false){
                        checknextlevel = true;
                    }
                    //sku
                    if(sku.alive == true){
                        if(sku.back == false){
                            if(sku.x<=0) sku.x=1000;
                            else sku.x= sku.x-5;
                        }
                        else{
                            if(sku.x<=0) sku.x=1000;
                            else sku.x= sku.x+5;
                        }
                        sku.distanceP = (int)Math.sqrt((Math.pow(Math.abs(sku.x-ro.x),2))+(Math.pow(Math.abs(sku.y-ro.y),2)));
                        
                        if(ro.checkfloor == 0){
                           if(sku.distanceP <= 80){
                                checkenemysonw = 1;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(sku.distanceP <= 60){
                                sku.x = ro.x+100;
                                ro.HP -= sku.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(sku.distanceP <= 60){
                                sku.x = ro.x-100;
                                ro.HP -= sku.ak;
                            }
                        }


                        if(sku.x <= 500){
                            sku.back = true;
                        }
                        else if(sku.x >= 750){
                            sku.back = false;
                        }      
                    }
                    //scim
                    if(scim.alive == true){
                        if(scim.back == false){
                            if(scim.x<=0) scim.x=1000;
                            else scim.x= scim.x-5;
                        }
                        else{
                            if(scim.x<=0) scim.x=1000;
                            else scim.x= scim.x+5;
                        }
                        scim.distanceP = (int)Math.sqrt((Math.pow(Math.abs(scim.x-ro.x),2))+(Math.pow(Math.abs(scim.y-ro.y),2)));
                        
                        if(ro.checkfloor == 1){
                           if(scim.distanceP <= 80){
                                checkenemysonw = 2;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(scim.distanceP <= 60){
                                scim.x = ro.x+100;
                                ro.HP -= scim.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(scim.distanceP <= 60){
                                scim.x = ro.x-100;
                                ro.HP -= scim.ak;
                            }
                        }


                        if(scim.x <= 700){
                            scim.back = true;
                        }
                        else if(scim.x >= 900){
                            scim.back = false;
                        }      
                    } 
                    //skill
                    if(skill.alive == true){
                        if(skill.back == false){
                            if(skill.x<=0) skill.x=1000;
                            else skill.x= skill.x-5;
                        }
                        else{
                            if(skill.x<=0) skill.x=1000;
                            else skill.x= skill.x+5;
                        }
                        skill.distanceP = (int)Math.sqrt((Math.pow(Math.abs(skill.x-ro.x),2))+(Math.pow(Math.abs(skill.y-ro.y),2)));
                        
                        if(ro.checkfloor == 2){
                           if(skill.distanceP <= 80){
                                checkenemysonw = 3;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(skill.distanceP <= 60){
                                skill.x = ro.x+100;
                                ro.HP -= skill.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(skill.distanceP <= 60){
                                skill.x = ro.x-100;
                                ro.HP -= skill.ak;
                            }
                        }


                        if(skill.x <= 400){
                            skill.back = true;
                        }
                        else if(skill.x >= 600){
                            skill.back = false;
                        }      
                    }
                    
                    Thread.sleep(60);
                    
                }catch(Exception e){
                 
                }
                
                if(timestart == true){
                    repaint();
                }
            }
        }
    });
    
    Map1(){
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a == KeyEvent.VK_F9){
                    checknextlevel = true;
                    score = 90;
                }
                if(a == KeyEvent.VK_F10){
                    sku.alive = false;
                    scim.alive = false;
                    skill.alive = false;
                }
                if(a == KeyEvent.VK_RIGHT){
                    checkbackorfront = 0;
                    if(checknextlevel == false){
                        if(checkbackorfront == 0){
                            if(ro.x >= 1050){
                                ro.x = 1050;
                            }
                            else{
                                if(ro.checkfloor == 2){
                                    if(ro.x >= 870){
                                        ro.x = 870;
                                    }
                                }
                                else if(ro.checkfloor == 1){
                                    if(ro.x >= 220 && ro.x <= 520){
                                        ro.x = 220;
                                    }
                                }
                                ro.x+=10;
                                ro.count++;

                                if(ro.count >= 2){
                                    ro.count = 0;
                                }
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_LEFT){
                    checkbackorfront = 1;
                    if(checknextlevel == false){
                        if(checkbackorfront == 1){
                            if(ro.x <= 0){
                                ro.x = 0;
                            }

                            else{                                    
                                if(ro.checkfloor == 2){
                                    if(ro.x <= 150){
                                        ro.x = 150;
                                    }
                                }

                                if(ro.checkfloor == 1){
                                    if(ro.x >= 250 && ro.x <= 550){
                                        ro.x = 550;
                                    }
                                }
                                ro.x-=10;
                                ro.count++;

                                if(ro.count >= 2){
                                    ro.count = 0;
                                }
                            }
                        }
                    }
                }
                if(a == KeyEvent.VK_UP){
                    //bandai 1
                    if(ro.x >=570 && ro.x <= 600){
                        checkbackorfront = 2;
                        if(ro.checkfloor == 0){
                            ro.checkfloor = 1;
                        }
                        if(checkbackorfront == 2){
                            if(ro.y <= 275){
                                ro.checkfloor = 1 ;
                                ro.y = 275;
                            }    
                            else{
                                ro.y -= 10;
                                ro.count++;

                                if(ro.count >= 2){
                                    ro.count = 0;
                                }
                            }   
                        }  
                    }  
                    //bandai 2
                    else if((ro.x >= 860 && ro.x <= 900) && ro.y <= 355){
                        if(ro.checkfloor == 1){
                            checkbackorfront = 2;
                            ro.checkfloor = 2;
                        }
                        if(checkbackorfront == 2){
                            if(ro.y <= 75){
                                ro.y = 75;
                            }    
                            else{
                                ro.y -= 10;
                                ro.count++;

                                if(ro.count >= 2){
                                    ro.count = 0;
                                }
                            }   
                        }  
                    }
                    //bandai 3
                    else if((ro.x >= 165 && ro.x <= 185) && ro.y <= 355){
                        if(ro.checkfloor == 1){
                            checkbackorfront = 2;
                            ro.checkfloor = 2;
                        }
                        if(checkbackorfront == 2){
                            if(ro.y <= 75){
                                ro.y = 75;
                            }    
                            else{
                                ro.y -= 10;
                                ro.count++;

                                if(ro.count >= 2){
                                    ro.count = 0;
                                }
                            }   
                        }  
                    }
                    
                }
                if(a == KeyEvent.VK_DOWN){
                    //bandai 1
                    if(ro.x >=569 && ro.x <= 590){
                       checkbackorfront = 2;
                        if(ro.checkfloor == 1){
                           ro.checkfloor = 0;
                        }
                        if(checkbackorfront == 2){
                            if(ro.y >= 472)
                                ro.y = 472;
                            else{
                                ro.y += 10;
                                ro.count++;
                            
                                if(ro.count >= 2){
                                    ro.count = 0;
                                }    
                            }
                        } 
                    }
                    //bandai 2
                    else if((ro.x >= 860 && ro.x <= 900) && ro.y <= 355){
                        checkbackorfront = 2;
                        if(ro.checkfloor == 2){
                           ro.checkfloor = 1;
                        }
                        if(checkbackorfront == 2){
                            if(ro.y >= 275)
                                ro.y = 275;
                            else
                                ro.y += 10;
                                ro.count++;
                            
                                if(ro.count >= 2){
                                    ro.count = 0;
                            }
                        } 
                    }
                    //bandai 3
                    else if((ro.x >= 165 && ro.x <= 185) && ro.y <= 355){
                        checkbackorfront = 2;
                        if(ro.checkfloor == 2){
                           ro.checkfloor = 1;
                        }
                        if(checkbackorfront == 2){
                            if(ro.y >= 275)
                                ro.y = 275;
                            else
                                ro.y += 10;
                                ro.count++;
                            
                                if(ro.count >= 2){
                                    ro.count = 0;
                            }
                        } 
                    }
                }  
                else if(a == KeyEvent.VK_K){
                    if(checkattacker == 0){
                        checkattacker = 1;
                    }
                }
            }
            
            public void keyReleased(KeyEvent e){
                ro.count=0;
            }
        });
        timer.start();
        time.start();
        timee.start();
    }
    
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timee){
                timeee--;
            }
            repaint();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
  
        g.drawImage(doro.getImage(), 610, 390, 70, 200, this);  // bandai 1
        g.drawImage(doro.getImage(), 900, 190, 70, 200, this);  // bandai 2
        g.drawImage(doro.getImage(), 210, 193, 70, 200, this);  // bandai 3
        g.drawImage(doorrr.getImage(), 1050, 490, 60, 100, this);
        
        
        g.setColor(Color.RED);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        g.drawString("Score: "+score, 350, 50);
        g.drawString("Time: "+ timeee, 200, 50); 
        //Attack
        if(sku.alive == true){
            if(checkattacker == 1 && checkenemysonw == 1) {//skull
                score += 30;
                sku.alive = false;
                checkattacker = 0;
                checkenemysonw = 0;
            }
        }
        if(scim.alive == true){
            if(checkattacker == 1 && checkenemysonw == 2) {//skull
                score += 30;
                scim.alive = false;
                checkattacker = 0;
                checkenemysonw = 0;
            }
        }
        if(skill.alive == true){
            if(checkattacker == 1 && checkenemysonw == 3) {//skull
                score += 30;
                skill.alive = false;
                checkattacker = 0;
                checkenemysonw = 0;
            }
        }
        
        if(ro.alive = true){
            g.drawString("HP: "+ro.HP, ro.x+50, ro.y+10);
        }
        if(ro.alive == true){  
            g.drawString("HP: "+ro.HP, ro.x+50, ro.y+10);
            if(checkbackorfront == 0){
                if(checkattacker == 0){
                    if(ro.count == 0){
                        g.drawImage(ro.robin.getImage(), ro.x, ro.y, 140, 120, this);
                    }
                    else{
                        g.drawImage(ro.robinrunright.getImage(), ro.x, ro.y, 140, 120, this);
                    }
                }
                else if(checkattacker == 1){
                    g.drawImage(ro.robinrunRightkill.getImage(), ro.x, ro.y, 140, 120, this);
                    checkattacker = 0;
                }
            }
            else if(checkbackorfront == 1){
                if(checkattacker == 0){
                    if(ro.count != 1){
                        g.drawImage(ro.robin2.getImage(), ro.x, ro.y, 140, 120, this);
                    }
                    else{
                        g.drawImage(ro.robinrunleft.getImage(), ro.x, ro.y, 140, 120, this);
                    }
                }
                else if(checkattacker == 1){
                    g.drawImage(ro.robinrunleftkill.getImage(), ro.x, ro.y, 140, 120, this);
                    checkattacker = 0;
                }

            }
            else if(checkbackorfront == 2){
                if(ro.count != 1){
                    g.drawImage(ro.robin.getImage(), ro.x, ro.y, 140, 120, this);
                }
                else{
                    g.drawImage(ro.robinrunright.getImage(), ro.x, ro.y, 140, 120, this);
                }           
            }  
        }
        ro.alive = false;
        
        //skull
        if(checkgameover == false){
            if(sku.alive == true)
            {
                if(sku.back == true){
                    g.drawImage(sku.skull1.getImage(), sku.x, sku.y, 135, 135, this); 
                }
                else{
                   g.drawImage(sku.skull1.getImage(), sku.x, sku.y, 135, 135, this); 
                }
            }
            //scim
            if(scim.alive == true)
            {
                if(scim.back == true){
                    g.drawImage(scim.skull2.getImage(), scim.x, scim.y, 135, 135, this); 
                }
                else{
                   g.drawImage(scim.skull2.getImage(), scim.x, scim.y, 135, 135, this); 
                }
            }
            //skill
            if(skill.alive == true)
            {
                if(skill.back == true){
                    g.drawImage(skill.skull3.getImage(), skill.x, skill.y, 135, 135, this); 
                }
                else{
                   g.drawImage(skill.skull3.getImage(), skill.x, skill.y, 135, 135, this); 
                }
            }
        }
         
        
        if(ro.HP <= 0){
            checkgameover = true;
            g.drawImage(lose.getImage(), 0, 0, 1200, 665, this);
        }
        
        if(checknextlevel == true){
            if(ro.x >= 1010){
                g.drawImage(wal.getImage(), 0, 0, 1200, 665, this);

                this.setLayout(null);
                level1.setBounds(200, 200, 800, 300);
                level1.setBorderPainted(false);
                level1.setBorder(null);
                level1.setOpaque(false);
                level1.setContentAreaFilled(false);
                add(level1);

                time.stop();
                
            }
        }
    }
    
}
