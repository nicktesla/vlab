/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Questions extends JPanel {
     private String[][] questionList;
     private JButton nextQ;
     private JLabel currentScore, currentQuestion;
     private JTextField currentAnswer;
     private int score=0;
     private int questCurr=0;
          
    public Questions(){

        questionList = new String[2][2];
        
        questionList[0][0]="What is the value of Pi?";
        questionList[0][1]="3";
        questionList[1][0]="Who made reasonable Doubt";
        questionList[1][1]="Jay-Z";
        ResponseListener response = new ResponseListener();
        
        score=0;
        questCurr=0;
        nextQ = new JButton("Next");
        nextQ.addActionListener(response);
        currentScore = new JLabel("Current Score: " + score);
        currentQuestion = new JLabel(questionList[questCurr][0]);
        currentAnswer = new JTextField(20);
        currentAnswer.addActionListener(response);
        
        add(currentQuestion);
        add(currentAnswer);
        add(currentScore);
        add(nextQ);

        setPreferredSize (new Dimension(400,400));
        setBackground (Color.white);

          }

          
          public String getQuestion(){

              return currentQuestion.getText();
          }

         

          private class ResponseListener implements ActionListener{

              public void actionPerformed(ActionEvent event){
                if (event.getSource()==currentAnswer){
                String text = currentAnswer.getText();
                if(text.compareTo(questionList[questCurr][1])==0);
                score++;
                currentScore.setText("Current Score: " + score); 
                }
                    else if(questCurr<1)
                  questCurr++;
                  currentQuestion.setText(questionList[questCurr][0]);
                  currentScore.setText("Current Score: " + score);
              }


          }
}
