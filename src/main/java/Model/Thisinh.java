package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Iterator;
import java.util.Objects;

public class Thisinh implements Serializable{
  
   private String masv;
   private String ho;
   private String ten;
   public Tinh quequan;
   private Date ngaysinh;
   private boolean gioitinh;
   private String lop;
    private String hocky;
   private float diemtoan;
   private float diemli;
   private float diemhoa;
   private float diemtb;
   
    
	public Thisinh(String masv, String ho, String ten, Tinh quequan, Date ngaysinh, boolean gioitinh, String lop,
		String hocky, float diemtoan, float diemli, float diemhoa, float diemtb) {
	super();
	this.masv = masv;
	this.ho = ho;
	this.ten = ten;
	this.quequan = quequan;
	this.ngaysinh = ngaysinh;
	this.gioitinh = gioitinh;
	this.lop = lop;
	this.hocky = hocky;
	this.diemtoan = diemtoan;
	this.diemli = diemli;
	this.diemhoa = diemhoa;
	this.diemtb = diemtb;
}


	@Override
	public String toString() {
		return " "+ masv + ","+ho+"," + ten + "," + quequan + "," + ngaysinh
				+ "," + gioitinh + "," + lop +","+hocky+ "," + diemtoan + "," + diemli + "," + diemhoa+ "," + diemtb
				;
	}


	public String getMasv() {
		return masv;
	}


	public void setMasv(String masv) {
		this.masv = masv;
	}


	public String getHo() {
		return ho;
	}


	public void setHo(String ho) {
		this.ho = ho;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public Tinh getQuequan() {
		return quequan;
	}


	public void setQuequan(Tinh quequan) {
		this.quequan = quequan;
	}


	public Date getNgaysinh() {
		return ngaysinh;
	}


	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}


	public boolean isGioitinh() {
		return gioitinh;
	}


	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}


	public String getLop() {
		return lop;
	}


	public void setLop(String lop) {
		this.lop = lop;
	}


	public String getHocky() {
		return hocky;
	}


	public void setHocky(String hocky) {
		this.hocky = hocky;
	}


	public float getDiemtoan() {
		return diemtoan;
	}


	public void setDiemtoan(float diemtoan) {
		this.diemtoan = diemtoan;
	}


	public float getDiemli() {
		return diemli;
	}


	public void setDiemli(float diemli) {
		this.diemli = diemli;
	}


	public float getDiemhoa() {
		return diemhoa;
	}


	public void setDiemhoa(float diemhoa) {
		this.diemhoa = diemhoa;
	}


	public float getDiemtb() {
		return diemtb;
	}


	public void setDiemtb(float diemtb) {
		this.diemtb = diemtb;
	}


	@Override
	public int hashCode() {
		return Objects.hash(diemhoa, diemli, diemtb, diemtoan, gioitinh, ho, hocky, lop, masv, ngaysinh, quequan, ten);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thisinh other = (Thisinh) obj;
		return Float.floatToIntBits(diemhoa) == Float.floatToIntBits(other.diemhoa)
				&& Float.floatToIntBits(diemli) == Float.floatToIntBits(other.diemli)
				&& Float.floatToIntBits(diemtb) == Float.floatToIntBits(other.diemtb)
				&& Float.floatToIntBits(diemtoan) == Float.floatToIntBits(other.diemtoan) && gioitinh == other.gioitinh
				&& Objects.equals(ho, other.ho) && Objects.equals(hocky, other.hocky) && Objects.equals(lop, other.lop)
				&& Objects.equals(masv, other.masv) && Objects.equals(ngaysinh, other.ngaysinh)
				&& Objects.equals(quequan, other.quequan) && Objects.equals(ten, other.ten);
	}

	
}
