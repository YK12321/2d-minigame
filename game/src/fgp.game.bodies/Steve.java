/**
 * 
 */
package fgp.game.bodies;

import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.engine.inputs.Keyboarder;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;

/**
 * @author YK12321
 *
 */

public class Steve extends Body implements Keyboarder{
	/**
	 * @param g
	 * @param l
	 * @param x
	 * @param y
	 */
	static boolean Gravity=true;
	boolean Falling=false;
	public static boolean Protected=false;
	int a=0;
	int relativeXToFrame=12;
	int relativeYToFrame=5;
	public static boolean stevehassaid=false;
	public Steve(GameEngine g, Layer l, int x, int y) {
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

//		if(spriteIndex == 0) {
//		spriteIndex = 1;
//		}else {
//			spriteIndex = 0;
//		}
//		System.out.println(getX()+", "+getY());
// Offset fix {
//		if(game.getXOffset()>getX()-12) {
//			game.moveOffset(-1, 0);
//		}
//		if(game.getXOffset()<getX()-12) {
//			game.moveOffset(1, 0);
//		}
//		if(game.getYOffset()>getY()) {
//			game.moveOffset(0, -1);
//		}
//		if(game.getYOffset()<getY()) {
//			game.moveOffset(0, 1);
//		}
// Offset fix }
		if(stevehassaid==true) {
			setSpeech(60, "Don't go near that goomba");
			stevehassaid=false;
		}
			
		if (game.getCurrentLevel()==2) {
			Gravity=false;
		}
		
		//Don't go off stage {
		if(game.getCurrentLevel()==1||game.getCurrentLevel()==2) {
		if (getX()>25) {
			move(Direction.Left);
		}
		if (getX()<0) {
			move(Direction.Right);
		}
		if (getY()<0) {
			move(Direction.Down);
		}
		if (getY()>9) {
			move(Direction.Up);
		}
		}
	    // }
		
		//gravity
		gravityTime++;
		if(Gravity==true&& gravityTime >= 15) {
			move(Direction.Down);
			gravityTime = 0;
		}
		if(a>=3) {
			a=0;
		}
		
		a++;
		super.advance2();
	}

