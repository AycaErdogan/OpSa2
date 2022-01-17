package business.businessSporthallen;
//import gui.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import ownUtil.PlausiException;
import pattern.Observer;
public class SporthallenModel {

		// private Freizeitbad freizeitbad;
		private ArrayList<Sporthalle> sporthalle = new ArrayList<>();
		private static SporthallenModel sporthallenModel =null;
		Vector<Observer> Observers = new Vector<Observer>();

		private SporthallenModel() {

		}
		public static SporthallenModel getInstance() {
			if (sporthallenModel == null)
					sporthallenModel = new SporthallenModel();

			return sporthallenModel;
		}

		public void leseSporthallenAusCsvDatei() throws IOException, PlausiException{
			BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
				ArrayList<Sporthalle> ergebnis =new ArrayList<>(); 
				String zeileStr = ein.readLine();
				while(zeileStr != null) {
					String[] zeile = zeileStr.split(";");
			           //ergebnis.add(new SporthallenModel(zeile[0], zeile[1], zeile[2]));
					ergebnis.add(new Sporthalle(zeile[0].substring(1),zeile[1],zeile[2].substring(0,zeile[2].length()-1)));
			           zeileStr = ein.readLine();
				}    
			 	ein.close();
			 	this.sporthalle = ergebnis;
			}
		public ArrayList<Sporthalle> getSporthalle() {
			return sporthalle;
		}

		public void setSporthalle(ArrayList<Sporthalle>sporthalle) {
			this.sporthalle=sporthalle;
		}
}
