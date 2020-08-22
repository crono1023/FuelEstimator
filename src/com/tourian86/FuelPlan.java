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
    double altTotalHours;
    double tripDistance;
    TimeMS time;
    double cruiseSpeed;
    double fuelBurn;
    double alternateDistance;
    double blockFuel;


    public FuelPlan(Scanner scnr) {
        String userInput = null;

        while(true){
            System.out.print("Taxi fuel (gallons): ");
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

            System.out.print("\nTrip Distance (NM): ");
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

            System.out.print("\nEstimated Cruise Speed (gs)(knots): ");
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
            System.out.print("\nAircraft fuel burn rate (galons/hr): ");
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

        while(true){
            System.out.print("Distance from destination to alternate airport (NM): ");
            userInput = scnr.nextLine();

            if(userInput.equals("")){
                alternateDistance = 0;
                break;
            }

            try{
                alternateDistance = Double.parseDouble(userInput);
                break;
            }
            catch (NumberFormatException except) {
                System.out.println("Please enter a valid distance in nautical miles.");
                continue;
            }
        }

        // Calculate estimated trip time
        totalHours = tripDistance / cruiseSpeed;
        time = new TimeMS(totalHours);

        // Calculate trip fuel
        trip = fuelBurn * totalHours;

        System.out.printf("Trip Time: %d:%d\n", time.hours(), time.minutes());
        System.out.printf("Trip Fuel: %.2f\n", trip);

        //Calculate contingency fuel
        contingency = Math.ceil(trip * 0.05);

        altTotalHours = alternateDistance / cruiseSpeed;
        alternate = altTotalHours * fuelBurn;

        System.out.printf("Alternate Fuel: %.2f\n", alternate);

        // Calculate final reserve based on cruise fuel burn estimate.
        finalReserve = 0.75 * fuelBurn;

        System.out.printf("Final Reserve: %.2f\n", finalReserve);

        // Calculate total (block fuel)
        blockFuel = taxi + trip + contingency + alternate + finalReserve;

        System.out.printf("Block Fuel: %.2f", blockFuel);


    }
}
