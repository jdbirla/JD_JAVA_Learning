package streams.world;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {

	public static void main(String[] args) {

		 List<Person> personList = Arrays.asList(new Person(1, "Ram", 25),
	                new Person(2, "Peter", 31),
	                new Person(3, "Peter", 25),
	                new Person(4, "Balu", 32));
	        

		  Stream<Person> name1 = personList.stream() //convert list to stream                 
	                .filter(x -> "Peter".equals(x.getName())); // we want "Peter" only
	         	  
	        System.out.println(name1.collect(Collectors.toList()));

		 
	        String name = personList.stream() //convert list to stream                 
	                .filter(x -> "Peter".equals(x.getName())) // we want "Peter" only
	                .map(Person::getName) //convert Stream<Person> to Stream<String>
	                .findAny()  // If 'findAny' then return found                                   
	                .orElse(null);  // If not found, return null
	        
	        System.out.println(name);
	}

}
