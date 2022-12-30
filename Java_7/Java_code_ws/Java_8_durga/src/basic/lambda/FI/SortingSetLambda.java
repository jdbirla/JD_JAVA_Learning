package basic.lambda.FI;

import java.util.TreeSet;

public class SortingSetLambda {

	public static void main(String[] args) {
		TreeSet<Integer> tsDefualtSort =  new TreeSet<Integer>();
		TreeSet<Integer> tsDescSort	 =  new TreeSet<Integer>((I1,I2)->(I1>I2)?-1:(I1<I2)?1:0);
		
		tsDefualtSort.add(5);
		tsDefualtSort.add(10);
		tsDefualtSort.add(2);
		tsDefualtSort.add(0);
		tsDefualtSort.add(3);
		tsDefualtSort.add(8);
		
		tsDescSort.add(5);
		tsDescSort.add(10);
		tsDescSort.add(2);
		tsDescSort.add(0);
		tsDescSort.add(3);
		tsDescSort.add(8);

		System.out.println("Default Tree set"+tsDefualtSort);
		System.out.println("Comparator desc Tree set"+tsDescSort);
	}

}
