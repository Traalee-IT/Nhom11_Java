package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import ConnectDataBase.DataBasSQL;

import Main.CreateSQL;
import Model.Khoa;

public class connectKhoa {

	 public static  connectKhoa getInstanse() {
     	return new connectKhoa();
     }
	 
	 public List<Khoa> selectAll() { 
		 List<Khoa> list = new ArrayList<>();
		 try {
		 String sql = "select * from QUANLYKHOA";
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
			   while(rs.next())
			   {
				 String maKhoa = rs.getString("maKhoa");
				 String tenKhoa = rs.getString("tenKhoa");
				 list.add(new Khoa(maKhoa,tenKhoa));
			   }
				
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		 
	 }
	 public int insertKhoa(String maKhoa, String tenKhoa) {
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
		 String sql ="insert into QUANLYKHOA values (?,?)";
		 PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,maKhoa);
			 pre.setString(2,tenKhoa);
			 pre.executeUpdate();
			 DataBasSQL.closeConnect(conn);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	 }
	 public int updateKhoa(String maKhoa, String tenKhoa) {
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
		 String sql ="update QUANLYKHOA set tenKhoa = ? where maKhoa = ?";
		 PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(2,maKhoa);
			 pre.setString(1,tenKhoa);
			 pre.executeUpdate();
			 DataBasSQL.closeConnect(conn);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	 }
	 public boolean  kiemtra(String maKhoa) {
		
		 try {    
		 String sql = " select maKhoa from QUANLYKHOA WHERE MAKHOA=?";
		 Connection conn =DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1,maKhoa);
				ResultSet rs = statement.executeQuery();
		   if(!rs.next())
			   {
				return false;
			   }
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	 }
	 public int deleteKhoa(String maKhoa) {
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
		 String sql ="delete QUANLYKHOA where maKhoa = ?";
		 PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,maKhoa);
			 pre.executeUpdate();
			 DataBasSQL.closeConnect(conn);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	 }
	 public Khoa searchKhoa(String maKhoa)
	 {
		 Khoa khoa = null;
		 try {
		 String sql = "select * from QUANLYKHOA where maKhoa = ? ";
		 Connection conn = DataBasSQL.getConect(CreateSQL.databaseName);
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, maKhoa);
				ResultSet rs = statement.executeQuery();
			   while(rs.next())
			   {
				 String makhoa = rs.getString("maKhoa");
				 String tenKhoa = rs.getString("tenKhoa");
				 khoa = new Khoa(maKhoa, tenKhoa);	//Sau có nhu cầu thêm tên thì thay vào đây
			   }
				
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(khoa);
		 return khoa;
	 }
}