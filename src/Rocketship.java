import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public void up() {
		if(y > speed) {
			y -= speed;
		}
		else {
			y = 0;
		}
	}
	public void down() {
		if(y < LeagueInvaders.HEIGHT - (speed + height)) {
			y += speed;
		}
		else {
			
			y = LeagueInvaders.HEIGHT - height;
		}
	}
	public void left() {
		if(x > speed) {
			x -= speed;
		}
		else {
			x = 0;
		}
	}
	public void right() {
		if(x < LeagueInvaders.WIDTH - (speed + width)) {
			x += speed;
		}
		else {
			x = LeagueInvaders.WIDTH - width;
		}
	}
}
