/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.awt.*;
import java.util.*;

public class WireTester {



    public static void main(String[] args){

        Wire top = new Wire();

        for(int i =0; i<11; i++)
        {
            top.setID(i);
            Point p = new Point(i,i);
            top.setWireStart(p);
            System.out.println("contents of wire:" + top.getID() + top.getWireList()+ top.getWireStart());
        }
    }

}
