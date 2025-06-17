package tech.mcverse.metasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.mcverse.metasky.external.FlightProvider;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import java.util.List;

@Service
public class FlightSearchService implements SearchableService<SearchRequest, FlightResult> {

    private final FlightProvider defaultProvider;
    private final FlightAggregatorService aggregatorService;

    public FlightSearchService(
            @Qualifier("mockFlightApiClient") FlightProvider defaultProvider,
            FlightAggregatorService aggregatorService) {
        this.defaultProvider = defaultProvider;
        this.aggregatorService = aggregatorService;
    }

    @Override
    public List<FlightResult> search(SearchRequest request) {
        // Use default provider for regular searches
        return defaultProvider.searchFlights(request);
    }

    // Additional method to search all providers
    public List<FlightResult> searchAllProviders(SearchRequest request) {
        return aggregatorService.searchAllProviders(request);
    }

    // Additional method to search specific provider
    public List<FlightResult> searchProvider(SearchRequest request, String providerName) {
        return aggregatorService.searchSpecificProvider(request, providerName);
    }
}