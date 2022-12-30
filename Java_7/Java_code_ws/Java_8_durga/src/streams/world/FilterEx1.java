package streams.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterEx1 {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(0);
		al.add(5);
		al.add(10);
		al.add(20);
		al.add(15);
		al.add(25);

		Predicate<Integer> p1 = I -> I % 3 == 0;

		List<Integer> l1 = al.stream().filter(p1).collect(Collectors.toList());

		System.out.println(l1);
		System.out.println("****************************************************");

		Function<Integer, Integer> f1 = I -> I * I;
		List<Integer> l2 = al.stream().map(f1).collect(Collectors.toList());
		System.out.println(l2);
		System.out.println("****************************************************");

		long count = al.stream().count();
		long count1 = al.stream().filter(I -> I % 3 == 0).count();

		System.out.println(count1);

		System.out.println("****************************************************");

		System.out.println("******************Sorting:start****************************");
		// sorted() default natural order
		// sorted(Comparator c) Customized soarting order

		List<Integer> sortList = al.stream().sorted().collect(Collectors.toList());

		System.out.println(sortList);
		List<Integer> customiSortList = al.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(customiSortList);

		System.out.println("******************Sorting:end****************************");

		System.out.println("******************Min and max:start****************************");

		Integer min = al.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("Min value :" + min);

		Integer max = al.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("Max value :" + max);
		System.out.println("******************Min and max:end****************************");

		System.out.println("******************Foreach method:start****************************");
		al.stream().forEach(I -> System.out.println("each element : " + I));
		al.stream().forEach(System.out::println);

		System.out.println("******************Foreach method:end****************************");

		System.out.println("******************toArray method:start****************************");

		Integer[] arr = al.stream().toArray(Integer[]::new);
		for (Integer a : arr) {
			System.out.println("aray elements : " + a);
		}
		System.out.println("******************toArray methiod:end****************************");

		System.out.println("******************Stream.of():start****************************");
		Integer[] d = { 1, 2, 3, 4, 5, 6, 8, 9 };
		Stream<Integer> ss = Stream.of(d);
		ss.forEach(System.out::println);
		System.out.println("******************Stream.of():end****************************");

	}

}
