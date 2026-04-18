package com.example.vitaliipetitions.model;

public class Signature {
    private String name;
    private String email;

    // Empty constructor needed for Spring
    public Signature() {}

    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
