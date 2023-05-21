package Main;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import com.microsoft.sqlserver.jdbc.SQLServerDatabaseMetaData;
import ConnectDataBase.DataBasSQL;
import Model.DsDiemDanh;
import Model.Thisinh;
public class CreateSQL {
    public static String databaseName = "NHOM11";
    public static CreateSQL getInfor() {

        return new CreateSQL();
    }
    public int CreateDatabase() {
        try {
            Connection conection = DataBasSQL.getConect();
            String sql = "CREATE DATABASE " + databaseName;
            java.sql.PreparedStatement st = conection.prepareStatement(sql);
                int ketqua = st.executeUpdate();
                DataBasSQL.closeConnect(conection);
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;

    }

    @SuppressWarnings("null")
    public int CreateTableLogin() {
        try {
            int ketqua = 0;
            // bước 1;kết nối với lại sql
            Connection conection = DataBasSQL.getConect(databaseName);
            String sql =  "CREATE TABLE QUANLYKHOA "
            		+ "("
            		+ "   MAKHOA NVARCHAR(50) PRIMARY KEY,"
            		+ "   TENKHOA NVARCHAR(50)\r\n"
            		+ ")"
            		+ "CREATE TABLE QUANLYLOPHOC "
            		+ "( "
            		+ "	  MALOP NVARCHAR(50) PRIMARY KEY,"
            		+ "	  CHUYENNGANH NVARCHAR(50),"
            		+ "	  COVANHOCTAP NVARCHAR(50),"
            		+ "	  MAKHOA NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYKHOA(MAKHOA)"
            		+ ")"
            		+ "  CREATE TABLE QUANLYSINHVIEN"
            		+ "("
            		+ "   MASV NVARCHAR(50) PRIMARY KEY,"
            		+ "   HO NVARCHAR(50),"
            		+ "   TEN NVARCHAR(50),"
            		+ "   QUEQUAN NVARCHAR(50),"
            		+ "   NGAYSINH DATE,\r\n"
            		+ "   GIOITINH NVARCHAR(50),"
            		+ "   MALOP NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYLOPHOC(MALOP),"
            		+ "   HOCKY Nvarchar(50),"
            		+ "   CHUNGHIAXAHOI FLOAT,"
            		+ "   TUTUONGHCM FLOAT,"
            		+ "   NHAPMONTINOC FLOAT,"
            		+ "   DIEMTB FLOAT"
            		+ " )"
            		+ "CREATE TABLE TAIKHOANSV"
            		+ "( "
            		+ "  MASV NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYSINHVIEN(MASV) ,"
            		+ "  MATKHAU NVARCHAR(50)"
            		+ ")"
            		+ " CREATE TABLE DIEMDANH "
            		+ " ("
            		+ " MASV NVARCHAR(50) FOREIGN KEY REFERENCES  QUANLYSINHVIEN(MASV),"
            		+ "	VANGCP NVARCHAR(50),"
            		+ "	VANGKP NVARCHAR(50),"
            		+ "	SOTIET INT ,"
            		+ " HOCKY Nvarchar(50),"
            		+ "	BUOIHOC INT "
            		+ ")"
        
            		+ "CREATE TABLE PHANTRAM "
            		+ "("
            		+ "   MASV NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYSINHVIEN(MASV),\r\n"
            		+ " HOCKY Nvarchar(50),"
            		+ " PHANTRAM FLOAT"
            		+ ")"
            		+ ""
            		+ "CREATE TABLE LOGIN"
            		+ "("
            		+ "   EMAIL NVARCHAR(50) PRIMARY KEY,"
            		+ "   TAIKHOAN NVARCHAR(50),"
            		+ "   PASS NVARCHAR(50),"
            		+ "   ID NVARCHAR(50)"
            		+ " )"
            		+ "CREATE TABLE THONGTINCANHANSINHVIEN"
            		+ "("
            		+ "  MAHOSO INT  IDENTITY(1,1) PRIMARY KEY,"
            		+ "  MASV NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYSINHVIEN(MASV),"
            		+ "  LUUHINHANH NVARCHAR(MAX),"
            		+ "  TRANGTHAI NVARCHAR(50),"
            		+ "  CHUYENNGANH NVARCHAR(50),"
            		+ "  COVANHOCTAP NVARCHAR(50),"
            		+ "  TENKHOA NVARCHAR(50),"
            		+ "  DANTOC NVARCHAR(50),"
            		+ "  SDT VARCHAR(20),"
            		+ "  NGAYSINH date,"
            		+ "  HOKHAU NVARCHAR(50),"
            		+ "  TONGIAO NVARCHAR(50),"
            		+ "  MALOP NVARCHAR(50), "
            		+ "  CMND NVARCHAR(50)"
            		+ ")"
            		
            		+ "CREATE TABLE TAIKHOANNHATRUONG ("
            		+ "            	   MASOTAIKHOAN VARCHAR(50)  PRIMARY KEY,"
            		+ "            	   MONEY decimal(18, 1))"
            		+ "CREATE TABLE THANHTOAN\r\n"
            		+ "(\r\n"
            		+ "  MAHOADON INT IDENTITY(1,1) PRIMARY KEY,\r\n"
            		+ "	 MASV NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYSINHVIEN(MASV),\r\n"
            		+ "	 THOIGIAN NVARCHAR(MAX),"
            		+ "	 NOIDUNG NVARCHAR(MAX),"
            		+ "	 TONGTHANHTOAN decimal(18, 1),\r\n"
            	     + " HOCKY Nvarchar(50),"
            		+ "	 SODU decimal(18, 1),"
            		+ "  TENNGANHANG NVARCHAR(MAX),"
            		+ "  MASOTAIKHOAN VARCHAR(50)FOREIGN KEY REFERENCES TAIKHOANNHATRUONG(MASOTAIKHOAN)"
            		+ ")"
            		+ "CREATE TABLE DANHGIARENLUYEN"
            		+ "("
            		+ "   MASV NVARCHAR(50) FOREIGN KEY REFERENCES QUANLYSINHVIEN(MASV),\r\n"
            		+ "	  KYHOC NVARCHAR(50),"
            		+ "   Ho NVARCHAR(50),"
            		+ "   TEN NVARCHAR(50),"
            		+ "   MALOP Nvarchar(50),"
            		+ "	  DIEMSV FLOAT,"
            		+ "	  DIEMCVHT FLOAT,"
            		+ "	  XEPLOAIRENLUYEN NVARCHAR(50),"
            		+ "   GHICHU NVARCHAR(50)"
            		+ ")"
            	
            	
            		
            		
            		
            ;

            java.sql.PreparedStatement st = conection.prepareStatement(sql);

            ketqua = st.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }
    public int insertNganhang() {
    	try { 
    		Connection conection = DataBasSQL.getConect(databaseName);
    	    String sql = "insert into  TAIKHOANNHATRUONG values('1234567',1234500),"
    	    		+ " ('7654321',1234)";


    	   java.sql.PreparedStatement st;
    		st = conection.prepareStatement(sql);
    		int ketqua = st.executeUpdate();

    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    	  return 0;
    
    }
  public int creatrTriger() {
	try { 
		Connection conection = DataBasSQL.getConect(databaseName);
	    String sql = "CREATE TRIGGER Capnhat_diemdanh ON PHANTRAM"
	    		+ "	     FOR INSERT,UPDATE,DELETE"
	    		+ "	      AS"
	    		+ "			 BEGIN "
	    		+ "				  UPDATE DANHGIARENLUYEN"
	    		+ "				  SET GHICHU='CAM THI'"
	    		+ "				  WHERE DANHGIARENLUYEN.MASV = (SELECT inserted.MaSV FROM inserted JOIN QUANLYSINHVIEN ql\r\n"
	    		+ "				   ON inserted.MaSV = ql.MASV"
	    		+ "					and inserted.PHANTRAM>=40)"
	    		+ "	END ";

	   java.sql.PreparedStatement st;
		st = conection.prepareStatement(sql);
		int ketqua = st.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  return 0;
  }
  
 
  public int creatrTriger2() {
		try { 
			Connection conection = DataBasSQL.getConect(databaseName);
		    String sql = "CREATE TRIGGER capnhatThanhToan on THANHTOAN"
		    		+ "	    		FOR UPDATE,INSERT,DELETE\r\n"
		    		+ "	    		 AS "
		    		+ "	      BEGIN"
		    		+ "	            UPDATE TAIKHOANNHATRUONG"
		    		+ "		        SET MONEY= TAIKHOANNHATRUONG.MONEY+ (select TONGTHANHTOAN  from inserted "
		    		+ "					   where TAIKHOANNHATRUONG.MASOTAIKHOAN=inserted.MASOTAIKHOAN)"
		    		+ "	    	 END ";
		   java.sql.PreparedStatement st;
			st = conection.prepareStatement(sql);
			int ketqua = st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return 0;
	  }
}
