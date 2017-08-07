/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author anants
 */
public class SignUp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String first = request.getParameter("first");
        String middle = request.getParameter("middle");
        String last = request.getParameter("last");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String cnfpass = request.getParameter("cnfpass");
        String gender = request.getParameter("gender");
        String contact = request.getParameter("contact");
        String dob = request.getParameter("dob");
        // Date of birth formatted
        DateFormat format = new SimpleDateFormat("dd MMMMM, yyyy");
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date = format.parse(dob);
            dob=format2.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //encrrypt password
        String hashed_pass = BCrypt.hashpw(pass, BCrypt.gensalt());
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
            PreparedStatement ps = con.prepareStatement("insert into userdetails(first,middle,last,email,password,contact,gender,dob) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, first);
            ps.setString(2, middle);
            ps.setString(3, last);
            ps.setString(4, email);
            ps.setString(5, hashed_pass);
            ps.setString(6, contact);
            ps.setString(7, gender);
            ps.setString(8, dob);
            int i = ps.executeUpdate();
            if (i > 0) {
                RequestDispatcher rs = request.getRequestDispatcher("useraddress.jsp");
                rs.include(request, response);
            }
            else{
                RequestDispatcher rs = request.getRequestDispatcher("signupunsuccess.html");
                rs.include(request, response);
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

    }
}
