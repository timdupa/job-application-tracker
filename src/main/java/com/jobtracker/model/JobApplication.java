package com.jobtracker.model;

import java.util.Date;

public class JobApplication {
    private int id;
    private String companyName;
    private Date dateApplied;
    private String status;
    private String notes;
    private Date createdAt;
    
    // Constructors
    public JobApplication() {}
    
    public JobApplication(String companyName, Date dateApplied, String status, String notes) {
        this.companyName = companyName;
        this.dateApplied = dateApplied;
        this.status = status;
        this.notes = notes;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public Date getDateApplied() { return dateApplied; }
    public void setDateApplied(Date dateApplied) { this.dateApplied = dateApplied; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}