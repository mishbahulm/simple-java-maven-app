package com.mycompany.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Hello world!
 */
public class App {

    public static final String AM = "good morning";
    public static final String PM = "good afternoon";
    public static final String EVE = "good evening";
    private static final String MESSAGE = "Hello ";

    public App() {}

    public static void main(String[] args) {

        System.out.println(MESSAGE);

        // Scanner keyboard = new Scanner(System.in);

        // int computerNumber = (int) (Math.random()*100 + 1);
        // int userAnswer = 0;
        // // System.out.println("The correct guess would be " + computerNumber);
        // int count = 1;

        // System.out.print("Your Name: ");
        // String name = keyboard.nextLine();

        // Calendar time = Calendar.getInstance();
        // System.out.println(MESSAGE + name + ", " + decodePeriod(time) + "!");
        // System.out.println("Try to guess the number for less than a minute.");

        // while (userAnswer != computerNumber)
        // {
        //     System.out.println("========= Guessing Game =========");
        //     System.out.print("Enter a guess (between 1 and 100): ");

        //     try {
        //         userAnswer = keyboard.nextInt();

        //         System.out.println(determineGuess(userAnswer, computerNumber, count, name));

        //         count++;
                
        //     } catch (Exception e) {
        //         System.out.println("Wrong format!\n" + e);
        //         break;
        //     }
            
        // }  

    }

    public String getMessage() {
        return MESSAGE;
    }

    /**
     * Determines if we're in the morning or afternoon
     * 
     * @param time the time to decode.
     * @return String representing the period of the day.
     * 
     * source: http://www.java2s.com/example/java/java.util/determines-if-were-in-the-morning-or-afternoon.html
     */

    public static String decodePeriod(final Calendar time) {
        String decodedPeriod = null;
        int hour = time.get(Calendar.HOUR_OF_DAY);
        if (hour >= 18) {
            decodedPeriod = EVE;
        } else if (hour >= 12) {
            decodedPeriod = PM;
        } else {
            decodedPeriod = AM;
        }
        return decodedPeriod;
    }


    // source: https://hackr.io/blog/java-projects
    public static String determineGuess(int userAnswer, int computerNumber, int count, String name){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct! " + name + ", you awesome. \nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}
