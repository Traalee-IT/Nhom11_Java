package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDanhgiaRL;
import DAO.conectSinhvien;
import Model.Danhgiarenluyen;
import Model.Tinh;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class DanhGiaRenLuyen extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	public JLabel lbelMasv ;
	public JLabel mnlabe2 ;
	public JLabel mnlabe3 ;
	public JComboBox cbxhanhkiem;
	JComboBox<String> cbxhocky;
	JComboBox cbxlop;
	private JTextField txtA;
	private JTextField textField_5;
	String lop;
	String cbky;
	public DanhGiaRenLuyen() {
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 974, 43);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("ĐÁNH GIÁ RÈN LUYỆN ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lớp  : ");
		lblNewLabel_1.setBounds(423, 65, 90, 32);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Kì học :");
		lblNewLabel_2.setBounds(20, 65, 78, 22);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 984, 276);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MASV", "H\u1ECC", "T\u00CAN", "K\u1EF2 H\u1ECCC", "\u0110I\u1EC2M Tb", "\u0110I\u1EC2M TH\u00C0NH PH\u1EA6N", "X\u1EBEP LO\u1EA0I", "GHI CH\u00DA"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getjTable1MouseClicked();
			}
		});
		scrollPane.setViewportView(table);
		
	      cbxhocky = new JComboBox();
	      cbxhocky.setFont(new Font("Tahoma", Font.PLAIN, 14));
		   cbxhocky.addItem("");
		   cbxhocky.addItem("hk1:2022-2023");
		   cbxhocky.addItem("hk2:2022-2023");
		   cbxhocky.addItem("hk3:2022-2023");
		   cbxhocky.addItem("hk4:2022-2023");
		   cbxhocky.addItem("hk5:2022-2023");
		cbxhocky.setBounds(110, 65, 172, 32);
		add(cbxhocky);
		
		 cbxlop = new JComboBox();
		 cbxlop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 cbxlop.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		lop=cbxlop.getSelectedItem()+"";
		       cbky=cbxhocky.getSelectedItem()+"";
		       SetDuLieu();
		 	}
		 });
		 try {
				for(String lop : conectSinhvien.getInforSV().getAllLop()) {
					cbxlop.addItem(lop);
				   }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		cbxlop.setBounds(545, 65, 172, 32);
		add(cbxlop);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capnhat();
			}
		});
		btnLuu.setBorderPainted(false);
		btnLuu.setBackground(new Color(255, 255, 0));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuu.setBounds(10, 576, 105, 23);
		add(btnLuu);
		
		JLabel lblNewLabel_3 = new JLabel("MASV");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(20, 415, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm Tb");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(732, 415, 71, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Điểm thành phần");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(388, 477, 111, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("xếp loại");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(388, 535, 71, 14);
		add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setEnabled(false);
		textField.setBounds(509, 407, 198, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(509, 468, 198, 32);
		add(textField_1);
		textField_1.setColumns(10);
		
		 cbxhanhkiem = new JComboBox();
		cbxhanhkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxhanhkiem.setBounds(513, 525, 198, 32);
		cbxhanhkiem.addItem("");
		cbxhanhkiem.addItem("Tốt");
		cbxhanhkiem.addItem("khá");
		cbxhanhkiem.addItem("giỏi");
		cbxhanhkiem.addItem("yếu");
		add(cbxhanhkiem);

		 lbelMasv = new JLabel("");
		 lbelMasv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbelMasv.setBounds(122, 403, 160, 26);
		add(lbelMasv);
		
		JLabel lblNewLabel_7 = new JLabel("Họ ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(20, 465, 46, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tên");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(20, 525, 46, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_4_1 = new JLabel("Kỳ  học ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(388, 415, 71, 14);
		add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Ghi chú ");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(732, 525, 71, 14);
		add(lblNewLabel_4_2);
		
		txtA = new JTextField();
		txtA.setForeground(new Color(255, 0, 0));
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtA.setEnabled(false);
		txtA.setColumns(10);
		txtA.setBounds(817, 403, 105, 30);
		add(txtA);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 255, 128));
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(813, 500, 165, 64);
		add(textField_5);
		JSeparator separator = new JSeparator();
		separator.setBounds(122, 427, 160, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(122, 477, 160, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(122, 534, 160, 2);
		add(separator_2);
		
		 mnlabe3 = new JLabel("");
		mnlabe3.setFont(new Font("Tahoma", Font.BOLD, 15));
		mnlabe3.setBounds(122, 506, 160, 26);
		add(mnlabe3);
		
		 mnlabe2 = new JLabel("");
		mnlabe2.setFont(new Font("Tahoma", Font.BOLD, 15));
		mnlabe2.setBounds(122, 446, 160, 26);
		add(mnlabe2);
	}
public void addvaoTable(Danhgiarenluyen dgrl) {
		DefaultTableModel mode=(DefaultTableModel)table.getModel();
      	 mode.addRow(new Object[] {
      		 mode.getRowCount()+1,// so thứ tự
      		dgrl.getMaSinhvien()+"",
  		      dgrl.getHo()+"".toUpperCase(),
  	          dgrl.getTen()+"".toUpperCase(),
  	          dgrl.getKiHoc()+"",
  	          dgrl.getDiemSV()+"",
  	           dgrl.getDiemCVHT()+"",
  	           dgrl.getXepLoairenluyen()+"",
  	            dgrl.getGhichu()+""
  	          });
	    }

	public void getjTable1MouseClicked() {
	    // lấy ra gtri tư bảng trong hang so bao nhieu
		try {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			     if(table.getSelectedRow()<0) {
			    	 return;
			     }
			    int i_Row=table.getSelectedRow();
			    System.out.println(i_Row);
			    model.getValueAt(i_Row,8 );		    
				this.lbelMasv .setText(""+ model.getValueAt(i_Row,1)+"");
				this.mnlabe2.setText(model.getValueAt(i_Row,2 )+"");
			    this.mnlabe3.setText( model.getValueAt(i_Row,3 )+"");
			    this.cbxhanhkiem.setSelectedItem(model.getValueAt(i_Row,7)+"");
			    this.textField.setText(model.getValueAt(i_Row,4 )+"");
				this.textField_1.setText(model.getValueAt(i_Row,6)+"");
			    this.txtA.setText(model.getValueAt(i_Row,5)+"");
			    this.textField_5.setText(model.getValueAt(i_Row,8)+"");
		} catch (NullPointerException e) {
			System.out.println(e);
		    // xử lý ngoại lệ ở đây
		    // bạn có thể chọn hiển thị một thông báo cho người dùng hoặc thực hiện một hành động khác
		}				
}
	public void setnull() {
		this.lbelMasv .setText("");
		this.mnlabe2.setText("");
	    this.mnlabe3.setText("");
	    this.cbxhanhkiem.setSelectedItem("");
	    this.textField.setText("");
		this.textField_1.setText("");
	    this.txtA.setText("");
	    this.textField_5.setText("");
	}
//	public void LayDuLieuDatebase() {
//		for(Danhgiarenluyen dgrl:ConnectDanhgiaRL.danhgia().selectAll()){
//		     addvaoTable(dgrl);
//		     cbxhocky.setSelectedItem("");
//		     cbxlop.setSelectedItem("");
//	       }
//	}
	public void SetDuLieu() {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		while(true) {
			/* xóa toàn bộ dữ liệu trong tabel cho đến khi hết thì thôi*/
			
			int soluongDong=model.getRowCount();
			if(soluongDong==0) {
				break;
			}else {
				try {
				model.removeRow(0);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		for(Danhgiarenluyen dgrl:ConnectDanhgiaRL.danhgia().selectAllconDition(cbky, lop)){
		     addvaoTable(dgrl);
		     //gán gtri để sau dùng tiếp cho select
		     cbxhocky.setSelectedItem("");
		     cbxlop.setSelectedItem("");
	       }
	}
	public void capnhat() {
		ConnectDanhgiaRL.danhgia().upDatedanhgiaRenluyen(Float.parseFloat(textField_1.getText()), cbxhanhkiem.getSelectedItem()+"",textField.getText(),lbelMasv.getText());
		DefaultTableModel model=(DefaultTableModel)table.getModel();
			while(true) {
				/* xóa toàn bộ dữ liệu trong tabel cho đến khi hết thì thôi*/
				
				int soluongDong=model.getRowCount();
				if(soluongDong==0) {
					break;
				}else {
					try {
					model.removeRow(0);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
			SetDuLieu();
			setnull();
			
	}
	
}
