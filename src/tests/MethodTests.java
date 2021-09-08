package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

import model.DateHelper;

class MethodTests {

	@Test
	void test() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");

		LocalDate date1 =  LocalDate.parse("2021 03 01", dtf);
		LocalDate date2 =  LocalDate.parse("2021 03 03", dtf);
		
		System.out.println(DateHelper.getDiffDays(date1, date2));
	}
	
	@Test
	void test2() {
		Date date1 = new Date();
		date1.setYear(2002);
		Date date2 = new Date();
		date2.setYear(2001);
		
		
		double days =DateHelper.getDiffDays(date1, date2);
		
		System.out.println(days);
	}

}
