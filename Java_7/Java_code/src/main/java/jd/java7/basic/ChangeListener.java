package jd.java7.basic;
 public class ChangeListener extends Thread {
		@Override public void run()
		{
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					LOGGER.log(
						Level.INFO,
						"Got Change for MY_INT : {0}",
						MY_INT);
					local_value = MY_INT;
				}
			}
		}
	}