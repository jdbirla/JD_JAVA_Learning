package basic.lambda.FI;

public class AnonymousClassLambda {

	public static void main(String[] args) {

		//Option 1
		Runnable r = () -> {

			for (int i = 0; i < 10; i++) {
				System.out.println("child thread" + i);
			}

		};
		Thread t = new Thread(r);
		t.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main thread" + i);
		}
		
		//Option 2

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("child new t thread" + i);
			}
		});
		t1.start();
	}

}
