package Model;

import java.util.Objects;

public class congThanhToan {
    private String mahoadon;
    private String thoigian;
    private String noidung;
    private double tongthanhtoan;
    private String hocky;
    private double sodu;
    private String masotaikhoan;
    private String tenganhang;
	public congThanhToan(String mahoadon, String thoigian, String noidung, double tongthanhtoan, String hocky,
			double sodu, String masotaikhoan, String tenganhang) {
		super();
		this.mahoadon = mahoadon;
		this.thoigian = thoigian;
		this.noidung = noidung;
		this.tongthanhtoan = tongthanhtoan;
		this.hocky = hocky;
		this.sodu = sodu;
		this.masotaikhoan = masotaikhoan;
		this.tenganhang = tenganhang;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getThoigian() {
		return thoigian;
	}
	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public double getTongthanhtoan() {
		return tongthanhtoan;
	}
	public void setTongthanhtoan(double tongthanhtoan) {
		this.tongthanhtoan = tongthanhtoan;
	}
	public String getHocky() {
		return hocky;
	}
	public void setHocky(String hocky) {
		this.hocky = hocky;
	}
	public double getSodu() {
		return sodu;
	}
	public void setSodu(double sodu) {
		this.sodu = sodu;
	}
	public String getMasotaikhoan() {
		return masotaikhoan;
	}
	public void setMasotaikhoan(String masotaikhoan) {
		this.masotaikhoan = masotaikhoan;
	}
	public String getTenganhang() {
		return tenganhang;
	}
	public void setTenganhang(String tenganhang) {
		this.tenganhang = tenganhang;
	}
	@Override
	public String toString() {
		return "congThanhToan [mahoadon=" + mahoadon + ", thoigian=" + thoigian + ", noidung=" + noidung
				+ ", tongthanhtoan=" + tongthanhtoan + ", hocky=" + hocky + ", sodu=" + sodu + ", masotaikhoan="
				+ masotaikhoan + ", tenganhang=" + tenganhang + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(hocky, mahoadon, masotaikhoan, noidung, sodu, tenganhang, thoigian, tongthanhtoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		congThanhToan other = (congThanhToan) obj;
		return Objects.equals(hocky, other.hocky) && Objects.equals(mahoadon, other.mahoadon)
				&& Objects.equals(masotaikhoan, other.masotaikhoan) && Objects.equals(noidung, other.noidung)
				&& Double.doubleToLongBits(sodu) == Double.doubleToLongBits(other.sodu)
				&& Objects.equals(tenganhang, other.tenganhang) && Objects.equals(thoigian, other.thoigian)
				&& Double.doubleToLongBits(tongthanhtoan) == Double.doubleToLongBits(other.tongthanhtoan);
	}
	
    
    
    
}
