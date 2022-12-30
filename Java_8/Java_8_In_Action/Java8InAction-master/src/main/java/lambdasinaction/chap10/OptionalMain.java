package lambdasinaction.chap10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

	public static void main(String[] args) {
		Person p = new Person();
		Optional<Person> p1 = Optional.of(p);
		String name  = new OptionalMain().getCarInsuranceName(p1);
	}
	
	
    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

	/*
	 * public Set<String> getCarInsuranceNames(List<Person> persons) { return
	 * persons.stream() .map(Person::getCar) .map(optCar ->
	 * optCar.flatMap(Car::getInsurance)) .map(optInsurance ->
	 * optInsurance.map(Insurance::getName)) .flatMap(Optional::stream)
	 * .collect(toSet()); }
	 */
}
