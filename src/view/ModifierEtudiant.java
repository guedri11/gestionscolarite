package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Etudiant;
import interfacesBD.AccesBDEtudiant;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifierEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField NumInsc;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField Email;
	private JTextField Telephone;
	private JTextField Cin;
	private JTable table;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_3;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierEtudiant frame = new ModifierEtudiant();
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
	public ModifierEtudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00B0Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(38, 117, 86, 20);
		contentPane.add(lblNewLabel);
		
		NumInsc = new JTextField();
		NumInsc.setBounds(134, 116, 190, 25);
		contentPane.add(NumInsc);
		NumInsc.setColumns(10);
		
		Nom = new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(131, 171, 193, 25);
		contentPane.add(Nom);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(38, 175, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(131, 223, 193, 25);
		contentPane.add(Prenom);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(38, 227, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(131, 273, 193, 25);
		contentPane.add(Email);
		
		lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(38, 277, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		Telephone = new JTextField();
		Telephone.setColumns(10);
		Telephone.setBounds(134, 324, 190, 25);
		contentPane.add(Telephone);
		
		JLabel lblNewLabel_4 = new JLabel("Telephone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(41, 328, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		Cin = new JTextField();
		Cin.setColumns(10);
		Cin.setBounds(134, 373, 190, 25);
		contentPane.add(Cin);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cin");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(38, 370, 86, 28);
		contentPane.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(383, 85, 538, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				NumInsc.setText(Model.getValueAt(table.getSelectedRow(), 0).toString());
				Nom.setText(Model.getValueAt(table.getSelectedRow(),1).toString());
		    	Prenom.setText(Model.getValueAt(table.getSelectedRow(),2).toString()) ;
		    	Email.setText(Model.getValueAt(table.getSelectedRow(),4).toString()) ;
		    	Telephone.setText(Model.getValueAt(table.getSelectedRow(),5).toString()) ;
		    	Cin.setText(Model.getValueAt(table.getSelectedRow(),3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0Inscription", "Nom", "Prenom", "Cin", "Email", "Telephone"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				Model.setRowCount(0);
				if(NumInsc.getText().equals("") && Nom.getText().equals("") && Prenom.getText().equals("")){
					try {
						List<Etudiant> ListeEtudiant = AccesBDEtudiant.getAllEtudiant();
						for(Etudiant Etudiant:ListeEtudiant) {
							String[] row = {Integer.toString(Etudiant.getNum_Insc()),Etudiant.getNom(),Etudiant.getPrenom(),Integer.toString(Etudiant.getCIN()),Etudiant.getEmail(),Etudiant.getTelephone()};
							System.out.println(row);
							Model.addRow(row);
						}
					}catch(ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}else if(!(NumInsc.getText().equals(""))) {
					try {
						Etudiant Etudiant = AccesBDEtudiant.getEtudiantByNumInsc(Integer.parseInt(NumInsc.getText()));
						String[] row = {Integer.toString(Etudiant.getNum_Insc()),Etudiant.getNom(),Etudiant.getPrenom(),Integer.toString(Etudiant.getCIN()),Etudiant.getEmail(),Etudiant.getTelephone()};
						Model.addRow(row);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(NumInsc.getText().equals("") && (!(Nom.getText().equals("")) || !(Prenom.getText().equals("")))) {
					if(!(Nom.getText().equals(""))) {
						try {
							Etudiant Etu = new Etudiant() ;
							Etu.setNom(Nom.getText());
							List<Etudiant> ListeEtudiant = AccesBDEtudiant.getEtudiantByNomOuPrenom(Etu);
							for(Etudiant Etudiant:ListeEtudiant) {
								String[] row = {Integer.toString(Etudiant.getNum_Insc()),Etudiant.getNom(),Etudiant.getPrenom(),Integer.toString(Etudiant.getCIN()),Etudiant.getEmail(),Etudiant.getTelephone()};
								Model.addRow(row);
							}
						}catch(ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
						// GHODWA TAAMEL DES CONTROLLEUR YAAMLOU RETURB L Model WALA Row zid khamem
					}
					else {
						Etudiant Etu = new Etudiant() ;
						Etu.setPrenom(Prenom.getText());
						List<Etudiant> ListeEtudiant;
						try {
							ListeEtudiant = AccesBDEtudiant.getEtudiantByNomOuPrenom(Etu);
							for(Etudiant Etudiant:ListeEtudiant) {
								String[] row = {Integer.toString(Etudiant.getNum_Insc()),Etudiant.getNom(),Etudiant.getPrenom(),Integer.toString(Etudiant.getCIN()),Etudiant.getEmail(),Etudiant.getTelephone()};
								Model.addRow(row);
							}
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
					}
				}
		});
		btnNewButton.setBounds(10, 442, 110, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
			    if(table.getSelectedRowCount()==1) {
			    	int ID = Integer.parseInt(NumInsc.getText());
			    	String NOM = Nom.getText();
			    	String PRENOM = Prenom.getText();
			        String EMAIL = Email.getText();
			        String Telephon = Telephone.getText();
			        int CIN = Integer.parseInt(Cin.getText());			    	
			    	Etudiant Etu = new Etudiant(ID,NOM,PRENOM,Telephon,EMAIL,CIN);		    	
			    	try {
						AccesBDEtudiant.ModifierEtudiant(Etu);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
			    }else {
			    	if(table.getRowCount() ==0) {
			    		JOptionPane.showMessageDialog( null, "Le Tableau est Vide !");
			    	}else {
			    		JOptionPane.showMessageDialog( null, "Veuillez Selectionnez au moins un Enregistrement.");
			    	}
			    }
			}
		});
		btnNewButton_1.setBounds(130, 442, 106, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
			    if(table.getSelectedRowCount()==1) {
			    	int ID = Integer.parseInt(Model.getValueAt(table.getSelectedRow(),0).toString()); 
			    	Etudiant Etu = new Etudiant();
			    	Etu.setNum_Insc(ID);
			    	try {
						AccesBDEtudiant.SupprimerEtudiant(Etu);
						Model.removeRow(table.getSelectedRow());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
			    }else {
			    	if(table.getRowCount() ==0) {
			    		JOptionPane.showMessageDialog( null, "Le Tableau est Vide !");
			    	}else {
			    		JOptionPane.showMessageDialog( null, "Veuillez Selectionnez au moins un Enregistrement.");
			    	}
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(246, 442, 110, 42);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_5 = new JLabel("Gestion Des Etudiants");
		lblNewLabel_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_5.setBounds(339, 9, 334, 42);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton_3 = new JButton("<Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant I = new GestionDesEtudiant();
				I.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(25, 24, 85, 21);
		contentPane.add(btnNewButton_3);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(24, 85, 322, 336);
		contentPane.add(panel);
	}
}
