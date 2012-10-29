/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class SliderPanel  extends JPanel {
private JSlider HscaleSlide, VscaleSlide;
 private JLabel hLabel, vLabel;
 private JPanel scales;
 
 int xscale, yscale;
 
 public SliderPanel(){
     
     xscale =1;
     yscale=1;

    HscaleSlide = new JSlider (JSlider.HORIZONTAL,0,4,0);
    HscaleSlide.setMajorTickSpacing(2);
    HscaleSlide.setMinorTickSpacing(1);
    HscaleSlide.setPaintTicks(true);
    HscaleSlide.setPaintLabels(true);
    HscaleSlide.setAlignmentX(Component.LEFT_ALIGNMENT);

    VscaleSlide = new JSlider (JSlider.HORIZONTAL,0,4,0);
    VscaleSlide.setMajorTickSpacing(2);
    VscaleSlide.setMinorTickSpacing(1);
    VscaleSlide.setPaintTicks(true);
    VscaleSlide.setPaintLabels(true);
    VscaleSlide.setAlignmentX(Component.LEFT_ALIGNMENT);

    ScaleListener listener = new ScaleListener();
    HscaleSlide.addChangeListener(listener);
    VscaleSlide.addChangeListener(listener);

    hLabel = new JLabel("Time Scale: 1 ms/div");
    hLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    vLabel = new JLabel ("Voltage Scale: 1 V/div");
    vLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

    scales = new JPanel();
    BoxLayout layout = new BoxLayout (scales, BoxLayout.Y_AXIS);
    scales.setLayout(layout);
    scales.add(hLabel);
    scales.add(HscaleSlide);
    scales.add(Box.createRigidArea(new Dimension(0,20)));
    scales.add(vLabel);
    scales.add(VscaleSlide);
    add(scales);

    setBackground(Color.white);
    setPreferredSize(new Dimension(50,50));

 }

 public int getHor(){
     return HscaleSlide.getValue();
 }

  public int getVer(){
     return VscaleSlide.getValue();
 }
  


 private class ScaleListener implements ChangeListener{



    public void stateChanged (ChangeEvent event){

        xscale = HscaleSlide.getValue();
        yscale = VscaleSlide.getValue();

        hLabel.setText("Time Scale: " + xscale + " " + "ms/div");
        vLabel.setText("Voltage Scale: " + yscale + " " + "V/div");

    }

}


}
