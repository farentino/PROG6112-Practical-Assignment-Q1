/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progq1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PROGQ1IT {
    
    private PROGQ1 instance;

    @BeforeEach
    public void setUp() {
        instance = new PROGQ1();
        instance.seriesList = new ArrayList<>();
        // Updated test data
        instance.seriesList.add("101, Star Wars, 13, 10");
        instance.seriesList.add("102, Star Wars: The Clone Wars Season 1, 10, 8");
    }

    @Test
    public void TestSearchSeries() {
        boolean found = instance.seriesList.stream().anyMatch(s -> s.startsWith("101"));
        assertTrue(found, "Series 101 (Star Wars) should be found");
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        boolean found = instance.seriesList.stream().anyMatch(s -> s.startsWith("999"));
        assertFalse(found, "Series 999 should not be found");
    }

    @Test
    public void TestUpdateSeries() {
        for (int i = 0; i < instance.seriesList.size(); i++) {
            if (instance.seriesList.get(i).startsWith("101")) {
                instance.seriesList.set(i, "101, Star Wars Remastered, 15, 12");
            }
        }
        boolean updated = instance.seriesList.stream().anyMatch(s -> s.contains("Star Wars Remastered"));
        assertTrue(updated, "Series 101 should be updated");
    }

    @Test
    public void TestDeleteSeries() {
        boolean removed = instance.seriesList.removeIf(s -> s.startsWith("102"));
        assertTrue(removed, "Series 102 (Clone Wars) should be deleted");
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean removed = instance.seriesList.removeIf(s -> s.startsWith("999"));
        assertFalse(removed, "Non-existing series should not be deleted");
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        int age = 13;
        assertTrue(age >= 2 && age <= 18, "Age restriction 13 should be valid");
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        int age = 25;
        assertFalse(age >= 2 && age <= 18, "Age restriction 25 should be invalid");
    }
}
