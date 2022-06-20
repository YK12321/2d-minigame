package fgp.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.text.NumberFormat;

import javax.swing.JPanel;

import fgp.engine.GameEngine;

/**
 * @author Mr. Hapke
 *
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = -253320674008631948L;
	public static final int DEBUG_HEIGHT = 100;
	private static final int NUM_FRAMES = 40;
	private int tickI = 0;
//	private long tickSum = 0;
	private double[] tickList = new double[NUM_FRAMES];

	private FrameManager manager;
	private GameEngine game;
	private NumberFormat nf;

	public GamePanel(GameEngine game) {
		this.game = game;
		int w = Math.max(10, getWidth());
		int h = Math.max(10, getHeight());
		manager = new FrameManager(game, w, h);
		addComponentListener(manager);
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		double fps = calcFps();
		Image i = manager.getCurrent();
		g.drawImage(i, 0, 0, null);
		g.setColor(Color.black);
		if (game.isDebugEnabled()) {
			int h = game.convertYGridToPixel(game.getYSize());
			g.drawString("FPS: " + nf.format(fps), 4, h + 32);
			g.drawString(manager.getDebugInfo(), 4, h + 48);
			// TODO #8 OPTIONAL: If you'd like to display something at the bottom of the window, it goes here.
			//g.drawString(, 4, h + 64);
			//g.drawString( + , 4, h + 80);
		}
	}

	public FrameManager getManager() {
		return manager;
	}

	public double calcFps() {
		double newTick = System.currentTimeMillis();
//		System.out.println(newTick);
		tickI++;
		if (tickI >= NUM_FRAMES)
			tickI = 0;

		double prev = tickList[tickI];
		tickList[tickI] = newTick;
		double deltaT = newTick - prev;
//		System.out.println(tickI + " : " + deltaT);
		if (deltaT == 0)
			return -1;
		return (1000d * NUM_FRAMES) / deltaT;
	}
}
