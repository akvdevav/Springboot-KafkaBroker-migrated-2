package com.springbootkafka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    public User() {
        // Default constructor required by JPA
    }

    public User(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    // Additional accessor methods expected by other classes
    public int getUserId() {
        return this.id;
    }

    public void setUserId(final int id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return this.firstName;
    }

    public void setUserFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getUserLastName() {
        return this.lastName;
    }

    public void setUserLastName(final String lastName) {
        this.lastName = lastName;
    }
}