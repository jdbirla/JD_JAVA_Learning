package predefine.FI.Function;

import java.util.function.BiFunction;

public class BiFunctionEx1 {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> bf = (a, b) -> a * b;
		System.out.println(bf.apply(10, 20));
	}

}
