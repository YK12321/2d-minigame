package fgp.engine;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import fgp.engine.inputs.Notification;
import fgp.engine.util.ImageLoader;

/**
 * TODO #1 extend this class. Put your class in the package fgp.game. Go read
 * the readme for instructions.
 * 
 * @author Mr. Hapke
 */
public abstract class GameEngine {
	protected int score = 0;
	private int currentLevel = 1;
	private final List<Layer> layers = new ArrayList<>();
	protected final Map<Integer, Layer> layerMap = new HashMap<>();
	protected final Map<String, Image> spriteMap = new HashMap<>();
	private static final int TOP_GAP = 20;
	private GameMode gameMode = GameMode.Play;
	private GameMode nextGameMode = GameMode.Play;
	private boolean debugEnabled = true;
	private ImageLoader imgLoader;
	protected int advanceTick = 0;
	private int nextLayerId = 1;

	/*-
	 * For image loading to work properly, invoke this constructor as follows: 
	 * If your Game class is called MyGame:
	 * 
	 * super(MyGame.class);
	 */
	public GameEngine(Class<? extends GameEngine> cls) {
		imgLoader = new ImageLoader(cls);
		createLayers();

		loadSprites();
	}

	/**
	 * How many FPS would you like?
	 */
	public abstract int getTargetFps();

	/**
	 * Will be placed in the Frame's Titlebar automatically
	 */
	public abstract String getGameTitle();

	/**
	 * How many levels does your game support?
	 */
	protected abstract int getLevels();

	/**
	 * Load your sprites here, by calling addSprite(). Watch out for capitals, as
	 * well as the extension: JPG vs. JPEG vs. GIF vs. PNG.
	 * 
	 * You can have more than one sprite for a given id. Start with index=0, of
	 * course.
	 */
	public abstract void loadSprites();

	/**
	 * Create the layers for your game. Strongly recommend putting them into a
	 * private field for yourself. Add them to the List called layers. They will be
	 * rendered in (first = bottom)-->(last = top) order. Strongly recommend adding
	 * the StatusLayer last. It will add Pause support to your game with the P-key.
	 */
	public abstract void createLayers();

	protected int addLayer(Layer l) {
		layers.add(l);
		int id = nextLayerId();
		layerMap.put(id, l);
		return id;
	}

	private int nextLayerId() {
		return nextLayerId++;
	}

	/**
	 * How many grid boxes horizontally?
	 */
	public abstract int getXSize();

	/**
	 * How many grid boxes vertically?
	 */
	public abstract int getYSize();

	/**
	 * What size are your images? They must be square. ie: 16x16/32x32, etc.
	 */
	public abstract int getTileSize();

	public Image getSprite(Body b) {
		return spriteMap.get(b.getSpriteKey());
	}

	public void gameOver() {
		changeLevel(0);
		JOptionPane.showMessageDialog(null, "Game Over!");
	}

	public void newGame() {
		score = 0;
		changeLevel(1);
	}

	public void restartLevel() {
		changeLevel(currentLevel);
	}

	public void nextLevel() {
		changeLevel(currentLevel + 1);
	}

	public void changeLevel(int level) {
		currentLevel = level;
		boolean over = false;
		if (currentLevel > getLevels()) {
			currentLevel = 0;
			setGameMode(GameMode.Over);
			over = true;
		}
		int i = 0;
		while (i < layers.size()) {
			Layer l = layers.get(i);
			l.changeLevel(level);
			i++;
		}
		if (!over) {
			setGameMode(GameMode.Play);
		}
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public List<Layer> getLayers() {
		return layers;
	}

	public Layer getLayer(int id) {
		return layerMap.get(id);
	}

	public int convertXGridToPixel(int x) {
		return x * getTileSize();
	}

	public int convertYGridToPixel(int y) {
		return y * getTileSize() + TOP_GAP;
	}

	public int convertXPixelToGrid(int x) {
		return x / getTileSize();
	}

	public int convertYPixelToGrid(int y) {
		return (y - TOP_GAP) / getTileSize();
	}

	public void advance() {
		gameMode = nextGameMode;
		int delay = getAdvanceDelay();
		if (delay >= 0) {
			advanceTick++;
			if (advanceTick > delay) {
				advanceTick = 0;
				advance2();
			}
		}
		for (Layer layer : layers) {
			if (layer.runsDuring(gameMode))
				layer.advance();
		}
	}

	protected abstract int getAdvanceDelay();

	protected void advance2() {
	}

	/**
	 * TODO #6 Search through your layers, in order from top to bottom, and return
	 * all of the Bodies that you find at that (x,y) location
	 */
	public List<Body> search(int x, int y) {
		List<Body> result = new ArrayList<>();
		
		for(Layer l : layers) {
			Body found;
			found = l.search(x, y);
			if(found!=null) {
				result.add(found);
			}
		}
		return result;
	}

	/**
	 * TODO #7a OPTIONAL: You may want this depending on the type of game you are
	 * making. Search through your layers, in order from top to bottom, and return
	 * all of the Bodies that you find with that id
	 */
	public List<Body> search(char id) {
		List<Body> result = new ArrayList<>();
		
		for(Layer l : layers) {
			List<Body> found;
			found = l.search(id);
			if(found!=null) {
				result.addAll(found);
			}
		}
		return result;
	}

	public List<Body> search(Predicate<Body> p) {
		List<Body> found = new ArrayList<Body>();
		for (Layer l : layers) {
			List<Body> fromLayer = l.search(p);
			found.addAll(fromLayer);
		}
		return found;
	}

	protected void addSprite(char id, int i, String folder, String filename) {
		String key = Body.createKey(id, i);
		if (!spriteMap.containsKey(key)) {
			Image img = imgLoader.getImage(folder, filename);
			spriteMap.put(key, img);
		}
	}

	public void remove(Collection<Body> c) {
		for (Body b : c) {
			remove(b);
		}
	}

	public void remove(Body b) {
		for (Layer layer : layers) {
			layer.removeBody(b);
		}
	}

	@SuppressWarnings("rawtypes")
	public void notify(Notification notification) {
		for (Layer layer : layers) {
			layer.notify(notification);
		}
	}

	public int getScore() {
		return score;
	}

	public void addScore(int i) {
		score += i;
	}

	public void setScore(int i) {
		score = i;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.nextGameMode = gameMode;
		for (Layer layer : layers) {
			layer.gameModeChanged(gameMode);
		}
	}

	public void setDebugEnabled(boolean enabled) {
		this.debugEnabled = enabled;
	}

	public boolean isDebugEnabled() {
		return debugEnabled;
	}
	private final Point offset = new Point(0, 0); 

	 

	public int getXOffset() { 

	return offset.x; 

	} 

	public int getYOffset() { 

	return offset.y; 

	} 

	 

	public void moveOffset(int dx, int dy) { 

		if (getCurrentLevel()!= 1&&getCurrentLevel()!=2)
		{	offset.x += dx; 

	offset.y += dy; 
		}
	} 
}

