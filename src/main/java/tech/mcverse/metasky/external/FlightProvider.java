package tech.mcverse.metasky.external;

import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;

import java.util.List;

public interface FlightProvider {
    String getProviderName();
    List<FlightResult> searchFlights(SearchRequest request);
}
