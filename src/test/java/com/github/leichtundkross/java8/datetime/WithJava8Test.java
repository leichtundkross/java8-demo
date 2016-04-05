package com.github.leichtundkross.java8.datetime;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.junit.Test;

public class WithJava8Test {

	private WithJava8 time = new WithJava8();

	@Test
	public void isAfterPayDay() {
		assertEquals(true, time.isAfterPayDay(LocalDateTime.of(2016, 3, 30, 0, 0)));
		assertEquals(false, time.isAfterPayDay(LocalDateTime.of(2016, 4, 5, 0, 0)));
	}

	@Test
	public void daysToNewYear() {
		assertEquals(Period.ofMonths(8).withDays(27), time.daysToNewYear(LocalDate.of(2016, 4, 5)));
	}

	@Test
	public void isRentalOverdue() {
		assertEquals(true, time.isRentalOverdue(LocalDateTime.of(2016, 3, 30, 0, 0)));
	}

	@Test
	public void getBirthMonthText() {
		assertEquals("April", time.getBirthMonthText(LocalDate.of(2016, 4, 5)));
	}
}
