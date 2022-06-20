package fgp.engine.inputs;

import java.awt.Point;

/**
 * @author Mr. Hapke
 *
 */
public interface Mouser {
	void mouseDown(Point loc);

	void mouseUp(Point loc);

	void mouseMove(Point loc);

	void mouseEnter(Point loc);

	void mouseExit(Point loc);
}
