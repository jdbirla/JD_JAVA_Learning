package Method.Constructor.reference;

public class TestConstructorref {

	public static void main(String[] args) {
		Interf1 i = ConstructorReferenceEx1::new;
		ConstructorReferenceEx1 sam = i.get();
	}

}
