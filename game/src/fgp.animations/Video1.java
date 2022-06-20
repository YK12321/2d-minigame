package fgp.animations;

import java.io.File;

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
public class Video1 extends Application {
	

@Override
public void start(Stage stage) throws Exception {

    File f=new File("animations/Animation_1_with_sound.mp4");
    System.out.print(f);
    Media m=new Media(f.toURI().toString());
    MediaPlayer mp=new MediaPlayer(m);
    MediaView mv=new MediaView(mp);

    StackPane root=new StackPane();
    root.getChildren().add(mv);
    stage.setScene(new Scene(root,600,600));
    stage.setTitle("The Beginnings");
    stage.show();
    mp.play();
		    for (int i = 0; i < 100; i++) {
				System.out.println(stage.getX()+", "+stage.getY());
			}
}


public static void main(String[] args) {
    launch(args);
}
}
