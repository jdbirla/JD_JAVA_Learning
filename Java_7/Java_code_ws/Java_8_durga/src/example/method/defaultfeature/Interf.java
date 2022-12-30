package example.method.defaultfeature;

public interface Interf {

	default void m1()
	{
		System.out.println("Default method");
	}
}
