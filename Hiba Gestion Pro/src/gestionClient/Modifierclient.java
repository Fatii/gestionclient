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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modifierclient extends JFrame {

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
					Modifierclient frame = new Modifierclient();
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
	public Modifierclient() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifierClient = new JLabel("Modifier client");
		lblModifierClient.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblModifierClient.setForeground(Color.RED);
		lblModifierClient.setBounds(133, 11, 141, 38);
		contentPane.add(lblModifierClient);
		
		JLabel label = new JLabel("T\u00E9l\u00E9phone 1 :");
		label.setBounds(232, 63, 79, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(321, 60, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(321, 98, 86, 20);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("T\u00E9l\u00E9phone 2 :");
		label_1.setBounds(232, 101, 79, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("T\u00E9l\u00E9phone 3 :");
		label_2.setBounds(232, 141, 79, 14);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(321, 138, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(80, 180, 86, 20);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("CIN :");
		label_3.setBounds(24, 183, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Adresse :");
		label_4.setBounds(24, 141, 46, 14);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(80, 138, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(80, 98, 86, 20);
		contentPane.add(textField_5);
		
		JLabel label_5 = new JLabel("Pr\u00E9nom :");
		label_5.setBounds(24, 101, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Nom :");
		label_6.setBounds(24, 63, 46, 14);
		contentPane.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(80, 60, 86, 20);
		contentPane.add(textField_6);
		
		JButton btnEnregistrerLesModifications = new JButton("Enregistrer");
		btnEnregistrerLesModifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listeclient frameListeClient = new Listeclient();
				frameListeClient.setVisible(true);
			}
		});
		btnEnregistrerLesModifications.setBounds(255, 211, 121, 23);
		contentPane.add(btnEnregistrerLesModifications);
	}

}
