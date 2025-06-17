// Search controller unifier pour vols et voitures
package tech.mcverse.metasky.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.mcverse.metasky.model.*;
import tech.mcverse.metasky.service.SearchService;
import tech.mcverse.metasky.service.BookingService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    private final SearchService searchService;
    private final BookingService bookingService;
    public SearchController(SearchService searchService, BookingService bookingService) {
        this.searchService = searchService;
        this.bookingService = bookingService;
    }
    @PostMapping("/search")
    public ResponseEntity<SearchResult> search(@RequestBody SearchRequest request) {
        SearchResult result = searchService.search(request);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/book")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {
        Booking booking = bookingService.createBooking(request.getUser(), request.getItems());
        return ResponseEntity.ok(booking);
    }
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable String bookingId) {
        return bookingService.getBooking(bookingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{userId}/bookings")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String userId) {
        List<Booking> userBookings = bookingService.getBookingsForUser(userId);
        return ResponseEntity.ok(userBookings);
    }
    @PutMapping("/booking/{bookingId}/status")
    public ResponseEntity<Booking> updateBookingStatus(
            @PathVariable String bookingId,
            @RequestBody StatusUpdateRequest request) {
        Booking booking = bookingService.updateBookingStatus(bookingId, request.getStatus());
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable String bookingId) {
        boolean cancelled = bookingService.cancelBooking(bookingId);
        return cancelled ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    @GetMapping("/")
    public String home() {

        return "Metasky - Flight metasearch engine: \n" +
                "/search\n" +
                "/book\n" +
                "/booking/{bookingId}\n" +
                "/user/{userId}/bookings\n" +
                "/booking/{bookingId}/status\n" +
                "/booking/{bookingId}\n";
    }
}