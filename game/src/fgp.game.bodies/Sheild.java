package fgp.game.bodies;

import fgp.engine.Body;
import fgp.engine.GameEngine;
import fgp.game.bodies.Steve;
import fgp.engine.Layer;
import fgp.game.constants.BodyConstants;

public class Sheild extends Body {
	public static boolean exists=false;

	public Sheild(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void advance2() {
		// TODO Auto-generated method stub
		if (exists==false) {
			spriteIndex=1;
		} if(exists==true) {
			spriteIndex=0;
		}
		super.advance2();
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if (getSpriteId()==BodyConstants.P&&exists==true) {
			fgp.game.bodies.Steve.Protected=true;
			game.addScore(70);
			game.remove(this);
			return true;
		} else {
		
		return false;
		}
		}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
			return BodyConstants.Z;
	}

}
