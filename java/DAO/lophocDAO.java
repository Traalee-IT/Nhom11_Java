package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.Khoa;
import Model.Quanlylophoc;

public class lophocDAO {
	 public static  lophocDAO getInstanse() {
	     	return new lophocDAO();
	     }
	 
	 public List<Quanlylophoc> selectAll() { 
		 List<Quanlylophoc> list = new ArrayList<>();
		 try {
		 String sql = "select * from QUANLYLOPHOC";
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
			   while(rs.next())
			   {
				 String maKhoa = rs.getString("maKhoa");

				 Model.Quanlylophoc qllh = new Model.Quanlylophoc();
				 qllh.setMaKhoa(rs.getString("maKhoa"));
				 qllh.setMaLop(rs.getString("maLop"));
				 qllh.setTenLop(rs.getString("tenLop"));
				 qllh.setCovanhoctap(rs.getString("Covanhoctap"));
				
				 list.add(qllh);
			   }
			   
			  // statement.close();
			 //  conn.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return list;
		 
	 }	  
	 public int insert(String maLop, String tenLop, String Covanhoctap ,String maKhoa) {
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
		 String sql ="insert into QUANLYLOPHOC values (?,?,?,?)";
		 PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,maLop);
			 pre.setString(2,tenLop);
			 pre.setString(3,Covanhoctap);
			 pre.setString(4,maKhoa);
			 pre.executeUpdate();
			 DataBasSQL.closeConnect(conn);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	 }
	public boolean kiemtra(String maLop) {

		ResultSet ketqua = null;
		 try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);

			 /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
			   
			  */ String sql="SELECT* FROM QUANLYLOPHOC Where MALOP=?";
			  java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,maLop);
			    ketqua=st.executeQuery();
	      if(!ketqua.next()){
			          return false;
		         }
			
      } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      return true;

	   
	}
	 public int updateQuanlylophoc (String maLop, String tenLop, String Covanhoctap,String maKhoa) {
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
		 String sql ="update QUANLYLOPHOC set tenLop = ? , Covanhoctap = ?, maKhoa = ? where maLop = ?";
		 PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			 pre.setString(1,tenLop);
			 pre.setString(2,Covanhoctap);
			 pre.setString(3,maKhoa);
			 pre.setString(4,maLop);
		
			 pre.executeUpdate();
			 DataBasSQL.closeConnect(conn);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	 }
	 
	 public ArrayList<String > Select(){
		 ArrayList< String > Arr  = new ArrayList<String>();
		 String maKhoa = "Select MAKHOA from QUANLYKHOA";
		try {
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(maKhoa);
				ResultSet rs = statement.executeQuery();
			   while(rs.next())
			   {
				   String MaKhoa = rs.getString("MAKHOA");
				   Arr.add(MaKhoa) ;
			   }
		}
		catch (SQLException ex )
		{
			
		}
		 return Arr;
		 
	 }
	 public ArrayList<Quanlylophoc> Timkiem(String masv) { 
		 ArrayList<Quanlylophoc> list = new ArrayList<Quanlylophoc>();
		 try {
		 String sql = "select * from QUANLYLOPHOC WHERE maLop=? ";
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(sql);
				  statement.setNString(1,masv);
				ResultSet rs = statement.executeQuery();
				
			   while(rs.next())
			   {
				 String maKhoa = rs.getString("maKhoa");
				 Model.Quanlylophoc qllh = new Model.Quanlylophoc();
				 qllh.setMaKhoa(rs.getString("maKhoa"));
				 qllh.setMaLop(rs.getString("maLop"));
				 qllh.setTenLop(rs.getString("tenLop"));
				 qllh.setCovanhoctap(rs.getString("Covanhoctap"));
				
				 list.add(qllh);
			   }
			   
			  // statement.close();
			 //  conn.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return list;
		 
	 }
}