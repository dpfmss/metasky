package tech.mcverse.metasky.model;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightResult implements BookableItem {
    private String flightId;
    private String airline;
    private double price;
    private String from;
    private String to;
    @JsonFormat(pattern = "dd-MM-yyy HH:mm ")
    private LocalDateTime departureTime;
    @JsonFormat(pattern = "dd-MM-yyy HH:mm ")
    private LocalDateTime arrivalTime;
    private String flightNumber;
    private int availableSeats;

    public FlightResult() {}
    public FlightResult(String flightId, String airline, double price, String from, String to,
                        LocalDateTime departureTime, LocalDateTime arrivalTime, String flightNumber) {
        this.flightId = flightId;
        this.airline = airline;
        this.price = price;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
    }

    public FlightResult(String airFrance, double v, String from, String to, String time, String time1) {
    }

    @Override
    public String getId() { return flightId; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getType() { return "FLIGHT"; }

    @Override
    public String getDescription() {
        return String.format("%s - %s to %s (%s)", airline, from, to, flightNumber);
    }

    // Getters and setters
    public String getFlightId() { return flightId; }
    public void setFlightId(String flightId) { this.flightId = flightId; }

    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public void setPrice(double price) { this.price = price; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}