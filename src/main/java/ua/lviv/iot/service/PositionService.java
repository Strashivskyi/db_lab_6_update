package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Position;
import ua.lviv.iot.repository.PositionRepository;

@Service
public class PositionService extends AbstractService<Position, Integer> {

  private final PositionRepository positionRepository;

  public PositionService(PositionRepository positionRepository) {
    this.positionRepository = positionRepository;
  }

  @Override
  protected JpaRepository<Position, Integer> getRepository() {
    return positionRepository;
  }

}
