package dk.aau.oose;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import dk.aau.oose.core.GameElement;

public class Wall extends GameElement{

	
	
	 public Wall(float x, float y) throws SlickException {
		super(new Image ("assets/wall.png"));
		position= new Vector2f();
		position.x=x;
		position.y=y;
	
		// TODO Auto-generated constructor stub
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
