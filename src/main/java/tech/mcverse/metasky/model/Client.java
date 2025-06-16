package tech.mcverse.metasky.model;

public class Client {
  String name;
  String email;
  String phone;
  public Client(String name, String email, String phone) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
}
