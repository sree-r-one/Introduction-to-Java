import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {

		Fraction fraction1 = new Fraction(1,2);
		Fraction fraction2 = new Fraction(1,2);

		assertEquals(fraction1, fraction2);

		Fraction fraction3 = new Fraction(1,2);
		Fraction fraction4 = new Fraction(2,3);

		assertNotEquals(fraction3, fraction4);
	}

}
