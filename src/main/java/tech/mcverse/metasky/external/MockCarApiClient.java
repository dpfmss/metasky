package tech.mcverse.metasky.external;
import org.springframework.stereotype.Component;
import tech.mcverse.metasky.model.CarResult;
import tech.mcverse.metasky.model.SearchRequest;
import java.util.Arrays;
import java.util.List;
@Component
public class MockCarApiClient {
    public List<CarResult> getCars(SearchRequest request) {
        return Arrays.asList(
                new CarResult("Toyota Yaris", 77.0, request.getFrom(), request.getTo(), "08:00", "11:00"),
                new CarResult("WV Gold 8", 97.5, request.getFrom(), request.getTo(), "09:30", "12:30"),
                new CarResult("Tesla Model S", 123.6, request.getFrom(), request.getTo(), "10:00", "12:00")
            );
    }
}
