package Method.Constructor.reference;

public class MethodReferenceEx2 {

	public static void m1() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Child method");
		}

	}

	public static void main(String[] args) {

		// MethodReferenceEx2 obj = new MethodReferenceEx2();
		// Option1 :
		// Runnable r = obj::m1;
		// Option 2
		Runnable r = MethodReferenceEx2::m1;

		Thread t = new Thread(r);
		t.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main method");
		}

	}
}
