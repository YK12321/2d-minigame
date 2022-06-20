package fgp.game.bodies;

import java.util.List;

import javax.swing.JOptionPane;

import fgp.engine.Body;
import fgp.engine.Direction;
import fgp.engine.GameEngine;
import fgp.engine.Layer;
import fgp.game.GameDemo;
import fgp.game.constants.BodyConstants;

public class Glitched_goomba extends Body {

	public Glitched_goomba(GameEngine g, Layer l, int x, int y) {
		super(g, l, x, y);
		// TODO Auto-generated constructor stub
	}
int i =0;
boolean reverse=false;
float dx=0;
float dy=0;
static int PlayerX = 0;
static int PlayerY = 9;
int a=0;
double distance = 0;
int movedelay=0;
	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void advance2() {
		// TODO Auto-generated method stub
		//Checks to see if asteroids are destroyed
		List<Body> Asteroidlookup = game.search(BodyConstants.R);
		if (Asteroidlookup.size()==0) {
			setSpeech(15, ""
					+ ""
					+ ""
					+ ""
					+ ""
					+ ""
					+ "Ә̸̢͚͈̉̊́̀̔ͅͅl̶͍̮̘͈͚͋̊̈́́̚ȉ̵̡̞̲̰̘̃̏̃̍Ɉ̵̢̱͚͉̰̀̿̀̓͠ɔ̵͕̙͕͇̩̎̿̿͊͠ʜ̷͙͍͉̝̰͗̌͐̈́͐ ̶̤̞̺̳͚̒̂̈́̊̋T̸̮̳͇͚̻̿̄̋͘̕ǝ̸̜̞̩̻̎̔̍́̂ͅx̵̧̣̤̖̺̓̐͗̐̽Ɉ̴͍̺͉̟͖̾͒̚͠͝ ̶̺̤̪̬͚͗̑̀̔̕Ә̸̣̲̦͇̫́̂̇͆̂ǝ̷̛͚̺͔͚̳͐͒̄͝n̴͙͇̖̙̠͛͐͋͒̇ǝ̶̨̜̲̗̼̒̔̕̚͝ɿ̴̡̪̲̦̞̃̑͗̃͝ɒ̴̨͈͈͎͚̄̽́͆̅Ɉ̷̲̰̯̲̎̂̉̾͋ͅó̶̢̢̝̦̫̒͛̓̔ɿ̴̧̪̦͉͋͑͂̚͜͠"
					+ ""
					+ ""
					+ "");
			fgp.game.bodies.Glitched_projectile.glitch_this_exists=true;
		}
		//Pathfinding{
        List<Body> search = game.search(BodyConstants.P);
        if(search.size()>0) {
        	Body b = search.get(a);
        	PlayerX = b.getX();
        	PlayerY = b.getY();
        }
        dx= PlayerX - getX();
        dy= PlayerY - getY();
        distance = Math.sqrt((dx*dx)+(dy*dy));
       
    if (movedelay>=5) {
        if (distance<=15) {
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
        if(movedelay==5) {
        	movedelay=0;
        }
        }
		
		
		
		//Pathfinding }
    if (distance>15) {
    	spriteIndex=81;
    }
if (distance<=15) {
    fgp.game.bodies.Steve.stevehassaid=true;
	//Animating {
	
		if (reverse==false&&i<=79) {
			spriteIndex=i;
			i++;
			if (i==79) {
				reverse=true;
			}
		}
		if(i>=0&&reverse==true) {
			spriteIndex=i;
			i--;
			if(i==0) {
				reverse=false;
			}
		}
		//Animating }
}
		//Timers{
		movedelay++;
		//Timers}
		super.advance2();
	}

	@Override
	protected boolean collision(Body b, int dx, int dy) {
		// TODO Auto-generated method stub
		if (b.getSpriteId()==BodyConstants.P) {
			((GameDemo)game).hp=((GameDemo)game).hp-1;
			
			
			
			//Glitched Text {	
			
			
			setSpeech(30, "G̢̢̢̛̭̫̼͇̗̲̙̠̬̙̎̈̅̏̂͋͒̑̎̾̕̚o̧͇̪͖͖͛̅̐̍̿̇͘͜͢ǫ̣̤̳͖̬̞̼̼͉̩̫̞̘̫̲͕̞͖̠͎̞̰̮̝̰̒̒͌̄͌̿̅̍̃̌̅͋̀̌͋̾́͛͋̄̒̿̚̚͘͜͞͡m̢̢̢̧̛̛͉̞͉̣͔̤̤̮̺̜̙̭̭̦͎̹̥̼͈̰̺̟̯͌̑͐̈̐̋͛̀̀͒͗́͒̔̾̏̏̔͑̃̌̃͋͌͘̚̕͜͟͟͢͠͡͞ͅb̡̢̛̖̟̤͖̣̞͔̦͇̱̻̈́̊̈͋͒̒͛͊̇͘̕͢͠͝ą̤̣̝̘̺̲̞͚͕̪͙̼̙̖̜͈͛̃́̽̀̈̂̋͊͌͐̑̉͋̿͊̚̕͘͜͢ ̢̛̝̳̦̜͙̲̲̖͔̱̲̗̣̘͈͋̿̊̎̇̇̃̿̿̾̓͌̔̕͟͢͡͝͡͞ͅw͚̪̯̆͌̆̃̈́͜ͅa̢̙͇̩͈̦̜͈͚̻̫͊͗̾̃̄͛͂̔̚͘̕ņ̮̗̘̟̬̆̿͑̍͛́t̝̩̥͋̄̚s̢̛̛̪͈̰̥̖̩͍̮̗̳̪̳͖͈̫͉̘̼͙̩̦̘͇͓̠̝̙̼͒͑͋̓̅͒̆̍͂̋̑͌͒̍̌͆̏͊͌͌̑̿̇͒͘̕͜͟͠͞͞͡ͅ ̥̹̭̹̭̼͈̱̗͎͕̬͚̮̳͕̳͈̟͗̌͛̈̽̉͋̐̆̆̉͊̾̂̀̿͌̐̕͘͢͝ͅŗ̛̛̮̜̭̮̗͓̺̣̰͔̝̳͉̳̙̝͍̜͙͇̮̪͔̠̗͚̺͊̎̑̊̎͑̆͑́͊̈́͒͑̐̈̅̓͑̆̓̊̕͘̕͘̚͟͜͡͠e̡͈̬̞̻̞̤̙̲̙̐̍͗́̂̄͒̇̌̒͜͡v̡̢̧̧̢̛̹̰͇̻̗̦̖̝͙̹̝̠̻͇̘̞̱̫̯̦͈̮̒͑̾̇̑̅̀͒̆̑͋͛͌̆̏̂̀̈̇̏̔̌̇͗̐̑͘͘͘͜͢͜͟͢͝͡͠ͅè͍͉̫̘̞͈̼͖̐̒͊͑̏̆̉n̡̡̤̺̟͕̗͈͚̣͈͈̗̯̣̩̪̫̻̟̗̥̩̰̳̓͑̉̀̾͋̐́͗͑̌̂̌̽̈̈́̉̎̓̂̋̅͘͟͟͠͡͠͞ǵ̛̹̹̥͔̺̩̗̱̦̭͎͚͈͖̥̓̍̔̒͆̃͊͒̑̇̾͒͞ȩ̱̟̺͚͓͉̝̥̗̙͙̟̫̲͕͔̼̫̰̗̖̜͓͍̼̺͇̫͇͖̫̫̍̐̀͒͆̏̔̓̃͐̅̌͛̎͌͒̐͊̄̍͊͛̎͑̅͂̑̐̀͘̚̕͟͜͞͝͝!͍̝̮̲͉̟͕̲̯̣͛́̎̊́̏̽́͒̊̏̋̍͢͢͜͢͡");
		
			
			//Glitched Text }
		
		
		}
		if (b.getSpriteId()==BodyConstants.R) {
			return true;
		}
		if (b.getSpriteId()==BodyConstants.Y) {
			return true;
		}
		if (b.getSpriteId()==BodyConstants.Z) {
			return true;
		}
		return false;
	}

	@Override
	public char getSpriteId() {
		// TODO Auto-generated method stub
		return BodyConstants.Q;
	}

}
