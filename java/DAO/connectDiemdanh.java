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
public class connectDiemdanh {
           public static connectDiemdanh getDiemdanh() {
        	   return new connectDiemdanh();
           }
 public ArrayList<DsDiemDanh> SelectAllDiemdanhSV(String condition,int buoi,String hocky) {
       		ArrayList<DsDiemDanh> arrayList = new ArrayList<DsDiemDanh>();
       		      try { 		
       				// bước 1;kết nối với lại sql
       			     Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
       				 String sql="SELECT diemdanh.masv,ho, ten,ngaysinh,lop,gioitinh,vangcp,vangkp,sotiet,PHANTRAM" 
       						  		+ " from QUANLYSINHVIEN,diemdanh,phantram" 
       						  		+ " where lop =? and buoihoc=? and QUANLYSINHVIEN.masv=diemdanh.masv and QUANLYSINHVIEN.masv=phantram.masv "
       						  		+ "and hocky=?"
       						  		+ "";
       					PreparedStatement st=conection.prepareStatement(sql);
       				     st.setString(1,condition);
       				     st.setInt(2, buoi);
       				     st.setString(3,hocky);
				              ResultSet ketqua=st.executeQuery();
                               while(ketqua.next()){
                               String id=ketqua.getString("masv");
       						   String ho=ketqua.getString("ho");
       					    	String tenThisinh=ketqua.getString("ten");
       					        Date ngaysinh=ketqua.getDate("ngaysinh");
       					        boolean gioitinh=ketqua.getBoolean("gioitinh");
       					    	boolean vangcp=ketqua.getBoolean("vangcp");
       					    	boolean vangkp=ketqua.getBoolean("vangkp");
       					    	String lop=ketqua.getString("lop");
       					        float phantram=ketqua.getFloat("phantram");
       					     arrayList.add(new DsDiemDanh(id,ho,tenThisinh,ngaysinh,gioitinh,lop,vangcp,vangkp,phantram));
                             }
                             DataBasSQL.closeConnect(conection);
       					
       					} catch (SQLException e) {
       						// TODO Auto-generated catch block
       						e.printStackTrace();
       					}
       		return arrayList ;
    	}
 public ArrayList<DsDiemDanh> SelectAllDiemdanhSV(String condition,String hocky) {
		ArrayList<DsDiemDanh> arrayList = new ArrayList<DsDiemDanh>();
		      try { 	
				// bước 1;kết nối với lại sql
			     Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);					
				 String sql="SELECT diemdanh.masv ,ho,ten,ngaysinh,lop,gioitinh,vangcp,vangkp,sotiet,phantram"
				 		+ "	from QUANLYSINHVIEN,diemdanh,phantram"
				 		+ " where  lop =? and QUANLYSINHVIEN.masv=diemdanh.masv and phantram.masv=QUANLYSINHVIEN.masv and phantram.hocky=?"
				 		+ "	group by diemdanh.masv,ho,ten,ngaysinh,lop,gioitinh,vangcp,vangkp,sotiet,phantram";
					PreparedStatement st=conection.prepareStatement(sql);
				     st.setString(1,condition);
				     st.setString(2,hocky);
			              ResultSet ketqua=st.executeQuery();
                        while(ketqua.next()){
                        String id=ketqua.getString("masv");
						   String ho=ketqua.getString("ho");
					    	String tenThisinh=ketqua.getString("ten");
					        Date ngaysinh=ketqua.getDate("ngaysinh");
					        boolean gioitinh=ketqua.getBoolean("gioitinh");
					    	boolean vangcp=ketqua.getBoolean("vangcp");
					    	boolean vangkp=ketqua.getBoolean("vangkp");
					    	String lop=ketqua.getString("lop");
					        float phantram=ketqua.getFloat("phantram");
					     arrayList.add(new DsDiemDanh(id,ho,tenThisinh,ngaysinh,gioitinh,lop,vangcp,vangkp,phantram));
                      }
                      DataBasSQL.closeConnect(conection);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		return arrayList ;
	}
public boolean SelectAllbuoi(int buoi, String cbHocKy) throws SQLException {
			
			 ResultSet ketqua = null;
			 try { 	
				
				 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
				 /*bước 3 thưcj hiện câu lệnh truy vấn sql
				  * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
				  */
				    String sql="SELECT diemdanh.masv FROM diemdanh  Where buoihoc=?";
				    java.sql.PreparedStatement st=conection.prepareStatement(sql);
				    st.setInt(1,buoi);
				
				    ketqua=st.executeQuery();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
	//		     int i=ketqua.getInt(1);
//		         if(i>0) {
//		        	 return true;
//		        	 
//		         }else {
//		        	 return false;
//		         }
				if(ketqua.next()){
					          return true;
			
		      } return false;
}
				
		
//		public int insert(DsDiemDanh t,int sotiet,int buoihoc) {
//			try { 
//				 
//		  		 // bước 1;kết nối với lại sql
//		             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
//		           String sql="INSERT INTO diemdanh(masv,vangcp,vangkp,sotiet,phantram,buoihoc)"
//		              		+ "VALUES(?,?,?,?,?,?)"
//		              		;
//		          java.sql.PreparedStatement st=conection.prepareStatement(sql);
//		          st.setString(1,t.getMasv());
//		          st.setBoolean(2,t.isCophep());
//		          st.setBoolean(3,t.isKophep());
//		          st.setInt(4,sotiet);
//		          st.setFloat(5,t.getPhantram());
//		          st.setInt(6,buoihoc);
//		        
//		           int ketqua=st.executeUpdate();
//		           
//		           DataBasSQL.closeConnect(conection);
//		   
//		   } catch (SQLException e) {
//		  	
//		  		e.printStackTrace();
//		  	}
//			
//			return 0;
//
//		}
public static int insertMasvInTableDiemDanh(String masv,String hocky) {
	try { 
  		 // bước 1;kết nối với lại sql
             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
           String sql="INSERT INTO DIEMDANH(masv,hocky)"
              		+ " VALUES(?,?)";
          java.sql.PreparedStatement st=conection.prepareStatement(sql);
          st.setString(1,masv);
          st.setString(2,hocky);
           int ketqua=st.executeUpdate();
           DataBasSQL.closeConnect(conection);
   } catch (SQLException e) {
  		e.printStackTrace();
  	}
	return 0;
}
public static int insertmasvaotablePhanTram(String masv,String hocky) {
	try { 
		 
  		 // bước 1;kết nối với lại sql
             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
           String sql="INSERT INTO phantram(masv,hocky)"
              		+ "VALUES(?,?)";
          java.sql.PreparedStatement st=conection.prepareStatement(sql);
          st.setString(1,masv);
          st.setString(2,hocky);
           int ketqua=st.executeUpdate();
           DataBasSQL.closeConnect(conection);
   } catch (SQLException e) {
  		e.printStackTrace();
  	}
	return 0;
}
//		public int DiemDanh(DsDiemDanh t) {
//			// bước 1;kết nối với lại sql
//			  try { 	
//			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
//		
//		  
//			String sql=" UPDATE diemdanh"
//					+ " SET masv=?,ho=?,ten=?,quequan=?,ngaysinh=?,gioitinh=?,lop=?,toan=?,ly=?,hoa=?,tbinh=? where masv=?";
//		 
//		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
//		  st.setString(1,t.getMasv());
//		  st.setString(2,t.getHo());
//		  st.setString(3,t.getTen());
//	      st.setString(4,t.get)
//	      st.setDate(5,t.getNgaysinh());
//	      st.setBoolean(6,t.isGioitinh());
//	      st.setString(7,t.getLop());
//	      st.setFloat(8,t.getPhantram());
//	   
//	      int ketqua=st.executeUpdate();
//		 
//		
//		  System.out.println("số dòng thay đổi la:  "+ketqua);
//		  if(ketqua>0) {
//		 	 System.out.println("thêm dữ liệu thành công");
//		 	// System.out.println("xuat giá tri đuọc them vào"+sql);
//		  }else {
//		 	 System.out.println("thêm dữ liệu thất bại ");
//		  }
//		  
//		 
//		  /* bước 5 close chương gtrinh;	
//		   * 
//		   */
//		 
//		  DataBasSQL.closeConnect(conection);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//			return 0;
//		}
		
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
