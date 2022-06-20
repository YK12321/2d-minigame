package fgp.game.bodies;

import java.util.logging.Level;

import javax.swing.JOptionPane;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;

public class Goomba extends Body {

	public Goomba(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 7;
	}
	public boolean stomped= false;
	int i = 0;
	boolean a =false;
	boolean angry = false;
	int moveblock = 8;
	public void advance2() {
		
		if (game.getCurrentLevel()==2) {
//       do.nothing;
		}
		
		if (game.getCurrentLevel()==1) {
	if(stomped==false)	{
		if (i <=moveblock&&a==false) {
	move(Direction.Left);
	spriteIndex=2;
	if(i==0) {
		a=true;
	}
	i--;
} if (i<=moveblock&&a==true) {
	move(Direction.Right);
	spriteIndex=1;
	i++;
	if (i==moveblock) {
		a = false;
	}
} }
	

if (stomped==true&&angry==false) {
	spriteIndex = 3;
} 
		if (angry==true) {
			spriteIndex=0;
		}
		}
		super.advance2();
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if (b.getSpriteId()==BodyConstants.P) {
			if (dy!=1) {
				JOptionPane.showMessageDialog(null, "Goomba attacked you! Now your hp is "+(((GameDemo)game).hp-1));
				((GameDemo)game).hp=((GameDemo)game).hp-1;
				return true;
			} 
			return false;
		}
		return false;
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.B;
	}

}
