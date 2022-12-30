package basic.lambda.FI;

public class TestRunnableLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = () -> {

			for (int i = 0; i <= 10; i++) {
				System.out.println("Child method by runnable");
			}

		};

		Thread t = new Thread(r);
		t.start();

		for (int i = 0; i <= 10; i++) {
			System.out.println("main method by main thread");
		}

	}

}
