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
		setBackground(new Color(128, 128, 192));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 830, 49);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Kết quả học tập");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(10, 99, 830, 420);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbMaSV = new JLabel("New label");
		lbMaSV.setBounds(32, 37, 238, 29);
		panel_1.add(lbMaSV);
		lbMaSV.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbLop = new JLabel("New label");
		lbLop.setBounds(32, 291, 121, 30);
		panel_1.add(lbLop);
		lbLop.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbGioiTInh = new JLabel("New label");
		lbGioiTInh.setBounds(32, 239, 121, 30);
		panel_1.add(lbGioiTInh);
		lbGioiTInh.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbNgaySinh = new JLabel("New label");
		lbNgaySinh.setBounds(32, 182, 238, 30);
		panel_1.add(lbNgaySinh);
		lbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbHoVaTen = new JLabel("New label");
		lbHoVaTen.setBounds(32, 89, 121, 23);
		panel_1.add(lbHoVaTen);
		lbHoVaTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbTrungBinh = new JLabel("New label");
		lbTrungBinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTrungBinh.setBounds(442, 172, 225, 30);
		panel_1.add(lbTrungBinh);
		
		JLabel lbHocKy = new JLabel("New label");
		lbHocKy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbHocKy.setBounds(267, 348, 121, 30);
		panel_1.add(lbHocKy);
		
		JLabel lbXaHoi = new JLabel("New label");
		lbXaHoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbXaHoi.setBounds(442, 38, 121, 30);
		panel_1.add(lbXaHoi);
		
		JLabel lbTuTuong = new JLabel("New label");
		lbTuTuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTuTuong.setBounds(442, 85, 121, 30);
		panel_1.add(lbTuTuong);
		
		JLabel lbNhapMon = new JLabel("New label");
		lbNhapMon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbNhapMon.setBounds(442, 131, 121, 30);
		panel_1.add(lbNhapMon);
		
		JLabel lbQueQuan = new JLabel("New label");
		lbQueQuan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbQueQuan.setBounds(32, 131, 238, 30);
		panel_1.add(lbQueQuan);
       
		try {
			/// bon e se viet phân code vào đây nha
			for(Thisinh dgrl:ConnKetQuanHocTap.ketqua().SelectThongTin()) {
				lbMaSV.setText("Ma Sinh Vien:"+" "+dgrl.getMasv());
				lbHoVaTen.setText(dgrl.getHo()+" "+dgrl.getTen());
				lbQueQuan.setText("Que Quan:"+" "+dgrl.getQuequan());
				lbNgaySinh.setText("Ngay Sinh:"+" "+dgrl.getNgaysinh());
				if(dgrl.isGioitinh()==true)
				{
					lbGioiTInh.setText("Nam");
				}
				else
				{
					lbGioiTInh.setText("Nu");
				}
				lbLop.setText(dgrl.getLop());
				lbXaHoi.setText("Xa Hoi:"+" "+dgrl.getDiemtoan());
				lbTuTuong.setText("Tu Tuong:"+" "+dgrl.getDiemli());
				lbNhapMon.setText("Nhap Mon:"+" "+dgrl.getDiemhoa());
				lbTrungBinh.setText("Diem Trung Binh:"+" "+dgrl.getDiemtb());
				lbHocKy.setText(dgrl.getHocky());
				//Tuong tự với các label khác nha
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
