package ua.lviv.iot.dto;

public class AttractionDto {
  private int id;
  private String name;
  private String description;
  private int capacity;
  private int minimumAge;
  private int amusementParkId;


  public AttractionDto(int id, String name, String description, int capacity, int minimumAge, int amusementParkId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.capacity = capacity;
    this.minimumAge = minimumAge;
    this.amusementParkId = amusementParkId;
  }

  public AttractionDto() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getMinimumAge() {
    return minimumAge;
  }

  public void setMinimumAge(int minimumAge) {
    this.minimumAge = minimumAge;
  }

  public int getAmusementParkId() {
    return amusementParkId;
  }

  public void setAmusementParkId(int amusementParkId) {
    this.amusementParkId = amusementParkId;
  }
}
