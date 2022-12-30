package streams.world;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = Arrays.asList(new Person(1, "Ram", 25), new Person(2, "Peter", 31),
				new Person(3, "Peter", 25), new Person(4, "Balu", 32));

		Stream<Person> ps = personList.stream().filter(x -> "Peter".equals(x.getName()));

		Person person = personList.stream() // convert list to stream
				.filter(x -> "Peter".equals(x.getName())) // we want "Peter" only
				.findAny() // If 'findAny' then return found
				.orElse(null); // If not found, return null

		System.out.println(person);
	}

}
