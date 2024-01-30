import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Control {
	
	private int guesses = 0;
	private String[] words;
	private String[] playerNames;
	private int[] gamesPlayed;
	private int[] totalNumberOfGuesses;
	private double[] average;
	
	
	public void readWordFile(String fileName) {
		words = new String[99];
		try
		(BufferedReader br = new BufferedReader(new FileReader (fileName));)
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				words[i] = line;
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readPlayerFile(String fileName) {
		playerNames = new String[99];
		gamesPlayed = new int[99];
		totalNumberOfGuesses = new int[99];
		average = new double[99];
		try
		(BufferedReader br = new BufferedReader(new FileReader (fileName));)
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				playerNames[i] = st.nextToken();
				if (st.hasMoreTokens()) {
					gamesPlayed[i] = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					totalNumberOfGuesses[i] = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					average[i] = totalNumberOfGuesses[i] / gamesPlayed[i];
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeScoresToFile(String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter (fileName));
			int i = 0;
			while(!playerNames[i].equals(null)) {
				bw.write(playerNames[i] + "\t" + gamesPlayed[i] + "\t" + totalNumberOfGuesses[i] + "\t" + average[i] + "\n");
				i++;
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String pickWord(String[] list) {
		int randInt = (int) ((Math.random() * list.length));
		String word = list[randInt];
		return word;
	}
	
	public String[] checkWord(String guess, String answer) {
		String[] colors = new String[answer.length()];
		for (int i = 0; i < answer.length(); i++) {
			for (int j = 0; j < guess.length(); j++) {
				if (guess.charAt(j) == answer.charAt(i) && (i == j)) {
					colors[j] = "green";
				} else if (guess.charAt(j) == answer.charAt(i) && (i != j)) {
					colors[j] = "yellow";
				} else {
					colors[j] = "grey";
				}
			}
		}
		guesses++;
		return colors;
	}
	
	public String message() {
		if (guesses == 1) {
			return "Great guess!";
		} else if (guesses == 2) {
			return "Incredible!";
		} else if (guesses == 3) {
			return "Great job!";
		} else if (guesses == 4) {
			return "Nice!";
		} else if (guesses == 5) {
			return "Good!";
		} else if (guesses == 6) {
			return "Close one!";
		} else {
			return "Better luck next time!";
		}
	}

}
