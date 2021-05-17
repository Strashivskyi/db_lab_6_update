package ua.lviv.iot.domain;
import javax.persistence.*;

@Table(name = "attraction")
@Entity
public class Attraction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "capacity")
  private int capacity;
  @Column(name = "minimum_age")
  private int minimumAge;
  @Column(name = "amusement_park_id")
  private Integer amusementParkId;


  public Attraction(Integer id, String name, String description, Integer capacity, Integer amusementParkId, Integer minimumAge) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.capacity = capacity;
    this.minimumAge = minimumAge;
    this.amusementParkId = amusementParkId;
  }
  public Attraction() {

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

  public Integer getAmusementParkId() {
    return amusementParkId;
  }

  public void setAmusementParkId(Integer amusementParkId) {
    this.amusementParkId = amusementParkId;
  }

  @Override
  public String toString() {
    return "Attraction{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", capacity=" + capacity +
        ", minimumAge=" + minimumAge +
        ", amusementParkId=" + amusementParkId +
        '}';
  }
}
