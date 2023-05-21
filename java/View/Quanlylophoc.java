package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.khoaDAO;
import DAO.lophocDAO;
import Model.Khoa;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Quanlylophoc extends JPanel {
	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JTextField txtCo_van_hoc_tap;
	private JTable table;
	SinhVien sv;
	DiemDanh ds;
	DanhGiaRenLuyen dgrl;
	 static JComboBox cbMakhoa ;
	private JTextField txtTimkiem;
	public Quanlylophoc() {
		setBackground(new Color(255, 204, 102));
		setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Mã lớp : ");
		lblNewLabel_1.setBounds(20, 76, 81, 29);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_1);		
		txtMaLop = new JTextField();
		txtMaLop .addKeyListener(new KeyAdapter() {
		@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==txtMaLop )
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	
				        	txtTenLop.requestFocusInWindow(); 
					         
				        
				        }
				    }
			   }
		});
		txtMaLop.setBounds(159, 76, 213, 29);
		add(txtMaLop);
		txtMaLop.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên lớp : ");
		lblNewLabel_2.setBounds(20, 129, 98, 29);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_2);
		
		txtTenLop = new JTextField();
		txtTenLop .addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==txtTenLop )
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	
				        	txtCo_van_hoc_tap.requestFocusInWindow(); 
					          
				        }
				    }
			   }
		});
		txtTenLop.setBounds(159, 131, 213, 29);
		add(txtTenLop);
		txtTenLop.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cố vấn học tập : ");
		lblNewLabel_3.setBounds(20, 186, 129, 20);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_3);
		
		txtCo_van_hoc_tap = new JTextField();
		txtCo_van_hoc_tap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				     if(e.getSource()==txtCo_van_hoc_tap)
				     {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	cbMakhoa.requestFocusInWindow(); 
				        }
				    }
			   }
		});
		txtCo_van_hoc_tap.setBounds(159, 171, 213, 29);
		add(txtCo_van_hoc_tap);
		
		txtCo_van_hoc_tap.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mã khoa : ");
		lblNewLabel_4.setBounds(20, 217, 116, 29);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_4);
		
		JButton btThem = new JButton("Thêm ");
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Themthongtin();
				//viết sự kiện
				
			}
		});
		btThem.setBackground(new Color(184, 134, 11));
		btThem.setIcon(new ImageIcon("src\\main\\java\\img\\Hopstarter-Button-Button-Add.16.png"));
		btThem.setBounds(465, 87, 133, 36);
		btThem.setFont(new Font("Arial", Font.BOLD, 16));
		add(btThem);
		
		
		JButton btSua = new JButton("Sửa ");
		btSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capnhatdulieu();
			}
		});
		btSua.setBackground(new Color(184, 134, 11));
		btSua.setIcon(new ImageIcon("src\\main\\java\\img\\Sbstnblnd-Plateau-Apps-text-editor.24.png"));
		btSua.setBounds(465, 153, 133, 36);
		btSua.setFont(new Font("Arial", Font.BOLD, 16));
		add(btSua);
		
		JButton btXoa = new JButton("Xóa");
		btXoa.setBackground(new Color(184, 134, 11));
		btXoa.setIcon(new ImageIcon("src\\main\\java\\img\\Hopstarter-Button-Button-Close.16.png"));
		btXoa.setBounds(632, 91, 133, 36);
		btXoa.setFont(new Font("Arial", Font.BOLD, 16));
		add(btXoa);
		
		JButton btTimkiem = new JButton("Tìm kiếm ");
		btTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timkiem();
			}
		});
		btTimkiem.setBackground(new Color(184, 134, 11));
		btTimkiem.setIcon(new ImageIcon("8  src\\main\\java\\img\\Graphicloads-Colorful-Long-Shadow-Zoom.16.png"));
		btTimkiem.setBounds(632, 153, 133, 36);
		btTimkiem.setFont(new Font("Arial", Font.BOLD, 16));
		add(btTimkiem);
		
		JScrollPane tblclass = new JScrollPane();
		tblclass.setBounds(20, 312, 863, 251);
		add(tblclass);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT","M\u00E3 l\u1EDBp ", "T\u00EAn l\u1EDBp ", "C\u1ED1 v\u1EA5n h\u1ECDc t\u1EADp ", "M\u00E3 khoa "
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(184);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(186);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		tblclass.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(20, 11, 795, 44);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ LỚP HỌC");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		panel.add(lblNewLabel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getjTable1MouseClicked();
			}
		});
		JButton btLaydulieu = new JButton("Lấy dữ liệu ");
		btLaydulieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Laydulieu();
			}
		});
		btLaydulieu.setFont(new Font("Arial", Font.BOLD, 17));
		btLaydulieu.setBounds(465, 210, 133, 29);
		add(btLaydulieu);
		
		JButton btClear = new JButton("Clear ");
		btClear.setFont(new Font("Arial", Font.BOLD, 17));
		btClear.setBounds(629, 210, 136, 29);
		add(btClear);
		
	    
		cbMakhoa = new JComboBox();
		cbMakhoa.addItem("");
		for (String maKhoa : lophocDAO.getInstanse().Select()) {
			int i=0;
			i++;
			cbMakhoa.addItem(maKhoa);
		}
		cbMakhoa.setBounds(159, 219, 213, 29);
		add(cbMakhoa);
		
		JLabel lblNewLabel_4_1 = new JLabel("TÌM KIẾM  ");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(33, 270, 116, 29);
		add(lblNewLabel_4_1);
		
		txtTimkiem = new JTextField();
		txtTimkiem.setColumns(10);
		txtTimkiem.setBounds(159, 272, 213, 29);
		add(txtTimkiem);

	}
		public void insert(Model.Quanlylophoc ql) {  
		
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		de.addRow(new Object[] 
				{      
						de.getRowCount()+1,
						ql.getMaLop()+"",
						ql.getTenLop()+"",
						ql.getCovanhoctap()+"",
						ql.getMaKhoa()+""
						
						
				} );
						
				
	}
