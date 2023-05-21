package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectDataBase.DataBasSQL;
import Main.CreateSQL;
import Model.Danhgiarenluyen;
import Model.GiangVien;
import Model.Thisinh;
import Model.Tinh;
import ModelInterface.DAOinterface;
public class conectSinhvien implements DAOinterface<Thisinh> {
      public static conectSinhvien getInforSV() {
    	  return new conectSinhvien();
      }
	@Override
	public int insert(Thisinh t) {
		try { 
	  		 // bước 1;kết nối với lại sql từ lớp kết nối dâtbse
	             Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
	           String sql="INSERT INTO QUANLYSINHVIEN "
	        			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	          java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          /*PreparedStatement được sử dụng để thực thi các câu truy vấn SQL động hoặc có tham số. 
	           * PreparedStatement thừa kế từ Statement nhưng nó cho phép truyền các tham số vào câu SQL
	           *  trong thời gian run time. 
	           * PreparedStatement được khuyên sử dụng trong trường hợp câu SQL được sử dụng nhiều lần*/
	          st.setString(1,t.getMasv());
	          st.setString(2,t.getHo());
	          st.setString(3,t.getTen());
	          st.setString(4,t.getQuequan().gettenTinh());
	          st.setDate(5,t.getNgaysinh());
	          st.setBoolean(6,t.isGioitinh());
	          st.setString(7,t.getLop());
	          st.setString(8,t.getHocky());
	          st.setFloat(9,t.getDiemtoan());
	          st.setFloat(10,t.getDiemli());
	          st.setFloat(11,t.getDiemhoa());
	          st.setFloat(12,t.getDiemtb());
	           int ketqua=st.executeUpdate();
	           
	           DataBasSQL.closeConnect(conection);
	   
	   } catch (SQLException e) {
	  	
	  		e.printStackTrace();
	  	}
		
		return 0;

	}

