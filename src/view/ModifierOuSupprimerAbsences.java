package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Absences;
import Classes.Etudiant;
import interfacesBD.AccesBDAbscences;
import interfacesBD.AccesBDCours;
import interfacesBD.AccesBDEtudiant;
import Actions.Prepare;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifierOuSupprimerAbsences extends JFrame {

	private JPanel contentPane;
	private JTextField IDETU;
	private JTextField IDCrs;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierOuSupprimerAbsences frame = new ModifierOuSupprimerAbsences();
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
	public ModifierOuSupprimerAbsences() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IDAbs = new JLabel("ID Abscence");
		IDAbs.setBounds(35, 121, 156, 14);
		contentPane.add(IDAbs);
		
		JLabel IDEtudiant = new JLabel("ID Etudiant");
		IDEtudiant.setBounds(35, 201, 156, 14);
		contentPane.add(IDEtudiant);
		
		JLabel IDCours = new JLabel("ID Cours");
		IDCours.setBounds(35, 279, 156, 14);
		contentPane.add(IDCours);
		
		JTextPane IDABS = new JTextPane();
		IDABS.setBounds(35, 146, 156, 20);
		contentPane.add(IDABS);
		
		IDETU = new JTextField();
		IDETU.setBounds(35, 226, 156, 20);
		contentPane.add(IDETU);
		IDETU.setColumns(10);
		
		IDCrs = new JTextField();
		IDCrs.setBounds(35, 304, 156, 20);
		contentPane.add(IDCrs);
		IDCrs.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 88, 431, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				IDETU.setText(Model.getValueAt(table.getSelectedRow(),1).toString());
				IDCrs.setText(Model.getValueAt(table.getSelectedRow(),2).toString());
				IDABS.setText(Model.getValueAt(table.getSelectedRow(),0).toString());
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID_Abcence", "ID_Etudiant", "ID_Cours"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==1) {
			    	int ID = Integer.parseInt(IDABS.getText());
			    	int IDEtu = Integer.parseInt(IDETU.getText()) ;
			    	int IDCourse = Integer.parseInt(IDCrs.getText()) ;			    	
			    	Absences Abs = new Absences();	
			    	Abs.getCourse().setID(IDCourse);
			    	Abs.getEtu().setNum_Insc(IDEtu);
			    	Abs.setID(ID);
			    	
			    	try {
						AccesBDAbscences.ModifierAbscences(Abs);
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
		btnUpdate.setBounds(78, 382, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				Model.setRowCount(0);
				if( !(IDABS.getText().equals("")) ) {
					try {
						Absences Abs = AccesBDAbscences.getAbsencesByID(Integer.parseInt(IDABS.getText()));
						String[] row = {Integer.toString(Abs.getID()),Integer.toString(Abs.getEtu().getNum_Insc()),Integer.toString(Abs.getCourse().getID())};
						Model.addRow(row);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(IDCrs.getText().equals("") && IDETU.getText().equals("") && IDABS.getText().equals("")) {
					try {
						List<Absences> ListeAbs = AccesBDAbscences.getAllAbsences();
						for(Absences Abs:ListeAbs) {
						String[] row = {Integer.toString(Abs.getID()),Integer.toString(Abs.getEtu().getNum_Insc()),Integer.toString(Abs.getCourse().getID())};
						Model.addRow(row);
						}
					}catch(ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if(IDABS.getText().equals("") && !(IDETU.getText().equals("")) ) {
						try {
							Etudiant Etu = new Etudiant();
							Etu.setNum_Insc(Integer.parseInt(IDETU.getText()));
							List<Absences> ListeAbs = AccesBDAbscences.getAbsencesByEtudiant(Etu);
							for(Absences Abs:ListeAbs) {
							String[] row = {Integer.toString(Abs.getID()),Integer.toString(Abs.getEtu().getNum_Insc()),Integer.toString(Abs.getCourse().getID())};
							Model.addRow(row);
							}
						}catch(ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
				}
				else {
					try {
						List<Absences> ListeAbs = AccesBDAbscences.getAllAbsences();
						for(Absences Abs:ListeAbs) {
						String[] row = {Integer.toString(Abs.getID()),Integer.toString(Abs.getEtu().getNum_Insc()),Integer.toString(Abs.getCourse().getID())};
						Model.addRow(row);
						}
					}catch(ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnChercher.setBounds(78, 345, 89, 23);
		contentPane.add(btnChercher);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
			    if(table.getSelectedRowCount()==1) {
			    	int ID = Integer.parseInt(Model.getValueAt(table.getSelectedRow(),0).toString()); 
			    	int IDETUD = Integer.parseInt(Model.getValueAt(table.getSelectedRow(),1).toString()); 
			    	int IDCOURS = Integer.parseInt(Model.getValueAt(table.getSelectedRow(),2).toString()); 
			
			    	Absences Abs = null ;
			    	Abs =Prepare.PrepareAbsence(ID,IDETUD,IDCOURS);
			    	try {
						AccesBDAbscences.SupprimerAbscences(Abs);
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
		btnNewButton_2.setBounds(78, 416, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Retourner");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant Obj = new GestionDesEtudiant();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(54, 46, 89, 23);
		contentPane.add(btnNewButton);
	}
}
