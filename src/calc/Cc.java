package calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cc extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValue1;
	private JTextField txtValue2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cc frame = new Cc();
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
	public Cc() {
		this.setTitle("Java calculator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 126);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(12, 48, 97, 25);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(121, 48, 97, 25);
		contentPane.add(btnMinus);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setBounds(230, 48, 97, 25);
		contentPane.add(btnDivide);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setBounds(339, 48, 97, 25);
		contentPane.add(btnMultiply);
		
		txtValue1 = new JTextField();
		txtValue1.setBounds(12, 13, 63, 22);
		contentPane.add(txtValue1);
		txtValue1.setColumns(10);
		
		final JLabel lblInputDisplay = new JLabel("+");
		lblInputDisplay.setBounds(79, 16, 78, 16);
		contentPane.add(lblInputDisplay);
		
		JButton btnEquals = new JButton("=");
		btnEquals.setBounds(169, 10, 97, 25);
		contentPane.add(btnEquals);
		
		final JLabel lblAns = new JLabel("");
		lblAns.setBounds(278, 13, 97, 22);
		contentPane.add(lblAns);
		
		txtValue2 = new JTextField();
		txtValue2.setColumns(10);
		txtValue2.setBounds(94, 13, 63, 22);
		contentPane.add(txtValue2);
		
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInputDisplay.setText("+");
			}
		});
		
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInputDisplay.setText("-");
			}
		});
		
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInputDisplay.setText("*");
			}
		});
		
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInputDisplay.setText("/");
			}
		});
		
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int firstNum = 0;
				int secondNum = 0;
				int Answer = 0;
				String sign = lblInputDisplay.getText();
				
				if (isInteger(txtValue1.getText())){
					firstNum = Integer.parseInt(txtValue1.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please only numbers","error in first textbox", 0);
					txtValue1.setText("");
					txtValue2.setText("");
				}
				
				if (isInteger(txtValue2.getText())){
					secondNum = Integer.parseInt(txtValue2.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please only numbers","error in second textbox", 0);
					txtValue1.setText("");
					txtValue2.setText("");
				}
				
				
				switch (sign) {
				case "+":
					Answer = firstNum + secondNum;
					break;
				case "-":
					Answer = firstNum - secondNum;
					break;
				case "*":
					Answer = firstNum * secondNum;
					break;
				case "/":
					Answer = firstNum / secondNum;
					break;
				}
				
				lblAns.setText(String.valueOf(Answer));
				txtValue1.setText("");
				txtValue2.setText("");
			}
		});
			
	}
	
	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c <= '/' || c >= ':') {
				return false;
			}
		}
		return true;
	}
}
