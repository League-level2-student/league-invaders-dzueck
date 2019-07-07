import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gamePanel;
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	LeagueInvaders(){
		frame = new JFrame();
		

		gamePanel = new GamePanel();
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(gamePanel);
	}
	public static void main(String[] args) {
		LeagueInvaders runner = new LeagueInvaders();
		runner.setup();
	}
}
//http://central.jointheleague.org/levels/Level2/InvadersOverview.html