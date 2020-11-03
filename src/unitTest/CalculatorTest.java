package unitTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	@DisplayName("2の二乗は4になる")
	void testSquare2() {
		Calculator calc = new Calculator();
		int result = calc.square(2);
		assertThat(result, is(4));
	}

	@Test
	@DisplayName("4の平方根は2になる")
	void testRoot4() {
		Calculator calc = new Calculator();
		double result = calc.root(4.0);
		assertThat(result, is(2.0));
	}

	@Test
	@DisplayName("-1の平方根は例外が発生する")
	void testRootException() {
		Calculator calc = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> calc.root(-1));
	}

}
