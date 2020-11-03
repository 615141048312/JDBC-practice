package unitTest;

public class Calculator {
	public int square(int x) {
		return x * x;
	}

	public double root(double x) {
		if(x < 0) {
			throw new IllegalArgumentException("負の値の平方根は求められません");
		}
		return Math.sqrt(x);
	}
}
