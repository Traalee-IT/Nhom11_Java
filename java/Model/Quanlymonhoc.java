package Model;

public class Quanlymonhoc {
	private String maMonhoc;
	private String tenMonhoc;
	private String soTinchi;
	private String maKhoa;
	public Quanlymonhoc(String maMonhoc, String tenMonhoc, String soTinchi, String maKhoa) {
		this.maMonhoc = maMonhoc;
		this.tenMonhoc = tenMonhoc;
		this.soTinchi = soTinchi;
		this.maKhoa = maKhoa;
	}
	public String getMaMonhoc() {
		return maMonhoc;
	}
	public void setMaMonhoc(String maMonhoc) {
		this.maMonhoc = maMonhoc;
	}
	public String getTenMonhoc() {
		return tenMonhoc;
	}
	public void setTenMonhoc(String tenMonhoc) {
		this.tenMonhoc = tenMonhoc;
	}
	public String getSoTinchi() {
		return soTinchi;
	}
	public void setSoTinchi(String soTinchi) {
		this.soTinchi = soTinchi;
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	@Override
	public String toString() {
		return "Quanlymonhoc [maMonhoc=" + maMonhoc + ", tenMonhoc=" + tenMonhoc + ", soTinchi=" + soTinchi
				+ ", maKhoa=" + maKhoa + "]";
	}
	
	
}