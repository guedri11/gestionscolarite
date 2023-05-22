 package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MyHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyHomePage frame = new MyHomePage();
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
	public MyHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestion Des Etudiants");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDesEtudiant Obj = new GestionDesEtudiant();
				Obj.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(90, 82, 264, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestion Des Enseignant");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterEnseignant Obj = new AjouterEnseignant();
				setVisible(false);
				Obj.setVisible(true);  
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(90, 160, 264, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gestion Des Groupes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionsDesGroupe Obj = new GestionsDesGroupe();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(90, 244, 264, 58);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Gestion Des Utilisateur");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionUtilisateur Obj = new GestionUtilisateur();
				setVisible(false);
				Obj.setVisible(true); 
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(90, 326, 264, 58);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Administration Pedagojique ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrationPedagojique Obj=new AdministrationPedagojique();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.setBounds(90, 407, 264, 58);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Se Deconnecter");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLogin I = new MyLogin();
				I.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBounds(147, 502, 133, 37);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur GestionPi");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(111, 22, 243, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\GUEDRI\\Desktop\\logopi.jpg");
		Image image = imageIcon.getImage();
		Image resizedImage = image.getScaledInstance(62, 47, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblNewLabel_1.setIcon(resizedIcon);
		lblNewLabel_1.setBounds(10, 10, 62, 47);
		contentPane.add(lblNewLabel_1);
	}

}
