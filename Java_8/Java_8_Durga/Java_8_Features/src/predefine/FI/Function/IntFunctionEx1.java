package predefine.FI.Function;

import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

public class IntFunctionEx1 {
	public static void main(String[] args) {

		IntFunction<Integer> f = i -> i * i;

		System.out.println(f.apply(5));
		
		IntFunction f1 = i -> i * i;
		
		System.out.println(f1.apply(5));
		
		ToIntFunction<String> f2 =  s->s.length();
		System.out.println(f2.applyAsInt("Jitendra"));
		
		IntToDoubleFunction f3 = i->Math.sqrt(i);
		System.out.println(f3.applyAsDouble(10));
		
		/*****************************All primitive function *******************************
			----Input type---
			IntFunction<R>   -- public R apply(int i)
			LongFunction<R> 	-- public R apply(long i)
			DoubleFuncrion<R>	-- public R apply(double i)
			
			---return type--
			ToIntFunction<T>   --Public int applyAsInt(T t)
			ToLongFunction<T>	 --Public long applyAslong(T t)
			ToDoubleFunction<T>	 --Public double applyAsDouble	(T t)
			
			---inpute and retunr type ---
			
			intToLong  --public long applyAsLong(int i)
			intToDouble --public double applyAsDouble(int i)
			
		--	similar for all
			
			
			----bi function---
			toIntBifunction<t,U>  --public int applyAsInt(t,U);
			
		--	similar for all
			
			
			
			

		
		*****************************All primitive function *******************************/

	}
}
