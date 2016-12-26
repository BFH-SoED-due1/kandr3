/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.model;

import java.util.Calendar;

public class TimeRange {
	private Calendar calendar1;
	private Calendar calendar2;

	public TimeRange() {
		this.calendar1 = Calendar.getInstance();
		this.calendar2 = Calendar.getInstance();
	}

	public TimeRange(Calendar calendar1, Calendar calendar2) {
		// this.calendar1.set(year, month, date, hourOfDay, minute);
		this.calendar1 = calendar1;
		this.calendar2 = calendar2;
	}

	public Calendar getCalendar1() {
		return calendar1;
	}

	public Calendar getCalendar2() {
		return calendar2;
	}

	@Override
	public String toString() {
		return "TimeRange [calendar1=" + calendar1.toString() + ", calendar2=" + calendar2.toString() + "]";
	}

	/**
	 *
	 * @param weeks
	 *            number of weeks, the reservation is recurring
	 * @return the dates in the returned TimeRange object will be shifted by the
	 *         number of weeks, which is specified in the parameter 'weeks'
	 */
	public TimeRange addWeeks(int weeks) {
		Calendar calendar1 = (Calendar) this.calendar1.clone();
		Calendar calendar2 = (Calendar) this.calendar2.clone();

		calendar1.add(Calendar.DAY_OF_MONTH, 7 * weeks);
		calendar2.add(Calendar.DAY_OF_MONTH, 7 * weeks);
		return new TimeRange(calendar1, calendar2);
	}
}
