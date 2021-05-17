package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Attraction;
import ua.lviv.iot.repository.AttractionRepository;

import java.util.List;

@Service
public class AttractionService extends AbstractService<Attraction, Integer> {


  private final AttractionRepository attractionRepository;

  public List<Attraction> getAllByAmusementParkId(Integer id) {
    return attractionRepository.getAttractionsByAmusementParkId(id);
  }



  public AttractionService(AttractionRepository attractionRepository) {
    this.attractionRepository = attractionRepository;
  }

  @Override
  protected JpaRepository<Attraction, Integer> getRepository() {

    return attractionRepository;
  }



}
