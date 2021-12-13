package guiFreizeitbaeder;

import java.io.IOException;
import business.FreizeitbaederModel;
import javafx.stage.Stage;
import Pattern.Observer;

public class FreizeitbaederControl implements Observer {
	
	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;
	
	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.freizeitbaederView = new FreizeitbaederView(primaryStage, this, this.freizeitbaederModel);
		this.freizeitbaederModel.addObserver(this);
	}

	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				// Aufruf des Models zum Schreiben des
				// Freizeitbads in die Datei des vorgegebenen
				// Typs und Ausgabe der Meldung
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde erfolgreich in die csv-Datei eingetragen.");
			}else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde erfolgreich in die txt-Datei eingetragen.");
			
			} else {
				freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!", exc.toString());
		} catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!", exc.toString());
		}
	}

	@Override
	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
	}
}