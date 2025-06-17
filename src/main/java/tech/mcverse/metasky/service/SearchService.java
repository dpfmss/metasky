package tech.mcverse.metasky.service;

import org.springframework.stereotype.Service;
import tech.mcverse.metasky.model.*;
import java.util.List;
import java.util.Collections;

@Service
public class SearchService {
    private final FlightSearchService flightSearchService;
    private final CarSearchService carSearchService;

    public SearchService(FlightSearchService flightSearchService, CarSearchService carSearchService) {
        this.flightSearchService = flightSearchService;
        this.carSearchService = carSearchService;
    }

    public SearchResult search(SearchRequest request) {
        List<FlightResult> flights = Collections.emptyList();
        List<CarResult> cars = Collections.emptyList();

        switch (request.getSearchType()) {
            case FLIGHT:
                flights = flightSearchService.search(request);
                break;
            case CAR:
                cars = carSearchService.search(request);
                break;
            case BOTH:
                flights = flightSearchService.search(request);
                cars = carSearchService.search(request);
                break;
        }

        return new SearchResult(flights, cars, request);
    }
}