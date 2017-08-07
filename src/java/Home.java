/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anants
 */
public class Home extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter();
        out.println("		<!DOCTYPE html>\n"
                + "\n"
                + "		<head>\n"
                + "			<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n"
                + "			<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css\">\n"
                + "			<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                + "			<style>\n"
                + "				#banner {\n"
                + "					width: 100%;\n"
                + "					height: auto;\n"
                + "				}\n"
                + "\n"
                + "				.nav {\n"
                + "					background-color: #1976d2 !important;\n"
                + "				}\n"
                + "				/* label color */\n"
                + "				.input-field label {\n"
                + "					color: #01579b;\n"
                + "				}\n"
                + "				/* label focus color */\n"
                + "				.input-field input[type=text]:focus + label {\n"
                + "					color: #00b0ff;\n"
                + "				}\n"
                + "				/* label underline focus color */\n"
                + "				.input-field input[type=text]:focus {\n"
                + "					border-bottom: 1px solid #00b0ff;\n"
                + "					box-shadow: none;\n"
                + "				}\n"
                + "				.input-field input[type=email]:focus + label {\n"
                + "					color: #00b0ff;\n"
                + "				}\n"
                + "				/* label underline focus color */\n"
                + "				.input-field input[type=email]:focus {\n"
                + "					border-bottom: 1px solid #00b0ff;\n"
                + "					box-shadow: none;\n"
                + "				}\n"
                + "				/* label focus color */\n"
                + "				.input-field input[type=password]:focus + label {\n"
                + "					color: #00b0ff;\n"
                + "				}\n"
                + "				/* label underline focus color */\n"
                + "				.input-field input[type=password]:focus {\n"
                + "					border-bottom: 1px solid #00b0ff;\n"
                + "					box-shadow: none;\n"
                + "				}\n"
                + "				.input-field input[type=number]:focus + label {\n"
                + "					color: #00b0ff;\n"
                + "				}\n"
                + "				/* label underline focus color */\n"
                + "				.input-field input[type=number]:focus {\n"
                + "					border-bottom: 1px solid #00b0ff;\n"
                + "					box-shadow: none;\n"
                + "				}\n"
                + "			</style>\n"
                + "		</head>\n"
                + "\n"
                + "		<body>\n"
                + "\n"
                + "			<nav class=\"light-blue darken-4\">\n"
                + "				<div class=\"nav-wrapper container\">\n"
                + "					<a href=\"#\" class=\"brand-logo \"><img src=\"logo.png\" class=\"center\" height=\"50\" style=\"margin: 5%\"></a>\n"
                + "					<ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n"
                + "						<li><a href=\"about.html\">About</a></li>\n"
                + "					</ul>\n"
                + "				</div>\n"
                + "			</nav>\n"
                + "			<div>\n"
                + "				<img id=\"banner\" src=\"banner3.png\">\n"
                + "			</div>\n"
                + "			<div class=\"container\" style=\"padding-left: 200px; padding-right: 200px\" >\n"
                + "\n"
                + "				<div class=\"card-panel z-depth-2\" style=\"padding: 20px 80px 20px 80px\">\n"
                + "\n"
                + "					<h4 class=\"light-blue-text text-darken-4 center\"><b>User Details</b></h4>\n"
                + "					<form class=\"col s12\" method=\"post\" action=\"changeuserdetails\">\n"
                + "						<div class=\"row\">\n"
                + "							<div class=\"input-field col s4\">");
        try {
            //loading drivers for mysql
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

            //Display values
            out.println("<input id=\"first_name\" type=\"text\" name=\"first\" class=\"validate\"  disabled value=\"" + first + "\">");
            out.println("<label for=\"first_name\">First Name</label>\n"
                    + "							</div>\n"
                    + "							<div class=\"input-field col s4\">");
            out.println("<input id=\"middle_name\" type=\"text\" name=\"middle\" class=\"validate\" disabled  value=\"" + middle + "\">");
            out.println("<label for=\"middle_name\">Middle Name</label>\n"
                    + "							</div>\n"
                    + "							<div class=\"input-field col s4\">");
            out.println("<input id=\"last_name\" type=\"text\" class=\"validate\" name=\"last\" disabled value=\"" + last + "\">");
            out.println("<label for=\"last_name\">Last Name</label>\n"
                    + "</div>\n"
                    + "</div>\n"
                    + "<div class=\"row\">\n"
                    + " 	<div class=\"input-field col s12\">");
            out.println("<input id=\"email\" type=\"email\" class=\"validate\" name=\"email\" disabled value=\"" + emaildb + "\">"
                    + "<input id=\"mail\" type=\"hidden\" class=\"validate\" name=\"mail\" value=\"" + emaildb + "\">");
            out.println("<label for=\"email\">Email</label>\n"
                    + "	</div>\n"
                    + "	</div>\n"
                    + "\n"
                    + "	<div class=\"row\">\n"
                    + "		<div class=\"input-field col s3\">\n"
                    + "		<label>Gender :</label>\n"
                    + "	</div>\n"
                    + "	<div class=\"input-field col s3\">");
            if (gender.equals("male")) {
                out.println("<input class=\"with-gap\" name=\"gender\" type=\"radio\" id=\"male\" value=\"male\" disabled checked />");
            } else {
                out.println("<input class=\"with-gap\" name=\"gender\" type=\"radio\" id=\"male\" value=\"male\" disabled />");
            }
            out.println("<label for=\"male\">Male</label>\n"
                    + "	</div>\n"
                    + "	<div class=\"input-field col s3\">");
            if (gender.equals("female")) {
                out.println("<input class=\"with-gap\" name=\"gender\" type=\"radio\" id=\"female\" value=\"female\" disabled checked/>");
            } else {
                out.println("<input class=\"with-gap\" name=\"gender\" type=\"radio\" id=\"female\" value=\"female\" disabled />");
            }

            out.println("<label for=\"female\">Female</label>\n"
                    + "	</div>\n"
                    + "	<div class=\"input-field col s3\">");
            if (gender.equals("others")) {
                out.println("<input class=\"with-gap\" name=\"gender\" type=\"radio\" id=\"others\" value=\"others\" disabled checked/>");
            } else {
                out.println("<input class=\"with-gap\" name=\"gender\" type=\"radio\" id=\"others\" value=\"others\" disabled />");
            }
            out.println("<label for=\"others\">Others</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">");
            out.println("<input id=\"contact\" type=\"number\" class=\"validate\" disabled name=\"contact\" value=\"" + contact + "\" disabled>");
            out.println("<label for=\"contact\">Contact Number</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">");
            out.println("<input id=\"date\" type=\"text\" class=\"datepicker\" disabled name=\"dob\" value=\"" + dob + "\">");
            out.println("<label for=\"date\">Date of Birth (Birthday)</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"center\" style=\"display: none;\" id=\"save_details\">\n"
                    + "							<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\" type=\"submit\"  name=\"action\" style=\"margin-left: 30px;\">Save\n"
                    + "								<i class=\"fa fa-fighter-jet right\" aria-hidden=\"true\"></i>\n"
                    + "							</button>\n"
                    + "						</div>\n"
                    + "					</form> \n"
                    + "					<div class=\"row\">\n"
                    + "						<div class=\"center\" id=\"edit_details\">\n"
                    + "							<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\"  name=\"action\"  onclick=\"showSaveDetails()\" style=\"margin-left: 30px\">Edit\n"
                    + "								<i class=\"fa fa-pencil right\" aria-hidden=\"true\"></i>\n"
                    + "							</button>\n"
                    + "						</div>\n"
                    + "\n"
                    + "					</div>\n"
                    + "				</div>   	");

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
            String c_add = "", c_city = "", c_state = "", c_country = "";
            int c_zip = 0;

            out.println("<div class=\"card-panel z-depth-2\" style=\"padding:20px 80px 20px 80px \">\n"
                    + "					<h4 class=\"light-blue-text text-darken-4 center\"><b>User Address</b></h4><br>\n"
                    + "					<form class=\"col s12\" method=\"post\" action=\"updateuseradd\">\n"
                    + "						<h5 class=\"light-blue-text text-darken-4 \" style=\"font-size: 22px\"><b>Permanent Address :</b></h5>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">"
                    + "<input id=\"status\" type=\"hidden\" class=\"validate\" name=\"status\" value=\"" + address_status + "\">");
            out.println("<input id=\"address\" type=\"text\" class=\"validate\" name=\"p_add\" disabled value=\"" + p_add + "\">"
                    + "<input id=\"mail\" type=\"hidden\" class=\"validate\" name=\"mail\" value=\"" + emaildb + "\">");
            out.println("<label for=\"address\">Address</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">");
            out.println("<input id=\"city\" type=\"text\" class=\"validate\"  name=\"p_city\" disabled value=\"" + p_city + "\">");
            out.println("<label for=\"city\">City</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">");
            out.println("<input id=\"state\" type=\"text\" class=\"validate\"  name=\"p_state\" disabled value=\"" + p_state + "\">");
            out.println("<label for=\"state\">State</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">");
            out.println("<input id=\"country\" type=\"text\" class=\"validate\"  name=\"p_country\" disabled value=\"" + p_country + "\">");
            out.println("<label for=\"country\">Country</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<div class=\"row\">\n"
                    + "							<div class=\"input-field col s12\">");
            out.println("<input id=\"zipcode\" type=\"number\" class=\"validate\"  name=\"p_zip\" disabled value=\"" + p_zip + "\">");
            out.println("<label for=\"zipcode\">Zipcode</label>\n"
                    + "							</div>\n"
                    + "						</div>\n"
                    + "						<br>");

            out.println("<div class=\"row\">\n"
                    + "							<div class=\"col s6\">\n"
                    + "								<h5 class=\"light-blue-text text-darken-4 \" style=\"font-size: 22px\"><b>Current Address :</b></h5>\n"
                    + "							</div>\n"
                    + "							<div class=\"col s6 \" style=\"padding: 15px\">\n");
            if (address_status.equals("notsame")) {
                PreparedStatement psac = con.prepareStatement("SELECT * FROM test.current_add where email=?");
                psac.setString(1, email);
                ResultSet rsac = psac.executeQuery();
                rsac.next();
                c_add = rsac.getString("address");
                c_city = rsac.getString("city");
                c_state = rsac.getString("state");
                c_country = rsac.getString("country");
                c_zip = rsac.getInt("zipcode");

                out.println(" <input type=\"checkbox\" class=\"filled-in\" id=\"address_same\" name=\"address_same\" disabled/>\n"
                        + "<label for=\"address_same\" class=\"light-blue-text text-darken-4 right\">Same as Permanent</label>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"row\">\n"
                        + "<div class=\"input-field col s12\">");
                out.println("<input id=\"c_address\" type=\"text\" class=\"validate\"  name=\"a_add\" disabled value=\"" + c_add + "\"> ");
                out.println("<label for=\"address\">Address</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_city\" type=\"text\" class=\"validate\"  name=\"a_city\" disabled value=\"" + c_city + "\">");
                out.println("<label for=\"city\">City</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_state\" type=\"text\" class=\"validate\"  name=\"a_state\" disabled value=\"" + c_state + "\">");
                out.println("<label for=\"state\">State</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_country\" type=\"text\" class=\"validate\"  name=\"a_country\" disabled value=\"" + c_country + "\">");
                out.println("<label for=\"country\">Country</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_zipcode\" type=\"number\" class=\"validate\"  name=\"a_zip\" disabled value=\"" + c_zip + "\">");
                out.println("<label for=\"xipcode\">Zipcode</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<br>\n"
                        + "						<div class=\"center\" style=\"display: none;\" id=\"save_add\">\n"
                        + "							<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\" type=\"submit\"  name=\"action\" style=\"margin-left: 30px;\">Save\n"
                        + "								<i class=\"fa fa-fighter-jet right\" aria-hidden=\"true\"></i>\n"
                        + "							</button>\n"
                        + "						</div>\n"
                        + "					</form> \n"
                        + "					<div class=\"row\">\n"
                        + "						<div class=\"center\" id=\"edit_add\"> \n"
                        + "							<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\"  name=\"action\"  onclick=\"showSaveAdd()\" style=\"margin-left: 30px\">Edit\n"
                        + "								<i class=\"fa fa-pencil right\" aria-hidden=\"true\"></i>\n"
                        + "							</button>\n"
                        + "						</div>\n"
                        + "\n"
                        + "					</div>\n"
                        + "					<br>\n"
                        + "				</div>");
            } else {
                out.println(" <input type=\"checkbox\" class=\"filled-in\" id=\"address_same\" name=\"address_same\" checked disabled/>\n"
                        + "<label for=\"address_same\" class=\"light-blue-text text-darken-4 right\">Same as Permanent</label>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"row\">\n"
                        + "<div class=\"input-field col s12\">");
                out.println("<input id=\"c_address\" type=\"text\" class=\"validate\"  name=\"a_add\" disabled value=\"\"> ");
                out.println("<label for=\"address\">Address</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_city\" type=\"text\" class=\"validate\"  name=\"a_city\" disabled value=\"\">");
                out.println("<label for=\"city\">City</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_state\" type=\"text\" class=\"validate\"  name=\"a_state\" disabled value=\"\">");
                out.println("<label for=\"state\">State</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_country\" type=\"text\" class=\"validate\"  name=\"a_country\" disabled value=\"\">");
                out.println("<label for=\"country\">Country</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<div class=\"row\">\n"
                        + "							<div class=\"input-field col s12\">");
                out.println("<input id=\"c_zipcode\" type=\"number\" class=\"validate\"  name=\"a_zip\" disabled value=\"\">");
                out.println("<label for=\"xipcode\">Zipcode</label>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						<br>\n"
                        + "						<div class=\"center\" style=\"display: none;\" id=\"save_add\">\n"
                        + "							<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\" type=\"submit\"  name=\"action\" style=\"margin-left: 30px;\">Save\n"
                        + "								<i class=\"fa fa-fighter-jet right\" aria-hidden=\"true\"></i>\n"
                        + "							</button>\n"
                        + "						</div>\n"
                        + "					</form> \n"
                        + "					<div class=\"row\">\n"
                        + "						<div class=\"center\" id=\"edit_add\"> \n"
                        + "							<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\"  name=\"action\"  onclick=\"showSaveAdd()\" style=\"margin-left: 30px\">Edit\n"
                        + "								<i class=\"fa fa-pencil right\" aria-hidden=\"true\"></i>\n"
                        + "							</button>\n"
                        + "						</div>\n"
                        + "\n"
                        + "					</div>\n"
                        + "					<br>\n"
                        + "				</div>");
            }

            //USER Address
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
            out.println("<div class=\"card-panel z-depth-2\" style=\"padding: 20px 80px 20px 80px\">\n"
                    + "     <h4 class=\"light-blue-text text-darken-4 center\"><b>User Interest</b></h4><br>\n"
                    + "     <div style=\"padding: 20px 0px 20px 30%\">\n"
                    + "     <form class=\"col s12\" method=\"post\" action=\"updateuserint\">\n"
                    + "			<div class=\"row\">\n"
                    + "									<div class=\"input-field col s12  \">");
            out.println("<input id=\"mail\" type=\"hidden\" class=\"validate\" name=\"mail\" value=\"" + emaildb + "\">");
            out.println("");
            if (sports == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"sports\" name=\"sports\" disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"sports\" name=\"sports\" disabled />");
            }
            out.println("<label for=\"sports\">Sports</label>\n"
                    + "	</div>\n"
                    + "	</div>\n"
                    + " <div class=\"row\">\n"
                    + "		<div class=\"input-field col s12  \">");
            if (reading == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"reading\" name=\"reading\" disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"reading\" name=\"reading\" disabled/>");
            }
            out.println("<label for=\"reading\">Reading</label>\n"
                    + "	</div>\n"
                    + "		</div>\n"
                    + "		<div class=\"row\">\n"
                    + "		<div class=\"input-field col s12  \">");
            if (computer == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"computer\" name=\"computer\" disabled/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"computer\" name=\"computer\" disabled/>");
            }
            out.println("<label for=\"computer\">Computer and Software</label>\n"
                    + "	</div>\n"
                    + "								</div>\n"
                    + "								<div class=\"row\">\n"
                    + "									<div class=\"input-field col s12  \">");
            if (songs == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"songs\" name=\"songs\" disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"songs\" name=\"songs\" disabled/>");
            }
            out.println("<label for=\"songs\">Songs</label>\n"
                    + "</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "	<div class=\"input-field col s12  \">");
            if (dance == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"dance\" name=\"dance\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"dance\" name=\"dance\"  disabled/>");
            }
            out.println("<label for=\"dance\">Dance</label>\n"
                    + "</div>\n"
                    + "	</div>\n"
                    + "<div class=\"row\">\n"
                    + "	<div class=\"input-field col s12  \">");
            if (photography == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"photography\" name=\"photography\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"photography\" name=\"photography\"  disabled/>");
            }
            out.println("<label for=\"photography\">Photography</label>\n"
                    + "	</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "	<div class=\"input-field col s12  \">");
            if (fashion == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"fashion\" name=\"fashion\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"fashion\" name=\"fashion\"  disabled/>");
            }
            out.println("<label for=\"fashion\">Fashion</label>\n"
                    + "</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "	<div class=\"input-field col s12  \">");
            if (painting == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"painting\" name=\"painting\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"painting\" name=\"painting\"  disabled/>");
            }
            out.println("<label for=\"painting\">Painting</label>\n"
                    + "</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "<div class=\"input-field col s12  \">");
            if (traveling == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"traveling\" name=\"traveling\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"traveling\" name=\"traveling\"  disabled/>");
            }
            out.println("<label for=\"traveling\">Traveling</label>\n"
                    + "	</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "<div class=\"input-field col s12  \">");
            if (writing == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"writing\" name=\"writing\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"writing\" name=\"writing\"  disabled/>");
            }
            out.println("<label for=\"writing\">Writing</label>\n"
                    + "	</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "	<div class=\"input-field col s12  \">");
            if (gaming == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"gaming\" name=\"gaming\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"gaming\" name=\"gaming\"  disabled/>");
            }
            out.println("<label for=\"gaming\">Gaming</label>\n"
                    + "	</div>\n"
                    + "	</div>\n"
                    + "	<div class=\"row\">\n"
                    + "		<div class=\"input-field col s12  \">");
            if (cooking == 1) {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"cooking\" name=\"cooking\"  disabled checked/>");
            } else {
                out.println("<input type=\"checkbox\" class=\"filled-in\" id=\"cooking\" name=\"cooking\"  disabled/>");
            }
            out.println("<label for=\"cooking\">Cooking</label>\n"
                    + "									</div>\n"
                    + "								</div>  \n"
                    + "							</div>			 \n"
                    + "	<div class=\"center\" style=\"display: none;\" id=\"save_int\">\n"
                    + "	<button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\" type=\"submit\"  name=\"action\" style=\"margin-left: 30px;\">Save\n"
                    + "		<i class=\"fa fa-fighter-jet right\" aria-hidden=\"true\"></i>\n"
                    + "	</button>\n"
                    + "	</div>\n"
                    + "	</form> 		\n"
                    + "						 \n"
                    + "	<div class=\"row\">\n"
                    + "	<div class=\"center\" id=\"edit_int\">\n"
                    + " <button class=\"btn waves-effect waves-light light-blue darken-4 z-depth-2\"  id=\"edit_int\" name=\"action\" onclick=\"showSaveInt()\"  style=\"margin-left: 30px\">Edit\n"
                    + "		<i class=\"fa fa-pencil right\" aria-hidden=\"true\"></i>\n"
                    + "		</button>\n"
                    + "		</div>\n"
                    + "\n"
                    + "	</div>\n"
                    + "</div>   ");

            //Main div closed below
            out.println("</div>   	\n"
                    + "			</div>\n"
                    + "			<footer class=\"page-footer light-blue darken-4\">\n"
                    + "				<div class=\"footer-copyright\">\n"
                    + "					<div class=\"container\">\n"
                    + "						© 2017 Copyright &emsp; &emsp; &emsp; &emsp; Made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i>	 while drinking <i class=\"fa fa-coffee\" aria-hidden=\"true\"></i>\n"
                    + "						<a class=\"grey-text text-lighten-4 right\" href=\"#!\">More Links</a>\n"
                    + "					</div>\n"
                    + "				</div>\n"
                    + "			</footer>\n"
                    + "			<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                    + "			<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js\"></script>\n"
                    + "\n"
                    + "			<script type=\"text/javascript\">\n"
                    + "				$('.datepicker').pickadate({\n"
                    + "				    selectMonths: true, // Creates a dropdown to control month\n"
                    + "				    selectYears: 15, // Creates a dropdown of 15 years to control year,\n"
                    + "				    today: 'Today',\n"
                    + "				    clear: 'Clear',\n"
                    + "				    close: 'Ok',\n"
                    + "				    closeOnSelect: false // Close upon selecting a date,\n"
                    + "				});\n"
                    + "				$(document).ready(function(){\n"
                    + "					$(\"#edit_details\").click(function(){\n"
                    + "						document.getElementById('first_name').disabled = false;\n"
                    + "						document.getElementById('middle_name').disabled = false;\n"
                    + "						document.getElementById('last_name').disabled = false;\n"
                    + "						document.getElementById('male').disabled = false;\n"
                    + "						document.getElementById('female').disabled = false;\n"
                    + "						document.getElementById('others').disabled = false;\n"
                    + "						document.getElementById('contact').disabled = false;\n"
                    + "					});\n"
                    + "\n"
                    + "					$(\"#edit_add\").click(function(){\n"
                    + "						document.getElementById('address').disabled = false;\n"
                    + "						document.getElementById('city').disabled = false;\n"
                    + "						document.getElementById('state').disabled = false;\n"
                    + "						document.getElementById('country').disabled = false;\n"
                    + "						document.getElementById('zipcode').disabled = false;\n"
                    + "                                         document.getElementById('c_address').disabled = false;\n"
                    + "						document.getElementById('c_city').disabled = false;\n"
                    + "						document.getElementById('c_state').disabled = false;\n"
                    + "						document.getElementById('c_country').disabled = false;\n"
                    + "                                         document.getElementById('c_zipcode').disabled = false;\n"
                    + "						document.getElementById('address_same').disabled = false;\n"
                    + "					});\n"
                    + "\n"
                    + "					$(\"#edit_int\").click(function(){\n"
                    + "						document.getElementById('sports').disabled = false;\n"
                    + "						document.getElementById('reading').disabled = false;\n"
                    + "						document.getElementById('computer').disabled = false;\n"
                    + "						document.getElementById('songs').disabled = false;\n"
                    + "						document.getElementById('dance').disabled = false;\n"
                    + "						document.getElementById('photography').disabled = false;\n"
                    + "						document.getElementById('fashion').disabled = false;\n"
                    + "						document.getElementById('painting').disabled = false;\n"
                    + "						document.getElementById('traveling').disabled = false;\n"
                    + "						document.getElementById('writing').disabled = false;\n"
                    + "						document.getElementById('gaming').disabled = false;\n"
                    + "						document.getElementById('cooking').disabled = false;\n"
                    + "					});\n"
                    + "				});\n"
                    + "				function showSaveDetails(){\n"
                    + "					document.getElementById(\"save_details\").style.display='block';\n"
                    + "					document.getElementById(\"edit_details\").style.display='none';\n"
                    + "				}\n"
                    + "				function showEditDetails(){\n"
                    + "					document.getElementById(\"save_details\").style.display='none';\n"
                    + "					document.getElementById(\"edit_details\").style.display='block';\n"
                    + "				}\n"
                    + "				function showSaveAdd(){\n"
                    + "					document.getElementById(\"save_add\").style.display='block';\n"
                    + "					document.getElementById(\"edit_add\").style.display='none';\n"
                    + "				}\n"
                    + "				function showSaveInt(){\n"
                    + "					document.getElementById(\"save_int\").style.display='block';\n"
                    + "					document.getElementById(\"edit_int\").style.display='none';\n"
                    + "				}\n"
                    + "\n"
                    + "			</script>\n"
                    + "		</body>\n"
                    + "		</html>");

        } catch (Exception se) {
            se.printStackTrace();
        }
        

    }//method close
}// class
