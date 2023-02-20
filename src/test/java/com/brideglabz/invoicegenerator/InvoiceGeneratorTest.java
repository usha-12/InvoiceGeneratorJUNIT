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
    public void givenDistanceAndTime_shouldReturnCalculateFareForNormalRide() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFareForRideType(distance, time, true);
        Assert.assertEquals(25.0, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnCalculateFalseFareForPremiumRide() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFareForRideType(distance, time, false);
        Assert.assertEquals(40.0, fare, 0.0);
    }

    @Test
    public void givenRides_shouldReturnInvoiceCostForNormalRide() {

        Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        double fare = invoiceGenerator.calculateFareForMultipleRides(rides, true);
        Assert.assertEquals(30.0, fare, 0.0);
    }

    @Test
    public void givenRides_shouldReturnInvoiceCostForPremiumRide() {

        Ride[] rides = { new Ride(2.0, 5, false), new Ride(0.1, 1, false) };
        double fare = invoiceGenerator.calculateFareForMultipleRides(rides, false);
        Assert.assertEquals(60.0, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceDescriptionForNormalRide() {
        Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        Invoice_Description actualDescription = invoiceGenerator.calculateFareDescription(rides, true);
        Invoice_Description expectedDescription = new Invoice_Description(2, 30.0, true);
        Assert.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceDescriptionForPremiumRide() {
        Ride[] rides = { new Ride(2.0, 5, false), new Ride(0.1, 1, false) };
        Invoice_Description actualDescription = invoiceGenerator.calculateFareDescription(rides, false);
        Invoice_Description expectedDescription = new Invoice_Description(2, 60.0, false);
        Assert.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void givenUserId_shouldReturnInvoiceDescriptionListForNormalRide() {
        String userId = "abc@gmail.com";
        Ride[] rides = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        invoiceGenerator.addRides("abc@gmail.com", rides, true);
        Ride[] rides1 = { new Ride(2.0, 5, true), new Ride(0.1, 1, true) };
        invoiceGenerator.addRides(userId, rides1, true);
        Invoice_Description actualDescription = invoiceGenerator.getInvoiceDescription(userId, true);
        Invoice_Description expectedDescription = new Invoice_Description(2, 30.0, true);
        Assert.assertEquals(expectedDescription, actualDescription);
    }
}
