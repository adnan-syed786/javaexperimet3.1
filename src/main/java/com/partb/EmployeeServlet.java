package com.partb;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid"); // Optional search field

        out.println("<html><head><title>Employee Records</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f9f9f9; }");
        out.println("table { border-collapse: collapse; width: 80%; margin: 20px auto; background: #fff; }");
        out.println("th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }");
        out.println("th { background-color: #0078d7; color: white; }");
        out.println("h2 { text-align: center; }");
        out.println("form { text-align: center; margin-top: 20px; }");
        out.println("</style></head><body>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/experimentdb", "root", "password");

            Statement stmt = con.createStatement();
            String query;

            if (empid != null && !empid.isEmpty()) {
                query = "SELECT * FROM employee WHERE EmpID = " + empid;
            } else {
                query = "SELECT * FROM employee";
            }

            ResultSet rs = stmt.executeQuery(query);

            out.println("<h2>Employee Records</h2>");
            out.println("<form action='EmployeeServlet' method='get'>");
            out.println("Search by Employee ID: <input type='text' name='empid'>");
            out.println("<input type='submit' value='Search'>");
            out.println("</form>");

            out.println("<table>");
            out.println("<tr>"
                    + "<th>Emp ID</th>"
                    + "<th>Full Name</th>"
                    + "<th>Gender</th>"
                    + "<th>Department</th>"
                    + "<th>Designation</th>"
                    + "<th>Salary (₹)</th>"
                    + "<th>Phone</th>"
                    + "</tr>");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("EmpID") + "</td>");
                out.println("<td>" + rs.getString("FullName") + "</td>");
                out.println("<td>" + rs.getString("Gender") + "</td>");
                out.println("<td>" + rs.getString("Department") + "</td>");
                out.println("<td>" + rs.getString("Designation") + "</td>");
                out.println("<td>₹" + rs.getDouble("Salary") + "</td>");
                out.println("<td>" + rs.getString("Phone") + "</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='7' style='color:red;'>No Employee Found!</td></tr>");
            }

            out.println("</table>");
            con.close();

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }

        out.println("</body></html>");
    }
}
