package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.AmusementPark;
import ua.lviv.iot.domain.Attraction;
import ua.lviv.iot.dto.AttractionDto;
import ua.lviv.iot.service.AmusementParkService;
import ua.lviv.iot.service.AttractionService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/attraction")
@RestController
public class AttractionController {
  private final AttractionService attractionService;
  private final AmusementParkService amusementParkService;

  public AttractionController(AttractionService attractionService, AmusementParkService amusementParkService) {
    this.attractionService = attractionService;
    this.amusementParkService = amusementParkService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<AttractionDto>> getAll() {
    List<Attraction> attractions = attractionService.getAll();
    List<AttractionDto> attractionDtos = new ArrayList<>();
    for (Attraction attraction : attractions) {
      AttractionDto attractionDto = new AttractionDto (
          attraction.getId(),
          attraction.getName(),
          attraction.getDescription(),
          attraction.getCapacity(),
          attraction.getMinimumAge(),
          attraction.getAmusementParkId()
      );
      attractionDtos.add(attractionDto);
    }
    return new ResponseEntity<>(attractionDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/amusementPark/{id}")
  public @ResponseBody  ResponseEntity<List<AttractionDto>> getAllByAmusementPark(@PathVariable Integer id) {
    List<Attraction> attractions = attractionService.getAllByAmusementParkId(id);
    AmusementPark amusementPark = amusementParkService.getById(id);
    try {
      if (amusementPark.getName() != null){
      List<AttractionDto> attractionDtos = new ArrayList<>();
      for (Attraction attraction : attractions) {
        AttractionDto attractionDto = new AttractionDto (
            attraction.getId(),
            attraction.getName(),
            attraction.getDescription(),
            attraction.getCapacity(),
            attraction.getMinimumAge(),
            attraction.getAmusementParkId()
        );
        attractionDtos.add(attractionDto);
      }
      return new ResponseEntity<>(attractionDtos, HttpStatus.OK);
    }
    else{
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<AttractionDto> getById(@PathVariable Integer id) {
    Attraction attraction = attractionService.getById(id);
    try {
      if (attractionService.getById(id) != null) {
        AttractionDto attractionDto = new AttractionDto(
            attraction.getId(),
            attraction.getName(),
            attraction.getDescription(),
            attraction.getCapacity(),
            attraction.getMinimumAge(),
            attraction.getAmusementParkId()
        );
        return new ResponseEntity<>(attractionDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AttractionDto> create(@RequestBody Attraction attraction) {
    attractionService.create(attraction);
    AttractionDto attractionDto = new AttractionDto(
        attraction.getId(),
        attraction.getName(),
        attraction.getDescription(),
        attraction.getCapacity(),
        attraction.getMinimumAge(),
        attraction.getAmusementParkId()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(attractionDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<AttractionDto> update(@PathVariable Integer id,
                                        @RequestBody Attraction attraction) {
    try {
      attraction.setId(id);
      Attraction oldAttraction = attractionService.getById(id);
      if (oldAttraction != null && oldAttraction.getName() != null) {
        attractionService.update(id, attraction);
        AttractionDto newPositionDto = new AttractionDto(
            attraction.getId(),
            attraction.getName(),
            attraction.getDescription(),
            attraction.getCapacity(),
            attraction.getMinimumAge(),
            attraction.getAmusementParkId()
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
        if (attractionService.getById(id) != null && attractionService.getById(id).getName() != null) {
          attractionService.deleteById(id);
          return new ResponseEntity<>(HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      } catch (EntityNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

}