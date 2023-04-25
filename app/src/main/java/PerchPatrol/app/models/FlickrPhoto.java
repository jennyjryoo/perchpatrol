package PerchPatrol.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrPhoto {
    private BirdImage[] photo;

    public FlickrPhoto() {}

    public FlickrPhoto(BirdImage[] photo) {
        this.photo = photo;
    }

    public BirdImage[] getPhoto() {
        return photo;
    }

    public void setPhoto(BirdImage[] photo) {
        this.photo = photo;
    }
}
