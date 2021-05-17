package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.repository.RegionRepository;

@Service
public class RegionService extends AbstractService<Region, Integer> {

  private final RegionRepository regionRepository;

  public RegionService(RegionRepository regionRepository) {
    this.regionRepository = regionRepository;
  }

  @Override
  protected JpaRepository<Region, Integer> getRepository() {
    return regionRepository;
  }

}
