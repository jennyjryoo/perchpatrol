package PerchPatrol.app.models;

public class Form {

    private String zip;
    private int distance;

    public Form() {}

    public Form(String zip, int distance) {
        this.zip = zip;
        this.distance = distance;
    }


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
