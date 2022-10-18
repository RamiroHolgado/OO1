package ar.edu.unlp.info.oo1.ejercicio15_alquilerDePropiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return to;
	}
	
	public int sizeInDays() {
		return (int) this.from.until(this.to, ChronoUnit.DAYS);
	}
	
	public boolean includesDate(LocalDate d) {
		return (this.from.isBefore(d) && this.to.isAfter(d));	
	}
	
	public boolean overlaps(DateLapse d) {
		return includesDate(d.getTo()) || includesDate(d.getFrom());
	}
	
}
