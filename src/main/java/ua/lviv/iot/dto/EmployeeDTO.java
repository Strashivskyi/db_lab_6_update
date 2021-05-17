package ua.lviv.iot.dto;

public class EmployeeDTO {
  private int id;
  private String phoneNumber;
  private String email;
  private String birthday;
  private String gender;
  private String firstName;
  private String lastName;
  private int cityId;
  private int amusementParkId;
  private int positionId;

  public EmployeeDTO(int id, String phoneNumber, String email, String birthday, String gender, String firstName, String lastName, Integer cityId, Integer amusementParkId, Integer positionId) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.birthday = birthday;
    this.gender = gender;
    this.firstName = firstName;
    this.lastName = lastName;
    this.cityId = cityId;
    this.amusementParkId = amusementParkId;
    this.positionId = positionId;
  }

  public EmployeeDTO() {
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

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  public int getAmusementParkId() {
    return amusementParkId;
  }

  public void setAmusementParkId(int amusementParkId) {
    this.amusementParkId = amusementParkId;
  }

  public int getPositionId() {
    return positionId;
  }

  public void setPositionId(int positionId) {
    this.positionId = positionId;
  }
}
