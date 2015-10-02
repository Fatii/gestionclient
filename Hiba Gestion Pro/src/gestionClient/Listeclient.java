package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frameMenu = new Menu();
				frameMenu.setVisible(true);
			}
		});
		button.setBounds(10, 217, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modifierclient frameModifierClient = new Modifierclient();
				frameModifierClient.setVisible(true);
			}
		});
		button_1.setBounds(122, 217, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.setBounds(221, 217, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Ajouter");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajoutclient frameAjoutClient = new Ajoutclient();
				frameAjoutClient.setVisible(true);
			}
		});
		button_3.setBounds(335, 217, 89, 23);
		contentPane.add(button_3);
		
		int i=0;
		String[] entetes = {"Nom", "Prenom", "Adresse", "CIN", "Téléphone"};
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
		
//		Object[][] donnees = {
//                {"stouti"},
//                {"stouti"},
//                {"halabi"},
//                {"stouti"},
//                {"halabi"}
//        };
//		
//		String[] entetes = {"Nom"};
		
		 JTable tableau = new JTable(donnees, entetes);
//       Ajouter lentete
       contentPane.add(tableau.getTableHeader(), BorderLayout.NORTH);
       contentPane.setLayout(null);
       
//     Ajouter les données
     JScrollPane scrollPane = new JScrollPane(tableau);
     scrollPane.setBounds(10, 82, 681, 236);
     contentPane.add(scrollPane);
	}
}
