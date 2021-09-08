package app;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataHelper {

	public static long getDifferenceDays(Date startDate, Date endDate) {
	    long diff = endDate.getTime() - startDate.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
