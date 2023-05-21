package ModelInterface;

import java.awt.HeadlessException;
import java.sql.SQLException;

public interface InterfaceLogin {
     public void checkAlert()throws SQLException;
     public void DangKygtr() throws HeadlessException, SQLException;
     public void Login();
     public void SetkhiLoiDangKy();
     public void SetNull();
     public void xacMinhEmail()throws SQLException;
     public void xacNhan();
     }
