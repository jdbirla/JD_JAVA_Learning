package streams.world;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapEx {

	public static void main(String[] args) {
		List listOfIntegers = Stream.of("1", "2", "3", "4").map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(listOfIntegers);
		List evens = Arrays.asList(2, 4, 6);
		List odds = Arrays.asList(3, 5, 7);
		List primes = Arrays.asList(2, 3, 5, 7, 11);
		List numbers = (List) Stream.of(evens, odds, primes).flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println("flattend list: " + numbers);

	}
}
