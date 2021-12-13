package fabrik;

import business.Freizeitbad;
import java.io.*;

public class ConcreteProduct extends Product{

	private BufferedWriter bw;
	public ConcreteProduct() throws IOException{
		this.bw = new BufferedWriter(new FileWriter("Freizeitbad.csv",true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		this.bw.write(((Freizeitbad)object).gibFreizeitbadZurueck(';'));	
	}
	
	@Override
	public void schliesseDatei() throws IOException {
		this.bw.close();
	}

}