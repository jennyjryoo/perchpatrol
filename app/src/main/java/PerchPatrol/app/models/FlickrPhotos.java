package PerchPatrol.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FlickrPhotos {

    private FlickrPhoto photos;

    public FlickrPhotos(){}

    public FlickrPhotos(FlickrPhoto photos) {
        this.photos = photos;
    }


    public FlickrPhoto getPhotos() {
        return photos;
    }

    public void setPhotos(FlickrPhoto photos) {
        this.photos = photos;
    }
}
