/*
 * Defines a circular object with access to its
 * color, center and radius
 */

/**
 *
 * @author Debo Olaosebikan
 */
import java.awt.*;



public class Circle {
   protected Color round_Color;
   protected int round_CenterX, round_CenterY, round_rad;

    //Constructs a rectangle with specified color, dimensions and center location
    public Circle(Color circ_Color, int circ_CenterX, int circ_CenterY, int radius){
    round_Color = circ_Color;
    round_CenterX = circ_CenterX;
    round_CenterY = circ_CenterY;
    round_rad = radius ;
    }
    //draws the specified rectangle
    public void draw (Graphics page){
    page.setColor(round_Color);
    page.fillOval(round_CenterX-round_rad,round_CenterY-round_rad, 2*round_rad, 2*round_rad);
             }

    // center mutator
    public void setCenter(int new_CenterX, int new_CenterY){
        round_CenterX = new_CenterX;
        round_CenterY = new_CenterY;

    }

    // center accessor
    public int[] getCenter(){

        int[] center =new int[2];
        center[0]= round_CenterX;
        center[1]= round_CenterY;
        return center;
    }
}
