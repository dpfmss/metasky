package tech.mcverse.metasky.controller;

import org.springframework.web.bind.annotation.*;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import tech.mcverse.metasky.service.FlightSearchService;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightSearchController {

    private final FlightSearchService service;

    public FlightSearchController(FlightSearchService service) {
        this.service = service;
    }

    @PostMapping("/search")
    public List<FlightResult> search(@RequestBody SearchRequest request) {
        return service.searchFlights(request);
    }
}
