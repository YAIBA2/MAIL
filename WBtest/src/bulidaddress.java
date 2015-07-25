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


public class bulidaddress extends JFrame {

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
					bulidaddress frame = new bulidaddress();
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
	public bulidaddress() {
		setSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u65B0\u8054\u7CFB\u4EBA\r\n");
		label.setBounds(145, 23, 107, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(43, 71, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D26\u6237\u5730\u5740");
		label_2.setBounds(43, 142, 72, 18);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(123, 68, 231, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 139, 231, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sendname=textField.getText();
				String sendaddress=textField_1.getText();
				try {
					filemail.writeaddress(sendname,sendaddress);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane,"新建成功");
			}
		});
		button.setBounds(160, 196, 113, 27);
		contentPane.add(button);
	}

}
