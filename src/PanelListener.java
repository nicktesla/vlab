



import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.TransferHandler;

//The constructor of this class registers the JPanel as a drag source
public class PanelListener extends MouseAdapter
{
	private Point clicked;
	private JPanel pane;

	public PanelListener(JPanel pane)
	{
		this.pane = pane;
		clicked = null;
	}

	public Point getSourceClickLocation()
	{
		return clicked;
	}

	public void mousePressed(MouseEvent e)
	{
    	// Assume the source of the event is the JPanel object
		// that has other JPanels living on it

		clicked = e.getPoint();

		//For debugging, delete later
		System.out.println("mousePressed recognized");

		//The subclass of TransferHandler is only called on single mouse clicks
		pane.setTransferHandler(new PanelTransferHandler(clicked));

		//movable may be the draggable panel or the source panel

        JPanel source = (JPanel)e.getSource();
        JPanel movable = (JPanel)source.getComponentAt(clicked);



        // I need to add a code here that checks if the Panel is the holding panel,
        // or the draggable one. The holding Panel is pane

        if( !source.equals(movable))
        {
        	// Initiate a drag
        	// Since JPanel does not support the method setDragEnabled(),
        	// we need to supply a MouseListener that watches for a drag gesture
        	// and then, we call the customized TransferHandler's
        	// exportAsDrag() method.
        	// Note: The drag gesture in this case is a mouse press action
        	// Also,
        	System.out.println("drag recognized"); //For debugging
        	TransferHandler handler = source.getTransferHandler();
        	System.out.println(handler); //For debugging
        	handler.exportAsDrag(source, e, TransferHandler.MOVE);
        }
        // Otherwise (source equals pane), no dragging is allowed

    };
}
