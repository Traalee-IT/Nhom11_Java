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

public class ConnectDanhgiaRL {
        public static ConnectDanhgiaRL  danhgia() {
        	return new ConnectDanhgiaRL() ;
        }
  public int insertInto(String ma,String ho,String ten,float diemsv,String hocky,String malop) {
        	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
        	 String sql="insert into DANHGIARENLUYEN(MASV,HO,TEN,DIEMSV,KYHOC,MALOP)"
        	 		+ " VALUES(?,?,?,?,?,?)";
        	 try {
				java.sql.PreparedStatement st=conection.prepareStatement(sql);
				  st.setString(1,ma);
				  st.setString(2,ho);
				  st.setString(3,ten);
				  st.setFloat(4,diemsv);
				  st.setString(5,hocky);
				  st.setString(6,malop);
				  int ketqua=st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 return 0;
        }
    public ArrayList<Danhgiarenluyen> selectAllconDition(String ky ,String lop){
    	
        	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
        	 ArrayList<Danhgiarenluyen> showAll=new  ArrayList<Danhgiarenluyen>();
        	  String sql="SELECT* FROM QUANLYSINHVIEN,DANHGIARENLUYEN"
        	  		+ " where KYHOC=? and QUANLYSINHVIEN.MALOP=? and QUANLYSINHVIEN.MASV=DANHGIARENLUYEN.MASV"
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
	         
        	 return showAll;
        }
    public int upDatedanhgiaRenluyen(float diemcvht,String seploai,String ghichu,String masv) {  
    	    try {
    	    	Connection con=DataBasSQL.getConect(CreateSQL.databaseName);
    	    	String sql=" UPDATE DANHGIARENLUYEN"
    					+ " SET DIEMCVHT=?,XEPLOAIRENLUYEN=?,GHICHU=? where MASV=?";
    		 
    		  java.sql.PreparedStatement st=con.prepareStatement(sql);
    		  st.setFloat(1, diemcvht);
    		  st.setString(2, seploai);
    		  st.setString(3, ghichu);
    		  st.setString(4, masv);
    		  int ketqua=st.executeUpdate();
    		  
    	    }catch(SQLException ex) {
    	    	
    	    }
    	    return 0;
    }
  
}
