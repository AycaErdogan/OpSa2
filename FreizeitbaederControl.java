package gui.guiFreizeitbaeder;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import pattern.*;
import javafx.stage.*;
import java.io.*;


public class FreizeitbaederControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private FreizeitbaederView freizeitbaederView;

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.freizeitbaederView = new FreizeitbaederView(primaryStage, this, this.freizeitbaederModel);
		this.freizeitbaederModel.addObserver(this);
	}
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".contentEquals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");

			} else if ("txt".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");
			}
			else {
				freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert.");
			}
			
		} catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("IOException beim Speicher",typ);
		} catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern",typ);
		}
	}
	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
	}
}
