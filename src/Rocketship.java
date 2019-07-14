import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	int speed;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("rocket.png");
		}
		// TODO Auto-generated constructor stub
		
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
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
	void update() {
		super.update();
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
		   
	        } catch (Exception e) {
	           
	        }
	        needImage = false;
	    }
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 
}
