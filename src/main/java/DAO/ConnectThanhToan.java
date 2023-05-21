package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.Thisinh;
import Model.Tinh;
import Model.congThanhToan;

public class ConnectThanhToan {
          public static ConnectThanhToan getConnect() {
        	  return new ConnectThanhToan();
          }
    public int updateThanhToan(String masv,String hocky,String noidung,double tongthanhtoan,String sotaikhoannhatruong,String date,String tennn,double sodu) {
    int ketqua=0;	try {  
    		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
    			
    			String sql=" INSERT INTO THANHTOAN "
    					+ " VALUES(?,?,?,?,?,?,?,?)";
    		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
    		  st.setString(1, masv);
    		  st.setString(2,date); 
    		  st.setString(3,noidung);
    		  st.setDouble(4, tongthanhtoan);
    		  st.setString(5,hocky);
			  st.setDouble(6,sodu); 
			  st.setString (7,tennn); 
			  st.setString(8,sotaikhoannhatruong);
    		 
    		  ketqua=st.executeUpdate();
    	}catch(SQLException ex) {
                  ex.printStackTrace();
    	}
    	return ketqua;
    }
    public ArrayList<String>Thongtinsinhvien(String masv){
    	ArrayList<String> arr=new ArrayList<String>();
    	try
    	{
    		String sql="SELECT * FROM QUANLYSINHVIEN WHERE QUANLYSINHVIEN.MASV=?";
			// bước 1;kết nối với lại sql
				    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName); 
				    java.sql.PreparedStatement st = conection.prepareStatement(sql); 
					st.setString(1,masv);
			  ResultSet ketqua=st.executeQuery();
             while(ketqua.next()) {
            	 
            	 String id=ketqua.getString("MASV");
			     String ho=ketqua.getString ("HO");
		    	 String tenThisinh=ketqua.getString("TEN");
		         Date ngaysinh=ketqua.getDate("NGAYSINH");
		    	 boolean gioitinh=ketqua.getBoolean("GIOITINH");
		    	 String lop=ketqua.getString("MALOP");

			    	
		         arr.add(id);
		         arr.add(ho+" "+tenThisinh);
		         arr.add(ngaysinh+"");
		         arr.add(gioitinh+"");
		         arr.add(lop);
			    } 
    	}catch(SQLException es){
    		es.printStackTrace();
    	}
    	
    	
    	
    	
    	return arr;
    	
    }
    public ArrayList<congThanhToan> selectThanhToan(String masv) {
		ArrayList<congThanhToan> arrayList = new ArrayList<congThanhToan>();
		 try { 	
				
				// bước 1;kết nối với lại sql
					  
					  String sql="SELECT * FROM THANHTOAN where masv=? ";
					// bước 1;kết nối với lại sql
					    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName); 
					    java.sql.PreparedStatement st = conection.prepareStatement(sql); 
						st.setString(1,masv);
				  ResultSet ketqua=st.executeQuery();
                       while(ketqua.next()) {
					    	
						     String mahoadon=ketqua.getString("MAHOADON");
						     String thoigian=ketqua.getString ("thoigian");
					    	 String noidung=ketqua.getString("NOIDUNG");
					    	 double tongthanhtoan=ketqua.getDouble("TONGTHANHTOAN");
					    	 String hocky=ketqua.getString("HOCKY");
					    	 double sodu=ketqua.getDouble("SODU");
					    	 String masotaikhoan=ketqua.getString("MASOTAIKHOAN");
					    	 String tennganhang=ketqua.getString("TENNGANHANG");
					         

							arrayList.add(new congThanhToan(mahoadon,thoigian,noidung,tongthanhtoan,hocky,sodu,masotaikhoan,tennganhang));
					    }
					  
					
                       DataBasSQL.closeConnect(conection);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      return arrayList ;
	}

}
