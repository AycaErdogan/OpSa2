package business;

import Pattern.ConcreteObservable;
import Pattern.Observer;
import java.io.IOException;
import java.util.Vector;
import fabrik.ConcreteCreator;
import fabrik.ConcreteProduct;
import fabrik.ConcreteTxtProduct;
import fabrik.Creator;

public class FreizeitbaederModel extends ConcreteObservable {
	
	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel getInstance = null;
	Vector<Observer> observers = new Vector<Observer>();
	private FreizeitbaederModel() {
		
	}
	
	public static FreizeitbaederModel getInstance(){
		if (getInstance == null)
			getInstance = new FreizeitbaederModel();
		return getInstance;
	}

	public void schreibeFreizeitbaederInTxtDatei() 
	throws IOException {
		Creator txt = new ConcreteCreator();
		ConcreteTxtProduct writer = (ConcreteTxtProduct)txt.factoryMethod("txt");
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInCsvDatei() 
	throws IOException {
		Creator csv = new ConcreteCreator();
		ConcreteProduct writer = (ConcreteProduct)csv.factoryMethod("csv");
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		this.notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.removeElement(obs);
	}

	@Override
	public void notifyObservers() {
		for(Observer obs : observers) {
			obs.update();
		}
	}
}