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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anants
 */
@WebServlet(urlPatterns = {"/updateuserint"})
public class UpdateUserInt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("");
        String email = request.getParameter("mail");
        String sports = request.getParameter("sports");
        String reading = request.getParameter("reading");
        String computer = request.getParameter("computer");
        String songs = request.getParameter("songs");
        String dance = request.getParameter("dance");
        String photography = request.getParameter("photography");
        String fashion = request.getParameter("fashion");
        String painting = request.getParameter("painting");
        String traveling = request.getParameter("traveling");
        String writing = request.getParameter("writing");
        String gaming = request.getParameter("gaming");
        String cooking = request.getParameter("cooking");
        try   {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
            PreparedStatement ps = con.prepareStatement("UPDATE user_interest SET sports=?,reading=?,computer=?,songs=?,dance=?,photography=?,"
                    + "fashion=?,painting=?,traveling=?,writing=?,gaming=?,cooking=? WHERE email=?");
            if(sports == null){
            ps.setInt(1,0);
            }else{
                ps.setInt(1,1);
            }
            if(reading == null){
            ps.setInt(2,0);
            }else{
                ps.setInt(2,1);
            }
            if(computer == null){
            ps.setInt(3,0);
            }else{
                ps.setInt(3,1);
            }
            if(songs == null){
            ps.setInt(4,0);
            }else{
                ps.setInt(4,1);
            }
            if(dance == null){
            ps.setInt(5,0);
            }else{
                ps.setInt(5,1);
            }
            if(photography == null){
            ps.setInt(6,0);
            }else{
                ps.setInt(6,1);
            }
            if(fashion == null){
            ps.setInt(7,0);
            }else{
                ps.setInt(7,1);
            }
            if(painting == null){
            ps.setInt(8,0);
            }else{
                ps.setInt(8,1);
            }
            if(traveling == null){
            ps.setInt(9,0);
            }else{
                ps.setInt(9,1);
            }
            if(writing == null){
            ps.setInt(10,0);
            }else{
                ps.setInt(10,1);
            }
            if(gaming == null){
            ps.setInt(11,0);
            }else{
                ps.setInt(11,1);
            }
            if(cooking == null){
            ps.setInt(12,0);
            }else{
                ps.setInt(12,1);
            }
            ps.setString(13, email);
            int i=ps.executeUpdate();
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
