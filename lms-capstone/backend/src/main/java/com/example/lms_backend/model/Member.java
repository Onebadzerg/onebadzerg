package com.example.lms_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "member")  // Updated table name from "members" to "member"
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;

    @Column(name = "member_name", nullable = false, length = 100)
    private String name;

    @Column(name = "member_password", nullable = false, length = 100)
    private String password;

    @Column(name = "member_email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "member_hp", nullable = false, length = 100)
    private String phoneNumber;

    @Column(name = "is_admin")
    private String isAdmin; // 'yes' or 'no'

    // Constructors
    public Member() {}

    public Member(String name, String password, String email, String phoneNumber, String isAdmin) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getIsAdmin() { return isAdmin; }
    public void setIsAdmin(String isAdmin) { this.isAdmin = isAdmin; }
}
