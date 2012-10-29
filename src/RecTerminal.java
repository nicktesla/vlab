/*
 * Terminal Object that is used in various instruments
 * A Terminal is a rectangular or circular boundary with a given polarity.
 */

/**
 *
 * @author Debo Olaosebikan/Ikenna Odinaka
 */

import java.awt.*;
import javax.swing.*;



public class RecTerminal extends Rectangle {

// POSITIVE_TERMINAL = 1;NEGATIVE_TERMINAL = -1.
	private static final int GROUND_TERMINAL = 0;
	private int termValue;

	// Constructor for the class:

	// Default constructor
	// Rectangular terminal with given polarity
	public RecTerminal(int value, Color rect_Color, int rect_CenterX, int rect_CenterY, int height, int width)
        {
        super(rect_Color, rect_CenterX, rect_CenterY, height, width);
	termValue = value;
         
	}
        
         // Not needed but included for completeness
	public void setTerminal(int value){
		termValue = value;
	}

	// Retrieve the type of terminal
	public int getTermPolarity(){
		return termValue;
	}

        //access the terminal boundaries

        //endpoints of a horizontal line drawn from one vertical end of the box to the other

        public Point getBoundaryX(){
            Point p = new Point();
            p.x = box_CenterX-(box_Width/2);
            p.y = box_CenterX+(box_Width/2);
            return p;
                    }
//endpoints of a vertical line drawn from one horizontal edge of the box to the other
        public Point getBoundaryY(){
            Point p = new Point();
            p.x = box_CenterY-(box_Height/2);
            p.y = box_CenterY+(box_Height/2);
            return p;
                    }
        }

