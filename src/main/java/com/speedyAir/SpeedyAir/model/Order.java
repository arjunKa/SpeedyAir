/**
 * 
 */
package com.speedyAir.SpeedyAir.model;

/**
 * The {@code Order} class represents an order that can be put on a
 * {@code Flight}.
 */
public class Order {

	private int number;
	private String destination;
	private boolean scheduled = false;
	private Flight flight;

	/**
	 * Instantiate an Order object.
	 * 
	 * @param number      Order number for this order
	 * @param destination destination city for this order
	 */
	public Order(int number, String destination) {
		this.number = number;
		this.destination = destination;

	}

	/**
	 * Set this order's scheduled status to {@code true} or {@code false}.
	 * 
	 * @param b boolean true of false.
	 */
	public void setScheduled(boolean b) {
		this.scheduled = b;
	}

	/**
	 * Set the Flight carrying this Order.
	 * 
	 * @param f the Flight that carries this Order.
	 */
	public void setFlight(Flight f) {
		this.flight = f;
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
		return this.number;
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
					"order-" + String.format("%03d", number), flight.getNumber(), flight.getStart(),
					flight.getDestination(), flight.getDay());

		} else {
			s = String.format("order: %s, flightNumber: %s", "order-" + String.format("%03d", number),
					"not scheduled");

		}
		return s;
	}

}
