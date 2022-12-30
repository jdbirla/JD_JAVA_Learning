package unary.operator.FI;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExq {

	public static void main(String[] args) {
		UnaryOperator<Integer> f = i -> i * i * i;
		System.out.println(f.apply(5));

		IntUnaryOperator f1 = i -> i * i;
		System.out.println(f1.applyAsInt(5));

	}

}
