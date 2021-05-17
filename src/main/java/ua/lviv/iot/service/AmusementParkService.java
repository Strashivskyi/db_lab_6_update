package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.AmusementPark;
import ua.lviv.iot.repository.AmusementParkRepository;

@Service
public class AmusementParkService extends AbstractService<AmusementPark, Integer> {

  private final AmusementParkRepository amusementParkRepository;

  public AmusementParkService(AmusementParkRepository amusementParkRepository) {
    this.amusementParkRepository = amusementParkRepository;
  }

  @Override
  protected JpaRepository<AmusementPark, Integer> getRepository() {
    return amusementParkRepository;
  }

}
