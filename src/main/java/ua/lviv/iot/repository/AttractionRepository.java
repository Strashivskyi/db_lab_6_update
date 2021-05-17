package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Attraction;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

  List<Attraction> getAttractionsByAmusementParkId(Integer amusementParkId);
}
