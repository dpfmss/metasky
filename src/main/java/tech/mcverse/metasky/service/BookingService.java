// 6. Enhanced BookingService using Repository
package tech.mcverse.metasky.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mcverse.metasky.model.*;
import tech.mcverse.metasky.repository.BookingRepo;
import tech.mcverse.metasky.repository.UserRepo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService {
  private final BookingRepo bookingRepo;
  private final UserRepo userRepo;
  @Autowired
  public BookingService(BookingRepo bookingRepo, UserRepo userRepo) {
    this.bookingRepo = bookingRepo;
    this.userRepo = userRepo;
  }

  public Booking createBooking(User user, List<BookableItem> items) {
    // Ensure user exists in repository
    if (user.getUserId() == null || !userRepo.existsById(user.getUserId())) {
      user = userRepo.save(user);
    }

    Booking booking = new Booking(user, items);
    return bookingRepo.save(booking);
  }

  public Optional<Booking> getBooking(String bookingId) {
    return bookingRepo.findById(bookingId);
  }

  public List<Booking> getBookingsForUser(String userId) {
    return bookingRepo.findByUserId(userId);
  }

  // Deprecated: Keep for backward compatibility
  @Deprecated
  public List<Booking> getBookingsForClient(String clientId) {
    return getBookingsForUser(clientId);
  }

  public Booking updateBookingStatus(String bookingId, Booking.BookingStatus status) {
    Optional<Booking> bookingOpt = bookingRepo.findById(bookingId);
    if (bookingOpt.isPresent()) {
      Booking booking = bookingOpt.get();
      booking.setStatus(status);
      return bookingRepo.save(booking);
    }
    return null;
  }

  public boolean cancelBooking(String bookingId) {
    Optional<Booking> bookingOpt = bookingRepo.findById(bookingId);
    if (bookingOpt.isPresent()) {
      Booking booking = bookingOpt.get();
      if (booking.getStatus() != Booking.BookingStatus.COMPLETED) {
        booking.setStatus(Booking.BookingStatus.CANCELLED);
        bookingRepo.save(booking);
        return true;
      }
    }
    return false;
  }

  public List<Booking> getAllBookings() {
    return bookingRepo.findAll();
  }

  // Additional useful methods
  public List<Booking> getBookingsByStatus(Booking.BookingStatus status) {
    return bookingRepo.findByStatus(status);
  }

  public List<Booking> getRecentBookings(int days) {
    LocalDateTime since = LocalDateTime.now().minusDays(days);
    LocalDateTime now = LocalDateTime.now();
    return bookingRepo.findByBookingDateBetween(since, now);
  }

  public long getTotalBookings() {
    return bookingRepo.count();
  }
}