package tech.mcverse.metasky.external;

import org.springframework.stereotype.Component;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;

import java.util.Arrays;
import java.util.List;

@Component
public class AirFranceClient implements FlightProvider {

    @Override
    public String getProviderName() {
        return "AirFrance";
    }

    @Override
    public List<FlightResult> searchFlights(SearchRequest request) {
        return Arrays.asList(
                new FlightResult("AirFrance", 220.0, request.getFrom(), request.getTo(), "07:45", "11:05")
        );
    }
}
