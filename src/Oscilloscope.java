/*
 * Oscilloscope with a display window, unit controls, 2 channel terminals 
 * an On button, and scale buttons, parallel type connection, Brand name
 * Display function checks whether circuit is closed and whether
 * connection is parallel. Graph is displayed according to the scale settings
 * and the value in the current array.
  */

/**
 *
 * @author Debo Olaosebikan
 */
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class Oscilloscope extends JPanel{
    //need to change this to a vector dimension object
 final int scope_width = 200, scope_height = 200, dispOffX = 50,dispOffY = 50;
 final int PlotSize = 1, TermRad =8;
 int ChanSpacing =2*TermRad;
 int disp_centerX, disp_centerY;
 Circle PlotPoint;
 CircTerminal positive1, positive2, ground;
 private ArrayList<Point> pointList;
 Random triggerX, triggerY;
 private int randomJump;
 private int gridSize;

 private JSlider HscaleSlide, VscaleSlide;
 private JLabel hLabel, vLabel;
 private JPanel scales;
 
 
    int xscale, yscale1, yscale2, center_scopeX, center_scopeY;
    Rectangle scope_body, scope_display, scope_grid;

    //Places an oscilloscope centered at scope_center
    //and sets the default scale and trigger variables for display
    //
    public Oscilloscope(){
       
        center_scopeX = 200;
        center_scopeY = 200;
        pointList = new ArrayList<Point>();
    positive1 = new CircTerminal(1, Color.red, getCh1PosX(),getCh1PosY(),TermRad);
    positive2 = new CircTerminal(1, Color.red, getCh2PosX(),getCh2PosY(),TermRad);
    ground = new CircTerminal(0, Color.red, getGrX(),getGrY(),TermRad);

    HscaleSlide = new JSlider (JSlider.HORIZONTAL,0,10,1);
    HscaleSlide.setMajorTickSpacing(5);
    HscaleSlide.setMinorTickSpacing(1);
    HscaleSlide.setPaintTicks(true);
    HscaleSlide.setPaintLabels(true);
    HscaleSlide.setAlignmentX(Component.LEFT_ALIGNMENT);

    VscaleSlide = new JSlider (JSlider.HORIZONTAL,0,10,1);
    VscaleSlide.setMajorTickSpacing(5);
    VscaleSlide.setMinorTickSpacing(1);
    VscaleSlide.setPaintTicks(true);
    VscaleSlide.setPaintLabels(true);
    VscaleSlide.setAlignmentX(Component.LEFT_ALIGNMENT);

    ScaleListener listener = new ScaleListener();
    HscaleSlide.addChangeListener(listener);
    VscaleSlide.addChangeListener(listener);

    hLabel = new JLabel("Time Scale: 1 ms/div");
    hLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    vLabel = new JLabel ("Voltage Scale: 1 V/div");
    vLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

    scales = new JPanel();
    BoxLayout layout = new BoxLayout (scales, BoxLayout.X_AXIS);
    scales.setLayout(layout);
    
    scales.add(HscaleSlide);    
    scales.add(VscaleSlide);

    xscale = 1;
    yscale1 = 1;
    yscale2 = 1;
    gridSize =10;
    add(scales);

        setBackground(Color.white);
        setPreferredSize(new Dimension(400,400));
       }


    public Oscilloscope(int scope_centerX, int scope_centerY){
        xscale = 1;
        yscale1 = 1;
        yscale2 = 1;
        center_scopeX = scope_centerX;
        center_scopeY = scope_centerY;        
        pointList = new ArrayList<Point>();
       positive1 = new CircTerminal(1, Color.red, getCh1PosX(),getCh1PosY(),TermRad);
       positive2 = new CircTerminal(1, Color.red, getCh2PosX(),getCh2PosY(),TermRad);
       ground = new CircTerminal(0, Color.red, getGrX(),getGrY(),TermRad);

       HscaleSlide = new JSlider (JSlider.HORIZONTAL,0,10,0);
    HscaleSlide.setMajorTickSpacing(5);
    HscaleSlide.setMinorTickSpacing(1);
    HscaleSlide.setPaintTicks(true);
    HscaleSlide.setPaintLabels(true);
    HscaleSlide.setAlignmentX(Component.TOP_ALIGNMENT);

    VscaleSlide = new JSlider (JSlider.HORIZONTAL,0,10,0);
    VscaleSlide.setMajorTickSpacing(5);
    VscaleSlide.setMinorTickSpacing(1);
    VscaleSlide.setPaintTicks(true);
    VscaleSlide.setPaintLabels(true);
    VscaleSlide.setAlignmentX(Component.TOP_ALIGNMENT);

        setBackground(Color.white);
        setPreferredSize(new Dimension(400,400));
        
    }

  //function that controls brightness of the bulb via the alpha value of the color


    //sets the location of the oscilloscope frame and contents

public void setLocation(Point point){
    center_scopeX = point.x;
    center_scopeY = point.y;

}


public void setTimeScale (int newTime)
{
    xscale = newTime;
}

public void setCh1Scale (int newVolt)
{
    yscale1 = newVolt;
}

public void setCh2Scale (int newVolt2)
{
    yscale2 = newVolt2;
}


public int getTimeScale (){
    return xscale;
}

public int getCh1Scale (){
    return yscale1;
}

public int getCh2Scale (){
    return yscale2;
}

public int getGridSize(){
    return gridSize;
}

public int getDispCenterX (){
    return center_scopeX-(scope_width/5);
}

public int getDispCenterY (){
    return center_scopeY-(scope_width/5);
}

public int getDispHeight(){
    return scope_height/2;
}

public int getDispWidth(){
    return scope_width/2;
}

public int getCh1PosX (){
    return center_scopeX+(scope_width/20);
}

public int getCh1PosY (){
    return center_scopeY+(scope_height/3);
}

public int getCh2PosX (){
    return center_scopeX+ 2*ChanSpacing+(scope_width/20);
}

public int getCh2PosY (){
    return center_scopeY+(scope_height/3);
}
public int getGrX (){
    return center_scopeX+ 4*ChanSpacing+(scope_width/20);
}

public int getGrY (){
     return center_scopeY+(scope_height/3);
}

public int getPlotSize(){
    return PlotSize;
}

public ArrayList<Point> getPointList(){
    return pointList;
}

 public Point getCH1TerminalX(){
         return positive1.getBoundaryX();
     }

       public Point getCH1TerminalY(){
         return positive1.getBoundaryY();
     }


     public Point getCH2TerminalX(){
         return positive2.getBoundaryX();
     }

     public Point getCH2TerminalY(){
         return positive2.getBoundaryY();
     }

      public Point getGrTerminalX(){
         return ground.getBoundaryX();
     }

     public Point getGrTerminalY(){
         return ground.getBoundaryY();
     }

  
public void paintComponent(Graphics page){
    
    super.paintComponent(page);

    scope_body = new Rectangle(Color.blue, center_scopeX, center_scopeY, scope_height, scope_width);
    scope_display = new Rectangle(Color.white, getDispCenterX(), getDispCenterY(), getDispHeight(), getDispWidth());
    positive1 = new CircTerminal(1, Color.red, getCh1PosX(),getCh1PosY(),TermRad);
    positive2 = new CircTerminal(1, Color.red, getCh2PosX(),getCh2PosY(),TermRad);
    ground = new CircTerminal(0, Color.red, getGrX(),getGrY(),TermRad);

    scope_body.draw(page);
    scope_display.draw(page);
    positive1.draw(page);
    positive2.draw(page);
    ground.draw(page);

    
    page.setColor(Color.LIGHT_GRAY);
    for(int i =0;gridSize*i<= getDispHeight(); i++)
    page.drawLine(getDispCenterX()- (getDispWidth()/2), getDispCenterY()- (getDispHeight()/2)+gridSize*i,getDispCenterX()+ (getDispWidth()/2),getDispCenterY()- (getDispHeight()/2)+gridSize*i);

    for(int i =0;gridSize*i<= getDispWidth(); i++)
    page.drawLine(getDispCenterX()- (getDispWidth()/2)+gridSize*i, getDispCenterY()- (getDispHeight()/2), getDispCenterX()- (getDispWidth()/2)+gridSize*i, getDispCenterY()+ (getDispHeight()/2));

    page.setColor(Color.green);

    for(Point spot : pointList)
    page.fillOval (getDispCenterX()-(getDispWidth()/2)+spot.x-PlotSize, getDispCenterY()+spot.y-PlotSize, PlotSize*2, PlotSize*2);

    
}
//scale listeners for sliders

private class ScaleListener implements ChangeListener{



    public void stateChanged (ChangeEvent event){

        xscale = HscaleSlide.getValue();
        yscale1 = VscaleSlide.getValue();

        hLabel.setText("Time Scale: " + xscale + " " + "ms/div");
        vLabel.setText("Voltage Scale: " + yscale1 + " " + "V/div");
        pointList.clear();
        repaint();
        
    }

}


}
     
    




