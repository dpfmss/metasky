// 3. Booking Repository Interface
package tech.mcverse.metasky.repository;

import tech.mcverse.metasky.model.Booking;
import tech.mcverse.metasky.model.Booking.BookingStatus;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepo extends BaseRepo<Booking, String> {
    List<Booking> findByUserId(String userId);
    List<Booking> findByStatus(BookingStatus status);
    List<Booking> findByBookingDateBetween(LocalDateTime start, LocalDateTime end);
    List<Booking> findByUserIdAndStatus(String userId, BookingStatus status);
}
