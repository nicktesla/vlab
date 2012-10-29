



import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;


@SuppressWarnings("serial")
public class PanelTransferHandler extends TransferHandler
{
	// A variable that holds the location of the
	// mouse during mouse press
	private Point clicked;

	//A static field that holds a reference to a DataFlavor that
	//represents a JPanel. The DataFlavor represents JPanel
	//as a java.lang.Class object.

	private static DataFlavor jPanelFlavor =
	new DataFlavor(javax.swing.JPanel.class, "Swing JPanel");
   //in case this doesn't work, use javax.swing.JPanel.class

	// Only ONE data flavor is accepted
	private static final DataFlavor flavors[] = {jPanelFlavor};

	// Add a constructor for the class
	//Check this!
	public PanelTransferHandler(Point clicked)
	{
		this.clicked = clicked;
	}


	// Only MOVE operation is supported
	public int getSourceActions(JComponent c)
	{
		return TransferHandler.MOVE;
	}

    // Anonymous Transferable inner class
	// Modify this if needed
	public Transferable createTransferable(JComponent comp)
	{

		if (comp instanceof JPanel)
		{
			JPanel panel = (JPanel)comp;

			//get component at panel
            final JPanel movable = (JPanel)panel.getComponentAt(clicked);

            if(movable instanceof JPanel)
            {
    			Transferable transferable = new Transferable()
    			{

    				public Object getTransferData(DataFlavor flavor)
    				{
    					//This method comes from Transferable and shall return our JPanel
        				//in the given flavor.

    					if (isDataFlavorSupported(flavor))
    					{
    						return movable;
    					}
    					return null;
    				}

    				public DataFlavor[] getTransferDataFlavors()
    				{
    					//This method comes from Transferable and shall return an
    					//array of DataFlavors containing all the supported
    					//DataFavors. We only support one.

    					return flavors;
    				}


    				public boolean isDataFlavorSupported(DataFlavor flavor)
    				{
    					//This method comes from Transferable and will tell
    					//whether the given DataFlavor is supported.

    					return flavor.equals(jPanelFlavor);

    				}

    			};

    			return transferable;
            }
		}

		return null;
	}


/* Another version of canImport

	public boolean canImport(JComponent comp, DataFlavor flavor[])
	{System.out.println("Checking to see if the release point can accept data");
		if (!(comp instanceof JPanel))
		{
			System.out.println("Not the right object");
			return false;
		}
		for (int i=0, n=flavor.length; i<n; i++)
		{
			for (int j=0, m=flavors.length; j<m; j++)
			{
				if (flavor[i].equals(flavors[j]))
				{
					System.out.println("Yay! The right object");
					return true;
				}
			}
      	}
		System.out.println("Not the right object");
		return false;
	}
*/
	public boolean canImport(TransferSupport supp)
	{
		System.out.println("Checking to see if the release point can accept data");
	    // Check for JPanel flavor
	    if (!supp.isDataFlavorSupported(jPanelFlavor))
	    {
	        return false;
	    }

	    // Return whether we accept the location
	    return shouldAcceptDropLocation(supp);
	}

/* Another version of importData

	public boolean importData(JComponent comp, Transferable t)
	{
		if (comp instanceof JPanel)
		{
			JPanel panel = (JPanel)comp;
			// Check that the selected flavor is supported
			if (t.isDataFlavorSupported(flavors[0]))
			{
				try
				{
					JPanel movable = (JPanel)t.getTransferData(flavors[0]);
					return true;
				}
				catch (UnsupportedFlavorException ignored)
				{
					// Does nothing
				}
				catch (IOException ignored)
				{
					// Does nothing
				}
			}
      }
      return false;
	}
*/
	public boolean importData(TransferSupport supp)
	{
	    if (!canImport(supp))
	    {
	        return false;
	    }

	    // Fetch the Transferable and its data
	    Transferable t = supp.getTransferable();

	    try
		{
			JPanel data = (JPanel)t.getTransferData(jPanelFlavor);

		    // Insert the data at this location
		    insertAt(supp, data);

			return true;
		}
		catch (UnsupportedFlavorException ignored)
		{
			System.out.println("The data import was not successful");
			return false;
		}
		catch (IOException ignored)
		{
			System.out.println("The data import was not successful");
			return false;
		}

	}


	//Clean up source of drag
	public void exportDone(JComponent c,Transferable data,int action)
	{
		/*
		 * Parameters:
	    	c - the component that was the source of the data
			data - The data that was transferred or possibly null if the action is NONE.
			action - the actual action that was performed
		 */
		JPanel source = (JPanel)c;
		JPanel toBeDeleted = (JPanel)source.getComponentAt(clicked);
		if (action == TransferHandler.MOVE)
		{
	        source.remove(toBeDeleted);
	        //validate since a change has been made to the JPanel
	        source.validate();
		}

	}


	//Helper methods
	public boolean shouldAcceptDropLocation(TransferSupport supp )
	{
		// Fetch the drop location
	    DropLocation loc = supp.getDropLocation();
	    Point click = loc.getDropPoint();
	    JPanel panel = (JPanel)supp.getComponent();
	    JPanel movable = (JPanel)panel.getComponentAt(click);
	    if(movable == panel)
	    {
	    	System.out.println("Yay! The right object");
	    	return true;
	    }

    	return false;
	}

	// assume the panel uses the GridBagLayout
	// the mouse location determines the gridx, gridy points
	public void insertAt(TransferSupport supp, JPanel data)
	{
		//For debugging, delete later
		System.out.println("Attempting to drop");
	    // Fetch the drop location
	    DropLocation loc = supp.getDropLocation();

	    // Change this to a Point object
	    Point click = loc.getDropPoint();

	    // Fetch the component that accepts drops
	    JPanel panel = (JPanel)supp.getComponent();

	    //Insert the component at the mouse location

	    panel.add(data);

	    data.setLocation(click);

	    // validate, since the drop panel has been modified
	    panel.validate();
	}

}



