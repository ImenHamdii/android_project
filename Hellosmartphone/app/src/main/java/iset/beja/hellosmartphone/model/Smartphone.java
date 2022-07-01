package iset.beja.hellosmartphone.model;

import com.google.gson.annotations.SerializedName;

public class Smartphone {
    @SerializedName("marque")
    private String marque;
    @SerializedName("prix")
    private double prix;
    @SerializedName("image")
    private String imageURL;

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
        return "http://172.16.22.123/connexion/smartphone/"+imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
