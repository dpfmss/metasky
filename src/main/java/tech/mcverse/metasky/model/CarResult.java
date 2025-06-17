package tech.mcverse.metasky.model;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CarResult implements BookableItem {
  private String carId;
  private String make;
  private String model;
  private int year;
  private double pricePerDay;
  private String location;
  private String carType; // SUV, Sedan, etc.
  @JsonFormat(pattern = "dd-MM-yyy HH:mm ")
  private LocalDateTime availableFrom;
  @JsonFormat(pattern = "dd-MM-yyy HH:mm ")
  private LocalDateTime availableTo;
  private boolean available;

  public CarResult() {}

  public CarResult(String carId, String make, String model, int year, double pricePerDay,
                   String location, String carType, LocalDateTime availableFrom, LocalDateTime availableTo) {
    this.carId = carId;
    this.make = make;
    this.model = model;
    this.year = year;
    this.pricePerDay = pricePerDay;
    this.location = location;
    this.carType = carType;
    this.availableFrom = availableFrom;
    this.availableTo = availableTo;
    this.available = true;
  }

  public CarResult(String toyotaYaris, double v, String from, String to, String time, String time1) {
  }

  @Override
  public String getId() { return carId; }

  @Override
  public double getPrice() { return pricePerDay; }

  @Override
  public String getType() { return "CAR"; }

  @Override
  public String getDescription() {
    return String.format("%d %s %s (%s) - %s", year, make, model, carType, location);
  }

  // Getters and setters
  public String getCarId() { return carId; }
  public void setCarId(String carId) { this.carId = carId; }

  public String getMake() { return make; }
  public void setMake(String make) { this.make = make; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public int getYear() { return year; }
  public void setYear(int year) { this.year = year; }

  public double getPricePerDay() { return pricePerDay; }
  public void setPricePerDay(double pricePerDay) { this.pricePerDay = pricePerDay; }

  public String getLocation() { return location; }
  public void setLocation(String location) { this.location = location; }

  public String getCarType() { return carType; }
  public void setCarType(String carType) { this.carType = carType; }

  public LocalDateTime getAvailableFrom() { return availableFrom; }
  public void setAvailableFrom(LocalDateTime availableFrom) { this.availableFrom = availableFrom; }

  public LocalDateTime getAvailableTo() { return availableTo; }
  public void setAvailableTo(LocalDateTime availableTo) { this.availableTo = availableTo; }

  public boolean isAvailable() { return available; }
  public void setAvailable(boolean available) { this.available = available; }
}