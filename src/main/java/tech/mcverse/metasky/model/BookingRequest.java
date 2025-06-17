package tech.mcverse.metasky.model;
import java.util.List;

public class BookingRequest {
    private User user;
    private List<BookableItem> items;

    public BookingRequest() {}

    public BookingRequest(User user, List<BookableItem> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // Deprecated: Keep for backward compatibility
    @Deprecated
    public User getClient() { return user; }
    @Deprecated
    public void setClient(User user) { this.user = user; }

    public List<BookableItem> getItems() { return items; }
    public void setItems(List<BookableItem> items) { this.items = items; }
}