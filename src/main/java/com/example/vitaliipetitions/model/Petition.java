package com.example.vitaliipetitions.model;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private String id;
    private String title;
    private String description;

    // Creates an empty list ready to hold Signatures
    private List<Signature> signatures = new ArrayList<>();

    // maven needs empty method to execute
    public Petition() {}

    // constructor
    public Petition(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Signature> getSignatures() { return signatures; }
    public void setSignatures(List<Signature> signatures) { this.signatures = signatures; }
}
