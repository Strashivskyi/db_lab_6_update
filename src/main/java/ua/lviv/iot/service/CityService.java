package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.repository.CityRepository;

import java.util.List;

@Service
public class CityService extends AbstractService<City, Integer> {

  private final CityRepository cityRepository;


  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  protected JpaRepository<City, Integer> getRepository() {

    return cityRepository;
  }

  public List<City> getAllByRegionId(Integer id) {
    return cityRepository.getCitiesByRegionId(id);
  }
}
