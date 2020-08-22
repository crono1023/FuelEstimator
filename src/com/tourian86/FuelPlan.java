package com.tourian86;

import java.util.Scanner;

public class FuelPlan {

    // Fields
    double taxi;
    double trip;
    double contingency;
    double alternate;
    double finalReserve;
    double additional;
    double totalHours;
    double tripDistance;
    TimeMS time;
    double cruiseSpeed;
    double fuelBurn;


    public FuelPlan(Scanner scnr) {
        String userInput = null;

        while(true){
            System.out.println("Taxi fuel (gallons): ");
            userInput = scnr.nextLine();

            if(userInput.equals("")){
                taxi = 2;
                break;
            }
            try{
                taxi = Double.parseDouble(userInput);
                break;
            }
            catch (NumberFormatException except)
            {
                System.out.println("Please enter a valid number of gallons.");
                continue;
            }
        }

        while(true){

            System.out.println("\nTrip Distance (NM): ");
            userInput = scnr.nextLine();

            try{
                tripDistance = Double.parseDouble(userInput);
                break;
            }
            catch (NumberFormatException except){
                System.out.println("Please enter a valid distance in nautical miles (NM)");
                continue;
            }
        }

        while(true){

            System.out.println("\nEstimated Cruise Speed (gs)(knots): ");
            userInput = scnr.nextLine();

            try{
                cruiseSpeed = Double.parseDouble(userInput);
                break;
            }
            catch (NumberFormatException except){
                System.out.println("Please enter a valid speed in knots.");
                continue;
            }
        }

        while(true){
            System.out.println("\nAircraft fuel burn rate (galons/hr): ");
            userInput = scnr.nextLine();

            try{
                fuelBurn = Double.parseDouble(userInput);
                break;
            }
            catch (NumberFormatException except) {
                System.out.println("Please enter a valid fuel burn rate in gallons.");
                continue;
            }
        }

        // Calculate estimated trip time
        totalHours = tripDistance / cruiseSpeed;
        time = new TimeMS(totalHours);

        // Calculate trip fuel
        trip = Math.ceil(fuelBurn * totalHours);

        System.out.printf("Trip Time: %d:%d\n", time.hours(), time.minutes());
        System.out.printf("Trip Fuel: %.2f\n", trip);


    }
}
