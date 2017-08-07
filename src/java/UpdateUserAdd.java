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
public class UpdateUserAdd extends HttpServlet {

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
        String email = request.getParameter("mail");
        String p_add = request.getParameter("p_add");
        String p_city = request.getParameter("p_city");
        String p_state = request.getParameter("p_state");
        String p_country = request.getParameter("p_country");
        int p_zip = Integer.parseInt(request.getParameter("p_zip"));
        String address_same = request.getParameter("address_same");
        String address_status=request.getParameter("status");
        //out.println(email+"--"+address_same+"--"+address_status);
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
            PreparedStatement ps = con.prepareStatement("UPDATE permanent_add SET address=?,city=?,state=?,country=?,zipcode=? WHERE email=?");
            ps.setString(1, p_add);
            ps.setString(2, p_city);
            ps.setString(3, p_state);
            ps.setString(4, p_country);
            ps.setInt(5, p_zip);
            ps.setString(6, email);
            i=ps.executeUpdate();
            if (address_same == null) {
              if(address_status.equals("notsame")){
                PreparedStatement psa = con.prepareStatement("UPDATE current_add SET address=?,city=?,state=?,country=?,zipcode=? WHERE email=?");
                psa.setString(1, a_add);
                psa.setString(2, a_city);
                psa.setString(3, a_state);
                psa.setString(4, a_country);
                psa.setInt(5, a_zip);
                psa.setString(6, email);
                j=psa.executeUpdate();
              }
              if(address_status.equals("same")){
                PreparedStatement psa = con.prepareStatement("insert into current_add values(?,?,?,?,?,?)");
                psa.setString(1, email);
                psa.setString(2, a_add);
                psa.setString(3, a_city);
                psa.setString(4, a_state);
                psa.setString(5, a_country);
                psa.setInt(6, a_zip);
                j=psa.executeUpdate();
              }
               PreparedStatement psaa = con.prepareStatement("UPDATE test.userdetails SET address_status = 'notsame' WHERE email=?");
                psaa.setString(1, email);
                psaa.executeUpdate();
            }
            else{
                if(address_status.equals("notsame")){
                PreparedStatement psaaa = con.prepareStatement("DELETE FROM current_add WHERE email=?");
                psaaa.setString(1, email);
                psaaa.executeUpdate();
                } 
                PreparedStatement psa = con.prepareStatement("UPDATE test.userdetails SET address_status = 'same' WHERE email=?");
                psa.setString(1, email);
                j=psa.executeUpdate();
            }
            if (i > 0 && j>0) {
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
