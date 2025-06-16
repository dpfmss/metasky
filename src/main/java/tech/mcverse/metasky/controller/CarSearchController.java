package tech.mcverse.metasky.controller;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.mcverse.metasky.model.CarResult;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;
import tech.mcverse.metasky.service.CarSearchtService;
import tech.mcverse.metasky.service.FlightSearchService;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarSearchController {
  @Autowired
  private final CarSearchtService service;
  public CarSearchController(CarSearchtService service) {
    this.service = service;
  }
  @RequestMapping("/search")
  @GetMapping("/begindate")
  public List<CarResult> search(@RequestBody SearchRequest request) {
    //return "Search Result";
    return service.searchcars(request);
  }
  @GetMapping("/length")
  public List<CarResult> length(@RequestBody SearchRequest request) {}
}
