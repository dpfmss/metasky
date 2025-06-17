// 9. Enhanced Mock Data for Flight/Car APIs
package tech.mcverse.metasky.external;
import org.springframework.stereotype.Component;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class MockFlightApiClient implements FlightProvider {
    private final Random random = new Random();
    @Override
    public String getProviderName() {
        return "MockFlightAPI";
    }
    @Override
    public List<FlightResult> searchFlights(SearchRequest request) {
        // Generate more realistic flight data
        LocalDateTime baseDate = request.getDate().atTime(6, 0); // Start at 6 AM
        return Arrays.asList(
                createFlight("MOCK001", "SkyJet", 199.0 + random.nextInt(100),
                        request.getFrom(), request.getTo(), baseDate.plusHours(2), "SJ101"),
                createFlight("MOCK002", "AirStar", 210.5 + random.nextInt(80),
                        request.getFrom(), request.getTo(), baseDate.plusHours(4), "AS202"),
                createFlight("MOCK003", "SkyBird", 166.0 + random.nextInt(120),
                        request.getFrom(), request.getTo(), baseDate.plusHours(6), "SB303"),
                createFlight("MOCK004", "CloudWings", 185.0 + random.nextInt(90),
                        request.getFrom(), request.getTo(), baseDate.plusHours(8), "CW404"),
                createFlight("MOCK005", "JetStream", 220.0 + random.nextInt(70),
                        request.getFrom(), request.getTo(), baseDate.plusHours(10), "JS505")
        );
    }
    private FlightResult createFlight(String id, String airline, double price,
                                      String from, String to, LocalDateTime departure, String flightNumber) {
        LocalDateTime arrival = departure.plusHours(3); // 3-hour flight
        FlightResult flight = new FlightResult(id, airline, price, from, to, departure, arrival, flightNumber);
        flight.setAvailableSeats(50 + random.nextInt(200));
        return flight;
    }
    // Deprecated: Keep for backward compatibility
    @Deprecated
    public List<FlightResult> getFlights(SearchRequest request) {
        return searchFlights(request);
    }
}