package tech.mcverse.metasky.model;

public class StatusUpdateRequest {
    private Booking.BookingStatus status;
    public StatusUpdateRequest() {}
    public StatusUpdateRequest(Booking.BookingStatus status) {
        this.status = status;
    }
    public Booking.BookingStatus getStatus() { return status; }
    public void setStatus(Booking.BookingStatus status) { this.status = status; }
}