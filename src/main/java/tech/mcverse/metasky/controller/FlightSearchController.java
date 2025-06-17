package tech.mcverse.metasky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import tech.mcverse.metasky.service.FlightSearchService;

import java.util.List;
@RestController
@RequestMapping("/api/flights")
public class FlightSearchController {
    @Autowired
    private final FlightSearchService service;
    public FlightSearchController(FlightSearchService service) {
        this.service = service;
    }
    @PostMapping("/search")
    public List<FlightResult> search(@RequestBody SearchRequest request) {
        //return "Search Result";
        return service.search(request);
    }
    @GetMapping ({"/","home"})
    public String home (){
        return "Metasky flight metasearch engine service";
    }
}