public void insertLopVaoCombobox(String tenlop){
			 sv=new SinhVien();
			sv.cbblop.addItem(tenlop);
			dgrl=new DanhGiaRenLuyen();
			dgrl.cbxlop.addItem(tenlop);
			ds=new DiemDanh();
			ds.cbbhocky.addItem(tenlop);
			
		}
	public void Themthongtin () {
		String maLop = txtMaLop.getText();
		String tenLop = txtTenLop.getText();
		String Covanhoctap = txtCo_van_hoc_tap.getText();
		String maKhoa = (String) cbMakhoa.getSelectedItem();
		
		if(lophocDAO.getInstanse().kiemtra(maLop)==false) {
		    Model.Quanlylophoc kh = new  Model.Quanlylophoc(maLop,tenLop,Covanhoctap,maKhoa);
			insert(kh);
			insertLopVaoCombobox(tenLop);
			lophocDAO.getInstanse(). insert(maLop,tenLop,Covanhoctap,maKhoa);
		     txtMaLop.setText("");
			 txtTenLop.setText("");
			 txtCo_van_hoc_tap.setText("");
			 ;
		}
		else
		{
			int luachon=JOptionPane.showConfirmDialog(this,"mã lớp đã trùng ! ");
		    if(luachon==JOptionPane.YES_OPTION) {
	          return ;
		    }
		}
	}
	public void Laydulieu() {
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		while(de.getRowCount()!=0) {
			de.removeRow(0);
		}
		for(Model.Quanlylophoc kh : lophocDAO.getInstanse().selectAll()) {
			insert(kh);
		}
	}
	public void updatett() {
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		if (table.getSelectedRow()<0)
		{ return ;}
		else
		{ int i = table.getSelectedRow();
		  String maLop = de.getValueAt(i,1)+ "";
		  String tenLop = de.getValueAt(i,2)+"";
		  String Covanhoctap = de.getValueAt(i,3)+"";
		  String maKhoa  = de.getValueAt(i,4)+"";
		  this.txtMaLop.setText(maLop);
		  this.txtTenLop.setText(tenLop);
		  this.txtCo_van_hoc_tap.setText(Covanhoctap);
		  this.cbMakhoa.setSelectedItem(maKhoa);
		   this.txtMaLop.setEnabled(true);
		   this.cbMakhoa.setEnabled(true);
		   
		}
	}
	public void capnhatdulieu() {//cập nhật cho database
		 this.txtMaLop.setEnabled(true);
		String maLop = txtMaLop.getText();
		String tenLop = txtTenLop.getText();
		String Covanhoctap = txtCo_van_hoc_tap.getText();
		String maKhoa = (String) cbMakhoa.getSelectedItem();
		lophocDAO.getInstanse().updateQuanlylophoc(maLop, tenLop, Covanhoctap, maKhoa);
		Laydulieu();
	}
	public void getjTable1MouseClicked() {
	    // lấy ra gtri tư bảng trong hang so bao nhieu
		this.txtMaLop.setEnabled(false);
		this.cbMakhoa.setEnabled(true);
		try {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			     if(table.getSelectedRow()<0) {
			    	 return;
			     }
			    int i_Row=table.getSelectedRow();
			    System.out.println(i_Row);
			    model.getValueAt(i_Row,4 );		
			    
			    String maLop = ""+ model.getValueAt(i_Row,1 );
			    String tenLop = model.getValueAt(i_Row,2 )+"";	
			    String Covanhoctap = model.getValueAt(i_Row,3 )+"";
		          String maKhoa = model.getValueAt(i_Row,4 )+"";
			   this.txtMaLop.setText(maLop);
			   this.txtTenLop.setText(tenLop);
			   this.txtCo_van_hoc_tap.setText(Covanhoctap);
			   this.cbMakhoa.setSelectedItem(maKhoa+"");
			
		} catch (NullPointerException e) {
			System.out.println(e);
		    // xử lý ngoại lệ ở đây
		    // bạn có thể chọn hiển thị một thông báo cho người dùng hoặc thực hiện một hành động khác
		}
	}
	public void timkiem() {
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		while(de.getRowCount()!=0) {
			de.removeRow(0);
		}
		for( Model.Quanlylophoc kh : lophocDAO.getInstanse().Timkiem(this.txtTimkiem.getText())) {
			insert(kh);
		}
		this.txtTimkiem.setText("");
	}
}