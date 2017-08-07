/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anants
 */
import java.io.PrintWriter;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
public class Validate {
    public static int checkUser(String email,String pass) 
     {
      int status = 0;
      try{
//        String p="anant";
//        String hashed_pass = BCrypt.hashpw(p, BCrypt.gensalt());
	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test","root","mindfire");
         
         PreparedStatement ps =con.prepareStatement
                             ("select * from userdetails where (email=? or contact=?)");
         ps.setString(1, email);
         ps.setString(2, email);
         ResultSet rs =ps.executeQuery();
         rs.next();
         String passdb = rs.getString("password");
        // System.out.println(" original---------"+p+"crypt----------------"+hashed_pass+"---status ----"+BCrypt.checkpw(p, hashed_pass));
         if (BCrypt.checkpw(pass,passdb)){     
         status = rs.getInt("status");
         }
         else{
             status=3;
         }
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return status;                 
  }   
}
