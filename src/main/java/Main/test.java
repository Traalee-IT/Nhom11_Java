package Main;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ConnectDataBase.DataBasSQL;
import View.HeThong;

public class test {
	public static void main(String...sgs) {
		Thread th=new Thread(()->{
			/* sử dụng luồng với cấu trúc lamda ()->{ là 1 phương thức ẩn của hàm runble */
			Connection conection= DataBasSQL.getConect();
			try {
				DatabaseMetaData meta = conection.getMetaData();
				/*cung cấp các phương thức để lấy metadata của cơ sở dữ liệu như tên sản phẩm cơ sở dữ liệu,
				 *  phiên bản sản phẩm cơ sở dữ liệu, tên driver, tên của tổng số bảng, 
				 *  tên của tổng số các view,
				 *  Phương thức getMetaData() của Giao diện Connection trả về đối tượng DatabaseMetaData.
				 */
                ResultSet resultSet;
				resultSet = meta.getCatalogs();
				/*Phương thức getCatalogs() của giao diện DatabaseMetaData trả về tên của cơ sở dữ liệu bên dưới ở định dạng Chuỗi.*/
				while (resultSet.next()) {
				    String databaseName = resultSet.getString(1);	  
				    if (databaseName.equals(CreateSQL.databaseName)) {
				        System.out.println("Database exists!");
				        return ;
				    }
				}
				CreateSQL.getInfor().CreateDatabase();
	            CreateSQL.getInfor().CreateTableLogin();  
                CreateSQL.getInfor().creatrTriger();
                CreateSQL.getInfor().creatrTriger2();
                CreateSQL.getInfor().insertNganhang();
			} catch (SQLException e) {
			
				e.printStackTrace();
			           }	
			     }
		);
		th.start();
		try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		/* cách nhìn theo giao diẹn người dùng*/
    		try {
				th.sleep(2000);
				new HeThong();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
    	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
    			| UnsupportedLookAndFeelException e) {
    		e.printStackTrace();
    	}	}
}
