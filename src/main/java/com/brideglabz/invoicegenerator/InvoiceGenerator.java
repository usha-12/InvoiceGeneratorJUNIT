package com.brideglabz.invoicegenerator;
public class InvoiceGenerator {
    private static final double normalRide_Min_Cost_Per_KiloMeter = 10;
    private static final int normalRide_Cost_per_Time = 1;
    private static final double normalRide_Minimum_Fare = 5;
    private static final double Premium_Min_Cost_Per_KiloMeter = 15;
    private static final int Premium_Cost_per_Time = 2;
    private static final double Premium_Minimum_Fare = 20;
    private RideRepository rideRepository;


    public double calculateFareForRideType(double distance, int time, boolean normalRide) {
        if (normalRide) {
            double cost = distance * normalRide_Min_Cost_Per_KiloMeter + time * normalRide_Cost_per_Time;
            if (cost < normalRide_Minimum_Fare)
                return normalRide_Minimum_Fare;
            return cost;
        } else {
            double cost = distance * Premium_Min_Cost_Per_KiloMeter + time * Premium_Cost_per_Time;
            if (cost < Premium_Minimum_Fare)
                return Premium_Minimum_Fare;
            return cost;
        }

    }
    public double calculateFareForMultipleRides(Ride[] rides, boolean normalRide) {
        double cost = 0;
        for (Ride ride : rides) {
            cost = cost + this.calculateFareForRideType(ride.distance, ride.time, ride.rideType);
        }
        return cost;

    }
    public Invoice_Description calculateFareDescription(Ride[] rides, boolean normalRide) {
        double cost = 0;
        for (Ride ride : rides) {
            cost = cost + this.calculateFareForRideType(ride.distance, ride.time, ride.rideType);
        }
        return new Invoice_Description(rides.length, cost, normalRide);
    }

    public Invoice_Description getInvoiceDescription(String userId, boolean normalRide) {
        return this.calculateFareDescription(rideRepository.getRides(userId), normalRide);
    }


    public void addRides(String userId, Ride[] rides, boolean normalRide) {
        rideRepository.addRides("abc@gmail.com", rides);
    }
}
