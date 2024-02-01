import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GamePanel extends JFrame {
	private JPanel cards; 
	private JPanel panel; //game panel
	private JPanel starting; //starting panel
	private JPanel topPanel; private JLabel lblEnterGuess; private JTextField textField; private JButton btnEnter;
	private JPanel bottomPanel; private JLabel lblUsedLetters; private JTextArea textArea;
	private JPanel middlePanel;
	public JPanel guess1container; public JLabel guess1letter1; public JLabel guess1letter2; public JLabel guess1letter3; public JLabel guess1letter4; public JLabel guess1letter5;
	public JPanel guess2container; public JLabel guess2letter1; public JLabel guess2letter2; public JLabel guess2letter3; public JLabel guess2letter4; public JLabel guess2letter5;
	public JPanel guess3container; public JLabel guess3letter1; public JLabel guess3letter2; public JLabel guess3letter3; public JLabel guess3letter4; public JLabel guess3letter5;
	public JPanel guess4container; public JLabel guess4letter1; public JLabel guess4letter2; public JLabel guess4letter3; public JLabel guess4letter4; public JLabel guess4letter5;
	public JPanel guess5container; public JLabel guess5letter1; public JLabel guess5letter2; public JLabel guess5letter3; public JLabel guess5letter4; public JLabel guess5letter5;
	public JPanel guess6container; public JLabel guess6letter1; public JLabel guess6letter2; public JLabel guess6letter3; public JLabel guess6letter4; public JLabel guess6letter5;
	private JButton gameBack;

	private JLabel title; private JPanel startingButtons; private JButton startGame; private JButton openLeaderboard; private JButton openTutorial;
	private JPanel howTo; private JTextArea tutorial; private JButton tutorialBack; 
	private JPanel leaderboard; private JList<String> leaderboardList; private JButton leaderboardBack;
	private String placeholder = "\s\s";

	public String name = "";

	Control control = new Control();
	public static final Color darkGreen = new Color(0, 153, 0);
	public static final Color darkYellow = new Color(255,204,0);

	
	DefaultListModel<String> listModel = new DefaultListModel<>();

	public boolean isOver = false;
	ActionListener guessEntered = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(isOver){
			}
			else if(textField.getText().length() < 5) {
				System.out.println("Must be a 5 letter word");
			} else {
				System.out.println("Guessed: " + textField.getText());
				control.checkWord(textField.getText());
				displayGuess(control.colors, control.guesses);
				writeToUsedLetters();
				if(control.isFinished()){
					//won
					wonGame();
					System.out.println(name);
					control.handleVictory(name, control.guesses);
					control.leaderboardDisplay();
				} else if(control.guesses == 6){
					//lost
					lostGame();
					control.handleLoss(name);
				}
			}
		}
	};

	public void displayGuess(String[] colors, int guess) {
		char[] guessArr = textField.getText().toCharArray();
		switch(guess){
			case 1:
				guess1letter1.setText(guessArr[0] +"");
				if(colors[0].equals("green")){
					guess1letter1.setForeground(darkGreen);
				} else if(colors[0].equals("yellow")){
					guess1letter1.setForeground(darkYellow);
				}

				guess1letter2.setText(guessArr[1] +"");
				if(colors[1].equals("green")){
					guess1letter2.setForeground(darkGreen);
				} else if(colors[1].equals("yellow")){
					guess1letter2.setForeground(darkYellow);
				}

				guess1letter3.setText(guessArr[2] +"");
				if(colors[2].equals("green")){
					guess1letter3.setForeground(darkGreen);
				} else if(colors[2].equals("yellow")){
					guess1letter3.setForeground(darkYellow);
				}

				guess1letter4.setText(guessArr[3] +"");
				if(colors[3].equals("green")){
					guess1letter4.setForeground(darkGreen);
				} else if(colors[3].equals("yellow")){
					guess1letter4.setForeground(darkYellow);
				}

				guess1letter5.setText(guessArr[4] +"");
				if(colors[4].equals("green")){
					guess1letter5.setForeground(darkGreen);
				} else if(colors[4].equals("yellow")){
					guess1letter5.setForeground(darkYellow);
				}
				break;
			case 2:
				guess2letter1.setText(guessArr[0] +"");
				if(colors[0].equals("green")){
					guess2letter1.setForeground(darkGreen);
				} else if(colors[0].equals("yellow")){
					guess2letter1.setForeground(darkYellow);
				}

				guess2letter2.setText(guessArr[1] +"");
				if(colors[1].equals("green")){
					guess2letter2.setForeground(darkGreen);
				} else if(colors[1].equals("yellow")){
					guess2letter2.setForeground(darkYellow);
				}

				guess2letter3.setText(guessArr[2] +"");
				if(colors[2].equals("green")){
					guess2letter3.setForeground(darkGreen);
				} else if(colors[2].equals("yellow")){
					guess2letter3.setForeground(darkYellow);
				}

				guess2letter4.setText(guessArr[3] +"");
				if(colors[3].equals("green")){
					guess2letter4.setForeground(darkGreen);
				} else if(colors[3].equals("yellow")){
					guess2letter4.setForeground(darkYellow);
				}

				guess2letter5.setText(guessArr[4] +"");
				if(colors[4].equals("green")){
					guess2letter5.setForeground(darkGreen);
				} else if(colors[4].equals("yellow")){
					guess2letter5.setForeground(darkYellow);
				}
				break;
			case 3: 
				guess3letter1.setText(guessArr[0] +"");
				if(colors[0].equals("green")){
				guess3letter1.setForeground(darkGreen);
				} else if(colors[0].equals("yellow")){
					guess3letter1.setForeground(darkYellow);
				}

				guess3letter2.setText(guessArr[1] +"");
				if(colors[1].equals("green")){
					guess3letter2.setForeground(darkGreen);
				} else if(colors[1].equals("yellow")){
					guess3letter2.setForeground(darkYellow);
				}

				guess3letter3.setText(guessArr[2] +"");
				if(colors[2].equals("green")){
					guess3letter3.setForeground(darkGreen);
				} else if(colors[2].equals("yellow")){
					guess3letter3.setForeground(darkYellow);
				}

				guess3letter4.setText(guessArr[3] +"");
				if(colors[3].equals("green")){
					guess3letter4.setForeground(darkGreen);
				} else if(colors[3].equals("yellow")){
					guess3letter4.setForeground(darkYellow);
				}

				guess3letter5.setText(guessArr[4] +"");
				if(colors[4].equals("green")){
					guess3letter5.setForeground(darkGreen);
				} else if(colors[4].equals("yellow")){
					guess3letter5.setForeground(darkYellow);
				}
				break;
			case 4: 
				guess4letter1.setText(guessArr[0] +"");
				if(colors[0].equals("green")){
					guess4letter1.setForeground(darkGreen);
				} else if(colors[0].equals("yellow")){
					guess4letter1.setForeground(darkYellow);
				}

				guess4letter2.setText(guessArr[1] +"");
				if(colors[1].equals("green")){
					guess4letter2.setForeground(darkGreen);
				} else if(colors[1].equals("yellow")){
					guess4letter2.setForeground(darkYellow);
				}

				guess4letter3.setText(guessArr[2] +"");
				if(colors[2].equals("green")){
					guess4letter3.setForeground(darkGreen);
				} else if(colors[2].equals("yellow")){
					guess4letter3.setForeground(darkYellow);
				}

				guess4letter4.setText(guessArr[3] +"");
				if(colors[3].equals("green")){
					guess4letter4.setForeground(darkGreen);
				} else if(colors[3].equals("yellow")){
					guess4letter4.setForeground(darkYellow);
				}

				guess4letter5.setText(guessArr[4] +"");
				if(colors[4].equals("green")){
					guess4letter5.setForeground(darkGreen);
				} else if(colors[4].equals("yellow")){
					guess4letter5.setForeground(darkYellow);
				}
				break;
			case 5:
				guess5letter1.setText(guessArr[0] +"");
				if(colors[0].equals("green")){
					guess5letter1.setForeground(darkGreen);
				} else if(colors[0].equals("yellow")){
					guess5letter1.setForeground(darkYellow);
				}

				guess5letter2.setText(guessArr[1] +"");
				if(colors[1].equals("green")){
					guess5letter2.setForeground(darkGreen);
				} else if(colors[1].equals("yellow")){
					guess5letter2.setForeground(darkYellow);
				}

				guess5letter3.setText(guessArr[2] +"");
				if(colors[2].equals("green")){
					guess5letter3.setForeground(darkGreen);
				} else if(colors[2].equals("yellow")){
					guess5letter3.setForeground(darkYellow);
				}

				guess5letter4.setText(guessArr[3] +"");
				if(colors[3].equals("green")){
					guess5letter4.setForeground(darkGreen);
				} else if(colors[3].equals("yellow")){
					guess5letter4.setForeground(darkYellow);
				}

				guess5letter5.setText(guessArr[4] +"");
				if(colors[4].equals("green")){
					guess5letter5.setForeground(darkGreen);
				} else if(colors[4].equals("yellow")){
					guess5letter5.setForeground(darkYellow);
				}
				break;
			case 6:
				guess6letter1.setText(guessArr[0] +"");
				if(colors[0].equals("green")){
					guess6letter1.setForeground(darkGreen);
				} else if(colors[0].equals("yellow")){
					guess6letter1.setForeground(darkYellow);
				}

				guess6letter2.setText(guessArr[1] +"");
				if(colors[1].equals("green")){
					guess6letter2.setForeground(darkGreen);
				} else if(colors[1].equals("yellow")){
					guess6letter2.setForeground(darkYellow);
				}

				guess6letter3.setText(guessArr[2] +"");
				if(colors[2].equals("green")){
					guess6letter3.setForeground(darkGreen);
				} else if(colors[2].equals("yellow")){
					guess6letter3.setForeground(darkYellow);
				}

				guess6letter4.setText(guessArr[3] +"");
				if(colors[3].equals("green")){
					guess6letter4.setForeground(darkGreen);
				} else if(colors[3].equals("yellow")){
					guess6letter4.setForeground(darkYellow);
				}

				guess6letter5.setText(guessArr[4] +"");
				if(colors[4].equals("green")){
					guess6letter5.setForeground(darkGreen);
				} else if(colors[4].equals("yellow")){
					guess6letter5.setForeground(darkYellow);
				}
				break;
			default:
				break;

		}
	}

	public void writeToUsedLetters() {
		textArea.setText(control.usedLettersToString());
	}

	public void wonGame() {
		isOver = true;
		name = JOptionPane.showInputDialog(this, "You successfully guessed the word in " + control.guesses +
		" guesses. Enter your name to be displayed on the leaderboard.", "Game Won", JOptionPane.INFORMATION_MESSAGE);

	}

	public void lostGame() {
		isOver = true;
		name = JOptionPane.showInputDialog(this, "You were unble to guess the word in 6 guesses. Enter your name to be displayed on the leaderboard.", "Game Lost", JOptionPane.INFORMATION_MESSAGE);

	}

	public void displayLeaderboard() {
		listModel.clear();
		ArrayList<String> values = control.leaderboardDisplay();
		for(String value : values){
			listModel.addElement("<html><pre>" + value + "</pre></html>");
		}
		System.out.println(listModel);
	}


	public GamePanel() {
		setTitle("Infinite Wordle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		this.add(cards);

		GridBagConstraints c = new GridBagConstraints();
		starting = new JPanel();
		starting.setPreferredSize(new Dimension(400, 600));
		starting.setLayout(new GridBagLayout());
		title = new JLabel("Infinite Wordle");
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 0;
		starting.add(title, c);

		startingButtons = new JPanel();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		starting.add(startingButtons, c);
		startGame = new JButton("Start Game"); openLeaderboard = new JButton("Leaderboard"); openTutorial = new JButton("How to Play");
		startingButtons.add(startGame); startingButtons.add(openLeaderboard); startingButtons.add(openTutorial); 

		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) cards.getLayout();
				c1.show(cards, "gamePanel");
				
				control.guesses = 0;
				control.readWordFile("CS410 Partner Program/src/wordList");
				control.pickWord(control.words);
			}
		});

		openLeaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) cards.getLayout();
				c1.show(cards, "leaderboard");
				control.leaderboardDisplay();
				displayLeaderboard();
			}
		});

		openTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) cards.getLayout();
				c1.show(cards, "howTo");
			}
		});

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 600));
		getContentPane().add(panel);

		howTo = new JPanel(new GridBagLayout());
		howTo.setPreferredSize(new Dimension(100, 600));
		tutorial = new JTextArea("Infinite Wordle is a word puzzle game where you are given 6 tries to guess a random 5-letter word. "
								+ "Each guess you are given hints in the form of the color of the letters. Grey means that letter is not found in the word, "
								+ "yellow means that letter is found in the word, but not in that spot, and green means that letter is found in the word and in that spot.");
		
		tutorial.setSize(300, 400);
		tutorial.setLineWrap(true); tutorial.setWrapStyleWord(true); tutorial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tutorialBack = new JButton("Back");	
		tutorialBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) cards.getLayout();
				c1.first(cards);
			}
		});					
		howTo.add(tutorialBack, c);
		c.gridy = 0; c.fill = GridBagConstraints.HORIZONTAL;
		howTo.add(tutorial, c);

		leaderboard = new JPanel(new GridBagLayout());
		leaderboardBack = new JButton("Back");
		
		leaderboardList = new JList<>();
		leaderboardList.setModel(listModel);
		leaderboardList.setSize(400, 200);
		leaderboardList.setFixedCellHeight(20); leaderboardList.setFixedCellWidth(300);
		leaderboardBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) cards.getLayout();
				c1.first(cards);
			}
		});

		c.gridx = 0; c.gridy = 1; c.fill = GridBagConstraints.CENTER;
		leaderboard.add(leaderboardBack, c);

		
		c.gridx = 0; c.gridy = 0; c.fill = GridBagConstraints.CENTER;
		leaderboard.add(leaderboardList, c);
		

		cards.add(starting);
		cards.add(howTo, "howTo");
		cards.add(leaderboard, "leaderboard");
		cards.add(panel, "gamePanel");
		
		
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
		btnEnter.addActionListener(guessEntered);
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
		textArea.setLineWrap(true); textArea.setWrapStyleWord(true);
		textArea.setTabSize(5);
		textArea.setRows(2);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setColumns(13);
		bottomPanel.add(textArea);

		gameBack = new JButton("Back");
		bottomPanel.add(gameBack);
		gameBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) cards.getLayout();
				c1.first(cards);
			}
		});


		
	}
}
