import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JobApplicationServlet")
public class JobApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String fatherName = request.getParameter("fatherName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String contactNumber = request.getParameter("contactNumber");
        String email = request.getParameter("email");
        String aadhar = request.getParameter("aadhar");
        String address = request.getParameter("address");
        String highestQualification = request.getParameter("highestQualification");
        String university = request.getParameter("university");
        String yearPassing = request.getParameter("yearPassing");
        String percentage = request.getParameter("percentage");
        String jobType = request.getParameter("jobType");
        String preferredLocation = request.getParameter("preferredLocation");
        String preferredRole = request.getParameter("preferredRole");
  

        response.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JobApplicationServlet", "root", "Sakib@123");

            String query = "INSERT INTO JobApplicationServlet (fullName, fatherName, dob, gender, contactNumber, email, aadhar, address, highestQualification, university, yearPassing, percentage, jobType, preferredLocation, preferredRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, fatherName);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, contactNumber);
            ps.setString(6, email);
            ps.setString(7, aadhar);
            ps.setString(8, address);
            ps.setString(9, highestQualification);
            ps.setString(10, university);
            ps.setString(11, yearPassing);
            ps.setString(12, percentage);
            ps.setString(13, jobType);
            ps.setString(14, preferredLocation);
            ps.setString(15, preferredRole);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().println("<div style = \" height: 99vh; width: 100%; background-image:url('https://cdn.pixabay.com/photo/2016/04/27/20/38/girl-1357485_1280.jpg'); display: flex; justify-content: center; align-items: center;   \"><h3 style=\"color:blue;text-align:center;\">Your data successfully submitted. Fill another candidate's data:  <a href='index.html'>back to the home</a></h3></div>");
            } else {
                response.getWriter().println("<h3>Please enter valid data</h3>");
            }

            con.close();
        } catch (Exception e) {
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(); 
        }
    }
}
