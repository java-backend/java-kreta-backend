package org.example.kreta.model;

import java.util.Date;

public class Teacher {

    private long id;
    private String firstName;
    private String lastName;
    private boolean wooman;
    private Date dataOfBirth;
    private String city;
    private String streetAndNumber;
    private int postCode;
    private String loginName;
    private String password;
    private int grossSalary;
    private int numberOfChildren;

    public Teacher(long id, String firstName, String lastName, boolean wooman, Date dataOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wooman = wooman;
        this.dataOfBirth = dataOfBirth;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isWooman() {
        return wooman;
    }

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWooman(boolean wooman) {
        this.wooman = wooman;
    }

    public void setDataOfBirth(Date dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) { this.password = password; }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wooman=" + wooman +
                ", dataOfBirth=" + dataOfBirth +
                '}';
    }
}
