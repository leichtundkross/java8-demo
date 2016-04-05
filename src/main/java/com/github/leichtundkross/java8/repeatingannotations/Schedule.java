package com.github.leichtundkross.java8.repeatingannotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Repeatable annotations need flag {@link Repeatable}
 */
@Repeatable(Schedules.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedule {

	String dayOfMonth() default "first";

	String dayOfWeek() default "Mon";

	int hour() default 12;
}
