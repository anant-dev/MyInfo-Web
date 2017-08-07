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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anants
 */
public class UserInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("uid");
        String info = request.getParameter("info");
        PrintWriter out = response.getWriter();
        //out.println("rr"+email);
        out.println("<!DOCTYPE html>\n"
                + "\n"
                + "    <head>\n"
                + "        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                + "        <style>\n"
                + "        #banner {\n"
                + "			    width: 100%;\n"
                + "			    height: auto;\n"
                + "			}\n"
                + "		\n"
                + "		.nav {\n"
                + "			  background-color: #1976d2 !important;\n"
                + "			}\n"
                + "			/* label color */\n"
                + "		   .input-field label {\n"
                + "		     color: #01579b;\n"
                + "		   }\n"
                + "		   /* label focus color */\n"
                + "		    .input-field input[type=text]:focus + label {\n"
                + "		     color: #00b0ff;\n"
                + "		   }\n"
                + "		    /* label underline focus color */\n"
                + "		   .input-field input[type=text]:focus {\n"
                + "		     border-bottom: 1px solid #00b0ff;\n"
                + "		   	 box-shadow: none;\n"
                + "		   }\n"
                + "		   .input-field input[type=email]:focus + label {\n"
                + "		     color: #00b0ff;\n"
                + "		   }\n"
                + "		    /* label underline focus color */\n"
                + "		   .input-field input[type=email]:focus {\n"
                + "		     border-bottom: 1px solid #00b0ff;\n"
                + "		   	 box-shadow: none;\n"
                + "		   }\n"
                + "		   /* label focus color */\n"
                + "		   .input-field input[type=password]:focus + label {\n"
                + "		     color: #00b0ff;\n"
                + "		   }\n"
                + "		    /* label underline focus color */\n"
                + "		   .input-field input[type=password]:focus {\n"
                + "		     border-bottom: 1px solid #00b0ff;\n"
                + "		   	 box-shadow: none;\n"
                + "		   }\n"
                + "		    .input-field input[type=number]:focus + label {\n"
                + "		     color: #00b0ff;\n"
                + "		   }\n"
                + "		    /* label underline focus color */\n"
                + "		   .input-field input[type=number]:focus {\n"
                + "		     border-bottom: 1px solid #00b0ff;\n"
                + "		   	 box-shadow: none;\n"
                + "		   }\n"
                + "		   h5{\n"
                + "		   		font-size: 23px;\n"
                + "		   }\n"
                + "     	</style>\n"
                + "    </head>\n"
                + "\n"
                + "    <body>\n"
                + "	       \n"
                + "    	<nav class=\"light-blue darken-4\">\n"
                + "	        <div class=\"nav-wrapper container\">\n"
                + "	          <a href=\"#\" class=\"brand-logo \"><img src=\"logo.png\" class=\"center\" height=\"50\" style=\"margin: 5%\"></a>\n"
                + "	          <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n"
                + "	            <li><a href=\"about.html\">About</a></li>\n"
                + "	          </ul>\n"
                + "	        </div>\n"
                + "    	</nav>\n"
                + "    	<div>\n"
                + "    		<img id=\"banner\" src=\"banner3.png\">\n"
                + "    	</div>\n"
                + "    	<div class=\"container\"  style=\"padding-left: 100px; padding-right: 100px\">\n"
                + "		     \n"
                + "			    <div class=\"card-panel z-depth-2\" style=\"padding: 20px 20px 30px 80px \">\n"
                + "				    <h4 class=\"light-blue-text text-darken-4 center\"><b>User Details</b></h4><br>"
                + "<div style=\"padding:  20px 0px 30px 0px\">\n"
                + "     <div class=\"row\">\n"
                + "         <div class=\"col s4\">");
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
            //USER DETAILS TABLE
            PreparedStatement ps = con.prepareStatement("SELECT * FROM userdetails where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //Retrieve by column name
            String first = rs.getString("first");
            String middle = rs.getString("middle");
            String last = rs.getString("last");
            String emaildb = rs.getString("email");
            String contact = rs.getString("contact");
            String gender = rs.getString("gender");
            String dob = rs.getString("dob");
            String address_status = rs.getString("address_status");
            int status = rs.getInt("status");

            //Display values
            out.println("<h5 class=\"light-blue-text text-darken-4 \"><b>First Name:</b> " + first + " </h5>");
            out.println("</div>\n"
                    + "<div class=\"col s4\">");
            out.println("<h5 class=\"light-blue-text text-darken-4 \"><b>Middle Name:</b> " + middle + " </h5>");
            out.println("</div>\n"
                    + "	<div class=\"col s4\">");
            out.println("<h5 class=\"light-blue-text text-darken-4 \"><b>Last Name:</b> " + last + " </h5>");
            out.println("</div>\n"
                    + "</div>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Email :</b>  " + emaildb + " </h5>"
                    + "<input id=\"mail\" type=\"hidden\" class=\"validate\" name=\"mail\" value=\"" + emaildb + "\">");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Contact Number :</b> " + contact + "</h5>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Gender :</b>  " + gender + "</h5>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Date of Birth (Birthday) :</b>  " + dob + "</h5>");
            if (status == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Status :</b> Active  </h5><br>");
            } else if (status == 2) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Status :</b> Admin  </h5><br>");
            } else {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Status :</b> Deactive  </h5><br>");
            }
            out.println(" </div>\n"
                    + "	</div> "); // userinfo card closed

            //USER Address
            PreparedStatement psap = con.prepareStatement("SELECT * FROM permanent_add where email=?");
            psap.setString(1, email);
            ResultSet rsap = psap.executeQuery();
            rsap.next();
            //Retrieve by column name
            String p_add = rsap.getString("address");
            String p_city = rsap.getString("city");
            String p_state = rsap.getString("state");
            String p_country = rsap.getString("country");
            int p_zip = rsap.getInt("zipcode");
            String a_add = "", a_city = "", a_state = "", a_country = "";
            int a_zip = 0;
            out.println("<div class=\"card-panel z-depth-2\" style=\"padding: 20px 0px 30px 0px\">\n"
                    + "     <h4 class=\"light-blue-text text-darken-4 center\"><b>User Address</b></h4><br>\n"
                    + "		<div style=\"padding:  20px 20px 30px 80px\">");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Permanent Address :</b> " + p_add + "</h5>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>City :</b> " + p_city + "</h5>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>State :</b> " + p_state + "</h5>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Country :</b> " + p_country + "</h5>");
            out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Zipcode :</b> " + p_zip + "</h5> <br>");
            if (address_status.equals("notsame")) {
                PreparedStatement psac = con.prepareStatement("SELECT * FROM current_add where email=?");
                psac.setString(1, email);
                ResultSet rsac = psac.executeQuery();
                rsac.next();
                a_add = rsac.getString("address");
                a_city = rsac.getString("city");
                a_state = rsac.getString("state");
                a_country = rsac.getString("country");
                a_zip = rsac.getInt("zipcode");
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Current Address :</b> " + a_add + "</h5>");
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>City :</b> " + a_city + "</h5>");
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>State :</b> " + a_state + "</h5>");
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Country :</b> " + a_country + "</h5>");
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>Zipcode :</b> " + a_zip + "</h5> <br>");
            }
            out.println("</div>\n"
                    + "			    </div>"); // user address card closed
            //USER Address
            out.println("<div class=\"card-panel z-depth-2\" style=\"padding:  20px 0px 30px 0px\">\n"
                    + "				    <h4 class=\"light-blue-text text-darken-4 center\"><b>User Interest</b></h4><br>\n"
                    + "				    <div style=\"padding: 20px 0px 20px 40%\">");
            PreparedStatement psi = con.prepareStatement("SELECT * FROM user_interest where email=?");
            psi.setString(1, email);
            ResultSet rsi = psi.executeQuery();
            rsi.next();
            //Retrieve by column name
            int sports = rsi.getInt("sports");
            int reading = rsi.getInt("reading");
            int computer = rsi.getInt("computer");
            int songs = rsi.getInt("songs");
            int dance = rsi.getInt("dance");
            int photography = rsi.getInt("photography");
            int fashion = rsi.getInt("fashion");
            int painting = rsi.getInt("painting");
            int traveling = rsi.getInt("traveling");
            int writing = rsi.getInt("writing");
            int gaming = rsi.getInt("gaming");
            int cooking = rsi.getInt("cooking");

            if (sports == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Sports </b></h5>");
            }
            if (reading == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Reading </b></h5>");
            }
            if (computer == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Computer </b></h5>");
            }
            if (songs == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Songs </b></h5>");
            }
            if (dance == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Dance </b></h5>");
            }
            if (photography == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Photography </b></h5>");
            }
            if (fashion == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Fashion </b></h5>");
            }
            if (painting == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Painting </b></h5>");
            }
            if (traveling == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Traveling </b></h5>");
            }
            if (writing == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Writing </b></h5>");
            }
            if (gaming == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Gaming </b></h5>");
            }
            if (cooking == 1) {
                out.println("<h5 class=\"light-blue-text text-darken-4\"> <b>* Cooking </b></h5>");
            }

            out.println("</div>\n"
                    + "	<br>\n");
            if(status == 1){
            out.println( "	<div class=\"row\">\n"
                    + "		<form class=\"col s6\" method=\"post\" action=\"activateaccount?uid="+email+"\" >\n"
                    + "			<div class=\"right\" id=\"activate\">\n"
                    + "			<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\" type=\"submit\" name=\"action\" style=\"margin-left: 30px\">Activate\n"
                    + "			<i class=\"fa fa-heartbeat right\" aria-hidden=\"true\"></i>\n"
                    + "			</button>\n"
                    + "			</div>\n"
                    + "		</form>\n"
                    + "		<form class=\"col s6\" method=\"post\" action=\"deactivateaccount?uid="+email+"\" >\n"
                    + "			<div class=\"left\" id=\"deactivate\">\n"
                    + "			<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\" type=\"submit\" name=\"action\" style=\"margin-left: 30px\">Deactivate\n"
                    + "			<i class=\"fa fa-bomb right\" aria-hidden=\"true\"></i>\n"
                    + "			</button>\n"
                    + "			</div>\n"
                    + "		</form>\n"
                    + "	</div>\n");
            }
            // FOOTER
            out.println("</div> </div>\n"
                    + "    	 <footer class=\"page-footer light-blue darken-4\">\n"
                    + "          <div class=\"footer-copyright\">\n"
                    + "            <div class=\"container\">\n"
                    + "            © 2017 Copyright &emsp; &emsp; &emsp; &emsp; Made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i>	 while drinking <i class=\"fa fa-coffee\" aria-hidden=\"true\"></i>\n"
                    + "            <a class=\"grey-text text-lighten-4 right\" href=\"#!\">More Links</a>\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "        </footer>\n"
                    + "	    <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                    + "	    <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js\"></script>\n"
                    + "	   \n"
                    + "	    <script type=\"text/javascript\">\n"
                    + "		    $('.datepicker').pickadate({\n"
                    + "			    selectMonths: true, // Creates a dropdown to control month\n"
                    + "			    selectYears: 15, // Creates a dropdown of 15 years to control year,\n"
                    + "			    today: 'Today',\n"
                    + "			    clear: 'Clear',\n"
                    + "			    close: 'Ok',\n"
                    + "			    closeOnSelect: false // Close upon selecting a date,\n"
                    + "			  });\n"
                     
                    + "	    </script>\n"
                    + "    </body>\n"
                    + "    </html>");

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

}
