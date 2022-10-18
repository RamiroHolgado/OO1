package ar.edu.unlp.info.oo1.ej3;

import java.time.LocalDate;

public class DateLapseEj3 implements Date {
	private LocalDate from;
	private int sizeInDays;

	public DateLapseEj3(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}

	@Override
	public LocalDate getFrom() {
		return this.from;
	}

	@Override
	public int sizeInDays() {
		return this.sizeInDays;
	}

	@Override
	public boolean includesDate(LocalDate d) {
		System.out.println(this.from.plusDays(sizeInDays));
		if (this.from.isBefore(d) && this.from.plusDays(sizeInDays).isAfter(d))
			return true;
		
		return false;
		
	}
	
}
