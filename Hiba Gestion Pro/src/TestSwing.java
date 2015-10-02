import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.FabriqueSession;
import model.Client;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestSwing extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwing frame = new TestSwing();
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
	public TestSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 445);
		getContentPane().setLayout(null);
		
		JLabel lblHibaGestionPro = new JLabel("HIBA GESTION PRO");
		lblHibaGestionPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblHibaGestionPro.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHibaGestionPro.setBounds(130, 11, 220, 14);
		getContentPane().add(lblHibaGestionPro);
		
		JButton btnListeDesClients = new JButton("Liste des clients");
		btnListeDesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showOptionDialog(null, "le Client à été ajouté avec succés", "Confirmation", JOptionPane.DEFAULT_OPTION,
				        JOptionPane.INFORMATION_MESSAGE, null, null, null);
//if res = 0 alors l'utilisateur à clicker sur le button ok
//if res = -1 alors l'utilisatuer à fermer le popup
				System.out.println(res);
			}
		});
		btnListeDesClients.setBounds(49, 110, 144, 39);
		getContentPane().add(btnListeDesClients);
		
		JButton btnAjouterClient = new JButton("Ajouter Client");
		btnAjouterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    int res = JOptionPane.showConfirmDialog(null, "Etes vous sur de supprimer ce client", "Confirmation", JOptionPane.YES_NO_OPTION);
			    System.out.println(res);
//			    Client clt = new Client();
//			    clt.setNom("robij");
//			    creerClient(clt);
			  //if res = 0 alors l'utilisateur à clicker sur le button ok
			  //if res = -1 alors l'utilisatuer à fermer le popup
			    // if res = 1 alors l'utilisatuer a clicker sur le button annuler
			}
		});
		btnAjouterClient.setBounds(293, 110, 125, 39);
		getContentPane().add(btnAjouterClient);
		
	}
	

	

}
