package tech.mcverse.metasky.model;

public class Flight {
  private int id;
  private String flightNumber;
  private String flightType;
  private String flightDate;
  private String flightTime;
  private String flightStatus;
  private String flightLocation;
  private String flightDestination;
  private String flightModel;
  public Flight(final int id, final String flightNumber, final String flightType, final String flightDate, final String flightTime) {
    this.id = id;
    this.flightNumber = flightNumber;
    this.flightType = flightType;
    this.flightDate = flightDate;
    this.flightTime = flightTime;
  }
  public int getId() {
    return id;
  }
  public void setId(final int id) {
    this.id = id;
  }
  public String getFlightNumber() {
    return flightNumber;
  }
  public void setFlightNumber(final String flightNumber) {
    this.flightNumber = flightNumber;
  }
  public String getFlightType() {
    return flightType;
  }
  public void setFlightType(final String flightType) {
    this.flightType = flightType;
  }
  public String getFlightDate() {
    return flightDate;
  }
  public void setFlightDate(final String flightDate) {
    this.flightDate = flightDate;
  }
  public String getFlightTime() {
    return flightTime;
  }
  public void setFlightTime(final String flightTime) {
    this.flightTime = flightTime;
  }
  public String getFlightStatus() {
    return flightStatus;
  }
  public void setFlightStatus(final String flightStatus) {
    this.flightStatus = flightStatus;
  }
}
