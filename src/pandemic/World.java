package pandemic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class World {

	private int width;
	private int height;
	private IRenderer renderer;
	private Collection<Actor> actors;

	public World(int width, int height, int numActors, IRenderer renderer) {
		this.width = width;
		this.height = height;
		this.actors = createActors(numActors);
		this.renderer = renderer;
		renderer.setActors(actors);
	}

	public void step() {
		for (Actor a : actors) {
			a.move();
			a.changeState();
		}
		renderer.render();
	}

	/**
	 * Create a collection of actors, randomly placed.
	 * 
	 * @param num The number of actors to create.
	 * @return a collection of actors.
	 */
	private Collection<Actor> createActors(int num) {
		Random r = new Random();
		Collection<Actor> actors = new HashSet<Actor>();

		for (int i = 0; i < num; i++) {
			Location loc = new Location(r.nextInt(width), r.nextInt(height));
			actors.add(new Actor(loc));
		}

		return actors;
	}

}
