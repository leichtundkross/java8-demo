package com.github.leichtundkross.java8.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;

public class WithJava8 {

	public boolean isAfterPayDay(LocalDateTime datetime) {
		if (datetime.getMonthValue() == 2) {
			return datetime.getDayOfMonth() > 26;
		}

		return datetime.getDayOfMonth() > 28;
	}

	public Period daysToNewYear(LocalDate fromDate) {
		// use Period for date operations
		LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
		return Period.between(fromDate, newYear);
	}

	public boolean isRentalOverdue(LocalDateTime datetimeRented) {
		// use Duration for datetime operations
		Duration rentalPeriod = Duration.ofDays(2).plus(Duration.ofHours(12));
		return datetimeRented.plus(rentalPeriod).isBefore(LocalDateTime.now());
	}

	public String getBirthMonthText(LocalDate dateOfBirth) {
		return dateOfBirth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
}
