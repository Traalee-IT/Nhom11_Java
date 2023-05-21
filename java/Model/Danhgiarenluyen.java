package Model;

import java.util.Objects;

public class Danhgiarenluyen {
	private String maSinhvien;
	private String ho;
	private String ten;
	private String kiHoc;
	private float diemSV;
	private float diemCVHT;
	private String xepLoairenluyen;
	private String ghichu;
	public Danhgiarenluyen(String maSinhvien, String ho, String ten, String kiHoc, float diemSV, float diemCVHT,
			String xepLoairenluyen, String ghichu) {
		super();
		this.maSinhvien = maSinhvien;
		this.ho = ho;
		this.ten = ten;
		this.kiHoc = kiHoc;
		this.diemSV = diemSV;
		this.diemCVHT = diemCVHT;
		this.xepLoairenluyen = xepLoairenluyen;
		this.ghichu = ghichu;
	}
	public String getMaSinhvien() {
		return maSinhvien;
	}
	public void setMaSinhvien(String maSinhvien) {
		this.maSinhvien = maSinhvien;
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
	public String getKiHoc() {
		return kiHoc;
	}
	public void setKiHoc(String kiHoc) {
		this.kiHoc = kiHoc;
	}
	public float getDiemSV() {
		return diemSV;
	}
	public void setDiemSV(float diemSV) {
		this.diemSV = diemSV;
	}
	public float getDiemCVHT() {
		return diemCVHT;
	}
	public void setDiemCVHT(float diemCVHT) {
		this.diemCVHT = diemCVHT;
	}
	public String getXepLoairenluyen() {
		return xepLoairenluyen;
	}
	public void setXepLoairenluyen(String xepLoairenluyen) {
		this.xepLoairenluyen = xepLoairenluyen;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "Danhgiarenluyen [maSinhvien=" + maSinhvien + ", ho=" + ho + ", ten=" + ten + ", kiHoc=" + kiHoc
				+ ", diemSV=" + diemSV + ", diemCVHT=" + diemCVHT + ", xepLoairenluyen=" + xepLoairenluyen + ", ghichu="
				+ ghichu + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(diemCVHT, diemSV, ghichu, ho, kiHoc, maSinhvien, ten, xepLoairenluyen);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Danhgiarenluyen other = (Danhgiarenluyen) obj;
		return Float.floatToIntBits(diemCVHT) == Float.floatToIntBits(other.diemCVHT)
				&& Float.floatToIntBits(diemSV) == Float.floatToIntBits(other.diemSV)
				&& Objects.equals(ghichu, other.ghichu) && Objects.equals(ho, other.ho)
				&& Objects.equals(kiHoc, other.kiHoc) && Objects.equals(maSinhvien, other.maSinhvien)
				&& Objects.equals(ten, other.ten) && Objects.equals(xepLoairenluyen, other.xepLoairenluyen);
	}

}