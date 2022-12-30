package predefine.FI.Function;

import java.util.function.Function;

public class FunctionChaining {

	public static void main(String[] args) {

		Function<String, String> f1 = S -> S.toUpperCase();
		Function<String, String> f2 = S -> S.substring(0, 9);
		Function<String, String> f3 = f1.andThen(f2);
		Function<String, String> f4 = f1.compose(f2);

		System.out.println(f1.apply("BirlaJitendra"));
		System.out.println(f2.apply("BirlaJitendra"));
		System.out.println(f3.apply("BirlaJitendra"));
		System.out.println(f4.apply("BirlaJitendra"));

		Function<Integer, Integer> f5 = I -> I + I;
		Function<Integer, Integer> f6 = I -> I * I * I;

		System.out.println(f5.andThen(f6).apply(2));
		System.out.println(f5.compose(f6).apply(2));

		Function<String, String> f7 = Function.identity();
		System.out.println(f7.apply("Durga"));

	}

}
