package View;

import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuKeyEvent;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.tools.Tool;

import org.apache.commons.lang3.RandomStringUtils;

import DAO.ConnectLoginTeacher;
import ModelInterface.InterfaceLogin;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.SystemColor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

public class Login extends JPanel implements InterfaceLogin {
	private JTextField textDk;
	private JPasswordField passDK;
	private JPasswordField pasDK2;
	private JTextField txtNhpEmail;
	private JTextField txtEmail;
	private JTextField txtngNhp;
	private JTextField txtMessage;
    public JLayeredPane layeredPane;
	private JPanel panel_2;
	int i;
	public JPanel panel_3;
	public JPanel panel_4;
	public SinhVien sv;
	public JRadioButton rHienThi;
	public JButton btnDangky;
	public JButton btnTimLAI;
	public JButton btnXacnhan ;
	public JButton btnthuchien;
	public JRadioButton rdbts4;
	public  JTextField txtNhpVoTn;
	private JTextField txtNhpVoId;
	private JTextField textFieldma;
	private JPasswordField passwordxn;
	private JPasswordField pasDn;
	private JPasswordField passwordxs2;
	public JLayeredPane layeredPaneht;
	public JLabel lnelSetTime;
	String ganGtri;
	public Login(JLayeredPane layeredPaneht) {
	layeredPane = new JLayeredPane();
		layeredPane.setBounds(532, 46, 518, 477);
		this.add(layeredPane);
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		panel_1 = new JPanel();
		 this.layeredPaneht= layeredPaneht;
	JButton btnltk = new JButton("Lấy lại tài khoản ");
		JPanel panel = new JPanel();
	
		panel.setBounds(10, 46, 493, 477);
		add(panel);
		panel.setLayout(null);
		Thread th=new Thread(()->{
		
			 while(true) {
			int i=new Random().nextInt(255);
			int r=new Random().nextInt(255);
			int s=new Random().nextInt(255);
			for(;i<255&&r<255&&s<255;i++,r++,s++) {	
				panel.setBackground(new Color(i,r,s));
				 panel_1.setBackground(new Color(r, s, i));
				 btnltk.setBackground(new Color(r, s, i));
			
				 if(i==255) {
					 panel.setBackground(new Color(128, 255, 128));
					 panel_1.setBackground(new Color(128, 255, 128));
					 btnltk.setBackground(new Color(128, 255, 128));
					 return ;
				 }
			}
				 try {
					Thread.sleep(4100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		});
		th.start();
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/View/42496-school-icon.png")));
		lblNewLabel.setBounds(148, 121, 134, 162);
		panel.add(lblNewLabel);
		txtngNhp = new JTextField();
		txtngNhp.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0, true));
		txtngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		txtngNhp.setBackground(new Color(128, 255, 128));
		txtngNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtngNhp.setEditable(false);
		txtngNhp.setText("ĐĂNG NHẬP");
		txtngNhp.setBounds(153, 32, 129, 32);
		panel.add(txtngNhp);
		txtngNhp.setColumns(10);
		
		JButton bt = new JButton("SINH VIÊN");
		bt.setBackground(new Color(128, 255, 128));
		// thucs hien taoj phims tắt chỉ thưcj hiẹne cho button inputMap.put("K"),"Mo Form sv");
				InputMap inputMap = bt.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
				inputMap.put(KeyStroke.getKeyStroke(MenuKeyEvent.VK_K, MenuKeyEvent.CTRL_DOWN_MASK),"Mo Form sv"); // truyền vaof phím tắt vaf tên biến của key
				bt.getActionMap().put("Mo Form sv", new AbstractAction() {
				    public void actionPerformed(ActionEvent evt) {
				    	txtngNhp.setText("Dang nhập");
						layeredPane.removeAll(); 
		                layeredPane.add(new Panel_Lgsv(layeredPane,layeredPaneht) );// add cái panel   
						layeredPane.repaint();
						layeredPane.revalidate();
				    }
				});
	
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText("Dang nhập");
				layeredPane.removeAll(); 
                layeredPane.add(new Panel_Lgsv(layeredPane,layeredPaneht) );// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		bt.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt.setBounds(10, 390, 114, 33);
		panel.add(bt);
		
		JButton btngv2 = new JButton("GIẢNG VIÊN ");
		btngv2.setBackground(new Color(128, 255, 128));
		btngv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText("Dang nhập");
				layeredPane.removeAll(); 
                layeredPane.add(panel_1 );// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btngv2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btngv2.setBounds(349, 390, 134, 32);
		panel.add(btngv2);
		
		JButton btnNewButton = new JButton("QUẢN LÝ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneht.removeAll(); // xóa đi cái giao diện ban đầu 
    			layeredPaneht.add(new quanlyht(layeredPaneht) );// add cái panellấy từ hệ thống  gọi ra giao diện mới
    			layeredPaneht.repaint();
				layeredPaneht.revalidate();
				
			}
		});
		btnNewButton.setBounds(186, 391, 114, 30);
		panel.add(btnNewButton);
		layeredPane.setLayout(new CardLayout(0, 0));
		
	
	   
