package com.github.leichtundkross.java8.repeatingannotations;

public class JobWithRepeatingAnnotations {

	@Schedule(dayOfWeek = "Wed", hour = 23)
	@Schedule(dayOfWeek = "Fri", hour = 23)
	public void doWeeklyCleanup() {
		// clean up DB two times during the week
	}

	@Schedule(dayOfMonth = "last")
	public void doMonthlyCleanup() {
		// clean up DB at last day of month
	}
}
