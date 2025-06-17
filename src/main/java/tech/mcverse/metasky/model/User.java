package tech.mcverse.metasky.model;
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    public User() {}
    public User(String firstName, String lastName, String email, String phone) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.phone = phone;
    }
    // Keep consistent with User naming throughout
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getFullName() { return firstName + " " + lastName; }
}