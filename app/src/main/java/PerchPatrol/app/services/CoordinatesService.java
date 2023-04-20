package PerchPatrol.app.services;

import PerchPatrol.app.models.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URL;

@Service
public class CoordinatesService {

    @Value("${apiKeyZip}")
    String apiKeyZip;
    public Location getCoordinates(){

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Location location = objectMapper.readValue(new URL("https://www.zipcodeapi.com/rest/"+this.apiKeyZip+"/info.json/91752/degrees"),Location.class);
            return location;
        } catch (IOException e) {
            e.printStackTrace();
            Location location = new Location();
            return location;
        }
    }

}
