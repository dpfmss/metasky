package tech.mcverse.metasky.service;
import org.springframework.stereotype.Service;
import tech.mcverse.metasky.external.MockCarApiClient;
import tech.mcverse.metasky.model.CarResult;
import tech.mcverse.metasky.model.SearchRequest;
import java.util.List;

@Service
public class CarSearchService implements SearchableService<SearchRequest, CarResult> {
  private final MockCarApiClient client;
  public CarSearchService(MockCarApiClient client) {
    this.client = client;
  }
  @Override
  public List<CarResult> search(SearchRequest request) {
    return client.getCars(request);
  }
}