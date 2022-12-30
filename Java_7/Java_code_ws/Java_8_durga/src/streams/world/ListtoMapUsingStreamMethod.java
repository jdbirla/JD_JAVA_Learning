package streams.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListtoMapUsingStreamMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();

		// Adding Products
		productList.add(new Product(1, "Sony mobile", 25000));
		productList.add(new Product(2, "Lenovo mobile", 15000));
		productList.add(new Product(3, "Nokia mobile", 10000));
		productList.add(new Product(4, "Samsung mobile", 40000));
		productList.add(new Product(5, "Micromax mobile", 10000));

		// Converting Product List into a Map
		Map<Integer, String> productPriceMap = productList.stream()
				.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));

		System.out.println(productPriceMap);
	}

}
