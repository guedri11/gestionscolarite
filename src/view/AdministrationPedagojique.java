package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrationPedagojique extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrationPedagojique frame = new AdministrationPedagojique();
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
	public AdministrationPedagojique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Planifier Un Cours");
		btnNewButton.setBounds(238, 81, 280, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestion des Matiere");
		btnNewButton_1.setBounds(238, 285, 280, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gestion des Modules");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(238, 176, 280, 59);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Retourner");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyHomePage Obj = new MyHomePage();
				setVisible(false);
				Obj.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(238, 388, 280, 59);
		contentPane.add(btnNewButton_2_1);
	}
}
