package tech.mcverse.metasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import tech.mcverse.metasky.external.MockFlightApiClient;
import java.util.List;

@Service
public class FlightSearchService {
@Autowired
    private final MockFlightApiClient client;
    public FlightSearchService(MockFlightApiClient client) {
        this.client = client;
    }
    public List<FlightResult> searchFlights(SearchRequest request) {
        return client.getFlights(request);
    }
};
