package business;

import Pattern.ConcreteObservable;
import java.io.IOException;
import fabrik.ConcreteCreator;
import fabrik.ConcreteProduct;
import fabrik.ConcreteTxtProduct;
import fabrik.Creator;

public class FreizeitbaederModel extends ConcreteObservable {

		private Freizeitbad freizeitbad;

		/*
		 * public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView)
		 * throws IOException { BufferedWriter aus = new BufferedWriter(new
		 * FileWriter("Freizeitbaeder.csv", true));
		 * aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
		 */
		

		//Singleton
		private static FreizeitbaederModel freizeitbaederModel= null;
		private FreizeitbaederModel() {
			
		}
		public static FreizeitbaederModel getInstance() {
			if(freizeitbaederModel == null)
				freizeitbaederModel= new FreizeitbaederModel();
			
			return freizeitbaederModel;
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
			return this.freizeitbad;
		}

		public void setFreizeitbad(Freizeitbad freizeitbad) {
			this.freizeitbad = freizeitbad;
			this.notifyObservers();
		}

}
