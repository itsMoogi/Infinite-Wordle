
public class Engine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Control c = new Control();
		GamePanel gp = new GamePanel();
		c.readWordFile("src/wordList");
		gp.setVisible(true);
		gp.setSize(400, 600);
		
		
	}

}
