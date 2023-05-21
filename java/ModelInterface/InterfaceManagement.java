package ModelInterface;

import java.io.IOException;
import java.util.ArrayList;

import Model.Thisinh;

public interface InterfaceManagement {
   public ArrayList<Thisinh> openFileExcel()throws IOException;
   public void ThucHienOpenFilecSV() ;
   public void thucHienSaveFile();
   public void Exit();
}
