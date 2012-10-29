/*
 * default all connections to false
 * add movable panel and WireDraw listeners, add movable objectPanels,
 * add Timer, start timer, Timer Listener for start of object dynamics
 * bar bounces, and connections are checked soon as timer starts,
 * if bulb and bar are connected light up bulb, if scope and bar are connected
 * display graph on scope.
 * if scope and bulb and bar are connected properly light up and show graph
 */

/**
 *
 * @author Debo Olaosebikan
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

public class ExperimentPanel extends JPanel {

protected Bulb b;
protected BarPost metal = new BarPost();
protected Oscilloscope scope;
protected int barY, wireNo= -1;
protected ArrayList<Wire> wireArray;
protected ArrayList<Point> wire;
Wire newWire;

protected Timer timer1, timer2, timer3;
protected int DELAY1, DELAY2, DELAY3;
protected int i,y,dy;
//acceleration due to gravity
protected final int GRAV = 10;
protected int vel_bar, magField,mTopix;

//Bulb
protected float an,da;

//scope
protected int di;
protected int j=0;
protected ArrayList<Point> dispList;


//connection values represent whether wire exists between two terminals
protected Boolean bulb_scope1, bulb_scope2, bulb_bar1, bulb_bar2, scope_bar1,scope_bar2;
protected Boolean bulb_bar, bulb_scope, scope_bar;

//location of corners of objects in panel
protected Point barCorner, scopeCorner, bulbCorner;
protected Point placeBar, placeScope, placeBulb;
// Terminal Boundaries
protected Point leftBarTerminalX, leftBarTerminalY;
protected Point rightBarTerminalX, rightBarTerminalY;
protected Point bulbTerminalX, bulbTerminalY;
protected Point scopeTerminal1X, scopeTerminal1Y, scopeTerminal2X, scopeTerminal2Y;
protected Point scopeTerminalgX, scopeTerminalgY;



    public ExperimentPanel()
    {
     //All objects are disconnected at the start of a new experiment
      bulb_scope1 = bulb_scope2 = bulb_bar1 = bulb_bar2= scope_bar1 = scope_bar2= false;
      bulb_bar = false;
      bulb_scope = false;
      scope_bar = false;
      i=y=0;
      di=1;
      b= new Bulb();
      metal = new BarPost();
      scope = new Oscilloscope();
      an= b.getInitBright();
      dy=2;
      da= 0.01F;
      wireArray = new ArrayList<Wire>();
      wire = new ArrayList<Point>();
      dispList = new ArrayList<Point>();
      newWire = new Wire();
      barCorner = new Point(108,6);
      bulbCorner = new Point(310,410);
      scopeCorner = new Point(513,6);
      placeBar = placeScope = placeBulb = new Point(0,0);
         //move left bar terminal
     leftBarTerminalX = new Point(barCorner.x + metal.getLeftTerminalX().x,barCorner.x + metal.getLeftTerminalX().y);
     leftBarTerminalY = new Point(barCorner.y + metal.getLeftTerminalY().x, barCorner.y + metal.getLeftTerminalY().y);
    //move right bar Terminal
     rightBarTerminalX = new Point(barCorner.x + metal.getRightTerminalX().x, barCorner.x + metal.getRightTerminalX().y);
     rightBarTerminalY = new Point(barCorner.y + metal.getRightTerminalY().x, barCorner.y + metal.getRightTerminalY().y);

     //move ch1 terminal
    scopeTerminal1X = new Point(scopeCorner.x + scope.getCH1TerminalX().x, scopeCorner.x + scope.getCH1TerminalX().y);
    scopeTerminal1Y = new Point(scopeCorner.y + scope.getCH1TerminalY().x, scopeCorner.y + scope.getCH1TerminalY().y);
    //move ch2 Terminal
    scopeTerminal2X = new Point(scopeCorner.x + scope.getCH2TerminalX().x, scopeCorner.x + scope.getCH2TerminalX().y);
    scopeTerminal2Y = new Point(scopeCorner.y + scope.getCH2TerminalY().x, scopeCorner.y + scope.getCH2TerminalY().y);

    // move ground Terminals

    scopeTerminalgX = new Point(scopeCorner.x + scope.getGrTerminalX().x,scopeCorner.x + scope.getGrTerminalX().y);
    scopeTerminalgY = new Point(scopeCorner.y + scope.getGrTerminalY().x,scopeCorner.y + scope.getGrTerminalY().y);

    //move bulb terminal
    bulbTerminalX = new Point(bulbCorner.x + b.getBulbTerminalX().x,bulbCorner.x + b.getBulbTerminalX().y);
    bulbTerminalY = new Point(bulbCorner.y + b.getBulbTerminalY().x, bulbCorner.y + b.getBulbTerminalY().y);

      addMouseMotionListener(new wireListener());
      addMouseListener(new wireDetector());
      DELAY1 = 100;
      timer1 = new Timer(DELAY1, new connectionsListener());
      timer1.start();
      
      
       setBackground (Color.white);
    
        }



    public void paintComponent(Graphics page){

        super.paintComponent(page);
        
        metal.setOpaque(false);
        b.setOpaque(false);
        scope.setOpaque(false);
        
        //to allow for painting and repainting of multiple objects
        
        validate();

        add(metal);
        add(scope);
        add(b);
        

    page.setColor(Color.black);
           
      for (Point spot: wire)
        page.fillOval(spot.x-6,spot.y-6,12,12);

page.drawString ("Wire Count: " + wireArray.size(), 5, 15);

page.drawString ("Wire 1, Wire 2, Series " + bulb_bar1 + " " + bulb_bar2 + " " + bulb_bar, 5, 630);
    }

    //check connections

public Boolean checkConn(Point s, Point e, Point Boundx, Point Boundy, Point Bound2x, Point Bound2y){
    Boolean connected = false;
    if(s.x > Boundx.x && s.x < Boundx.y && s.y > Boundy.x && s.y < Boundy.y)
    {if(e.x > Bound2x.x && e.x < Bound2x.y && e.y > Bound2y.x && e.y < Bound2y.y)
    connected = true;
    }
    else if(e.x > Boundx.x && e.x < Boundx.y && e.y > Boundy.x && e.y < Boundy.y){
        if(s.x > Bound2x.x && s.x < Bound2x.y && s.y > Bound2y.x && s.y < Bound2y.y)
    connected = true;
    }
        return connected;
}

public Boolean setConnBulbBar(){
    if(bulb_bar1&&bulb_bar2)
      bulb_bar=true;
    return bulb_bar;
}

public Boolean setConnBulbScope(){
    if(bulb_scope1&&bulb_scope2)
      bulb_scope=true;
    return bulb_scope;
}

public Boolean setConnScopeBar(){
    if(scope_bar1&&scope_bar2)
     scope_bar=true;
    return scope_bar;
}

//change the locations of bar, scope and bulb will be overridden in movable child class
// probably need to define a getplaceBar etc function in the child class as well

public Point changeBarCorner(){


   barCorner.x = barCorner.x + placeBar.x;
    barCorner.y = barCorner.y + placeBar.y;

      //move left bar terminal
     leftBarTerminalX.x = barCorner.x + metal.getLeftTerminalX().x;
     leftBarTerminalX.y =  barCorner.x + metal.getLeftTerminalX().y;
     leftBarTerminalY.x = barCorner.y + metal.getLeftTerminalY().x;
     leftBarTerminalY.y = barCorner.y + metal.getLeftTerminalY().y;
    //move right bar Terminal
     rightBarTerminalX.x = barCorner.x + metal.getRightTerminalX().x;
     rightBarTerminalX.y =  barCorner.x + metal.getRightTerminalX().y;
     rightBarTerminalY.x = barCorner.y + metal.getRightTerminalY().x;
     rightBarTerminalY.y = barCorner.y + metal.getRightTerminalY().y;


  
            return barCorner;

}

public Point changeScopeCorner(){

    scopeCorner.x = scopeCorner.x + placeScope.x;
    scopeCorner.y = scopeCorner.y + placeScope.y;

    
 //move ch1 terminal
    scopeTerminal1X.x = scopeCorner.x + scope.getCH1TerminalX().x;
    scopeTerminal1X.y =  scopeCorner.x + scope.getCH1TerminalX().y;
    scopeTerminal1Y.x = scopeCorner.y + scope.getCH1TerminalY().x;
    scopeTerminal1Y.y = scopeCorner.y + scope.getCH1TerminalY().y;
    //move ch2 Terminal
    scopeTerminal2X.x = scopeCorner.x + scope.getCH2TerminalX().x;
    scopeTerminal2X.y =  scopeCorner.x + scope.getCH2TerminalX().y;
    scopeTerminal2Y.x = scopeCorner.y + scope.getCH2TerminalY().x;
    scopeTerminal2Y.y = scopeCorner.y + scope.getCH2TerminalY().y;

    // move ground Terminals

    scopeTerminalgX.x = scopeCorner.x + scope.getGrTerminalX().x;
    scopeTerminalgX.y =  scopeCorner.x + scope.getGrTerminalX().y;
    scopeTerminalgY.x = scopeCorner.y + scope.getGrTerminalY().x;
    scopeTerminalgY.y = scopeCorner.y + scope.getGrTerminalY().y;

   
    return scopeCorner;
}

public Point changeBulbCorner(){

    bulbCorner.x = bulbCorner.x + placeBulb.x;
    bulbCorner.y = bulbCorner.y + placeBulb.y;

    //move bulb terminal
    bulbTerminalX.x = bulbCorner.x + b.getBulbTerminalX().x;
    bulbTerminalX.y =  bulbCorner.x + b.getBulbTerminalX().y;
    bulbTerminalY.x = bulbCorner.y + b.getBulbTerminalY().x;
    bulbTerminalY.y = bulbCorner.y + b.getBulbTerminalY().y;

      
    return bulbCorner;
}

// mutates the Bar, displaces it by an extra amount dy everytime method is called
public void mutateBar(){
       
       y +=dy;
       if (y >= metal.getINITBarHeight()|| y < 0)
           dy= -1*dy;
       barY = metal.getINITBarHeight()+y;
       metal.setBarHeight(barY);
}

// mutates Bulb, changes its brightness to match velocity of bar

public void mutateBulb(){
     if(bulb_bar)
            {
       an+= da;

            if (an<=(float)0.01 || an>= (float)0.9)
                da = da * -1;
            b.setBrightness(an);
          }
            else{
                an = b.getInitBright();
              b.setBrightness(an);
                         }

}

public void mutateScope(){
    if(( bulb_bar && bulb_scope) || scope_bar)
            {

        j += di;

                int t= j*DELAY1/(100*scope.getTimeScale()), volt= (int)(10*Math.sin((double)(j*DELAY1))/scope.getCh1Scale());
               if (volt<= -((scope.getDispHeight()/2)- scope.getPlotSize())|| volt>=(scope.getDispHeight()/2)-scope.getPlotSize())
                 di=di * -1;
             if (t<= -1*scope.getDispWidth() || t>=(scope.getDispWidth()))
                     j=0;
                dispList = scope.getPointList();
                dispList.add(new Point(t,volt));
                           }

            else{
                 j+=di;
                  int t=j*DELAY1, volt= (int)(10*Math.sin((double)(j*DELAY1)));
                 volt= 0;
                  if (t<= -1*scope.getDispWidth() || t>=(scope.getDispWidth()))
                     j=0;
                dispList =scope.getPointList();
                 dispList.add(new Point(t,volt));
                   }
}


//records a wire once the mouse is pressed

    private class wireDetector extends MouseAdapter{
    
      public void mousePressed(MouseEvent event){
       
       wireNo++;
       newWire.setID(wireNo);
       newWire.setWireStart(event.getPoint());
       wireArray.add(newWire);
       repaint();

          }
    public void mouseReleased(MouseEvent event){
        
        newWire.setWireEnd(event.getPoint());
        //check to see where start and end points belong and set boolean variables
        //accordingly! terminals are only currently defined within individual panels.
        //They must be defined (for now) as boundaries of each panel
        //this class out to be able to tell me where each panel is and we can work from there

        //check bar and bulb
        Point start = newWire.getWireStart();
        Point end = newWire.getWireEnd();

        
        if(checkConn(start, end, leftBarTerminalX, leftBarTerminalY, bulbTerminalX, bulbTerminalY))
        {bulb_bar1=true;}
        else if(checkConn(start, end, rightBarTerminalX, rightBarTerminalY, bulbTerminalX, bulbTerminalY))
        {bulb_bar2=true;}
        else if(checkConn(start, end, leftBarTerminalX, leftBarTerminalY, scopeTerminal1X, scopeTerminal1Y))
        {scope_bar1=true;}
        else if(checkConn(start, end, rightBarTerminalX, rightBarTerminalY, scopeTerminalgX, scopeTerminalgY))
        {scope_bar2=true;}
        else if(checkConn(start, end, scopeTerminal1X, scopeTerminal1Y, bulbTerminalX, bulbTerminalY))
        {
            bulb_scope1 = true;           
        }
         else if(checkConn(start, end, scopeTerminalgX, scopeTerminalgY, bulbTerminalX, bulbTerminalY))
        {
            bulb_scope2 = true;
        }


    }
}

    //draws out a wire when the mouse is dragged.
private class wireListener implements MouseMotionListener{
    public void mouseDragged(MouseEvent event){
         
        newWire.populateWire(event.getPoint());
        wire = newWire.getWireList();
        repaint();
    }
    public void mouseMoved(MouseEvent event){
    }
}

// checks to see what connections exists and decides what to do with the objects
// in the experiment
private class connectionsListener implements ActionListener{
      
    public void actionPerformed(ActionEvent event) {

       i++;

       //Bar behavior
    changeBarCorner();
    mutateBar();

       //Bulb Behavior
    changeBulbCorner();
    setConnBulbBar();
     mutateBulb();
      
    //Scope Behavior
     changeScopeCorner();
     setConnBulbScope();
     setConnScopeBar();
     mutateScope();

       repaint();
       
        
   }
}
}

