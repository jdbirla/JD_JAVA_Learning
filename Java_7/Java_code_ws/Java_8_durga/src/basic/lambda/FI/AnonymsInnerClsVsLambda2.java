package basic.lambda.FI;

public class AnonymsInnerClsVsLambda2 {
	
	int x = 1000 ;
	public void m2()
	{
		InterfAnonymExample2 i = () ->{
			int y = 999;
				System.out.println(x);
				System.out.println(y);

		};
		i.m1();
	}

	public static void main(String[] args) {
	
		AnonymsInnerClsVsLambda2 aI= new AnonymsInnerClsVsLambda2();
		aI.m2();

	}

}
