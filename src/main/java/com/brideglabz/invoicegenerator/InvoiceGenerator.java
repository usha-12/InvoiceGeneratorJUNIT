package com.brideglabz.invoicegenerator;
public class InvoiceGenerator {
    private static final double Min_Cost_Per_KiloMeter = 10;
    private static final double Cost_per_Time = 1;
    private static final double Minimum_Fare = 5;
    private static final double avgFare =2.0;
    private RideRepository rideRepository;

    public double calculateFare(double distance, double time) {
        double cost = distance * Min_Cost_Per_KiloMeter + time * Cost_per_Time;
        if (cost < Minimum_Fare)
            return Minimum_Fare;
        return cost;
    }

    public double calculateFareForMultipleRides(Ride[] rides) {
        double cost = 0;
        for (Ride ride : rides) {
            cost = cost + this.calculateFare(ride.distance, ride.time);
        }
        return cost;
    }

    public  Invoice_Description calculateFareDescription(Ride[] rides) {
        double cost = 0;
        for (Ride ride : rides) {
            cost = cost + this.calculateFare(ride.distance, ride.time);
        }
        return new Invoice_Description(rides.length, cost,avgFare);
    }

    public Invoice_Description getInvoiceDescription(String userId) {
        return this.calculateFareDescription(rideRepository.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}
