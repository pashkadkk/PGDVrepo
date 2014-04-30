package dk.aau.oose;

import dk.aau.oose.Zombie.Direction;

public interface EnemiesWithDirectionalLoop {

	public void directionFunction (float targetX, float targetY);

	public Direction directions ();
	public void directionLoop(Direction direction);
	// calls for a directional loop from direction X and Y
	
	
}