		panel_1.setBackground(new Color(128, 255, 128));
		layeredPane.add(panel_1, "name_210611471824900");
		panel_1.setLayout(null);
		JButton btndangnhap = new JButton("Đăng nhập");
		btndangnhap.setForeground(new Color(0, 0, 0));
		btndangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});

		btndangnhap.setBackground(new Color(128, 255, 128));
		btndangnhap.setBounds(25, 309, 129, 31);
		panel_1.add(btndangnhap);
		
		JButton btndangky = new JButton("Đăng Ký");
		btndangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText("    Dang ky");
				// khi thực hiên nhấn vào button này thì nó lập tưcs sẻ bij đổi giao diện 
				layeredPane.removeAll(); 
                layeredPane.add(panel_2 );// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndangky.setBackground(new Color(128, 255, 128));
		btndangky.setBounds(232, 309, 129, 31);
		panel_1.add(btndangky);
		
		
		btnltk.setIcon(new ImageIcon("D:\\laptrinhJava\\BaiHeThongsqlserver4\\src\\main\\java\\img\\Fatcow-Farm-Fresh-Account-functions.24.png"));
		btnltk.setForeground(new Color(128, 0, 255));
		btnltk.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		//btnltk.setFocusPainted(false);
		btnltk.setBorderPainted(false);
		btnltk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText(" TÀI KHOẢN");
				layeredPane.removeAll(); 
                layeredPane.add(panel_3);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnltk.setBackground(new Color(128, 255, 128));
		btnltk.setBounds(123, 368, 187, 31);
		panel_1.add(btnltk);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(44, 91, 43, 22);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PassWord");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(38, 162, 67, 14);
		panel_1.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hiển Thị");
		rdbtnNewRadioButton.setBackground(new Color(128, 255, 128));
		rdbtnNewRadioButton.setBounds(199, 211, 67, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		
//========= sử lý thông tin nhâpj chuỗi khi click action PANNEL 1	======================================
		
		
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
//		txtNhpVoTn.setText("    Nhập vào tên");
		txtNhpVoTn.setBounds(135, 87, 198, 31);
		
		panel_1.add(txtNhpVoTn);
		txtNhpVoTn.setColumns(10);
		
                      //===============passs====================		

		pasDn = new JPasswordField("Nhập vào pass");
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
		        	     btndangnhap.doClick();  
		        	     txtNhpVoId.addFocusListener(new FocusAdapter() {
		        		        public void focusGained(FocusEvent e) {
		        		          if (txtNhpVoId.getText().equals(" nhập tài khoản")) {
		        		        	  txtNhpVoId. setText("");
		        		        	  txtNhpVoId.setForeground(UIManager.getColor("textText"));
		        		          }
		        		        }
		        		        public void focusLost(FocusEvent e) {
		        		          if (txtNhpVoId.getText().isEmpty()) {
		        		        	  txtNhpVoId.setForeground(UIManager.getColor("TextField.shadow"));
		        		        	  txtNhpVoId. setText(" nhập tài khoản");
		        		          }
		        		        }
		        		      });
							pasDn.setForeground(UIManager.getColor("TextField.shadow"));
							pasDn.setText("Nhập mật khẩu");
							pasDn.setEchoChar((char)0);
				        	
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
//		pasDn.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//		    pasDn.setText("");
//		    pasDn.setEchoChar('*');
//			 pasDn.setForeground(UIManager.getColor("textText"));
//			}
//		});
		pasDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pasDn.setBounds(135, 150, 198, 31);
		panel_1.add(pasDn);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbtnNewRadioButton.isSelected()) {
				//lệnh này dùng để khi nhấn vào 1 cái jbutton thì lập tức nó sẻ 
					 // thực hiệ 2 chức năng là hiển thị chuỗi nhập vào 
					 // ngược lại nó sẻ trả về kí tự nếu ta bỏ nhấn nút ấy
					 pasDn.setEchoChar((char)0);
			        }
			        else{
			            if(pasDn.getText().equals("Nhập vào pass")) {
			            	pasDn.setEchoChar((char)0);
			            }else {
			        	 pasDn.setEchoChar('*');
			            }
				 }
			}
		});
		
		
		
	//	====================== PANEL2 Thực hiện cho panel dăng ký tài khoản================================================================

                     
		
		panel_2 = new JPanel();
		//    thực hiện với tài khoản Id    
		txtNhpVoId = new JTextField();
		txtNhpVoId.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		txtNhpVoId.setBackground(new Color(255, 255, 255));
		txtNhpVoId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNhpVoId.setText("Nhập vào id");
		txtNhpVoId.setBounds(154, 22, 212, 37);
		txtNhpVoId.setForeground(UIManager.getColor("TextField.shadow"));
		txtNhpVoId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==txtNhpVoId)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	if(txtNhpVoId .getText().equals("")) {
								txtNhpVoId.setText("Nhập vào id");
								txtNhpVoId.setForeground(UIManager.getColor("TextField.shadow"));
							}
				        	txtNhpEmail.requestFocusInWindow(); 
				        	txtNhpEmail.setText("");
				        	txtNhpEmail.setForeground(UIManager.getColor("textText"));
				        	
				        }
				    }
			    }
		});
		
		
		txtNhpVoId.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (txtNhpVoId.getText().equals("Nhập vào id")) {
	        	  txtNhpVoId. setText("");
	        	  txtNhpVoId.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (txtNhpVoId.getText().isEmpty()) {
	        	  txtNhpVoId. setText("Nhập vào id");
	        	  txtNhpVoId.setForeground(UIManager.getColor("TextField.shadow"));
	          }
	        }
	      });
		
	    txtNhpVoId.setColumns(10);
		panel_2.add(txtNhpVoId);
		
	
		// ============== phần set cho email==============
		
		txtNhpEmail = new JTextField();
		txtNhpEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		txtNhpEmail .setForeground(UIManager.getColor("TextField.shadow"));
		txtNhpEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNhpEmail.setText("Nhâp vào Email");
		txtNhpEmail.setBounds(158, 83, 208, 35);
		
		txtNhpEmail.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (txtNhpEmail.getText().equals("Nhâp vào Email")) {
	        	  txtNhpEmail. setText("");
	        	  txtNhpEmail.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (txtNhpEmail.getText().isEmpty()) {
	        	  txtNhpEmail. setText("Nhâp vào Email");
	        	  txtNhpEmail.setForeground(UIManager.getColor("TextField.shadow"));
	          }
	        }
	      });
		
		txtNhpEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==txtNhpEmail)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	if(txtNhpEmail.getText().equals("")) {
				        		txtNhpEmail.setText("Nhâp vào Email");
				        		txtNhpEmail.setForeground(UIManager.getColor("TextField.shadow"));
							}
                          textDk.requestFocusInWindow(); 
                          textDk.setText("");
						  textDk.setForeground(UIManager.getColor("textText"));
					
				        }
				    }
			}
		});
		txtNhpEmail.setColumns(10);
		
		
		panel_2.add(txtNhpEmail);
		
		 panel_2.setBackground(new Color(128, 255, 128));
		 layeredPane.add(panel_2, "name_210611493212200");
		 panel_2.setLayout(null);
		
		
		//==============text tài khoan ============
		
		
		textDk = new JTextField();
		textDk.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		textDk.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if( textDk .getText().equals("")) {
					textDk.setText("   Nhâp tai khoan");
					textDk.setForeground(UIManager.getColor("TextField.shadow"));
				}
			}
		});

		textDk.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
	          if (textDk.getText().equals("Nhập vào tài khoản")) {
	        	  textDk. setText("");
	        	  textDk.setForeground(UIManager.getColor("textText"));
	          }
	        }
	        public void focusLost(FocusEvent e) {
	          if (textDk.getText().isEmpty()) {
	        	  textDk. setText("Nhập vào tài khoản");
	        	  textDk.setForeground(UIManager.getColor("TextField.shadow"));
	          }
	        }
	      });
		
		textDk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==textDk)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	if(txtNhpEmail.getText().equals("")) {
				        		txtNhpEmail.setText("Nhâp vào Email");
				        		txtNhpEmail.setForeground(UIManager.getColor("TextField.shadow"));
							}
				        	passDK.requestFocusInWindow(); 
				        	passDK.setText("");
				        	passDK.setEchoChar('*');
				        	passDK.setForeground(UIManager.getColor("textText"));
							
				        }
				    }
			}
		});
		textDk.setToolTipText("");
		textDk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDk.setText("Nhập vào tài khoản");
		textDk.setForeground(UIManager.getColor("TextField.shadow")); 
		textDk.setBounds(158, 144, 208, 35);
		
		textDk.setColumns(10);
		textDk.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e){
				 textDk.setText("");
				 textDk.setForeground(UIManager.getColor("textText"));
	            }
	        });
		
		panel_2.add(textDk);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbtnNewRadioButton.isSelected()) {
				
					 passDK.setEchoChar((char)0);
			        }
			        else{
			            
			        passDK.setEchoChar('*');
			        
				 }
			}
		});
		
		
		
	//==================== cập nhâtj laj pass đăng  ký ==========================	
		
		pasDK2 = new JPasswordField();
		pasDK2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		pasDK2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==pasDK2) {
				   
				        if(key==KeyEvent.VK_ENTER){
				        	btnDangky.doClick(); 
				        	System.out.println("nút này được thực hiện1");
				        	pasDK2.setForeground(UIManager.getColor("TextField.shadow"));
							pasDK2.setText("    Nhập lại pass");
							pasDK2.setEchoChar((char)0);
				        }
				    }
			}
		
		});
		
		
	
		
		pasDK2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pasDK2.setText("");
				pasDK2.setEchoChar('*');
				pasDK2.setForeground(UIManager.getColor("textText"));
			}
		});	
		pasDK2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pasDK2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(pasDK2 .getText().equals("")) {
					
					pasDK2.setEchoChar((char)0);
					pasDK2.setText("    Nhập lại pass");
					pasDK2.setForeground(UIManager.getColor("TextField.shadow"));
					
				}
			}
		});
		//=xaet chư mơ
		pasDK2.setText("    Nhập lại pass");
		pasDK2.setEchoChar((char)0);
		pasDK2.setForeground(UIManager.getColor("TextField.shadow"));
		pasDK2.setBounds(158, 253, 208, 37);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbtnNewRadioButton.isSelected()) {
				
					 pasDK2.setEchoChar((char)0);
			        }
			        else{
			            
			        	pasDK2.setEchoChar('*');
			        
				 }
			}
		});
		panel_2.add(pasDK2);
	
