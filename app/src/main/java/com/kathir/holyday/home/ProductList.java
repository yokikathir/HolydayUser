package com.kathir.holyday.home;

import java.io.Serializable;

public class ProductList implements Serializable{

    private String houseName;
    private String houseDescription;
    private String locationDetails;
    private String wifiEnabled;
    private String ratings;
    private String parking;
    private String swimming;
    private String priceValue;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public String getWifiEnabled() {
        return wifiEnabled;
    }

    public void setWifiEnabled(String wifiEnabled) {
        this.wifiEnabled = wifiEnabled;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getSwimming() {
        return swimming;
    }

    public void setSwimming(String swimming) {
        this.swimming = swimming;
    }

    public String getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(String priceValue) {
        this.priceValue = priceValue;
    }
}
