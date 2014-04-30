package dk.aau.oose;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import dk.aau.oose.core.GameElement;

public class Congratz extends GameElement{

	
	
	 public Congratz(float x, float y) throws SlickException {
		super(new Image ("assets/winner.jpg"));
		position= new Vector2f();
		position.x=x;
		position.y=y;
	
		// defines a sprite that shows up whenever a player wins the game.
	}


	@Override
	public void update() {		
	}

}
