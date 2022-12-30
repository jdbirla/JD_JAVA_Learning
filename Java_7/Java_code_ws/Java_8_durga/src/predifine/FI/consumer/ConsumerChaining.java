package predifine.FI.consumer;

import java.util.function.Consumer;

public class ConsumerChaining {

	public static void main(String[] args) {
		Consumer<Movie> C1 = M -> System.out.println("Moview name :" + M.name);
		Consumer<Movie> C2 = M -> System.out.println("Moview name :" + M.name + " and hero :" + M.hero);
		Consumer<Movie> C3 = M -> System.out.println("Moview store in DB :" + M.name);
		C1.andThen(C2).andThen(C3).accept(new Movie("Bahubali", "Hritik"));
	}

}
