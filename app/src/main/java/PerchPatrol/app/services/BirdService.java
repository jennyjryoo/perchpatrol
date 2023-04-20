package PerchPatrol.app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class BirdService {
    @Value("${apiKeyBirds}")
    String apiKeyBirds;

    public ResponseEntity<String> getBirds() {
        HttpHeaders header = new HttpHeaders();
        header.add("x-ebirdapitoken", this.apiKeyBirds);
        HttpEntity<Object> entity = new HttpEntity<Object>(header);
        String url = "https://api.ebird.org/v2/data/obs/geo/recent/notable?lat=33.98&lng=-117.53&back=7&dist=5";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

}
