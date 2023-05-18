package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classes.Groupe;
import interfacesBD.AccesBDGroupe;
import interfacesBD.AccesBDNote;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifSuppGroupe extends JFrame {

	private JPanel contentPane;
	private JTextField IDField; 
	private JTextField DiplomeField;
	private JTextField NumGField;
	private JTextField SpecialiteField;
	private JTable tableGroupe;
	private JTextField NiveauField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifSuppGroupe frame = new ModifSuppGroupe();
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
	public ModifSuppGroupe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID\u00B0Groupe");
		lblNewLabel.setBounds(26, 95, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Diplome");
		lblNewLabel_1.setBounds(26, 153, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Specialite");
		lblNewLabel_2.setBounds(26, 212, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0Groupe");
		lblNewLabel_3.setBounds(26, 314, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		IDField = new JTextField();
		IDField.setBounds(26, 120, 142, 20);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		DiplomeField = new JTextField();
		DiplomeField.setBounds(26, 178, 142, 20);
		DiplomeField.setColumns(10);
		contentPane.add(DiplomeField);
		
		NumGField = new JTextField();
		NumGField.setBounds(26, 339, 142, 20);
		NumGField.setColumns(10);
		contentPane.add(NumGField);
		
		SpecialiteField = new JTextField();
		SpecialiteField.setBounds(26, 237, 142, 20);
		SpecialiteField.setColumns(10);
		contentPane.add(SpecialiteField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 116, 483, 330);
		contentPane.add(scrollPane);
		
		tableGroupe = new JTable();
		tableGroupe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Model = (DefaultTableModel) tableGroupe.getModel();
				IDField.setText(Model.getValueAt(tableGroupe.getSelectedRow(),0).toString());
				DiplomeField.setText(Model.getValueAt(tableGroupe.getSelectedRow(),1).toString());
				SpecialiteField.setText(Model.getValueAt(tableGroupe.getSelectedRow(),2).toString());
				NiveauField.setText(Model.getValueAt(tableGroupe.getSelectedRow(),3).toString());
				NumGField.setText(Model.getValueAt(tableGroupe.getSelectedRow(),4).toString());
			}
		});
		tableGroupe.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID\u00B0Groupe", "Diplome", "Specialite", "Niveau", "N\u00B0Groupe"
			}
		));
		tableGroupe.getColumnModel().getColumn(3).setPreferredWidth(79);
		scrollPane.setViewportView(tableGroupe);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IDGRP = Integer.parseInt(IDField.getText().toString());
				String DIPLOMA = DiplomeField.getText().toString();
				String Major = SpecialiteField.getText().toString();
				int NumG = Integer.parseInt(NumGField.getText().toString());
				String LEVEL = NiveauField.getText().toString();
				Groupe GroupeSupp = new Groupe();
				GroupeSupp.setDiplome(DIPLOMA);
				GroupeSupp.setIDGrp(IDGRP);
				GroupeSupp.setSpecialite(Major);
				GroupeSupp.setNumG(NumG);
				GroupeSupp.setNiveau(LEVEL);
				
				try {
					AccesBDGroupe.SupprimerGroupe(IDGRP);
					IDField.setText(""); 
					DiplomeField.setText(""); 
					NumGField.setText(""); 
					SpecialiteField.setText("");  
					NiveauField.setText(""); 
		            
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setBounds(127, 431, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IDGRP = Integer.parseInt(IDField.getText().toString());
				String DIPLOMA = DiplomeField.getText().toString();
				String Major = SpecialiteField.getText().toString();
				int NumG = Integer.parseInt(NumGField.getText().toString());
				String LEVEL = NiveauField.getText().toString();
				Groupe GroupeSupp = new Groupe();
				GroupeSupp.setDiplome(DIPLOMA);
				GroupeSupp.setIDGrp(IDGRP);
				GroupeSupp.setSpecialite(Major);
				GroupeSupp.setNumG(NumG);
				GroupeSupp.setNiveau(LEVEL);
				
				try {
					AccesBDGroupe.ModifierGroupe(GroupeSupp);
					IDField.setText(""); 
					DiplomeField.setText(""); 
					NumGField.setText(""); 
					SpecialiteField.setText("");  
					NiveauField.setText(""); 
		            
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 431, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.setBounds(26, 22, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Chercher");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) tableGroupe.getModel();
				Model.setRowCount(0);
				try {
					List<Groupe> ListeGrp = AccesBDGroupe.getAllGroupe();
					for(Groupe Grp:ListeGrp) {
						
						String[] row = { Integer.toString(Grp.getIDGrp()),
								Grp.getDiplome().toString(),
								Grp.getSpecialite().toString(),
								Grp.getNiveau().toString(),
								Integer.toString(Grp.getNumG())
						};
						Model.addRow(row);
					}
					
				}catch(SQLException | ClassNotFoundException e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton_3.setBounds(68, 385, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Niveau");
		lblNewLabel_4.setBounds(26, 268, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		NiveauField = new JTextField();
		NiveauField.setBounds(26, 293, 142, 20);
		contentPane.add(NiveauField);
		NiveauField.setColumns(10);
	}

}