	@Override
	public int upDATE(Thisinh t) {
		// bước 1;kết nối với lại sql
		  try { 	
		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
	
	  
		String sql=" UPDATE QUANLYSINHVIEN"
				+ " SET ho=?,ten=?,quequan=?,ngaysinh=?,gioitinh=?,MAlop=?,HOCKY=?,CHUNGHIAXAHOI=?,TUTUONGHCM=?, NHAPMONTINOC=?,DIEMTB=? where masv=?";
	 
	  java.sql.PreparedStatement st=conection.prepareStatement(sql);
	  st.setString(12,t.getMasv());
	  st.setString(1,t.getHo());
	  st.setString(2,t.getTen());
      st.setString(3,t.getQuequan().gettenTinh());
      st.setDate(4,t.getNgaysinh());
      st.setBoolean(5,t.isGioitinh());
      st.setString(6,t.getLop());
      st.setString(7,t.getHocky());
      st.setFloat(8,t.getDiemtoan());
      st.setFloat(9,t.getDiemli());
      st.setFloat(10,t.getDiemhoa());
      st.setFloat(11,t.getDiemtb());
      int ketqua=st.executeUpdate();

	  if(ketqua>0) {
	 	 System.out.println("thêm dữ liệu thành công");
	 	// System.out.println("xuat giá tri đuọc them vào"+sql);
	  }else {
	 	 System.out.println("thêm dữ liệu thất bại ");
	  }
	  DataBasSQL.closeConnect(conection);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



		return 0;
	}

	@Override
	public int delete(Thisinh t) {
		  try { 	
		  Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
					  String sql="DELETE from QUANLYSINHVIEN"+" WHERE MASV=?";
					  java.sql.PreparedStatement st=conection.prepareStatement(sql);
			          st.setString(1,t.getMasv());
			          
					  int ketqua=st.executeUpdate();
				
					  if(ketqua>0) {
					 	 System.out.println("xóa dữ liệu thành công");
					 	 System.out.println("xuat giá tri đuọc them vào"+sql);
					  }else {
					 	 System.out.println("xóa dữ liệu thất bại ");
					  }
					
					  DataBasSQL.closeConnect(conection);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}



		return 0;
	}

	@Override
	public ArrayList<Thisinh> selectAll() {
		ArrayList<Thisinh> arrayList = new ArrayList<Thisinh>();
		 try { 	
				
				// bước 1;kết nối với lại sql
					    Connection conection=  DataBasSQL.getConect(CreateSQL.databaseName);
					 	  String sql="SELECT* FROM QUANLYSINHVIEN "; 
					 	  /*PreparedStatement có tham số chuyền vào */
					 	  java.sql.PreparedStatement st=conection.prepareStatement(sql);
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

							arrayList.add(new Thisinh(id,ho,tenThisinh,tinh,ngaysinh,gioitinh,lop,hocky,diemtoan,diemly,diemhoa,diemtb));
					    }
					  
					
                       DataBasSQL.closeConnect(conection);
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      return arrayList ;
	}
	public Thisinh slectByid(String t) {
	
			Thisinh kq=null;
			try {					  
				Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);;
					  String sql="SELECT* FROM QUANLYSINHVIEN where MASV=?";
					  java.sql.PreparedStatement st=conection.prepareStatement(sql);
			          st.setString(1,t);
					  ResultSet ketqua=st.executeQuery();
					  while(ketqua.next()) {
					    	String id=ketqua.getString("MASV");
					    	String ho=ketqua.getString("HO");
					    	String tenThisinh=ketqua.getString("TEN");
					    	String quequan=ketqua.getString("QUEQUAN");
					    	Tinh tinh=Tinh.getTinhByTen(quequan+"");
					    	Date ngaysinh=ketqua.getDate("NGAYSINH");
					    	boolean gioitinh=ketqua.getBoolean("GIOITINH");
					    	String lop= ketqua.getString("MALOP");
					    	 String hocky=ketqua.getString("HOCKY");
					        float diemtoan =ketqua.getFloat("CHUNGHIAXAHOI");
					         float diemly =ketqua.getFloat("TUTUONGHCM");
					         float diemhoa=ketqua.getFloat("NHAPMONTINOC");
					         float diemtb=ketqua.getFloat("DIEMTB");
							kq=(new Thisinh(id,ho,tenThisinh,tinh,ngaysinh,gioitinh,lop,hocky,diemtoan,diemly,diemhoa,diemtb));
					    	
					  }
					  
					  DataBasSQL.closeConnect(conection);
					
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
			return kq;
	}

	@Override
	public ArrayList<Thisinh> selectByCondition(float a) {
		
		ArrayList<Thisinh> arrayList = new ArrayList<Thisinh>();
		 try { 	
					     Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);;
						
						  String sql="SELECT* FROM QUANLYSINHVIEN where DIEMTB=? ";
						  java.sql.PreparedStatement st=conection.prepareStatement(sql);
				          st.setFloat(1,a);
						  ResultSet ketqua=st.executeQuery();
                      while(ketqua.next()) {
					    
                    	  String id=ketqua.getString("MASV");
					    	String ho=ketqua.getString("HO");
					    	String tenThisinh=ketqua.getString("TEN");
					    	String quequan=ketqua.getString("QUEQUAN");
					    	Tinh tinh=Tinh.getTinhByTen(quequan+"");
					    	Date ngaysinh=ketqua.getDate("NGAYSINH");
					    	boolean gioitinh=ketqua.getBoolean("GIOITINH");
					    	String lop= ketqua.getString("MALOP");
					    	 String hocky=ketqua.getString("HOCKY");
					        float diemtoan =ketqua.getFloat("CHUNGHIAXAHOI");
					         float diemly =ketqua.getFloat("TUTUONGHCM");
					         float diemhoa=ketqua.getFloat("NHAPMONTINOC");
					         float diemtb=ketqua.getFloat("DIEMTB");
							arrayList.add(new Thisinh(id,ho,tenThisinh,tinh,ngaysinh,gioitinh,lop,hocky,diemtoan,diemly,diemhoa,diemtb));
					    }
                      DataBasSQL.closeConnect(conection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		return arrayList ;
	}
	public boolean kiemtraId( String masv) throws SQLException {
	
		ResultSet ketqua = null;
		 try { 	
			 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);

			 /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
			   
			  */ String sql="SELECT* FROM QUANLYSINHVIEN Where MASV='"+masv+"'";
			  java.sql.PreparedStatement st=conection.prepareStatement(sql);
			    ketqua=st.executeQuery();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
	      if(!ketqua.next()){
			          return false;
		         }
			return true;

	      

	      }

public Thisinh slectByid(Thisinh t) {

		return null;
	}
public ArrayList<String>getAllLop() throws SQLException{
	ResultSet ketqua = null;
	ArrayList<String>arl=new ArrayList<String>();
	 try { 	
		 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);
		 /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
		  */ String sql="SELECT MALOP FROM QUANLYLOPHOC ORDER BY MALOP ASC ";
		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		  ketqua=st.executeQuery(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
	          while(ketqua.next()) {
	        	  String lop=ketqua.getString("MALOP");
	        	  arl.add(lop);
	          }

	return arl;
}
public int capNhatChotableALL(String ho,String ten,String lop,String hocky,float diem,String masv) {
	// bước 1;kết nối với lại sql
	  try { 	
	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);


	String sql=" UPDATE DANHGIARENLUYEN"
			+ " SET ho=?,ten=?,MAlop=?,KYHOC=?,DIEMSV=? where masv=?";

java.sql.PreparedStatement st=conection.prepareStatement(sql);

st.setString(1,ho);
st.setString(2,ten);
st.setString(3,lop);
st.setString(4,hocky);
st.setFloat(5,diem);
st.setString(6,masv);
int ketqua=st.executeUpdate();
DataBasSQL.closeConnect(conection);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



	return 0;
}
public int capNhatChotableALL(String hocky,String masv) {
	// bước 1;kết nối với lại sql
	  try { 	
	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);


	String sql=" UPDATE DIEMDANH "
			+ " SET HOCKY=? where masv=?";

java.sql.PreparedStatement st=conection.prepareStatement(sql);


st.setString(1,hocky);

st.setString(2,masv);
int ketqua=st.executeUpdate();
DataBasSQL.closeConnect(conection);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  	return 0;
}
public int capNhatChotableALLPhanTram(String hocky,String masv) {
	// bước 1;kết nối với lại sql
	  try { 	
	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);


	String sql=" UPDATE PHANTRAM "
			+ " SET HOCKY=? where masv=?";

java.sql.PreparedStatement st=conection.prepareStatement(sql);


st.setString(1,hocky);

st.setString(2,masv);
int ketqua=st.executeUpdate();
DataBasSQL.closeConnect(conection);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  	return 0;
}
public int capNhatChotablettsv(Date ngaysinh,String masv) {
	// bước 1;kết nối với lại sql
	  try { 	
	 Connection conection= DataBasSQL.getConect(CreateSQL.databaseName);


	String sql=" UPDATE THONGTINCANHANSINHVIEN  "
			+ " SET NGAYSINH=? where masv=?";

java.sql.PreparedStatement st=conection.prepareStatement(sql);
st.setDate(1,ngaysinh);
st.setString(2,masv);
int ketqua=st.executeUpdate();
DataBasSQL.closeConnect(conection);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  	return 0;
}
}
