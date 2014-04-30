package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cherry extends SmallObjects {
	int cherryMultiplyer = 2;
	// a variable, which defines the point multiplyer for whenever the "cherry" is eaten

	public static long cherryPowers() {
		return System.currentTimeMillis();
		// check the amount of time in a timer for "cherry" object
	}
	public  int increasedScore(){
		return cherryMultiplyer;
		// returns cherrymultiplyer number
		}
	public Cherry(float x, float y) throws SlickException{
		super (x, y, new Image ("assets/cherry.png")); 
		// defines a sprite for cherry objects
	}
	
	public void catchSmallObjects(Plant player) {
		if (this.interacts(player)){
		player.ateCherry=true;
		player.timerAteCherry=cherryPowers();
		this.destroy();
	}}
	// the following function check whether a player(plant) interacts with cherry object. If he does - a timer is activates, that specifies how long a player is under extra powers from the cherry object.
	
}
