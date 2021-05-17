package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.AmusementPark;
import ua.lviv.iot.dto.AmusementParkDto;
import ua.lviv.iot.service.AmusementParkService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/amusement_park")
@RestController
public class AmusementParkController {
  private final AmusementParkService amusementParkService;

  public AmusementParkController(AmusementParkService amusementParkService) {
    this.amusementParkService = amusementParkService;
  }
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<AmusementParkDto>> getAll() {
    List<AmusementPark> amusementParks = amusementParkService.getAll();
    List<AmusementParkDto> amusementParkDtos = new ArrayList<>();
    for (AmusementPark amusementPark : amusementParks) {
      AmusementParkDto amusementParkDto = new AmusementParkDto (
          amusementPark.getId(),
          amusementPark.getCapacity(),
          amusementPark.getAddress(),
          amusementPark.getName(),
          amusementPark.getCityId()
      );
      amusementParkDtos.add(amusementParkDto);
    }
    return new ResponseEntity<>(amusementParkDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AmusementParkDto> getById(@PathVariable Integer id) {
    AmusementPark amusementPark = amusementParkService.getById(id);
    try {
      if (amusementParkService.getById(id) != null && amusementParkService.getById(id).getName() != null) {
        AmusementParkDto amusementParkDto = new AmusementParkDto(
            amusementPark.getId(),
            amusementPark.getCapacity(),
            amusementPark.getAddress(),
            amusementPark.getName(),
            amusementPark.getCityId()
        );
        return new ResponseEntity<>(amusementParkDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AmusementParkDto> create(@RequestBody AmusementPark amusementPark) {
    amusementParkService.create(amusementPark);
    AmusementParkDto amusementParkDto = new AmusementParkDto(
        amusementPark.getId(),
        amusementPark.getCapacity(),
        amusementPark.getAddress(),
        amusementPark.getName(),
        amusementPark.getCityId()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(amusementParkDto);  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AmusementParkDto> update(@PathVariable Integer id,
                                        @RequestBody AmusementPark amusementPark) {
    try {
      amusementPark.setId(id);
      AmusementPark oldPosition = amusementParkService.getById(id);
      if (oldPosition != null && oldPosition.getName() != null) {
        amusementParkService.update(id, amusementPark);
        AmusementParkDto newPositionDto = new AmusementParkDto(
            amusementPark.getId(),
            amusementPark.getCapacity(),
            amusementPark.getAddress(),
            amusementPark.getName(),
            amusementPark.getCityId()
        );
        return new ResponseEntity<>(newPositionDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    try {
      if (amusementParkService.getById(id) != null && amusementParkService.getById(id).getName() != null) {
        amusementParkService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

