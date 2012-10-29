/*
 * Draws Bulb that is used in experiment sets up terminals which are aware of 
 * what wires are connected to them
 */

/**
 *
 * @author Debo Olaosebikan
 */
import java.awt.*;
import javax.swing.*;

public class Bulb extends JPanel{

private final int RADIUS;
private int round_centerX, round_centerY, height, width;
private float resist;
private final float INIT_BRIGHT=0.01F;
private float an, da;
private Color c ;
private Circle bulb;
private RecTerminal stand;


//Centers a bulb and stand relative to bulb_center,
//defines its dimensions and color
public Bulb ()
{
       RADIUS = 30;
       height = 80;
       width = 40;
       round_centerX = 200;
       round_centerY = 200;
       resist =10;
       an = INIT_BRIGHT;
       da=(float) 0.01;
       c = new Color((float)1.0,(float)1.0,(float)0,an);
       bulb = new Circle(c, round_centerX, round_centerY, RADIUS);
    stand = new RecTerminal(0,Color.black,round_centerX, round_centerY+RADIUS+(height)/2, height, width);
       setBackground(Color.white);
       setPreferredSize(new Dimension(400,400));
              }
public Bulb (int bulb_centerX, int bulb_centerY, int bulb_rad, int stand_height, int stand_width)
{
       RADIUS = bulb_rad;
       height = stand_height;
       width = stand_width;
       round_centerX = bulb_centerX;
       round_centerY = bulb_centerY;
       an = INIT_BRIGHT;
       da=(float) 0.01;
       c = new Color((float)1.0,(float)1.0,(float)0,an);
       bulb = new Circle(c, round_centerX, round_centerY, RADIUS);
    stand = new RecTerminal(0,Color.black,round_centerX, round_centerY+RADIUS+(height)/2, height, width);
       setBackground(Color.white);
       setPreferredSize(new Dimension(400,400));
              }
   
//function that controls brightness of the bulb via the alpha value of the color
public void setBrightness(float hue){
        c = new Color((float)1.0,(float)1.0,(float)0, hue);
    }
  
//sets the location of the Bulb object (bulb and stand)

public void setLocation(Point point){
    round_centerX = point.x;
    round_centerY = point.y;

}

public void setResist (float newResist)
{
    resist = (float) newResist;
}


public float getResist (){
    return resist;
}

public float getInitBright(){
    return INIT_BRIGHT;
}
public Point getBulbTerminalX(){
         return stand.getBoundaryX();
     }

       public Point getBulbTerminalY(){
         return stand.getBoundaryY();
     }
public void paintComponent(Graphics page){
    super.paintComponent(page);

    bulb = new Circle(c, round_centerX, round_centerY, RADIUS);
    stand = new RecTerminal(0,Color.black,round_centerX, round_centerY+RADIUS+(height)/2, height, width);

    bulb.draw(page);
    stand.draw(page);
}


}



