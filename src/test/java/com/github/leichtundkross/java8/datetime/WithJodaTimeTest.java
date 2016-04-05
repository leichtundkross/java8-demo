package com.github.leichtundkross.java8.datetime;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;

public class WithJodaTimeTest {

	private WithJodaTime time = new WithJodaTime();

	@Test
	public void isAfterPayDay() {
		assertEquals(true, time.isAfterPayDay(new DateTime(2016, 3, 30, 0, 0)));
		assertEquals(false, time.isAfterPayDay(new DateTime(2016, 4, 5, 0, 0)));
	}

	@Test
	public void daysToNewYear() {
		assertEquals(Days.days(271), time.daysToNewYear(new LocalDate(2016, 4, 5)));
	}

	@Test
	public void isRentalOverdue() {
		assertEquals(true, time.isRentalOverdue(new DateTime(2016, 3, 30, 0, 0)));
	}

	@Test
	public void getBirthMonthText() {
		assertEquals("April", time.getBirthMonthText(new LocalDate(2016, 4, 5)));
	}
}
