package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Actions.Prepare;
import interfacesBD.AccesBDNote;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AjouterNote extends JFrame {

	private JPanel contentPane;
	private JTextField IDEtu;
	private JTextField IDMat;
	private JTextField Type;
	private JTextField Note;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterNote frame = new AjouterNote();
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
	public AjouterNote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID\u00B0Etudiant");
		lblNewLabel_1.setBounds(160, 143, 461, 14);
		contentPane.add(lblNewLabel_1);
		
		IDEtu = new JTextField();
		IDEtu.setColumns(10);
		IDEtu.setBounds(142, 168, 479, 20);
		contentPane.add(IDEtu);
		
		JLabel lblNewLabel_2 = new JLabel("ID\u00B0Matiere");
		lblNewLabel_2.setBounds(160, 243, 461, 14);
		contentPane.add(lblNewLabel_2);
		
		IDMat = new JTextField();
		IDMat.setColumns(10);
		IDMat.setBounds(142, 268, 479, 20);
		contentPane.add(IDMat);
		
		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setBounds(160, 427, 461, 14);
		contentPane.add(lblNewLabel_2_1);
		
		Type = new JTextField();
		Type.setColumns(10);
		Type.setBounds(142, 452, 479, 20);
		contentPane.add(Type);
		
		JLabel Notee = new JLabel("Note");
		Notee.setBounds(160, 327, 461, 14);
		contentPane.add(Notee);
		
		Note = new JTextField();
		Note.setColumns(10);
		Note.setBounds(142, 352, 479, 20);
		contentPane.add(Note);
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(IDMat.getText().toString());
					String Typ = Type.getText().toString();
					int IDEtudiant = Integer.parseInt(IDEtu.getText().toString());
					int IDMatiere = Integer.parseInt(IDMat.getText().toString());
					float Not = Float.parseFloat(Note.getText().toString());
					Classes.Note NoTe = Prepare.PrepareNote(0, IDEtudiant, IDMatiere, Not, Typ);
					AccesBDNote.AjouterNote(NoTe);
					
				}catch(ClassNotFoundException | SQLException e1) {
					System.out.print(e1);
				}
			}
		});
		btnNewButton.setBounds(336, 529, 97, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Retourner");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesNotes Obj = new GestionDesNotes();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(34, 31, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
