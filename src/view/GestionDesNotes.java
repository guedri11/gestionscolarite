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

public class GestionDesNotes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDesNotes frame = new GestionDesNotes();
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
	public GestionDesNotes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter Note");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterNote Obj = new AjouterNote();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(79, 46, 231, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ModifierOuSupprimer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierOuSupprimerNote Obj = new ModifierOuSupprimerNote();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(79, 121, 231, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant Obj = new GestionDesEtudiant();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(117, 215, 128, 37);
		contentPane.add(btnNewButton_2);
	}
}
