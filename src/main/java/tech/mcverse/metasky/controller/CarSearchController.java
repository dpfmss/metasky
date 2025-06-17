package tech.mcverse.metasky.controller;
import org.springframework.web.bind.annotation.*;
import tech.mcverse.metasky.model.CarResult;
import tech.mcverse.metasky.model.SearchRequest;
import tech.mcverse.metasky.service.CarSearchService;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarSearchController {  private final CarSearchService service;
  public CarSearchController(CarSearchService service) {
    this.service = service;
  }
  @PostMapping("/search")
  public List<CarResult> search(@RequestBody SearchRequest request) {
    return service.search(request);
  }
  @GetMapping({"/", "/home"})
  public String home() {
    return "Metasky car search service\n"
            + "http://localhost:8080/cars/search\n";
  }
}
