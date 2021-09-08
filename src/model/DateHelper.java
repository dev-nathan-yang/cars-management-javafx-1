package model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateHelper {

	public static long getDiffDays(LocalDate start, LocalDate end) {
		long diff = Duration.between(start, end).toDays();
		System.out.println("Days: " + diff);
		return diff;
	}
	
	public static long getDiffDays(Date date1, Date date2) {
		
		long diff = date1.getTime() - date2.getTime();
		
		double seconds = diff / 1000;
		double hours = seconds / 3600;
		long days = (long)hours / 24;
		
		System.out.println(TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS));
		return days;
	}

}
