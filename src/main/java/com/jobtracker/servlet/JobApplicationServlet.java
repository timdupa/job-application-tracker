package com.jobtracker.servlet;

import com.jobtracker.dao.JobApplicationDAO;
import com.jobtracker.model.JobApplication;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/applications")
public class JobApplicationServlet extends HttpServlet {
    private JobApplicationDAO dao = new JobApplicationDAO();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String companyName = request.getParameter("companyName");
        String dateAppliedStr = request.getParameter("dateApplied");
        String status = request.getParameter("status");
        String notes = request.getParameter("notes");
        
        try {
            Date dateApplied = dateFormat.parse(dateAppliedStr);
            JobApplication application = new JobApplication(companyName, dateApplied, status, notes);
            
            dao.addApplication(application);
            response.sendRedirect("index.html");
            
        } catch (ParseException | SQLException e) {
            throw new ServletException("Error processing application", e);
        }
    }
}