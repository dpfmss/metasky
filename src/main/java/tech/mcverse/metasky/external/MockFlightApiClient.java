package tech.mcverse.metasky.external;

import org.springframework.stereotype.Component;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;

import java.util.List;
import java.util.Arrays;

@Component
public class MockFlightApiClient {

    public List<FlightResult> getFlights(SearchRequest request) {
        return Arrays.asList(
                new FlightResult("SkyJet", 199.0, request.getFrom(), request.getTo(), "08:00", "11:00"),
                new FlightResult("AirStar", 210.5, request.getFrom(), request.getTo(), "09:30", "12:30"),
                new FlightResult("SkyBird", 166.0, request.getFrom(), request.getTo(), "10:00", "12:00")
            );
    }
}
