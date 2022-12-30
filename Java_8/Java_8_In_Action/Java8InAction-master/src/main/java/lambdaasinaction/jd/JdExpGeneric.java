package lambdaasinaction.jd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import lambdasinaction.chap2.FilteringApples.Apple;



public class JdExpGeneric {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));	
		List<String> stringvalues = Arrays.asList("Jitendra","Kirti","Jaya","Jyoti");
		List<String> emptylist = new ArrayList<String>() ;
		List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println("greenApples :"+greenApples);
		List<String> startwithJ = filter(stringvalues, (String s) -> s.startsWith("J"));
		System.out.println("startwithJ :"+startwithJ);
			
		IntPredicate evenumbers = (int i) -> i%2==0;
		System.out.println("evenumbers :" +evenumbers.test(1000));
		
		Predicate<Integer> objevenumbers = (Integer i) -> i%2==0;
		System.out.println("objevenumbers :" +objevenumbers.test(1000));
		
		Predicate<List<String>> predicateList = (List<String> l) -> l.isEmpty();
		System.out.println("predicateList:" +predicateList.test(emptylist));

		Predicate<String> p = s->emptylist.add(s);		
		System.out.println("p :"+ p.test("Jitu"));

		Consumer<String> c = s->emptylist.add(s);		
		c.accept("Jiten1");
		System.out.println("emptylist :"+emptylist);
		
	
		
		/*Runnable r2 =  new Runnable() {
		//	int a = 5;
			@Override
			public void run() {
				//int a = 2;
				System.out.println("runnable  : "+this);
				
			}
		};
		Thread t =  new Thread(r2);
		t.start();*/
     new JdExpGeneric().jdlambda();
	}
	
	public static <T> List<T> filter(List<T> inventory, JdPredicate<T> p){
		List<T> result = new ArrayList<>();
		for(T apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}   
	
	interface JdPredicate<T>{
		public boolean test(T a);
	}
	
	public void jdlambda() {
		int a = 10;
		Runnable r1 = () -> {
			System.out.println("runnable  : "+this.toString());
		};
		  new Thread(r1).start();
	}
	
	  
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "jitendra Birla JdExpGeneric";
	}
}
