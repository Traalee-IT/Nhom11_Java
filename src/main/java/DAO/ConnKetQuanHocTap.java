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
  public ArrayList<Thisinh> SelectThongTin(String masv) {
	  ArrayList<Thisinh> arr=new ArrayList<Thisinh>();
	  try { 	
			  String sql="SELECT* FROM QUANLYSINHVIEN WHERE QUANLYSINHVIEN.MASV=?";
				    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName); 
						java.sql.PreparedStatement st = conection.prepareStatement(sql); 
						st.setString(1,masv);
				  ResultSet ketqua=st.executeQuery();
                 while(ketqua.next()) {
                	 
                	 String id=ketqua.getString("MASV");
				     String ho=ketqua.getString ("HO");
			    	 String tenThisinh=ketqua.getString("TEN");
			    	 String quequan=ketqua.getString("QUEQUAN");
			    	 Tinh tinh=Tinh.getTinhByTen(quequan+"");
			    	
			         Date ngaysinh=ketqua.getDate("NGAYSINH");
			    	
			    	 boolean gioitinh=ketqua.getBoolean("GIOITINH");
			    	 String lop=ketqua.getString("MALOP");
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
  public ArrayList<Danhgiarenluyen> selectAllconDition(String ma){
  	
 	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
 	 ArrayList<Danhgiarenluyen> showAll=new  ArrayList<Danhgiarenluyen>();
 	  String sql="SELECT* FROM QUANLYSINHVIEN,DANHGIARENLUYEN"
 	  		+ " where DANHGIARENLUYEN.MASV=?";
 	  	
 	  		
		  java.sql.PreparedStatement st;
		try {
			st = conection.prepareStatement(sql); 
			st.setString(1,ma);
		  ResultSet ketqua=st.executeQuery();
   while(ketqua.next()) {        	  
 	     String maSinhvien=ketqua.getString("MASV"); 
 	     String ho=ketqua.getString("HO");
 		 String ten=ketqua.getString("TEN");
 		 String kiHoc=ketqua.getString("kyhoc");
 		 float diemSV=ketqua.getFloat("DIEMSV");
 		 float diemCVHT=ketqua.getFloat("diemcvht");
 		 String xepLoairenluyen=ketqua.getString("xeploairenluyen");
 	    String ghichu=ketqua.getString("ghichu");
        showAll.add(new Danhgiarenluyen(maSinhvien,ho,ten, kiHoc, diemSV, diemCVHT, xepLoairenluyen,ghichu));	  
   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
 	 return showAll;
 }
}
