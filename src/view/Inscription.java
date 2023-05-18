package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Etudiant;
import interfacesBD.AccesBDEtudiant;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField Mail;
	private JTextField Telephone;
	private JTextField Cin;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
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
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Nom = new JTextField();
		Nom.setBounds(144, 76, 242, 20);
		contentPane.add(Nom);
		Nom.setColumns(10);
		
		Prenom = new JTextField();
		Prenom.setBounds(144, 128, 242, 20);
		contentPane.add(Prenom);
		Prenom.setColumns(10);
		
		Mail = new JTextField();
		Mail.setBounds(143, 179, 242, 20);
		contentPane.add(Mail);
		Mail.setColumns(10);
		
		Telephone = new JTextField();
		Telephone.setBounds(144, 235, 242, 20);
		contentPane.add(Telephone);
		Telephone.setColumns(10);
		
		Cin = new JTextField();
		Cin.setBounds(144, 285, 242, 20);
		contentPane.add(Cin);
		Cin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(72, 78, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(72, 130, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mail:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(72, 180, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telephone:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(72, 236, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cin:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(72, 286, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Inscrire");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Etudiant Etu = new Etudiant();
				Etu.setNom(Nom.getText());
				Etu.setCIN( Integer.parseInt(Cin.getText()));
				Etu.setEmail(Mail.getText());
				Etu.setPrenom(Nom.getText());
				Etu.setTelephone(Telephone.getText());
				try {
					AccesBDEtudiant.AjouterEtudiant(Etu);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(181, 350, 111, 33);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Inscrire Un Etudiant");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(181, 23, 197, 33);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("< Retourner");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant I = new GestionDesEtudiant();
				I.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 391, 108, 23);
		contentPane.add(btnNewButton_1);
	}
}
