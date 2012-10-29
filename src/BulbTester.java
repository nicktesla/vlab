/*
 * Allows for dragging, depicts all objects,
 * checks connections and tells all objects to start running
 */

/**
 *
 * @author levelz
 */

import javax.swing.*;

public class BulbTester {


    public static void main (String[] args)
    {
        JFrame frame = new JFrame("Bulb");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Bulb btest = new Bulb(200,200,30,80,40);
        JPanel primary = new JPanel();

        primary.add(btest);


        frame.getContentPane().add (primary);
        frame.pack();
        frame.setVisible(true);

     }

}
