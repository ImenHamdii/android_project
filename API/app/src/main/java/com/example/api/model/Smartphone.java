package com.example.api.model;

import com.google.gson.annotations.SerializedName;

public class Smartphone {
    @SerializedName("marque")
    private String marque;
    @SerializedName("prix")
    private double prix;
    @SerializedName("image")
    private String imageURL;

    public Smartphone(String marque, double prix, String imageURL) {
        this.marque = marque;
        this.prix = prix;
        this.imageURL = imageURL;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImageURL() {
        return "http://172.16.24.235/connexion/smartphone/" +imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

