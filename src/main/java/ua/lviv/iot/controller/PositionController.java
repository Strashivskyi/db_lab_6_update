package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Position;
import ua.lviv.iot.dto.PositionDto;
import ua.lviv.iot.service.PositionService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/position")
@RestController
public class PositionController {
  private final PositionService positionService;

  public PositionController(PositionService positionService) {
    this.positionService = positionService;
  }
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<PositionDto>> getAll() {
    List<Position> positions = positionService.getAll();
    List<PositionDto> positionDtos = new ArrayList<>();
    for (Position position : positions) {
      PositionDto positionDto = new PositionDto (
          position.getId(),
          position.getName(),
          position.getDescription()
      );
      positionDtos.add(positionDto);
    }
    return new ResponseEntity<>(positionDtos, HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<PositionDto> getById(@PathVariable Integer id) {
    Position position = positionService.getById(id);
    try {
      if ( positionService.getById(id) != null && positionService.getById(id).getName() != null) {
        PositionDto positionDto = new PositionDto (
            position.getId(),
            position.getName(),
            position.getDescription()
        );
        return new ResponseEntity<>(positionDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<PositionDto> create(@RequestBody Position position) {
    positionService.create(position);
    PositionDto positionDto = new PositionDto (
        position.getId(),
        position.getName(),
        position.getDescription()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(positionDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<PositionDto> update(@PathVariable Integer id,
                                        @RequestBody Position position) {
    try {
      position.setId(id);
      Position oldPosition = positionService.getById(id);
      if (oldPosition != null && oldPosition.getName() != null) {
        positionService.update(id, position);
        PositionDto newPositionDto = new PositionDto(
            position.getId(),
            position.getName(),
            position.getDescription()
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
      if (positionService.getById(id) != null && positionService.getById(id).getName() != null) {
        positionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

