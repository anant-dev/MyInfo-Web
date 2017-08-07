/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author anants
 */
public class UpdateUserDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String first = request.getParameter("first");
        String middle = request.getParameter("middle");
        String last = request.getParameter("last");
        String email = request.getParameter("mail");
        String gender = request.getParameter("gender");
        String contact = request.getParameter("contact");
        out.println("data "+first+middle+last+"---email"+email+" gender"+gender+"contact"+contact);
        //String dob = request.getParameter("dob");
        // Date of birth formatted
//        DateFormat format = new SimpleDateFormat("dd MMMMM, yyyy");
//        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            java.util.Date date = format.parse(dob);
//            dob=format2.format(date);
//        } catch (ParseException ex) {
//            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
            //PreparedStatement ps = con.prepareStatement("UPDATE userdetails SET first=?,middle=?,last=?,contact=?,gender=?  WHERE email=?");
            PreparedStatement ps = con.prepareStatement("UPDATE userdetails SET first=?,middle=?,last=?,contact=?,gender=? WHERE email=?");
            ps.setString(1, first);
            ps.setString(2, middle);
            ps.setString(3, last);
            ps.setString(4, contact);
            ps.setString(5, gender);
            ps.setString(6, email);
//            out.println("data ---------"+ ps.executeUpdate());
            int i = ps.executeUpdate();
            if (i > 0) {
                RequestDispatcher rs = request.getRequestDispatcher("updatesuccess.html");
                rs.include(request, response);
            }
            else{
                RequestDispatcher rs = request.getRequestDispatcher("updateunsuccess.html");
                rs.include(request, response);
            }

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
