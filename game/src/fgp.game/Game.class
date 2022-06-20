/**
 * 
 */
package fgp.game;

import java.net.http.HttpResponse.BodyHandler;
import java.util.logging.Level;

import fgp.engine.GameEngine;
import fgp.game.constants.BodyConstants;
import fgp.game.constants.LayerConstants;
import fgp.game.layers.BackgroundImageLayer;
import fgp.game.layers.BackgroundLayer;
import fgp.game.layers.CharactersLayer;
import fgp.game.layers.StatusLayer;
import fgp.ui.FrmLauncher;

/**
 * @author YK12321
 *
 */
public class GameDemo extends GameEngine {

	public static void main(String[] args) {

		FrmLauncher.launch(new GameDemo());

	}

	/**
	 * @param cls
	 */
	public int hp = 5;
	public int key = 0;

	public GameDemo() {
		super(GameDemo.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTargetFps() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	public String getGameTitle() {
		// TODO Auto-generated method stub
		return "So the game begins.";
	}

	@Override
	protected int getLevels() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void loadSprites() {
		// TODO Auto-generated method stub
		addSprite(BodyConstants.G, 0, "images/Background/Grass_Living", "Grass_Living_M.png");
		addSprite(BodyConstants.P, 0, "images/Characters/Steve", "characterRight_M.png");
		addSprite(BodyConstants.P, 1, "images/Characters/Steve", "characterLeft_M.png");
		addSprite(BodyConstants.P, 2, "images/Characters/Steve", "characterDown_M.png");
		addSprite(BodyConstants.P, 3, "images/Characters/Steve", "characterUp_M.png");
		addSprite(BodyConstants.P, 4, "images/Characters/Steve", "characterRight_M_Protected-1.png");
		addSprite(BodyConstants.P, 5, "images/Characters/Steve", "characterLeft_M_Protected-1.png");
		addSprite(BodyConstants.P, 6, "images/Characters/Steve", "characterDown_M_Protected-1.png");
		addSprite(BodyConstants.P, 7, "images/Characters/Steve", "characterUp_M_Protected-1.png");
		addSprite(BodyConstants.B, 0, "images/Characters/Goomba", "Goomba_0.png");
		addSprite(BodyConstants.B, 1, "images/Characters/Goomba", "Goomba_1.png");
		addSprite(BodyConstants.B, 2, "images/Characters/Goomba", "Goomba_2.png");
		addSprite(BodyConstants.B, 3, "images/Characters/Goomba", "Goomba_3.png");
		addSprite(BodyConstants.E, 0, "images/Background/Portal", "Portal_1.png");
		addSprite(BodyConstants.E, 1, "images/Background/Portal", "Portal_2.png");
		addSprite(BodyConstants.E, 2, "images/Background/Portal", "Portal_3.png");
		addSprite(BodyConstants.E, 3, "images/Background/Portal", "Portal_4.png");
		addSprite(BodyConstants.E, 4, "images/Background/Portal", "Portal_5.png");
		addSprite(BodyConstants.E, 5, "images/Background/Portal", "Portal_6.png");
		addSprite(BodyConstants.L, 0, "images/Background/Lucky_Block", "Lucky-block_1.png");
		addSprite(BodyConstants.D, 0, "images/Background/Door", "Door_0.png");
		addSprite(BodyConstants.D, 1, "images/Background/Door", "Door_1.png");
		addSprite(BodyConstants.R, 0, "images/Background/Asteroid", "Asteroid_0.png");
		addSprite(BodyConstants.Z, 0, "images/Background/Shield", "Shield_0.png");
		addSprite(BodyConstants.Z, 1, "images/Background/Shield", "Shield_1.png");
		addSprite(BodyConstants.Q, 81, "images/Characters/Goomba", "Goomba_0.png");
		addSprite(BodyConstants.Y, 0, "images/Characters/Glitch_loader", "Glitch-Loader_Invisible.png");
		//Pen {
		addSprite(BodyConstants.U, 0, "images/Characters/Pen/Normal", "Pen_Idle.png");
		addSprite(BodyConstants.U, 1, "images/Characters/Pen/Normal", "Pen_Laughing.png");
		addSprite(BodyConstants.U, 2, "images/Characters/Pen/Normal", "Pen_Diagonal_UL.png");
		addSprite(BodyConstants.U, 3, "images/Characters/Pen/Normal", "Pen_Diagonal_UR.png");
		addSprite(BodyConstants.U, 4, "images/Characters/Pen/Normal", "Pen_Diagonal_DR.png");
		addSprite(BodyConstants.U, 5, "images/Characters/Pen/Normal", "Pen_Diagonal_DL.png");
		addSprite(BodyConstants.U, 6, "images/Characters/Pen/Ready_for_attack/Lightning", "Pen_Ready.png");
		addSprite(BodyConstants.U, 7, "images/Characters/Pen/Ready_for_attack/Mid", "Pen_Ready.png");
		addSprite(BodyConstants.U, 8, "images/Characters/Pen/Attacks/Melee", "Attack_Left.png");
		addSprite(BodyConstants.U, 9, "images/Characters/Pen/Attacks/Melee", "Attack_Right.png");
		//Pen }
		// Pen's attacks {

		// Ranged attack {
		addSprite(BodyConstants.O, 0, "images/Characters/Pen/Attacks/Lightning", "Attack_Up.png");
		addSprite(BodyConstants.O, 1, "images/Characters/Pen/Attacks/Lightning", "Attack_Left.png");
		addSprite(BodyConstants.O, 2, "images/Characters/Pen/Attacks/Lightning", "Attack_Down.png");
		addSprite(BodyConstants.O, 3, "images/Characters/Pen/Attacks/Lightning", "Attack_Right.png");
		// Ranged attack }
		
		// Mid attack {
		addSprite(BodyConstants.I, 0, "images/Characters/Pen/Attacks/Mid", "Attack_Up.png");
		addSprite(BodyConstants.I, 1, "images/Characters/Pen/Attacks/Mid", "Attack_Left.png");
		addSprite(BodyConstants.I, 2, "images/Characters/Pen/Attacks/Mid", "Attack_Down.png");
		addSprite(BodyConstants.I, 3, "images/Characters/Pen/Attacks/Mid", "Attack_Right.png");	
		// Mid attack }
		
		// The sprites for melee attack are in the Pen's sprites, as there aren't any projectiles involved in the melee attack
		
		// Pen's attacks }
		//Animated Glitched_Projectile{
		addSprite(BodyConstants.Y, 1, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_1.png");
		addSprite(BodyConstants.Y, 2, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_2.png");
		addSprite(BodyConstants.Y, 3, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_3.png");
		addSprite(BodyConstants.Y, 4, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_4.png");
		addSprite(BodyConstants.Y, 5, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_5.png");
		addSprite(BodyConstants.Y, 6, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_6.png");
		addSprite(BodyConstants.Y, 7, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_7.png");
		addSprite(BodyConstants.Y, 8, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_8.png");
		addSprite(BodyConstants.Y, 9, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_9.png");
		addSprite(BodyConstants.Y, 10, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_10.png");
		addSprite(BodyConstants.Y, 11, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_11.png");
		addSprite(BodyConstants.Y, 12, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_12.png");
		addSprite(BodyConstants.Y, 13, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_13.png");
		addSprite(BodyConstants.Y, 14, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_14.png");
		addSprite(BodyConstants.Y, 15, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_15.png");
		addSprite(BodyConstants.Y, 16, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_16.png");
		addSprite(BodyConstants.Y, 17, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_17.png");
		addSprite(BodyConstants.Y, 18, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_18.png");
		addSprite(BodyConstants.Y, 19, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_19.png");
		addSprite(BodyConstants.Y, 20, "images/Characters/Glitch_loader/Animation", "Glitch-Loader_20.png");

		//Animated Glitched_Projectile}
		//Animated Glitched_Goomba
		addSprite(BodyConstants.Q, 0, "images/Characters/Glitched_goomba", "Glitched-goomba (1).png");
		addSprite(BodyConstants.Q, 1, "images/Characters/Glitched_goomba", "Glitched-goomba (2).png");
		addSprite(BodyConstants.Q, 2, "images/Characters/Glitched_goomba", "Glitched-goomba (3).png");
		addSprite(BodyConstants.Q, 3, "images/Characters/Glitched_goomba", "Glitched-goomba (4).png");
		addSprite(BodyConstants.Q, 4, "images/Characters/Glitched_goomba", "Glitched-goomba (5).png");
		addSprite(BodyConstants.Q, 5, "images/Characters/Glitched_goomba", "Glitched-goomba (6).png");
		addSprite(BodyConstants.Q, 6, "images/Characters/Glitched_goomba", "Glitched-goomba (7).png");
		addSprite(BodyConstants.Q, 7, "images/Characters/Glitched_goomba", "Glitched-goomba (8).png");
		addSprite(BodyConstants.Q, 8, "images/Characters/Glitched_goomba", "Glitched-goomba (9).png");
		addSprite(BodyConstants.Q, 9, "images/Characters/Glitched_goomba", "Glitched-goomba (10).png");
		addSprite(BodyConstants.Q, 10, "images/Characters/Glitched_goomba", "Glitched-goomba (11).png");
		addSprite(BodyConstants.Q, 11, "images/Characters/Glitched_goomba", "Glitched-goomba (12).png");
		addSprite(BodyConstants.Q, 12, "images/Characters/Glitched_goomba", "Glitched-goomba (13).png");
		addSprite(BodyConstants.Q, 13, "images/Characters/Glitched_goomba", "Glitched-goomba (14).png");
		addSprite(BodyConstants.Q, 14, "images/Characters/Glitched_goomba", "Glitched-goomba (15).png");
		addSprite(BodyConstants.Q, 15, "images/Characters/Glitched_goomba", "Glitched-goomba (16).png");
		addSprite(BodyConstants.Q, 16, "images/Characters/Glitched_goomba", "Glitched-goomba (17).png");
		addSprite(BodyConstants.Q, 17, "images/Characters/Glitched_goomba", "Glitched-goomba (18).png");
		addSprite(BodyConstants.Q, 18, "images/Characters/Glitched_goomba", "Glitched-goomba (19).png");
		addSprite(BodyConstants.Q, 19, "images/Characters/Glitched_goomba", "Glitched-goomba (20).png");
		addSprite(BodyConstants.Q, 20, "images/Characters/Glitched_goomba", "Glitched-goomba (21).png");
		addSprite(BodyConstants.Q, 21, "images/Characters/Glitched_goomba", "Glitched-goomba (22).png");
		addSprite(BodyConstants.Q, 22, "images/Characters/Glitched_goomba", "Glitched-goomba (23).png");
		addSprite(BodyConstants.Q, 23, "images/Characters/Glitched_goomba", "Glitched-goomba (24).png");
		addSprite(BodyConstants.Q, 24, "images/Characters/Glitched_goomba", "Glitched-goomba (25).png");
		addSprite(BodyConstants.Q, 25, "images/Characters/Glitched_goomba", "Glitched-goomba (26).png");
		addSprite(BodyConstants.Q, 26, "images/Characters/Glitched_goomba", "Glitched-goomba (27).png");
		addSprite(BodyConstants.Q, 27, "images/Characters/Glitched_goomba", "Glitched-goomba (28).png");
		addSprite(BodyConstants.Q, 28, "images/Characters/Glitched_goomba", "Glitched-goomba (29).png");
		addSprite(BodyConstants.Q, 29, "images/Characters/Glitched_goomba", "Glitched-goomba (30).png");
		addSprite(BodyConstants.Q, 30, "images/Characters/Glitched_goomba", "Glitched-goomba (31).png");
		addSprite(BodyConstants.Q, 31, "images/Characters/Glitched_goomba", "Glitched-goomba (32).png");
		addSprite(BodyConstants.Q, 32, "images/Characters/Glitched_goomba", "Glitched-goomba (33).png");
		addSprite(BodyConstants.Q, 33, "images/Characters/Glitched_goomba", "Glitched-goomba (34).png");
		addSprite(BodyConstants.Q, 34, "images/Characters/Glitched_goomba", "Glitched-goomba (35).png");
		addSprite(BodyConstants.Q, 35, "images/Characters/Glitched_goomba", "Glitched-goomba (36).png");
		addSprite(BodyConstants.Q, 36, "images/Characters/Glitched_goomba", "Glitched-goomba (37).png");
		addSprite(BodyConstants.Q, 37, "images/Characters/Glitched_goomba", "Glitched-goomba (38).png");
		addSprite(BodyConstants.Q, 38, "images/Characters/Glitched_goomba", "Glitched-goomba (39).png");
		addSprite(BodyConstants.Q, 39, "images/Characters/Glitched_goomba", "Glitched-goomba (40).png");
		addSprite(BodyConstants.Q, 40, "images/Characters/Glitched_goomba", "Glitched-goomba (41).png");
		addSprite(BodyConstants.Q, 41, "images/Characters/Glitched_goomba", "Glitched-goomba (42).png");
		addSprite(BodyConstants.Q, 42, "images/Characters/Glitched_goomba", "Glitched-goomba (43).png");
		addSprite(BodyConstants.Q, 43, "images/Characters/Glitched_goomba", "Glitched-goomba (44).png");
		addSprite(BodyConstants.Q, 44, "images/Characters/Glitched_goomba", "Glitched-goomba (45).png");
		addSprite(BodyConstants.Q, 45, "images/Characters/Glitched_goomba", "Glitched-goomba (46).png");
		addSprite(BodyConstants.Q, 46, "images/Characters/Glitched_goomba", "Glitched-goomba (47).png");
		addSprite(BodyConstants.Q, 47, "images/Characters/Glitched_goomba", "Glitched-goomba (48).png");
		addSprite(BodyConstants.Q, 48, "images/Characters/Glitched_goomba", "Glitched-goomba (49).png");
		addSprite(BodyConstants.Q, 49, "images/Characters/Glitched_goomba", "Glitched-goomba (50).png");
		addSprite(BodyConstants.Q, 50, "images/Characters/Glitched_goomba", "Glitched-goomba (51).png");
		addSprite(BodyConstants.Q, 51, "images/Characters/Glitched_goomba", "Glitched-goomba (52).png");
		addSprite(BodyConstants.Q, 52, "images/Characters/Glitched_goomba", "Glitched-goomba (53).png");
		addSprite(BodyConstants.Q, 53, "images/Characters/Glitched_goomba", "Glitched-goomba (54).png");
		addSprite(BodyConstants.Q, 54, "images/Characters/Glitched_goomba", "Glitched-goomba (55).png");
		addSprite(BodyConstants.Q, 55, "images/Characters/Glitched_goomba", "Glitched-goomba (56).png");
		addSprite(BodyConstants.Q, 56, "images/Characters/Glitched_goomba", "Glitched-goomba (57).png");
		addSprite(BodyConstants.Q, 57, "images/Characters/Glitched_goomba", "Glitched-goomba (58).png");
		addSprite(BodyConstants.Q, 58, "images/Characters/Glitched_goomba", "Glitched-goomba (59).png");
		addSprite(BodyConstants.Q, 59, "images/Characters/Glitched_goomba", "Glitched-goomba (60).png");
		addSprite(BodyConstants.Q, 60, "images/Characters/Glitched_goomba", "Glitched-goomba (61).png");
		addSprite(BodyConstants.Q, 61, "images/Characters/Glitched_goomba", "Glitched-goomba (62).png");
		addSprite(BodyConstants.Q, 62, "images/Characters/Glitched_goomba", "Glitched-goomba (63).png");
		addSprite(BodyConstants.Q, 63, "images/Characters/Glitched_goomba", "Glitched-goomba (64).png");
		addSprite(BodyConstants.Q, 64, "images/Characters/Glitched_goomba", "Glitched-goomba (65).png");
		addSprite(BodyConstants.Q, 65, "images/Characters/Glitched_goomba", "Glitched-goomba (66).png");
		addSprite(BodyConstants.Q, 66, "images/Characters/Glitched_goomba", "Glitched-goomba (67).png");
		addSprite(BodyConstants.Q, 67, "images/Characters/Glitched_goomba", "Glitched-goomba (68).png");
		addSprite(BodyConstants.Q, 68, "images/Characters/Glitched_goomba", "Glitched-goomba (69).png");
		addSprite(BodyConstants.Q, 69, "images/Characters/Glitched_goomba", "Glitched-goomba (70).png");
		addSprite(BodyConstants.Q, 70, "images/Characters/Glitched_goomba", "Glitched-goomba (71).png");
		addSprite(BodyConstants.Q, 71, "images/Characters/Glitched_goomba", "Glitched-goomba (72).png");
		addSprite(BodyConstants.Q, 72, "images/Characters/Glitched_goomba", "Glitched-goomba (73).png");
		addSprite(BodyConstants.Q, 73, "images/Characters/Glitched_goomba", "Glitched-goomba (74).png");
		addSprite(BodyConstants.Q, 74, "images/Characters/Glitched_goomba", "Glitched-goomba (75).png");
		addSprite(BodyConstants.Q, 75, "images/Characters/Glitched_goomba", "Glitched-goomba (76).png");
		addSprite(BodyConstants.Q, 76, "images/Characters/Glitched_goomba", "Glitched-goomba (77).png");
		addSprite(BodyConstants.Q, 77, "images/Characters/Glitched_goomba", "Glitched-goomba (78).png");
		addSprite(BodyConstants.Q, 78, "images/Characters/Glitched_goomba", "Glitched-goomba (79).png");
		addSprite(BodyConstants.Q, 79, "images/Characters/Glitched_goomba", "Glitched-goomba (80).png");

		
		//Animated background {
		addSprite(BodyConstants.W,0, "images/AnimatedBackground", "Frame (1).jpg");
		addSprite(BodyConstants.W,1, "images/AnimatedBackground", "Frame (2).jpg");
		addSprite(BodyConstants.W,2, "images/AnimatedBackground", "Frame (3).jpg");
		addSprite(BodyConstants.W,3, "images/AnimatedBackground", "Frame (4).jpg");
		addSprite(BodyConstants.W,4, "images/AnimatedBackground", "Frame (5).jpg");
		addSprite(BodyConstants.W,5, "images/AnimatedBackground", "Frame (6).jpg");
		addSprite(BodyConstants.W,6, "images/AnimatedBackground", "Frame (7).jpg");
		addSprite(BodyConstants.W,7, "images/AnimatedBackground", "Frame (8).jpg");
		addSprite(BodyConstants.W,8, "images/AnimatedBackground", "Frame (9).jpg");
		addSprite(BodyConstants.W,9, "images/AnimatedBackground", "Frame (10).jpg");
		addSprite(BodyConstants.W,10, "images/AnimatedBackground", "Frame (11).jpg");
		addSprite(BodyConstants.W,11, "images/AnimatedBackground", "Frame (12).jpg");
		addSprite(BodyConstants.W,12, "images/AnimatedBackground", "Frame (13).jpg");
		addSprite(BodyConstants.W,13, "images/AnimatedBackground", "Frame (14).jpg");
		addSprite(BodyConstants.W,14, "images/AnimatedBackground", "Frame (15).jpg");
		addSprite(BodyConstants.W,15, "images/AnimatedBackground", "Frame (16).jpg");
		addSprite(BodyConstants.W,16, "images/AnimatedBackground", "Frame (17).jpg");
		addSprite(BodyConstants.W,17, "images/AnimatedBackground", "Frame (18).jpg");
		addSprite(BodyConstants.W,18, "images/AnimatedBackground", "Frame (19).jpg");
		addSprite(BodyConstants.W,19, "images/AnimatedBackground", "Frame (20).jpg");
		addSprite(BodyConstants.W,20, "images/AnimatedBackground", "Frame (21).jpg");
		addSprite(BodyConstants.W,21, "images/AnimatedBackground", "Frame (22).jpg");
		addSprite(BodyConstants.W,22, "images/AnimatedBackground", "Frame (23).jpg");
		addSprite(BodyConstants.W,23, "images/AnimatedBackground", "Frame (24).jpg");
		addSprite(BodyConstants.W,24, "images/AnimatedBackground", "Frame (25).jpg");
		addSprite(BodyConstants.W,25, "images/AnimatedBackground", "Frame (26).jpg");
		addSprite(BodyConstants.W,26, "images/AnimatedBackground", "Frame (27).jpg");
		addSprite(BodyConstants.W,27, "images/AnimatedBackground", "Frame (28).jpg");
		addSprite(BodyConstants.W,28, "images/AnimatedBackground", "Frame (29).jpg");
		addSprite(BodyConstants.W,29, "images/AnimatedBackground", "Frame (30).jpg");
		addSprite(BodyConstants.W,30, "images/AnimatedBackground", "Frame (31).jpg");
		addSprite(BodyConstants.W,31, "images/AnimatedBackground", "Frame (32).jpg");
		addSprite(BodyConstants.W,32, "images/AnimatedBackground", "Frame (33).jpg");
		addSprite(BodyConstants.W,33, "images/AnimatedBackground", "Frame (34).jpg");
		addSprite(BodyConstants.W,34, "images/AnimatedBackground", "Frame (35).jpg");
		addSprite(BodyConstants.W,35, "images/AnimatedBackground", "Frame (36).jpg");
		addSprite(BodyConstants.W,36, "images/AnimatedBackground", "Frame (37).jpg");
		addSprite(BodyConstants.W,37, "images/AnimatedBackground", "Frame (38).jpg");
		addSprite(BodyConstants.W,38, "images/AnimatedBackground", "Frame (39).jpg");
		addSprite(BodyConstants.W,39, "images/AnimatedBackground", "Frame (40).jpg");
		addSprite(BodyConstants.W,40, "images/AnimatedBackground", "Frame (41).jpg");
		addSprite(BodyConstants.W,41, "images/AnimatedBackground", "Frame (42).jpg");
		addSprite(BodyConstants.W,42, "images/AnimatedBackground", "Frame (43).jpg");
		addSprite(BodyConstants.W,43, "images/AnimatedBackground", "Frame (44).jpg");
		addSprite(BodyConstants.W,44, "images/AnimatedBackground", "Frame (45).jpg");
		addSprite(BodyConstants.W,45, "images/AnimatedBackground", "Frame (46).jpg");
		addSprite(BodyConstants.W,46, "images/AnimatedBackground", "Frame (47).jpg");
		addSprite(BodyConstants.W,47, "images/AnimatedBackground", "Frame (48).jpg");
		addSprite(BodyConstants.W,48, "images/AnimatedBackground", "Frame (49).jpg");
		addSprite(BodyConstants.W,49, "images/AnimatedBackground", "Frame (50).jpg");
		addSprite(BodyConstants.W,50, "images/AnimatedBackground", "Frame (51).jpg");
		addSprite(BodyConstants.W,51, "images/AnimatedBackground", "Frame (52).jpg");
		addSprite(BodyConstants.W,52, "images/AnimatedBackground", "Frame (53).jpg");
		addSprite(BodyConstants.W,53, "images/AnimatedBackground", "Frame (54).jpg");
		addSprite(BodyConstants.W,54, "images/AnimatedBackground", "Frame (55).jpg");
		addSprite(BodyConstants.W,55, "images/AnimatedBackground", "Frame (56).jpg");
		addSprite(BodyConstants.W,56, "images/AnimatedBackground", "Frame (57).jpg");
		addSprite(BodyConstants.W,57, "images/AnimatedBackground", "Frame (58).jpg");
		addSprite(BodyConstants.W,58, "images/AnimatedBackground", "Frame (59).jpg");
		addSprite(BodyConstants.W,59, "images/AnimatedBackground", "Frame (60).jpg");
		addSprite(BodyConstants.W,60, "images/AnimatedBackground", "Frame (61).jpg");
		addSprite(BodyConstants.W,61, "images/AnimatedBackground", "Frame (62).jpg");
		addSprite(BodyConstants.W,62, "images/AnimatedBackground", "Frame (63).jpg");
		addSprite(BodyConstants.W,63, "images/AnimatedBackground", "Frame (64).jpg");
		addSprite(BodyConstants.W,64, "images/AnimatedBackground", "Frame (65).jpg");
		addSprite(BodyConstants.W,65, "images/AnimatedBackground", "Frame (66).jpg");
		addSprite(BodyConstants.W,66, "images/AnimatedBackground", "Frame (67).jpg");
		addSprite(BodyConstants.W,67, "images/AnimatedBackground", "Frame (68).jpg");
		addSprite(BodyConstants.W,68, "images/AnimatedBackground", "Frame (69).jpg");
		addSprite(BodyConstants.W,69, "images/AnimatedBackground", "Frame (70).jpg");
		addSprite(BodyConstants.W,70, "images/AnimatedBackground", "Frame (71).jpg");
		addSprite(BodyConstants.W,71, "images/AnimatedBackground", "Frame (72).jpg");
		addSprite(BodyConstants.W,72, "images/AnimatedBackground", "Frame (73).jpg");
		addSprite(BodyConstants.W,73, "images/AnimatedBackground", "Frame (74).jpg");
		addSprite(BodyConstants.W,74, "images/AnimatedBackground", "Frame (75).jpg");
		addSprite(BodyConstants.W,75, "images/AnimatedBackground", "Frame (76).jpg");
		addSprite(BodyConstants.W,76, "images/AnimatedBackground", "Frame (77).jpg");
		addSprite(BodyConstants.W,77, "images/AnimatedBackground", "Frame (78).jpg");
		addSprite(BodyConstants.W,78, "images/AnimatedBackground", "Frame (79).jpg");
		addSprite(BodyConstants.W,79, "images/AnimatedBackground", "Frame (80).jpg");
		addSprite(BodyConstants.W,80, "images/AnimatedBackground", "Frame (81).jpg");
		addSprite(BodyConstants.W,81, "images/AnimatedBackground", "Frame (82).jpg");
		addSprite(BodyConstants.W,82, "images/AnimatedBackground", "Frame (83).jpg");
		addSprite(BodyConstants.W,83, "images/AnimatedBackground", "Frame (84).jpg");
		addSprite(BodyConstants.W,84, "images/AnimatedBackground", "Frame (85).jpg");
		addSprite(BodyConstants.W,85, "images/AnimatedBackground", "Frame (86).jpg");
		addSprite(BodyConstants.W,86, "images/AnimatedBackground", "Frame (87).jpg");
		addSprite(BodyConstants.W,87, "images/AnimatedBackground", "Frame (88).jpg");
		addSprite(BodyConstants.W,88, "images/AnimatedBackground", "Frame (89).jpg");
		addSprite(BodyConstants.W,89, "images/AnimatedBackground", "Frame (90).jpg");
		addSprite(BodyConstants.W,90, "images/AnimatedBackground", "Frame (91).jpg");
		addSprite(BodyConstants.W,91, "images/AnimatedBackground", "Frame (92).jpg");
		addSprite(BodyConstants.W,92, "images/AnimatedBackground", "Frame (93).jpg");
		addSprite(BodyConstants.W,93, "images/AnimatedBackground", "Frame (94).jpg");
		addSprite(BodyConstants.W,94, "images/AnimatedBackground", "Frame (95).jpg");
		addSprite(BodyConstants.W,95, "images/AnimatedBackground", "Frame (96).jpg");
		addSprite(BodyConstants.W,96, "images/AnimatedBackground", "Frame (97).jpg");
		addSprite(BodyConstants.W,97, "images/AnimatedBackground", "Frame (98).jpg");
		addSprite(BodyConstants.W,98, "images/AnimatedBackground", "Frame (99).jpg");
		addSprite(BodyConstants.W,99, "images/AnimatedBackground", "Frame (100).jpg");
		addSprite(BodyConstants.W,100, "images/AnimatedBackground", "Frame (101).jpg");
		addSprite(BodyConstants.W,101, "images/AnimatedBackground", "Frame (102).jpg");
		addSprite(BodyConstants.W,102, "images/AnimatedBackground", "Frame (103).jpg");
		addSprite(BodyConstants.W,103, "images/AnimatedBackground", "Frame (104).jpg");
		addSprite(BodyConstants.W,104, "images/AnimatedBackground", "Frame (105).jpg");
		addSprite(BodyConstants.W,105, "images/AnimatedBackground", "Frame (106).jpg");
		addSprite(BodyConstants.W,106, "images/AnimatedBackground", "Frame (107).jpg");
		addSprite(BodyConstants.W,107, "images/AnimatedBackground", "Frame (108).jpg");
		addSprite(BodyConstants.W,108, "images/AnimatedBackground", "Frame (109).jpg");
		addSprite(BodyConstants.W,109, "images/AnimatedBackground", "Frame (110).jpg");
		addSprite(BodyConstants.W,110, "images/AnimatedBackground", "Frame (111).jpg");
		addSprite(BodyConstants.W,111, "images/AnimatedBackground", "Frame (112).jpg");
		addSprite(BodyConstants.W,112, "images/AnimatedBackground", "Frame (113).jpg");
		addSprite(BodyConstants.W,113, "images/AnimatedBackground", "Frame (114).jpg");
		addSprite(BodyConstants.W,114, "images/AnimatedBackground", "Frame (115).jpg");
		addSprite(BodyConstants.W,115, "images/AnimatedBackground", "Frame (116).jpg");
		addSprite(BodyConstants.W,116, "images/AnimatedBackground", "Frame (117).jpg");
		addSprite(BodyConstants.W,117, "images/AnimatedBackground", "Frame (118).jpg");
		addSprite(BodyConstants.W,118, "images/AnimatedBackground", "Frame (119).jpg");
		addSprite(BodyConstants.W,119, "images/AnimatedBackground", "Frame (120).jpg");
		addSprite(BodyConstants.W,120, "images/AnimatedBackground", "Frame (121).jpg");
		addSprite(BodyConstants.W,121, "images/AnimatedBackground", "Frame (122).jpg");
		addSprite(BodyConstants.W,122, "images/AnimatedBackground", "Frame (123).jpg");
		addSprite(BodyConstants.W,123, "images/AnimatedBackground", "Frame (124).jpg");
		addSprite(BodyConstants.W,124, "images/AnimatedBackground", "Frame (125).jpg");
		addSprite(BodyConstants.W,125, "images/AnimatedBackground", "Frame (126).jpg");
		addSprite(BodyConstants.W,126, "images/AnimatedBackground", "Frame (127).jpg");
		addSprite(BodyConstants.W,127, "images/AnimatedBackground", "Frame (128).jpg");
		addSprite(BodyConstants.W,128, "images/AnimatedBackground", "Frame (129).jpg");
		addSprite(BodyConstants.W,129, "images/AnimatedBackground", "Frame (130).jpg");
		addSprite(BodyConstants.W,130, "images/AnimatedBackground", "Frame (131).jpg");
		addSprite(BodyConstants.W,131, "images/AnimatedBackground", "Frame (132).jpg");
		addSprite(BodyConstants.W,132, "images/AnimatedBackground", "Frame (133).jpg");
		addSprite(BodyConstants.W,133, "images/AnimatedBackground", "Frame (134).jpg");
		addSprite(BodyConstants.W,134, "images/AnimatedBackground", "Frame (135).jpg");
		addSprite(BodyConstants.W,135, "images/AnimatedBackground", "Frame (136).jpg");
		addSprite(BodyConstants.W,136, "images/AnimatedBackground", "Frame (137).jpg");
		addSprite(BodyConstants.W,137, "images/AnimatedBackground", "Frame (138).jpg");
		addSprite(BodyConstants.W,138, "images/AnimatedBackground", "Frame (139).jpg");
		addSprite(BodyConstants.W,139, "images/AnimatedBackground", "Frame (140).jpg");
		addSprite(BodyConstants.W,140, "images/AnimatedBackground", "Frame (141).jpg");
		addSprite(BodyConstants.W,141, "images/AnimatedBackground", "Frame (142).jpg");
		addSprite(BodyConstants.W,142, "images/AnimatedBackground", "Frame (143).jpg");
		addSprite(BodyConstants.W,143, "images/AnimatedBackground", "Frame (144).jpg");
		addSprite(BodyConstants.W,144, "images/AnimatedBackground", "Frame (145).jpg");
		addSprite(BodyConstants.W,145, "images/AnimatedBackground", "Frame (146).jpg");
		addSprite(BodyConstants.W,146, "images/AnimatedBackground", "Frame (147).jpg");
		addSprite(BodyConstants.W,147, "images/AnimatedBackground", "Frame (148).jpg");
		addSprite(BodyConstants.W,148, "images/AnimatedBackground", "Frame (149).jpg");
		addSprite(BodyConstants.W,149, "images/AnimatedBackground", "Frame (150).jpg");
		addSprite(BodyConstants.W,150, "images/AnimatedBackground", "Frame (151).jpg");
		addSprite(BodyConstants.W,151, "images/AnimatedBackground", "Frame (152).jpg");
		addSprite(BodyConstants.W,152, "images/AnimatedBackground", "Frame (153).jpg");
		addSprite(BodyConstants.W,153, "images/AnimatedBackground", "Frame (154).jpg");
		addSprite(BodyConstants.W,154, "images/AnimatedBackground", "Frame (155).jpg");
		addSprite(BodyConstants.W,155, "images/AnimatedBackground", "Frame (156).jpg");
		addSprite(BodyConstants.W,156, "images/AnimatedBackground", "Frame (157).jpg");
		addSprite(BodyConstants.W,157, "images/AnimatedBackground", "Frame (158).jpg");
		addSprite(BodyConstants.W,158, "images/AnimatedBackground", "Frame (159).jpg");
		addSprite(BodyConstants.W,159, "images/AnimatedBackground", "Frame (160).jpg");
		addSprite(BodyConstants.W,160, "images/AnimatedBackground", "Frame (161).jpg");
		addSprite(BodyConstants.W,161, "images/AnimatedBackground", "Frame (162).jpg");
		addSprite(BodyConstants.W,162, "images/AnimatedBackground", "Frame (163).jpg");
		addSprite(BodyConstants.W,163, "images/AnimatedBackground", "Frame (164).jpg");
		addSprite(BodyConstants.W,164, "images/AnimatedBackground", "Frame (165).jpg");
		addSprite(BodyConstants.W,165, "images/AnimatedBackground", "Frame (166).jpg");
		addSprite(BodyConstants.W,166, "images/AnimatedBackground", "Frame (167).jpg");
		addSprite(BodyConstants.W,167, "images/AnimatedBackground", "Frame (168).jpg");
		addSprite(BodyConstants.W,168, "images/AnimatedBackground", "Frame (169).jpg");
		addSprite(BodyConstants.W,169, "images/AnimatedBackground", "Frame (170).jpg");
		addSprite(BodyConstants.W,170, "images/AnimatedBackground", "Frame (171).jpg");
		addSprite(BodyConstants.W,171, "images/AnimatedBackground", "Frame (172).jpg");
		addSprite(BodyConstants.W,172, "images/AnimatedBackground", "Frame (173).jpg");
		addSprite(BodyConstants.W,173, "images/AnimatedBackground", "Frame (174).jpg");
		addSprite(BodyConstants.W,174, "images/AnimatedBackground", "Frame (175).jpg");
		addSprite(BodyConstants.W,175, "images/AnimatedBackground", "Frame (176).jpg");
		addSprite(BodyConstants.W,176, "images/AnimatedBackground", "Frame (177).jpg");
		addSprite(BodyConstants.W,177, "images/AnimatedBackground", "Frame (178).jpg");
		addSprite(BodyConstants.W,178, "images/AnimatedBackground", "Frame (179).jpg");
		addSprite(BodyConstants.W,179, "images/AnimatedBackground", "Frame (180).jpg");
		addSprite(BodyConstants.W,180, "images/AnimatedBackground", "Frame (181).jpg");
		addSprite(BodyConstants.W,181, "images/AnimatedBackground", "Frame (182).jpg");
		addSprite(BodyConstants.W,182, "images/AnimatedBackground", "Frame (183).jpg");
		addSprite(BodyConstants.W,183, "images/AnimatedBackground", "Frame (184).jpg");
		addSprite(BodyConstants.W,184, "images/AnimatedBackground", "Frame (185).jpg");
		addSprite(BodyConstants.W,185, "images/AnimatedBackground", "Frame (186).jpg");
		addSprite(BodyConstants.W,186, "images/AnimatedBackground", "Frame (187).jpg");
		addSprite(BodyConstants.W,187, "images/AnimatedBackground", "Frame (188).jpg");
		addSprite(BodyConstants.W,188, "images/AnimatedBackground", "Frame (189).jpg");
		addSprite(BodyConstants.W,189, "images/AnimatedBackground", "Frame (190).jpg");
		addSprite(BodyConstants.W,190, "images/AnimatedBackground", "Frame (191).jpg");
		addSprite(BodyConstants.W,191, "images/AnimatedBackground", "Frame (192).jpg");
		addSprite(BodyConstants.W,192, "images/AnimatedBackground", "Frame (193).jpg");
		addSprite(BodyConstants.W,193, "images/AnimatedBackground", "Frame (194).jpg");
		addSprite(BodyConstants.W,194, "images/AnimatedBackground", "Frame (195).jpg");
		addSprite(BodyConstants.W,195, "images/AnimatedBackground", "Frame (196).jpg");
		addSprite(BodyConstants.W,196, "images/AnimatedBackground", "Frame (197).jpg");
		addSprite(BodyConstants.W,197, "images/AnimatedBackground", "Frame (198).jpg");
		addSprite(BodyConstants.W,198, "images/AnimatedBackground", "Frame (199).jpg");
		addSprite(BodyConstants.W,199, "images/AnimatedBackground", "Frame (200).jpg");
		// }
		

	}

	@Override
	public void createLayers() {
		LayerConstants.backgroundImageLayerId = addLayer(new BackgroundImageLayer(this));
		
		LayerConstants.backgroundLayerId = addLayer(new BackgroundLayer(this));

		LayerConstants.charactersLayerId = addLayer(new CharactersLayer(this));

		LayerConstants.statusLayerId = addLayer(new StatusLayer(this));
	}

	@Override
	public int getXSize() {
		// TODO Auto-generated method stub
		return 26;
	}

	@Override
	public int getYSize() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getTileSize() {
		// TODO Auto-generated method stub
		return 32;
	}

	@Override
	protected int getAdvanceDelay() {
		// TODO Auto-generated method stub
		return 31;
	}

	@Override
	public void advance2() {
		if (getCurrentLevel() == 1) {
			if (key == 2) {

			}
		}

		if (hp <= 0) {
			gameOver();

		}
		if (getCurrentLevel() == 0) {
			hp = 5;
			fgp.game.bodies.Steve.Protected=false;
			changeLevel(1);
		}

		super.advance2();
	}
}
