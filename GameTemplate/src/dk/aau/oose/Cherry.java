package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cherry extends SmallObjects {
	int cherryMultiplyer = 2;

	public static long cherryPowers() {
		return System.currentTimeMillis();
	}
	public  int increasedScore(){
		return cherryMultiplyer;
		}
	public Cherry(float x, float y) throws SlickException{
		super (x, y, new Image ("assets/cherry.png")); 
	}
	
	public void catchSmallObjects(Plant player) {
		if (this.interacts(player)){
		player.ateCherry=true;
		player.timerAteCherry=cherryPowers();
		this.destroy();
	}}
	
}
