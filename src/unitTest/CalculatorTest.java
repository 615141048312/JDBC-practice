package unitTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	private Calculator calc;

	@BeforeEach
	void setUp() {
		calc = new Calculator();
	}

	@Test
	@DisplayName("2の二乗は4になる")
	void testSquare2() {
		int result = calc.square(2);
		assertThat(result, is(4));
	}

	@Test
	@DisplayName("4の平方根は2になる")
	void testRoot4() {
		double result = calc.root(4.0);
		assertThat(result, is(2.0));
	}

	@Test
	@DisplayName("-1の平方根は例外が発生する")
	void testRootException() {
		assertThrows(IllegalArgumentException.class, () -> calc.root(-1));
	}

}
