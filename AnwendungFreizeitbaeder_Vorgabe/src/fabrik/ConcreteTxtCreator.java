package fabrik;

import java.io.*;

public class ConcreteTxtCreator extends Creator{
	
    public Product factoryMethod(String typ) throws IOException {
        return new ConcreteTxtProduct();
    }
}