package PerchPatrol.app.services;

import PerchPatrol.app.models.BirdImage;
import PerchPatrol.app.models.FlickrPhotos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class BirdImageService {
    @Value("${apiKeyFlickr}")
    private String apiKeyFlickr;

    public BirdImage getImage(String name) {

        String[] nameArray = name.split(" ");
        String newName = nameArray[0]+"%20"+nameArray[1];

        ObjectMapper objectMapper = new ObjectMapper();
        try {
                FlickrPhotos photos = objectMapper.readValue(new URL("https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key="+this.apiKeyFlickr+"&text="+newName+"&license=2%2C3%2C4%2C5%2C6%2C7%2C8%2C9%2C10&privacy_filter=1&safe_search=1&content_type=1&format=json&nojsoncallback=1&per_page=1"),FlickrPhotos.class);
                BirdImage[] images = photos.getPhotos().getPhoto();
                BirdImage image = images[0];
                return image;
        } catch (IOException e) {
                e.printStackTrace();
                BirdImage image = new BirdImage();
                return image;
            }

    }

}
