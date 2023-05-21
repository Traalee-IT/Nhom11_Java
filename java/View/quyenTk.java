package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ConnectLoginTeacher;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class quyenTk extends JFrame {

	private JPanel contentPane;
	private JTextField textMail;
	private JTextField textTk;
	private JTextField textMk;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public quyenTk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMail = new JTextField();
		textMail.setBounds(158, 47, 184, 28);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		JLabel textEmail = new JLabel("email");
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmail.setForeground(new Color(255, 0, 0));
		textEmail.setBounds(76, 49, 61, 17);
		contentPane.add(textEmail);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(178, 91, 89, 23);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemEmail();
			}
		});
		contentPane.add(btnTim);
		
		textTk = new JTextField();
		textTk.setBounds(181, 129, 178, 28);
		contentPane.add(textTk);
		textTk.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tài khoản");
		lblNewLabel.setBounds(76, 132, 46, 14);
		contentPane.add(lblNewLabel);
		
		textMk = new JTextField();
		textMk.setColumns(10);
		textMk.setBounds(181, 174, 178, 23);
		contentPane.add(textMk);
		
		JLabel textPass = new JLabel("Pass");
		textPass.setBounds(89, 177, 46, 14);
		contentPane.add(textPass);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(178, 216, 89, 23);
		contentPane.add(btnThoat);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 8, 184, 28);
		contentPane.add(textField);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.RED);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(76, 15, 61, 17);
		contentPane.add(lblId);
		this.setVisible(true);
	}

	public void timKiemEmail() {
		String TextMail= this.textMail.getText();
		this.textTk.setText(ConnectLoginTeacher.getInfor().EmailTaikhoan(TextMail).get(0));
		this.textMk.setText(ConnectLoginTeacher.getInfor().EmailTaikhoan(TextMail).get(1));
		
	}
}
