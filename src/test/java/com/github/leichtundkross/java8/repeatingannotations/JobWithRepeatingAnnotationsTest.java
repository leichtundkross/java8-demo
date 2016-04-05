package com.github.leichtundkross.java8.repeatingannotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Method;

import org.junit.Test;

public class JobWithRepeatingAnnotationsTest {

	@Test
	public void doWeeklyCleanup_getAnnotations() throws NoSuchMethodException, SecurityException {
		final Method annotatedMethod = JobWithRepeatingAnnotations.class.getDeclaredMethod("doWeeklyCleanup", new Class<?>[] {});

		Schedule scheduleAnnotation = annotatedMethod.getAnnotation(Schedule.class);
		assertNull("Found more than 1 @Schedule Annotation", scheduleAnnotation);

		Schedule[] scheduleAnnotations = annotatedMethod.getAnnotationsByType(Schedule.class);
		assertEquals(2, scheduleAnnotations.length);

		Schedules schedulesAnnotation = annotatedMethod.getAnnotation(Schedules.class);
		assertEquals(2, schedulesAnnotation.value().length);
	}

	@Test
	public void doMonthlyCleanup_getAnnotations() throws NoSuchMethodException, SecurityException {
		final Method annotatedMethod = JobWithRepeatingAnnotations.class.getDeclaredMethod("doMonthlyCleanup", new Class<?>[] {});

		Schedule scheduleAnnotation = annotatedMethod.getAnnotation(Schedule.class);
		assertNotNull("Found exaclty 1 @Schedule Annotation", scheduleAnnotation);

		Schedule[] scheduleAnnotations = annotatedMethod.getAnnotationsByType(Schedule.class);
		assertEquals(1, scheduleAnnotations.length);

		Schedules schedulesAnnotation = annotatedMethod.getAnnotation(Schedules.class);
		assertNull("@Schedules not present since there are less than 2 @Schedule annotations", schedulesAnnotation);
	}
}
