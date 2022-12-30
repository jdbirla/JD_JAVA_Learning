package streams.world;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamEx1 {
	public static void main(String[] args) {

		List<Integer> numberList = new ArrayList<Integer>();

		for (int i = 1; i <= 5; i++) {
			numberList.add(i);
		}

		Stream s = numberList.stream();
		s.forEach(System.out::println);

		/*
		 * // Here creating a parallel stream Stream<Integer> parallelStream =
		 * numberList.stream(); Integer[] evenNumbersArray = parallelStream.filter(i ->
		 * i % 2 == 0).toArray(Integer[]::new); for (Integer evenNumber :
		 * evenNumbersArray) { System.out.println(evenNumber); }
		 */

		
	}
}
