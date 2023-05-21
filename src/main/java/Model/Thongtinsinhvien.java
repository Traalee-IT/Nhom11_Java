package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Objects;

public class Thongtinsinhvien {
	  private String luuHinhanh;
      private String maSV;
      private String hoVaTen;
      private String trAngthai;
      private String Gioitinh;
      private String malop;
      private String ChuyenNganh;
      private String Khoa;
      private String giangvien;
      private Date Ngaysinh;
      private String SDT;
      private String Hokhau;
      private String Dantoc;
      private String Tongiao;
      private String CMND;
      
	public Thongtinsinhvien() {
		super();
	}
	public Thongtinsinhvien(String luuHinhanh, String maSV, String hoVaTen, String trAngthai, String gioitinh,
			String malop, String chuyenNganh, String khoa, String giangvien, Date ngaysinh, String sDT, String hokhau,
			String dantoc, String tongiao, String cMND) {
		super();
		this.luuHinhanh = luuHinhanh;
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		this.trAngthai = trAngthai;
		Gioitinh = gioitinh;
		this.malop = malop;
		ChuyenNganh = chuyenNganh;
		Khoa = khoa;
		this.giangvien = giangvien;
		Ngaysinh = ngaysinh;
		SDT = sDT;
		Hokhau = hokhau;
		Dantoc = dantoc;
		Tongiao = tongiao;
		CMND = cMND;
	}
	public String getLuuHinhanh() {
		return luuHinhanh;
	}
	public void setLuuHinhanh(String luuHinhanh) {
		this.luuHinhanh = luuHinhanh;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getTrAngthai() {
		return trAngthai;
	}
	public void setTrAngthai(String trAngthai) {
		this.trAngthai = trAngthai;
	}
	public String getGioitinh() {
		return Gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getChuyenNganh() {
		return ChuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		ChuyenNganh = chuyenNganh;
	}
	public String getKhoa() {
		return Khoa;
	}
	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	public String getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(String giangvien) {
		this.giangvien = giangvien;
	}
	public Date getNgaysinh() {
		return Ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		Ngaysinh = ngaysinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getHokhau() {
		return Hokhau;
	}
	public void setHokhau(String hokhau) {
		Hokhau = hokhau;
	}
	public String getDantoc() {
		return Dantoc;
	}
	public void setDantoc(String dantoc) {
		Dantoc = dantoc;
	}
	public String getTongiao() {
		return Tongiao;
	}
	public void setTongiao(String tongiao) {
		Tongiao = tongiao;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	@Override
	public String toString() {
		return "Thongtinsinhvien [luuHinhanh=" + luuHinhanh + ", maSV=" + maSV + ", hoVaTen=" + hoVaTen + ", trAngthai="
				+ trAngthai + ", Gioitinh=" + Gioitinh + ", malop=" + malop + ", ChuyenNganh=" + ChuyenNganh + ", Khoa="
				+ Khoa + ", giangvien=" + giangvien + ", Ngaysinh=" + Ngaysinh + ", SDT=" + SDT + ", Hokhau=" + Hokhau
				+ ", Dantoc=" + Dantoc + ", Tongiao=" + Tongiao + ", CMND=" + CMND + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(CMND, ChuyenNganh, Dantoc, Gioitinh, Hokhau, Khoa, Ngaysinh, SDT, Tongiao, giangvien,
				hoVaTen, luuHinhanh, maSV, malop, trAngthai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thongtinsinhvien other = (Thongtinsinhvien) obj;
		return Objects.equals(CMND, other.CMND) && Objects.equals(ChuyenNganh, other.ChuyenNganh)
				&& Objects.equals(Dantoc, other.Dantoc) && Objects.equals(Gioitinh, other.Gioitinh)
				&& Objects.equals(Hokhau, other.Hokhau) && Objects.equals(Khoa, other.Khoa)
				&& Objects.equals(Ngaysinh, other.Ngaysinh) && Objects.equals(SDT, other.SDT)
				&& Objects.equals(Tongiao, other.Tongiao) && Objects.equals(giangvien, other.giangvien)
				&& Objects.equals(hoVaTen, other.hoVaTen) && Objects.equals(luuHinhanh, other.luuHinhanh)
				&& Objects.equals(maSV, other.maSV) && Objects.equals(malop, other.malop)
				&& Objects.equals(trAngthai, other.trAngthai);
	}
      

      
}