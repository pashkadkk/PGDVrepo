package dk.aau.oose;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;


public class EndScreen extends GameElement {

	
	public Image screen;
	
	public EndScreen() throws SlickException {
		super(new Image ("assets/cherry.png"));
		position=new Vector2f(0,0);
		// TODO Auto-generated constructor stub
	}
	

	
	
	@Override
	public void update() {
		
		// TODO Auto-generated method stub
		
	}

}
