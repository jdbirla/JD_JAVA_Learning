package lambdaasinaction.jd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
  public static void main(String[] args) {
		String someString1 = "Jitendra Birla";
		String[] arrstr = someString1.replaceAll("\\W", "").split("");
		System.out.println(arrstr);
		Arrays.stream(arrstr).sorted().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.forEach((k,v) -> System.out.println(k +"  " +v));

}
}
