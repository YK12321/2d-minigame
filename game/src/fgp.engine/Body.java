package fgp.engine;

import java.awt.Point;
import java.util.List;

/**
 * @author Mr. Hapke
 *
 */
public abstract class Body {
	private int speechFrames = -1;
	private boolean remove = false;
	private final Point location;
	protected final GameEngine game;
	protected final Layer layer;
	protected int tick = 0;
	protected int spriteIndex = 0;
	private String speech;

	public String getSpeech() {

		return this.speech;

		}

		public int getSpeechFrames() {

		return speechFrames;

		}

		public void setSpeech(int frames, String value) {

		this.speechFrames = frames;

		this.speech = value;

		}
	
	public Body(GameEngine g, Layer l, int x, int y) {
		this.game = g;
		this.layer = l;
		location = new Point(x, y);
	
	}
	

	public int getX() {
		return location.x - game.getXOffset();
	}

	public int getY() {
		return location.y - game.getYOffset();
	}

	public final void advance() {
		int delay = getAdvanceDelay();
		if (delay >= 0) {
			tick++;
			if (tick > delay) {
				tick = 0;
				speechFrames--;
				advance2();
			}
		}
	}

	public void advance2() {
		// Default: NOOP
	}

	/**
	 * How many frames would you like to wait before advance2() is called? 0 means
	 * every frame, -1 means to not animate at all
	 * 
	 * @return -1 to disable Animation
	 */
	protected abstract int getAdvanceDelay();

	/**
	 * Not recommended for general use. This bypasses the collision detection
	 * system.
	 */
	public void forceLocation(int x, int y) {
		location.x = x;
		location.y = y;
	}

	public void forceLocation(Direction d) {
		forceLocation(location.x + d.dx, location.y + d.dy);
	}

	public boolean move(Direction d) {
		return move(d.dx, d.dy);
	}

	public boolean move(int dx, int dy) { 

		int x = location.x - game.getXOffset() + dx; 

		int y = location.y - game.getYOffset() + dy; 

		 

		boolean allowed = true; 

		 

		List<Body> ahead = game.search(x, y); 

		if (ahead != null) { 

		for (Body b : ahead) { 

		allowed = allowed && collision(b, dx, dy); 

		} 

		} 

		 

		if (allowed) { 

		location.x += dx; 

		location.y += dy; 

		} 

		 

		return allowed; 

		} 

	/**
	 * Gets called before you Move() into a location that has a Body there already.
	 * In this project, we'll use Look-Ahead collision detection. The Body that is
	 * moving is responsible for not ruining the playability of your game.
	 * 
	 * @return False if the move should be blocked, True if it should be allowed
	 */
	protected abstract boolean collision(Body b, int dx, int dy);

	public boolean shouldRemove() {
		return remove;
	}

	public void markForRemoval() {
		this.remove = true;
	}

	public abstract char getSpriteId();

	public final static String createKey(char id, int i) {
		return id + "$" + i;
	}

	public final String getSpriteKey() {
		return createKey(getSpriteId(), spriteIndex);
	}

	@Override
	public String toString() {
		return "Body [" + getSpriteKey() + "@" + getPrettyLocation();
	}

	public String getPrettyLocation() {
		return getPrettyCoordinate(location.x, location.y);
	}

	public static String getPrettyCoordinate(int x, int y) {
		return "(" + x + "," + y + ")";
	}

}
