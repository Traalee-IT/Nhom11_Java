package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ConnKetQuanHocTap;
import DAO.ConnectThanhToan;
import Model.Thisinh;
import Model.congThanhToan;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ThanhToan extends JPanel {
	private JTextField txtMaSV;
	private JTextField txtHoten;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtLop;
	private JTextField txtSoTien;
    JTable tab;
    JComboBox comboBox;
    JComboBox comboBox_1 ;
    JComboBox comboBox_2 ;
	/**
	 * Create the panel.
	 */
    ArrayList<String> ar; 
	private JTextField textField;
	private JTextField txtsoDu;
	public ThanhToan() {
		setBackground(new Color(128, 255, 128));
		tab=new JTable();
		tab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MAHOADON","NỘI DUNG", "TÔNG THANH TOÁN","HỌC KỲ", "NGÂN HÀNG", "MÃ NGÂN HÀNG", "SỐ TIỀN","THỜI GIAN"
			}
		));
		JLabel lblNewLabel = new JLabel("Cổng thanh toán");
		lblNewLabel.setBounds(312, 5, 227, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		setLayout(null);
		add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 128));
		panel_1.setBounds(10, 49, 1035, 613);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Mã sinh viên:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 30, 83, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Họ va Tên");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(10, 90, 83, 15);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("Ngày sinh:");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_3.setBounds(281, 30, 83, 15);
		panel_1.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Giới tính:");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_4.setBounds(281, 68, 83, 15);
		panel_1.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Lớp:");
		lblNewLabel_5_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_5.setBounds(281, 106, 83, 15);
		panel_1.add(lblNewLabel_5_5);
		
		txtMaSV = new JTextField();
		txtMaSV.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaSV.setEditable(false);
		txtMaSV.setBounds(102, 25, 138, 27);
		panel_1.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtHoten = new JTextField();
		txtHoten.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtHoten.setEditable(false);
		txtHoten.setColumns(10);
		txtHoten.setBounds(103, 81, 164, 32);
		panel_1.add(txtHoten);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(357, 29, 138, 28);
		panel_1.add(txtNgaySinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(357, 67, 138, 28);
		panel_1.add(txtGioiTinh);
		
		txtLop = new JTextField();
		txtLop.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtLop.setEditable(false);
		txtLop.setColumns(10);
		txtLop.setBounds(357, 104, 138, 27);
		panel_1.add(txtLop);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin sinh viên");
		lblNewLabel_1.setBounds(366, 0, 147, 19);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capnhat();
			}
		});
		btnThanhToan.setBackground(new Color(243, 179, 139));
		btnThanhToan.setBounds(911, 122, 114, 23);
		panel_1.add(btnThanhToan);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane(tab);
		scrollPane.setBounds(10, 335, 1015, 267);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("LỊCH SỬ GIAO DỊCH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(334, 310, 179, 14);
		panel_1.add(lblNewLabel_2);
		
	 comboBox = new JComboBox();
	 comboBox.addItem("");
	 comboBox.addItem("hk1:2022-2023");
	 comboBox.addItem("hk2:2022-2023");
	 comboBox.addItem("hk3:2022-2023");
	 comboBox.addItem("hk4:2022-2023");
	 comboBox.addItem("hk5:2022-2023");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("hk1:2022-2023")) {
					txtSoTien.setText("8000000.0");
				}
				
			}
		});
		comboBox.setBounds(684, 24, 138, 29);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("HỌC KỲ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(535, 31, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Hủy bỏ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   comboBox.setSelectedItem("");
			        comboBox_1.setSelectedItem("");
			        comboBox_2.setSelectedItem("");
			        textField.setText("");
				
			}
		});
		btnNewButton.setBackground(new Color(243, 179, 139));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(936, 43, 89, 23);
		panel_1.add(btnNewButton);
		
	 comboBox_1 = new JComboBox();
	 comboBox_1.addItem("");
	 comboBox_1.addItem("HỌC PHÍ");
	 comboBox_1.addItem(" THU CHI KHÁC");
		comboBox_1.setBounds(684, 122, 138, 34);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Danh mục thanh toán");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(535, 127, 132, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Số tiền ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1.setBounds(535, 91, 132, 14);
		panel_1.add(lblNewLabel_3_1_1);
		
		txtSoTien = new JTextField();
		txtSoTien.setBounds(684, 76, 139, 29);
		panel_1.add(txtSoTien);
		txtSoTien.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Xem lịch sử");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(761, 544, 89, 23);
		panel_1.add(btnNewButton_1);
		
		 ArrayList<String> ar=ConnectThanhToan.getConnect().Thongtinsinhvien(formDangNhapSinhVien.madn);
	
		    txtMaSV.setText(ar.get(0));
			txtHoten.setText(ar.get(1));
			txtNgaySinh.setText(ar.get(2));
			txtGioiTinh.setText(ar.get(3));
			txtLop.setText(ar.get(4));
			
			JLabel lblNewLabel_3_1_1_1 = new JLabel("Số Tài Khoản Nhà trường ");
			lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3_1_1_1.setBounds(385, 222, 147, 27);
			panel_1.add(lblNewLabel_3_1_1_1);
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.BOLD, 14));
			 comboBox_2 = new JComboBox();
			 comboBox_2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		if(comboBox_2.getSelectedItem().equals("BIDV")) {
			 			textField.setText("1234567");
			 		}else if(comboBox_2.getSelectedItem().equals("VCB")) {
			 			textField.setText("7654321");
			 		}
			 	}
			 });
			comboBox_2.addItem("");
			comboBox_2.addItem("BIDV");
			comboBox_2.addItem("VCB");
			comboBox_2.setBounds(102, 157, 165, 27);
			panel_1.add(comboBox_2);

			textField.setBounds(555, 217, 194, 34);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lbnganhang = new JLabel("Ngân hàng");
			lbnganhang.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbnganhang.setBounds(10, 158, 114, 21);
			panel_1.add(lbnganhang);
			
			txtsoDu = new JTextField("14000000");
			txtsoDu.setFont(new Font("Tahoma", Font.BOLD, 15));
			txtsoDu.setEnabled(false);
			txtsoDu.setBounds(123, 218, 157, 32);
			panel_1.add(txtsoDu);
			txtsoDu.setColumns(10);
			
			JLabel lblSD = new JLabel("Số dư");
			lblSD.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSD.setBounds(23, 223, 114, 21);
			panel_1.add(lblSD);
			
			JButton btnNewButton_2 = new JButton("XEM LỊCH SỬ");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select();
				}
			});
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton_2.setBounds(849, 218, 176, 32);
			panel_1.add(btnNewButton_2);
		
		  
	     
	     
	}
	public void capnhat() {
	     String masv=txtMaSV.getText();
	     String hocky=comboBox.getSelectedItem()+"";
	     String danhmucthanhtoan=comboBox_1.getSelectedItem()+"";
	     double sotien = Double.valueOf(txtSoTien.getText()+"");
	     String tenngangang =  comboBox_2.getSelectedItem()+"";
	     LocalTime now = java.time.LocalTime.now();
	     String sotaikhoannhatruong= textField.getText();
	     SimpleDateFormat fomatDate=new SimpleDateFormat("dd/MM/yyyy");
    		Date date=new Date(); 
	     String dates=(date+" "+now+"");	
	    double giatien= Double.parseDouble(txtsoDu.getText())-sotien;
	    if( ConnectThanhToan.getConnect().updateThanhToan(masv, hocky, danhmucthanhtoan, sotien,sotaikhoannhatruong,dates,tenngangang,giatien)==1) {
	     if(Double.valueOf(txtsoDu.getText())<Double.valueOf(txtSoTien.getText()+"")) {
	    	 int luachon=JOptionPane.showConfirmDialog(this,"số tiền tài khoản không đủ vui lòng nạp thêm tiền ");
	    		if(luachon==JOptionPane.YES_OPTION) {
	    			return ;
	    		}
	     }

	   
	     ConnectThanhToan.getConnect().updateThanhToan(masv, hocky, danhmucthanhtoan, sotien,sotaikhoannhatruong,dates,tenngangang,giatien);     
	        txtsoDu.setText(giatien+"");
	    }
	        comboBox.setSelectedItem("");
	        comboBox_1.setSelectedItem("");
	        comboBox_2.setSelectedItem("");
	        textField.setText("");

}
	public void select()
	{ 
		DefaultTableModel model=(DefaultTableModel)tab.getModel();
		try {
			/// bon e se viet phân code vào đây nha
			for(congThanhToan ctt:ConnectThanhToan.getConnect().selectThanhToan(formDangNhapSinhVien.madn)) {
				model.addRow(new Object[] {
	   	        		 model.getRowCount()+1,
	   	        		 ctt.getMahoadon(),
	   	        		 ctt.getNoidung(),
	   	        		 ctt.getTongthanhtoan(),
	   	        		 ctt.getHocky(),
	   	        		 ctt.getTenganhang(),
	   	        		 ctt.getMasotaikhoan(),
	   	        		 ctt.getSodu(),
	   	        		 ctt.getThoigian()
	   	    		     });
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
