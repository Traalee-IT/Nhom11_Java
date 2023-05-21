package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DAO.conectSinhvien;
import DAO.connectDiemdanh;
import Model.DsDiemDanh;
import Model.Thisinh;
import Model.Tinh;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class DiemDanh extends JPanel {
	public static  JTable table_2;
	/**
	 * Create the panel.
	 */
	public JComboBox combl ;
	private JComboBox comBuoi;
	public JSpinner spinner;
	public JComboBox cbbhocky;
	public DiemDanh() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		JCheckBox checkcp = new JCheckBox("");
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(10, 90, 1034, 402);
		add(scrollPane_1);
		table_2 = new JTable();
		table_2.setEnabled(true);
		table_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		
		table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setFillsViewportHeight(true);
		table_2.setBackground(new Color(186, 226, 199));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		   table_2.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"STT", "MASV", "H\u1ECC ", "T\u00CAN", "Ngaysinh", "Giới tính","Lop", "VANG CP", "VANG KP", "SO TIEY", "Phần trăm(%)"
			}) {
				private static final long serialVersionUID = 1L;

			@Override
		      public Class<?> getColumnClass(int columnIndex) {
			     if (columnIndex == 7||columnIndex == 8) 
			          return Boolean.class;
			        
			        return super.getColumnClass(columnIndex);
			    }
			 @Override
		      public boolean isCellEditable(int row, int column) {
		        return column == 7 || column == 8; // chỉ cho phép chỉnh sửa cột thứ hai và thứ ba
		      }
		    }
	     );
		  
		table_2.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(98);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(113);
 		table_2.setShowGrid(false);
		scrollPane_1.setViewportView(table_2);
     	combl = new JComboBox();
     	combl.addItem("");
		combl.setEditable(true);
		    try {
				for(String lop : conectSinhvien.getInforSV().getAllLop()) {
                      combl.addItem(lop);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		combl.setBounds(106, 25, 150, 27);
		add(combl);
		
		comBuoi = new JComboBox();
		comBuoi.addItem("");
		for(int i=1;i<51;i++) {
			comBuoi.addItem(i);
			}

		comBuoi.setEditable(true);
		comBuoi.setBounds(533, 25, 74, 27);
		add(comBuoi);
		
		JLabel lblNewLabel = new JLabel("Chọn lớp");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 29, 80, 14);
		add(lblNewLabel);
		
		JLabel lblBui = new JLabel("Buổi Học");
		lblBui.setForeground(Color.WHITE);
		lblBui.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBui.setBounds(443, 29, 80, 23);
		add(lblBui);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LuuThongTinDiemDanh();
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuu.setBounds(25, 540, 97, 27);
		add(btnLuu);
		
		JButton bthuy = new JButton("Hủy");
		bthuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bthuy.setBounds(561, 540, 97, 27);
		add(bthuy);
		
		 spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner.setBounds(366, 28, 46, 20);
		add(spinner);
		
		JButton btndiemdanh = new JButton("Điểm danh");
		btndiemdanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  DefaultTableModel model=(DefaultTableModel)table_2.getModel();
				  while(model.getRowCount()!=0) { 
						model.removeRow(0);
			   }
				try {
					SelectTietHoc();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btndiemdanh.setBackground(new Color(0, 255, 64));
		btndiemdanh.setBounds(945, 27, 89, 23);
		add(btndiemdanh);
		
		cbbhocky = new JComboBox();
		cbbhocky.addItem("");
		   cbbhocky.addItem("hk1:2022-2023");
		   cbbhocky.addItem("hk2:2022-2023");
		   cbbhocky.addItem("hk3:2022-2023");
		   cbbhocky.addItem("hk4:2022-2023");
		   cbbhocky.addItem("hk5:2022-2023");
		   cbbhocky.setBounds(747, 25, 150, 27);
		add(cbbhocky);
		
		JLabel lblHcK = new JLabel("HỌC KỲ");
		lblHcK.setForeground(Color.WHITE);
		lblHcK.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHcK.setBounds(652, 29, 80, 14);
		add(lblHcK);
		
		JLabel lblSTit = new JLabel("Số Tiết");
		lblSTit.setForeground(Color.WHITE);
		lblSTit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSTit.setBounds(292, 29, 80, 14);
		add(lblSTit);
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				DanhDauDiemDanh();
			}
		});	
	}
	public  DsDiemDanh getCapNhatThongTinSinhVien() {
		/*
		 * hàm này trả về gtri của đối tương thí sinh 
		 * khi ta thực hiện click vào 1 hàng nào đos trong table thì
		 * lập tức hàng đó sẻ trả về gtij qua phươg thúc get.
		 * ta tạo ra các biến phù hợp để nhận gtri của các hàng tương ứng 
		 */
	 DefaultTableModel model=(DefaultTableModel)table_2.getModel();
	      if(table_2.getSelectedRow()<0) {
    	      return null;
         }
	  	  int i_Row=table_2.getSelectedRow();
	  	  if(table_2.getAutoscrolls()==false) {
	  	   model.getValueAt(i_Row,10 );
	  	   String masv= ""+ model.getValueAt(i_Row,1 );
	  	   String ho= model.getValueAt(i_Row,2 )+"";	
	  	   String ten= model.getValueAt(i_Row,3 )+"";
	  	   Date ngaysinh;
	  	   if((model.getValueAt(i_Row,5 )+"").equals("null")) {
	  	    	 ngaysinh= Date.valueOf( "2000-1-1");
	  	   }else {// neeus no đã tòn tại thì ta thực hiện lấy ra như bình thường
	  	    	ngaysinh= Date.valueOf( model.getValueAt(i_Row,6)+"");
	  	      }
	  	    String TextGioiTinh=model.getValueAt(i_Row,7)+""; 
	  	    boolean chonGioiTinh=TextGioiTinh.equals("Nam");	
	  	    String lop=model.getValueAt(i_Row,5)+"";
	  	    boolean cop=model.getValueAt(i_Row, 6)+"" != null;
	  	   boolean kop=model.getValueAt(i_Row, 7)+"" != null;
	  	   int sotiet=Integer.parseInt(model.getValueAt(i_Row,8)+"");
	  	  float phantram=Float.valueOf(model.getValueAt(i_Row,9 )+"");
	  		
	  	   DsDiemDanh thisinh=new DsDiemDanh(masv,ho,ten,ngaysinh,chonGioiTinh,lop,cop,kop,phantram);
	  		return thisinh;
	  	  }   
	  	  return null;
	  	}
	public  void DanhDauDiemDanh() {
		try {
			DefaultTableModel model=(DefaultTableModel)table_2.getModel();
			 int i=table_2.getSelectedRow(); 
			 if(i<0) {
		    	 return;
		     }
			 int column = table_2.getSelectedColumn();// set cột cho nó 
			  if(column==7||column==8) {
			    boolean cophep=(boolean) model.getValueAt(i,7);
		        boolean kophep=(boolean) model.getValueAt(i,8);       
		        int sotiet=(int) spinner.getValue();
		        float phantram =Float.parseFloat(model.getValueAt(i,10)+"");
		    if(cophep==true&&kophep==true) {
		    	model.setValueAt(false, i,column);
		    	return;
	        }else if(cophep==false&&kophep==false) {
	        	int sotiettru=Integer.parseInt(model.getValueAt(i,9)+"");
	        	phantram= (float) (phantram-(sotiettru*0.2));
	        	model.setValueAt(phantram, i,10);
	       }else if(cophep==true&&kophep==false||cophep==false&&kophep==true) {
	    	   phantram= (float) (sotiet*0.2)+phantram;
	        	model.setValueAt(phantram, i,10);
	        }else {
	        	int sotiettru=Integer.parseInt(model.getValueAt(i,9)+"");
	        return ;
	        }
			  }			
		} catch (NullPointerException e) {
			System.out.println(e);
		    // xử lý ngoại lệ ở đây
		    // bạn có thể chọn hiển thị một thông báo cho người dùng hoặc thực hiện một hành động khác
		}
		
	}

	public void AddVaoTable(DsDiemDanh ds) {  
        
	 	  DefaultTableModel mode=(DefaultTableModel)table_2.getModel();
	   	        	 mode.addRow(new Object[] {
	   	        		 mode.getRowCount()+1,// so thứ tự
	   	        		 ds.getMasv()+"",
	   	    		      ds.getHo()+"",
	   	    	          ds.getTen()+"",
	   	    	          (ds.getNgaysinh())+"",
	   	    	          (ds.isGioitinh()? "Nam" : "Nữ")+"",
	   	    	          ds.getLop()+"",
	   	    	          (ds.isCophep()? true:false),
	   	    	          (ds.isKophep()? true:false),
	   	    	           spinner.getValue(),// là phần ô chọn gia stri từ 1 đến 50 
	   	    	          ds.getPhantram()+""
	   	    	           }); 
//	   	        	 table_2.getModel().addTableModelListener(new TableModelListener() {
//	   	              public void tableChanged(TableModelEvent e) {
//	   	                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 1) {
//	   	                  int row = e.getFirstRow();
//	   	                  boolean checked = (Boolean) mode.getValueAt(row, 7);
//	   	                  boolean checked2 = (Boolean) mode.getValueAt(row, 8);
//	   	                    if(checked==true||checked2==true) {
//	   	                    	float phantram=(float)spinner.getValue();
//	   	                    	         
//	   	                   String value = (String) mode.getValueAt(row, 9); // lấy giá trị của cột bên cạnh
//	   	                  mode.setValueAt(checked, row, 1); // cập nhật giá trị của cột tương ứng
//	   	                  System.out.println("Hàng " + (row + 1) + " đã được chọn: " + checked + ", giá trị cột bên cạnh: " + value);
//	   	                }
//	   	                    }
//	   	                 
//	   	              }
//	   	            });       
	         }
	 public void SelectTietHoc() throws SQLException {
		 String cbHocKy = (String) cbbhocky.getSelectedItem();
        String selectedItem = (String) combl.getEditor().getItem();
        if(selectedItem.equals("")) {
        	  int gtri=JOptionPane.showConfirmDialog(this,"Vui lòng  nhập chọn buổi học ");
	 		    if(gtri==JOptionPane.YES_OPTION) {
	 		    	return ;	
	 		    }   
        } if((comBuoi.getEditor().getItem()+"").equals("")) {
        	 int gtri=JOptionPane.showConfirmDialog(this,"Vui lòng  nhập chọn buổi học ");
	 		    if(gtri==JOptionPane.YES_OPTION) {
	 		    	return ;	
	 		    }   
        }
		int buoi=Integer.parseInt(comBuoi.getEditor().getItem()+"");
		   
		System.out.println(connectDiemdanh.getDiemdanh().SelectAllbuoi(buoi,cbHocKy));
		if(connectDiemdanh.getDiemdanh().SelectAllbuoi(buoi,cbHocKy)==true) {
			for(DsDiemDanh dsdd :connectDiemdanh.getDiemdanh().SelectAllDiemdanhSV(selectedItem,buoi,cbHocKy)) {
			     AddVaoTable(dsdd);

		   }
		}else if(connectDiemdanh.getDiemdanh().SelectAllbuoi(buoi,cbHocKy)==false) {
			 if(spinner.getValue().equals("")) {
	        	  int gtri=JOptionPane.showConfirmDialog(this,"Vui lòng chọn số tiết  ");
		 		    if(gtri==JOptionPane.YES_OPTION) {
		 		    	return ;	
		 		    }  
	        }
			for(DsDiemDanh dsdd :connectDiemdanh.getDiemdanh().SelectAllDiemdanhSV(selectedItem,cbHocKy)) {
				System.out.println("bsdjbs0"+dsdd);
				 DefaultTableModel mode=(DefaultTableModel)table_2.getModel();
   	        	 mode.addRow(new Object[] {
   	        		 mode.getRowCount()+1,// so thứ tự
   	        		 dsdd.getMasv()+"",
   	    		      dsdd.getHo()+"",
   	    	          dsdd.getTen()+"",
   	    	          (dsdd.getNgaysinh())+"",
   	    	          (dsdd.isGioitinh()? "Nam" : "Nữ")+"",
   	    	          dsdd.getLop()+"",
   	    	          false,
   	    	          false,
   	    	           spinner.getValue(),// là phần ô chọn gia stri từ 1 đến 50 
   	    	          dsdd.getPhantram()+""
   	    	           }); 
		      }
		}
	 }
	 // hàm này sẻ đọc toàn bộ lại dữ liệu của bảng và cập nhật lại 
		public ArrayList<DsDiemDanh>getValueTable() {
			 ArrayList<DsDiemDanh> list=new ArrayList<DsDiemDanh> ();
			 DefaultTableModel model=(DefaultTableModel)table_2.getModel();
			  int soluongDong=model.getRowCount();
			 if(soluongDong==0) {
			       list=null;
			       return list;
			 }else {
			   for(int i=0;i<model.getRowCount();i++) {
				   model.getValueAt(i,10);
				    String masv= ""+ model.getValueAt(i,1);;
			        String ho=model.getValueAt(i,2)+"";
			        String ten=model.getValueAt(i,3)+"";
			        Date ngaysinh=Date.valueOf( model.getValueAt(i,4)+"");
			        String TextGioiTinh=model.getValueAt(i,5)+"";
			        boolean gioitinh=TextGioiTinh.equals("Nam");;
			        String lop=model.getValueAt(i,6)+""; 
			        boolean cophep=(boolean) model.getValueAt(i,7);
			        boolean kophep=(boolean) model.getValueAt(i,8);       
			        int sotiet=(int)model.getValueAt(i,9);
			        float phantram =Float.parseFloat(model.getValueAt(i,10)+"");
			       DsDiemDanh ds=new DsDiemDanh( masv, ho,ten,ngaysinh,gioitinh,lop, cophep,kophep,phantram);
			       list.add(ds);
			   }
			 }
			
			return list;
			
         }
		public void LuuThongTinDiemDanh() {
			try {
			int sotiet= (int) spinner.getValue();  
			String selectedItem = (String) combl.getEditor().getItem();
			String cbHocKy = (String) cbbhocky.getSelectedItem();
	        if(selectedItem.equals("")||cbHocKy.equals("")) {
	        	  int gtri=JOptionPane.showConfirmDialog(this,"Vui lòng  nhập chọn buổi học ");
		 		    if(gtri==JOptionPane.YES_OPTION) {
		 		    	return ;	
		 		    }        
	        }
			int buoi=Integer.parseInt(comBuoi.getEditor().getItem()+"");
			if(connectDiemdanh.getDiemdanh().SelectAllbuoi(buoi,cbHocKy)==true) {
				for(DsDiemDanh dsdd :getValueTable()) {
					connectDiemdanh.getDiemdanh().UpadateDiemDanh(dsdd,buoi);
					connectDiemdanh.getDiemdanh().UpadatePhanTram(dsdd.getMasv(),dsdd.getPhantram());
			   }
			}else if(connectDiemdanh.getDiemdanh().SelectAllbuoi(buoi,cbHocKy)==false) {
				for(DsDiemDanh dsdd :getValueTable()) {
					connectDiemdanh.getDiemdanh().InsertDiemDanh(dsdd,buoi,sotiet);
					connectDiemdanh.getDiemdanh().UpadatePhanTram(dsdd.getMasv(),dsdd.getPhantram());
			       	}
			   }
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
