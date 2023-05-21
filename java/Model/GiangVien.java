package Model;

import java.sql.Date;
import java.util.Objects;

public class GiangVien {

	private String masv;
	   private String ten;
	   public Tinh quequan;
	   private Date ngaysinh;
	   private boolean gioitinh;
	   private double luong;
	   private double heso;
	   private double thuclinh;
	  
	   public GiangVien(String masv, String ten, Tinh quequan, Date ngaysinh, boolean gioitinh, double luong, double heso,
			double thuclinh) {
		super();
		this.masv = masv;
		this.ten = ten;
		this.quequan = quequan;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.luong = luong;
		this.heso = heso;
		this.thuclinh = thuclinh;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
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

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public double getHeso() {
		return heso;
	}

	public void setHeso(double heso) {
		this.heso = heso;
	}

	public double getThuclinh() {
		return thuclinh;
	}

	public void setThuclinh(double thuclinh) {
		this.thuclinh = thuclinh;
	}

	@Override
	public String toString() {
		return "GiangVien [masv=" + masv + ", ten=" + ten + ", quequan=" + quequan + ", ngaysinh=" + ngaysinh
				+ ", gioitinh=" + gioitinh + ", luong=" + luong + ", heso=" + heso + ", thuclinh=" + thuclinh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioitinh, heso, luong, masv, ngaysinh, quequan, ten, thuclinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiangVien other = (GiangVien) obj;
		return gioitinh == other.gioitinh && Double.doubleToLongBits(heso) == Double.doubleToLongBits(other.heso)
				&& Double.doubleToLongBits(luong) == Double.doubleToLongBits(other.luong)
				&& Objects.equals(masv, other.masv) && Objects.equals(ngaysinh, other.ngaysinh)
				&& Objects.equals(quequan, other.quequan) && Objects.equals(ten, other.ten)
				&& Double.doubleToLongBits(thuclinh) == Double.doubleToLongBits(other.thuclinh);
	}
	
   
}
