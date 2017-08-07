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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anants
 */
public class SignUpAddress extends HttpServlet {

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
        String email = request.getParameter("email");
        String p_add = request.getParameter("p_add");
        String p_city = request.getParameter("p_city");
        String p_state = request.getParameter("p_state");
        String p_country = request.getParameter("p_country");
        int p_zip = Integer.parseInt(request.getParameter("p_zip"));
        String address_same = request.getParameter("address_same");
        String a_add="", a_city="", a_state="", a_country="";
        int a_zip=0;
        int i,j=0;
        if (address_same == null) {
            a_add = request.getParameter("a_add");
            a_city = request.getParameter("a_city");
            a_state = request.getParameter("a_state");
            a_country = request.getParameter("a_country");
            a_zip = Integer.parseInt( request.getParameter("a_zip"));
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
            PreparedStatement ps = con.prepareStatement("insert into permanent_add values(?,?,?,?,?,?)");
            ps.setString(1, email);
            ps.setString(2, p_add);
            ps.setString(3, p_city);
            ps.setString(4, p_state);
            ps.setString(5, p_country);
            ps.setInt(6, p_zip);
            i=ps.executeUpdate();
            if (address_same == null) {
                PreparedStatement psa = con.prepareStatement("insert into current_add values(?,?,?,?,?,?)");
                psa.setString(1, email);
                psa.setString(2, a_add);
                psa.setString(3, a_city);
                psa.setString(4, a_state);
                psa.setString(5, a_country);
                psa.setInt(6, a_zip);
                j=psa.executeUpdate();
            }
            else{
                PreparedStatement psa = con.prepareStatement("UPDATE test.userdetails SET address_status = 'same' WHERE email=?");
                psa.setString(1, email);
                j=psa.executeUpdate();
            }
            if (i > 0 && j>0) {
             RequestDispatcher rs = request.getRequestDispatcher("userinterest.jsp");
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
