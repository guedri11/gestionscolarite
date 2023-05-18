package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GestionDesAbs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDesAbs frame = new GestionDesAbs();
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
	public GestionDesAbs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter des Absences");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AjouterAbsences Obj = new AjouterAbsences();
				Obj.setVisible(true);
				setVisible(false);
			}
		});
		btnAjouter.setBounds(96, 66, 211, 37);
		contentPane.add(btnAjouter);
		
		JButton btnModifSupp = new JButton("Affichage et Modification");
		btnModifSupp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierOuSupprimerAbsences Obj = new ModifierOuSupprimerAbsences();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnModifSupp.setBounds(96, 114, 211, 37);
		contentPane.add(btnModifSupp);
		
		JButton btnNewButton_2 = new JButton("Retourner");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant Obj = new GestionDesEtudiant();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(152, 181, 111, 37);
		contentPane.add(btnNewButton_2);
	}

}
