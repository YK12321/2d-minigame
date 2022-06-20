package fgp.engine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

import fgp.engine.Transaction.Mode;
import fgp.engine.inputs.KeyNotification;
import fgp.engine.inputs.Keyboarder;
import fgp.engine.inputs.MouseNotification;
import fgp.engine.inputs.Mouser;
import fgp.engine.inputs.Notification;
import fgp.engine.util.Helpers;

/**
 * @author Mr. Hapke
 */
public abstract class Layer {
	private static final int MISSING_IMAGE_THICKNESS = 4;
	private static final BasicStroke MISSING_IMAGE_STROKE = new BasicStroke(MISSING_IMAGE_THICKNESS);
	public Body[][] map;
	private final Set<Body> bodies = Collections.synchronizedSet(new HashSet<>());
	private final Set<Keyboarder> keyboarders = new HashSet<>();
	private final Set<Mouser> mousers = new HashSet<>();
	protected final GameEngine game;
	protected int advanceTick = 0;

	private AbstractQueue<Transaction<Body>> transactions = new ConcurrentLinkedQueue<>();
	@SuppressWarnings("rawtypes")
	private Queue<Notification> notifications = new LinkedBlockingQueue<>();

	protected Layer(GameEngine game) {
		this.game = game;
	}

	protected abstract void changeLevel(int level);

	protected abstract boolean runsDuring(GameMode gameMode);

	/**
	 * TODO #4 Create the map, representing where all of the bodies are, using their
	 * location.x and location.y
	 */
	public final void createMap() {
		int width = game.getXSize();
		int height = game.getYSize();
		
		Body[][] nextMap = new Body[width][height];
		
		//run through each of the bodies,
		//each time this loop runs, put it in a variable called b
		for(Body b : bodies ) {
			int x = b.getX();
			int y = b.getY();
			if (Helpers.inside(0, width, x) && Helpers.inside(0, height, y)) { 

				nextMap[x][y] = b; 

				} 
			//put "b" into the map, at that (x, y) coordinate
		}
		this.map = nextMap;
	}

