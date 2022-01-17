package business.businessFreizeitbaeder;

//import gui.*;
import java.io.*;
import java.util.*;

import pattern.Observer;
import fabrik.*;

public class FreizeitbaederModel {
	// private Freizeitbad freizeitbad;
	private ArrayList<Freizeitbad> freizeitbad = new ArrayList<>();
	Vector<Observer> Observers = new Vector<Observer>();
	private static FreizeitbaederModel freizeitbaederModel =null;

	private FreizeitbaederModel() {

	}
	public static FreizeitbaederModel getInstance() {
		if (freizeitbaederModel ==null)
			freizeitbaederModel = new FreizeitbaederModel();

		return freizeitbaederModel;
	}

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator txt = new ConcreteTxtCreator();
		ConcreteTxtProduct writer = (ConcreteTxtProduct) txt.factoryMethod("txt");
		for (Freizeitbad fb : freizeitbad) {
			writer.fuegeInDateiHinzu(fb);
		}
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator csv = new ConcreteCsvCreator();
		ConcreteCsvProduct writer = (ConcreteCsvProduct) csv.factoryMethod("csv");
		for (Freizeitbad fzb : freizeitbad) {
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return this.freizeitbad;
	}
	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
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
