package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Enseignant;
import interfacesBD.AccesBDEnseignant;
import interfacesBD.AccesBDNote;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AjouterEnseignant extends JFrame {

	private JPanel contentPane;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField CIN;
	private JTextField CNSS;
	private JTextField Email;
	private JTextField Telephone;
	private JTable table;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterEnseignant frame = new AjouterEnseignant();
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
	public AjouterEnseignant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter Enseignant");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(197, 11, 275, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(128, 150, 67, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CIN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(128, 250, 92, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(128, 200, 92, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CNSS");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(128, 290, 92, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("E-Mail");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(128, 332, 92, 25);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Telephone");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(128, 380, 92, 25);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Enseignant Ens = new Enseignant();
					Ens.setNom((Nom.getText().toString()));		
					Ens.setPrenom((Prenom.getText().toString()));		
					Ens.setCIN(Integer.parseInt(CIN.getText().toString()));
					Ens.setTelephone(Telephone.getText().toString());
				    Ens.setEmail((Email.getText().toString()));
					Ens.setCNSS(Integer.parseInt(CNSS.getText().toString()));
					AccesBDEnseignant.AjouterEnseignant(Ens);
					
				}catch(SQLException | ClassNotFoundException  e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(171, 481, 111, 43);
		contentPane.add(btnNewButton);
		
		Nom = new JTextField();
		Nom.setBounds(220, 149, 238, 30);
		contentPane.add(Nom);
		Nom.setColumns(10);
		
		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(220, 199, 238, 30);
		contentPane.add(Prenom);
		
		CIN = new JTextField();
		CIN.setColumns(10);
		CIN.setBounds(220, 243, 238, 30);
		contentPane.add(CIN);
		
		CNSS = new JTextField();
		CNSS.setColumns(10);
		CNSS.setBounds(220, 289, 238, 30);
		contentPane.add(CNSS);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(220, 331, 238, 30);
		contentPane.add(Email);
		
		Telephone = new JTextField();
		Telephone.setColumns(10);
		Telephone.setBounds(220, 379, 238, 30);
		contentPane.add(Telephone);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 76, 377, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ID = new JTextField();
		ID.setEditable(false);
		ID.setBounds(114, 22, 237, 31);
		panel.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1_6 = new JLabel("ID");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(21, 24, 67, 25);
		panel.add(lblNewLabel_1_6);
		
		JButton Modifier = new JButton("Modifier");
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Enseignant Ens = new Enseignant();
					Ens.setID(Integer.parseInt(ID.getText()));
					
					Ens.setNom((Nom.getText()));		
					Ens.setPrenom((Prenom.getText()));		
					Ens.setCIN(Integer.parseInt(CIN.getText().toString()));
					Ens.setTelephone(Telephone.getText());
					Ens.setEmail((Email.getText()));
					Ens.setCNSS(Integer.parseInt(CNSS.getText()));
					AccesBDEnseignant.ModifierEnseignant(Ens);
					
				}catch(SQLException | ClassNotFoundException e2) {
					System.out.println(e2);
				}
			}
		});
		Modifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		Modifier.setBounds(302, 481, 111, 43);
		contentPane.add(Modifier);
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRowCount()==1) {
			    	int ID = Integer.parseInt(Model.getValueAt(table.getSelectedRow(),0).toString()); 

			    	Enseignant Not = new Enseignant() ;
			    	Not.setID(ID);
			    	try {
						AccesBDEnseignant.SupprimerEnseignant(Not);
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
		Supprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		Supprimer.setBounds(441, 481, 111, 43);
		contentPane.add(Supprimer);
		
		JButton Chercher = new JButton("Chercher");
		Chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Enseignant> ListeEns = AccesBDEnseignant.getAllEnseignant();
					DefaultTableModel Model = (DefaultTableModel) table.getModel();
					for(Enseignant Ens:ListeEns) {
						String[] Row = {
								Integer.toString(Ens.getID()),
								Ens.getNom(),
								Ens.getPrenom(),
								Integer.toString(Ens.getCIN()),
								Ens.getTelephone(),
								Ens.getEmail(),
								Integer.toString(Ens.getCNSS())							
						};
						Model.addRow(Row);
						
					}
				}catch(SQLException | ClassNotFoundException e1) {
					 System.out.println(e1);
					
				}
			}
		});
		Chercher.setFont(new Font("Tahoma", Font.BOLD, 13));
		Chercher.setBounds(37, 481, 111, 43);
		contentPane.add(Chercher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(594, 111, 477, 418);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				ID.setText(Model.getValueAt(table.getSelectedRow(), 0).toString()) ;
				Nom.setText(Model.getValueAt(table.getSelectedRow(), 1).toString());
				Prenom.setText(Model.getValueAt(table.getSelectedRow(), 2).toString());
				CIN.setText(Model.getValueAt(table.getSelectedRow(), 3).toString());
				Telephone.setText(Model.getValueAt(table.getSelectedRow(), 4).toString());
				Email.setText(Model.getValueAt(table.getSelectedRow(), 5).toString());
				CNSS.setText(Model.getValueAt(table.getSelectedRow(), 6).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nom", "Prenom", "Cin", "Telephone", "Email", "Cnss"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Retourner");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyHomePage Obj = new MyHomePage();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(27, 31, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
