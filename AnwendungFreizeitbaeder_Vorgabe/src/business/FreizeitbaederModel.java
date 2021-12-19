package business;

//import gui.*;
import java.io.*;
import java.util.*;
import pattern.*;
import pattern.Observer;
import fabrik.*;

public class FreizeitbaederModel {

	private Freizeitbad freizeitbad;

	/*
	 * public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView)
	 * throws IOException { BufferedWriter aus = new BufferedWriter(new
	 * FileWriter("Freizeitbaeder.csv", true));
	 * aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
	 */
	

	//Singleton
	Vector<Observer>Observers =new Vector<Observer>();
	
	private static FreizeitbaederModel freizeitbaederModel= null;
	private FreizeitbaederModel() {
		
	}
	public static FreizeitbaederModel getInstance() {
		if(freizeitbaederModel == null)
			freizeitbaederModel= new FreizeitbaederModel();
		
		return freizeitbaederModel;
	}
	

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		Creator txt = new ConcreteTxtCreator();
		Product writer = txt.factoryMethod(null);
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();

	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator c = new ConcreteCsvCreator();
		Product writer = c.factoryMethod(null);
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();

	}

	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		this.notifyObservers();
	}
    public void addObserver(Observer obs) {
		Observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        Observers.removeElement(obs);
    }

    public void notifyObservers() {
        for (Observer obs : Observers) {
            obs.update();
        }
    }
}
