/*
 * Represents a wire Object.
 */

/**
 *
 * @author Debo Olaosebikan
 */
import java.awt.*;
import java.util.*;

public class Wire {

    // A wire is a list of points of a certain color and size bounded by the start and end.
    private ArrayList<Point> wirePoints;
    private Point startPoint, endPoint;
    private Color wireColor;
    private int radW;
    private int wireID;
   
// default wire constructor sets the start and end points to zero, sets the wire
// list to zero and the default wire color to black
    public Wire(){
        wireID = 0;
        wireColor = Color.black;
        radW = 6;
        wirePoints = new ArrayList<Point>();
        startPoint = new Point (2,3);
        endPoint = startPoint;
        wirePoints.add(startPoint);
    }

// more specific constructor changes color and radius to whatever you like
    public Wire(int id, Color c, int radius){
       
        wireID = id;
        wireColor = c;
        radW = radius;
    }

// Accesses the start point of wire
    public Point getWireStart()
    {
        return startPoint;
    }
// Accesses the end point of wire
    public Point getWireEnd()
    {
       return endPoint;
    }
    //returns the list of wire points

    public ArrayList<Point> getWireList()
    {
        return wirePoints;
    }

      public void setID(int newID)
    {

        wireID = newID;
    }

       public int getID()
    {

        return wireID;
    }
// sets the start point of the wire
    public void setWireStart(Point p)
    {
        wirePoints.remove(0);
        startPoint = p;
        wirePoints.add(0, startPoint);     

    }


     public void setWireEnd(Point f)
    {

        endPoint = f;
    }
 // changes the color of the wire
    public void setWireColor(Color c){
        wireColor = c;
    }

//populates the list of points in the wire
    public void populateWire(Point p)
        {
        wirePoints.add(p);
            }

 // depicts each point in the wire list.
    public void drawWirePoint(Graphics page, Point p)
    {
    page.setColor(wireColor);
    page.fillOval(p.x-radW, p.y-radW,radW,radW);
             }
    }

        
   

    


