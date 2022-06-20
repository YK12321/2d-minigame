package fgp.game.bodies;

import javax.swing.JOptionPane;

import fgp.animations.Video1;
import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;

public class Glitched_projectile extends Body {

	public Glitched_projectile(GameEngine g, Layer l, int x, int y, boolean glitch_this_exists) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
		this.glitch_this_exists = glitch_this_exists;
	}
int i=1;
boolean reverse = false;
public static boolean glitch_this_exists;
	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public void advance2() {
	
		// TODO Auto-generated method stub
		//Do nothing{
		if (glitch_this_exists==false) {
			spriteIndex=0;
		}
		
		//Do nothing}
		if (glitch_this_exists==true) {
//Pathfinding

		        	if (fgp.game.bodies.Glitched_goomba.PlayerX>getX()) {
		        		move(Direction.Right);
		        	}
		        	if (fgp.game.bodies.Glitched_goomba.PlayerY>getY()) {
		        		move(Direction.Down);
		        	}
		        	if (fgp.game.bodies.Glitched_goomba.PlayerX<getX()) {
		        		move(Direction.Left);
		        	}
		        	if (fgp.game.bodies.Glitched_goomba.PlayerY<getY()) {
		        		move(Direction.Up);
		        	}
		        
			
		//Animation{
		if (i<=20&&reverse==false) {
			spriteIndex=i;
			i++;
			if (i==20) {
				reverse=true;
				i--;
			}
		}
		if (i>=1&&reverse==true) {
			spriteIndex=i;
			i--;
			if (i==1) {
				reverse=false;
				i++;
			}
		}
		//Animation}
		}
		super.advance2();
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if (glitch_this_exists==false) {
		return true;
		}
		if (glitch_this_exists==true) {
			if (b.getSpriteId()==BodyConstants.P) {
				JOptionPane.showMessageDialog(null, "<html><font color='BLUE'>"+"The shield self-destructed,"+"<font color='RED'> Causing a HUGE EXPLOSION, making it the end of the  <font color='BLACK'> evil goomba <font color='RED'>, and the end of this level.\n<font color='BLACK'>Steve was tossed away onto a faraway ostile planet ruled by goombas /n That was also where the evil pen was hiding.</font><html>");
				fgp.game.bodies.Steve.Protected=false;
				game.addScore(350);
				game.nextLevel();
				game.remove(game.search(BodyConstants.Y));

			}
		}
		return false;
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.Y;
	}

}
