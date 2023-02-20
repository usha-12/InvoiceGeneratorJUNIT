package com.brideglabz.invoicegenerator;

public class Invoice_Description {
    public int totalNoOfRide;
    public double fare;
    public double avgFare;
    public boolean normalRide;

    public Invoice_Description(int totalNoOfRide, double fare, boolean normalRide) {
        this.totalNoOfRide = totalNoOfRide;
        this.fare = fare;
        this.avgFare = avgFare;
        this.normalRide = normalRide;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Invoice_Description other = (Invoice_Description) obj;
        if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
            return false;
        if (totalNoOfRide != other.totalNoOfRide)
            return false;
        return true;

    }

    @Override
    public String toString() {
        return "Invoice_Description{" +
                "totalNoOfRide=" + totalNoOfRide +
                ", fare=" + fare +
                ", avgFare=" + avgFare +
                ", normalRide=" + normalRide +
                '}';
    }
    }

