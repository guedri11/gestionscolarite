package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Actions.Prepare;
import Classes.Absences;
import interfacesBD.AccesBDAbscences;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterAbsences extends JFrame {

	private JPanel contentPane;
	private JTextField IDETU;
	private JTextField IDCRS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterAbsences frame = new AjouterAbsences();
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
	public AjouterAbsences() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDETU = new JTextField();
		IDETU.setBounds(206, 87, 226, 20);
		contentPane.add(IDETU);
		IDETU.setColumns(10);
		
		IDCRS = new JTextField();
		IDCRS.setBounds(206, 145, 226, 20);
		contentPane.add(IDCRS);
		IDCRS.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Etudiant");
		lblNewLabel_1.setBounds(110, 90, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID Cours");
		lblNewLabel_2.setBounds(110, 148, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Absences Abs = Prepare.PrepareAbsence(0, Integer.parseInt(IDETU.getText()), Integer.parseInt(IDCRS.getText())) ;
				if(Abs == null) {
					JOptionPane.showMessageDialog(null, "L'Etudiant ou Le Cours n'existe Pas");
				}
				else {
					try {
						AccesBDAbscences.AjouterAbscences(Abs);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAjouter.setBounds(131, 227, 89, 33);
		contentPane.add(btnAjouter);
		
		JButton btnNewButton = new JButton("Retourner");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant Obj = new GestionDesEtudiant();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(280, 227, 89, 33);
		contentPane.add(btnNewButton);
	}

}
