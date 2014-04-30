package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Sun extends SmallObjects {
	    
	    public int score=20;
	    
		public Sun (float x, float y) throws SlickException {
			super (x,y,new Image ("assets/sun.png")); 
		// defines a sprite for 'sun' objects on the screen
		}
		
		public void catchSmallObjects(Plant player) {
			
			if (this.interacts(player))
			{player.points+=this.score;
			 player.totalSuns--;
			 // if sun/cherry interacts with player - amount of totalsuns left is decreased and player score is changed
			this.destroy();
			// sun/cherry is eaten thus destroyed
		}
			
	}}
		
	 	