	public void paintNextFrame(Graphics gfx) {
		if (map == null)
			return;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Body b = map[i][j];
				if (b != null) {
					Image sprite = game.getSprite(b);
					int x = game.convertXGridToPixel(i);
					int y = game.convertYGridToPixel(j);
					if (sprite != null) {
						gfx.drawImage(sprite, x, y, null);
					} else {
						// can't find the image, so draw a box to represent that something's there, with
						// an arbitrary
						// colour so we can tell the difference between types
						int tile = game.getTileSize();

						Stroke oldStroke = null;

						Graphics2D g2 = null;
						try {
							g2 = (Graphics2D) gfx;
							oldStroke = g2.getStroke();
							g2.setStroke(MISSING_IMAGE_STROKE);
						} catch (Exception e) {
						}
						char id = b.getSpriteId();
						float hue = (((float) id) - 33) / 93;
						Color c = Color.getHSBColor(hue, 1.0f, 0.8f);
						gfx.setColor(c);
						gfx.drawRect(x + MISSING_IMAGE_THICKNESS / 2 + 1, y + MISSING_IMAGE_THICKNESS / 2 + 1,
								tile - MISSING_IMAGE_THICKNESS - 1, tile - MISSING_IMAGE_THICKNESS - 1);

						if (oldStroke != null && g2 != null)
							g2.setStroke(oldStroke);
					}
					int speechFrames = b.getSpeechFrames();

					if (speechFrames >= 0) {

					String speech = b.getSpeech();

					if (speech != null) {

					gfx.setColor(Color.black);

					int xMid = x + game.getTileSize() / 2;

					int border = 5;

					// arrow

					FontMetrics metrics = gfx.getFontMetrics();

					Rectangle2D bounds = metrics.getStringBounds(speech, gfx);

					int w = (int) bounds.getWidth();

					int hw = (int) (w / 2);

					// border

					int h = (int) bounds.getHeight();

					gfx.setColor(Color.white);

					gfx.fillRect(xMid - hw - border, y - 2 * border - h, w + 2 * border, h + border);

					gfx.setColor(Color.black);

					gfx.drawRect(xMid - hw - border, y - 2 * border - h, w + 2 * border, h + border);

					gfx.setColor(Color.white);

					Polygon p = new Polygon();

					p.addPoint(xMid, y);

					p.addPoint(xMid - border - 1, y - border - 1);

					p.addPoint(xMid + border + 1, y - border - 1);

					gfx.fillPolygon(p);

					gfx.setColor(Color.black);

					gfx.drawLine(xMid, y, xMid - border, y - border);

					gfx.drawLine(xMid, y, xMid + border, y - border);

					gfx.drawString(speech, xMid - hw, y - 2 * border);

					}

					}
				}
			}
		}
	}

	/**
	 * TODO #5 search the list of Bodies, and see if you can find one at that (x,y)
	 * coordinate. If you find one, return it.
	 */
	public Body search(int x, int y) {
		for(Body b : bodies) {
			if(b.getX()==x&&b.getY()==y) {
				return b;
			}
		}
		
		return null;
	}

	/**
	 * TODO #7b OPTIONAL: You may want this depending on the type of game you are
	 * making. Search through bodies, and return all of the Bodies that you find
	 * with that id
	 */
	public List<Body> search(char id) {
		List<Body> result = new ArrayList<>();
		for(Body b : bodies) {
			if(b.getSpriteId()==id) {
				result.add(b);
			}
		}
		return result;
	}

	/**
	 * This is final so you don't accidentally override it, and add/removal of the
	 * bodies, as well as kill the keyboard/mouse. If you'd like to do something
	 * after this completes, then override advance2(), which is called at the end of
	 * this method.
	 */
	@SuppressWarnings("rawtypes")
	public final void advance() {
		while (notifications.size() > 0) {
			Notification n = notifications.poll();
			if (n instanceof KeyNotification) {
				KeyNotification kn = (KeyNotification) n;

				for (Keyboarder kl : keyboarders) {
					int value = kn.value;
					int modifiers = kn.modifiers;
					switch (n.type) {
					case KeyNotification.KEY_DOWN:
						kl.keyDown(value, modifiers);
						break;
					case KeyNotification.KEY_UP:
						kl.keyUp(value, modifiers);
						break;
					}
				}
			} else if (n instanceof MouseNotification) {
				MouseNotification mn = (MouseNotification) n;
				for (Mouser ml : mousers) {
					Point value = mn.value;
					switch (mn.type) {
					case MouseNotification.MOUSE_DOWN:
						ml.mouseDown(value);
						break;
					case MouseNotification.MOUSE_UP:
						ml.mouseUp(value);
						break;
					case MouseNotification.MOUSE_MOVE:
						ml.mouseMove(value);
						break;
					case MouseNotification.MOUSE_ENTER:
						ml.mouseEnter(value);
						break;
					case MouseNotification.MOUSE_EXIT:
						ml.mouseExit(value);
						break;
					}
				}
			}
		}
		Transaction<Body> t;
		while ((t = transactions.poll()) != null) {
			Body b = t.value;
			switch (t.mode) {
			case Add:
				bodies.add(b);
				if (b instanceof Keyboarder) {
					Keyboarder kl = (Keyboarder) b;
					addKeyboarder(kl);
				}
				if (b instanceof Mouser) {
					Mouser ml = (Mouser) b;
					addMouser(ml);
				}
				break;
			}
		}

		for (Iterator iterator = bodies.iterator(); iterator.hasNext();) {
			Body b = (Body) iterator.next();
			if (b.shouldRemove()) {
				iterator.remove();
				if (b instanceof Keyboarder) {
					Keyboarder kl = (Keyboarder) b;
					removeKeyboarder(kl);
				}
				if (b instanceof Mouser) {
					Mouser ml = (Mouser) b;
					removeMouser(ml);
				}
			}
		}
		int delay = getAdvanceDelay();
		if (delay >= 0) {
			advanceTick++;
			if (advanceTick > delay) {
				advanceTick = 0;
				advance2();
			}
		}
		for (Body body : bodies) {
			body.advance();
		}
	}

	protected abstract int getAdvanceDelay();

	protected void advance2() {
	}

	public void addKeyboarder(Keyboarder kl) {
		if (kl != null)
			keyboarders.add(kl);
	}

	private void addMouser(Mouser ml) {
		if (ml != null)
			mousers.add(ml);
	}

	public void removeKeyboarder(Keyboarder kl) {
		if (kl != null)
			keyboarders.remove(kl);
	}

	public void removeMouser(Mouser ml) {
		if (ml != null)
			mousers.remove(ml);
	}

	public Set<Body> clearBodies() {
		Set<Body> result = new HashSet<Body>();
//		toRemove.addAll(bodies);
		result.addAll(bodies);
		for (Body b : bodies) {
			b.markForRemoval();
		}
		return result;
	}

	public Set<Body> removeBodies(Predicate<Body> p) {
		Set<Body> result = new HashSet<Body>();
		for (Body b : bodies) {
			if (p.test(b)) {
				b.markForRemoval();
				result.add(b);
			}
		}
		return result;
	}

	public void removeBody(Body b) {
		if (b != null) {
			b.markForRemoval();
		}
	}

	public void addBody(Body b) {
		if (b != null) {
			transactions.add(new Transaction<Body>(Mode.Add, b));
		}
	}

	@SuppressWarnings("rawtypes")
	public void notify(Notification n) {
		if (n != null)
			notifications.add(n);
	}

	public List<Body> search(Predicate<Body> p) {
		List<Body> found = new ArrayList<Body>();
		for (Body b : bodies) {
			if (p.test(b)) {
				found.add(b);
			}
		}
		return found;
	}

	public void gameModeChanged(GameMode gameMode) {
	}
}
