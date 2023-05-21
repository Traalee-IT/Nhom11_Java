package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.Thisinh;
import Model.Tinh;

public class connTaiKhoan {
           public static connTaiKhoan  updateDoiTaiKhoan() {
        	  return  new connTaiKhoan ();
           }
        public int doimatkhau(String matkhau,String masv) {
      	  try { 	
     		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
     		String sql=" UPDATE TAIKHOANSV"
     				+ " SET MATKHAU=? where MASV=?";
     	 
     	  java.sql.PreparedStatement st=conection.prepareStatement(sql);
     	       st.setString(1,matkhau);
     	      st.setString(2,masv);
           int ketqua=st.executeUpdate();   
     	  DataBasSQL.closeConnect(conection);
     	  
     	} catch (SQLException e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
     	}



        	return 0;
        }
        public String matKhauCu(String masv) {
        	    String matkhau="";
        	    try { 	
 		  String sql="SELECT MATKHAU FROM TAIKHOANSV WHERE MASV=? ";
 					    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName);
 					   java.sql.PreparedStatement st=conection.prepareStatement(sql);
               
 					
 					      st.setString(1,masv);
 					  ResultSet ketqua=st.executeQuery();
                        while(ketqua.next()) {
 					    	
 						  matkhau=ketqua.getString("MATKHAU");
 						   
 						
 					    }
 					  
 					
                        DataBasSQL.closeConnect(conection);
 					
 					} catch (SQLException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
 		      return matkhau ;
        }
}
