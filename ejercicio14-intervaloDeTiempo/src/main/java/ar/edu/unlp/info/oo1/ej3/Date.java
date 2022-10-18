package ar.edu.unlp.info.oo1.ej3;

import java.time.LocalDate;

public interface Date {
	
	public LocalDate getFrom();
	
	public int sizeInDays();
	
	public boolean includesDate(LocalDate d);
	
}
