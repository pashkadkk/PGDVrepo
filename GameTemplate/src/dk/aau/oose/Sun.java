package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Sun extends SmallObjects {
	    
	    public int score=20;
	    
		public Sun (float x, float y) throws SlickException {
			super (x,y,new Image ("assets/sun.png")); 
		
		}
		
		public void catchSmallObjects(Plant player) {
			
			if (this.interacts(player))
			{player.points+=this.score;
			 player.totalSuns--;
			 
			this.destroy();
		}
			
	}}
		
	 	

