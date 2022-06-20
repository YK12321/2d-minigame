package fgp.game.bodies;

import fgp.engine.Body;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.constants.BodyConstants;

public class BackgroundImageTwo extends Body {

	public BackgroundImageTwo(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}
int i = 0;
boolean reverse= false;
	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void advance2() {
		// TODO Auto-generated method stub
		if (reverse==false&&i<=199) {
			spriteIndex=i;
			i++;
			if (i==199) {
				reverse=true;
			}
		}
		if (reverse==true&&i>=0) {
			spriteIndex=i;
			i--;
			if (i==0) {
				reverse=false;
			}
		}
		
		
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
		return BodyConstants.W;
	}

}
