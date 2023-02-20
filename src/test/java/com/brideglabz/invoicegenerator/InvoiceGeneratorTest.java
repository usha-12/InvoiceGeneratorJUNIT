package com.brideglabz.invoicegenerator;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator  invoiceGenerator = new InvoiceGenerator();
    @BeforeAll
    public static void printBeforeAllMsg() {
        System.out.println("-------Welcome to the Cab Invoice Generator Program-------");
    }
    @AfterEach
    public void PrintAfterEachTestCasePass(){
        System.out.println("passed");
    }
    @Test
    public void givenDistanceAndTime_shouldReturn_CalculateFare() {
        double distance = 2.0;
        double time = 5.0;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.0, fare, 0.0);
    }
    @Test
    public void givenLessDistanceAndTime_shouldReturn_MinimumCalculateFare() {
        double distance = 0.1;
        double time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRides_shouldReturn_invoiceCost() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        double fare = invoiceGenerator.calculateFareForMultipleRides(rides);
        Assert.assertEquals(30.0, fare, 0.0);
    }
    @Test
    public void givenMultipleRides_shouldReturn_invoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        Invoice_Description actualDescription = invoiceGenerator.calculateFareDescription(rides);
        Invoice_Description expectedDescription = new  Invoice_Description(2, 30.0,2.0);
        Assert.assertEquals(expectedDescription, actualDescription);
    }
}
