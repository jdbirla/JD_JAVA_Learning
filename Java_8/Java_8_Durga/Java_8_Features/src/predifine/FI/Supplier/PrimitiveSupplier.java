package predifine.FI.Supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class PrimitiveSupplier {

	public static void main(String[] args) {

		IntSupplier is = () -> 5 * 5;
		System.out.println(is.getAsInt());
		LongSupplier is1 = () -> 5 * 5;
		System.out.println(is1.getAsLong());
		DoubleSupplier is2 = () -> 5.0 * 5.0;
		System.out.println(is2.getAsDouble());
		BooleanSupplier is3 = () -> true;
		System.out.println(is3.getAsBoolean());

	}

}
