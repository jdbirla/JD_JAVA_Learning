package streams.world;

import java.util.stream.Stream;

public class IterateMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Stream.iterate(1, element -> element + 1) .forEach(System.out::println);
		 */
        
        
        /**
         * 
         * We can use stream to iterate any number of times. Stream provides
         * predefined methods to deal with the logic you implement. In the
         * following example, we are iterating, filtering and passed a limit
         * to fix the iteration.
         * 
         */
		Stream.iterate(1, i->i+1).filter(i->i%5==0).limit(5).forEach(System.out::println);
	
	}

	
}
