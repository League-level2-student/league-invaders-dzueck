import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Alien> aliens = new ArrayList();
	int score = 0;
	
	ObjectManager(Rocketship r){
		rocket = r;
	}
	int getScore() {
		return score;
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(Alien alien : aliens) {
			alien.update();
			if(alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		}
		for(Projectile projectile : projectiles) {
			projectile.update();
			if(projectile.y < 0) {
				projectile.isActive = false;
			}
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}
	void draw(Graphics g) {
		
		rocket.draw(g);
		for(Alien alien : aliens) {
			alien.draw(g);
			
		}
		for(Projectile projectile : projectiles) {
			projectile.draw(g);
			
		}
	}
	void purgeObjects() {
		for(int i = 0; i < aliens.size(); i ++) {
			if(aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
	}
	void checkCollision() {
		for(Alien alien : aliens) {
			if(rocket.collisionBox.intersects(alien.collisionBox)) {
				rocket.isActive = false;
				break;
			}
			for(Projectile projectile: projectiles) {
				if(alien.collisionBox.intersects(projectile.collisionBox)) {
					alien.isActive = false;
					
					score++;
				}
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
		// TODO Auto-generated method stub
		
	}
}
