



import java.awt.Point;
import javax.swing.JPanel;

public class PanelDragAndDrop
{
	private JPanel pane;
	private Point clicked = null;
	private Point[] clickCollection = null;
	private PanelListener mouseListener;

	public PanelDragAndDrop(JPanel pane)
	{
		this.pane = pane;
		this.mouseListener = new PanelListener(this.pane);
		this.pane.addMouseListener(mouseListener);
		this.clicked = mouseListener.getSourceClickLocation();
		//add code that creates a collection of Points

	}

	public Point getCurrentClickedPoint()
	{
		return clicked;
	}

	//Implement this later
	public Point[] getClickCollection()
	{
		return clickCollection;
	}









}

