package gui.guiSportstaetten;

import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.PlausiException;

public class SportstaettenView {

	// Hier ergaenzen
	private SportstaettenControl sportstaettenControl;
	private SporthallenModel sporthallenModel;
	private FreizeitbaederModel freizeitbaederModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	//Freizeitbaeder
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
	//Sporthallen
	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeSporthallen = new TextArea();
	private Button btnAnzeigeSporthallen = new Button("Csv-Import und Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(Stage primaryStage, SportstaettenControl sportstaettenControl,
			FreizeitbaederModel freizeitbaederModel, SporthallenModel sporthallenModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportstätten");
		primaryStage.show();
		// Hier ergaenzen
		this.sporthallenModel = sporthallenModel;
		this.freizeitbaederModel=freizeitbaederModel;
		this.setSportstaettenControl(sportstaettenControl);
		this.sportstaettenControl=sportstaettenControl;
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);
	
		lblAnzeigeSporthallen.setLayoutX(30);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSporthallen);
		// Textbereich
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);
		
		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(30);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);
		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);
		
		btnAnzeigeSporthallen.setLayoutX(30);
		btnAnzeigeSporthallen.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSporthallen);
	}

	private void initListener() {
		/*
		 * btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { zeigeFreizeitbaederAn(); } });
		 */
		/*btnAnzeigeFreizeitbaeder.setOnAction(e -> zeigeFreizeitbaederAn());
		btnAnzeigeFreizeitbaeder.setOnAction(e -> zeigeFreizeitbaederAn());
		btnAnzeigeFreizeitbaeder.setOnAction(e -> zeigeInformationsfensterAn("Noch nicht implementiert"));
	*/
		btnAnzeigeSporthallen.setOnAction(e ->{ zeigeInformationsfensterAn("csv-import beginnt");
		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (PlausiException e1) {
			e1.printStackTrace();
		}
		zeigeSporthallenAn();
	});
}

	void zeigeSporthallenAn() {
		if (this.sporthallenModel.getSporthalle().size() > 0) {
			StringBuffer text = new StringBuffer(); 
			// Ergaenzen: for each – Schleife ueber ArrayList

			for (Sporthalle sph : this.sporthallenModel.getSporthalle()) {
				text.append(sph.gibSporthalleZurueck(' ') + "\n");
			}
			this.txtAnzeigeSporthallen.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}
	public SportstaettenControl getSportstaettenControl() {
		return sportstaettenControl;
	}
	public void setSportstaettenControl(SportstaettenControl sportstaettenControl) {
		this.sportstaettenControl=sportstaettenControl;
	}
	
}