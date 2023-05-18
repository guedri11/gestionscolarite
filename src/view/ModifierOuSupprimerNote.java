package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Actions.Prepare;
import Classes.Absences;
import interfacesBD.AccesBDAbscences;
import interfacesBD.AccesBDNote;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifierOuSupprimerNote extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField IDNOTE;
	private JTextField IDETUDIANT;
	private JTextField IDMAT;
	private JTextField Note;
	private JTextField Type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierOuSupprimerNote frame = new ModifierOuSupprimerNote();
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
	public ModifierOuSupprimerNote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 71, 476, 390);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				IDNOTE.setText(Model.getValueAt(table.getSelectedRow(), 0).toString());
				IDETUDIANT.setText(Model.getValueAt(table.getSelectedRow(), 1).toString());
				IDMAT.setText(Model.getValueAt(table.getSelectedRow(), 3).toString());
				Note.setText(Model.getValueAt(table.getSelectedRow(), 5).toString());
				Type.setText(Model.getValueAt(table.getSelectedRow(), 6).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID\u00B0Note", "ID\u00B0Etudiant", "Nom", "ID\u00B0Matiere", "Nom", "Note", "Type"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==1) {
				int ID_Note = Integer.parseInt(IDNOTE.getText().toString()); 
				String ID_Mat =IDMAT.getText();
				String ID_Etu = IDETUDIANT.getText();
				String Val_Note = Note.getText();
				String Val_Type = Type.getText();
				
				Classes.Note Grad = Prepare.PrepareNote(ID_Note, Integer.parseInt(ID_Etu), Integer.parseInt(ID_Mat), Float.parseFloat(Val_Note), Val_Type);
				try {
					AccesBDNote.ModifierNote(Grad);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
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
		btnNewButton.setBounds(47, 446, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
			    if(table.getSelectedRowCount()==1) {
			    	int ID = Integer.parseInt(Model.getValueAt(table.getSelectedRow(),0).toString()); 

			    	Classes.Note Not = new Classes.Note() ;
			    	Not.setIDNote(ID);
			    	try {
						AccesBDNote.SupprimerNote(Not);
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
		btnNewButton_1.setBounds(153, 446, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Chercher");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				Model.setRowCount(0);
				if(!(IDNOTE.getText().equals(""))) {
					String ID_Note =IDNOTE.getText().toString();
					// String ID_Mat =IDMAT.getText();
					//  String ID_Etu = IDETUDIANT.getText();
					// String Val_Note = Note.getText();
					//  String Val_Type = Type.getText();
					/*
				    Integer.parseInt(ID_Note)
					Integer.parseInt(ID_Mat)
					Integer.parseInt(ID_Etu)
					Float.parseFloat(Val_Note)
					*/
					//Note Grad = Prepare.PrepareNote(Integer.parseInt(ID_Note), Integer.parseInt(ID_Etu), Integer.parseInt(ID_Mat), Float.parseFloat(Val_Note), Val_Type);
					try {
						Classes.Note Grad = AccesBDNote.getNoteByID(Integer.parseInt(ID_Note));
						String NomComplet = Grad.getEtu().getNom() +" "+ Grad.getEtu().getPrenom();
						String[] row = { Integer.toString(Grad.getIDNote()),
								Integer.toString(Grad.getEtu().getNum_Insc()),
								NomComplet,
								Integer.toString(Grad.getMat().getIdMat()),
								Grad.getMat().getNomMat(),
								Float.toString(Grad.getNote()),
								Grad.getType()			
						};
						Model.addRow(row);
						
					}catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if( IDNOTE.getText().equals("") && !(IDETUDIANT.getText().equals(""))) {
					String ID_Etudiant = IDETUDIANT.getText().toString();
					
					try {
						List<Classes.Note> Grads = AccesBDNote.getNoteByNumInsc(Integer.parseInt(ID_Etudiant));
						for(Classes.Note Notes:Grads) {
							String NomComplet = Notes.getEtu().getNom() + " " + Notes.getEtu().getPrenom() ;
							String[] row = { Integer.toString(Notes.getIDNote()),
									Integer.toString(Notes.getEtu().getNum_Insc()),
									NomComplet,
									Integer.toString(Notes.getMat().getIdMat()),
									Notes.getMat().getNomMat(),
									Float.toString(Notes.getNote()),
									Notes.getType()			
							};
							Model.addRow(row);
						}
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					try {
						List<Classes.Note> Grads = AccesBDNote.getAllNote();
						for(Classes.Note Notes:Grads) {
							String NomComplet = Notes.getEtu().getNom() + " " + Notes.getEtu().getPrenom() ;
							String[] row = { Integer.toString(Notes.getIDNote()),
									Integer.toString(Notes.getEtu().getNum_Insc()),
									NomComplet,
									Integer.toString(Notes.getMat().getIdMat()),
									Notes.getMat().getNomMat(),
									Float.toString(Notes.getNote()),
									Notes.getType()			
							};
							Model.addRow(row);
						}
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_2.setBounds(268, 446, 89, 23);
		contentPane.add(btnNewButton_2);
		
		IDNOTE = new JTextField();
		IDNOTE.setBounds(156, 75, 86, 20);
		contentPane.add(IDNOTE);
		IDNOTE.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID\u00B0Note");
		lblNewLabel.setBounds(174, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel IDLabel = new JLabel("ID\u00B0Etudiant");
		IDLabel.setBounds(174, 122, 46, 14);
		contentPane.add(IDLabel);
		
		IDETUDIANT = new JTextField();
		IDETUDIANT.setColumns(10);
		IDETUDIANT.setBounds(156, 147, 86, 20);
		contentPane.add(IDETUDIANT);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID\u00B0Matiere");
		lblNewLabel_1_1.setBounds(174, 205, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		IDMAT = new JTextField();
		IDMAT.setColumns(10);
		IDMAT.setBounds(156, 230, 86, 20);
		contentPane.add(IDMAT);
		
		JLabel lblNewLabel_1_2 = new JLabel("Note");
		lblNewLabel_1_2.setBounds(174, 286, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		Note = new JTextField();
		Note.setColumns(10);
		Note.setBounds(156, 311, 86, 20);
		contentPane.add(Note);
		
		JLabel lblNewLabel_1_3 = new JLabel("Type");
		lblNewLabel_1_3.setBounds(174, 373, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		Type = new JTextField();
		Type.setColumns(10);
		Type.setBounds(156, 398, 86, 20);
		contentPane.add(Type);
		
		JButton btnNewButton_3 = new JButton("Retourner");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesNotes Obj = new GestionDesNotes();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(153, 486, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
