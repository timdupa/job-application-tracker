package com.jobtracker.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jobtracker.dao.JobApplicationDAO;
import com.jobtracker.model.JobApplication;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/view-applications")
public class ViewApplicationsServlet extends HttpServlet {
    private JobApplicationDAO dao = new JobApplicationDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            List<JobApplication> applications = dao.getAllApplications();
            
            // Always return JSON for AJAX requests
            response.setContentType("application/json");
            Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
            response.getWriter().write(gson.toJson(applications));
            
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Database error: " + e.getMessage() + "\"}");
        }
    }
}