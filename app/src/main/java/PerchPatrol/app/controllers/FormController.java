package PerchPatrol.app.controllers;
import PerchPatrol.app.models.Bird;
import PerchPatrol.app.models.Location;
import PerchPatrol.app.services.BirdService;
import PerchPatrol.app.services.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class FormController {

    @Autowired
    private CoordinatesService coordinatesService;

    @Autowired
    private BirdService birdService;

    @GetMapping("zip")
    public Location getLocation() {
        return coordinatesService.getCoordinates();
    }

    @GetMapping("bird")
    public Bird[] getBirds() {
        return birdService.getBirds(33.99,-117.53,10);
    }
}
