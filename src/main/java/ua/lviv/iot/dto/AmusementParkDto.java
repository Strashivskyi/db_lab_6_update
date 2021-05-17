package ua.lviv.iot.dto;

public class AmusementParkDto {
  private int id;
  private int capacity;
  private String address;
  private String name;
  private Integer cityId;



  public AmusementParkDto(int id, int capacity, String address, String name, Integer cityId) {
    this.id = id;
    this.capacity = capacity;
    this.address = address;
    this.name = name;
    this.cityId = cityId;
  }

  public AmusementParkDto() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }
}
