package fgp.game.bodies;

import fgp.engine.Body;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.constants.BodyConstants;

public class Elytra extends Body {

	public Elytra(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if (b.getSpriteId()==BodyConstants.P) {
			fgp.game.bodies.Steve.Gravity=false;
			game.remove(this);
			return true;
		}
		return false;
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.F;
	}

}
