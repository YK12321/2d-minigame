package fgp.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import fgp.animations.Animation_1;
import fgp.engine.GameEngine;
import java.io.File;
import fgp.animations.*;

import javax.swing.JButton;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;


/**
 * @author Mr. Hapke
 */
public class FrmLauncher extends JFrame {

	private static final long serialVersionUID = 3811418719500055475L;
	private JPanel contentPane;
	private GameEngine game;
	private JTextArea txtReadme;
	private JFrame FrmLauncher;

	/**
	 * Launch the application.
	 */
	public static void launch(GameEngine game) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FrmLauncher frame = new FrmLauncher(game);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	
	}
	

	public FrmLauncher(GameEngine game) {
		if (game == null) {
			System.err.println("You must create your game by passing it to FrmLauncher.launch(new YourGame())");
		}
		this.game = game;
		setTitle(game.getGameTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnStart = new JButton("Start Game!");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start();
				game.newGame();
				FrmGame frame = new FrmGame(game);
				frame.setVisible(true);
				FrmLauncher.this.setVisible(false);
			}
		});
		btnStart.setFont(new Font("Candara", Font.BOLD, 20));
		btnStart.setBounds(10, 274, 239, 47);
		contentPane.add(btnStart);

		txtReadme = new JTextArea();
		txtReadme.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtReadme.setWrapStyleWord(true);
		txtReadme.setLineWrap(true);
		txtReadme.setText(
				"In the world of the mighty brush, everything was good and peaceful until the brush left, and the evil pen came...");
		txtReadme.setBounds(10, 11, 239, 256);
		contentPane.add(txtReadme);
	}
	protected void start(){
		Video intro = new Video();
		intro.main(null);
	}
}

