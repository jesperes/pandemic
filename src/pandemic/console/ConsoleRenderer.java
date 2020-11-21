package pandemic.console;

import java.util.Collection;

import pandemic.Actor;
import pandemic.IRenderer;

public class ConsoleRenderer implements IRenderer {

	int minx, miny, maxx, maxy;
	private Collection<Actor> actors;

	private static void p(String s) {
		System.out.print(s);
	}

	public void setActors(Collection<Actor> actors) {
		this.actors = actors;
		for (Actor a : actors) {
			minx = Math.min(a.location.x, minx);
			maxx = Math.max(a.location.x, maxx);
			miny = Math.min(a.location.y, miny);
			maxy = Math.max(a.location.y, maxy);
		}
	}

	public void render() {
		long t0 = System.nanoTime();
		p("\u250c");
		for (int x = minx; x <= maxx; x++) {
			p("\u2500");
		}
		p("\u2510\n");
		for (int y = miny; y <= maxy; y++) {
			p("\u2502");
			for (int x = minx; x <= maxx; x++) {
				boolean hasActor = false;
				for (Actor a : actors) {
					if (a.location.x == x && a.location.y == y) {
						hasActor = true;
						switch (a.state) {
						case Susceptible:
							p("\u263a"); // white smiling face
							break;
						case Infected:
							p("\u263b"); // black smiling face
							break;
						case Removed:
							p("\u2020"); // dagger
							break;
						default:
							p("?");
							break;
						}
						// Don't render more than one actor
						// at any one location
						break;
					}
				}

				if (!hasActor) {
					p(" ");
				}
			}
			p("\u2502\n");
		}
		p("\u2514");
		for (int x = minx; x <= maxx; x++) {
			p("\u2500");
		}
		p("\u2518\n");
		long t1 = System.nanoTime();
		System.out.format("Rendering took %g secs.\n", (t1 - t0) / 1000000000.0);
	}
}
