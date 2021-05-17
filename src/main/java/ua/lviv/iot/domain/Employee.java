package ua.lviv.iot.domain;
import javax.persistence.*;

@Table(name = "employee")
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column(name = "email")
  private String email;
  @Column(name = "birthday")
  private String birthday;
  @Column(name = "gender")
  private String gender;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "position_id")
  private Integer positionId;
  @Column(name = "amusement_park_id")
  private Integer amusementParkId;
  @JoinColumn(name = "city_id")
  private Integer cityId;


  public Employee(int id, String phoneNumber, String email, String birthday, String gender, String firstName, String lastName, Integer positionId, Integer amusementParkId, Integer cityId) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.birthday = birthday;
    this.gender = gender;
    this.firstName = firstName;
    this.lastName = lastName;
    this.positionId = positionId;
    this.amusementParkId = amusementParkId;
    this.cityId = cityId;
  }

  public Employee() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Integer getPositionId() {
    return positionId;
  }

  public void setPositionId(Integer positionId) {
    this.positionId = positionId;
  }

  public Integer getAmusementParkId() {
    return amusementParkId;
  }

  public void setAmusementParkId(Integer amusementParkId) {
    this.amusementParkId = amusementParkId;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", email='" + email + '\'' +
        ", birthday='" + birthday + '\'' +
        ", gender='" + gender + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}