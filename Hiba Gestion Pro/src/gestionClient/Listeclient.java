package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class Listeclient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listeclient frame = new Listeclient();
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
	public Listeclient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Liste des clients");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(140, 11, 144, 28);
		contentPane.add(label);
		
		JButton button = new JButton("Retour");
		button.setBounds(10, 217, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.setBounds(122, 217, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.setBounds(221, 217, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Ajouter");
		button_3.setBounds(335, 217, 89, 23);
		contentPane.add(button_3);
	}
}
