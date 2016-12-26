/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.model.TimeRange;

public class TimeRangeTest {

	@Test
	public void testAddWeeks() {
		TimeRange timeRange = new TimeRange();
		TimeRange timeRange2 = new TimeRange();
		assertTrue(timeRange.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertTrue(timeRange.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));
		timeRange2 = timeRange2.addWeeks(1);
		assertFalse(timeRange.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertFalse(timeRange.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));
		timeRange.getCalendar1().add(Calendar.DAY_OF_MONTH, 7);
		timeRange.getCalendar2().add(Calendar.DAY_OF_MONTH, 7);
		assertTrue(timeRange.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertTrue(timeRange.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));


	}

	public void testAddWeeks3(){
		TimeRange timeRange = new TimeRange();
		TimeRange timeRange2 = new TimeRange();
		assertTrue(timeRange.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertTrue(timeRange.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));
		timeRange2 = timeRange2.addWeeks(0);

		assertTrue(timeRange.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertTrue(timeRange.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));


	}

}
