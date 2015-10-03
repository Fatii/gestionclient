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
import javax.swing.JTextArea;

public class Modifierclient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setBounds(100, 100, 652, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifierClient = new JLabel("Modifier client");
		lblModifierClient.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModifierClient.setForeground(Color.RED);
		lblModifierClient.setBounds(231, 11, 187, 38);
		contentPane.add(lblModifierClient);
		
		JButton btnEnregistrerLesModifications = new JButton("Enregistrer");
		btnEnregistrerLesModifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listeclient frameListeClient = new Listeclient();
				frameListeClient.setVisible(true);
			}
		});
		btnEnregistrerLesModifications.setBounds(395, 234, 97, 23);
		contentPane.add(btnEnregistrerLesModifications);
		
		JLabel label = new JLabel("Nom :");
		label.setBounds(24, 60, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Pr\u00E9nom :");
		label_1.setBounds(24, 98, 59, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Adresse :");
		label_2.setBounds(24, 138, 59, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("CIN :");
		label_3.setBounds(24, 270, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("T\u00E9l\u00E9phone 1 :");
		label_4.setBounds(370, 63, 79, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("T\u00E9l\u00E9phone 2 :");
		label_5.setBounds(370, 101, 79, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("T\u00E9l\u00E9phone 3 :");
		label_6.setBounds(370, 141, 79, 14);
		contentPane.add(label_6);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 60, 187, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(106, 98, 187, 20);
		contentPane.add(textField_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(106, 133, 187, 124);
		contentPane.add(textArea);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 267, 187, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(459, 60, 154, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(459, 98, 154, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(459, 138, 154, 20);
		contentPane.add(textField_5);
	}
}
