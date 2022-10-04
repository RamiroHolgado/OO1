package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class Fifo extends JobScheduler{

	public JobDescription next() {
		
		JobDescription j = jobs.get(0);
		this.unschedule(j);
		
		return j;
		
	}
}
