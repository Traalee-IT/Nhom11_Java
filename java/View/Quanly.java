package View;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.conectSinhvien;
import DAO.connectDiemdanh;
import Model.QLSV;
import Model.Thisinh;
import Model.Tinh;
import ModelInterface.InterfaceManagement;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;

import java.awt.Choice;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class Quanly extends JPanel implements InterfaceManagement {
	public  QLSV qlsvmodel;
    public  SinhVien sv;  
    public  DanhGiaRenLuyen dgrl;
	public  JLayeredPane layeredPane;
	public  DiemDanh diemdanh;
	private JTextField txtHThngSinh;
	public static JTextField textTentk = new JTextField();
	public Quanly(JLayeredPane layeredPaneht) {
		diemdanh=new DiemDanh();
		sv=new SinhVien();
		dgrl=new DanhGiaRenLuyen();
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 42, 1077, 618);
		SinhVien sinhVien = new SinhVien();
		sinhVien.table_1.setBackground(new Color(192, 192, 192));
		sinhVien.table_1.setBounds(10, 85, 1045, 200);
		sinhVien.panelsv.setForeground(Color.BLACK);
		sinhVien.panelsv.setBounds(10, 296, 1067, 300);
		sinhVien.setBackground(new Color(244, 164, 96));
		layeredPane.add(sinhVien);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuItem.setBounds(93, 11, 137, 26);
		sinhVien.add(menuItem);
	    add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		txtHThngSinh = new JTextField();
		txtHThngSinh.setForeground(new Color(0, 0, 0));
		txtHThngSinh.setBackground(new Color(192, 192, 192));
		txtHThngSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHThngSinh.setText("HỆ THỐNG SINH VIÊN");
		txtHThngSinh.setBounds(455, 0, 149, 31);
		add(txtHThngSinh);
		txtHThngSinh.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 1015, 2);
		add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 128));
		menuBar.setBounds(0, -2, 445, 32);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("FILE");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open ");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Quanly.class.getResource("/img/Ampeross-Ampola-Folder-downloads.24.png")));
	
		// thuc hienj ttao phim tat khi mơ file
		mntmNewMenuItem_1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(MenuKeyEvent.VK_O, MenuKeyEvent.CTRL_DOWN_MASK), "openFile");
		mntmNewMenuItem_1.getActionMap().put("openFile", new AbstractAction() {
		    public void actionPerformed(ActionEvent evt) {
		    	ThucHienOpenFilecSV();	 
		     }
		});
          mntmNewMenuItem_1.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				
					ThucHienOpenFilecSV();
			}
		});
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("New");
			mntmNewMenuItem_2.setIcon(new ImageIcon(Quanly.class.getResource("/img/Custom-Icon-Design-Pretty-Office-11-New.24.png")));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 DefaultTableModel model=(DefaultTableModel)SinhVien.table_1.getModel();
					 while(model.getRowCount()>0) {
						 model.removeRow(0);
					 }
				}
			});
		mnNewMenu.add(mntmNewMenuItem_2);
	    mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save.TXT");
		mntmNewMenuItem.setIcon(new ImageIcon(Quanly.class.getResource("/img/Custom-Icon-Design-Pretty-Office-7-Save.24.png")));
		
		// thưucj hiện nhấn bằng phím tắt 
		InputMap inputMap2 = mntmNewMenuItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap2.put(KeyStroke.getKeyStroke(MenuKeyEvent.VK_S, MenuKeyEvent.CTRL_DOWN_MASK), "Save.TXT"); 
		mntmNewMenuItem.getActionMap().put("Save.TXT", new AbstractAction() {
		    public void actionPerformed(ActionEvent evt) {
		    	thucHienSaveFile();
		    }
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//   System.out.println(""+Arsv);
		          // save();
				thucHienSaveFile();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
		JMenuItem xuatExel = new JMenuItem("XUẤT EXCEL");
		xuatExel.setIcon(new ImageIcon(Quanly.class.getResource("/img/Carlosjj-Microsoft-Office-2013-Excel.24 (1).png")));
	
		// thưucj hiện nhấn bằng phím tắt 
		InputMap MapxuatEcel = xuatExel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		MapxuatEcel.put(KeyStroke.getKeyStroke(MenuKeyEvent.VK_X, MenuKeyEvent.CTRL_DOWN_MASK), "XuấtExcel.TXT"); 
		xuatExel.getActionMap().put("XuấtExcel.TXT", new AbstractAction() {
		    public void actionPerformed(ActionEvent evt) {
		    	try {
					sv. xuatExcel();
					 File excelFile = new File("src\\main\\java\\View\\EXCEL.csv");
                    Desktop.getDesktop().open(excelFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});

		//----- thực hiện xuất file excel  nhấn bằng con chuột //
		xuatExel.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					 try {
		                    File excelFile = new File("src\\main\\java\\View\\EXCEL.csv");
		                    Desktop.getDesktop().open(excelFile);
		                    sv. xuatExcel();
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		              } 
				  }    
			});   
		mnNewMenu.add(xuatExel);
		
		JMenu mndiemdanh = new JMenu("OPTION");
		mndiemdanh.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		mndiemdanh.setForeground(Color.BLACK);
		mndiemdanh.setBackground(Color.WHITE);
		menuBar.add(mndiemdanh);
		
		JMenuItem mnqlsv = new JMenuItem("SinhVien");
		mnqlsv.setIcon(new ImageIcon(Quanly.class.getResource("/img/Microsoft-Fluentui-Emoji-3d-Student-3d-Default.24.png")));
		mnqlsv.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					layeredPane.removeAll(); 
	                layeredPane.add(sinhVien );// add cái panel   
					layeredPane.repaint();
					layeredPane.revalidate();
						
				}
			});
		mndiemdanh.add(mnqlsv);
		
		JMenuItem mndiemd = new JMenuItem("Diem Danh");
		mndiemd.setIcon(new ImageIcon(Quanly.class.getResource("/img/Benjigarner-Softdimension-Picture-Manager.24.png")));
		mndiemd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
                layeredPane.add(diemdanh);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
				 diemdanh.combl.setEditable(true);
