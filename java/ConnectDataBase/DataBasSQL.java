package ConnectDataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataBasSQL {
	  public static Connection getConect() {
    	  // Dang ki driver
		  Connection c=null;
	    	 try {
	    		 // đây là thực hiệ chứac năng kết nói với csdl theo localhos và địa chỉ ip
	    		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	    	 c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=sa;encrypt=false");
	    	 }catch(Exception e) {
	    		e.printStackTrace(); 
	    	 }
	    	
	    	 return c;
     }
	  public static Connection getConect(String dataBaseName) {
		  // Dang ki driver
		  Connection c=null;
	    	 try {
	    		 // đây là thực hiệ chứac năng kết nói với csdl theo localhos và địa chỉ ip
	    		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	    	 c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+ dataBaseName +";user=sa;password=sa;encrypt=false");
	    	 }catch(Exception e) {
	    		e.printStackTrace(); 
	    	 }
	    	
	    	 return c;
     }
   public static void closeConnect(Connection c) {
	   if(c!=null) {
		   try {
			   c.close();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
   }
   public static void printInfor(Connection c) {
		  if(c!=null) {
			  try {
				  // in ra thong ten của hẹ quantricsdl và vesion
				 DatabaseMetaData mbmd=c.getMetaData();
				 System.out.println(mbmd.getDatabaseProductName());
				  // lấy ra thông tin bằng getmetadata của cái bảng sql
				//System.out.println(c.getMetaData().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

}
   	
}
