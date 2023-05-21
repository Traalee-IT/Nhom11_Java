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
			Connection conection= DataBasSQL.getConect();
			try {
				DatabaseMetaData meta = conection.getMetaData();
                ResultSet resultSet;
				resultSet = meta.getCatalogs();
				while (resultSet.next()) {
				    String databaseName = resultSet.getString(1);
				    System.out.println("get2 "+resultSet.getString(1));
				    if (databaseName.equals(CreateSQL.databaseName.toLowerCase())) {
				        System.out.println("Database exists!");
				        return ;
				    }
				}
				CreateSQL.getInfor().CreateDatabase();
	            CreateSQL.getInfor().CreateTableLogin();  
CreateSQL.getInfor().creatrTriger();
	            
			} catch (SQLException e) {
			
				e.printStackTrace();
			}	
			     }
				);
		th.start();
		try {
			
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
