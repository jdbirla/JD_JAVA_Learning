package data.time.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class DataTimeApiEx {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date);

		LocalTime time = LocalTime.now();
		System.out.println(time);

		LocalDate date1 = LocalDate.now();
		System.out.println(date1);

		int dd = date1.getDayOfMonth();
		int mm = date1.getMonthValue();
		int yy = date1.getYear();

		System.out.println(dd + "-" + mm + "-" + yy);
		System.out.printf("%d/%d/%d", dd, mm, yy);

		LocalTime time1 = LocalTime.now();
		System.out.println(time1);

		int h = time1.getHour();
		int m = time1.getMinute();
		int s = time1.getSecond();
		int n = time1.getNano();
		System.out.printf("%d:%d:%d:%d", h, m, s, n);
		System.out.println("*******************");

		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);

		int dd1 = dt.getDayOfMonth();
		int mm1 = dt.getMonthValue();
		int yy1 = dt.getYear();

		int h1 = dt.getHour();
		int m1 = dt.getMinute();
		int s1 = dt.getSecond();
		int n1 = dt.getNano();

		System.out.printf("%d-%d-%d::%d:%d:%d", dd1, mm1, yy1, h1, m1, s1);
		System.out.println("*******************");

		LocalDateTime dt1 = LocalDateTime.of(1991, 06, 21, 5, 10, 10);
		System.out.println(dt1);

		LocalDateTime dt2 = LocalDateTime.of(1995, Month.MAY, 28, 12, 45);
		System.out.println(dt2);
		System.out.println("after 6 months: " + dt2.plusMonths(6));

		System.out.println("before 6 months: " + dt2.minusMonths(6));

		LocalDate birthday = LocalDate.of(1994, 9, 8);
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthday, today);
		System.out.println(p);
		System.out.printf("Year age is %d years %d months and %d days", p.getYears(), p.getMonths(), p.getDays());
		System.out.println("********************8");

		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter year");
		// int y = sc.nextInt();
		int y = 2020;
		Year yo = Year.of(y);
		if (yo.isLeap()) {
			System.out.printf("%d is leap year ", y);

		}
		System.out.println("********************");

		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

		ZoneId IN = ZoneId.of("Asia/Calcutta");
		ZonedDateTime zdt = ZonedDateTime.now(IN);
		System.out.println(zdt);

	}

}
