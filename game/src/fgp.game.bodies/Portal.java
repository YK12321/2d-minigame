package fgp.game.bodies;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.constants.BodyConstants;

public class Portal extends Body {
	int a;

	public Portal(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 1;
	}
	public void advance2() {

//		animation
		if (a==0) {
			spriteIndex=0;
		}if(a==1) {
			spriteIndex=1;
		}if(a==2) {
			spriteIndex=2;
		}if(a==3) {
			spriteIndex=3;
		}if(a==4) {
			spriteIndex=4;
		}if(a==5) {
			spriteIndex=5;
		}if(a==6) {
			a=0;
		}
		a++;
		super.advance2();
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.E;
	}

}
