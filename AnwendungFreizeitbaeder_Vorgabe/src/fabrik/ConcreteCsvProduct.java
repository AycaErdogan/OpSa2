package fabrik;

import java.io.*;
import business.*;

public class ConcreteCsvProduct extends Product {

    private BufferedWriter bufferedWriter;
    public ConcreteCsvProduct() throws IOException{
            bufferedWriter = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
    }
    public void fuegeInDateiHinzu(Object object) throws IOException{
            bufferedWriter.write(((Freizeitbad)object).gibFreizeitbadZurueck(';'));
            bufferedWriter.write("\n");
            
    }
    public void schliesseDatei() throws IOException{
            bufferedWriter.close();
    }
}