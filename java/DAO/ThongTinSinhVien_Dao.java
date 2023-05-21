package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.Danhgiarenluyen;
import Model.Thisinh;
import Model.Thongtinsinhvien;
import Model.Tinh;

public class ThongTinSinhVien_Dao {
	 public static ThongTinSinhVien_Dao getInforSV() {
   	  return new ThongTinSinhVien_Dao();
     }
	 /*SELECT THONGTINCANHANSINHVIEN.MASV,LUUHINHANH,TrangThai,Chuyennganh,
		 			 	 Nganh,THONGTINCANHANSINHVIEN.Khoa,Dantoc,SDT,NgaySinh,Hokhau,Tongiao,CMND,Ho,Ten,GIOITINH,lop
		 			 		 from THONGTINCANHANSINHVIEN,QUANLYSINHVIEN
		 		 		 WHERE THONGTINCANHANSINHVIEN.MASV=QUANLYSINHVIEN.MASV 
		 		       AND THONGTINCANHANSINHVIEN.MASV='sv01'*/
	 public Thongtinsinhvien getInformation(String masv) {
		
		 String sql = "SELECT THONGTINCANHANSINHVIEN.MASV,LUUHINHANH,TrangThai,Chuyennganh,"
		 		+ "		 			 	 Nganh,TenKhoa,Dantoc,SDT,QUANLYSINHVIEN.NgaySinh,Hokhau,Tongiao,CMND,Ho,Ten,GIOITINH,lop"
		 		+ "		 			 		 from THONGTINCANHANSINHVIEN,QUANLYSINHVIEN"
		 		+ "		 		 		 WHERE THONGTINCANHANSINHVIEN.MASV=QUANLYSINHVIEN.MASV"
		 		+ "		 		       AND THONGTINCANHANSINHVIEN.MASV=?";
		 try (Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(sql);){
				statement.setString(1, masv);
				ResultSet rs = statement.executeQuery();
				while(rs.next())
				{
					Thongtinsinhvien ttsv = new Thongtinsinhvien();
					ttsv.setMaSV(rs.getString("MASV"));
					ttsv.setLuuHinhanh(rs.getString("LUUHINHANH"));
					ttsv.setTrAngthai(rs.getString("TrangThai"));
					ttsv.setChuyenNganh(rs.getString("Chuyennganh"));
					ttsv.setNganh(rs.getString("Nganh"));
					ttsv.setKhoa(rs.getString("TenKhoa"));
					ttsv.setDantoc(rs.getString("Dantoc"));
					ttsv.setSDT(rs.getString("SDT"));
				    ttsv.setNgaysinh(rs.getDate("NgaySinh"));
					ttsv.setHokhau(rs.getString("Hokhau"));
					ttsv.setTongiao(rs.getString("Tongiao"));
					ttsv.setCMND(rs.getString("CMND"));
					ttsv.setHoVaTen(rs.getString("Ho")+" "+rs.getString("Ten"));
					ttsv.setGioitinh(rs.getString("GIOITINH"));
					ttsv.setlOp(rs.getString("LOP"));
					
					return ttsv;
				}
		 }catch(SQLException e) {
			 e.printStackTrace();
			
		 }
		 return null;
		 
	 }

	 public  int insertInforSv(String masv) {
		  try {  
		          // Bảng thong tin sih viên 
		  		 // bước 1;kết nối với lại sql
		             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		           String sql="INSERT INTO THONGTINCANHANSINHVIEN (MASV)"
		              		+ " VALUES(?)"
		              		;
		          java.sql.PreparedStatement st=conection.prepareStatement(sql);
		         
		       
		          st.setString(1,masv);
		      
		           int ketqua=st.executeUpdate();
		           
		           DataBasSQL.closeConnect(conection);
		   
		   } catch (SQLException e) {
		  	
		  		e.printStackTrace();
		  	}
			
			return 0;

	  }
	 public ArrayList<Thongtinsinhvien> selectAllthongtin() {
		 ArrayList<Thongtinsinhvien> arr=new ArrayList<Thongtinsinhvien>();
		 try { 	
				// bước 1;kết nối với lại sql
					    Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
						   java.sql.Statement st=conection.createStatement();
					
					  String sql="SELECT* FROM QUANLYSINHVIEN,CANHANSINHVIEN ";
					  ResultSet ketqua=st.executeQuery(sql);
	                while(ketqua.next()) {
						     String masv=ketqua.getString("masv");
					    	 String quequan=ketqua.getString("quequan");
					    	 Tinh tinh=Tinh.getTinhByTen(quequan+"");
					         Date ngaysinh=ketqua.getDate("ngaysinh");
					    	 boolean gioitinh=ketqua.getBoolean("gioitinh");
					    	 String lop=ketqua.getString("lop");
					    	 float diemtoan =ketqua.getFloat("toan");
					         float diemly =ketqua.getFloat("ly");
					         float diemhoa=ketqua.getFloat("hoa");
					         float diemtb=ketqua.getFloat("tbinh");
							arr.add(new Thongtinsinhvien());
					    }
					  
	                DataBasSQL.closeConnect(conection);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      return arr ;
	 }
	      
	 public int capnhatTTSV(String luanh,String trangthai,String chuyennganh,
			 String nganh,String dantoc,String sdt,String shk,String tongiao,String cmnd ,String masv) {
		 try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		
		  
			String sql=" UPDATE  THONGTINCANHANSINHVIEN"
					+ " SET LUUHINHANH=?,TRANGTHAI=?,CHUYENNGANH=?,Nganh=?,DANTOC=?,SDT=?,HOKHAU=?,TONGIAO=?,CMND=? where  THONGTINCANHANSINHVIEN.MASV=?";
		 
		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		  st.setString(10,masv);
		  st.setString(1,luanh);
		  st.setString(2,trangthai);
	      st.setString(3,chuyennganh);
	      st.setString(4,nganh);
	      st.setString(5,dantoc);
	      st.setString(6,sdt);
	      st.setString(7,shk);
	      st.setString(8,tongiao);
	      st.setString(9,cmnd);
	    
	      int ketqua=st.executeUpdate();

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
	 public ArrayList<String> KETQUAHOCTAP(String ky ,String lop,String masv){
	    	
    	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
    	 ArrayList<Danhgiarenluyen> showAll=new   ArrayList<Danhgiarenluyen>();
    	  String sql="SELECT* FROM QUANLYSINHVIEN,DANHGIARENLUYEN"
    	  		+ " where KYHOC=? and QUANLYSINHVIEN.lop=? and QUANLYSINHVIEN.MASV=DANHGIARENLUYEN.MASV AND "
    	  		+ " ORDER BY DANHGIARENLUYEN.TEN ASC";
    	  		
		  java.sql.PreparedStatement st;
		try {
			st = conection.prepareStatement(sql); 
			st.setString(1,ky);
			st.setString(2,lop);
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
         
    	 return null;
    }
  public ArrayList<String> selectAllTenKhoa() {
			ArrayList<String> arrayList = new ArrayList<String>();
			 try { 	
					
					// bước 1;kết nối với lại sql
						    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName);
							   java.sql.Statement st=conection.createStatement();

						  String sql="SELECT tenkhoa from QUANLYKHOA ";
						  ResultSet ketqua=st.executeQuery(sql);
	                       while(ketqua.next()) {
						    	
							     String id=ketqua.getString("tenkhoa");
							  arrayList.add(id);
						    }
						  
						
	                       DataBasSQL.closeConnect(conection);
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			      return arrayList ;
		}
			    
}