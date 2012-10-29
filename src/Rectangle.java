/*
 * Defines a rectangular object with access to its
 * color, center, height and width
 */

/**
 *
 * @author levelz
 */
import java.awt.*;
import javax.swing.*;


public class Rectangle {
    Color box_Color;
    int box_CenterX, box_CenterY, box_Height, box_Width;
 
    //Constructs a rectangle with specified color, dimensions and center location
    public Rectangle(Color rect_Color, int rect_CenterX, int rect_CenterY, int height, int width ){
    box_Color = rect_Color;
    box_CenterX = rect_CenterX;
    box_CenterY = rect_CenterY;
    box_Height = height ;
    box_Width =  width;

    }

    //draws the specified rectangle
    public void draw (Graphics page){
page.setColor(box_Color);
page.fillRect(box_CenterX-(box_Width/2),box_CenterY-(box_Height/2), box_Width, box_Height);
             }

    // center mutator
    public void setCenter(int new_CenterX, int new_CenterY){
        box_CenterX = new_CenterX;
        box_CenterY = new_CenterY;
    }

    // center accessor
    public int[] getCenter(){
         int[] center =new int[2];
        center[0]= box_CenterX;
        center[1]= box_CenterY;
        return center;
    }
}
