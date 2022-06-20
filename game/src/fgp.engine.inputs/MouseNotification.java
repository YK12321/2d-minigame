package fgp.engine.inputs;

import java.awt.Point;

/**
 * @author Mr. Hapke
 */
public class MouseNotification extends Notification<Point> {

	public static final int MOUSE_DOWN = 1;
	public static final int MOUSE_UP = 2;
	public static final int MOUSE_MOVE = 4;
	public static final int MOUSE_ENTER = 8;
	public static final int MOUSE_EXIT = 16;

	public MouseNotification(int type, Point value) {
		super(type, value);
	}

}