//===================================================================================		
		
		JRadioButton rdbtnHienThi = new JRadioButton("Hiển Thi");
		rdbtnHienThi.setBounds(166, 307, 63, 23);
		panel_2.add(rdbtnHienThi);
		rdbtnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbtnHienThi.isSelected()) {
				
					 pasDK2.setEchoChar((char)0);
			        }
			        else{
			            
			       pasDK2.setEchoChar('*');
			        
				 }
			}
		});
		rdbtnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbtnHienThi.isSelected()) {
				
					 passDK.setEchoChar((char)0);
			        }
			        else{
			            
			       passDK.setEchoChar('*');
			        
				 }
			}
		});
		JLabel tkoan = new JLabel("Tài Khoản");
		tkoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tkoan.setBounds(28, 132, 70, 24);
		panel_2.add(tkoan);
		
		JLabel lblpassdk = new JLabel("PassDK1");
		lblpassdk.setBounds(28, 195, 96, 25);
		panel_2.add(lblpassdk);
		
		JLabel passDk2 = new JLabel("PassDK2");
		passDk2.setBounds(28, 248, 96, 25);
		panel_2.add(passDk2);
		
		JLabel lbemail = new JLabel("Email");
		lbemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbemail.setBackground(Color.MAGENTA);
		lbemail.setBounds(28, 70, 63, 23);
		panel_2.add(lbemail);
		
	
		 btnDangky = new JButton("Đăng Ký");
		btnDangky.setBackground(SystemColor.desktop);
		btnDangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DangKygtr();
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDangky.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDangky.setBounds(29, 373, 125, 35);
		panel_2.add(btnDangky);
		
		JButton btnback = new JButton("Back");
		//btnback.setBackground(new Color(128, 255, 128));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText("Dang nhap");
				layeredPane.removeAll(); 
                layeredPane.add(panel_1);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnback.setBounds(248, 375, 131, 35);
		panel_2.add(btnback);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBackground(Color.MAGENTA);
		lblId.setBounds(28, 29, 63, 23);
		panel_2.add(lblId);
		
		
		//================= danwg nhâp passs ======================
		
		
		
		passDK = new JPasswordField();
		passDK.setBounds(154, 195, 212, 35);
		panel_2.add(passDK);
		passDK.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		passDK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==passDK)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	if(textDk.getText().equals("")) {
				        		textDk.setText("    Nhập vào Email");
                               textDk.setForeground(UIManager.getColor("TextField.shadow"));
							}
				        	pasDK2.requestFocusInWindow(); 
							pasDK2.setText("");
							pasDK2.setEchoChar('*');
							pasDK2.setForeground(UIManager.getColor("textText"));
				        }
				    }
			}
		
		});
		
		passDK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passDK.setText("");
				passDK.setEchoChar('*');
				passDK.setForeground(UIManager.getColor("textText"));
			}
		});
		
		passDK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passDK.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(passDK .getText().equals("")) {
					passDK.setEchoChar((char)0);
					passDK.setText("   Nhập pass");
					passDK.setForeground(UIManager.getColor("TextField.shadow"));
				}
			}
		});
		
             // chư mờ cho set
			
			passDK.setText("  nhập Pass");
			passDK.setEchoChar((char)0);
			passDK.setForeground(UIManager.getColor("TextField.shadow"));
		
	    panel_3 = new JPanel();
	    panel_3.setBackground(new Color(128, 255, 128));
		layeredPane.add(panel_3, "name_210611513237200");
		panel_3.setLayout(null);
		
		
		//=======================LPanel3===========================
		
		txtEmail = new JTextField();
		txtEmail.setText("Nhập Email");
		txtEmail.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
		          if (txtEmail.getText().equals("Nhập Email")) {
		        	  txtEmail. setText("");
		        	  txtEmail.setForeground(UIManager.getColor("textText"));
		          }
		        }
		        public void focusLost(FocusEvent e) {
		          if (txtEmail.getText().isEmpty()) {
		        	  txtEmail. setText("Nhập Email");
		        	  txtEmail.setForeground(UIManager.getColor("TextField.shadow"));
		          }
		        }
		      });
		// đây là cái mà ô text tại vị trí hiên tại
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==txtEmail)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        {  
				             
				        	btnTimLAI.doClick();
				        	txtEmail.setText("Nhập Email");
							txtEmail.setForeground(UIManager.getColor("TextField.shadow"));
				        }
				    }
			}
		});
		txtNhpVoTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	
		
		txtEmail.setBounds(135, 87, 180, 31);
		txtEmail.setForeground(UIManager.getColor("TextField.shadow"));
		
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(91, 75, 219, 30);
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 81, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		 btnTimLAI = new JButton("Lấy mã xác minh");
		 btnTimLAI.setFocusPainted(false);
		 btnTimLAI.setBorderPainted(false);
		 btnTimLAI.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		 btnTimLAI.setBackground(new Color(128, 255, 0));
		 btnTimLAI.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			System.out.println(" ham nay thực hiệ lại ");
					xacMinhEmail();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
		 		}
		 });
		 btnTimLAI.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 int key=e.getKeyCode();
					    if(e.getSource()==btnTimLAI)
					    {
					        if(key==KeyEvent.VK_ENTER)
					        {  
					        	btnXacnhan.doClick();
					        	
					        }
					        
					    }
				}
			});
		btnTimLAI.setBounds(104, 179, 159, 30);
		panel_3.add(btnTimLAI);
		
		txtMessage = new JTextField();
		txtMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtMessage.setForeground(Color.BLACK);
		txtMessage.setBackground(new Color(128, 255, 128));
		txtMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMessage.setBounds(130, 250, 130, 30);
		panel_3.add(txtMessage);
		txtMessage.setColumns(10);
		
		JButton btnBack2 = new JButton("<--Back");
		btnBack2.setBackground(new Color(128, 255, 128));
		
		btnBack2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText("Đăng Nhập");
				layeredPane.removeAll(); 
                layeredPane.add(panel_1 );// add cái panel   
				
			}
		});
		btnBack2.setBounds(286, 380, 118, 28);
		panel_3.add(btnBack2);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Xác nhận");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(26, 250, 89, 30);
		panel_3.add(lblNewLabel_5);
		
		 btnXacnhan = new JButton("Xác nhận->>");
		 btnXacnhan.setBackground(new Color(128, 255, 128));
		btnXacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		i=0;
		   lnelSetTime.setText("");
		   ganGtri =txtMessage.getText();
		  txtMessage.setText("");
		   /*cai i nay no lai bi dungf*/
		   
			txtngNhp.setText("Dang ky");
			layeredPane.removeAll(); 
            layeredPane.add(panel_4 );// add cái panel   
			layeredPane.repaint();
			layeredPane.revalidate();
			}
		});
		btnXacnhan.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 int key=e.getKeyCode();
					    if(e.getSource()==btnXacnhan)
					    {
					        if(key==KeyEvent.VK_ENTER)
					        {  
					        	txtngNhp.setText("Dang ky");
								layeredPane.removeAll(); 
					            layeredPane.add(panel_4 );// add cái panel   
								layeredPane.repaint();
								layeredPane.revalidate();
					        }
					        
					    }
				}
			});
		btnXacnhan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXacnhan.setBounds(26, 380, 130, 28);
		panel_3.add(btnXacnhan);
		
		 lnelSetTime = new JLabel("");
		lnelSetTime.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lnelSetTime.setBounds(273, 247, 58, 30);
		panel_3.add(lnelSetTime);
		
		
		 panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 255, 128));
		layeredPane.add(panel_4, "name_210611538229900");
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 255, 128));
		panel_5.setBounds(10, 11, 450, 428);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
