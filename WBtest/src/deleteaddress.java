import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import filechuli.filemail;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class deleteaddress extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteaddress frame = new deleteaddress();
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
	public deleteaddress() {
		setSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5220\u9664\u8054\u7CFB\u4EBA");
		label.setBounds(157, 32, 100, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(45, 81, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D26\u6237\u5730\u5740");
		label_2.setBounds(45, 148, 72, 18);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(131, 78, 203, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 145, 203, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sendname=textField.getText();
				String sendaddress=textField_1.getText();
				try {
					filemail.deleteaddress(sendname,sendaddress);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane,"É¾³ý³É¹¦");
				
			}
		});
		button.setBounds(144, 196, 113, 27);
		contentPane.add(button);
	}

}
