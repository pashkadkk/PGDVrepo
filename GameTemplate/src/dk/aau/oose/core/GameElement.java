package dk.aau.oose.core;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Image;

/**
 * Basic game content element
 * @author Paolo Burelli
 */
public abstract class GameElement {
	/**
	 * Object's life status
	 */
	private boolean deadOrNot = false;
	
	/**
	 * Object's center position
	 */
	public Vector2f position;
	
	/**
	 * Object's size
	 */
	protected Vector2f size;
	
	/**
	 * Object's sprite
	 */
	private Image sprite;
	
	/**
	 * Object constructor
	 * @param sprite Image to be displayed for the object
	 */
	public GameElement(Image sprite) {
		this.sprite = sprite;
		size = new Vector2f(sprite.getWidth(),sprite.getHeight());
	}

	/**
	 * Check if the object is dead or not
	 * @return true if he's not dead
	 */
	public boolean isDead(){
		return deadOrNot;
	}

	/**
	 * Set the object as dead and removes it from the game
	 */
	public void destroy(){
		deadOrNot = true;
		GameWorld.remove(this);
	}
	
	/**
	 * Returns true if this object interacts with the other one
	 * @param other the object with which the collision is checked
	 * @return true if there is a collision
	 */
	public boolean interacts(GameElement other){
		return  (this.position.x - this.size.x/2 < other.position.x + other.size.x/2) && 
	            (other.position.x - other.size.x/2 < this.position.x + this.size.x/2) &&
	            (this.position.y - this.size.y/2 < other.position.y + other.size.y/2) &&
	            (other.position.y - other.size.y/2 < this.position.y + this.size.y/2);
	}
	
	/**
	 * Object's draw function, draws the object's sprite in its current position
	 */
	public void draw() {
		sprite.draw(position.x-sprite.getWidth()/2, position.y-sprite.getHeight()/2);
	}
	
	/**
	 * Implement this method to define the object's behavior
	 */
	public abstract void update();

}
