package tech.mcverse.metasky.service;

import org.springframework.stereotype.Service;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import tech.mcverse.metasky.external.MockFlightApiClient;

import java.util.List;

@Service
public class FlightSearchService {

    private final MockFlightApiClient client;

    public FlightSearchService(MockFlightApiClient client) {
        this.client = client;
    }

    public List<FlightResult> searchFlights(SearchRequest request) {
        return client.getFlights(request);
    }
}
