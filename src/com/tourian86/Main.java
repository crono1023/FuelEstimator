package com.tourian86;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double currentFuel = 0;
        double estimateFuelBurn = 0;
        double cruiseSpeedKnots = 0;


        double time;
        double rawHours;
        short hours;
        short minutes;
        short seconds;
        short range;
        String userInput;
        
        printMenu();
        System.out.print("Enter selection: ");
        userInput = scnr.nextLine();
        if (userInput == "1")
            estimateFuelNeeded(scnr);
        else if (userInput == "2")
            estimateFlightTime(scnr);
        


    }
    public static void printBadInputMsg(){
        System.out.println("Enter a valid number.");
    }

    private static double distanceToHours(double distance, double cruiseSpeed){
        return distance/cruiseSpeed;
    }

    private static int timeToGallons(double time, double fuelBurn)
    {
        return ((int)(time * fuelBurn)+1);
    }



    private static double gallonsToHours(double gallons, double fuelBurn)
    {
        return gallons/fuelBurn;
    }


    
    private static void printMenu(){
        System.out.print("\n\n");
        System.out.println("=================");
        System.out.println("==  Main Menu  ==");
        System.out.println("=================");
        System.out.print("\n\n");
        System.out.println("1) Estimate Fuel Needed");
        System.out.println("2) Estimate flight time and distance remaining");
        System.out.print("\n\n");
    }

    private static void estimateFlightTime(Scanner scnr)
    {
        double currentFuel = 0;
        double rawHours;
        double estimateFuelBurn = 1;
        double cruiseSpeedKnots = 0;
        double time;
        short hours, minutes, seconds, range;
        String userInput;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.print("Current fuel level(Gallons): ");
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
            System.out.printf("%d hour(s)\n", hours);
        System.out.printf("%d minute(s)\n",minutes);
        System.out.printf("%d second(s)\n", seconds);

        System.out.printf("Range: %d NM", range);

    }
    
    private static void estimateFuelNeeded(Scanner scnr){
        double distance = 0;
        double cruiseSpeed = 0;
        double fuelBurn = 0;
        int fuelNeeded;
        double hours;
        boolean inputValid = false;
        String userInput;

        while(!inputValid) {
            System.out.println("\n\n");
            System.out.print("Distance (NM): ");
            userInput = scnr.nextLine();
            try{
                distance = Double.parseDouble(userInput);
            }
            catch (NumberFormatException except){
                System.out.println("Error: Error parsing user input.");
            }
            inputValid = true;
        }
        inputValid = false;

        while(!inputValid)
        {
            System.out.print("Estimated fuel burn (Gallons/hour): ");
            userInput = scnr.nextLine();

            try{
                fuelBurn = Double.parseDouble(userInput);
            }
            catch (NumberFormatException except){
                System.out.println("Error. Error parsing user input.");
            }
            inputValid = true;
        }

        inputValid = false;

        while(!inputValid)
        {
            System.out.print("\nEstimated Cruise Speed (knots): ");
            userInput = scnr.nextLine();

            try {
                cruiseSpeed = Double.parseDouble(userInput);
            }
            catch (NumberFormatException except)
            {
                System.out.println("Error: Error parsing user input.");
            }
            inputValid = true;
        }
        hours = distanceToHours(distance, cruiseSpeed);
        fuelNeeded = timeToGallons(hours, fuelBurn);
        System.out.printf("\n\nFuel Needed: %d gallons\n\n", fuelNeeded);
    }
}