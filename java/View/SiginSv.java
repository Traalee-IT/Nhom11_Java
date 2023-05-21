package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import ModelInterface.InterfaceLoginSv;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SiginSv extends JPanel implements InterfaceLoginSv {
	private JTextField txtNhpMSinh;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	 
	/**
	 * Create the panel.
	 */
	public SiginSv(JLayeredPane layerPane,JLayeredPane layeredPaneht) {
		setBackground(Color.PINK);
		setLayout(null);
		
		JButton btnBackSv = new JButton("\tBack");
		btnBackSv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layerPane.removeAll(); 
                layerPane.add(new Panel_Lgsv(layerPane,layeredPaneht) );// add cái panel   
				layerPane.repaint();
				layerPane.revalidate();
			}
		});
		btnBackSv.setBounds(248, 397, 112, 30);
		add(btnBackSv);
		JButton btnNewButton = new JButton("Chấp nhận");
		btnNewButton.setBounds(31, 401, 100, 23);
		add(btnNewButton);
		
		txtNhpMSinh = new JTextField();
		txtNhpMSinh.setText("Nhập Mã Sinh Viên");
		txtNhpMSinh.setBounds(178, 76, 153, 30);
		add(txtNhpMSinh);
		txtNhpMSinh.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 156, 153, 30);
		add(passwordField);
		
		JRadioButton rbnsvht = new JRadioButton("Hiển thị ");
		rbnsvht.setBounds(248, 275, 109, 23);
		add(rbnsvht);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(189, 209, 153, 30);
		add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("Mã Sinh Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 82, 121, 14);
		add(lblNewLabel);
		
		JLabel lblPass_1 = new JLabel("Pass");
		lblPass_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass_1.setBounds(10, 152, 121, 14);
		add(lblPass_1);
		
		JLabel lblPass = new JLabel("Đổi lại Mật Khẩu");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(10, 215, 121, 14);
		add(lblPass);
		
		textField = new JTextField();
		textField.setBackground(Color.PINK);
		textField.setBounds(97, 271, 121, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 326, 121, 36);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPass_1_1 = new JLabel("mã xn");
		lblPass_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass_1_1.setBounds(10, 279, 121, 14);
		add(lblPass_1_1);
		
		JLabel lblPass_1_2 = new JLabel("Nhập mã xn");
		lblPass_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass_1_2.setBounds(22, 337, 121, 14);
		add(lblPass_1_2);

	}
	public void SelectInforSV() {
		   
	}
}
