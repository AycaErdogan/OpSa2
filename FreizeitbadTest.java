package test.business;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.businessFreizeitbaeder.Freizeitbad;

class FreizeitbadTest {

	Freizeitbad fb;

	@BeforeEach
	void setUp() throws Exception {
		this.fb = new Freizeitbad("Stadtbad", "7.0", "17.0", "25", "24");
	}

	@AfterEach
	void tearDown() throws Exception {
		this.fb = null;
	}

	@Test
	void pruefe() {
		BooleanSupplier bool;
		bool = () -> fb.getBeckenlaenge() == 25;
		assertTrue(bool.getAsBoolean());
	}
	
}