//======================= panel 4        ================================
		 rdbts4 = new JRadioButton("Hiển thị");
		rdbts4.setBackground(Color.GREEN);
		rdbts4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbts4.setBounds(203, 234, 89, 23);
		panel_5.add(rdbts4);
		
		JButton back4 = new JButton("Back");
		back4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtngNhp.setText("Tài khoản");
				layeredPane.removeAll(); 
                layeredPane.add(panel_3);// add cái panel   
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		back4.setBackground(new Color(255, 255, 128));
		back4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		back4.setBounds(300, 333, 122, 32);
		panel_5.add(back4);
		
		JLabel lblNewLabel_6 = new JLabel("Mã xác nhận");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(27, 48, 89, 23);
		panel_5.add(lblNewLabel_6);
		
		 btnthuchien= new JButton("Tiêp tục với");
		 btnthuchien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnthuchien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
				System.out.println("bsdbsd");
				
			}
		});
		 btnthuchien.setBounds(27, 333, 122, 32);
		panel_5.add(btnthuchien);
		
		textFieldma = new JTextField();
		textFieldma.setText("Nhập mã xác nhận");
		textFieldma.setForeground(UIManager.getColor("TextField.shadow"));
		textFieldma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldma.setBounds(133, 45, 188, 32);
		panel_5.add(textFieldma);
		textFieldma.setColumns(10);
