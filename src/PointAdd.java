/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.awt.*;


public class PointAdd extends Point{

     public PointAdd(){
        super();

    }


    public PointAdd(int x, int y){
        super(x,y);

    }

    public PointAdd pointAdd(Point b){
        PointAdd c = new PointAdd();
        c.x = this.x+b.x;
        c.y = this.y +b.y;
        return c;
    }

}
