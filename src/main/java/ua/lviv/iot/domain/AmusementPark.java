package ua.lviv.iot.domain;
import javax.persistence.*;
import java.util.Set;

@Table(name = "amusement_park")
@Entity
public class AmusementPark {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "capacity")
  private int capacity;
  @Column(name = "address")
  private String address;
  @Column(name = "name")
  private String name;
  @Column(name = "city_id")
  private Integer cityId;
  @OneToMany(mappedBy = "amusementParkId", fetch = FetchType.EAGER)
  private Set<Attraction> attractions;
  @OneToMany(mappedBy = "amusementParkId", fetch = FetchType.EAGER)
  private Set<Employee> employees;
  @OneToMany(mappedBy = "amusementParkId", fetch = FetchType.EAGER)
  private Set<Ticket> tickets;


  public AmusementPark(int id, int capacity, String address, String name, Integer cityId) {
    this.id = id;
    this.capacity = capacity;
    this.address = address;
    this.name = name;
    this.cityId = cityId;
  }


  public AmusementPark() {

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

  public Set<Attraction> getAttractions() {
    return attractions;
  }

  public void setAttractions(Set<Attraction> attractions) {
    this.attractions = attractions;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {

    this.employees = employees;
  }

  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }

  @Override
  public String toString() {
    return "AmusementPark{" +
        "id=" + id +
        ", capacity=" + capacity +
        ", address='" + address + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}


