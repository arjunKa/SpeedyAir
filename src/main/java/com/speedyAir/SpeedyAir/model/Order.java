/**
 * 
 */
package com.speedyAir.SpeedyAir.model;

/**
 * The {@code Order} class represents an order that can be put on a
 * {@code Flight}.
 */
public class Order extends ScheduledEntity {
	
	int flightNumber;

	/**
	 * Instantiate an Order object.
	 * 
	 * @param orderNumber Order number for this order
	 * @param destination destination city for this order
	 */
	public Order(int orderNumber, String destination) {
		this.number = orderNumber;
		this.destination = destination;
		this.complete = false;
	}

	/**
	 * Scheduled this order to a flight.
	 * 
	 * @param flight the flight this order will be on.
	 */
	public void setScheduledFlight(Flight flight) {
		this.complete = true;
		this.dayOfDeparture = flight.getDayOfDeparture();
		this.flightNumber = flight.getNumber();
		this.departure = flight.getDeparture();
	}
	

	/**
	 * Returns String representation of Order. Overrides base toString function.
	 * 
	 * @return String representation of Order.
	 */
	@Override
	public String toString() {
		String s;
		if (complete) {
			s = String.format("order: %s, flightNumber: %d," + " departure: %s, arrival: %s, day: %d",
					"order-" + String.format("%03d", number), flightNumber, departure, destination, dayOfDeparture);

		} else {
			s = String.format("order: %s, flightNumber: %s", "order-" + String.format("%03d", number),
					"not scheduled");

		}
		return s;
	}

}
