package tech.mcverse.metasky.model;
import org.apache.catalina.User;
import java.time.LocalDateTime;

public class Payment {
  private int id;
  private Booking booking;
  private User user;  // Use your User class consistently
  private LocalDateTime paymentDate;
  private String description;
  private PaymentStatus status;
  private double amount;
  private PaymentMethod paymentMethod;

  public enum PaymentStatus {
    PENDING, COMPLETED, FAILED, REFUNDED
  }

  public enum PaymentMethod {
    CREDIT_CARD, DEBIT_CARD, PAYPAL, BANK_TRANSFER
  }

  public Payment() {
    this.paymentDate = LocalDateTime.now();
    this.status = PaymentStatus.PENDING;
  }

  public Payment(Booking booking, User user) {
    this();
    this.booking = booking;
    this.user = user;
    this.amount = booking.getTotalPrice();
    this.description = "Payment for booking " + booking.getBookingId();
  }

  // Getters and setters
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public Booking getBooking() { return booking; }
  public void setBooking(Booking booking) { this.booking = booking; }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }

  public LocalDateTime getPaymentDate() { return paymentDate; }
  public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public PaymentStatus getStatus() { return status; }
  public void setStatus(PaymentStatus status) { this.status = status; }

  public double getAmount() { return amount; }
  public void setAmount(double amount) { this.amount = amount; }

  public PaymentMethod getPaymentMethod() { return paymentMethod; }
  public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
}
