package view;
import Classes.Login;
import view.MyHomePage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfacesBD.AccesBDUtilisateur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
public class MyLogin extends JFrame implements AccesBDUtilisateur {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLogin frame = new MyLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(97, 171, 100, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(97, 226, 100, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(195, 175, 261, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = textField.getText();
				String Password = passwordField.getText();
				Login Logins = new Login();
				Logins.setPassword(Password);
				Logins.setUsername(Username);
				
				
				try {
					int Stat = AccesBDUtilisateur.VerifierLogin(Logins);
					if ( Stat == 1) {
						JOptionPane.showMessageDialog(null, "Bievenue");
						MyHomePage Obj = new MyHomePage();
						Obj.setVisible(true);
						setVisible(false);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect !");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
					
				
			}
		});
		btnNewButton.setBounds(228, 306, 195, 49);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(195, 228, 261, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("CONNEXION");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_3.setBounds(223, 79, 187, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Se Connecter a votre compte");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(195, 126, 228, 22);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\GUEDRI\\Desktop\\logopi.jpg"));
		lblNewLabel_5.setBounds(10, 11, 205, 49);
		contentPane.add(lblNewLabel_5);
	}
}
