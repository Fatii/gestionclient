package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHibaGestionPro = new JLabel("Hiba Gestion Pro");
		lblHibaGestionPro.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHibaGestionPro.setForeground(Color.RED);
		lblHibaGestionPro.setBounds(137, 53, 152, 24);
		contentPane.add(lblHibaGestionPro);
		
		JButton btnAjoutDunClient = new JButton("Ajouter un client");
		btnAjoutDunClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajoutclient frameAjoutClient = new Ajoutclient();
				frameAjoutClient.setVisible(true);
			}
		});
		btnAjoutDunClient.setBounds(267, 117, 140, 23);
		contentPane.add(btnAjoutDunClient);
		
		JButton btnListeDesClients = new JButton("Liste des clients");
		btnListeDesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listeclient frameListeClient = new Listeclient();
				frameListeClient.setVisible(true);
			}
		});
		btnListeDesClients.setBounds(28, 117, 117, 23);
		contentPane.add(btnListeDesClients);
	}

}
