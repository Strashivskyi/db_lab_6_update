package ua.lviv.iot.domain;
import javax.persistence.*;

@Table(name = "ticket")
@Entity
public class Ticket {
  @Id
  @Column(name = "id")
  private int id;
  @Column(name = "arrival_time")
  private String arrivalTime;
  @Column(name = "departure_time")
  private String departureTime;
  @Column(name = "people_number")
  private int peopleNumber;
  @Column(name = "kids_number")
  private int kidsNumber;
  @Column(name = "price_in_USD")
  private int priceInUSD;
  @Column(name = "payment_time")
  private String paymentTime;
  @Column(name = "amusement_park_id")
  private int amusementParkId;
  @Column(name = "client_id")
  private int clientId;

  public Ticket(int id, String arrivalTime, String departureTime, int peopleNumber, int kidsNumber, int priceInUSD, String paymentTime, Integer amusementParkId, Integer clientId) {
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

  public Ticket() {

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

  @Override
  public String toString() {
    return "Ticket{" +
        "id=" + id +
        ", arrivalTime='" + arrivalTime + '\'' +
        ", departureTime='" + departureTime + '\'' +
        ", peopleNumber=" + peopleNumber +
        ", kidsNumber=" + kidsNumber +
        ", priceInUSD=" + priceInUSD +
        ", paymentTime='" + paymentTime + '\'' +
        '}';
  }
}
