package com.estudosjava.javacomoprogramar.javacore.capitulo24_JDBC.catalogo_app;

public class Person {
    private int addressId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Person(int addressId, String firstName, String lastName, String email, String phoneNumber) {
        setAddressId(addressId);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String toString() {
        return String.format("Pessoa: %d, %s %s, %s, %s%n", getAddressId(), getFirstName(), getLastName(), getEmail(), getPhoneNumber());
    }
}
