package ua.lviv.iot.dto;

public class CityDto {
  private int id;
  private String name;
  private Integer regionId;


  public CityDto(int id, String name, Integer regionId) {
    this.id = id;
    this.name = name;
    this.regionId = regionId;

  }

  public CityDto() {
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getRegionId() {
    return regionId;
  }

  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }
}
