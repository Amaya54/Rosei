package Model;

import java.sql.*;
import java.util.*;


public class ConnectionManager {

   Connection con;
   Connection con1;
   static String url;
   static String url1;
         
   public  Connection getConnection()
   {
     
      try
      {
         //String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name

         Class.forName("com.ibm.db2.jcc.DB2Driver");
         
         try
         {            	
            con = DriverManager.getConnection( "jdbc:db2://172.16.2.2:50000/rosei", "prayas", "1sai2ram3baba"); 
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
   
   
   public  Connection getConnection1()
   {
     
      try
      {
         //String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name

         Class.forName("com.ibm.db2.jcc.DB2Driver");
         
         try
         {            	
            con1 = DriverManager.getConnection( "jdbc:db2://172.16.2.2:50000/record", "prayas", "1sai2ram3baba"); 
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con1;
}
   
   
}