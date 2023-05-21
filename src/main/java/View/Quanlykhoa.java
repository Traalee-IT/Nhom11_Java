package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.connectKhoa;
import Model.Khoa;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Quanlykhoa extends JPanel {
	private JTextField txtMakhoa;
	private JTextField txtTenkhoa;
	private JTable table;
     
	/**
	 * Create the panel.
	 */
	public Quanlykhoa() {
		setBackground(new Color(128, 255, 128));
		
		JLabel lblNewLabel_1 = new JLabel("Mã khoa : ");
		lblNewLabel_1.setBounds(29, 92, 106, 31);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Tên khoa : ");
		lblNewLabel_2.setBounds(29, 161, 87, 20);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtMakhoa = new JTextField();
//		txtMakhoa.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				 int key=e.getKeyCode();
//				     if(e.getSource()==txtMakhoa  )
//				     {
//				        if(key==KeyEvent.VK_ENTER)
//				        { 
//				        	
//				        	txtTenkhoa.requestFocusInWindow(); 
//					           
//				        
//				        }
//				    }
//			   }
//		});
		txtMakhoa.setBounds(234, 94, 338, 31);
		txtMakhoa.setColumns(10);
		
		txtTenkhoa = new JTextField();
		txtTenkhoa.setBounds(234, 169, 338, 31);
		txtTenkhoa.setColumns(10);
		
		JButton btnNewButton = new JButton("Thêm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Themthongtin () ;
			}
		});
		btnNewButton.setBackground(new Color(184, 134, 11));
		btnNewButton.setIcon(new ImageIcon("src\\main\\java\\img\\Hopstarter-Button-Button-Add.16.png"));
		btnNewButton.setBounds(711, 85, 148, 45);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("Sửa ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capnhatdulieu();
			}
		});
		btnNewButton_1.setBackground(new Color(184, 134, 11));
		btnNewButton_1.setIcon(new ImageIcon("src\\main\\java\\img\\Sbstnblnd-Plateau-Apps-text-editor.24.png"));
		btnNewButton_1.setBounds(715, 205, 144, 45);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("Tìm kiếm ");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchKhoa();
			}
		});
		btnNewButton_2.setBackground(new Color(184, 134, 11));
		btnNewButton_2.setIcon(new ImageIcon("src\\main\\java\\img\\Graphicloads-Colorful-Long-Shadow-Zoom.16.png"));
		btnNewButton_2.setBounds(711, 141, 144, 45);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewButton_3 = new JButton("Xóa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnNewButton_3.setBackground(new Color(184, 134, 11));
		btnNewButton_3.setIcon(new ImageIcon("src\\main\\java\\img\\Hopstarter-Button-Button-Close.16.png"));
		btnNewButton_3.setBounds(721, 271, 144, 44);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
		setLayout(null);
		add(lblNewLabel_1);
		add(txtMakhoa);
		add(btnNewButton);
		add(btnNewButton_2);
		add(lblNewLabel_2);
		add(txtTenkhoa);
		add(btnNewButton_1);
		add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 326, 910, 275);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT","M\u00E3 khoa ", "T\u00EAn khoa "
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updatett();
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(162);
		table.getColumnModel().getColumn(1).setPreferredWidth(187);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JButton btLaydulieu = new JButton("Lấy dữ liệu");
		btLaydulieu.setIcon(new ImageIcon("src\\main\\java\\img\\Ampeross-Ampola-Folder-downloads.24.png"));
		btLaydulieu.setBackground(new Color(218, 165, 32));
		btLaydulieu.setFont(new Font("Arial", Font.BOLD, 17));
		btLaydulieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Laydulieu();
			}
		});
		btLaydulieu.setBounds(419, 237, 153, 45);
		add(btLaydulieu);
		
		JButton btnclear = new JButton("Clear");
		btnclear.setIcon(new ImageIcon("G:\\nn11sqlserver\\src\\main\\java\\img\\Seanau-Email-Clear.24.png"));
		btnclear.setFont(new Font("Arial", Font.BOLD, 17));
		btnclear.setBackground(new Color(255, 165, 0));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDataTable();

			}
		});
		btnclear.setBounds(252, 241, 130, 41);
		add(btnclear);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHOA");
		lblNewLabel.setBounds(380, 11, 157, 25);
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
            
	}
	public void setNull() {
		txtMakhoa.setText("");;
		txtTenkhoa.setText("");
		 this.txtMakhoa.setEnabled(true);
	}
	public void insert(Khoa ql) {
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		de.addRow(new Object[] 
				{
						de.getRowCount()+ 1,
						ql.getMaKhoa()+"",
						ql.getTenKhoa()+""
						
						
				} );
						
	
	}
	public void Themthongtin () {
		String maKhoa = txtMakhoa.getText();
		String tenKhoa = txtTenkhoa.getText();
		
		if(connectKhoa.getInstanse().kiemtra(maKhoa)==false) {
			Khoa kh = new Khoa(maKhoa,tenKhoa);
			insert(kh);
			Quanlylophoc.cbMakhoa.addItem(maKhoa); 		 
			connectKhoa.getInstanse(). insertKhoa(maKhoa, tenKhoa);
			setNull();
		}
		else if(connectKhoa.getInstanse().kiemtra(maKhoa)==true) {
			int luachon=JOptionPane.showConfirmDialog(this,"mã khoa đã trùng ! ");
		    if(luachon==JOptionPane.YES_OPTION) {
		    	setNull();
	          return ;
		    }
		}
	}
	public void Laydulieu() {
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		while(de.getRowCount()!=0) {
			de.removeRow(0);
		}
		for(Khoa kh : connectKhoa.getInstanse().selectAll()) {
			insert(kh);
		}
	}
	public void updatett() {//cập nhật lại ô text 
		DefaultTableModel de = (DefaultTableModel) table.getModel();
		if (table.getSelectedRow()<0)
		{ return ;}
		else
		{ int i = table.getSelectedRow();
		  String maKhoa = de.getValueAt(i,1)+ "";
		  String tenKhoa = de.getValueAt(i,2)+"";
		   this.txtMakhoa.setText(maKhoa);
		  this.txtTenkhoa.setText(tenKhoa);
		   this.txtMakhoa.setEnabled(false);
		   
		}
	}
	public void capnhatdulieu() {//cập nhật cho database
		
		String maKhoa = txtMakhoa.getText();
		String tenKhoa = txtTenkhoa.getText();
		connectKhoa.getInstanse().updateKhoa(maKhoa, tenKhoa);
		Laydulieu();
		setNull();
	}
	public void delete()
	{
		connectKhoa.getInstanse().deleteKhoa(txtMakhoa.getText());
		Quanlylophoc.setDataCombox();
		Laydulieu();
		setNull();
	}
	
	public void clearDataTable()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
	//Tìm kiếm khoa theo mã
	public void searchKhoa()
	{
		//Trước khi set dữ liệu tìm kiếm lên UI, xóa dữ liệu cũ
		clearDataTable();
		Khoa khoa = connectKhoa.getInstanse().searchKhoa(txtMakhoa.getText());
		insert(khoa);
		
	}
}