package Model;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class QuanLy {
	  private String maphong;
	   private String tenPhong;
	   private String ngquanly;	 
	   private String gvday;
	   private DateTimeFormatter thoigian;
	   private Date namql;
	   private int siso;
	   public QuanLy(String maphong, String tenPhong, String ngquanly,  String gvday,
			DateTimeFormatter thoigian, Date namql, int siso) {

		this.maphong = maphong;
		this.tenPhong = tenPhong;
		this.ngquanly = ngquanly;
	
		this.gvday = gvday;
		this.thoigian = thoigian;
		this.namql = namql;
		this.siso = siso;
	}
	@Override
	public String toString() {
		return "QuanLy [maphong=" + maphong + ", tenPhong=" + tenPhong + ", ngquanly=" + ngquanly + 
				 ", gvday=" + gvday + ", thoigian=" + thoigian + ", namql=" + namql + ", siso=" + siso
				+ "]";
	}
	public String getMaphong() {
		return maphong;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getNgquanly() {
		return ngquanly;
	}
	public void setNgquanly(String ngquanly) {
		this.ngquanly = ngquanly;
	}
	
	
	public String getGvday() {
		return gvday;
	}
	public void setGvday(String gvday) {
		this.gvday = gvday;
	}
	public DateTimeFormatter getThoigian() {
		return thoigian;
	}
	public void setThoigian(DateTimeFormatter thoigian) {
		this.thoigian = thoigian;
	}
	public Date getNamql() {
		return namql;
	}
	public void setNamql(Date namql) {
		this.namql = namql;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	@Override
	public int hashCode() {
		return Objects.hash( gvday, maphong, namql, ngquanly, siso, tenPhong, thoigian);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanLy other = (QuanLy) obj;
		return  Objects.equals(gvday, other.gvday)
				&& Objects.equals(maphong, other.maphong) && Objects.equals(namql, other.namql)
				&& Objects.equals(ngquanly, other.ngquanly) && siso == other.siso
				&& Objects.equals(tenPhong, other.tenPhong) && Objects.equals(thoigian, other.thoigian);
	}
	
	  
}
