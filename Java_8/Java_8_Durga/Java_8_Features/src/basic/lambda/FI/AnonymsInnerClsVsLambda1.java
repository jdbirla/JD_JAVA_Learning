package basic.lambda.FI;


public class AnonymsInnerClsVsLambda1 {
	
	int x = 888;
	public void m2()
	{
		InterfAnonymExample1 i = new InterfAnonymExample1() {
			
			int x = 1100;
			@Override
			public void m1() {
				System.out.println(this.x);
			}
		};
		i.m1();
		
	}

	public static void main(String[] args) {
	
		AnonymsInnerClsVsLambda1 aI= new AnonymsInnerClsVsLambda1();
		aI.m2();

	}

}
