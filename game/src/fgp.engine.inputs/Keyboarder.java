package fgp.engine.inputs;

/**
 * @author Mr. Hapke
 *
 */
public interface Keyboarder {

	void keyDown(int keycode, int modifiers);

	void keyUp(int keycode, int modifiers);
}
