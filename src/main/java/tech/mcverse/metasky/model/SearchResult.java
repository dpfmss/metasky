// 5. Unified SearchResult wrapper
package tech.mcverse.metasky.model;
import java.util.List;
public class SearchResult {
    private List<FlightResult> flights;
    private List<CarResult> cars;
    private SearchRequest originalRequest;
    private int totalResults;
    public SearchResult() {}
    public SearchResult(List<FlightResult> flights, List<CarResult> cars, SearchRequest originalRequest) {
        this.flights = flights;
        this.cars = cars;
        this.originalRequest = originalRequest;
        this.totalResults = (flights != null ? flights.size() : 0) + (cars != null ? cars.size() : 0);
    }
    // Getters and setters
    public List<FlightResult> getFlights() { return flights; }
    public void setFlights(List<FlightResult> flights) { this.flights = flights; }
    public List<CarResult> getCars() { return cars; }
    public void setCars(List<CarResult> cars) { this.cars = cars; }
    public SearchRequest getOriginalRequest() { return originalRequest; }
    public void setOriginalRequest(SearchRequest originalRequest) { this.originalRequest = originalRequest; }
    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }
}