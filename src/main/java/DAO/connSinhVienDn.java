package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
public class connSinhVienDn {
	public static connSinhVienDn DangNhap() {
		   return new connSinhVienDn();
	   }
	public boolean DN(String MaSV,String Pass) {
		 ResultSet ketqua = null;
		 try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
			    String sql="select * from TAIKHOANSV where TAIKHOANSV.masv =? and TAIKHOANSV.MATKHAU=?";
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
public int insertMASVdangNhap(String masv) {
	 try{
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
            String sql="INSERT INTO TAIKHOANSV "/*(N'MASV',N'MATKHAU')*/
            		+ "VALUES(?,?)";
        java.sql.PreparedStatement st=conection.prepareStatement(sql);
            st.setString(1,masv);
            st.setString(2,masv);
         int ketqua=st.executeUpdate();
         DataBasSQL.closeConnect(conection);
 } catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	return 0;

	}


}
