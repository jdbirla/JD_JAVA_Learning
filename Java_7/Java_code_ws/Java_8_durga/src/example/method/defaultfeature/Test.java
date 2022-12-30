package example.method.defaultfeature;

public class Test implements Left, Right {

	public void m1() {
		System.out.println("My own impl");
		Left.super.m1();
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.m1();
	}

}
