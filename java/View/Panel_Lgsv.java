package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import DAO.connSinhVienDn;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class Panel_Lgsv extends JPanel {
	private JTextField textDNSV;
	private JPasswordField passSv;
	JButton btsvDn ;
	 static String madn;
	JLayeredPane layeredPane;
	JLayeredPane layeredPaneht;
	public Panel_Lgsv(JLayeredPane layeredPane,JLayeredPane layeredPaneht) {
		setBackground(Color.ORANGE);
		setLayout(null);
		this.layeredPane=layeredPane;
		this.layeredPaneht=layeredPaneht;
		JLabel lbsv1 = new JLabel("Name");
		lbsv1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbsv1.setBounds(20, 149, 88, 33);
		add(lbsv1);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(20, 215, 98, 33);
		add(lblPass);
		
		JRadioButton rbnsv1 = new JRadioButton("Hiển Thị ");
		rbnsv1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbnsv1.isSelected()==true) {
					passSv.setEchoChar((char)0);
				}else{
					passSv.setEchoChar('*');
				}
			}
		});
		rbnsv1.setBounds(215, 283, 109, 23);
		add(rbnsv1);
		
		textDNSV = new JTextField();
		textDNSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDNSV.setText(" nhập tài khoản");
		textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
		textDNSV.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (textDNSV.getText().equals(" nhập tài khoản")) {
	        	  textDNSV. setText("");
	        	  textDNSV.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (textDNSV.getText().isEmpty()) {
	        	  textDNSV. setText(" nhập tài khoản");
	        	  textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
	          }
	        }
	      });
		
		textDNSV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==textDNSV)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	passSv.requestFocusInWindow(); 
				        	passSv.setText("");
				        	passSv.setEchoChar('*');
				        	passSv.setForeground(UIManager.getColor("textText"));
				        }
				    }
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		textDNSV.setBounds(149, 150, 185, 31);
		
		
		
		add(textDNSV);
		textDNSV.setColumns(10);
		
		passSv = new JPasswordField();
		passSv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passSv.setText("   Nhâp mật khẩu");
		
		passSv.setEchoChar((char)0);
		passSv.setForeground(UIManager.getColor("TextField.shadow"));
		passSv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==passSv)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        /*
				         * chức năng gọi nút enter để chuyên xuóng ô nhứo khác
				         * và thực hiện set lịa toàn bôh gtri cho o nhớ ở dangj ô nhớ khác
				         * 
				         */
		        	     btsvDn.doClick();  
		        	     textDNSV.addFocusListener(new FocusAdapter() {
		        		        public void focusGained(FocusEvent e) {
		        		          if (textDNSV.getText().equals(" nhập tài khoản")) {
		        		        	  textDNSV. setText("");
		        		        	  textDNSV.setForeground(UIManager.getColor("textText"));
		        		          }
		        		        }
		        		        public void focusLost(FocusEvent e) {
		        		          if (textDNSV.getText().isEmpty()) {
		        		        	  textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
		        		        	  textDNSV. setText(" nhập tài khoản");
		        		          }
		        		        }
		        		      });
		        	     passSv.setForeground(UIManager.getColor("TextField.shadow"));
		        	     passSv.setText("    Nhập pass");
		        	     passSv.setEchoChar((char)0);
				        	
				        }
				    }
			     }
		
		    });
	
		passSv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passSv.setText("");
				passSv.setEchoChar('*');
				passSv.setForeground(UIManager.getColor("textText"));
			}
		});
		passSv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passSv.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(passSv .getText().equals("")) {
					
					passSv.setEchoChar((char)0);
					passSv.setText("    Nhập pass");
				
					passSv.setForeground(UIManager.getColor("TextField.shadow"));
				}
			}
		});
	
		passSv.setBounds(147, 218, 187, 28);
		add(passSv);
		
		 btsvDn = new JButton("Đăng nhập");
		btsvDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap();
			}
		});
		btsvDn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btsvDn.setBounds(20, 333, 123, 39);
		add(btsvDn);
		
		JButton btnDoiMK = new JButton("Đôi Mật khẩu");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
                layeredPane.add(new SiginSv(layeredPane,layeredPaneht) );// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnDoiMK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDoiMK.setBounds(286, 334, 137, 37);
		add(btnDoiMK);
	
	}
	public void DangNhap() {//mở cái này ra thì ko cần đúng tài khoản vẫn vào đc hệ thống
		
		if(textDNSV.getText().equals("")){
			   /*
			    * thục hiện kiểm tra nếu mà rông thì lâpkj tức xóa bỏ gtrij cảu 2 ô đnagw nhập 
			    * và trả về trangj thái chuâw nhập j 
			    */
					passSv.setForeground(UIManager.getColor("TextField.shadow"));
					passSv.setText("    Nhập pass");
					passSv.setEchoChar((char)0);
					textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
					textDNSV.setText("  Nhập tài khoản ");
				}
		
		 if(textDNSV.getText().equals("")||passSv.getText().equals("")){
			 try {
				 /*
				  * nếu xãy ra đồng thời 2 ô đnagw nhập cùng rỗng thì thông báo lỗi
				  * và thực hiện trả lại trạng thái ban đầu cho hàm nhâpj
				  */
				
				textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
                textDNSV.setText("  Nhập tài khoản ");
				passSv.setEchoChar((char)0);
                passSv.setForeground(UIManager.getColor("TextField.shadow"));
				passSv.setText("    Nhập pass");
				
			 }catch(Exception ex) {
				 ex.printStackTrace();
			 }
		 }
		if(connSinhVienDn.DangNhap().DN(passSv.getText(),textDNSV.getText() )==true) {
			madn=textDNSV.getText();
			
            passSv.setForeground(UIManager.getColor("TextField.shadow"));
			passSv.setText("    Nhập pass");
			passSv.setEchoChar((char)0);
			textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
			textDNSV.setText("  Nhập tài khoản ");
          
   			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.layeredPaneht.removeAll(); 
			layeredPaneht.add(new inforsinhvien(layeredPaneht));// add cái panel   
			layeredPaneht.repaint();
			layeredPaneht.revalidate();
		}
		else {
			int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập lại mật khẩu ");
			if(luachon==JOptionPane.YES_OPTION) {
				passSv.setForeground(UIManager.getColor("TextField.shadow"));
				passSv.setText("    Nhập pass");
				passSv.setEchoChar((char)0);
				textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
				textDNSV.setText("  Nhập tài khoản ");
          return ;
	      }
		}
		passSv.setForeground(UIManager.getColor("TextField.shadow"));
		passSv.setText("    Nhập pass");
		passSv.setEchoChar((char)0);
		textDNSV.setForeground(UIManager.getColor("TextField.shadow"));
		textDNSV.setText("  Nhập tài khoản ");	
	}
	
}
