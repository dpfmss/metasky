package tech.mcverse.metasky.model;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
public class SearchRequest {
    private String from;
    private String to;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate; // for car rentals
    private int passengers; // for flights
    private SearchType searchType;
    public enum SearchType {
        FLIGHT, CAR, BOTH
    }

    // Constructors
    public SearchRequest() {}

    public SearchRequest(String from, String to, LocalDate date, SearchType searchType) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.searchType = searchType;
    }

    // Getters and setters
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public int getPassengers() { return passengers; }
    public void setPassengers(int passengers) { this.passengers = passengers; }

    public SearchType getSearchType() { return searchType; }
    public void setSearchType(SearchType searchType) { this.searchType = searchType; }
}
