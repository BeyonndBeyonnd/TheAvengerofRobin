
package project.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

public class Map3 extends JPanel implements ActionListener{
    
    private Timer timer = new Timer(1000, new Map3.Listener());
    
    private ImageIcon wallpaper3 = new ImageIcon(this.getClass().getResource("Map3.png"));
    private ImageIcon winner = new ImageIcon(this.getClass().getResource("winner.png"));
    private ImageIcon fire1 = new ImageIcon(this.getClass().getResource("Fire1.gif"));
    private ImageIcon fire2 = new ImageIcon(this.getClass().getResource("giphy.gif"));
    private ImageIcon lose = new ImageIcon(this.getClass().getResource("Lose.png"));
    
    
    public int team = 120;
    public int checkbackorfront = 0;
    public int checkattacker = 0;
    public int alive;
    public boolean timestart = false;
    public int checkenemysonw = 0;
    public int score =0;
    public boolean checknextlevel = false;
    int checkbacktofront = 0;
    public boolean startbomp = false;
    public boolean checkgameover = false;

    Chareater ro = new Chareater();
    Boss boss = new Boss();
    Princess pin = new Princess();
    public ArrayList<bomp1> bompp1 = new ArrayList<bomp1>();
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    if(boss.alive == true){
                        if(boss.back == false){
                            if(boss.x<=0) boss.x=1000;
                            else boss.x= boss.x-5;
                        }
                        else{
                            if(boss.x<=0) boss.x=1000;
                            else boss.x= boss.x+5;
                        }
                        boss.distanceP = (int)Math.sqrt((Math.pow(Math.abs(boss.x-ro.x3),2))+(Math.pow(Math.abs(boss.y-ro.y3),2)));
                        
                        if(ro.checkfloor == 0){
                           if(boss.distanceP <= 80){
                                checkenemysonw = 1;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(boss.distanceP <= 60){
                                boss.x = ro.x3+200;
                                ro.HP -= boss.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(boss.distanceP <= 60){
                                //boss.x = ro.x3-200;
                                ro.HP -= boss.ak;
                            }
                        }


                        if(boss.x <= 600){
                            boss.back = true;
                        }
                        else if(boss.x >= 800){
                            boss.back = false;
                        }      
                    }
                    
                    if(ro.x3 == 1000 && boss.alive == false){
                        checknextlevel = true;
                    }
                    Thread.sleep(50);
                }
                catch(Exception e){
                 
                }
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    Thread timebomp1 = new Thread(new Runnable(){
         public void run() {
             while(true){
                     try{
                         if(startbomp == false){
                             Thread.sleep((long)(Math.random()*2000)+1000);
                         }
                     }catch(InterruptedException e){
                         e.printStackTrace();
                     }
                     if(startbomp == false){
                         bompp1.add(new bomp1());
                     }
             }
         }
     });
    
    
    Map3(){
        this.setFocusable(true);
        this.setLayout(null);
       this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a == KeyEvent.VK_RIGHT){
                    checkbackorfront = 0;
                    if(checknextlevel == false){
                        if(checkbackorfront == 0){
                            if(ro.x3 >= 1050){
                                ro.x3 = 1050;
                            }
                            else{
                                ro.x3+=10;
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
                            if(ro.x3 <= 0){
                                ro.x3 = 0;
                            }
                            else{
                                ro.x3-=10;
                                ro.count++;

                                if(ro.count >= 2){
                                    ro.count = 0;
                                }
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_B){
                    checknextlevel = true;
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
       time.start();
       timer.start();
       timebomp1.start();
        
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timer){
                team--;
            }
            repaint();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper3.getImage(), 0, 0, 1200, 665, this);  
        g.drawImage(fire1.getImage(), -50, 505, 160, 160, this);  
        g.drawImage(fire1.getImage(), 500, 240, 120, 120, this);
        g.drawImage(fire1.getImage(), 20, 220, 100, 100, this);
        g.drawImage(fire1.getImage(), 85, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 130, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 310, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 445, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 670, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 715, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 895, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 940, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 985, 505, 160, 160, this);
        g.drawImage(fire1.getImage(), 1075, 505, 160, 160, this);
        
        
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        g.drawString("Score: "+score, 350, 50);
        g.drawString("Time: "+team, 200, 50);
        g.drawImage(pin.prins.getImage(), pin.x, pin.y, 130, 130, this);
        
        //ballFire3
        for(int i=0 ; i<bompp1.size();i++){
            g.drawImage( bompp1.get(i).getImage() ,bompp1.get(i).getX(),bompp1.get(i).getY(),90,90,this);
            ro.distanceP = (int)Math.sqrt((Math.pow(Math.abs(ro.x3-bompp1.get(i).getX()),2))+(Math.pow(Math.abs(ro.y3-bompp1.get(i).getY()),2)));
            
            if(ro.distanceP <= 50){
                bompp1.remove(i);
                ro.HP -= 10;
            }
        }
        g.setColor(Color.green);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        
        if(boss.alive == true){
            g.drawString("HP: "+boss.HP, boss.x+15, boss.y+8);
            g.drawImage(boss.bigboss.getImage(), boss.x, boss.y, 140, 140, this);
        }
        //Attack
        if(boss.alive == true){
            if(checkattacker == 1 && checkenemysonw == 1) {
                boss.HP -= ro.ATK;
                checkattacker = 0;
            }
        }
        if(ro.alive == true){  
            g.drawString("HP: "+ro.HP, ro.x3+50, ro.y3+10);
            if(checkbackorfront == 0){
                if(checkattacker == 0){
                    if(ro.count == 0){
                        g.drawImage(ro.robin.getImage(), ro.x3, ro.y3, 140, 120, this);
                    }
                    else{
                        g.drawImage(ro.robinrunright.getImage(), ro.x3, ro.y3, 140, 120, this);
                    }
                }
                else if(checkattacker == 1){
                    g.drawImage(ro.robinrunRightkill.getImage(), ro.x3, ro.y3, 140, 120, this);
                    checkattacker = 0;
                }
            }
            else if(checkbackorfront == 1){
                if(checkattacker == 0){
                    if(ro.count != 1){
                        g.drawImage(ro.robin2.getImage(), ro.x3, ro.y3, 140, 120, this);
                    }
                    else{
                        g.drawImage(ro.robinrunleft.getImage(), ro.x3, ro.y3, 140, 120, this);
                    }
                }
                else if(checkattacker == 1){
                    g.drawImage(ro.robinrunleftkill.getImage(), ro.x3, ro.y3, 140, 120, this);
                    checkattacker = 0;
                }

            }
        }
        
        
        if(ro.HP <= 0){
            checkgameover = true;
            g.drawImage(lose.getImage(), 0, 0, 1200, 665, this);
        }
        else if(boss.HP <=0){
            g.drawImage(fire2.getImage(), boss.x, boss.y, 140, 140, this);
            boss.alive = false;
        }
        if(checknextlevel == true){
            if(ro.x3 >= 990){
                g.drawImage(winner.getImage(), 0, 0, 1200, 665, this);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 50));
                g.drawString("Score: "+score, 800, 250);
            }
        }
        
        
        
    }
    @Override
        public void actionPerformed(ActionEvent e) {
            this.repaint();
        }    
    
}
