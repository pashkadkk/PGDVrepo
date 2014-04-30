package dk.aau.oose;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import dk.aau.oose.core.GameElement;

public class Grass extends GameElement{

	
	
	 public Grass(float x, float y) throws SlickException {
		super(new Image ("assets/grass.png"));
		position= new Vector2f();
		position.x=x;
		position.y=y;
	
		// defines a sprite for grass objects in the screen
	}


	@Override
	public void update() {		
	}

}
