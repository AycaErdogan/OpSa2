package guiSportstaetten;

import java.io.IOException;
import business.FreizeitbaederModel;
import javafx.stage.Stage;
import Pattern.Observer;

public class SportstaettenControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenView sportstaettenView;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(primaryStage, this, this.freizeitbaederModel);
		this.freizeitbaederModel.addObserver(this);
	}

	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				// Aufruf des Models zum Schreiben des
				// Freizeitbads in die Datei des vorgegebenen
				// Typs und Ausgabe der Meldung
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Test");
			} else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				sportstaettenView
						.zeigeInformationsfensterAn("Das Freizeitbad wurde erfolgreich in die txt-Datei eingetragen.");

			} else {
				sportstaettenView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!", exc.toString());
		} catch (Exception exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!", exc.toString());
		}
	}

	@Override
	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}