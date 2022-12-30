package basic.lambda.FI;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorLambdaSoarting {

	public static void main(String[] args) {
		ArrayList<Integer> I = new ArrayList<Integer>();
		I.add(10);
		I.add(2);
		I.add(0);
		I.add(5);
		I.add(10);
		I.add(15);

		Collections.sort(I, (I1, I2) -> (I1 > I2) ? -1 : (I1 < I2) ? 1 : 0);
		System.out.println("Sorted desc list" + I);

		Collections.sort(I, (I1, I2) -> (I1 > I2) ? 1 : (I1 < I2) ? -1 : 0);
		System.out.println("Sorted asc list" + I);
	}

}
