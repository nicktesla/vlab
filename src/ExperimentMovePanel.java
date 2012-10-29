



import java.awt.*;
import javax.swing.*;

public class ExperimentMovePanel extends ExperimentPanel
{


	private Point clicked = null;
        private Point[] clickCollection = null;
        private PanelListener mouseListener;

        public ExperimentMovePanel(){
            super();
            mouseListener = new PanelListener(this);
            addMouseListener(mouseListener);
            clicked = mouseListener.getSourceClickLocation();

            //Ikenna says he need to make collection of Points..:)
        }

        public Point getCurrentClickedPoint()
        {
            return clicked;
        }

// to be implemented later

        public Point[] getClickCollection()
        {
            return clickCollection;

        }

 //override  methods that set the panel displacements in parent class in order to
 // keep track of terminals.

 // need to actually set the displacements placeBar, placeScope, placeBulb;
 //by getting displacement vector of the panel corners from drag and drop methods.

public Point changeBarCorner(){


   barCorner.x = barCorner.x + placeBar.x;
    barCorner.y = barCorner.y + placeBar.y;

      //move left bar terminal
     leftBarTerminalX.x = barCorner.x + metal.getLeftTerminalX().x;
     leftBarTerminalX.y =  barCorner.x + metal.getLeftTerminalX().y;
     leftBarTerminalY.x = barCorner.y + metal.getLeftTerminalY().x;
     leftBarTerminalY.y = barCorner.y + metal.getLeftTerminalY().y;
    //move right bar Terminal
     rightBarTerminalX.x = barCorner.x + metal.getRightTerminalX().x;
     rightBarTerminalX.y =  barCorner.x + metal.getRightTerminalX().y;
     rightBarTerminalY.x = barCorner.y + metal.getRightTerminalY().x;
     rightBarTerminalY.y = barCorner.y + metal.getRightTerminalY().y;


  
            return barCorner;

}

public Point changeScopeCorner(){

    scopeCorner.x = scopeCorner.x + placeScope.x;
    scopeCorner.y = scopeCorner.y + placeScope.y;


 //move ch1 terminal
    scopeTerminal1X.x = scopeCorner.x + scope.getCH1TerminalX().x;
    scopeTerminal1X.y =  scopeCorner.x + scope.getCH1TerminalX().y;
    scopeTerminal1Y.x = scopeCorner.y + scope.getCH1TerminalY().x;
    scopeTerminal1Y.y = scopeCorner.y + scope.getCH1TerminalY().y;
    //move ch2 Terminal
    scopeTerminal2X.x = scopeCorner.x + scope.getCH2TerminalX().x;
    scopeTerminal2X.y =  scopeCorner.x + scope.getCH2TerminalX().y;
    scopeTerminal2Y.x = scopeCorner.y + scope.getCH2TerminalY().x;
    scopeTerminal2Y.y = scopeCorner.y + scope.getCH2TerminalY().y;

    // move ground Terminals

    scopeTerminalgX.x = scopeCorner.x + scope.getGrTerminalX().x;
    scopeTerminalgX.y =  scopeCorner.x + scope.getGrTerminalX().y;
    scopeTerminalgY.x = scopeCorner.y + scope.getGrTerminalY().x;
    scopeTerminalgY.y = scopeCorner.y + scope.getGrTerminalY().y;


    return scopeCorner;
}

public Point changeBulbCorner(){

    bulbCorner.x = bulbCorner.x + placeBulb.x;
    bulbCorner.y = bulbCorner.y + placeBulb.y;

    //move bulb terminal
    bulbTerminalX.x = bulbCorner.x + b.getBulbTerminalX().x;
    bulbTerminalX.y =  bulbCorner.x + b.getBulbTerminalX().y;
    bulbTerminalY.x = bulbCorner.y + b.getBulbTerminalY().x;
    bulbTerminalY.y = bulbCorner.y + b.getBulbTerminalY().y;


    return bulbCorner;
}





}
