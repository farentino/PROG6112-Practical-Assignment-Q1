/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progq1;

/**
 *
 * @author Faren
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PROGQ1 {
    ArrayList<String> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Capture a new series
    public void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age Restriction: ");
        String ageRestriction = scanner.nextLine();
        System.out.print("Enter Number of Episodes: ");
        String episodes = scanner.nextLine();

        String series = "SERIES ID: " + id + "\nSERIES NAME: " + name +
                        "\nSERIES AGE RESTRICTION: " + ageRestriction +
                        "\nNUMBER OF EPISODES: " + episodes;
        seriesList.add(series);

        System.out.println("Series captured successfully!");
    }

    // Search for a series
    public void SearchSeries() {
        System.out.print("Enter Series Name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (String series : seriesList) {
            if (series.contains(searchName)) {
                System.out.println("Series found:\n" + series);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Series not found.");
        }
    }

    // Update series age restriction
    public void UpdateSeries() {
        System.out.print("Enter Series Name to update age restriction: ");
        String searchName = scanner.nextLine();
        boolean updated = false;

        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).contains(searchName)) {
                System.out.print("Enter new Age Restriction: ");
                String newAge = scanner.nextLine();
                String updatedSeries = seriesList.get(i).replaceAll("SERIES AGE RESTRICTION: \\d+", "SERIES AGE RESTRICTION: " + newAge);
                seriesList.set(i, updatedSeries);
                System.out.println("Age restriction updated successfully!");
                updated = true;
            }
        }
        if (!updated) {
            System.out.println("Series not found.");
        }
    }

    // Delete a series
    public void DeleteSeries() {
        System.out.print("Enter Series Name to delete: ");
        String searchName = scanner.nextLine();
        boolean removed = seriesList.removeIf(series -> series.contains(searchName));

        if (removed) {
            System.out.println("Series deleted successfully!");
        } else {
            System.out.println("Series not found.");
        }
    }

    // Print series report
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.");
        } else {
            System.out.println("Series Report - 2025");
            int count = 1;
            for (String series : seriesList) {
                System.out.println("Series " + count++);
                System.out.println(series + "\n");
            }
        }
    }

    // Exit application
    public void ExitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
}

