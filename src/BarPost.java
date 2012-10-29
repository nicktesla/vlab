/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BarPost extends JPanel {

    private final int INIT_HEIGHT;
    private int bar_centerX, bar_centerY, bWIDTH, bTHICKNESS;
    private int leftRailX, leftRailY, rightRailX, rightRailY;
    private int velBar;
    private Rectangle bar;
    private RecTerminal leftRail, rightRail;
    
    int DELAY =10;
    
    public BarPost()
    {
       velBar = 0;
       

       INIT_HEIGHT=200;
       bar_centerX=200;
       bar_centerY=INIT_HEIGHT;
       bWIDTH = 250;
       bTHICKNESS = 40;
       leftRailX= bar_centerX - ((bWIDTH/2)-(bTHICKNESS/2));
       leftRailY= bar_centerY + (bWIDTH/2)+(bTHICKNESS/2);
       rightRailX= bar_centerX + ((bWIDTH/2)-(bTHICKNESS/2));
       rightRailY= bar_centerY + (bWIDTH/2)+(bTHICKNESS/2);
       bar = new Rectangle(Color.blue, bar_centerX, bar_centerY, bTHICKNESS, bWIDTH);
       leftRail = new RecTerminal(0,Color.black,leftRailX, leftRailY, bWIDTH, bTHICKNESS);
       rightRail= new RecTerminal(0,Color.black,rightRailX, rightRailY, bWIDTH, bTHICKNESS);
       setBackground(Color.white);
       setPreferredSize(new Dimension(400,400));
      

    }

    public void setBarHeight(int newHeight){
        bar_centerY = newHeight;
    }

    public void setVelBar(int newVel){
        velBar = newVel;
    }

    public int getBarHeight(){
        return bar_centerY;
    }

      public int getINITBarHeight(){
        return INIT_HEIGHT;
    }

     public int getVelBar(){
        return velBar;
    }

     public Point getLeftTerminalX(){
         return leftRail.getBoundaryX();
     }

       public Point getLeftTerminalY(){
         return leftRail.getBoundaryY();
     }


     public Point getRightTerminalX(){
         return rightRail.getBoundaryX();
     }

     public Point getRightTerminalY(){
         return rightRail.getBoundaryY();
     }
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        bar = new Rectangle(Color.blue, bar_centerX, bar_centerY, bTHICKNESS, bWIDTH);
        
        bar.draw(page);
        leftRail.draw(page);
        rightRail.draw(page);
        
        page.setColor(Color.black);
        page.drawString(leftRailX + " " + rightRailX, 5, 15);
    }

}









