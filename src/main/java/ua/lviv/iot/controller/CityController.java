package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.dto.CityDto;
import ua.lviv.iot.service.CityService;
import ua.lviv.iot.service.RegionService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/city")
@RestController
public class CityController {
  private final CityService cityService;
  private final RegionService regionService;

  public CityController(CityService cityService, RegionService regionService) {
    this.cityService = cityService;
    this.regionService = regionService;
  }
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<CityDto>> getAll() {
    List<City> cities = cityService.getAll();
    List<CityDto> cityDtos = new ArrayList<>();
    for (City city : cities) {
      CityDto cityDto = new CityDto (
          city.getId(),
          city.getName(),
          city.getRegionId()
          );
      cityDtos.add(cityDto);
    }
    return new ResponseEntity<>(cityDtos, HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<CityDto> getById(@PathVariable Integer id) {
    City city = cityService.getById(id);
    try {
      if (cityService.getById(id) != null) {
        CityDto cityDto = new CityDto(
            city.getId(),
            city.getName(),
            city.getRegionId()
        );
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.GET, value = "/region/{id}")
  public @ResponseBody  ResponseEntity<List<CityDto>> getAllByRegion(@PathVariable Integer id) {
    List<City> cities = cityService.getAllByRegionId(id);
    Region region = regionService.getById(id);

    try {
      if (region.getName()!=null){
      List<CityDto> cityDtos = new ArrayList<>();
      for (City city : cities) {
        CityDto cityDto = new CityDto (
            city.getId(),
            city.getName(),
            city.getRegionId()
        );
        cityDtos.add(cityDto);
      }
      return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }
    else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<CityDto> create(@RequestBody City city) {
    cityService.create(city);
    CityDto cityDto = new CityDto(
        city.getId(),
        city.getName(),
        city.getRegionId()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(cityDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<CityDto> update(@PathVariable Integer id,
                                               @RequestBody City city) {
    try {
      city.setId(id);
      City oldCity = cityService.getById(id);
      if (oldCity != null && oldCity.getName() != null) {
        cityService.update(id, city);
        CityDto newCityDto = new CityDto(
            city.getId(),
            city.getName(),
            city.getRegionId()
        );
        return new ResponseEntity<>(newCityDto, HttpStatus.OK);
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
      if (cityService.getById(id).getName() != null) {
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

