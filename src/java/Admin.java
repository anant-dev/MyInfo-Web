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
public class Admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter();
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
                + "     	</style>\n"
                + "    </head>\n"
                + "\n"
                + "    <body>\n"
                + "	       \n"
                + "    	<nav class=\"light-blue darken-4\">\n"
                + "	        <div class=\"nav-wrapper container\">\n"
                + "	          <a href=\"#\" class=\"brand-logo \"><img src=\"logo.png\" class=\"center\" height=\"50\" style=\"margin: 5%\"></a>\n"
                + "	          <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n"
                + "	            <li><a href=\"index.html\">Logout</a></li>\n"
                + "	            <li><a href=\"about.html\">About</a></li>\n"
                + "	          </ul>\n"
                + "	        </div>\n"
                + "    	</nav>\n"
                + "    	<div>\n"
                + "    		<img id=\"banner\" src=\"banner3.png\">\n"
                + "    	</div>\n"
                + "    	<div class=\"container\" >\n"
                + "		     \n"
                + "			    <div class=\"card-panel z-depth-2\" style=\"padding: 20px \">\n"
                + "			      <h4 class=\"light-blue-text text-darken-4 center\"><b>User Details</b></h4><br>\n"
                + "			    <table class=\"striped\">\n"
                + "			        <thead>\n"
                + "			          <tr>\n"
                + "			              <th>Name</th>\n"
                + "			              <th>Email</th>\n"
                + "			              <th>Contact</th>\n"
                + "			              <th>More Info</th>\n"
                + "			          </tr>\n"
                + "			        </thead>\n"
                + "\n"
                + "			        <tbody>");
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mindfire");
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM userdetails");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Retrieve by column name
                String first = rs.getString("first");
                String middle = rs.getString("middle");
                String last = rs.getString("last");
                String emaildb = rs.getString("email");
                String contact = rs.getString("contact");
                //Display values
                out.println(" <tr>\n"
                        + "            <td>" + first + middle + last + "</td>\n"
                        + "            <td>" + emaildb + "</td>\n"
                        + "            <td>" + contact + "</td>\n"
                        + "            <th><a href=\"userinfo?uid=" + emaildb + "\" value=\" name=\"key\"\">click here</a></th>\n"
                        + "          </tr>");

            }
            out.println("	</tbody>\n"
                    + "		        </table> <br><br>\n"
                    + "		     </div>   	\n"
                    + "    	</div>\n"
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
