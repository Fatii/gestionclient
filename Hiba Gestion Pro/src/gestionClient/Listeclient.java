package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.FabriqueSession;
import model.Client;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;

public class Listeclient extends JFrame {

	private JPanel contentPane;
	private JTable tableau;

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
		setTitle("Liste des Clients");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Liste des clients");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(284, 29, 144, 28);
		contentPane.add(label);
		
		JButton button = new JButton("Retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frameMenu = new Menu();
				frameMenu.setVisible(true);
			}
		});
		button.setBounds(186, 253, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modifierclient frameModifierClient = new Modifierclient();
				frameModifierClient.setVisible(true);
			}
		});
		button_1.setBounds(298, 253, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableau.getSelectedRow() != -1) {
				Client clt = new Client();
				clt.setCin((String)tableau.getValueAt(tableau.getSelectedRow(), 3));
				SupprimerClient(clt);
			}
			}
		});
		button_2.setBounds(397, 253, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Ajouter");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajoutclient frameAjoutClient = new Ajoutclient();
				frameAjoutClient.setVisible(true);
			}
		});
		button_3.setBounds(511, 253, 89, 23);
		contentPane.add(button_3);
		
		int i=0;
		String[] entetes = {"Nom", "Prénom", "Adresse", "CIN", "Téléphone"};
		Object[][] donnees = new Object[listerClient().size()][entetes.length];
		for (Iterator iter = listerClient().iterator(); iter.hasNext();) {
		Client clt = (Client) iter.next();
		donnees[i][0] = clt.getNom();
		donnees[i][1] = clt.getPrenom();
		donnees[i][2] = clt.getAdresse();
		donnees[i][3] = clt.getCin();
		donnees[i][4] = clt.getTel1();
		i++;
		}
		
		 tableau = new JTable(donnees, entetes);
		 tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//       Ajouter lentete
       contentPane.add(tableau.getTableHeader(), BorderLayout.NORTH);
       contentPane.setLayout(null);
       
//     Ajouter les données
     JScrollPane scrollPane = new JScrollPane(tableau);
     scrollPane.setBounds(10, 82, 681, 134);
     contentPane.add(scrollPane);
	}
	
	private static List listerClient() {
		Transaction tx = null;
		Session session = FabriqueSession.getInstance().getCurrentSession();
		List clients = null;
		try {
			tx = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("select * from client");
			sqlQuery.addEntity(Client.class);
			clients = sqlQuery.list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					tx.rollback();
				} catch (HibernateException e1) {
					e.printStackTrace();
				}
				throw e;
			}
		}
		return clients;
	}
	
	private static void SupprimerClient(Client clt) {
		Transaction tx = null;
		Session session = FabriqueSession.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.delete(clt);
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
