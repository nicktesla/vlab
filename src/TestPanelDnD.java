



import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPanelDnD
{


	public static void main(String args[])
	{

		JFrame frame = new JFrame("Drag and Drop Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        JPanel pane = new JPanel();
        pane.setLayout(null);

        JPanel move = new JPanel();
        move.setBounds(100,100,100,100);
	    move.setBackground(Color.blue);
	    move.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


	     pane.add(move);

	     // Add a drag source to the JPanel
	     new PanelDragAndDrop(pane);
	     contentPane.add(pane);
	     frame.setSize(600, 600);
	     frame.setVisible(true);

	}

}
