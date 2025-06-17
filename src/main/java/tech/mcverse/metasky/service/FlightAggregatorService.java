package tech.mcverse.metasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mcverse.metasky.external.FlightProvider;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import java.util.List;
import java.util.ArrayList;

@Service
public class FlightAggregatorService {
    private final List<FlightProvider> providers;
    @Autowired
    public FlightAggregatorService(List<FlightProvider> providers) {
        this.providers = providers;
    }
    public List<FlightResult> searchAllProviders(SearchRequest request) {
        List<FlightResult> allResults = new ArrayList<>();

        for (FlightProvider provider : providers) {
            try {
                List<FlightResult> results = provider.searchFlights(request);
                allResults.addAll(results);
            } catch (Exception e) {
                /** Log error and continue with other services**/
                System.err.println("Error with provider " + provider.getProviderName() + ": " + e.getMessage());
            }
        }
        return allResults;
    }
    public List<FlightResult> searchSpecificProvider(SearchRequest request, String providerName) {
        return providers.stream()
                .filter(provider -> provider.getProviderName().equals(providerName))
                .findFirst()
                .map(provider -> provider.searchFlights(request))
                .orElse(new ArrayList<>());
    }
}