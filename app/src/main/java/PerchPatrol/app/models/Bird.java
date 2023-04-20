package PerchPatrol.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bird {

    private String comName;
    private String sciName;
    private String obsDt;
    private String howMany;

    public Bird() {}

    public Bird(String comName, String sciName, String obsDt, String howMany) {
        this.comName = comName;
        this.sciName = sciName;
        this.obsDt = obsDt;
        this.howMany = howMany;
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
}
