package tech.mcverse.metasky.model;

import org.apache.catalina.User;

import java.sql.Time;
import java.util.Date;

public class Payment {
  private int id;
  private Booking booking;
  private User user;
  private Date date;
  private Time time;
  private String description;
  private String status;
  public Payment(Booking booking, User user) {}
}
