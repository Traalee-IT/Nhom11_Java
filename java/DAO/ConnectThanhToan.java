package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;

public class ConnectThanhToan {
          public ConnectThanhToan getConnect() {
        	  return new ConnectThanhToan();
        	  
          }
    public int updateThanhToan() {
    	try {
    		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
    			
    		  
    			String sql=" UPDATE "
    					+ " SET ho=?,ten=?,quequan=?,ngaysinh=?,gioitinh=?,lop=?,HOCKY=?,CHUNGHIAXAHOI=?,TUTUONGHCM=?, NHAPMONTINOC=?,DIEMTB=? where masv=?";
    		 
    		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
    		  
    	}catch(SQLException ex) {
                  ex.printStackTrace();
    	}
    	return 0;
    }
}
