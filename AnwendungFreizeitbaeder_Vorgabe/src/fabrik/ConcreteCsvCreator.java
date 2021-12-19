package fabrik;

import java.io.*;

public class ConcreteCsvCreator extends Creator{
	
    public Product factoryMethod(String typ) throws IOException {
    	return new ConcreteCsvProduct();
}
	

}