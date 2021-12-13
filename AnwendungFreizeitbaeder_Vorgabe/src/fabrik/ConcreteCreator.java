package fabrik;

import java.io.IOException;

public class ConcreteCreator extends Creator {
	public Product factoryMethod(String typ) throws IOException{
		if(typ.equals("csv"))
			return new ConcreteProduct();
		else 
			return new ConcreteTxtProduct();
	}
}