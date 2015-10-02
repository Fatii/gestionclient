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
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;

import model.Client;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.FabriqueSession;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _Listeclient extends JFrame {

	private JPanel contentPane;
	private JTable tableau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_Listeclient frame = new _Listeclient();
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
	public _Listeclient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Liste des clients");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(260, 35, 144, 28);
		contentPane.add(label);
		
		JButton button = new JButton("Retour");
		button.setBounds(140, 270, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.setBounds(252, 270, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableau.getSelectedRow() != -1)
				System.out.println(tableau.getValueAt(tableau.getSelectedRow(), 3));
			}
		});
		button_2.setBounds(351, 270, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Ajouter");
		button_3.setBounds(465, 270, 89, 23);
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
       
     JScrollPane scrollPane = new JScrollPane(tableau);
     scrollPane.setBounds(54, 74, 531, 185);
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
}
