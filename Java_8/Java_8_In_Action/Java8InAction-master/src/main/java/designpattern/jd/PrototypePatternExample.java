package designpattern.jd;

import java.util.ArrayList;
import java.util.List;

class VehicleC implements Cloneable {

	private List<String> vehicleList;

	public VehicleC() {
		this.vehicleList = new ArrayList<String>();
	}

	public VehicleC(List<String> list) {
		this.vehicleList = list;
	}

	public void insertData() {
		vehicleList.add("Honda amaze");
		vehicleList.add("Audi A4");
		vehicleList.add("Hyundai Creta");
		vehicleList.add("Maruti Baleno");
		vehicleList.add("Renault Duster");
	}

	public List<String> getVehicleList() {
		return this.vehicleList;
	}

	
	  @Override protected Object clone() throws CloneNotSupportedException {
	  List<String> tempList = new ArrayList<String>();
	  
	  for (String s : this.getVehicleList()) { tempList.add(s); }
	  
	  return new VehicleC(tempList);
	  
	  }
	 

}

public class PrototypePatternExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		VehicleC a = new VehicleC();
		a.insertData();

		VehicleC b = (VehicleC) a.clone();
		List<String> list = b.getVehicleList();

		list.add("Honda new Amaze");

		System.out.println("a list: " + a.getVehicleList());
		System.out.println("B list: " + list);

		b.getVehicleList().remove("Audi A4");
		System.out.println(list);
		System.out.println(a.getVehicleList());
	}
}
