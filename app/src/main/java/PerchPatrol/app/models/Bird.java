package PerchPatrol.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bird {

    private String comName;
    private String sciName;
    private String obsDt;
    private String howMany;

    private String image;

    private String ownerUrl;

    public Bird() {}

    public Bird(String comName, String sciName, String obsDt, String howMany, String ownerUrl) {
        this.comName = comName;
        this.sciName = sciName;
        this.obsDt = obsDt;
        this.howMany = howMany;
        this.image = "";
        this.ownerUrl = ownerUrl;
    }

    public String getComName() {
        return comName;
    }

    public String getSciName() {
        return sciName;
    }

    public String getObsDt() {
        return obsDt;
    }

    public String getHowMany() {
        return howMany;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "comName='" + comName + '\'' +
                ", sciName='" + sciName + '\'' +
                ", obsDt='" + obsDt + '\'' +
                ", howMany='" + howMany + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void setSciName(String sciName) {
        this.sciName = sciName;
    }

    public void setObsDt(String obsDt) {
        this.obsDt = obsDt;
    }

    public void setHowMany(String howMany) {
        this.howMany = howMany;
    }

    public String getOwnerUrl() {
        return ownerUrl;
    }

    public void setOwnerUrl(String ownerUrl) {
        this.ownerUrl = ownerUrl;
    }
}
