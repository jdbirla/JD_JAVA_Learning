package Method.Constructor.reference;

public class MethodReferenceEx1 {
	public static void m2() {
		System.out.println("Method reference of m2");
	}

	public static void main(String[] args) {

		Interf i = MethodReferenceEx1::m2;
		i.m1();

	}
	

}
