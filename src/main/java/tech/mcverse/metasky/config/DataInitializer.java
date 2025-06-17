// Initialisation of components for the MVP
package tech.mcverse.metasky.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.mcverse.metasky.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Metasky MVP donnée initialisé ===");
        System.out.println("Utilisateurs : " + userService.getTotalUsers());
        System.out.println("Les endpoints disponible:");
        System.out.println("- GET /api/users (retournes tous les utilisateurs)");
        System.out.println("- POST /api/search (recherche vols/voiture)");
        System.out.println("- POST /api/book (creation d'une reservation booking)");
        System.out.println("- GET /api/booking/{id} (retourne une reservation booking)");
        System.out.println("=====================================");
    }
}