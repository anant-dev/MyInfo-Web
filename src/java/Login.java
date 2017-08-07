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
        int status = Validate.checkUser(email, pass);
        
        if(status == 1)
        {
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
        else
        {
           out.println("<script> alert(\"Username or Password incorrect\");</script>");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}
