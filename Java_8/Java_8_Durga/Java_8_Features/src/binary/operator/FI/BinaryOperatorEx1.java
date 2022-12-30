package binary.operator.FI;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorEx1 {

	public static void main(String[] args) {
		BinaryOperator<String> bo = (s1, s2) -> s1 + s2;

		System.out.println(bo.apply("Jitendra", " Birla"));

		IntBinaryOperator boi = (i1, i2) -> i1 + i2;
		System.out.println(boi.applyAsInt(12, 15));
	}

}