	private int gravityTime;
	
	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if(dy==1) {
			Falling=false;
		}
//Poweup SHIELD Collision
		if (b.getSpriteId()==BodyConstants.Z) {
			if (fgp.game.bodies.Sheild.exists==true) {
			Protected=true;
			game.remove(b);
			}
			return true;
		}
//ASTEROID Collision
		if (b.getSpriteId()==BodyConstants.R) {
			if (dy!=1&&Protected==false) {
				setSpeech(60, "Ouch!");
				game.addScore(-5);
			((GameDemo)game).hp=((GameDemo)game).hp-1;
			return false;
			} if (dy!=1&&fgp.game.bodies.Steve.Protected==true) {
				setSpeech(60, "Nice");
				game.addScore(25);
				JOptionPane.showMessageDialog(null, "Your sheild turned the asteroid to dust");
				game.remove(b);
				return true;
			}
			if (dy==1) {
				if (fgp.game.bodies.Steve.Protected==false&&fgp.game.bodies.Asteroid.shieldremindersent==false) {
				    b.setSpeech(60, "Go get the shield.");	
					JOptionPane.showMessageDialog(null, "Congratulations on breaking the asteroid, as a reward, you got the sheild.");
					fgp.game.bodies.Sheild.exists=true;
					fgp.game.bodies.Asteroid.shieldremindersent=true;
					}
				game.remove(b);
				return true;
			}
		}
//DOOR Collision
		if (b.getSpriteId()==BodyConstants.D) {
			if (game.getCurrentLevel()==1) {
				if (((GameDemo)game).key==2&&((Door)b).Open==false) {
					((Door)b).Open=true;
					((GameDemo)game).key=((GameDemo)game).key-2;
					return true;
				}
				if (((GameDemo)game).key>2&&((Door)b).Open==false) {
					JOptionPane.showMessageDialog(null, "<html><font color='RED'>No hacking!</font></html>");
					game.gameOver();
					System.exit(0);
				}
				if (((GameDemo)game).key<2&&((Door)b).Open==false) {
				    JOptionPane.showMessageDialog(null, "You need 2x keys to go through this gate, (maybe try stomping goombas for keys)"+" Currently, you have: "+((GameDemo)game).key+" keys.");
				    return false;
				}
				if (((Door)b).Open==true) {
					return true;
				}
			}
		}
//GRASS_LIVING Collision		
		if (b.getSpriteId()==BodyConstants.G) {
			return false;
		}
//PORTAL Collision
		if (b.getSpriteId()==BodyConstants.E) {
			System.out.println(((GameDemo)game).key);
			game.changeLevel(2);
			game.addScore(100);
			game.remove(b);
			return true;
		}
		
//MARIO Collision
                if (b.getSpriteId()==BodyConstants.M) {
			if (dy == 1) {
				game.remove(b);
				return true;
			}
			if(dy!=1) {
				return false;	
			}
		}
//Non-existent Collisions
                  if(b.getSpriteId()==BodyConstants.Y&&fgp.game.bodies.Glitched_projectile.glitch_this_exists==false) {
                	  return true;
                  }
          		if (b.getSpriteId()==BodyConstants.W) {
        			return true;
        		}
// Lightning Collision
          		if (b.getSpriteId()==BodyConstants.O) {
          			return true;
          		}
                
//GOOMBA Collision
if (b.getSpriteId()==BodyConstants.B) {
		if (b.getSpriteId()==BodyConstants.B&&((Goomba)b).stomped==false) {
			if (dy==1){
				
					if(b.getSpriteId()==BodyConstants.B) {
						((Goomba)b).stomped=true;
						game.addScore(50);
						((GameDemo)game).key=((GameDemo)game).key+1;
					
				}
				return true;
			}}
		if (dy!=1&&((Goomba)b).stomped==true) {
			game.remove(b);
			setSpeech(120, "Don't worry, it is just a splash potion of invisibility.");
			JOptionPane.showMessageDialog(null, "Goomba Magically Disappered (Stealing some of your score)");
			game.addScore(-10);
		}
		
		
		if (dy==1&&((Goomba)b).stomped==true) {
			((Goomba)b).angry=true;
			return true;
		}
}
		return false;
	}
	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.P;
	}

	@Override
	public void keyDown(int keycode, int modifiers) {
		if (game.getCurrentLevel()==3) {
			//bug in scrolling when the scrolling moves up (also causes any systems using coordinates getX(), getY(), etc. to work incorrectly)
			//Fix: removing scrolling altogether.
			//Update 1: components requiring scrolling removed from Background Layer.
			//Update 2: added "//" in front of components of scrolling
			//Update 3: added "#" in front of bug causing code
			//Update 4: Changed the spawning coordinates of Steve and Pen, to make the game playable without scrolling.
			if(keycode=='W') {move(Direction.Up);
			// # game.moveOffset(0, (-1));
			spriteIndex = 3;}
		}
		
		if(keycode=='W'||keycode==KeyEvent.VK_UP&&Falling==false&&game.getCurrentLevel()!=3) {
			move(Direction.Up);
			if (Gravity) {
			Falling=true;
			gravityTime=0;}
			if (Protected==false) {
				spriteIndex = 3;
			} if (Protected==true) {
				spriteIndex = 7;
			}
		}
		if (keycode=='A'||keycode==KeyEvent.VK_LEFT) {
//			game.moveOffset(-1, 0);
			move(Direction.Left);
			if (Protected==false) {
				spriteIndex = 1;
			} if (Protected==true) {
				spriteIndex=5;
			}
		}
		if (keycode=='S'||keycode==KeyEvent.VK_DOWN) {
//			game.moveOffset(0, 1);
			move(Direction.Down);
			
			if (Protected==false) {
				spriteIndex = 2;
			}
			
			if (Protected==true) {
				spriteIndex = 6;
			}
		}
		if (keycode=='K'&&game.isDebugEnabled()==true) {
			game.remove(game.search(BodyConstants.R));
		}
		if (keycode=='D'||keycode==KeyEvent.VK_RIGHT) {
//			game.moveOffset(1, 0);
			move(Direction.Right);
			if (Protected==false) {
				spriteIndex = 0;
			}
			if (Protected==true) {
				spriteIndex = 4;
			}
		}
		if (keycode=='W'&&keycode=='A'||keycode==KeyEvent.VK_UP&&keycode==KeyEvent.VK_LEFT) {
		if (Falling==false) {
			move(Direction.UpLeft);
		} else {
			move(Direction.Left);
		}
		
		spriteIndex = 1;
		}
		if (keycode=='W'&&keycode=='D'||keycode==KeyEvent.VK_UP&&keycode==KeyEvent.VK_RIGHT) {
			
			if (Falling==false) {
			move(Direction.UpRight);
			} else {
				move(Direction.Right);
			}
			
			spriteIndex=0;
		}
		}

	@Override
	public void keyUp(int keycode, int modifiers) {
		// TODO Auto-generated method stub
		
	}

}
