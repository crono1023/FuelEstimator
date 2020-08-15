package com.tourian86;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double currentFuel = 0;
        double estimateFuelBurn = 0;
        double cruiseSpeedKnots = 0;

        //Todo implement
        double reserve = 0;
        double taxiAndTakeoffFuel = 0;

        double time;
        double rawHours;
        short hours;
        short minutes;
        short seconds;
        short range;

        String userInput;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.print("\n\nCurrent fuel level(Gallons): ");
            userInput = scnr.nextLine();
            try {
                currentFuel = Double.parseDouble(userInput);
            } catch (NumberFormatException except) {
                printBadInputMsg();
                continue;
            }
            inputValid = true;
        }

        inputValid = false;

        while (!inputValid){
            System.out.print("Estimated fuel burn (Gallons/hr): ");
            userInput = scnr.nextLine();
            try {
                estimateFuelBurn = Double.parseDouble(userInput);
            } catch (NumberFormatException except) {
                printBadInputMsg();
                continue;
            }
            inputValid = true;
        }

        inputValid = false;
        while(!inputValid)
        {
            System.out.print("Estimated Cruise Speed (Knots): ");
            userInput = scnr.nextLine();
            try {
                cruiseSpeedKnots = Double.parseDouble(userInput);
            } catch (NumberFormatException except) {
                printBadInputMsg();
                continue;
            }

            inputValid = true;
        }
        time = currentFuel / estimateFuelBurn;

        rawHours = time;

        if(time > 0 && time < 1)
        {
            hours = 0;
        }
        else {
            hours = (short)time;
            time -= hours;
        }

        time *= 60;
        minutes = (short)time;
        time -= minutes;

        time *= 60;
        seconds = (short)time;

        range = (short)(cruiseSpeedKnots * rawHours);

        if(hours > 0)
            System.out.printf("\n\n%d hour(s) ", hours);
        System.out.printf("%d minute(s) ",minutes);
        System.out.printf("%d second(s)\n", seconds);

        System.out.printf("Approximate Range: %d NM\n\n", range);



    }
    public static void printBadInputMsg(){
        System.out.println("Enter a valid number.");
    }
}
