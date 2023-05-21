package Model;

import java.sql.Date;
import java.util.Objects;

public class DsDiemDanh  {
        
         private String masv;
         private String ho;
         private String ten;
         private Date ngaysinh;
         private boolean gioitinh;
         private String lop; 
         private boolean cophep;
         private boolean kophep;
         private float phantram;
         public DsDiemDanh(String masv, String ho, String ten, Date ngaysinh, boolean gioitinh, String lop,
				boolean cophep, boolean kophep, float phantram) {
			super();
			this.masv = masv;
			this.ho = ho;
			this.ten = ten;
			this.ngaysinh = ngaysinh;
			this.gioitinh = gioitinh;
			this.lop = lop;
			this.cophep = cophep;
			this.kophep = kophep;
			this.phantram = phantram;
		}
		@Override
		public String toString() {
			return "" + masv + ", " + ho + "," + ten + "," + ngaysinh + ","
					+ gioitinh + ", " + lop + ",=" + cophep + "," + kophep + "," + phantram
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
		public boolean isCophep() {
			return cophep;
		}
		public void setCophep(boolean cophep) {
			this.cophep = cophep;
		}
		public boolean isKophep() {
			return kophep;
		}
		public void setKophep(boolean kophep) {
			this.kophep = kophep;
		}
		public float getPhantram() {
			return phantram;
		}
		public void setPhantram(float phantram) {
			this.phantram = phantram;
		}
		@Override
		public int hashCode() {
			return Objects.hash(cophep, gioitinh, ho, kophep, lop, masv, ngaysinh, phantram, ten);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DsDiemDanh other = (DsDiemDanh) obj;
			return cophep == other.cophep && gioitinh == other.gioitinh && Objects.equals(ho, other.ho)
					&& kophep == other.kophep && Objects.equals(lop, other.lop) && Objects.equals(masv, other.masv)
					&& Objects.equals(ngaysinh, other.ngaysinh)
					&& Float.floatToIntBits(phantram) == Float.floatToIntBits(other.phantram)
					&& Objects.equals(ten, other.ten);
		}
	

}
