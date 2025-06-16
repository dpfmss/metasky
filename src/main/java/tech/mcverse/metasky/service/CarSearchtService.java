package tech.mcverse.metasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mcverse.metasky.external.MockCarApiClient;
import tech.mcverse.metasky.external.MockFlightApiClient;
import tech.mcverse.metasky.model.CarResult;
import tech.mcverse.metasky.model.FlightResult;
import tech.mcverse.metasky.model.SearchRequest;

import java.util.List;

@Service
public class CarSearchtService {
  @Autowired
  private final MockCarApiClient client;
  public CarSearchtService(MockCarApiClient client) {
    this.client = client;
  }

  public List<CarResult> searchcars(SearchRequest request) {
    return client.getCars(request);
  }
}
