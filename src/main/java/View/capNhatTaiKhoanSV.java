package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import DAO.connTaiKhoan;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class capNhatTaiKhoanSV extends JPanel {
	private JTextField txtNhpVoTn;
	private JPasswordField pasDn;
	private JPasswordField pasDn2;
	JButton btnCapNhat;
	/**
	 * Create the panel.
	 */
	public capNhatTaiKhoanSV() {
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Sinh Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(173, 74, 102, 22);
		add(lblNewLabel);
		
		JLabel lblMtKhuC = new JLabel("Mật Khẩu Cũ");
		lblMtKhuC.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhuC.setBounds(173, 144, 102, 22);
		add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("Mật Khẩu Mới");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhuMi.setBounds(173, 226, 102, 22);
		add(lblMtKhuMi);
		
		txtNhpVoTn = new JTextField(" nhập tài khoản");
		txtNhpVoTn.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		txtNhpVoTn.setForeground(UIManager.getColor("TextField.shadow"));
		txtNhpVoTn.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (txtNhpVoTn.getText().equals(" nhập tài khoản")) {
	        	  txtNhpVoTn. setText("");
	        	  txtNhpVoTn.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (txtNhpVoTn.getText().isEmpty()) {
	        	  txtNhpVoTn. setText(" nhập tài khoản");
	        	  txtNhpVoTn.setForeground(UIManager.getColor("TextField.shadow"));
	          }
	        }
	      });
		
		txtNhpVoTn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==txtNhpVoTn)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	pasDn.requestFocusInWindow(); 
				        	 pasDn.setText("");
				        	 pasDn.setEchoChar('*');
							 pasDn.setForeground(UIManager.getColor("textText"));
				        }
				    }
			}
		
		});
		txtNhpVoTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNhpVoTn.setBounds(339, 71, 202, 32);
		add(txtNhpVoTn);
		txtNhpVoTn.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hiển Thị ");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					
							 pasDn.setEchoChar((char)0);
							 pasDn2.setEchoChar((char)0);
			            }
			       else{ 
			    	   if(pasDn.getText().equals("Nhập vào pass")&&pasDn2.getText().equals("Nhập vào pass")) {
							pasDn.setEchoChar((char)0);
							pasDn2.setEchoChar((char)0);
				        }else if(pasDn.getText().equals("Nhập vào pass")&& !pasDn2.getText().equals("Nhập vào pass")) {
				        	pasDn.setEchoChar((char)0);
				        	   pasDn2.setEchoChar('*');
				            }
				        else if(!pasDn.getText().equals("Nhập vào pass")&& pasDn2.getText().equals("Nhập vào pass")) {
				        	pasDn2.setEchoChar((char)0);
				        	   pasDn.setEchoChar('*');
				            }
						
						 else {
							 pasDn.setEchoChar('*');
							 pasDn2.setEchoChar('*');
						 }   
			       }
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBackground(new Color(128, 255, 128));
		rdbtnNewRadioButton.setBounds(395, 291, 109, 23);
		add(rdbtnNewRadioButton);
		
		 btnCapNhat = new JButton("Cập Nhật");
		 btnCapNhat.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		capnhat();
		 	}
		 });
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setBounds(193, 326, 137, 32);
		add(btnCapNhat);
		
		JButton bntsetNull = new JButton("Hủy");
		bntsetNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    txtNhpVoTn.setText("");
	 	            pasDn.setText("");
	 	            pasDn2.setText("");
			}
		});
		bntsetNull.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntsetNull.setBounds(512, 326, 137, 30);
		add(bntsetNull);
		
		pasDn = new JPasswordField("Nhập vào pass");
		pasDn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pasDn.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		pasDn.setEchoChar((char)0);
		pasDn.setForeground(UIManager.getColor("TextField.shadow"));
		pasDn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==pasDn)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        /*
				         * chức năng gọi nút enter để chuyên xuóng ô nhứo khác
				         * và thực hiện set lịa toàn bôh gtri cho o nhớ ở dangj ô nhớ khác
				         * 
				         */
				        	
				        	  txtNhpVoTn.addFocusListener(new FocusAdapter() {
		        		        public void focusGained(FocusEvent e) {
		        		          if (txtNhpVoTn.getText().equals(" nhập tài khoản")) {
		        		        	  txtNhpVoTn. setText("");
		        		        	  txtNhpVoTn.setForeground(UIManager.getColor("textText"));
		        		          }
		        		        }
		        		        public void focusLost(FocusEvent e) {
		        		          if (txtNhpVoTn.getText().isEmpty()) {
		        		        	  txtNhpVoTn.setForeground(UIManager.getColor("TextField.shadow"));
		        		        	  txtNhpVoTn. setText(" nhập tài khoản");
		        		          }
		        		        }
		        		      });
							pasDn.setForeground(UIManager.getColor("TextField.shadow"));
							pasDn.setText("Nhập mật khẩu");
							pasDn.setEchoChar((char)0);
				        	pasDn2.requestFocusInWindow(); 
				            pasDn2.setText("");
				        	pasDn2.setEchoChar('*');
							pasDn2.setForeground(UIManager.getColor("textText"));
				        }
				    }
			     }
		
		    });
		
		pasDn.setForeground(UIManager.getColor("TextField.shadow"));
		pasDn.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (pasDn.getText().equals("Nhập vào pass")) {
	        	  pasDn. setText("");
	        	  pasDn.setEchoChar('*');
	        	  pasDn.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (pasDn.getText().isEmpty()) {
	        	  pasDn.setEchoChar((char)0);
					pasDn.setText("Nhập vào pass");
					pasDn.setForeground(UIManager.getColor("TextField.shadow"));
			  }
	        }
	      });
		pasDn.setBounds(349, 147, 189, 32);
		add(pasDn);
		
		pasDn2 = new JPasswordField("Nhập vào pass");
		pasDn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pasDn2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		pasDn2.setEchoChar((char)0);
		pasDn2.setForeground(UIManager.getColor("TextField.shadow"));
		pasDn2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==pasDn2)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        /*
				         * chức năng gọi nút enter để chuyên xuóng ô nhứo khác
				         * và thực hiện set lịa toàn bôh gtri cho o nhớ ở dangj ô nhớ khác
				         * 
				         */
				        	pasDn.addFocusListener(new FocusAdapter() {
				    	        public void focusGained(FocusEvent e) {
				    	          if (pasDn.getText().equals("Nhập vào pass")) {
				    	        	  pasDn. setText("");
				    	        	  pasDn.setEchoChar('*');
				    	        	  pasDn.setForeground(UIManager.getColor("textText"));
				    	          }
				    	        }
				    	        public void focusLost(FocusEvent e) {
				    	          if (pasDn.getText().isEmpty()) {
				    	        	  pasDn.setEchoChar((char)0);
				    					pasDn.setText("Nhập vào pass");
				    					pasDn.setForeground(UIManager.getColor("TextField.shadow"));
				    			  }
				    	        }
				    	      });  
				        	btnCapNhat.doClick();
							pasDn2.setForeground(UIManager.getColor("TextField.shadow"));
							pasDn2.setText("Nhập mật khẩu");
							pasDn2.setEchoChar((char)0);
				        	
				        }
				    }
			     }
		
		    });
		pasDn2.setForeground(UIManager.getColor("TextField.shadow"));
		pasDn2.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (pasDn2.getText().equals("Nhập vào pass")) {
	        	  pasDn2. setText("");
	        	  pasDn2.setEchoChar('*');
	        	  pasDn2.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (pasDn2.getText().isEmpty()) {
	        	  pasDn2.setEchoChar((char)0);
					pasDn2.setText("Nhập vào pass");
					pasDn2.setForeground(UIManager.getColor("TextField.shadow"));
			  }
	        }
	      });
		pasDn2.setBounds(349, 147, 189, 32);
		add(pasDn2);
		
		
		pasDn2.setBounds(349, 223, 195, 32);
		add(pasDn2);

	}
	public void capnhat() {
		  String matkhauCu=connTaiKhoan.updateDoiTaiKhoan().matKhauCu(txtNhpVoTn.getText());
	      if(txtNhpVoTn.getText().equals("")||pasDn.getText().equals("")||pasDn2.getText().equals("")) {
	    	  int gtri1=JOptionPane.showConfirmDialog(this,"Nhập pass hoặc tai khoản ");
	 		     if(gtri1==JOptionPane.YES_OPTION) {
	 			   txtNhpVoTn.setText("");
	 	           pasDn.setText("");
	 	          pasDn2.setText("");
	 	           return ;	
	       }
	     }else if(!pasDn.getText().equals(matkhauCu)) {
	    	 int gtri1=JOptionPane.showConfirmDialog(this,"xác nhận ko hợp lệ ");
 		     if(gtri1==JOptionPane.YES_OPTION) {
 			   txtNhpVoTn.setText("");
 	           pasDn.setText("");
 	          pasDn2.setText("");
 	           return ;	
	       }
	     }else if(pasDn.getText().equals(matkhauCu)) {
	    	 int gtri1=JOptionPane.showConfirmDialog(this,"cập nhật thành công");
 		     if(gtri1==JOptionPane.YES_OPTION) {
 		    	connTaiKhoan.updateDoiTaiKhoan().doimatkhau(pasDn2.getText(), txtNhpVoTn.getText());
 			    txtNhpVoTn.setText("");
 	            pasDn.setText("");
 	            pasDn2.setText("");
 	           return ;	
	       }
	     }
	}
}
