import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font normalFont;
    Timer frameDraw;
    Rocketship rocketship = new Rocketship(250,700, 50, 50);
    ObjectManager objectManager = new ObjectManager(rocketship);
    Timer alienSpawn;
    
    GamePanel(){
    	titleFont = new Font("Arial", Font.PLAIN, 46);
    	normalFont = new Font("Arial", Font.PLAIN, 20);
    	frameDraw = new Timer(1000/60,this);
    	frameDraw.start();
    }

	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU) {
			drawMenuState(g);
		}
		else if(currentState == GAME) {
			drawGameState(g);
		}
		else if(currentState == END) {
			drawEndState(g);
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		if(rocketship.isActive == false) {
			currentState = END;
		}
		objectManager.update();
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS�", 5, 100);
		g.setFont(normalFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 150, LeagueInvaders.HEIGHT/2 - 50);
		g.drawString("Press SPACE for instructions", 100, LeagueInvaders.HEIGHT/2 + 50);
	}
	void drawGameState(Graphics g) {
		try {
            g.drawImage(ImageIO.read(this.getClass().getResourceAsStream("space.png")), 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
        } catch (Exception e) {
        	g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        }
		g.setFont(normalFont);
		g.setColor(Color.YELLOW);
		g.drawString("Score: " + objectManager.getScore(), 5, 40);
		objectManager.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	void startGame() {
		alienSpawn = new Timer(1000, objectManager);
		alienSpawn.restart();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				startGame();
			}
		    if (currentState == END) {
		        currentState = MENU;
		        rocketship = new Rocketship(250,700, 50, 50);
		        objectManager = new ObjectManager(rocketship);
		    } else {
		        currentState++;
		    }
		} 
		if (currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    
			    rocketship.up();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			
			    rocketship.down();
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			  
			    rocketship.left();
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			 
			    rocketship.right();
			}
			if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			    objectManager.addProjectile(rocketship.getProjectile());
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
