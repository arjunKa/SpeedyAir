/**
 * 
 */
package com.speedyAir.SpeedyAir.model;

/**
 * The {@code Order} class represents an order that can be put on a
 * {@code Flight}.
 */
public class Order {

	private int orderNumber;
	private String destination;
	private String departure;
	private int flightDay;
	private int flightNumber;
	private boolean scheduled;

	/**
	 * Instantiate an Order object.
	 * 
	 * @param orderNumber Order number for this order
	 * @param destination destination city for this order
	 */
	public Order(int orderNumber, String destination) {
		this.orderNumber = orderNumber;
		this.destination = destination;
		this.scheduled = false;
	}

	/**
	 * Scheduled this order to a flight.
	 * 
	 * @param flight the flight this order will be on.
	 */
	public void setScheduledFlight(Flight flight) {
		this.scheduled = true;
		this.flightDay = flight.getDay();
		this.flightNumber = flight.getNumber();
		this.departure = flight.getDeparture();
	}

	/**
	 * Returns Order's scheduled/filled status.
	 * 
	 * @return boolean that represents if this order has been scheduled to a Flight.
	 */
	public boolean getScheduled() {
		return this.scheduled;
	}

	/**
	 * Returns order number.
	 * 
	 * @return integer that is this Order's number.
	 */
	public int getNumber() {
		return this.orderNumber;
	}

	/**
	 * Returns destination city for this Order.
	 * 
	 * @return String that is the destination assigned for this Order.
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Returns String representation of Order. Overrides base toString function.
	 * 
	 * @return String representation of Order.
	 */
	@Override
	public String toString() {
		String s;
		if (scheduled) {
			s = String.format("order: %s, flightNumber: %d," + " departure: %s, arrival: %s, day: %d",
					"order-" + String.format("%03d", orderNumber), flightNumber, departure, destination, flightDay);

		} else {
			s = String.format("order: %s, flightNumber: %s", "order-" + String.format("%03d", orderNumber),
					"not scheduled");

		}
		return s;
	}

}
