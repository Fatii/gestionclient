package gestionClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		Object[][] donnees = {
                {"stouti", "yassine"},
                {"halabi", "fatima"}
        };
        String[] entetes = {"Nom", "Prénom"};
        JTable tableau = new JTable(donnees, entetes);
//        Ajouter lentete
        contentPane.add(tableau.getTableHeader(), BorderLayout.NORTH);
//        Ajouter les données
        contentPane.add(tableau, BorderLayout.CENTER);
	}

}
