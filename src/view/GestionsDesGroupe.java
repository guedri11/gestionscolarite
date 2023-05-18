package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class GestionsDesGroupe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionsDesGroupe frame = new GestionsDesGroupe();
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
	public GestionsDesGroupe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter Groupe");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterGroupe Obj = new AjouterGroupe();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(129, 115, 244, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afficher Modifier "
				+ "Supprimer Un Groupe");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifSuppGroupe Obj = new ModifSuppGroupe();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(129, 170, 244, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyHomePage Obj = new MyHomePage();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(129, 244, 244, 34);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Groupes");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(164, 44, 233, 44);
		contentPane.add(lblNewLabel);
	}
}
