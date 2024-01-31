import java.awt.Graphics;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JFrame {
	private JPanel panel;
	private JPanel topPanel;
	private JLabel lblEnterGuess;
	private JTextField textField;
	private JPanel bottomPanel;
	private JLabel lblUsedLetters;
	private JTextArea textArea;
	private JPanel middlePanel;
	private JPanel guess1container;
	private JLabel guess1letter1;
	private JLabel guess1letter2;
	private JLabel guess1letter3;
	private JLabel guess1letter4;
	private JLabel guess1letter5;
	private JPanel guess2container;
	private JLabel guess2letter1;
	private JLabel guess2letter2;
	private JLabel guess2letter3;
	private JLabel guess2letter4;
	private JLabel guess2letter5;
	private JPanel guess3container;
	private JLabel guess3letter1;
	private JLabel guess3letter2;
	private JLabel guess3letter3;
	private JLabel guess3letter4;
	private JLabel guess3letter5;
	private JPanel guess4container;
	private JLabel guess4letter1;
	private JLabel guess4letter2;
	private JLabel guess4letter3;
	private JLabel guess4letter4;
	private JLabel guess4letter5;
	private JPanel guess5container;
	private JLabel guess5letter1;
	private JLabel guess5letter2;
	private JLabel guess5letter3;
	private JLabel guess5letter4;
	private JLabel guess5letter5;
	private JPanel guess6container;
	private JLabel guess6letter1;
	private JLabel guess6letter2;
	private JLabel guess6letter3;
	private JLabel guess6letter4;
	private JLabel guess6letter5;
	private JButton btnEnter;
	private String placeholder = "\s\s";
	
	public GamePanel() {
		setTitle("Infinite Wordle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 600));
		getContentPane().add(panel);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		topPanel = new JPanel();
		panel.add(topPanel);
		
		lblEnterGuess = new JLabel("Enter your guess (5 letters):");
		lblEnterGuess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		topPanel.add(lblEnterGuess);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(5);
		topPanel.add(textField);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		topPanel.add(btnEnter);
		
		middlePanel = new JPanel();
		middlePanel.setForeground(Color.GRAY);
		middlePanel.setBorder(null);
		middlePanel.setBackground(Color.GRAY);
		panel.add(middlePanel);
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		
		guess1container = new JPanel();
		guess1container.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.add(guess1container);
		
		guess1letter1 = new JLabel(placeholder);
		guess1letter1.setHorizontalAlignment(SwingConstants.CENTER);
		guess1letter1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess1letter1.setBackground(Color.WHITE);
		guess1container.add(guess1letter1);
		
		guess1letter2 = new JLabel(placeholder);
		guess1letter2.setHorizontalAlignment(SwingConstants.CENTER);
		guess1letter2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess1letter2.setBackground(Color.WHITE);
		guess1container.add(guess1letter2);
		
		guess1letter3 = new JLabel(placeholder);
		guess1letter3.setHorizontalAlignment(SwingConstants.CENTER);
		guess1letter3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess1letter3.setBackground(Color.WHITE);
		guess1container.add(guess1letter3);
		
		guess1letter4 = new JLabel(placeholder);
		guess1letter4.setHorizontalAlignment(SwingConstants.CENTER);
		guess1letter4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess1letter4.setBackground(Color.WHITE);
		guess1container.add(guess1letter4);
		
		guess1letter5 = new JLabel(placeholder);
		guess1letter5.setHorizontalAlignment(SwingConstants.CENTER);
		guess1letter5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess1letter5.setBackground(Color.WHITE);
		guess1container.add(guess1letter5);
		
		guess2container = new JPanel();
		guess2container.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.add(guess2container);
		
		guess2letter1 = new JLabel(placeholder);
		guess2letter1.setForeground(Color.BLACK);
		guess2letter1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess2letter1.setBackground(Color.WHITE);
		guess2container.add(guess2letter1);
		
		guess2letter2 = new JLabel(placeholder);
		guess2letter2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess2container.add(guess2letter2);
		
		guess2letter3 = new JLabel(placeholder);
		guess2letter3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess2container.add(guess2letter3);
		
		guess2letter4 = new JLabel(placeholder);
		guess2letter4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess2container.add(guess2letter4);
		
		guess2letter5 = new JLabel(placeholder);
		guess2letter5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess2container.add(guess2letter5);
		
		guess3container = new JPanel();
		guess3container.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.add(guess3container);
		
		guess3letter1 = new JLabel(placeholder);
		guess3letter1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess3container.add(guess3letter1);
		
		guess3letter2 = new JLabel(placeholder);
		guess3letter2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess3container.add(guess3letter2);
		
		guess3letter3 = new JLabel(placeholder);
		guess3letter3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess3container.add(guess3letter3);
		
		guess3letter4 = new JLabel(placeholder);
		guess3letter4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess3container.add(guess3letter4);
		
		guess3letter5 = new JLabel(placeholder);
		guess3letter5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess3container.add(guess3letter5);
		
		guess4container = new JPanel();
		guess4container.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.add(guess4container);
		
		guess4letter1 = new JLabel(placeholder);
		guess4letter1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess4container.add(guess4letter1);
		
		guess4letter2 = new JLabel(placeholder);
		guess4letter2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess4container.add(guess4letter2);
		
		guess4letter3 = new JLabel(placeholder);
		guess4letter3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess4container.add(guess4letter3);
		
		guess4letter4 = new JLabel(placeholder);
		guess4letter4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess4container.add(guess4letter4);
		
		guess4letter5 = new JLabel(placeholder);
		guess4letter5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess4container.add(guess4letter5);
		
		guess5container = new JPanel();
		guess5container.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.add(guess5container);
		
		guess5letter1 = new JLabel(placeholder);
		guess5letter1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess5container.add(guess5letter1);
		
		guess5letter2 = new JLabel(placeholder);
		guess5letter2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess5container.add(guess5letter2);
		
		guess5letter3 = new JLabel(placeholder);
		guess5letter3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess5container.add(guess5letter3);
		
		guess5letter4 = new JLabel(placeholder);
		guess5letter4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess5container.add(guess5letter4);
		
		guess5letter5 = new JLabel(placeholder);
		guess5letter5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess5container.add(guess5letter5);
		
		guess6container = new JPanel();
		guess6container.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.add(guess6container);
		
		guess6letter1 = new JLabel(placeholder);
		guess6letter1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess6container.add(guess6letter1);
		
		guess6letter2 = new JLabel(placeholder);
		guess6letter2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess6container.add(guess6letter2);
		
		guess6letter3 = new JLabel(placeholder);
		guess6letter3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess6container.add(guess6letter3);
		
		guess6letter4 = new JLabel(placeholder);
		guess6letter4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess6container.add(guess6letter4);
		
		guess6letter5 = new JLabel(placeholder);
		guess6letter5.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess6container.add(guess6letter5);
		
		bottomPanel = new JPanel();
		panel.add(bottomPanel);
		
		lblUsedLetters = new JLabel("Letters used:");
		lblUsedLetters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottomPanel.add(lblUsedLetters);
		
		textArea = new JTextArea();
		textArea.setTabSize(5);
		textArea.setRows(2);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setColumns(13);
		bottomPanel.add(textArea);

	}
}
