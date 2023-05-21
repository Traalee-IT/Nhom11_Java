package Model;

import java.util.Objects;

public class congThanhToan {
   private String mahd; 
   private String masv;
   private double sotien;
   private double sodu;
   private String noidung;
public String getMahd() {
	return mahd;
}
public void setMahd(String mahd) {
	this.mahd = mahd;
}
public String getMasv() {
	return masv;
}
public void setMasv(String masv) {
	this.masv = masv;
}
public double getSotien() {
	return sotien;
}
public void setSotien(double sotien) {
	this.sotien = sotien;
}
public double getSodu() {
	return sodu;
}
public void setSodu(double sodu) {
	this.sodu = sodu;
}
public String getNoidung() {
	return noidung;
}
public void setNoidung(String noidung) {
	this.noidung = noidung;
}
public congThanhToan(String mahd, String masv, double sotien, double sodu, String noidung) {
	super();
	this.mahd = mahd;
	this.masv = masv;
	this.sotien = sotien;
	this.sodu = sodu;
	this.noidung = noidung;
}
@Override
public String toString() {
	return "congThanhToan [mahd=" + mahd + ", masv=" + masv + ", sotien=" + sotien + ", sodu=" + sodu + ", noidung="
			+ noidung + "]";
}
@Override
public int hashCode() {
	return Objects.hash(mahd, masv, noidung, sodu, sotien);
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
	return Objects.equals(mahd, other.mahd) && Objects.equals(masv, other.masv)
			&& Objects.equals(noidung, other.noidung)
			&& Double.doubleToLongBits(sodu) == Double.doubleToLongBits(other.sodu)
			&& Double.doubleToLongBits(sotien) == Double.doubleToLongBits(other.sotien);
}
    
    
}
