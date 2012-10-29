/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.awt.event.*;
import javax.swing.*;

public class ConnectionsListener implements ActionListener {

   ExperimentPanel a;
   BarPost b;
   private int i;
   private  int DELAY;
   private int GRAV;
   private  int y;

    public ConnectionsListener(ExperimentPanel x, BarPost y, int DEL, int accn ){
        a = x;
        b = y;
        DELAY = DEL;
        GRAV = accn;
    }


     public void actionPerformed(ActionEvent event) {

       i=0;
       a.add(b);
       int directn = (int) Math.signum(Math.sin(Math.PI*i*DELAY/(Math.sqrt(2*b.getINITBarHeight()/GRAV))));
       y = b.getBarHeight()+(GRAV/2)*i*(DELAY)*(DELAY)*directn;
       b.setBarHeight(y);
        a.remove(b);
       i++;
   }


}
