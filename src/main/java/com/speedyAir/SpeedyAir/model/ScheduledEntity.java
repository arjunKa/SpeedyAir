package com.speedyAir.SpeedyAir.model;

public abstract class ScheduledEntity {
	
	boolean complete;
	int dayOfDeparture;
	int number;
	String departure;
	String destination;
	
	/**
	 * Returns Order's scheduled/filled status.
	 * 
	 * @return boolean that represents if this order has been scheduled to a Flight.
	 */
	public boolean isCompleted() {
		return this.complete;
	}

	/**
	 * Returns order number.
	 * 
	 * @return integer that is this Order's number.
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Returns destination city for this Order.
	 * 
	 * @return String that is the destination assigned for this Order.
	 */
	public String getDeparture() {
		return this.departure;
	}
	

	/**
	 * Returns destination city for this Order.
	 * 
	 * @return String that is the destination assigned for this Order.
	 */
	public String getDestination() {
		return this.destination;
	}
	
	
	public int getDayOfDeparture() {
		return dayOfDeparture;
	}

}
