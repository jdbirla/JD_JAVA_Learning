package predifine.FI.consumer;

import java.util.function.IntConsumer;
import java.util.function.ObjDoubleConsumer;

public class primitiveTypeCosumerEx1 {

	public static void main(String[] args) {
		IntConsumer c = i -> System.out.println(i * i);
		c.accept(5);
		
		Employee e1 = new Employee("Jitendra",500000000000000.0);
		ObjDoubleConsumer<Employee> obc =  (e,d)-> e.salary = e.salary+d;
		obc.accept(e1, 100000000000.0);
	}

}
