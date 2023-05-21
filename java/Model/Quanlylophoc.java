package Model;

import java.util.Objects;

public class Quanlylophoc {
	private String maLop;
	private String tenLop;
	private String Covanhoctap;
	private String maKhoa;
	
	public Quanlylophoc() {
		
	}
	public Quanlylophoc(String maLOP, String tenLOP, String Covanhoctap, String maKhoa) {
		this.maLop = maLOP;
		this.tenLop = tenLOP;
		this.Covanhoctap = Covanhoctap;
		this.maKhoa = maKhoa;
	}
	
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public String getCovanhoctap() {
		return Covanhoctap;
	}
	public void setCovanhoctap(String covanhoctap) {
		Covanhoctap = covanhoctap;
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	@Override
	public String toString() {
		return "Quanlylophoc [maLop=" + maLop + ", tenLop=" + tenLop + ", Covanhoctap=" + Covanhoctap + ", maKhoa="
				+ maKhoa + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Covanhoctap, maKhoa, maLop, tenLop);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quanlylophoc other = (Quanlylophoc) obj;
		return Objects.equals(Covanhoctap, other.Covanhoctap) && Objects.equals(maKhoa, other.maKhoa)
				&& Objects.equals(maLop, other.maLop) && Objects.equals(tenLop, other.tenLop);
	}
	
}