package com.library.personallibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int userid;
    @Column(name = "firstName", nullable = false, length = 20)
    @JsonProperty("firstName")
    private String firstName;
    @Column(name = "lastName", nullable = false, length = 20)
    @JsonProperty("lastName")
    private String lastName;
    @Column(nullable = false, unique = true, length = 30)
    @JsonProperty("email")
    private String email;
    @Column(nullable = false, length = 64)
    private String password;

    public int getUserid() { return userid; }

    public void setUserid(int userid) { this.userid = userid; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
