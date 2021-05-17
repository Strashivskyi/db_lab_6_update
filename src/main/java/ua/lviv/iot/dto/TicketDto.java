package ua.lviv.iot.dto;

public class TicketDto {
  private int id;
  private String arrivalTime;
  private String departureTime;
  private int peopleNumber;
  private int kidsNumber;
  private int priceInUSD;
  private String paymentTime;
  private int amusementParkId;
  private int clientId;


  public TicketDto(int id, String arrivalTime, String departureTime, int peopleNumber, int kidsNumber, int priceInUSD, String paymentTime,Integer amusementParkId, Integer clientId) {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.departureTime = departureTime;
    this.peopleNumber = peopleNumber;
    this.kidsNumber = kidsNumber;
    this.priceInUSD = priceInUSD;
    this.paymentTime = paymentTime;
    this.amusementParkId = amusementParkId;
    this.clientId = clientId;
  }

  public TicketDto() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public int getPeopleNumber() {
    return peopleNumber;
  }

  public void setPeopleNumber(int peopleNumber) {
    this.peopleNumber = peopleNumber;
  }

  public int getKidsNumber() {
    return kidsNumber;
  }

  public void setKidsNumber(int kidsNumber) {
    this.kidsNumber = kidsNumber;
  }

  public int getPriceInUSD() {
    return priceInUSD;
  }

  public void setPriceInUSD(int priceInUSD) {
    this.priceInUSD = priceInUSD;
  }

  public String getPaymentTime() {
    return paymentTime;
  }

  public void setPaymentTime(String paymentTime) {
    this.paymentTime = paymentTime;
  }

  public int getAmusementParkId() {
    return amusementParkId;
  }

  public void setAmusementParkId(int amusementParkId) {
    this.amusementParkId = amusementParkId;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }
}
