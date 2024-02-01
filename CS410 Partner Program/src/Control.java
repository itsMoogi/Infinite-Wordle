import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class Control {
	
	public int guesses = 0;
	public String word = "";
	public String[] colors = new String[5];
	ArrayList<String> words = new ArrayList<>();
	ArrayList<Character> usedLetters = new ArrayList<>();
	ArrayList<String> playerNames = new ArrayList<>();
	ArrayList<Integer> gamesPlayed = new ArrayList<>();
	ArrayList<Integer> totalNumberOfGuesses = new ArrayList<>();
	ArrayList<Double> average = new ArrayList<>();

	ArrayList<String[]> leaderBoard = new ArrayList<>(); 

	String leaderboardFile = "CS410 Partner Program/src/leaderboard.txt";
	
	
	public void readWordFile(String fileName) {
		if(words.size() > 0) {
			words.clear();
		}
		try
		(BufferedReader br = new BufferedReader(new FileReader (fileName));)
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				words.add(line);
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
		playerNames.clear(); gamesPlayed.clear(); totalNumberOfGuesses.clear(); average.clear();
		System.out.println(average);
		try
		(BufferedReader br = new BufferedReader(new FileReader (fileName));)
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("\t");
				String[] split = arr[0].split("   ");
				playerNames.add(arr[0]);
				gamesPlayed.add(Integer.parseInt(arr[1]));
				totalNumberOfGuesses.add(Integer.parseInt(arr[2]));
				average.add(Double.parseDouble(arr[3]));
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
			for(String name : playerNames) {
				int i = playerNames.indexOf(name);
				bw.write(playerNames.get(i) + "\t" + gamesPlayed.get(i) + "\t" + totalNumberOfGuesses.get(i) + "\t" + average.get(i) + "\n");
				System.out.println(average);
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pickWord(ArrayList<String> list) {
		Random rand = new Random();
		int randInt = rand.nextInt(0, 100);
		word = list.get(randInt);
		System.out.println(word + " " + randInt);
	}
	
	public void checkWord(String guess) {
		clearColors();
		System.out.println("j   i");
		char[] guessChars = guess.toCharArray();
		usedLetters(guessChars);
		char[] wordChars = word.toCharArray();
		for(int i = 0 ; i < wordChars.length; i++) {

			for(int j = 0; j < guessChars.length; j++) {

				if(wordChars[i] == guessChars[j]){

					if(i == j){
						colors[j] = "green";
					} else if(!colors[j].equals("green")){
						colors[j] = "yellow";
					}
				}
				System.out.println(j + " " + guess.charAt(j) + " " + i + " " + word.charAt(i) + " " + colors[j]);
			}
		}
		guesses++;
	}

	public void usedLetters(char[] chars) {
		for(char temp : chars) {
			if(!usedLetters.contains(temp)) {
				usedLetters.add(temp);
			}
		}
	}

	public String usedLettersToString() {
		String output = "";
		for(char temp : usedLetters) {
			output = output + temp + ", ";
		}
		return output;
	}

	public void clearColors() {
		for(int i = 0; i < colors.length; i++){
			colors[i] = "grey";
		}
	}

	public ArrayList<String> leaderboardDisplay() {
		readPlayerFile(leaderboardFile);
		ArrayList<String> output = new ArrayList<>();
		output.add("Rank\tName\t# of Games\tAverage");

		HashMap<String, Double> avgHash = new HashMap<>();
		for(String name : playerNames){
			int index = playerNames.indexOf(name);
			avgHash.put(name, average.get(index));
		}

		List<Map.Entry<String, Double> > list =
               new LinkedList<Map.Entry<String, Double> >(avgHash.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1, 
                               Map.Entry<String, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
		int i = 1;
		for(Map.Entry<String, Double> column : list){
			int index = playerNames.indexOf(column.getKey());
			output.add(i + "\t" + column.getKey() + "\t" + totalNumberOfGuesses.get(index) + "\t\t" + column.getValue());
			i++;
		}
		
		for(String line : output) {
			System.out.println(line);
		}
		return output;
	}
	
	

	public boolean isFinished() {
		for(String color : colors) {
			if(!color.equals("green")){
				return false;
			}
		} 
		return true;
	}

	public void handleVictory(String name, int score) {
		readPlayerFile(leaderboardFile);
		if (playerNames.contains(name)) {
			int index = playerNames.indexOf(name);
			gamesPlayed.set(index, gamesPlayed.get(index) + 1);
			totalNumberOfGuesses.set(index, totalNumberOfGuesses.get(index) + score);
			double avg = (double) totalNumberOfGuesses.get(index) / gamesPlayed.get(index);
			System.out.println(avg);
			average.set(index, avg);
		} else {
			playerNames.add(name);
			gamesPlayed.add(1);
			totalNumberOfGuesses.add(score);
			average.add((double) score);
		}

		writeScoresToFile(leaderboardFile);
	}

	public void handleLoss(String name) {
		readPlayerFile(leaderboardFile);
		if (playerNames.contains(name)) {
			int index = playerNames.indexOf(name);
			gamesPlayed.set(index, gamesPlayed.get(index) + 1);
			totalNumberOfGuesses.set(index, totalNumberOfGuesses.get(index) + 7);
			average.add((double) ((double) totalNumberOfGuesses.get(index) / (double) gamesPlayed.get(index)));
		} else {
			playerNames.add(name);
			gamesPlayed.add(1);
			totalNumberOfGuesses.add(7);
			average.add((double) 7);
		}

		writeScoresToFile(leaderboardFile);
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
