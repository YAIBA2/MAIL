import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import RSA.RSAUtils;
import filechuli.xmlbuild;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class mailjiemian extends JFrame {

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
					mailjiemian frame = new mailjiemian();
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
	public mailjiemian() {
		setSize(new Dimension(452, 449));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6536\u4EF6\u4EBA");
		lblNewLabel.setBounds(38, 41, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 38, 290, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E3B\u9898");
		lblNewLabel_1.setBounds(38, 112, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 109, 290, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5185\u5BB9");
		lblNewLabel_2.setBounds(38, 185, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(97, 185, 290, 131);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u9644\u4EF6");
		btnNewButton.setBounds(38, 344, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D1\u9001");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String outfile = "E://邮箱/发送邮件/mail.xml"; 
				String sendname=textField.getText();
				String topic=textField_1.getText();
				String mail=textArea.getText();
				try {
					RSAUtils.builtKey();
					String cipherText = RSAUtils.encrypt(mail, 
							RSAUtils.getPublicKey());
					xmlbuild.writeXMLFile(outfile,sendname,topic,cipherText); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				JOptionPane.showMessageDialog(contentPane,"发送成功");
			
			}
		});
		btnNewButton_1.setBounds(274, 344, 113, 27);
		contentPane.add(btnNewButton_1);
	}
}
