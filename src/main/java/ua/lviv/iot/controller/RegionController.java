package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.dto.RegionDto;
import ua.lviv.iot.service.RegionService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/region")
@RestController
public class RegionController {
  private final RegionService regionService;

  public RegionController(RegionService regionService) {
    this.regionService = regionService;
  }
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<RegionDto>> getAll() {
    List<Region> regions = regionService.getAll();
    List<RegionDto> regionDtos = new ArrayList<>();
    for (Region region : regions) {
      RegionDto regionDto = new RegionDto (
          region.getId(),
          region.getName()
      );
      regionDtos.add(regionDto);
    }
    return new ResponseEntity<>(regionDtos, HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<RegionDto> getById(@PathVariable Integer id) {
    Region region = regionService.getById(id);
    try {
      if (regionService.getById(id) != null && regionService.getById(id).getName() != null) {
        RegionDto regionDto = new RegionDto(
            region.getId(),
            region.getName()
        );
        return new ResponseEntity<>(regionDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<RegionDto> create(@RequestBody Region region) {
    regionService.create(region);
    RegionDto regionDto = new RegionDto(
        region.getId(),
        region.getName()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(regionDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<RegionDto> update(@PathVariable Integer id,
                                        @RequestBody Region region) {
    try {
      region.setId(id);
      Region oldRegion = regionService.getById(id);
      if (oldRegion != null && oldRegion.getName() != null) {
        regionService.update(id, region);
        RegionDto newRegionDto = new RegionDto(
            region.getId(),
            region.getName()
        );
        return new ResponseEntity<>(newRegionDto, HttpStatus.OK);
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
      if (regionService.getById(id) != null && regionService.getById(id).getName() != null) {
        regionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

