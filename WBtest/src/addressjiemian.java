import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JButton;

import filechuli.filemail;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class addressjiemian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addressjiemian frame = new addressjiemian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public addressjiemian() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(450, 400));
		setBounds(100, 100, 449, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u901A\u8BAF\u5F55");
		lblNewLabel.setBounds(32, 65, 72, 18);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(99, 63, 281, 196);
		textArea.setText(filemail.readaddress().toString());
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[]=new String[0];
				deleteaddress.main(args);
			
			}
		});
		btnNewButton.setBounds(73, 294, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u65B0\u5EFA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[]=new String[0];
				bulidaddress.main(args);
			}
		});
		btnNewButton_1.setBounds(280, 294, 113, 27);
		contentPane.add(btnNewButton_1);
		
		
	}

}
