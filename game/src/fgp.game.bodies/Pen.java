package fgp.game.bodies;

import java.util.List;

import javax.swing.JOptionPane;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;
import fgp.game.constants.LayerConstants;
import fgp.game.layers.BackgroundLayer;
import fgp.game.layers.CharactersLayer;

public class Pen extends Body {

	public Pen(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}
static int PlayerX;
static int PlayerY;
static int weaknessAgainstRanged;
static int weaknessAgainstMid;
static int weaknessAgainstMelee;
int coord;
int dy;
int dx;
double distance;
int movetimer=0;
int movedelay=5;
boolean previousinfo = false;
boolean weakAgainstMelee = false;
boolean weakAgainstMid = false;
boolean weakAgainstRanged = false;
boolean doingRangedAttack = false;
boolean doingMidAttack = false;
boolean doingMeleeAttack = false;
boolean runningAway = false;
boolean following = false;
boolean hasSword = false;
	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void advance2() {
		// TODO Auto-generated method stub
		//Thinking {
		think();
		//Thinking }
		//Attacks {
		if (doingRangedAttack) {
			rangedAttack();
		}
		if (doingMidAttack) {
			midAttack();
		}
		if (doingMeleeAttack) {
			meleeAttack();
		}
		//Attacks }
		//Pathfinding {
		locatePlayer();
        if (movetimer>=movedelay) {
    	run();
    	follow();
    	movetimer++;
        if(movetimer==movedelay) {
        	movetimer=0;
        }
        }
		// Pathfinding }
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
		return BodyConstants.U;
	}
	
	//Thinking voids {
	protected void think() {
		//Thinking {
		//See "classpath:/images/Characters/Pen/Thinking/Think.png" for a human readable version of pen's thinking.
		if (weaknessAgainstRanged!=0||weaknessAgainstMid!=0||weaknessAgainstMelee!=0) {
			previousinfo=true;
			if (weaknessAgainstMid==weaknessAgainstRanged) {
				// If the target is equally weak/strong against attacks, don't try to target a weakness.
				previousinfo=false;
			}
			if (weaknessAgainstMid>weaknessAgainstRanged) {
				weakAgainstMid=true;
				weakAgainstRanged=false;
			}
			if (weaknessAgainstRanged>weaknessAgainstMid) {
				weakAgainstRanged=true;
				weakAgainstMid=false;
			}
			if(weaknessAgainstMelee>(weaknessAgainstMid+weaknessAgainstRanged)/2) {
				weakAgainstMelee=true;
				weakAgainstMid=false;
				weakAgainstRanged=false;
			}
		}
		if (distance<=15&&distance>7) {
			if (previousinfo==false) {
				if (Math.random()*(10)<=5) {
					doingRangedAttack=true;
				} else {
					following=true;
				}
			}
			if (previousinfo==true) {
				if (weakAgainstRanged==true) {
					doingRangedAttack=true;
				}
				if (weakAgainstMelee==true) {
					following=true;
				}
			}
		}
		if (distance>4&&distance<=7) {
			if (hasSword==true||weakAgainstMid==true) {
				doingMidAttack=true;
			}
			if (!hasSword&&weakAgainstMid==false) {
				following=true;
			}
		}
		if (distance<=4) {
			if(hasSword) {
				runningAway=true;
			}
			if(!hasSword) {
				doingMeleeAttack=true;
			}
		}
		
		//Thinking }
	}
	//Thinking voids }
	//Movement voids
	protected void locatePlayer() {
        List<Body> PlayerCoords = game.search(BodyConstants.P);
        if(PlayerCoords.size()>0) {
        	Body b = PlayerCoords.get(coord);
        	PlayerX = b.getX();
        	PlayerY = b.getY();
        }
        dx= PlayerX - getX();
        dy= PlayerY - getY();
        distance = Math.sqrt((dx*dx)+(dy*dy));
	}
	protected void follow() {
    	//Following {
    	if (following) {
        	if (PlayerX>getX()) {
        		move(Direction.Right);
        	}
        	if (PlayerY>getY()) {
        		move(Direction.Down);
        	}
        	if (PlayerX<getX()) {
        		move(Direction.Left);
        	}
        	if (PlayerY<getY()) {
        		move(Direction.Up);
        	}
    	}
    	//Following }
		following=false;
	}
	protected void run() {
    	//Running away {
    	if (runningAway==true) {
    		if (getX()>PlayerX) {
    			move(Direction.Right);
    		}
    		if (getX()<PlayerX) {
    			move(Direction.Left);
    		}
    		if (getY()>PlayerY) {
    			move(Direction.Up);
    		}
    		if (getY()<PlayerY) {
    			move(Direction.Down);
    		}
    		if (getX()==PlayerX) {
    			if (Math.random()*(10)<=5) {
    				move(Direction.Right);
    			} else {
    				move(Direction.Left);
    			}
    		}
    		if (getY()==PlayerY) {
    			if (Math.random()*(10)<=5) {
    				move(Direction.Up);
    			} else {
    				move(Direction.Down);
    			}
    		}
    	}
    	
    	//Running away }
		runningAway=false;
	}
	
	//Attack voids
	protected void rangedAttack() {
		if (doingRangedAttack) {
			spriteIndex=6;
			
			if(PlayerY==getY()) {
				if (PlayerX>getX()) {
					layer.addBody(new Pen_Ranged_Attack(game, layer, getX()+1, getY(), 2));
				}
				if (PlayerX<getX()) {
					layer.addBody(new Pen_Ranged_Attack(game, layer, getX()-1, getY(), 1));
				}
			}
			if(PlayerX==getX()) {
				if (PlayerY>getY()) {
					layer.addBody(new Pen_Ranged_Attack(game, layer, getX(), getY()-1, 4));	
				}
				if (PlayerY<getY()) {
					layer.addBody(new Pen_Ranged_Attack(game, layer, getX(), getY()+1, 3));
				}
			}
		}
		doingRangedAttack=false;
	}
	protected void midAttack() {
	if (doingMidAttack) {
		spriteIndex=7;
		if (PlayerX>getX()) {
			layer.addBody(new Pen_Mid_Attack(game, layer, getX()+1, getY(), 2));
		}
		if (PlayerX<getX()) {
			layer.addBody(new Pen_Mid_Attack(game, layer, getX()+1, getY(), 1));
		}
	}
	if(PlayerX==getX()) {
		if (PlayerY>getY()) {
			layer.addBody(new Pen_Mid_Attack(game, layer, getX(), getY()-1, 4));	
		}
		if (PlayerY<getY()) {
			layer.addBody(new Pen_Mid_Attack(game, layer, getX(), getY()+1, 3));
		}
	}
	doingMidAttack=false;
	}
	protected void meleeAttack() {
		if (getX()<4+PlayerX&&getX()>PlayerX-4) {
			if (getX()>PlayerX) {
				spriteIndex=8;
				move(Direction.Left);
			}
			if (getX()<PlayerX) {
				spriteIndex=9;
				move(Direction.Right);
			}
			if (distance==0) {
				weaknessAgainstMelee++;
				((GameDemo)game).hp=((GameDemo)game).hp-1;
			}
		}
		doingMeleeAttack=false;
	}
	


}

