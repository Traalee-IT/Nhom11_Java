package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.Danhgiarenluyen;
import Model.Thisinh;
import Model.Tinh;

public class ConnKetQuanHocTap {
  public static  ConnKetQuanHocTap ketqua() {
	  return new ConnKetQuanHocTap();
  }
  
  public ArrayList<Thisinh> SelectThongTin() {
	  ArrayList<Thisinh> arr=new ArrayList<Thisinh>();
	  try { 	
			
			// bước 1;kết nối với lại sql
				    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName);
					   java.sql.Statement st=conection.createStatement();

				  String sql="SELECT* FROM QUANLYSINHVIEN ";
				  ResultSet ketqua=st.executeQuery(sql);
                 while(ketqua.next()) {
                	 
                	 String id=ketqua.getString("MASV");
				     String ho=ketqua.getString ("HO");
			    	 String tenThisinh=ketqua.getString("TEN");
			    	 String quequan=ketqua.getString("QUEQUAN");
			    	 Tinh tinh=Tinh.getTinhByTen(quequan+"");
			    	
			         Date ngaysinh=ketqua.getDate("NGAYSINH");
			    	
			    	 boolean gioitinh=ketqua.getBoolean("GIOITINH");
			    	 String lop=ketqua.getString("LOP");
			    	 String hocky=ketqua.getString("HOCKY");
			         float diemtoan =ketqua.getFloat("CHUNGHIAXAHOI");
			         float diemly =ketqua.getFloat("TUTUONGHCM");
			         float diemhoa=ketqua.getFloat("NHAPMONTINOC");
			         float diemtb=ketqua.getFloat("DIEMTB");
				    	
			         arr.add(new Thisinh(id,ho,tenThisinh,tinh,ngaysinh,gioitinh,lop,hocky,diemtoan,diemly,diemhoa,diemtb));
				    }
				  
				
                 DataBasSQL.closeConnect(conection);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  return arr ;
  }
}
