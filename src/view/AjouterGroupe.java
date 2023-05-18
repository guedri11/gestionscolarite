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

import Classes.Absences;
import Classes.Groupe;
import interfacesBD.AccesBDAbscences;
import interfacesBD.AccesBDGroupe;
import interfacesBD.AccesBDModule;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AjouterGroupe extends JFrame {

	private JPanel contentPane;
	private JTextField NumG;
	private JTextField textField_1;
	private JTextField SPE;
	private JTextField DIP;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterGroupe frame = new AjouterGroupe();
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
	public AjouterGroupe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Diplome");
		lblNewLabel.setBounds(38, 188, 277, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Specialit\u00E9");
		lblNewLabel_1.setBounds(38, 237, 277, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel NIV = new JLabel("Niveau");
		NIV.setBounds(38, 299, 277, 14);
		contentPane.add(NIV);
		
		JLabel lblNewLabel_3 = new JLabel("Numero du Groupe");
		lblNewLabel_3.setBounds(38, 368, 277, 14);
		contentPane.add(lblNewLabel_3);
		
		NumG = new JTextField();
		NumG.setBounds(38, 393, 277, 20);
		contentPane.add(NumG);
		NumG.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(38, 326, 277, 20);
		contentPane.add(textField_1);
		
		SPE = new JTextField();
		SPE.setColumns(10);
		SPE.setBounds(38, 268, 277, 20);
		contentPane.add(SPE);
		
		DIP = new JTextField();
		DIP.setColumns(10);
		DIP.setBounds(38, 213, 277, 20);
		contentPane.add(DIP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 98, 426, 453);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID\u00B0Module", "Nom", "Coef"
			}
		));
		scrollPane.setViewportView(table);
		

		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Niv = NIV.getText().toString();
				String Dip = DIP.getText().toString();
				String Spe = SPE.getText().toString();
				int Num_G = Integer.parseInt(NumG.getText().toString());
				if(table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Veuillez Selectionner les Modules !");
				}
				else {
					try {
						Groupe Grp = new Groupe();
						Grp.setDiplome(Dip);
						Grp.setNiveau(Niv);
						Grp.setSpecialite(Spe);
						Grp.setNumG(Num_G);
						Groupe GrpAffectee = AccesBDGroupe.AjouterGroupe(Grp);
						int IDGrpAffectee = GrpAffectee.getIDGrp()	;
						
						// GET Selected Modules
						
						int selectedRow[] = table.getSelectedRows();
						List<Classes.Module> ListeModuleSelectionne = new ArrayList<Classes.Module>();
				        for (int i : selectedRow) {
				            int IDModule = Integer.parseInt(table.getValueAt(i, 0).toString());
							Classes.Module Modul = AccesBDModule.getModuleById(IDModule);
							ListeModuleSelectionne.add(Modul);		         
				        }
				        for(Classes.Module Mod :ListeModuleSelectionne ) {
				        	AccesBDGroupe.AjouterModule(IDGrpAffectee, Mod);
				        }
						
						
					}catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}			        
				}
			}
		});
		btnNewButton.setBounds(96, 481, 156, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afficher les Module");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				Model.setRowCount(0);
				List<Classes.Module> ListeModule;
				try {
					ListeModule = AccesBDModule.getAllModules();
					for(Classes.Module MDL : ListeModule ) {
						String[] Row = { Integer.toString(MDL.getID()),
								MDL.getNom().toString(),
								Float.toString(MDL.getCoef())
						};
						Model.addRow(Row);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(96, 435, 156, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionsDesGroupe Obj = new GestionsDesGroupe();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(132, 580, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
