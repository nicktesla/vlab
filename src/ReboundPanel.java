import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReboundPanel extends JPanel
{
    private final int WIDTH =300, HEIGHT =100;
    private final int DELAY =20, RADIUS=50, ALIVE = 1, DEAD = 0;
    private int life_state;
    private Circle balloon;
    private Timer timer;
    private int x, y, moveX, moveY;
    private float an, da;
    private final float INIT_BRIGHT=(float)0.05;
    Color c = new Color((float)1.0,(float)1.0,(float)0,an);



    //sets up panel and timer for animation
    public ReboundPanel()
    {
        timer = new Timer(DELAY, new ReboundListener());
        x=0;
        y=0;
        life_state=DEAD;
        an = INIT_BRIGHT;
        da=(float) 0.01;
        moveX = moveY =10;
        setPreferredSize (new Dimension(WIDTH, HEIGHT));
        setBackground (Color.black);
        clickListener Listener = new clickListener();
        addMouseListener(Listener);
          timer.start();
        
    }
    //draws the image in current location
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        balloon = new Circle(c, (WIDTH/2), (HEIGHT/2), RADIUS);
        balloon.draw(page);

            }
    //represents mouse click listener for starting the timer

    private class clickListener extends MouseAdapter{
        public void mouseClicked (MouseEvent event){
          if(life_state==DEAD)
            life_state=ALIVE;
          else{
              life_state=DEAD;
              }
        }
    }

    public void changeColor(float hue){
        c = new Color((float)1.0,(float)1.0,(float)0,hue);

    }
    //represents the action listener for the timer
    private class ReboundListener implements ActionListener{
        //updates the position of the image

        public void actionPerformed (ActionEvent event)
        {
            if(life_state==ALIVE)
            {
            an+= da;
            
            if (an<=(float)0.01 || an>= (float)0.9)
                da = da * -1;
            changeColor(an);
            repaint();
            }
            else{
                an = INIT_BRIGHT;
              changeColor(an);
              repaint();
            }

        }

    }
}