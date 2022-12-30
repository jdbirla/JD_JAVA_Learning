package example.method.defaultfeature;

public interface Right {


	default void m1()
	{
		System.out.println("right method");
	}
}
