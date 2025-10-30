package com.partc;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/experimentdb", "username", "userpassword");

            String query = "INSERT INTO Attendance (StudentID, StudentName, Date, Status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, date);
            ps.setString(4, status);

            int result = ps.executeUpdate();

            out.println("<html><body style='text-align:center;'>");
            if (result > 0) {
                out.println("<h2 style='color:green;'>Attendance Submitted Successfully!</h2>");
            } else {
                out.println("<h2 style='color:red;'>Error in submitting attendance.</h2>");
            }
            out.println("<br><a href='attendance.jsp'>Go Back</a>");
            out.println("</body></html>");

            con.close();
        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}
