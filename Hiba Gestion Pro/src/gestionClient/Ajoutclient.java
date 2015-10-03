package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private JTextField tNom;
	private JTextField tPrenom;
	private JTextField tAdresse;
	private JTextField tCin;
	private JTextField tTel1;
	private JTextField tTel2;
	private JTextField tTel3;

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
		
		tNom = new JTextField();
		tNom.setBounds(83, 65, 86, 20);
		contentPane.add(tNom);
		tNom.setColumns(10);
		
		tPrenom = new JTextField();
		tPrenom.setBounds(83, 103, 86, 20);
		contentPane.add(tPrenom);
		tPrenom.setColumns(10);
		
		tAdresse = new JTextField();
		tAdresse.setBounds(83, 143, 86, 20);
		contentPane.add(tAdresse);
		tAdresse.setColumns(10);
		
		tCin = new JTextField();
		tCin.setBounds(83, 185, 86, 20);
		contentPane.add(tCin);
		tCin.setColumns(10);
		
		tTel1 = new JTextField();
		tTel1.setBounds(324, 65, 86, 20);
		contentPane.add(tTel1);
		tTel1.setColumns(10);
		
		tTel2 = new JTextField();
		tTel2.setBounds(324, 103, 86, 20);
		contentPane.add(tTel2);
		tTel2.setColumns(10);
		
		tTel3 = new JTextField();
		tTel3.setBounds(324, 143, 86, 20);
		contentPane.add(tTel3);
		tTel3.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int res = JOptionPane.showConfirmDialog(null, "Etes vous sur d'ajouter ce client", "Confirmation", JOptionPane.YES_NO_OPTION);				    
				    if(res == 0){
				    	String nom = tNom.getText().toString();
				    	String prenom = tPrenom.getText().toString();
				    	String adresse = tAdresse.getText().toString();
				    	String cin = tCin.getText().toString();
				    	String tel1 = tTel1.getText().toString();
				    	String tel2 = tTel2.getText().toString();
				    	String tel3 = tTel3.getText().toString();
				    	Client clt = new Client();
				    	creerClient(clt);
				    	Listeclient frameListeClient = new Listeclient();
						frameListeClient.setVisible(true);
				    }else if(res == -1) {
				    	Listeclient frameListeClient = new Listeclient();
						frameListeClient.setVisible(true);
				    }
				
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
