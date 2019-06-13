package com.shankar.model;

/**
 * Model class holds the zip code range into two instance fields lowerzip and upperzip
 */
public class ZipCode {

    String lowerBoundZip;
    String upperBoundZip;

    public ZipCode() {
    }

    public ZipCode(String lowerBoundZip, String upperBoundZip) {
        this.lowerBoundZip = lowerBoundZip;
        this.upperBoundZip = upperBoundZip;
    }

    public String getLowerBoundZip() {
        return lowerBoundZip;
    }

    public void setLowerBoundZip(String lowerBoundZip) {
        this.lowerBoundZip = lowerBoundZip;
    }

    public String getUpperBoundZip() {
        return upperBoundZip;
    }

    public void setUpperBoundZip(String upperBoundZip) {
        this.upperBoundZip = upperBoundZip;
    }
}
