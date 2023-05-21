package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

import DAO.ConnKetQuanHocTap;
import Model.Danhgiarenluyen;
import Model.Thisinh;
import javax.swing.SwingConstants;

public class ketQuaHocTap extends JPanel {

	
	public ketQuaHocTap() {
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 128));
		panel_1.setBounds(25, 44, 965, 623);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbMaSV = new JLabel("New label");
		lbMaSV.setBounds(32, 39, 215, 29);
		panel_1.add(lbMaSV);
		lbMaSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbLop = new JLabel("New label");
		lbLop.setBounds(32, 434, 300, 30);
		panel_1.add(lbLop);
		lbLop.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbGioiTInh = new JLabel("New label");
		lbGioiTInh.setBounds(32, 367, 300, 30);
		panel_1.add(lbGioiTInh);
		lbGioiTInh.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbNgaySinh = new JLabel("New label");
		lbNgaySinh.setBounds(32, 298, 300, 30);
		panel_1.add(lbNgaySinh);
		lbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbHoVaTen = new JLabel("New label");
		lbHoVaTen.setBounds(32, 131, 337, 23);
		panel_1.add(lbHoVaTen);
		lbHoVaTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbTrungBinh = new JLabel("New label");
		lbTrungBinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTrungBinh.setBounds(536, 367, 357, 30);
		panel_1.add(lbTrungBinh);
		
		JLabel lbHocKy = new JLabel("New label");
		lbHocKy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbHocKy.setBounds(31, 506, 275, 30);
		panel_1.add(lbHocKy);
		
		JLabel lbXaHoi = new JLabel("New label");
		lbXaHoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbXaHoi.setBounds(533, 38, 310, 30);
		panel_1.add(lbXaHoi);
		
		JLabel lbTuTuong = new JLabel("New label");
		lbTuTuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTuTuong.setBounds(536, 127, 357, 30);
		panel_1.add(lbTuTuong);
		
		JLabel lbNhapMon = new JLabel("New label");
		lbNhapMon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbNhapMon.setBounds(533, 211, 357, 30);
		panel_1.add(lbNhapMon);
		
		JLabel lbQueQuan = new JLabel("New label");
		lbQueQuan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbQueQuan.setBounds(33, 211, 352, 30);
		panel_1.add(lbQueQuan);
		
		JLabel lbdiemrenluyen = new JLabel("New label");
		lbdiemrenluyen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbdiemrenluyen.setBounds(536, 298, 357, 30);
		panel_1.add(lbdiemrenluyen);
		
		JLabel labelghichu = new JLabel("New label");
		labelghichu.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelghichu.setBounds(533, 506, 310, 30);
		panel_1.add(labelghichu);
		
		JLabel hanhkiem = new JLabel("New label");
		hanhkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		hanhkiem.setBounds(536, 434, 337, 30);
		panel_1.add(hanhkiem);
		
		JLabel lblNewLabel_1 = new JLabel("Kết quả học tập");
		lblNewLabel_1.setBounds(464, 11, 142, 22);
		add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
       
		try {
			/// bon e se viet phân code vào đây nha
			for(Thisinh dgrl:ConnKetQuanHocTap.ketqua().SelectThongTin(formDangNhapSinhVien.madn)) {
				lbMaSV.setText("Ma Sinh Vien:"+" "+dgrl.getMasv());
				lbHoVaTen.setText("Họ và Tên :"+dgrl.getHo()+" "+dgrl.getTen());
				lbQueQuan.setText("Que Quan:"+" "+dgrl.getQuequan());
				lbNgaySinh.setText("Ngay Sinh:"+" "+dgrl.getNgaysinh());
				if(dgrl.isGioitinh()==true)
				{
					lbGioiTInh.setText("Giới tính :Nam");
				}
				else
				{
					lbGioiTInh.setText("Giới tính :Nữ");
				}
				lbLop.setText("Lớp học : "+dgrl.getLop());
				lbXaHoi.setText("Xa Hoi :"+" "+dgrl.getDiemtoan());
				lbTuTuong.setText("Tu Tuong :"+" "+dgrl.getDiemli());
				lbNhapMon.setText("Nhap Mon :"+" "+dgrl.getDiemhoa());
				lbTrungBinh.setText("Diem Trung Binh : "+dgrl.getDiemtb());
				lbHocKy.setText("học kỳ"+dgrl.getHocky());
				//Tuong tự với các label khác nha
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Danhgiarenluyen rl:ConnKetQuanHocTap.ketqua().selectAllconDition(formDangNhapSinhVien.madn)) {
			lbdiemrenluyen.setText("Điểm rèn luyện: "+rl.getDiemCVHT());
			hanhkiem.setText("Hạnh Kiểm : "+rl.getXepLoairenluyen());
			labelghichu.setText("Ghi chú : "+rl.getGhichu());
		}
		
	}
}
