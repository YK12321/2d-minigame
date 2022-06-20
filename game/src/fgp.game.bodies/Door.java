package fgp.game.bodies;

import fgp.engine.Body;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.constants.BodyConstants;

public class Door extends Body {

	public Door(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}
	public boolean Open=false;
	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}
@Override
public void advance2() {
if(game.getCurrentLevel()==1) {
	if(Open==true) {
		spriteIndex=1;
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
		return BodyConstants.D;
	}

}
