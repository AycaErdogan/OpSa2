package main;

import gui.guiFreizeitbaeder.*;
import gui.guiSportstaetten.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{

	/*
	@Override
	public void start(Stage primaryStage) {
		new FreizeitbaederControl(primaryStage);
	}	
	*/
	
	public void start(Stage primaryStage) {
		
		//Fenster zu Freizeitbaedern
		new FreizeitbaederControl(primaryStage);
		
		//Fenster zu Sportstaetten
		Stage fensterSportstaetten = new Stage();
		new SportstaettenControl(fensterSportstaetten);
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
