package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class GestionDesEtudiant extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDesEtudiant frame = new GestionDesEtudiant();
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
	public GestionDesEtudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Inscrire un Etudiant");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription I = new Inscription();
				I.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(80, 77, 294, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier Ou Supprimer Un Etudiant");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierEtudiant I = new ModifierEtudiant();
				I.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(80, 138, 294, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gestion Des Absences");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesAbs Obj = new GestionDesAbs();
				setVisible(false);
				Obj.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(80, 195, 294, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retourner");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyHomePage I = new MyHomePage();
				I.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(134, 324, 173, 34);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Gestion Des Notes");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesNotes Obj = new GestionDesNotes();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(80, 251, 294, 34);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Etudiants");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(140, 23, 218, 25);
		contentPane.add(lblNewLabel);
	}
}