//		textFieldma.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				if( textFieldma .getText().equals("")) {
//					textFieldma.setText("   Nhâp mã xác thực");
//					textFieldma.setForeground(UIManager.getColor("TextField.shadow"));
//				}
//			}
//		});
		textFieldma.addFocusListener(new FocusAdapter() {
	        public void focusGained(FocusEvent e) {
		          if (textFieldma.getText().equals("Nhập mã xác nhận")) {
		        	  textFieldma. setText("");
		        	  textFieldma.setForeground(UIManager.getColor("textText"));
		          }
		        }
		        public void focusLost(FocusEvent e) {
		          if (textFieldma.getText().isEmpty()) {
		        	  textFieldma. setText("Nhập mã xác nhận");
		        	  textFieldma.setForeground(UIManager.getColor("TextField.shadow"));
		          }
		        }
		      });
		textFieldma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==textFieldma)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	
				        	if(textFieldma.getText().equals("")) {
				        		textFieldma.setText("    Nhập mã xác nhận");
				        		textFieldma.setForeground(UIManager.getColor("TextField.shadow"));
							}
				        	passwordxn.requestFocusInWindow(); 
				        	passwordxn.setText("");
				        	passwordxn.setEchoChar('*');
				        	passwordxn.setForeground(UIManager.getColor("textText"));
							
				        }
				    }
			}
		});
		
		//================= danwg nhâp passs ======================
		
		
		
		passwordxn = new JPasswordField();
		passwordxn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordxn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key=e.getKeyCode();
				    if(e.getSource()==passwordxn)
				    {
				        if(key==KeyEvent.VK_ENTER)
				        { 
				        	if(passwordxn.getText().equals("")) {
				        	passwordxn.setText("Nhập mã xác nhận");
				        	passwordxn.setForeground(UIManager.getColor("TextField.shadow"));
							}
				        	passwordxs2.requestFocusInWindow(); 
				        	passwordxs2.setText("");
				        	passwordxs2.setEchoChar('*');
				        	passwordxs2.setForeground(UIManager.getColor("textText"));
				        }
				    }
			}
		
		});
		
		passwordxn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordxn.setText("");
				passwordxn.setEchoChar('*');
				passwordxn.setForeground(UIManager.getColor("textText"));
			}
		});
		
		passwordxn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordxn.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(passwordxn .getText().equals("")) {
					passwordxn.setEchoChar((char)0);
					passwordxn.setText("Nhập vào pass");
					passwordxn.setForeground(UIManager.getColor("TextField.shadow"));
				}
			}
		});
	
		passwordxn.setText("Nhập vào pass");
		passwordxn.setEchoChar((char)0);
		passwordxn.setForeground(UIManager.getColor("TextField.shadow"));
		
		
		rdbts4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbts4.isSelected()) {
				
					 passwordxn.setEchoChar((char)0);
			        }
			        else{
			            
			        	passwordxn.setEchoChar('*');
			        
				 }
			}
		});
		rdbts4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdbts4.isSelected()) {
				
					  passwordxs2.setEchoChar((char)0);
			        }
			     else{
			            
			        passwordxs2.setEchoChar('*');
			        
				 }
			}
		});
		
		JLabel lbLabel_6 = new JLabel("Mật Khẩu Mới");
		lbLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLabel_6.setBounds(27, 105, 89, 23);
		panel_5.add(lbLabel_6);
		
		JLabel lblNewLabel_6_2 = new JLabel("Mật khẩu XN");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6_2.setBounds(27, 171, 89, 23);
		panel_5.add(lblNewLabel_6_2);
		
		
		passwordxn.setBounds(133, 105, 188, 32);
		panel_5.add(passwordxn);
		
			//==================== cập nhâtj laj pass đăng  ký ==========================
				
		///=======================================================================		
				passwordxs2 = new JPasswordField();
				passwordxs2.setBounds(133, 167, 188, 32);
				panel_5.add(passwordxs2);
				passwordxs2.setText("Nhập vào pass");
				passwordxs2.setEchoChar((char)0);
				passwordxs2.setForeground(UIManager.getColor("TextField.shadow"));
				
				passwordxs2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						 int key=e.getKeyCode();
						    if(e.getSource()==passwordxs2) {
						        if(key==KeyEvent.VK_ENTER){
						         	btnthuchien.doClick(); 
						        	passwordxs2.setForeground(UIManager.getColor("TextField.shadow"));
						        	passwordxs2.setText("Nhập vào pass");
						        	passwordxs2.setEchoChar((char)0);
						        }
						    }
					}
				
				});
				passwordxs2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						passwordxs2.setText("");
						passwordxs2.setEchoChar('*');
						passwordxs2.setForeground(UIManager.getColor("textText"));
					}
				});	
				// khi nhập vào chữ cái
				
				passwordxs2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				passwordxs2.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseMoved(MouseEvent e) {
						if(passwordxs2 .getText().equals("")) {
							
							passwordxs2.setEchoChar((char)0);
							passwordxs2.setText("Nhập vào pass");
							passwordxs2.setForeground(UIManager.getColor("TextField.shadow"));
							
						}
					}
				});
				
	
				passwordxs2.setText("Nhập vào pass");
				passwordxs2.setForeground(SystemColor.controlShadow);
				passwordxs2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				passwordxs2.setEchoChar('*');
				passwordxs2.setText("Nhập vào pass");
				passwordxs2.setEchoChar((char)0);
				passwordxs2.setForeground(UIManager.getColor("TextField.shadow"));
		
	
	}
	
