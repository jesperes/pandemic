package pandemic;

import java.util.Random;

public class Actor {
	private static Random r = new Random();

	public Location location;
	public State state = State.Susceptible;

	public Actor(Location loc) {
		location = loc;
	}

	/**
	 * Invoked once each step to move actor.
	 */
	public void move() {
		// TODO Implement! This is just a random walk.
		location.x += r.nextInt(3) - 1;
		location.y += r.nextInt(3) - 1;
	}

	/**
	 * Invoked once each step to (potentially) change the state of the actor.
	 */
	public void changeState() {
		// TODO Implement! This just randomly assigns a new value.
		State states[] = State.values();
		state = states[r.nextInt(states.length)];
	}
}
