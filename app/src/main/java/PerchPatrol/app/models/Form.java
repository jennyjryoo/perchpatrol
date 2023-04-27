package PerchPatrol.app.models;

public class Form {

    private String zip;
    private int distance;

    private String type;

    public Form() {}

    public Form(String zip, int distance, String type) {
        this.zip = zip;
        this.distance = distance;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
