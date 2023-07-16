package com.mycompany.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

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

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Your Name: ");
        String name = keyboard.nextLine();
            
            Calendar time = Calendar.getInstance();
            System.out.println(MESSAGE + "there, " + decodePeriod(time) + "!");
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            System.out.println("Now:" + dtf.format(now));
        
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
}
