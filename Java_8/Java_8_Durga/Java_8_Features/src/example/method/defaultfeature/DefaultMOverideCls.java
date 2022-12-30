package example.method.defaultfeature;

public class DefaultMOverideCls implements Interf {

	public void m1() {
		System.out.println("My Own impl");
	}

	public static void main(String[] args) {
		DefaultMOverideCls t = new DefaultMOverideCls();
		t.m1();

	}
}
