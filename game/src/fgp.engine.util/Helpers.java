package fgp.engine.util;

/**
 * @author Mr. Hapke
 *
 */
public abstract class Helpers {

	/**
	 * At least min, less than max.
	 */
	public static boolean inside(int min, int max, int val) {
		return val >= min && val < max;
	}

	public static char[][] transpose(char[][] in) {
		char[][] out = new char[in[0].length][in.length];
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[i].length; j++) {
				out[j][i] = in[i][j];
			}

		}
		return out;
	}
}
