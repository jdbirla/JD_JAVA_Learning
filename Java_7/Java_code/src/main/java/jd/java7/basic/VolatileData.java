package jd.java7.basic;

public class VolatileData {
	private static volatile int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void increaseCounter() {
		++counter; // increases the value of counter by 1
	}
}