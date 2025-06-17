package tech.mcverse.metasky.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
public class Booking {
  private String bookingId;
  private User user;  // Use User consistently
  private List<BookableItem> items;
  private double totalPrice;
  private BookingStatus status;
  private LocalDateTime bookingDate;
  private LocalDateTime lastModified;
  public enum BookingStatus {
    PENDING, CONFIRMED, CANCELLED, COMPLETED
  }
  public Booking() {
    this.bookingId = UUID.randomUUID().toString();
    this.bookingDate = LocalDateTime.now();
    this.lastModified = LocalDateTime.now();
    this.status = BookingStatus.PENDING;
  }
  public Booking(User user, List<BookableItem> items) {
    this();
    this.user = user;
    this.items = items;
    this.totalPrice = items.stream().mapToDouble(BookableItem::getPrice).sum();
  }
  // Getters and setters using User consistently
  public String getBookingId() { return bookingId; }
  public void setBookingId(String bookingId) { this.bookingId = bookingId; }
  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
  // Deprecated: Keep for backward compatibility but mark as deprecated
  @Deprecated
  public User getClient() { return user; }
  @Deprecated
  public void setClient(User user) { this.user = user; }
  public List<BookableItem> getItems() { return items; }
  public void setItems(List<BookableItem> items) {
    this.items = items;
    this.totalPrice = items.stream().mapToDouble(BookableItem::getPrice).sum();
    this.lastModified = LocalDateTime.now();
  }
  public double getTotalPrice() { return totalPrice; }
  public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
  public BookingStatus getStatus() { return status; }
  public void setStatus(BookingStatus status) {
    this.status = status;
    this.lastModified = LocalDateTime.now();
  }
  public LocalDateTime getBookingDate() { return bookingDate; }
  public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

  public LocalDateTime getLastModified() { return lastModified; }
  public void setLastModified(LocalDateTime lastModified) { this.lastModified = lastModified; }
}