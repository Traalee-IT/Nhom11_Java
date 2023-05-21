package Model;

public class DangNhapSV {
	private String MaSV;
	private String Pass;
	public DangNhapSV(String maSV, String Pass) {
		super();
		MaSV = maSV;
		this.Pass = Pass;
	}
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String Pass) {
		this.Pass = Pass;
	}
}
