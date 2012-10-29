/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author levelz
 */
import java.util.*;
public class MathExerciser {

    //randomly generates pairs for multiplication and keeps track of scores

    public static void main (String[] args){
       int score=0;
       int noquestions=10;
       long time;
       time = System.currentTimeMillis();
        for(int i=1; i<noquestions+1; i++){
        Random no1, no2;
        no1 = new Random();
        no2 = new Random();
        int times, timesIn, first, second;
        Scanner product = new Scanner(System.in);
        first = no1.nextInt(20);
        second= no2.nextInt(20);
        times = first*second;
        System.out.println("What is " + first + " times " + second);
        timesIn = product.nextInt();
        if(timesIn==times){
            System.out.println("Correct!");
            score++;
        }
        else
            System.out.println("Wrong!");}
       time = System.currentTimeMillis()-time;
       System.out.println("Your Final Score is " + score + " out of " + noquestions);
       System.out.println("It took you a total time of " + time + " milliseconds");
       
    }

}
