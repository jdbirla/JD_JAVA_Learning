package basic.lambda.FI;

import java.util.TreeMap;

public class TreeMapSoartingComparatorLambda {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> tmDefaultSort = new TreeMap<Integer, String>();
		
		TreeMap<Integer, String> tmDescSort = new TreeMap<Integer, String>((I1,I2)->(I1>I2)?-1:(I1<I2)?-1:0);

		tmDefaultSort.put(100, "Jitendra");
		tmDefaultSort.put(600, "Jitendra 1");
		tmDefaultSort.put(200, "Jitendra 2");
		tmDefaultSort.put(300, "Jitendra 3");
		tmDefaultSort.put(500, "Jitendra 4");
		tmDefaultSort.put(700, "Jitendra 5");
		
		
		tmDescSort.put(100, "Jitendra");
		tmDescSort.put(600, "Jitendra 1");
		tmDescSort.put(200, "Jitendra 2");
		tmDescSort.put(300, "Jitendra 3");
		tmDescSort.put(500, "Jitendra 4");
		tmDescSort.put(700, "Jitendra 5");

		System.out.println("Default sort map"+tmDefaultSort);
		System.out.println("lambda comparator desc sort map"+tmDescSort);

	}
}
