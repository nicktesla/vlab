/*
 * Allows for dragging, depicts all objects,
 * checks connections and tells all objects to start running
 */

/**
 *
 * @author levelz
 */

import javax.swing.*;
import java.awt.*;

public class BarTester {


    public static void main (String[] args)
    {
        JFrame frame = new JFrame("BarPost");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BarPost fall = new BarPost();
        JPanel primary = new JPanel();

        primary.add(fall);


        frame.getContentPane().add (primary);
        frame.pack();
        frame.setVisible(true);

        PointAdd a = new PointAdd(10,10);
        PointAdd b = new PointAdd(-8,15);
        PointAdd c = a.pointAdd(b);
        
        System.out.println("The left end of terminal is " + fall.getLeftTerminalX().x + "The right end of Terminal is" + fall.getLeftTerminalX().y);
        System.out.println("The x of PointAdd is  " + c.x + "The y of Point Add is " + c.y);

     }

}

