package com.example.superreg.entities;

import javax.persistence.*;

@Entity
@Table(name="sr_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private Long idNumber;

    private String telephoneNumber;

    public User() {
    }

    public User(String name, Long idNumber, String telephoneNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