// =================================  sư lý sự kiên                          ================================================================
public void Login() {
	String id=txtNhpVoTn.getText();
	if(txtNhpVoTn.getText().equals("")){
   /*
    * thục hiện kiểm tra nếu mà rông thì lâpkj tức xóa bỏ gtrij cảu 2 ô đnagw nhập 
    * và trả về trangj thái chuâw nhập j 
    */
		pasDn.setForeground(UIManager.getColor("TextField.shadow"));
		pasDn.setText("Nhập vào pass");
		pasDn.setEchoChar((char)0);
		txtNhpVoTn.setForeground(UIManager.getColor("TextField.shadow"));
		txtNhpVoTn.setText("  Nhập tài khoản ");
	}
	
	String pass=pasDn.getText();
	 if(txtNhpVoTn.getText().equals("")||pasDn.getText().equals("")){
		 try {
			 /*
			  * nếu xãy ra đồng thời 2 ô đnagw nhập cùng rỗng thì thông báo lỗi
			  * và thực hiện trả lại trạng thái ban đầu cho hàm nhâpj
			  */
			checkAlert();
			txtNhpVoTn.setForeground(UIManager.getColor("TextField.shadow"));
			txtNhpVoTn.setText("  Nhập tài khoản ");
			pasDn.setEchoChar((char)0);
			pasDn.setForeground(UIManager.getColor("TextField.shadow"));
			pasDn.setText("Nhập vào pass");
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}else {
	/*
	 * ngược lại nếu 2 ô nó đã có tri và và kiểm tra
	 */
      boolean gtrave = false;
	try {
		gtrave = ConnectLoginTeacher.getInfor().dangNhapJDBC(id, pass);
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
      try {
		System.out.println(ConnectLoginTeacher.getInfor().dangNhapJDBC(id, pass));
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
 if(gtrave==true) {
    	  try {
    	
    		    Quanly.textTentk.setText(txtNhpVoTn.getText());
    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    			layeredPaneht.removeAll(); // xóa đi cái giao diện ban đầu 
    			layeredPaneht.add(new Quanly(layeredPaneht));// add cái panellấy từ hệ thống  gọi ra giao diện mới
				layeredPaneht.repaint();// vẽ lại hình ảnh của panel
				layeredPaneht.revalidate();
    		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
    				| UnsupportedLookAndFeelException e1) {
    			
    			e1.printStackTrace();
    		}
      }
      else {
    	  try {
			checkAlert();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }
    }
	
}

	
	@Override
	public void SetkhiLoiDangKy() {
	txtNhpVoId.setText(" Nhập vào tên");
	txtNhpVoId.setForeground(UIManager.getColor("TextField.shadow"));
	pasDK2.setForeground(UIManager.getColor("TextField.shadow"));
	pasDK2.setText("Nhập vào pass");
	pasDK2.setEchoChar((char)0);
	textDk.setText("Nhập tài khoản");
	textDk.setForeground(UIManager.getColor("TextField.shadow"));
	passDK.setText("Nhập lại pass");
	passDK.setEchoChar((char)0);
	passDK.setForeground(UIManager.getColor("TextField.shadow"));
	txtNhpEmail.setText("Nhập vào Email");
	txtNhpEmail.setForeground(UIManager.getColor("TextField.shadow"));
}
	public void DangKygtr() throws HeadlessException, SQLException {
		String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
		     String email=this.txtNhpEmail.getText();
		     txtNhpEmail.requestFocusInWindow();
		     String taikhoan =this.textDk.getText();
		     String pass=this.passDK.getText();
		     String pasXacthuc=this.pasDK2.getText();
		     String ids=this.txtNhpVoId.getText();
		     if(!pass.equals(pasXacthuc)|| ConnectLoginTeacher.getInfor().LayTkEmail(email)==true) {
		    	 int gtr3=JOptionPane.showConfirmDialog(this,"xác thực ko chính sác hoặc email đã tồn tại");
		         if(gtr3==JOptionPane.YES_OPTION) {
		        	 SetkhiLoiDangKy();
		    	 return;
		         }
		     }
		     else if (!email.matches(EMAIL_PATTERN)) {
		    	 
		          int gtr2=JOptionPane.showConfirmDialog(this," Mail nhâp vào ko chính sác");
		          if(gtr2==JOptionPane.YES_OPTION) {
		        	  SetkhiLoiDangKy();
		    	 return;
		         }
		     }else if(email.equals("")&&taikhoan.endsWith("")&&pass.equals("")&&pasXacthuc.endsWith("")&&ids.equals("")){
		    	   int gtr3=JOptionPane.showConfirmDialog(this," vui lòng nhập thông tin");
		           if(gtr3==JOptionPane.YES_OPTION) {
		        	   SetkhiLoiDangKy();
		    	   return;
		          }
		     } else {
		       int gtri=JOptionPane.showConfirmDialog(this,"đăng kí thành công");
 		         if(gtri==JOptionPane.YES_OPTION); 
 		        SetkhiLoiDangKy();
 		         ConnectLoginTeacher.getInfor().capNhatTaiKhoan(taikhoan,pass, email, ids);

	   }
	}
	
	@Override
	public void checkAlert() throws SQLException {
		if(this.pasDn.getText().equals("")|| this.txtNhpVoTn.getText().equals("")) {
			  int gtri1=JOptionPane.showConfirmDialog(this,"Nhập pass hoặc tai khoản ");
		 		     if(gtri1==JOptionPane.YES_OPTION) {
		 			   txtNhpVoTn.setText("");
		 	           pasDn.setText("");
		 	           return ;	
		        }
		}else {
		 int gtri=JOptionPane.showConfirmDialog(this,"Tài khoản hoặc pass không đúng ");
 		if(gtri==JOptionPane.YES_OPTION) {
 			pasDn.setForeground(UIManager.getColor("TextField.shadow"));
			pasDn.setText("Nhập vào pass");
			pasDn.setEchoChar((char)0);
			txtNhpVoTn.setText(" nhập tài khoản");
			txtNhpVoTn.setForeground(UIManager.getColor("TextField.shadow"));
 	         return ;	
 		  }
		}
     }
	  public void SetNull() {
		this.pasDK2.setText("");
		this.passDK.setText("");
		this.textDk.setText("");
		this.txtNhpVoId.setText("");
		this.txtNhpEmail.setText("");
	}
	
      private String tiepnhanmail="";
      private JPanel panel_1;
 
public void xacMinhEmail() throws SQLException {
	
	String email=txtEmail.getText();
	tiepnhanmail=email;
	if(txtEmail.getText().equals("")||txtEmail.getText().equals("   Nhap Mail")){

		        int gtri=JOptionPane.showConfirmDialog(this,"Vui long nhập mail ");
	 		    if(gtri==JOptionPane.YES_OPTION) {
	 			txtEmail.setForeground(UIManager.getColor("TextField.shadow"));
	          	txtEmail.setText("Nhập vào mail");
	 	        return ;	
	 		 }
		
   }else {
      boolean gtrave = false;
		try {
				gtrave = ConnectLoginTeacher.getInfor().LayTkEmail(email);
			} catch (SQLException e2) {
				
				e2.printStackTrace();
			}
	  try {
				System.out.println(ConnectLoginTeacher.getInfor().LayTkEmail(email));
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		   if(gtrave==true) {

			 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";
			 String pwd = RandomStringUtils.random( 6, characters );
			 this.txtMessage.setText(pwd);
		      } 
	}
	 Thread th=new Thread(()->{
		 i=60;
		   while(i>-1) {
			   if(i==0) {
				   txtMessage.setText("");
				   lnelSetTime.setText("");
				   return ;
			   }
			   i--;
			   lnelSetTime.setText(""+i);
			   
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
		   
		
	});
	th.start();
}
@Override
public void xacNhan() {
   
    String pass=this. passwordxn.getText();
    String pasXacthuc=this. passwordxs2.getText();
  
    if(!passwordxn.getText().equals(passwordxs2.getText())) {
 
       int gtr3=JOptionPane.showConfirmDialog(this,"Mk nhập ko khớp ");
          if(gtr3==JOptionPane.YES_OPTION) {
        	    passwordxs2.setEchoChar((char)0);;
        		passwordxs2.setForeground(UIManager.getColor("TextField.shadow"));
            	passwordxs2.setText("    Nhập lại pass");
            	
            	passwordxn.setEchoChar((char)0);
        		passwordxn.setText("    Nhập pass");
        		passwordxn.setForeground(UIManager.getColor("TextField.shadow"));
            	
   	      return;
          }
      } 
    else if(passwordxn.getText().equals("    Nhập pass")||passwordxs2.getText().equals("    Nhập lại pass")) {
    	 int gtr3=JOptionPane.showConfirmDialog(this,"Nhập mk vào ");
    	
         if(gtr3==JOptionPane.YES_OPTION) {
        	 return ;
         }
      }
    else if(passwordxn.getText().equals(passwordxs2.getText())&&(this.textFieldma.getText().equals(this.ganGtri))){
         int gtri=JOptionPane.showConfirmDialog(this,"Đổi mk thành công");
          if(gtri==JOptionPane.YES_OPTION) {
        
            ConnectLoginTeacher.getInfor().CapnhatLaipass(pass,tiepnhanmail);
            textFieldma.setText("   Nhâp mã xác thực");
			textFieldma.setForeground(UIManager.getColor("TextField.shadow"));
		
	     	passwordxn.setEchoChar((char)0);;
    		passwordxn.setText("    Nhập pass");
    		passwordxn.setForeground(UIManager.getColor("TextField.shadow"));
		
            passwordxs2.setEchoChar((char)0);;
        	passwordxs2.setForeground(UIManager.getColor("TextField.shadow"));
        	passwordxs2.setText("    Nhập lại pass");
        	
            }
         }
     }
}