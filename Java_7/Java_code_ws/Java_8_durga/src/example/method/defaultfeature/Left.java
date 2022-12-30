package example.method.defaultfeature;

public interface Left {

	default void m1()
	{
		System.out.println("Left method");
	}
}
