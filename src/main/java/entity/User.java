package entity;

import enums.UserType;

import java.util.Date;
import java.util.Objects;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String dataOfBirthday;
    private String password;
    private UserType userType;


    public User(String firstName, String lastName, String email, String phoneNumber, String dataOfBirthday, String securePassword, UserType user, String photo) {

    }

    public User(int id, String firstname, String lastname, String email, String phoneNumber,
                String dataOfBirthday, String password, UserType userType, long photo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dataOfBirthday = dataOfBirthday;
        this.password = password;
        this.userType = userType;

    }

    public User(String firstname, String lastname, String email, String phoneNumber,
                String dataOfBirthday, String password, UserType userType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dataOfBirthday = dataOfBirthday;
        this.password = password;
        this.userType = userType;


    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDataOfBirthday() {
        return dataOfBirthday;
    }

    public void setDataOfBirthday(String dataOfBirthday) {
        this.dataOfBirthday = dataOfBirthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dataOfBirthday=" + dataOfBirthday +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
