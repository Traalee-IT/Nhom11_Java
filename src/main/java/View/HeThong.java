package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JCheckBox;

public class HeThong extends JFrame {
	
	public JLayeredPane layeredPaneht;
	private JLabel lblHll;
	Login login ;
	QuanLySinhVien ql;
	QuanLyHeThong qlht;
	ThongTinCaNhanSinhVien infsv;
        public HeThong() {
        	getContentPane().setBackground(new Color(128, 255, 128));
            ql=new QuanLySinhVien(layeredPaneht);
            qlht=new QuanLyHeThong(layeredPaneht);
            infsv=new ThongTinCaNhanSinhVien(layeredPaneht);
        	setAlwaysOnTop(true);
        	this.setSize(1102,735);
        	getContentPane().setLayout(null);
        	layeredPaneht = new JLayeredPane();
        	layeredPaneht.setBounds(0, 33, 1084, 663);
        	layeredPaneht.setLayout(new CardLayout(0, 0));
            login = new Login( layeredPaneht);
        	login.layeredPane.setSize(550, 602);
        	login.layeredPane.setLocation(534, 0);
        	layeredPaneht.add(login);
        	getContentPane().add(layeredPaneht);
        	
        	 lblHll = new JLabel("");
        	 lblHll.setForeground(Color.RED);
        	 lblHll.setBackground(new Color(222, 197, 97));
        	 lblHll.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	lblHll.setBounds(10, 0, 214, 28);
        	getContentPane().add(lblHll);
        	
        	JCheckBox sizeOver = new JCheckBox(" setResizable");
        	sizeOver.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			if(sizeOver.isSelected()) {
        				setResizable(false);
        			}else {
        				setResizable(true);
        			}
        		}
        	});
        	sizeOver.setFont(new Font("Tahoma", Font.BOLD, 11));
        	sizeOver.setBounds(963, 5, 115, 23);
        	getContentPane().add(sizeOver);
        	ThoiGian();
        	this.setTitle("Nhóm 11".toUpperCase());
        	URL url2=HeThong.class.getResource("Car-Orange-icon.png");
    		Image img2=Toolkit.getDefaultToolkit().createImage(url2);
    		this.setIconImage(img2); 
    		
        	this.setVisible(true);
        
        }
        public  void ThoiGian() {
       	 SimpleDateFormat fomatDate=new SimpleDateFormat("dd/MM/yyyy");
       		Date date=new Date(); 
       		System.out.println(fomatDate.format(date));
       		System.out.println(java.time.LocalTime.now());
       		LocalTime sangB = LocalTime.of(0, 0);
       		LocalTime sangE = LocalTime.of(11, 0);
       		LocalTime truaB = LocalTime.of(11, 0);
       		LocalTime truaE = LocalTime.of(12, 0);
       		LocalTime chieuB = LocalTime.of(13, 0);
       		LocalTime chieuE = LocalTime.of(17, 0);
       		LocalTime toiB = LocalTime.of(17, 0);
       		LocalTime toiE = LocalTime.of(23, 59);
       		LocalTime now = java.time.LocalTime.now();
       		if(check(now, sangB, sangE) == true)
       		{
       			System.out.println("chao buoi sang ");
       			this.lblHll.setText("chào buổi sáng "+fomatDate.format(date));
       		}
       		else if(check(now, truaB, truaE) == true)
       		{
       		
       			this.lblHll.setText("chào buổi trưa "+fomatDate.format(date));
       		}
       		else if(check(now, chieuB, chieuE) == true)
       		{
       			this.lblHll.setText("chào buổi chiều"+fomatDate.format(date));
       		}
       		else if(check(now, toiB, toiE) == true)
       		{
       		
       			this.lblHll.setText("chào buổi tối"+fomatDate.format(date));
       		}
       	}
        public  boolean check(LocalTime a, LocalTime b, LocalTime c) {
       	 {
       			if(a.getHour() == b.getHour() && a.getMinute()>= b.getMinute())
       			{
       				return true;
       			}
       			if(a.getHour() == c.getHour() && a.getMinute()<= c.getMinute())
       			{
       				return true;
       			}
       			if(a.getHour() >= b.getHour() && a.getHour() <= c.getHour())
       			{
       				return true;
       			}
       			return false;
       			
       		}
       }
}
