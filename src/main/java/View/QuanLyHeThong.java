package View;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;

public class QuanLyHeThong extends JPanel {
	JLayeredPane layeredPane;
	Quanlykhoa qlk=new Quanlykhoa();
	Quanlylophoc qllh=new Quanlylophoc();
	//HeThong ht=new HeThong();
	/**
	 * Create the panel.
	 */
	public QuanLyHeThong(JLayeredPane layeredPaneht) {
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 190, 22);
		add(menuBar);
		
		JMenu chonql = new JMenu("Chọn quản lý");
		chonql.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(chonql);
		
		JMenuItem mnlophoc = new JMenuItem("Quản lý lớp hoc");
		mnlophoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(qllh);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		chonql.add(mnlophoc);
		
		JMenuItem mnkhoa = new JMenuItem("Quản lý khoa");
		mnkhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(qlk);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		chonql.add(mnkhoa);
		
		JMenu mnNewMenu = new JMenu("đăng xuất");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mndangxuat = new JMenuItem("ĐĂNG XUẤT");
		mndangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneht.removeAll(); 
				layeredPaneht.add(new Login(layeredPaneht));// add cái panel   
				layeredPaneht.repaint();
				layeredPaneht.revalidate();
			}
		});
		mndangxuat.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mndangxuat);
		
	    layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 33, 974, 675);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.removeAll(); 
		qlk.setBackground(new Color(128, 255, 128));
		layeredPane.add(qlk);// add cái panel   
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
