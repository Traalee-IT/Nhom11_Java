package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;


public class ConnectLoginTeacher  {
	   
   public static ConnectLoginTeacher getInfor() {
	   return new ConnectLoginTeacher();
   }
 
  
//           }
public boolean dangNhapJDBC(String idLogin, String pass) throws SQLException {
	 ResultSet ketqua = null;
	 try { 	
		
		
		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		
		    String sql="SELECT* FROM LOGIN Where TAIKHOAN=? and PASS=?";
		    java.sql.PreparedStatement st=conection.prepareStatement(sql);
		    st.setString(1,idLogin);
		    st.setString(2,pass);
		    ketqua=st.executeQuery();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	 
      if(!ketqua.next()){
		          return false;
	         }
		return true; 
      }

public int capNhatTaiKhoan(String taikhoan,String pass,String Email,String id) {
	  try { 
			 
	  		 // bước 1;kết nối với lại sql
	             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
	     
	            /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
	        	/*bước 3 thưcj hiện câu lệnh sql
	  		 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
	  		 */
	           String sql= "INSERT INTO LOGIN(ID,TAIKHOAN,PASS,EMAIL) VALUES(?,?,?,?)";//++","++","++","++")";
	          java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,id);
	          st.setString(2,taikhoan);
	          st.setString(3,pass);
	          st.setString(4,Email);
	          
	          int ketqua=st.executeUpdate();
	           
	           /*bước 4 sử lí kế quả
	            *  check nó sẻ cho biết con số lượng dòng thay đổi
	            * - check>0 nễu có 1 dòng thay đổi 
	               ngược lại thêm bị thất bại
	            */
	           System.out.println("số dòng thay đổi la:  "+ketqua);
	           if(ketqua>0) {
	          	 System.out.println("thêm dữ liệu thành công");
	          	 System.out.println("xuat giá tri đuọc them vào"+sql);
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
public ArrayList<String> EmailTaikhoan(String email) {
	   ArrayList<String> chuoitk=new ArrayList<String>();
	   ResultSet ketqua=null;
	try { 	
		
		// bước 1;kết nối với lại sql
			    Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);;
			
			   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
			      
			     
				   
				/*bước 3 thưcj hiện câu lệnh truy vấn sql
				 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseuteQuery 
				 * là câu lệnh truy vấn trả về class reusultset giống như table bên 
				 * trong lấy dữ liệu ra
				 *
				 * 
				 */
			  String sql="SELECT * FROM LOGIN Where EMAIL=?";
			  java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,email);
			   ketqua=st.executeQuery();
			 
				   while(ketqua.next()) {
				  String taikhoan=ketqua.getString("TAIKHOAN");
				  String passWord=ketqua.getString("PASS");
				  chuoitk.add(taikhoan);
				  chuoitk.add(passWord);
				  
			  } 
			 
			  /* bước 5 close chương gtrinh;
			   * 
			   */
              DataBasSQL.closeConnect(conection);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
 

      return chuoitk;
}
public boolean LayTkEmail(String Mail) throws SQLException {
	 ResultSet ketqua = null;
	 try { 	

		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		 /*bước 3 thưcj hiện câu lệnh truy vấn sql
		  * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
		  */
		    String sql="SELECT* FROM LOGIN Where EMAIL=? ";
		    java.sql.PreparedStatement st=conection.prepareStatement(sql);
		    st.setString(1,Mail);
		    ketqua=st.executeQuery();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	 
     if(!ketqua.next()){
		          return false;
	         }
		return true; 
     }



public String CapnhatLaipass(String pass,String email) {
	// TODO Auto-generated method stub
	  try { 	
	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);


	String sql=" UPDATE LOGIN"
			+ " SET PASS=? where EMAIL=?";
			java.sql.PreparedStatement st=conection.prepareStatement(sql);
			st.setString(1,pass);
			st.setString(2,email);
		
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
	  return "";
}
public ResultSet ThongTinTK (String Mail) {
	 ResultSet ketqua =null;
	 try { 	
		
		
		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		
		    String sql="SELECT TAIKHOAN  FROM LOGIN Where EMAIL=? ";
		    java.sql.PreparedStatement st=conection.prepareStatement(sql);
		    st.setString(1,Mail);
		   
		    ketqua=st.executeQuery();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	 
     return ketqua;
}

}
