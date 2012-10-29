/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.awt.*;
import javax.swing.*;

public class Schematic extends JPanel {
    
    JLabel label;
    ImageIcon schematic;
    
    public Schematic(){
        
        schematic = new ImageIcon("Schematic.gif");
        label = new JLabel ("Faraday Effect Experiment Schematic", schematic, SwingConstants.CENTER);
        add(label);
        setBackground(Color.white);
        setPreferredSize(new Dimension(400,400));
    }


}
