/*
 * Terminal Object that is used in various instruments
 * A Terminal is a rectangular or circular boundary with a given polarity.
 */

/**
 *
 * @author Ikenna Odinaka
 */

import java.awt.*;




public class CircTerminal extends Circle {

// POSITIVE_TERMINAL = 1;NEGATIVE_TERMINAL = -1.
	private static final int GROUND_TERMINAL = 0;
	private int termValue;

	// Constructor for the class:

	// Default constructor
	// Rectangular terminal with given polarity
	public CircTerminal(int value, Color circ_Color, int circ_CenterX, int circ_CenterY, int radius)
        {
        super(circ_Color, circ_CenterX, circ_CenterY, radius);
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

        public Point getBoundaryX(){
            Point p = new Point();
            p.x = round_CenterX-(round_rad);
            p.y = round_CenterX+(round_rad);
            return p;
                    }

        public Point getBoundaryY(){
            Point p = new Point();
            p.x = round_CenterY-(round_rad);
            p.y = round_CenterY+(round_rad);
            return p;
                    }
        }

