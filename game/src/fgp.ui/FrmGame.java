package fgp.ui;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fgp.engine.GameEngine;
import fgp.engine.inputs.KeyNotification;
import fgp.engine.inputs.MouseNotification;
import fgp.engine.util.TimerThreadWithKill;

/**
 * @author Mr. Hapke
 */
public class FrmGame extends JFrame {

	private static final long serialVersionUID = 6255440113168001509L;
	private static final int GAP = 10;

	private final class KeyManager extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			int modifiers = e.getModifiersEx();
			game.notify(new KeyNotification(KeyNotification.KEY_UP, code, modifiers));
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			int modifiers = e.getModifiersEx();
			game.notify(new KeyNotification(KeyNotification.KEY_DOWN, code, modifiers));
		}
	}

	private final class FormEvents extends ComponentAdapter {
		@Override
		public void componentResized(ComponentEvent e) {
			moveDebug();
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			moveDebug();
		}

		@Override
		public void componentShown(ComponentEvent e) {
			start();
		}
	}

	private final class MouseManager implements MouseMotionListener, MouseListener {

		@Override
		public void mouseMoved(MouseEvent e) {
			game.notify(new MouseNotification(MouseNotification.MOUSE_MOVE, e.getPoint()));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			game.notify(new MouseNotification(MouseNotification.MOUSE_EXIT, e.getPoint()));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			game.notify(new MouseNotification(MouseNotification.MOUSE_DOWN, e.getPoint()));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			game.notify(new MouseNotification(MouseNotification.MOUSE_UP, e.getPoint()));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			game.notify(new MouseNotification(MouseNotification.MOUSE_ENTER, e.getPoint()));
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}

	}

	private JPanel contentPane;
	private GameEngine game;
	private GamePanel pnlMain;
	private FrameManager manager;
	private TimerThreadWithKill repaintInvoker;
	private FrmDebug frmDebug;

	private void init() {
		pnlMain = new GamePanel(game);
		MouseManager mouser = new MouseManager();
		pnlMain.addMouseMotionListener(mouser);
		pnlMain.addMouseListener(mouser);
		addKeyListener(new KeyManager());
		manager = pnlMain.getManager();
	}

	private void start() {
		manager.start();
		if (repaintInvoker == null) {
			repaintInvoker = new TimerThreadWithKill("RepaintInvoker", (long) (1000d / game.getTargetFps())) {
				@Override
				protected void doWork() {
					pnlMain.repaint();
				}
			};
			repaintInvoker.start();
		}
	}

	/**
	 * Create the frame.
	 */
	public FrmGame(GameEngine game) {
		this.game = game;
		init();

//		setTitle("Game!");
		setTitle(game.getGameTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		int tileSize = game.getTileSize();
		int debugSize = GamePanel.DEBUG_HEIGHT;

		Insets frameSize = getInsets();
		int w = game.convertXGridToPixel(game.getXSize()) + frameSize.left + frameSize.right + 16;
		int h = game.convertYGridToPixel(game.getYSize()) + debugSize + frameSize.bottom + frameSize.top + 42;
		setLocation(100, 100);
		setBounds(100, 100, w, h);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		pnlMain.setBackground(Color.WHITE);
		pnlMain.setForeground(Color.BLACK);
		pnlMain.setBounds(0, 0, w, h);
		contentPane.setLayout(null);
		contentPane.add(pnlMain);

		addComponentListener(new FormEvents());
		frmDebug = new FrmDebug(game);
		frmDebug.setVisible(true);
		moveDebug();
	}

	private void moveDebug() {
		int x = getX();
		int y = getY();
		int w = getWidth();

		frmDebug.setLocation(x + w + GAP, y);
	}

}
