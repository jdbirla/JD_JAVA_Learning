package basic.lambda.FI;

public class AnonymousClass {

	public static void main(String[] args) {

		Runnable r 	 =  new Runnable() {
			
			@Override
			public void run() {
				for (int i=0;i<10;i++)
				{
					System.out.println("Child thread"+i);
				}
				
				
			}
		};
		Thread t = new Thread(r);
		t.start();
		
		for (int i=0;i<10;i++)
		{
			System.out.println("Main thread"+i);
		}
	}

}
