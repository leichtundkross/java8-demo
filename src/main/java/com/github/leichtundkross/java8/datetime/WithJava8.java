package com.github.leichtundkross.java8.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class WithJava8 {

	private static final LocalTime NO_TIME_PART = LocalTime.of(0, 0, 0);

	public boolean isAfterPayDay(LocalDateTime datetime) {
		if (datetime.getMonthValue() == 2) {
			return datetime.getDayOfMonth() > 26;
		}

		return datetime.getDayOfMonth() > 28;
	}

	public Duration daysToNewYear(LocalDate fromDate) {
		LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
		return Duration.between(LocalDateTime.of(fromDate, NO_TIME_PART), LocalDateTime.of(newYear, NO_TIME_PART));
	}

	public boolean isRentalOverdue(LocalDateTime datetimeRented) {
		Duration rentalPeriod = Duration.ofDays(2).plus(Duration.ofHours(12));
		return datetimeRented.plus(rentalPeriod).isBefore(LocalDateTime.now());
	}

	public String getBirthMonthText(LocalDate dateOfBirth) {
		return dateOfBirth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
}
