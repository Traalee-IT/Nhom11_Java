package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh implements Serializable{
 
   private String tentinh;




public String gettenTinh() {
	return tentinh; 
}
public void settenTinh(String tinh) {
	this.tentinh = tinh;
}
public Tinh( String tinh) {
	super();
	
	this.tentinh = tinh;
}
@Override
public String toString() {
	return ""  + tentinh ;
}
@Override
public int hashCode() {
	return Objects.hash( tentinh);
}
@Override
public boolean equals(Object obj) {
	
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Tinh other = (Tinh) obj;
	return Objects.equals(tentinh, other.tentinh);
}
// su dụng nếu ko tạo ra đối tương thí đùng sattic như này
public static ArrayList<Tinh> getDSTinh(){
	String[] arr_tinh = {"An Giang",
						"Bà Rịa – Vũng Tàu",
						"Bạc Liêu",
						"Bắc Giang",
						"Bắc Kạn",
						"Bắc Ninh",
						"Bến Tre",
						"Bình Dương",
						"Bình Định",
						"Bình Phước",
						"Bình Thuận",
						"Cà Mau",
						"Cao Bằng",
						"Cần Thơ",
						"Đà Nẵng",
						"Đắk Lắk",
						"Đắk Nông",
						"Điện Biên",
						"Đồng Nai",
						"Đồng Tháp",
						"Gia Lai",
						"Hà Giang",
						"Hà Nam",
						"Hà Nội",
						"Hà Tĩnh",
						"Hải Dương",
						"Hải Phòng",
						"Hậu Giang",
						"Hòa Bình",
						"Thành phố Hồ Chí Minh",
						"Hưng Yên",
						"Khánh Hòa",
						"Kiên Giang",
						"Kon Tum",
						"Lai Châu",
						"Lạng Sơn",
						"Lào Cai",
						"Lâm Đồng",
						"Long An",
						"Nam Định",
						"Nghệ An",
						"Ninh Bình",
						"Ninh Thuận",
						"Phú Thọ",
						"Phú Yên",
						"Quảng Bình",
						"Quảng Nam",
						"Quảng Ngãi",
						"Quảng Ninh",
						"Quảng Trị",
						"Sóc Trăng",
						"Sơn La",
						"Tây Ninh",
						"Thái Bình",
						"Thái Nguyên",
						"Thanh Hóa",
						"Thừa Thiên Huế",
						"Tiền Giang",
						"Trà Vinh",
						"Tuyên Quang",
						"Vĩnh Long",
						"Vĩnh Phúc",
						"Yên Bái"};
	

	ArrayList<Tinh> listTinh = new ArrayList<Tinh>();
	int i = 0;
	for (String tenTinh : arr_tinh) {
		Tinh t = new Tinh(tenTinh);
		// lúc này 1 lần add se tạo ra mang có gtri là [i-tentinh,...,n-tentinh]
		// như vâỵ tinh ser đc truyền là 2 gtri cùng 1 lúc add tai mỗi một đối tươnhg
		// arraylits
		// chức năng của Arraylist là thêm họac bớt đôi tượng 1 cách linh hoạt
		listTinh.add(t);
	}
	return listTinh;
}
public static Tinh getTinhById(int quequan) {
	return Tinh.getDSTinh().get(quequan);
}

public static Tinh getTinhByTen(String tenTinh) {
	ArrayList<Tinh> listTinh = Tinh.getDSTinh();
	for (Tinh tinh :listTinh) {
		if(tinh.tentinh.equals(tenTinh))
			return tinh;
	}
	return null;
}
}
