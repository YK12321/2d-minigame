package fgp.game.bodies;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;

public class Pen_Ranged_Attack extends Body {

	public Pen_Ranged_Attack(GameEngine g, Layer l, int x, int y, int direction) {
		super(g, l, x, y);
		this.direction=direction;
		// TODO Auto-generated constructor stub
	
	}
	int direction;
	int i;
	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if(b.getSpriteId()==BodyConstants.P) {
		    ((GameDemo)game).hp=((GameDemo)game).hp--;
		    fgp.game.bodies.Pen.weaknessAgainstRanged++;
		    game.remove(this);
		    return true;
		}
		if(b.getSpriteId()!=BodyConstants.P&&game.isDebugEnabled()==false) {
			game.remove(this);
		}
		return false;
	}
	@Override
	public void advance2() {
		// TODO Auto-generated method stub
		switch (direction) {
		case 1:
			spriteIndex=1;
			move(Direction.Left);
			i++;
			break;
		case 2:
			spriteIndex=3;
			move(Direction.Right);
			i++;
			break;
		case 3:
			spriteIndex=2;
			move(Direction.Down);
			i++;
			break;
		case 4:
			spriteIndex=0;
			move(Direction.Up);
			i++;
			break;
		default:
			new IllegalArgumentException("Invalid Direction, please check to make sure that the dirction provided for the /nconstructor argument is either 1, or 2, or 3, or 4");
			break;
		}
		switch (i) {
		case 40:
			game.remove(this);
			break;

		default: //Do Nothing 
			break;
		}
		super.advance2();
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.O;
	}

}
