package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Login;
import Classes.Utilisateur;
import interfacesBD.AccesBDUtilisateur;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class GestionUtilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField IDEMP;
	private JTextField USERNAME;
	private JTextField PASSWORD;
	private JTable table;
	private JTextField ROLE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUtilisateur frame = new GestionUtilisateur();
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
	public GestionUtilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Employee");
		lblNewLabel.setBounds(42, 207, 60, 14);
		contentPane.add(lblNewLabel);
		
		IDEMP = new JTextField();
		IDEMP.setBounds(108, 204, 183, 20);
		contentPane.add(IDEMP);
		IDEMP.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(52, 241, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		USERNAME = new JTextField();
		USERNAME.setBounds(108, 238, 183, 20);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
		PASSWORD = new JTextField();
		PASSWORD.setBounds(108, 275, 183, 20);
		contentPane.add(PASSWORD);
		PASSWORD.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password\r\n");
		lblNewLabel_2.setBounds(52, 278, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 112, 556, 413);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel();
				IDEMP.setText((Model.getValueAt(table.getSelectedRow(), 0).toString()));
				USERNAME.setText((Model.getValueAt(table.getSelectedRow(), 1).toString()));
				PASSWORD.setText((Model.getValueAt(table.getSelectedRow(), 2).toString()));
				ROLE.setText((Model.getValueAt(table.getSelectedRow(), 3).toString()));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID\u00B0Employeee", "Username", "Password", "Role"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Role");
		lblNewLabel_3.setBounds(52, 319, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		ROLE = new JTextField();
		ROLE.setBounds(108, 316, 183, 20);
		contentPane.add(ROLE);
		ROLE.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Model = (DefaultTableModel) table.getModel()	;
				Model.setRowCount(0);
				try {
					List<Utilisateur> UserList = new ArrayList<Utilisateur>();
					UserList = AccesBDUtilisateur.getAllUsers();
					for(Utilisateur User:UserList) {
						String[] Row = {
								Integer.toString(User.getEmployeeID()),
								User.getLogin().getUsername(),
								User.getLogin().getPassword(),
								User.getRole()
						};
						Model.addRow(Row);
					}
					
				}catch(SQLException | ClassNotFoundException e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(487, 557, 144, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utilisateur User = new Utilisateur();
					Login Logs = new Login();
					Logs.setUsername(USERNAME.getText().toString());
					Logs.setPassword(PASSWORD.getText().toString());
					User.setLogin(Logs);
					User.setEmployeeID(Integer.parseInt(IDEMP.getText().toString()));
					User.setRole(ROLE.getText().toString());
					
					AccesBDUtilisateur.AjouterUtilisateur(User);
					
				}catch(ClassNotFoundException | SQLException e2) {
					
				}
			}
		});
		btnNewButton_1.setBounds(20, 431, 89, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modifier");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur User = new Utilisateur();
				Login Logs = new Login();
				Logs.setUsername(USERNAME.getText().toString());
				Logs.setPassword(PASSWORD.getText().toString());
				User.setLogin(Logs);
				User.setEmployeeID(Integer.parseInt(IDEMP.getText().toString()));
				User.setRole(ROLE.getText().toString());
				
				try {
					AccesBDUtilisateur.ModifierUtilisateur(User);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(119, 431, 89, 35);
		contentPane.add(btnNewButton_1_1);
		
		
		
		JButton btnNewButton_1_2_1 = new JButton("Supprimer");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur User = new Utilisateur();
				User.setEmployeeID(Integer.parseInt(IDEMP.getText()));
				try {
					AccesBDUtilisateur.SupprimerUtilisateur(User);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2_1.setBounds(231, 431, 89, 35);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_2 = new JButton("Retourner");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyHomePage Obj = new MyHomePage();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(41, 33, 105, 35);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Gestion des utilisateurs");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(359, 43, 285, 35);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(20, 165, 309, 222);
		contentPane.add(panel);
	}
}
