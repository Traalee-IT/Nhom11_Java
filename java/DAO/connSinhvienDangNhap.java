package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.DsDiemDanh;
import Model.Thisinh;
public class connSinhvienDangNhap {
           public static connSinhvienDangNhap getdangnhap() {
        	   return new connSinhvienDangNhap();
           }

//public static int insertMasvInTableDangnhap(String masv) {
//	try { 
//  		 // bước 1;kết nối với lại sql
//             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
//           String sql="INSERT INTO DangNhapSinhVien(masv,matkhau)"
//              		+ "VALUES(?,?)";
//          java.sql.PreparedStatement st=conection.prepareStatement(sql);
//          st.setString(1,masv);
//          st.setString(2,masv);
//           int ketqua=st.executeUpdate();
//           DataBasSQL.closeConnect(conection);
//   } catch (SQLException e) {
//  		e.printStackTrace();
//  	}
//	return 0;
//}
public static int insertmasvaotablePhanTram(String masv) {
	try { 
		 
  		 // bước 1;kết nối với lại sql
             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
           String sql="INSERT INTO phantram(masv)"
              		+ "VALUES(?)";
          java.sql.PreparedStatement st=conection.prepareStatement(sql);
          st.setString(1,masv);
           int ketqua=st.executeUpdate();
           DataBasSQL.closeConnect(conection);
   } catch (SQLException e) {
  		e.printStackTrace();
  	}
	return 0;
}
public boolean DN(String MaSV, String Pass) {
	 ResultSet ketqua = null;
	 try { 	
		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		    String sql="select * from sinhvien,SVDangNhap where SVDangNhap.MaSV=sinhvien.masv and sinhvien.masv =? and MatKhau=?";
		    java.sql.PreparedStatement st=conection.prepareStatement(sql);
		    st.setString(1,MaSV);
		    st.setString(2,Pass);
		    ketqua=st.executeQuery();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	 
     try {
		if(!ketqua.next()){
			          return false;
		         }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true; 
     }

		
		public int UpadateDiemDanh(DsDiemDanh ds,int buoihoc) {
			// nếu buổi học đó tồn tại thì cập nhật laị cho buổi học đó 
			// bước 1;kết nối với lại sql
			  try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		
		  
			String sql=" UPDATE diemdanh"
					+ " SET vangcp=?,vangkp=?,phantram=? where masv=? and buoihoc=?";
		 
		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		  st.setString(4,ds.getMasv());
		  st.setInt(5,buoihoc);
		  st.setBoolean(1,ds.isCophep());
	      st.setBoolean(2,ds.isKophep());
	    
	      st.setFloat(3,ds.getPhantram());
	     
	      int ketqua=st.executeUpdate();
		  System.out.println("số dòng thay đổi la:  "+ketqua);
		  if(ketqua>0) {
		 	 System.out.println("thêm dữ liệu thành công");
		 	// System.out.println("xuat giá tri đuọc them vào"+sql);
		  }else {
		 	 System.out.println("thêm dữ liệu thất bại ");
		  }
		  
		 
		  /* bước 5 close chương gtrinh;	
		   * 
		   */
		 
		  DataBasSQL.closeConnect(conection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			return 0;
}
		public int UpadatePhanTram(String masv, float phantram) {
			// nếu buổi học đó tồn tại thì cập nhật laị cho buổi học đó 
			// bước 1;kết nối với lại sql
			  try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);

			String sql=" UPDATE phantram"
					+ " SET phantram=? where masv=?";
		 
		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		  st.setFloat(1,phantram);
	     st.setString(2,masv);
	      int ketqua=st.executeUpdate();
		  /* bước 5 close chương gtrinh;	
		   * 
		   */
		  DataBasSQL.closeConnect(conection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return 0;
		}
		public int InsertDiemDanh(DsDiemDanh ds,int buoihoc,int sotiet) {
			// nếu buổi học đó tồn tại thì cập nhật laị cho buổi học đó 
			// bước 1;kết nối với lại sql
			  try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		
		  
			String sql=" insert into diemdanh(masv,vangcp,vangkp,sotiet,buoihoc)"
					+ " values(?,?,?,?,?)";
		   
		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		  st.setString(1,ds.getMasv());
		  st.setBoolean(2,ds.isCophep());
	      st.setBoolean(3,ds.isKophep());
	      st.setInt(4, sotiet);
	    st.setInt(5,buoihoc);
	     
	      int ketqua=st.executeUpdate();
		  System.out.println("số dòng thay đổi la:  "+ketqua);
		  if(ketqua>0) {
		 	 System.out.println("thêm dữ liệu thành công");
		 	// System.out.println("xuat giá tri đuọc them vào"+sql);
		  }else {
		 	 System.out.println("thêm dữ liệu thất bại ");
		  }
		  
		 
		  /* bước 5 close chương gtrinh;	
		   * 
		   */
		 
		  DataBasSQL.closeConnect(conection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			return 0;
		}

		

       	
}
