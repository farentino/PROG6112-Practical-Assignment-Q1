/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progq1;

/**
 *
 * @author Faren
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PROGQ1 progApp = new PROGQ1();

        System.out.println("Latest Series - 2025");
        System.out.println("****************************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit:");

        if (scanner.hasNextInt() && scanner.nextInt() == 1)//Got scanner from W3schools 
        {
            int choice = 0;

            // Loop until user selects Exit
            while (choice != 6) {
                System.out.println("\nPlease select one of the following menu items:");
                System.out.println("(1) Capture a new series");
                System.out.println("(2) Search for a series");
                System.out.println("(3) Update series age restriction");
                System.out.println("(4) Delete a series");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application");

                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> progApp.CaptureSeries();
                    case 2 -> progApp.SearchSeries();
                    case 3 -> progApp.UpdateSeries();
                    case 4 -> progApp.DeleteSeries();
                    case 5 -> progApp.SeriesReport();
                    case 6 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Exiting...!");
        }
    }
}