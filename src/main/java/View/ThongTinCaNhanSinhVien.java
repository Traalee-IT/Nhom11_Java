package View;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;

public class ThongTinCaNhanSinhVien extends JPanel {
    
	public static String duonglink;

	/**
	 * Create the panel.
	 */
	Thongtinsinhvien ttsv;
	Quanlykhoa qlk=new Quanlykhoa();

	Quanlylophoc qllh=new Quanlylophoc();
	ketQuaHocTap kqht=new ketQuaHocTap();
	JLayeredPane layeredPane;
	public ThongTinCaNhanSinhVien(JLayeredPane layeredPaneht) {
		setLayout(null);
	  
		ttsv=new Thongtinsinhvien();
		ttsv.setBackground(new Color(128, 255, 128));
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 332, 22);
		add(menuBar);
		
		JMenu mnchon = new JMenu("CHOSE IMG");
		mnchon.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnchon);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("open");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAnh();
			}
		});
		mnchon.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("QUẢN LÝ");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem qlthanhtoan = new JMenuItem("Thanh toán");
		qlthanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(new ThanhToan());// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu.add(qlthanhtoan);
		JMenuItem mnTT = new JMenuItem("Quản lý TTSV");
		mnTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(ttsv);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu.add(mnTT);
		JMenuItem mnkqht = new JMenuItem("KetQuaHocTap");
		mnkqht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(kqht);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu.add(mnkqht);
		
		JMenu mnNewMenu_1 = new JMenu("ĐĂNG XUẨT");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("sdbhs chbdsjd");
				layeredPane.removeAll(); 
				layeredPane.add(new ThanhToan());// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("ĐỎI TÀI KHOẢN");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(new capNhatTaiKhoanSV());// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem doitk = new JMenuItem("ĐỔI TÀI KHOẢN");
		doitk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(new capNhatTaiKhoanSV());// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_2.add(doitk);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mndangxuat = new JMenuItem("Đăng xuất");
		mndangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneht.removeAll(); 
				layeredPaneht.add(new Login(layeredPaneht));// add cái panel   
				layeredPaneht.repaint();
				layeredPaneht.revalidate();
			}
		});
		mnNewMenu_1.add(mndangxuat);
		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 33, 1070, 633);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		layeredPane.add(ttsv);
		

	}
	public  static ImageIcon ResizeImg(String Url) {
			ImageIcon Myimage=new ImageIcon(Url);
			Image img=Myimage.getImage();
			Image newimg=img.getScaledInstance(Thongtinsinhvien.labelanh.getWidth(),Thongtinsinhvien.labelanh.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon image=new ImageIcon(newimg);
			return image;
		}
	public void openAnh() {
		try{
				JFileChooser fc=new JFileChooser("D:\\laptrinhJava\\BaiHeThongsqlserver5\\src\\main\\java\\img");
			int rever=fc.showOpenDialog(this);
			if(rever==JFileChooser.APPROVE_OPTION) {
				File file=fc.getSelectedFile();
		           duonglink=file.getAbsolutePath();
		            try {
		            	ImageIcon img = new ImageIcon(duonglink);
		                 Thongtinsinhvien.labelanh.setIcon(ResizeImg(String.valueOf(file.getAbsolutePath())));
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
			}
		}catch(Exception ex){
			System.out.println("bạn chưa có ảnh");
		   }
		}
}
