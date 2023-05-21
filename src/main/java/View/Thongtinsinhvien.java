package View;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import DAO.connectThongTinSinhVien;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Thongtinsinhvien extends JPanel {
	private JTextField txtTrangthai;
	private JTextField txtMaSV;
	private JTextField txtHovaten;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_16;
	private JTextField txtSDT;
	private JLabel lblNewLabel_17;
	private JTextField txtHokhau;
	private JLabel lblNewLabel_19;
	private JTextField txtTongiao;
	private JTextField txtCMND;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_8;
	static JLabel labelanh;
	private JButton btnCapNhat;
	private JTextField txtLop;
	private JTextField txtChuyennganh;
	private JRadioButton rbNu;
	private JRadioButton rbNam;
	JComboBox cbbdantoc;
	 public static String masv;
	JDateChooser dateNgaysinh=new JDateChooser();
	private JTextField textFgv;
	private JTextField txtkhoa;
	/**
	 * Create the panel.
	 */
	public Thongtinsinhvien() {
		
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		
		dateNgaysinh.setBounds(169, 442, 282, 29);
		add(dateNgaysinh);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên : ");
		lblNewLabel_1.setBounds(267, 161, 131, 34);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_1);
		
		txtTrangthai = new JTextField();
		txtTrangthai.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTrangthai.setBounds(169, 359, 245, 29);
		add(txtTrangthai);
		txtTrangthai.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Trạng thái  : ");
		lblNewLabel_2.setBounds(23, 355, 131, 34);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Lớp :");
		lblNewLabel_5.setBounds(638, 102, 49, 22);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_5);
		txtMaSV = new JTextField();
		txtMaSV.setEnabled(false);
		txtMaSV.setBackground(UIManager.getColor("Button.background"));
		txtMaSV.setForeground(UIManager.getColor("textText"));
		txtMaSV.setToolTipText("");
		
		txtMaSV.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaSV.setForeground(Color.BLACK);
		txtMaSV.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		txtMaSV.setBounds(408, 100, 186, 29);
		add(txtMaSV);
		txtMaSV.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Chuyên ngành :");
		lblNewLabel_6.setBounds(638, 167, 163, 22);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Khoa  : ");
		lblNewLabel_7.setBounds(638, 231, 96, 23);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Giới tính : ");
		lblNewLabel_9.setBounds(581, 376, 96, 27);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_9);
		
		txtHovaten = new JTextField();
		txtHovaten.setEnabled(false);
		txtHovaten.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtHovaten.setBounds(408, 165, 186, 29);
		add(txtHovaten);
		txtHovaten.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Ngày sinh : ");
		lblNewLabel_13.setBounds(32, 442, 109, 29);
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Dân tộc : ");
		lblNewLabel_14.setBounds(581, 442, 96, 22);
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_14);
		
		lblNewLabel_16 = new JLabel("SĐT : ");
		lblNewLabel_16.setBounds(32, 503, 68, 24);
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_16);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(169, 503, 282, 29);
		add(txtSDT);
		txtSDT.setColumns(10);
		
		lblNewLabel_17 = new JLabel("Hộ khẩu : ");
		lblNewLabel_17.setBounds(29, 560, 96, 29);
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_17);
		
		txtHokhau = new JTextField();
		txtHokhau.setBounds(169, 560, 282, 29);
		add(txtHokhau);
		txtHokhau.setColumns(10);
		
		lblNewLabel_19 = new JLabel("Tôn giáo : ");
		lblNewLabel_19.setBounds(581, 504, 96, 22);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_19);
		
		txtTongiao = new JTextField();
		txtTongiao.setBounds(708, 503, 292, 29);
		add(txtTongiao);
		txtTongiao.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("CMND : ");
		lblNewLabel_20.setBounds(594, 561, 77, 22);
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_20);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(708, 560, 292, 29);
		add(txtCMND);
		txtCMND.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Mã sinh viên : ");
		lblNewLabel_3.setBounds(267, 96, 131, 34);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_3);
		
		labelanh = new JLabel("");
		labelanh.setBounds(29, 138, 163, 199);
		add(labelanh);
		
		btnCapNhat = new JButton("Câp Nhật ");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatesinhvien() ;
			}
		});
		btnCapNhat.setBounds(957, 11, 89, 28);
		add(btnCapNhat);
		
		 rbNu = new JRadioButton("Nữ");
		 rbNu.setBackground(new Color(128, 255, 128));
		 rbNu.setFont(new Font("Arial", Font.BOLD, 15));
		rbNu.setToolTipText("");
		rbNu.setBounds(710, 367, 68, 36);
		add(rbNu);
		
	    rbNam = new JRadioButton("Nam");
	    rbNam.setBackground(new Color(128, 255, 128));
		rbNam.setToolTipText("");
		rbNam.setFont(new Font("Arial", Font.BOLD, 15));
		rbNam.setBounds(824, 367, 68, 36);
		add(rbNam);
		
		ButtonGroup btgroup=new ButtonGroup();
    	btgroup.add(rbNu);
 		btgroup.add(rbNam);
		
		txtLop = new JTextField();
		txtLop.setEnabled(false);
		txtLop.setBounds(810, 101, 190, 29);
		add(txtLop);
		txtLop.setColumns(10);
		
		txtChuyennganh = new JTextField();
		txtChuyennganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChuyennganh.setBounds(810, 166, 190, 29);
		add(txtChuyennganh);
		txtChuyennganh.setColumns(10);
		
		 cbbdantoc = new JComboBox();
		 cbbdantoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		 cbbdantoc.addItem("KINH");
		 cbbdantoc.addItem("MƯỜNG");
		 cbbdantoc.addItem("THÁI");
		 cbbdantoc.addItem("TÀY");
		 cbbdantoc.addItem("NÙNG");
		 cbbdantoc.addItem("EDE");
		 cbbdantoc.addItem("BANA");
		cbbdantoc.setBounds(708, 442, 277, 29);
		add(cbbdantoc);
		
		lblNewLabel_8 = new JLabel("THÔNG TIN SINH VIÊN ");
		lblNewLabel_8.setBounds(387, 10, 220, 24);
		add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel_9_1 = new JLabel("Giảng Viên : ");
		lblNewLabel_9_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_9_1.setBounds(259, 229, 109, 27);
		add(lblNewLabel_9_1);
		
		textFgv = new JTextField();
		textFgv.setColumns(10);
		textFgv.setBounds(401, 230, 206, 29);
		add(textFgv);
		
		txtkhoa = new JTextField();
		txtkhoa.setColumns(10);
		txtkhoa.setBounds(814, 230, 186, 29);
		add(txtkhoa);
		
		setDataa();
	}
	public void setDataa()
	{
		  
		Model.Thongtinsinhvien ttsv = connectThongTinSinhVien.getInforSV().getInformation(formDangNhapSinhVien.madn);
		if(ttsv!=null){
			
			ImageIcon img = new ImageIcon(ttsv.getLuuHinhanh());	
			System.out.println();
			Thongtinsinhvien.labelanh.setIcon(ThongTinCaNhanSinhVien.ResizeImg(ttsv.getLuuHinhanh()));
			txtMaSV.setText(ttsv.getMaSV());
			txtHovaten.setText(ttsv.getHoVaTen());
			txtTrangthai.setText(ttsv.getTrAngthai());
			 if(ttsv.getGioitinh().equals("Nam")) {
				 rbNam.setSelected(true);
			 }else {
				 rbNu.setSelected(true);
			 }
			 txtkhoa.setText(ttsv.getKhoa());
			 txtLop.setText(ttsv.getMalop());
			 txtChuyennganh.setText(ttsv.getChuyenNganh());
			 textFgv.setText(ttsv.getGiangvien());
			 dateNgaysinh.setDate(ttsv.getNgaysinh());
			 txtSDT.setText(ttsv.getSDT());
			 txtHokhau.setText(ttsv.getHokhau());
			 cbbdantoc.setSelectedItem(ttsv.getDantoc());
			 txtTongiao.setText(ttsv.getTongiao());
			 txtCMND.setText(ttsv.getCMND());
		}
	}
	public void updatesinhvien() {
		connectThongTinSinhVien.getInforSV().capnhatTTSV(
				ThongTinCaNhanSinhVien.duonglink,
				txtTrangthai.getText(),
				 txtChuyennganh.getText(),
				 txtkhoa.getText(),
				 cbbdantoc.getSelectedItem()+"",
			     txtSDT.getText(),
				 txtHokhau.getText(),
				 txtTongiao.getText(),
				 txtCMND.getText(),
				 formDangNhapSinhVien.madn
				 );
		
	}
}