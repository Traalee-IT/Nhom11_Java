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
      private String lOp;
      private String ChuyenNganh;
      private String Khoa;
      private String Nganh;
      private Date Ngaysinh;
      private String SDT;
      private String Hokhau;
      private String Dantoc;
      private String Tongiao;
      private String CMND;
      
	public Thongtinsinhvien()
	{
		
	}
	public Thongtinsinhvien(String luuHinhanh,String maSV, String hoVaTen, String trAngthai, String gioitinh, String lOp,
			String chuyenNganh, String khoa, String nganh, Date ngaysinh, String sDT, String hokhau, String dantoc,
			String tongiao, String cMND) {
		
		this.luuHinhanh = luuHinhanh;
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		this.trAngthai = trAngthai;
		Gioitinh = gioitinh;
		this.lOp = lOp;
		ChuyenNganh = chuyenNganh;
		Khoa = khoa;
		Nganh = nganh;
		Ngaysinh = ngaysinh;
		SDT = sDT;
		Hokhau = hokhau;
		Dantoc = dantoc;
		Tongiao = tongiao;
		CMND = cMND;
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
	public String getlOp() {
		return lOp;
	}
	public void setlOp(String lOp) {
		this.lOp = lOp;
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
	public String getNganh() {
		return Nganh;
	}
	public void setNganh(String nganh) {
		Nganh = nganh;
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
	public String getLuuHinhanh() {
		return luuHinhanh;
	}
	public void setLuuHinhanh(String luuHinhanh) {
		this.luuHinhanh = luuHinhanh;
	}
	@Override
	public String toString() {
		return "Thongtinsinhvien [luuHinhanh=" + luuHinhanh + ", maSV=" + maSV + ", hoVaTen=" + hoVaTen + ", trAngthai="
				+ trAngthai + ", Gioitinh=" + Gioitinh + ", lOp=" + lOp + ", ChuyenNganh=" + ChuyenNganh + ", Khoa="
				+ Khoa + ", Nganh=" + Nganh + ", Ngaysinh=" + Ngaysinh + ", SDT=" + SDT + ", Hokhau=" + Hokhau
				+ ", Dantoc=" + Dantoc + ", Tongiao=" + Tongiao + ", CMND=" + CMND + "]";
	}
	
	
      
}