package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThanhToan extends JPanel {
	private JTextField txtMaSV;
	private JTextField txtHo;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtLop;
	private JTextField textField;
    JTable tab;
	/**
	 * Create the panel.
	 */
	public ThanhToan() {
		tab=new JTable();
		tab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MADK", "NỘI DUNG", "BẮT BUỘC ", "TÍN CHỈ", "SỐ TIỀN"
			}
		));
		JLabel lblNewLabel = new JLabel("Cổng thanh toán");
		lblNewLabel.setBounds(312, 5, 227, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		setLayout(null);
		add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243, 179, 139));
		panel_1.setBounds(10, 49, 935, 643);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Mã sinh viên:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 30, 83, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Họ va Tên");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(10, 95, 83, 15);
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
		txtMaSV.setEditable(false);
		txtMaSV.setBounds(94, 29, 138, 27);
		panel_1.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtHo = new JTextField();
		txtHo.setEditable(false);
		txtHo.setColumns(10);
		txtHo.setBounds(94, 87, 164, 32);
		panel_1.add(txtHo);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(357, 29, 138, 28);
		panel_1.add(txtNgaySinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(357, 67, 138, 28);
		panel_1.add(txtGioiTinh);
		
		txtLop = new JTextField();
		txtLop.setEditable(false);
		txtLop.setColumns(10);
		txtLop.setBounds(357, 104, 138, 27);
		panel_1.add(txtLop);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin sinh viên");
		lblNewLabel_1.setBounds(281, 0, 147, 19);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(243, 179, 139));
		btnThanhToan.setBounds(615, 164, 114, 23);
		panel_1.add(btnThanhToan);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane(tab);
		scrollPane.setBounds(10, 240, 901, 267);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("LICH SU  GIAO DICH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(283, 215, 179, 14);
		panel_1.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(684, 24, 126, 29);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("HỌC KỲ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(535, 31, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Hủy bỏ");
		btnNewButton.setBackground(new Color(243, 179, 139));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(761, 165, 89, 23);
		panel_1.add(btnNewButton);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(684, 59, 126, 34);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Danh mục thanh toán");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(542, 69, 132, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Số tiền ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1.setBounds(542, 105, 132, 14);
		panel_1.add(lblNewLabel_3_1_1);
		
		textField = new JTextField();
		textField.setBounds(683, 102, 126, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Xem lịch sử");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(761, 544, 89, 23);
		panel_1.add(btnNewButton_1);

	}
}
