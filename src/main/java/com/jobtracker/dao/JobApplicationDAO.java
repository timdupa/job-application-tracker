package com.jobtracker.dao;

import com.jobtracker.model.JobApplication;
import com.jobtracker.util.DatabaseConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class JobApplicationDAO {
    
    public void addApplication(JobApplication application) throws SQLException {
        String sql = "INSERT INTO job_applications (company_name, date_applied, status, notes) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, application.getCompanyName());
            stmt.setDate(2, new java.sql.Date(application.getDateApplied().getTime()));
            stmt.setString(3, application.getStatus());
            stmt.setString(4, application.getNotes());
            
            stmt.executeUpdate();
        }
    }
    
    public List<JobApplication> getAllApplications() throws SQLException {
        List<JobApplication> applications = new ArrayList<>();
        String sql = "SELECT * FROM job_applications ORDER BY date_applied DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                JobApplication app = new JobApplication();
                app.setId(rs.getInt("id"));
                app.setCompanyName(rs.getString("company_name"));
                app.setDateApplied(rs.getDate("date_applied"));
                app.setStatus(rs.getString("status"));
                app.setNotes(rs.getString("notes"));
                app.setCreatedAt(rs.getTimestamp("created_at"));
                
                applications.add(app);
            }
        }
        
        return applications;
    }
    
    public void updateApplicationStatus(int id, String status) throws SQLException {
        String sql = "UPDATE job_applications SET status = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}