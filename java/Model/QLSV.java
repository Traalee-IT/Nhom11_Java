package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class QLSV {
	Thisinh t;
      private  ArrayList<Thisinh>danhsach;
     private String luachon;
     private String tenfile="";
	public String getTenfile() {
		return tenfile;
	}
	public void setTenfile(String tenfile) {
		this.tenfile = tenfile;
	}
	public QLSV(ArrayList<Thisinh> danhsach) {
		super();
		this.danhsach = danhsach;
	}
	public QLSV() {
         
		this.danhsach = new ArrayList<Thisinh>();
	      this.luachon="";
	}
 public String getLuachon() {
		return luachon;
	}
	public void setLuachon(String luachon) {
		this.luachon =luachon;
	}
public ArrayList<Thisinh> getDsThiSinh() {
		return danhsach;
	}

	public void setDsThiSinh(ArrayList<Thisinh> danhsach) {
		this.danhsach = danhsach;
	}
	public void insert(Thisinh danhsach) {
	  this.danhsach.add(danhsach);
}
	public void remove(Thisinh danhsach) {
		  this.danhsach.remove(danhsach);
		 
		  
	  }
//	public void delete(Thisinh thiSinh) {
//		
//		Iterator<Thisinh> iterator = thiSinh.;
//		while(iterator.hasNext()) {
//			Thisinh ts = iterator.next();
//			if(ts.equals(ts)) {
//				iterator.remove();
//			}
//		}
//	}
  public void update(Thisinh danhsach) {
	  this.danhsach.remove(danhsach);
	  this.danhsach.add(danhsach);
	  
  }
public boolean kiemTraTonTai(Thisinh ts) {
	for(Thisinh ts2:danhsach) {
		if(ts2.getMasv().equals(ts.getMasv()))
			return true;
	} 
	return false;
}
public String insertSQL() {
	return "INSERT INTO qlsinhvien(Masv, Tên,Quê, Date, GiớiTinh, Điểm toán, Điểm lý, Điẻm hóa) "
       		+ "VALUES ('"+t.getMasv()+"','"+t.getTen()+"',,"+t.quequan.gettenTinh()+"',"+t.isGioitinh()+","+t.getNgaysinh()+","+t.getDiemtoan()+","+t.getDiemli()+","+t.getDiemhoa()+")";
   

}
}