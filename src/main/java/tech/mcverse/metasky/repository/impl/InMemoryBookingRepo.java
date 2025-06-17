package tech.mcverse.metasky.repository.impl;
import org.springframework.stereotype.Repository;
import tech.mcverse.metasky.model.Booking;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import tech.mcverse.metasky.repository.BookingRepo;
import java.util.*;
import java.util.stream.Collectors;
@Repository
public class InMemoryBookingRepo implements BookingRepo {
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();
    @Override
    public Booking save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Optional<Booking> findById(String id) {
        return Optional.ofNullable(bookings.get(id));
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookings.values());
    }

    @Override
    public void deleteById(String id) {
        bookings.remove(id);
    }

    @Override
    public boolean existsById(String id) {
        return bookings.containsKey(id);
    }

    @Override
    public long count() {
        return bookings.size();
    }

    @Override
    public List<Booking> findByUserId(String userId) {
        return bookings.values().stream()
                .filter(booking -> booking.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findByStatus(Booking.BookingStatus status) {
        return List.of();
    }

    @Override
    public List<Booking> findByBookingDateBetween(LocalDateTime start, LocalDateTime end) {
        return List.of();
    }

    @Override
    public List<Booking> findByUserIdAndStatus(String userId, Booking.BookingStatus status) {
        return List.of();
    }

}