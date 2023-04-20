package PerchPatrol.app.services;

import PerchPatrol.app.models.Bird;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BirdService {
    @Value("${apiKeyBirds}")
    String apiKeyBirds;

    public Bird[] getBirds(Double lat, Double lng, int dist) {

        HttpHeaders header = new HttpHeaders();
        header.add("x-ebirdapitoken", this.apiKeyBirds);
        HttpEntity<Object> entity = new HttpEntity<Object>(header);

        String urlPart1 = "https://api.ebird.org/v2/data/obs/geo/recent/notable?";
        String urlPart2 = "&back=7&dist=";
        String newUrl = urlPart1+"lat="+lat+"&lng="+lng+urlPart2+dist;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Bird[]> response = restTemplate.exchange(newUrl, HttpMethod.GET, entity, Bird[].class);
        return response.getBody();
    }

}
