/*
 * Allows for dragging, depicts all objects,
 * checks connections and tells all objects to start running
 */

/**
 *
 * @author levelz
 */

import javax.swing.*;

public class Experiment {
 

    public static void main (String[] args)
    {
        JFrame frame = new JFrame("Experimental Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ExperimentPanel experiment = new ExperimentPanel();
        Schematic picture = new Schematic();
        Questions questions = new Questions();
       

        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Active Experiment", experiment);
        tp.addTab("Schematic", picture);
        tp.addTab("Questions", questions);

            
        frame.getContentPane().add (tp);
        frame.pack();
        frame.setVisible(true);

        System.out.println(questions.getQuestion());
       
     }

}
