package dk.aau.oose;

import org.newdawn.slick.SlickException;

import dk.aau.oose.core.GameWorld;
import dk.aau.oose.core.GameElement;

/**
 * The main game class
 * All your "global" code should go here
 * @author Paolo Burelli
 */
public class Main {
	/*
	 * Set game title
	 */
	public static String title="Plants VS Zombies - PacMan Edition";
	// public Level lvl1=new Level ();
	public Main() throws SlickException{
		/*
		 * Add game elements
		 */
	
		GameWorld.add(new Plant());

	}
	
	public void update()  throws SlickException{
		/*
		 * Update game state
		 */

	}
}
