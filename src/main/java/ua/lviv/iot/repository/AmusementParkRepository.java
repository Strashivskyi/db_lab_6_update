package ua.lviv.iot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.AmusementPark;

import java.util.List;

@Repository
public interface AmusementParkRepository extends JpaRepository<AmusementPark, Integer> {

}
