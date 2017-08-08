/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author anants
 */
public class Login extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String contact =request.getParameter("contact");
        int status = Validate.checkUser(email, pass,contact);
        
       if (status == 1) {
            
               try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
                   PreparedStatement pse = con.prepareStatement("SELECT * FROM userdetails where email=? or contact=?");
                   pse.setString(1, email);
                   pse.setString(2, contact);
                   ResultSet rse = pse.executeQuery();
                   rse.next();
                   //Retrieve by column name
                   email = rse.getString("email");
                   

               } catch (Exception e) {

               }
               request.setAttribute("mail",email);
               RequestDispatcher rs = request.getRequestDispatcher("Home");
               rs.forward(request, response);
           
       }
        else if(status == 2){
            RequestDispatcher rs = request.getRequestDispatcher("Admin");
            rs.forward(request, response);
        }
        else if(status == 0){
           out.println("<script> alert(\"Your Account has been Deactivated\");</script>");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
        else if(status == 3)
        {
           out.println("<script> alert(\"Password incorrect\");</script>");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
        else{
           out.println("<script> alert(\"You are not Registered with My info Do Signup !!!\");</script>");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}
