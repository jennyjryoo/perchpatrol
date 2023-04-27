package PerchPatrol.app.controllers;
import PerchPatrol.app.models.Bird;
import PerchPatrol.app.models.BirdImage;
import PerchPatrol.app.models.Form;
import PerchPatrol.app.models.Location;
import PerchPatrol.app.services.BirdImageService;
import PerchPatrol.app.services.BirdService;
import PerchPatrol.app.services.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class FormController {

    @Autowired
    private CoordinatesService coordinatesService;

    @Autowired
    private BirdService birdService;

    @Autowired
    private BirdImageService birdImageService;

    @PostMapping("submit")
    public Bird[] submitForm(@RequestBody @Validated Form form, Errors errors) {
        if (!errors.hasErrors()) {
            String zipCode = form.getZip();
            Location location = coordinatesService.getCoordinates(zipCode);
            Bird[] birds = birdService.getBirds(location.getLat(), location.getLng(), form.getDistance(), form.getType());
            for (Bird bird : birds) {
                BirdImage image = birdImageService.getImage(bird.getSciName());
                String url = "https://live.staticflickr.com/"+image.getServer()+"/"+image.getId()+"_"+image.getSecret()+".jpg";
                if (image.getId() == null) {
                    bird.setImage("assets/perch.png");
                } else {
                    bird.setImage(url);
                    String ownerUrl = "https://www.flickr.com/photos/"+image.getOwner();
                    bird.setOwnerUrl(ownerUrl);
                }
            }
            return birds;
        } else {
            return new Bird[0];
        }
    }
}
