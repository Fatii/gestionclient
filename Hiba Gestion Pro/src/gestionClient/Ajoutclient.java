package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import model.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.FabriqueSession;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajoutclient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajoutclient frame = new Ajoutclient();
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
	public Ajoutclient() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjoutDunClient = new JLabel("Ajout d'un client");
		lblAjoutDunClient.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAjoutDunClient.setForeground(Color.RED);
		lblAjoutDunClient.setBounds(132, 11, 146, 26);
		contentPane.add(lblAjoutDunClient);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(27, 68, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setBounds(27, 106, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(27, 146, 46, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblCin = new JLabel("CIN :");
		lblCin.setBounds(27, 188, 46, 14);
		contentPane.add(lblCin);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone 1 :");
		lblTlphone.setBounds(235, 68, 79, 14);
		contentPane.add(lblTlphone);
		
		JLabel lblTlphone_1 = new JLabel("T\u00E9l\u00E9phone 2 :");
		lblTlphone_1.setBounds(235, 106, 79, 14);
		contentPane.add(lblTlphone_1);
		
		JLabel lblTlphone_2 = new JLabel("T\u00E9l\u00E9phone 3 :");
		lblTlphone_2.setBounds(235, 146, 79, 14);
		contentPane.add(lblTlphone_2);
		
		textField = new JTextField();
		textField.setBounds(83, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 103, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 143, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 185, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 65, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(324, 103, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(324, 143, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Listeclient frameListeClient = new Listeclient();
				frameListeClient.setVisible(true);
			}
		});
		btnAjouter.setBounds(269, 216, 89, 23);
		contentPane.add(btnAjouter);
	}
	
	private static void creerClient(Client clt) {
		Transaction tx = null;
		Session session = FabriqueSession.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.save(clt);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					e.printStackTrace();
				}
				// throw again the first exception
				throw e;
			}
		}
	}
}
