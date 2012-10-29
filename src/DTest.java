
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

public class DTest
{
	public static void main(String[] args) 
	{
	    JFrame frame = new JFrame("DTest!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    

	    JPanel panel = new JPanel(new BorderLayout());
	    panel.setBackground(new Color(200,200,255));
	    

	        panel.add(new DKnob(), BorderLayout.CENTER);
	    
                frame.getContentPane().setLayout(new BorderLayout());
	        frame.getContentPane().add(panel, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
	  
	}
}


