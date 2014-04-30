package dk.aau.oose;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.lwjgl.util.vector.Vector2f;

import dk.aau.oose.core.GameElement;
import dk.aau.oose.core.GameWorld;
import dk.aau.oose.Zombie;



public class Plant extends GameElement  {
	
	public int amountOfLives=5; // defines amount of lifes that player has got
	public Life[] health; // creates health of a player
	public int totalSuns=405; // defines total amount of suns on the screen, which is later on used to check whether all of them were collected
	public int points=0; // amount of points player has got
	public int speed = 2; // speed of a player
	public boolean ateCherry=false; // boolean, which is used to define whether player has eaten a cherry object or not
	public long timerAteCherry=0; // a number, which is used to define a number for a timmer, that represents how long has it passed since player has eaten a cherry object
	public  float initialX; // variable, that is used later on to define initial player X coordinate
	public  float initialY; // variable, that is used later on to define initial player Y coordinate
	public Maze lvl= new Maze(); // creates new maze object
	public Congratz congratulations=new Congratz (400, 300); // defines and creates a new "congratz" class object, that is later on used in order to show a sprite (image), whenever a player wins the game
	
	
	
	public Plant() throws SlickException {
		super(new Image ("assets/Plant.png"));
		position = new Vector2f(GameWorld.getGameContainer().getWidth()-100,GameWorld.getGameContainer().getHeight()-20);
		size=new Vector2f(9,9);
		// defines a sprite for a player and it's location and size
		lvl.buildMaze(); // calls for a buildMaze function that builds the maze to the stage
		this.initialX=position.x; // initial player position X
		this.initialY=position.y; // initial player position Y
		health= new Life[amountOfLives];
	
		
		for (int i=0;i<amountOfLives;i++)
		{	
			health[i]=new Life();
			health[i].position.x=GameWorld.getGameContainer().getWidth()-55;
			health[i].position.y=100-(i*18);
		}
		for(int i=0;i<amountOfLives;i++)
		  GameWorld.add(health[i]); 
		// the code lines above create 5 life objects for a player. The lifes are added as gameobjects to gameworld as well as shown on the top right of the screen
	}

	@Override
	public void update(){
	
		movement (); // calls for 'movement' function, that is explained later on
		controlPower(); // calls for 'controlpower' function, that is explained later on
		System.out.println(points); // prints out the amount of points to the console
		for (GameElement g: GameWorld.getGameObjects())
			if (g.interacts(this) && g instanceof Zombie)
				if (fight((Zombie)g))
					g.destroy();
		// checks whether player interacted with a zombie, if yes - then a fight function is called
		for (GameElement g: GameWorld.getGameObjects())
			if (g.interacts(this) && g instanceof SuperZombie)
				if (fightSuper((SuperZombie)g))
					g.destroy();
		// checks whether player interacted with a superzombie, if yes - then a superfight function is called
		if (this.amountOfLives<0) 
		{this.destroy(); 
; // if amount of lifes is gets to 0 - the game ends and a player object is destroyed
		}
		if (this.totalSuns==0)
		{  lvl.updateMaze();
		  GameWorld.add(congratulations);
		  // checks whether player has eaten all of the 'sun' objects on the screen. If yes - then the game should end, thus a congratulations screen is being called and added to the screen.
		}
		
				
	}
	
	private boolean isInteracting(Class c){
		for (GameElement g: GameWorld.getGameObjects())
			if (g != this && c.isInstance(g) && g.interacts(this))
				return true;
		return false;
		// a function that is used to check whether object A is interacting with object B, and returns true/false based on that
	}
	
	public void movement () {
		
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_LEFT)) 
			if (position.x > 0)
				{position.x-=speed;
				 if (isInteracting(Wall.class)) position.x+=speed;
				}
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_RIGHT)) 
			if (position.x< GameWorld.getGameContainer().getWidth() && !isInteracting(Wall.class))
				{position.x+=speed;
				if (isInteracting(Wall.class)) position.x-=speed;
				}
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_UP)) 
			if (position.y> 0 && !isInteracting(Wall.class))
			   {position.y-=speed;
			   if (isInteracting(Wall.class)) position.y+=speed;
			   }
		if (GameWorld.getGameContainer().getInput().isKeyDown(Input.KEY_DOWN)) 
			if (position.y < GameWorld.getGameContainer().getHeight() && !isInteracting(Wall.class) )
				{position.y+=speed;
				if (isInteracting(Wall.class)) position.y-=speed;
				}
		// the function above checks whether player would interact with a wall or not if he would move either left/right/up/down (depends on what he has chosen). If he would not interact with a wall - a player location is changed.
	}

	public boolean fight(Zombie zombie){
		
		if (ateCherry==true) { 
		
			points+=zombie.fightPoints;
			return true;
			// if player is under effects of cherry object and interacts with zombie - he receives zombie.fightpoints amount of points for that that is added to his points pool
		}
		 
		else { 
				this.health[amountOfLives-1].lifeChanged(amountOfLives-1, health);
				this.amountOfLives--;
				this.position.x=initialX;
				this.position.y=initialY;
				// if player is not under effects of cherry object - when he interacts with zombie, his life is decreased by one and position resets to starting position
				
				
		}		
		return false;
	}
public boolean fightSuper(SuperZombie superzombie){
		
		if (ateCherry==true) { 
		
			points+=superzombie.fightPoints;
			return true;
			// if player is under effects of cherry object and interacts with SUPERzombie - he receives SUPERzombie.fightpoints amount of points for that that is added to his points pool
		}
		 
		else { 
				this.health[amountOfLives-1].lifeChanged(amountOfLives-1, health);
				this.amountOfLives--;
				this.position.x=initialX;
				this.position.y=initialY;
				// if player is not under effects of cherry object - when he interacts with SUPERzombie, his life is decreased by one and position resets to starting position
				
		}		
		return false;
	}
	public void controlPower (){
		if (ateCherry==true ) 
		
				if (System.currentTimeMillis()-timerAteCherry>10000)
						{ateCherry=false;
						}
	}
	// the function above checks whether the timer after eating a cherry object has expired or not, and based on that defines whether player ate cherry recently enough or not

	
}
