package PerchPatrol.app.controllers;
import PerchPatrol.app.models.Bird;
import PerchPatrol.app.models.Form;
import PerchPatrol.app.models.Location;
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

    @PostMapping("submit")
    public Bird[] submitForm(@RequestBody @Validated Form form, Errors errors) {
        String zipCode = form.getZip();
        Location location = coordinatesService.getCoordinates(zipCode);
        Bird[] birds = birdService.getBirds(location.getLat(), location.getLng(), form.getDistance());
        return birds;
    }

}
