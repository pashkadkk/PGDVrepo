package dk.aau.oose;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;
import dk.aau.oose.Plant;


public abstract class SmallObjects extends GameElement {
	 
			
	public SmallObjects (float x, float y,Image sprite) throws SlickException {
		super(sprite);
		this.position = new Vector2f(x,y);
		
	}
	

	public void catchSmallObjects (Plant player) {}
		
	@Override
	public void update() {
		for(GameElement ge: GameWorld.getGameObjects()){
			if (ge instanceof Plant)
				this.catchSmallObjects((Plant)ge);	
		}
		
	}
}