
package project.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;


public class Map2 extends JPanel implements ActionListener{
    
    private Timer timerb = new Timer(1000, new Map2.Listener());
    
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("Map2.png"));
    private ImageIcon lose = new ImageIcon(this.getClass().getResource("Lose.png"));
    Chareater ro = new Chareater();
    Cony1 cony1 = new Cony1();
    Cony2 cony2 = new Cony2();
    MiniBosss mini = new MiniBosss();
    public int poppe = 120;
    public boolean checkgameover = false;
    
    private Timer topyou = new Timer(1000, new Map2.Listener());
    
    public int score = 0;
    boolean checknextlevel = false;
    public boolean checkpickkey = false;
    public boolean checknext = false;
    public boolean checknextlevel3 = false;
    
    int checkbacktofront = 0;
    public int alive;
    public int checknearskull = 0;
    boolean timestart = true;
    int checkbackorfront = 0;
    public int checkattacker = 0;
    public int checkenemysonw = 0;
    public int keyx = 40;
    private ImageIcon Key = new ImageIcon(this.getClass().getResource("key.png"));
    private ImageIcon star = new ImageIcon(this.getClass().getResource("Star.gif"));
    private ImageIcon doro = new ImageIcon(this.getClass().getResource("doro.png"));
    private ImageIcon doorrr = new ImageIcon(this.getClass().getResource("door.png"));
    private ImageIcon wal = new ImageIcon(this.getClass().getResource("background.png"));
    private ImageIcon next2 = new ImageIcon(this.getClass().getResource("Next level.png"));
    JButton level2 = new JButton(next2);
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    if(ro.checkfloor == 1){
                        if(ro.x == keyx){
                            checkpickkey = true;
                        }
                    }
                    
                    if(ro.checkfloor == 0 && ro.x == 1010 && checkpickkey == true ){
                        checknext = true;
                        
                    }
                    if(ro.x == 1010 && checknext == true && ro.checkfloor == 0 && cony1.alive == false && cony2.alive == false && mini.alive == false){
                        checknextlevel = true;
                    }
                    //cony1
                    if(cony1.alive == true){
                        if(cony1.back == false){
                            if(cony1.x<=0) cony1.x=1000;
                            else cony1.x= cony1.x-5;
                        }
                        else{
                            if(cony1.x<=0) cony1.x=1000;
                            else cony1.x= cony1.x+5;
                        }
                        cony1.distanceP = (int)Math.sqrt((Math.pow(Math.abs(cony1.x-ro.x),2))+(Math.pow(Math.abs(cony1.y-ro.y),2)));
                        
                        if(ro.checkfloor == 0){
                           if(cony1.distanceP <= 80){
                                checkenemysonw = 1;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(cony1.distanceP <= 60){
                                cony1.x = ro.x+200;
                                ro.HP -= cony1.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(cony1.distanceP <= 60){
                                cony1.x = ro.x-200;
                                ro.HP -= cony1.ak;
                            }
                        }


                        if(cony1.x <= 490){
                            cony1.back = true;
                        }
                        else if(cony1.x >= 700){
                            cony1.back = false;
                        }      
                    }
                    if(cony1.alive == true){
                        if(cony1.back == false){
                            if(cony1.x<=0) cony1.x=1000;
                            else cony1.x= cony1.x-5;
                        }
                        else{
                            if(cony1.x<=0) cony1.x=1000;
                            else cony1.x= cony1.x+5;
                        }
                        cony1.distanceP = (int)Math.sqrt((Math.pow(Math.abs(cony1.x-ro.x),2))+(Math.pow(Math.abs(cony1.y-ro.y),2)));
                        
                        if(ro.checkfloor == 0){
                           if(cony1.distanceP <= 80){
                                checkenemysonw = 1;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(cony1.distanceP <= 60){
                                cony1.x = ro.x+200;
                                ro.HP -= cony1.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(cony1.distanceP <= 60){
                                cony1.x = ro.x-200;
                                ro.HP -= cony1.ak;
                            }
                        }


                        if(cony1.x <= 490){
                            cony1.back = true;
                        }
                        else if(cony1.x >= 700){
                            cony1.back = false;
                        }      
                    }
                    //MiniBoss
                    if(score == 200){
                        if(mini.alive == true){
                            if(mini.back == false){
                                if(mini.x<=0) mini.x=1000;
                                else mini.x= mini.x-5;
                            }
                            else{
                                if(mini.x<=0) mini.x=1000;
                                else mini.x= mini.x+5;
                            }
                            mini.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mini.x-ro.x),2))+(Math.pow(Math.abs(mini.y-ro.y),2)));

                            if(ro.checkfloor == 0){
                               if(mini.distanceP <= 60){
                                    checkenemysonw = 2;

                                }
                                else{
                                    checkenemysonw = 0;
                                } 
                            }   

                            if(checkbacktofront == 0){

                                if(mini.distanceP <= 60){
                                    mini.x = ro.x+200;
                                    ro.HP -= mini.ak;
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(mini.distanceP <= 60){
                                    mini.x = ro.x-200;
                                    ro.HP -= mini.ak;
                                }
                            }


                            if(mini.x <= 490){
                                mini.back = true;
                            }
                            else if(mini.x >= 700){
                                mini.back = false;
                            }      
                        }
                        if(mini.alive == true){
                            if(mini.back == false){
                                if(mini.x<=0) mini.x=1000;
                                else mini.x= mini.x-5;
                            }
                            else{
                                if(mini.x<=0) mini.x=1000;
                                else mini.x= mini.x+5;
                            }
                            mini.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mini.x-ro.x),2))+(Math.pow(Math.abs(mini.y-ro.y),2)));

                            if(ro.checkfloor == 0){
                               if(mini.distanceP <= 80){
                                    checkenemysonw = 1;

                                }
                                else{
                                    checkenemysonw = 0;
                                } 
                            }   

                            if(checkbacktofront == 0){

                                if(mini.distanceP <= 60){
                                    mini.x = ro.x+200;
                                    ro.HP -= mini.ak;
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(mini.distanceP <= 60){
                                    mini.x = ro.x-200;
                                    ro.HP -= mini.ak;
                                }
                            }


                            if(mini.x <= 490){
                                mini.back = true;
                            }
                            else if(mini.x >= 700){
                                cony1.back = false;
                            }      
                        }
                    }
                    
                    //cony2
                    if(cony2.alive == true){
                        if(cony2.back == false){
                            if(cony2.x<=0) cony2.x=1000;
                            else cony2.x= cony2.x-5;
                        }
                        else{
                            if(cony2.x<=0) cony2.x=1000;
                            else cony2.x= cony2.x+5;
                        }
                        cony2.distanceP = (int)Math.sqrt((Math.pow(Math.abs(cony2.x-ro.x),2))+(Math.pow(Math.abs(cony2.y-ro.y),2)));
                        
                        if(ro.checkfloor == 2){
                           if(cony2.distanceP <= 80){
                                checkenemysonw = 3;
                                
                            }
                            else{
                                checkenemysonw = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(cony2.distanceP <= 60){
                                cony2.x = ro.x+200;
                                ro.HP -= cony2.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(cony2.distanceP <= 60){
                                cony2.x = ro.x-200;
                                ro.HP -= cony2.ak;
                            }
                        }


                        if(cony2.x <= 400){
                            cony2.back = true;
                        }
                        else if(cony2.x >= 600){
                            cony2.back = false;
                        }      
                    }
                    Thread.sleep(50);
                
                
                    
                }catch(Exception e){
                 
                }
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
   
    
    Map2(){
        timerb.start();
        time.start();
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a == KeyEvent.VK_F9){
                    checknextlevel = true;
                    checkpickkey = true;
                    checknext = true;
                }
                if(a == KeyEvent.VK_F10){
                    cony1.alive = false;
                    cony2.alive = false;
                    
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
                            else
                                ro.y += 10;
                                ro.count++;
                            
                                if(ro.count >= 2){
                                    ro.count = 0;
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
        topyou.start();
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == topyou){
                poppe--;
            }
            repaint();
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        g.drawString("Score: "+score, 350, 50);
        g.drawString("checkenemysonw: "+checkenemysonw, 750, 50);
        g.drawString("Time: "+ poppe, 200, 50); 
        
        if(checkpickkey == false){
            g.drawImage(star.getImage(), 24, 320, 70, 70, this);
            g.drawImage(Key.getImage(), keyx, 350, 40, 20, this);
        }
        
        g.drawImage(doro.getImage(), 610, 390, 70, 200, this);  // bandai 1
        g.drawImage(doro.getImage(), 900, 190, 70, 200, this);  // bandai 2
        g.drawImage(doro.getImage(), 210, 193, 70, 200, this);  // bandai 3
        g.drawImage(doorrr.getImage(), 1050, 490, 60, 100, this);
        if(score == 200){
            if(mini.alive == true){
                g.drawString("HP: "+mini.HP, mini.x+15, mini.y+8);
                g.drawImage(mini.miniboss.getImage(), mini.x, mini.y, 140, 140, this);
            }
        }
        
       
        //Attack
        if(cony1.alive == true){
            if(checkattacker == 1 && checkenemysonw == 1) {
                score += 55;
                cony1.alive = false;
                checkattacker = 0;
                checkenemysonw = 0;
            }
        }
        if(cony2.alive == true){
            if(checkattacker == 1 && checkenemysonw == 3) {
                score += 55;
                cony2.alive = false;
                checkattacker = 0;
                checkenemysonw = 0;
            }
        }
        if(score == 200){
            if(mini.alive = true){
                if(checkattacker == 1 && checkenemysonw == 1) {
                mini.HP -= ro.ATK;
                checkattacker = 0;
            }
               
            }
        
        }
        
        //cony1
        if(cony1.alive == true)
        {
            if(cony1.back == true){
                g.drawImage(cony1.cony1.getImage(), cony1.x, cony1.y, 130, 135, this); 
            }
            else{
               g.drawImage(cony1.cony1.getImage(), cony1.x, cony1.y, 130, 135, this); 
            }
        }
        //cony2
        if(cony2.alive == true)
        {
            if(cony2.back == true){
                g.drawImage(cony2.cony2.getImage(), cony2.x, cony2.y, 130, 135, this); 
            }
            else{
               g.drawImage(cony2.cony2.getImage(), cony2.x, cony2.y, 130, 135, this); 
            }
        }
        if(ro.alive = true){
            g.drawString("HP: "+ro.HP, ro.x+50, ro.y+10);
            if(checkattacker == 1 && checkenemysonw == 1) {
                mini.HP -= ro.ATK;
                checkattacker = 0;
                checkenemysonw = 0;
            }
        }
       
        if(score == 200){        
            if(mini.HP <=0){
                mini.alive = false;
            }

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
        if(ro.HP <= 0){
            checkgameover = true;
            g.drawImage(lose.getImage(), 0, 0, 1200, 665, this);
        }
        if(checkpickkey == true && checknext == true && checknextlevel == true){
            checknextlevel3 = true;
        }
        if(checknextlevel3 == true){
            if(ro.x >= 1010){
                g.drawImage(wal.getImage(), 0, 0, 1200, 665, this);
                this.setLayout(null);
                level2.setBounds(200, 200, 800, 300);
                level2.setBorderPainted(false);
                level2.setBorder(null);
                level2.setOpaque(false); 
                level2.setContentAreaFilled(false);
                add(level2);

                time.stop();
                
            }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