//				    try {
//						for(String lop:conectSinhvien.getInforSV().getAllLop()) {
//							System.out.println(lop);
//							diemdanh.combl.addItem(lop);
//							sv.cbblop.addItem(lop);
//							dgrl.cbxhocky.addItem(lop);
//						}
//					} catch (SQLException ex) {
//						// TODO Auto-generated catch block
//						ex.printStackTrace();
//					}
			}
		});
		mndiemdanh.add(mndiemd);
		
		JMenu mnEdit = new JMenu("ĐÁNH GIÁ");
		mnEdit.setForeground(Color.BLACK);
		mnEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuBar.add(mnEdit);
		
		JMenuItem mndanhgia = new JMenuItem("Đánh giá rèn luyên'");
		mndanhgia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
                layeredPane.add(dgrl);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnEdit.add(mndanhgia);
		
		JMenu mnNewMenu_5 = new JMenu("ĐĂNG XUẤT");
		mnNewMenu_5.setForeground(Color.BLACK);
		mnNewMenu_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mndangxuat = new JMenuItem("ĐĂNG XUẤT");
		mndangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			layeredPaneht.removeAll(); 
			layeredPaneht.add(new Login(layeredPaneht));// add cái panel   
			layeredPaneht.repaint();
			layeredPaneht.revalidate();
			}
		});
		mnNewMenu_5.add(mndangxuat);
		
		JMenu mnNewMenu_6 = new JMenu("SETTING");
		mnNewMenu_6.setIcon(new ImageIcon(Quanly.class.getResource("/img/Froyoshark-Enkel-Settings.16.png")));
		mnNewMenu_6.setForeground(Color.BLACK);
		mnNewMenu_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_2 = new JMenu("ABOUT");
		mnNewMenu_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		mnNewMenu_2.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1, 2);
		add(separator);
		
		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Tahoma", Font.BOLD, 11));
		textTentk.setFont(new Font("Tahoma", Font.BOLD, 15));
		textTentk.setHorizontalAlignment(SwingConstants.CENTER);
		textTentk.setBounds(944, 0, 129, 31);
		add(textTentk);
		textTentk.setColumns(10);
		exit.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
				Exit();
			   }
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				  }
			   }
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				 }
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	 }

////==========================================================================================
	public void thucHienSaveFile() {
		JFileChooser fc=new JFileChooser();
		int rever=fc.showOpenDialog(this);
		if(rever==JFileChooser.APPROVE_OPTION) {
			File file=fc.getSelectedFile();
	            System.out.println(" dduowngf dan ten file la->  "+file.getAbsolutePath());
	            try {
	    			FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
	    			ObjectOutputStream oos = new ObjectOutputStream(fos);
	    			for (Thisinh ts : sv.DanhSachDoituong())
	    			   {
	    				System.out.println(ts.toString());
	    				oos.writeObject(ts);
	    			   }
	    			    oos.close();
	    		    } catch (Exception e) {
	    			    e.printStackTrace();
	    		   }
		         }
	          }
	@Override
public ArrayList<Thisinh> openFileExcel() throws IOException {
		ArrayList<Thisinh> openReadCSV=new ArrayList<Thisinh>();
		JFileChooser fc1=new JFileChooser();
		int rever=fc1.showOpenDialog(this);
		if(rever==JFileChooser.APPROVE_OPTION) {// TRAR VE ftri chon file 
			File file=fc1.getSelectedFile();
	             System.out.println(" dduowngf dan ten file la->    "+file.getAbsolutePath());
	             Scanner sc=new Scanner(file);
	             sc.nextLine();
	             while(sc.hasNext()) {
	             String[] obj=sc.nextLine().split(",");
	          	
	                 Thisinh ts=new Thisinh(obj[0],obj[1],obj[2],Tinh.getTinhByTen(obj[3]+""),Date.valueOf(obj[4]),Boolean.parseBoolean(obj[5]),obj[6],obj[7],Float.parseFloat(obj[8]),Float.parseFloat(obj[9]),Float.parseFloat(obj[10]),Float.parseFloat(obj[11]));
	                 openReadCSV.add(ts);
	             }
             }     
		    return openReadCSV;    
	}
	@Override
	public  void ThucHienOpenFilecSV() {
		
		while(true) {
			    DefaultTableModel model=(DefaultTableModel)sv.table_1.getModel();
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
		try {
			  ArrayList<Thisinh> list = this.openFileExcel();
			   for(Thisinh tsinh:list){
				  System.out.println(tsinh.toString());
			  this.sv.AddVaoTable(tsinh); 
		      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	}
//====================
@Override
public void Exit() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}else {
		return ;
	  }
    }
}