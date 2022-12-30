package lambdaasinaction.jd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class Student {
	  // Member attributes of final class
	private final String name;
	private final int regno;
	private final Map<String, String> metadata;

	public Student(String name, int regno, Map<String, String> metadata) {
		this.name = name;
		this.regno = regno;

		// Creating Map object with reference to HashMap
        // Declaring object of string type
		//Deep Copy
		Map<String, String> tempMap = new HashMap<String, String>();
		Iterator itr = metadata.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> ent = (Entry) itr.next();
			tempMap.put(ent.getKey(), ent.getValue());
		}
		this.metadata = tempMap;
		
		//this.metadata = metadata;
	}

	public String getName() {
		return name;
	}

	public int getRegno() {
		return regno;
	}

	/*
	 * public Map<String, String> getMetadata() { return metadata; }
	 */

	// Method 3
    // User -defined type
    // To get meta data
	  public Map<String, String> getMetadata() {
	  
	  Map<String, String> map = new HashMap<String, String>();
	  
	  for (Map.Entry<String, String> m : metadata.entrySet()) { map.put(m.getKey(),
	  m.getValue()); } return map; }
	 
}

public class ImmutableClass {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "First");
		map.put("2", "Second");

		Student s = new Student("Jitendra", 100, map);

		System.out.println(s.getName());
		System.out.println(s.getRegno());
		System.out.println(s.getMetadata());
		
		//s.name = "asdad";
		map.put("3", "third");
		
      System.out.println("Second time print:=>"+s.getMetadata());
      s.getMetadata().put("4", "fourth");
      // Remains unchanged due to deep copy in getter
      System.out.println(s.getMetadata());
      
  /* Output:
Jitendra
100
{1=First, 2=Second}
Second time print:=>{1=First, 2=Second}
{1=First, 2=Second}
        */
	}

}
