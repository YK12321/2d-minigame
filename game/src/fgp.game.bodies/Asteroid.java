package fgp.game.bodies;

import javax.swing.JOptionPane;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;

public class Asteroid extends Body {

	public Asteroid(GameEngine g, Layer l, int x, int y, boolean moveParraleltoX, boolean moveParraleltoY,
			boolean move2d) {
		super(g, l, x, y);
		this.moveParraleltoX = moveParraleltoX;
		this.moveParraleltoY = moveParraleltoY;
		this.move2d = move2d;
	}

	int i = 1;
	int time = 0;
	static boolean shieldremindersent=false;
	boolean up = false;
	boolean left = false;
	boolean down = false;
	boolean right = false;
	boolean move = false;
	boolean moveParraleltoY;
	boolean moveParraleltoX;
	boolean move2d;
	boolean noneleft = false;

	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void advance2() {
		// TODO Auto-generated method stub
		// Code for movement starts here
		// Horizontal Movement
		if (time == 5 && moveParraleltoX == true) {
			while (move == false) {
				reroll();
				if (i == 0 && this.getX() == 0) {
					left = false;
				}
				if (i == 1 && this.getX() == 25) {
					right = false;
				}
				if (i == 0 && this.getX() != 0) {
					left = true;
					move = true;
				}
				if (i == 1 && this.getX() != 25) {
					right = true;
					move = true;
				}
			}
			if (left == true) {
				move(Direction.Left);
				left = false;
				move = false;
			}
			if (right == true) {
				move(Direction.Right);
				right = false;
				move = false;
			}
			time = 0;
		}
		// Vertical movement
		if (time == 5 && moveParraleltoY == true) {
			while (move == false) {
				reroll();
				if (i == 0 && this.getY() == 0) {
					up = false;
				}
				if (i == 1 && this.getY() == 9) {
					down = false;
				}
				if (i == 0 && this.getY() != 0) {
					up = true;
					move = true;
				}
				if (i == 1 && this.getY() != 9) {
					down = true;
					move = true;
				}
			}
			if (up == true) {
				move(Direction.Up);
				up = false;
				move = false;
			}
			if (down == true) {
				move(Direction.Down);
				down = false;
				move = false;
			}
			time = 0;
		}
		// 2d Movement
		if (time == 5 && move2d == true) {
			while (move == false) {
				reroll();
				if (i == 0 && this.getY() == 0) {
					up = false;
				}
				if (i == 1 && this.getX() == 0) {
					left = false;
				}
				if (i == 2 && this.getY() == 9) {
					down = false;
				}
				if (i == 3 && this.getX() == 25) {
					right = false;
				}
				if (i == 0 && this.getY() != 0) {
					up = true;
					move = true;
				}
				if (i == 1 && this.getX() != 0) {
					left = true;
					move = true;
				}
				if (i == 2 && this.getY() != 9) {
					down = true;
					move = true;
				}
				if (i == 3 && this.getX() != 25) {
					right = true;
					move = true;
				}
			}
			if (up == true) {
				move(Direction.Up);
				up = false;
				move = false;
			}
			if (left == true) {
				move(Direction.Left);
				left = false;
				move = false;
			}
			if (down == true) {
				move(Direction.Down);
				down = false;
				move = false;
			}
			if (right == true) {
				move(Direction.Right);
				right = false;
				move = false;
			}
			time = 0;
		}
		// Code for movement ends here

		time++;
		super.advance2();
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
//STEVE collision
		if (b.getSpriteId() == BodyConstants.P) {
			if (dy!=-1&&fgp.game.bodies.Steve.Protected==false) {
				b.setSpeech(60, "Ouch!");
			((GameDemo) game).hp = ((GameDemo) game).hp - 1;
			return false;
			} if (dy!=-1&&fgp.game.bodies.Steve.Protected==true) {
				b.setSpeech(60, "nice");
				JOptionPane.showMessageDialog(null, "Your sheild turned the asteroid to dust");
				game.remove(this);
				return true;
			}
			if (dy==-1) {
				if (fgp.game.bodies.Steve.Protected==false&&fgp.game.bodies.Asteroid.shieldremindersent==false) {
			    b.setSpeech(60, "Go get the shield.");	
				JOptionPane.showMessageDialog(null, "Congratulations on breaking the asteroid, as a reward, you got the sheild.");
				fgp.game.bodies.Sheild.exists=true;
				shieldremindersent=true;
				}
				game.remove(this);
				return true;
			}
			
		}
//ASTEROID Collision
		if (b.getSpriteId() == BodyConstants.R) {
			return false;
		}
		return true;
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.R;
	}

	protected void reroll() {
		if (move2d == true) {
			i = (int) (Math.random() * (4));
		}
		if (moveParraleltoX == true ^ moveParraleltoY == true) {
			i = (int) (Math.random() * (2));
		}
	}
}
