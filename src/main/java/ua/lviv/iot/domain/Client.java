package ua.lviv.iot.domain;
import javax.persistence.*;
import java.util.Set;

@Table(name = "client")
@Entity
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "birthday")
  private String birthday;
  @Column(name = "gender")
  private String gender;
  @Column(name = "address")
  private String address;
  @Column(name = "city_id")
  private int cityId;
  @OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
  private Set<Ticket> tickets;

  public Client(int id, String firstName, String lastName, String birthday, String gender, String address, Integer cityId) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.gender = gender;
    this.address = address;
    this.cityId = cityId;
  }



  public Client() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }

  @Override
  public String toString() {
    return "Client{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", birthday='" + birthday + '\'' +
        ", gender='" + gender + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
