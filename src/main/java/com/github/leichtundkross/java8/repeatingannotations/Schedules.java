package com.github.leichtundkross.java8.repeatingannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Schedules {

	Schedule[] value();
}
