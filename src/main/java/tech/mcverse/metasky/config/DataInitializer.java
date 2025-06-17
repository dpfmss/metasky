// 10. Data Initialization Component
package tech.mcverse.metasky.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.mcverse.metasky.repository.UserService;
import tech.mcverse.metasky.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Metasky MVP Data Initialized ===");
        System.out.println("Total Users: " + userService.getTotalUsers());
        System.out.println("Available endpoints:");
        System.out.println("- GET /api/users (get all users)");
        System.out.println("- POST /api/search (search flights/cars)");
        System.out.println("- POST /api/book (create booking)");
        System.out.println("- GET /api/booking/{id} (get booking)");
        System.out.println("=====================================");
    }
}