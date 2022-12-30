package predifine.FI.Supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierEx1 {

	public static void main(String[] args) {
		Supplier<Date> s = () -> new Date();
		System.out.println("Todays's date : " + s.get());

		System.out.println("************************************************************");

		Supplier<String> s1 = () -> {

			String[] sarry = { "Sunnnny", "Bunny", "Chinni", "Vinni" };
			int x = (int) (Math.random() * 4);
			return sarry[x];
		};
		System.out.println(s1.get());
		System.out.println("************************************************************");

		Supplier<String> s3 = () -> {
			String otp = "";
			for (int i = 0; i <= 6; i++) {
				otp = otp + (int) (Math.random() * 10);

			}
			return otp;
		};
		System.out.println(s3.get());
		System.out.println("************************************************************");

		Supplier<String> s4 = () -> {
			String pass = "";
			Supplier<Integer> d = () -> (int) (Math.random() * 10);

			String symboles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
			Supplier<Character> c = () -> symboles.charAt((int) Math.random() * 29);

			for (int i = 1; i <= 8; i++) {
				if (i % 2 == 0) {
					pass = pass + d.get();
				} else {
					pass = pass + c.get();
				}
			}
			return pass;
		};

		System.out.println(s4.get());
		System.out.println("************************************************************");

	}

}
