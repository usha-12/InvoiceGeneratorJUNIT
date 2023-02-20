package com.brideglabz.invoicegenerator;

public class Invoice_Description {
    public int totalNoOfRide;
    public double fare;
    public double avgFare;

    public Invoice_Description(int totalNoOfRide, double fare, double avgFare) {
        this.totalNoOfRide = totalNoOfRide;
        this.fare = fare;
        this.avgFare = avgFare;
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
    }

