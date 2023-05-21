package ModelInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import Model.Thisinh;

public interface InterfaceSinhvien {
	public void kiemtra(Thisinh ts) throws SQLException;
	public void nhapsv();
	public void timKiem();
	public void TimKiemIndiem();
	public void setFormNull();
	public void SelectDsSinhVienInTable();
	public void HuyTim();
	public void alertTimkiem();
	public float CheckDiemkiemTra(float diem, JTextField text);
	public void Xoasv();
	public  Thisinh getCapNhatThongTinSinhVien();
	public void CapNhatGiaTriTbale(Thisinh ts);
	public void getjTable1MouseClicked();
	public void capNhatSuaThongTin();
	public void addAllDataBaseOntoTable();
}
