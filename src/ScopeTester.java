/*
 * Allows for dragging, depicts all objects,
 * checks connections and tells all objects to start running
 */

/**
 *
 * @author levelz
 */

import javax.swing.*;

public class ScopeTester {


    public static void main (String[] args)
    {
        JFrame frame = new JFrame("Oscilloscope");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oscilloscope scopeTest = new Oscilloscope();
        JPanel primary = new JPanel();

        primary.add(scopeTest);


        frame.getContentPane().add (primary);
        frame.pack();
        frame.setVisible(true);

     }

}

