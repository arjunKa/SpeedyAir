/**
 * 
 */
package com.speedyAir.SpeedyAir.model;

/**
 * The {@code Flight} class represents flight schedules.
 */
public class Flight {

	/** Max orders that each Flight can carry */
	public static final int MAX_ORDERS = 20;
	private int number;
	private int day;
	private String start;
	private String destination;
	private Order orders[];
	private int totalOrders;

	/**
	 * Instantiate Flight object to have flight number, day of flight departure, and
	 * the city codes for departure and destination cities.
	 * 
	 * @param number      the flight number
	 * @param day         the day the flight departs
	 * @param departure   the city code of departure city
	 * @param destination the city code of destination city
	 */
	public Flight(int number, int day, String departure, String destination) {
		this.number = number;
		this.day = day;
		this.start = departure;
		this.destination = destination;
		this.orders = new Order[MAX_ORDERS];
		this.totalOrders = 0;
	}

	/**
	 * Get order number.
	 * 
	 * @return Integer representing order number.
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Get day of flight.
	 * 
	 * @return Integer representing day of flight.
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * Get departure location of flight.
	 * 
	 * @return departure city as String.
	 */
	public String getStart() {
		return this.start;
	}

	/**
	 * Get destination of flight.
	 * 
	 * @return destination city as String.
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Adds an order to this Flight, setting the schedule of order to TRUE, assigns
	 * the order to this flight, and increments totalOrders for this flight.
	 * 
	 * @param order Order to be added to Flight's Order array.
	 */
	public void addOrder(Order order) {
		if (totalOrders < MAX_ORDERS) {
			order.setScheduledFlight(this);
			orders[totalOrders] = order;
			totalOrders++;
		}
	}

	/**
	 * Returns String representation of Flight. Overrides base toString function.
	 * 
	 * @return String representation of Flight.
	 */
	@Override
	public String toString() {
		String s = String.format("Flight: %d, departure: %s," + " arrival: %s, day: %d", number, start, destination,
				day);
		return s;
	}

	/**
	 * Returns the orders array for this flight.
	 * 
	 * @return orders in this Flight.
	 */
	public Order[] getOrders() {
		return this.orders;
	}

	/**
	 * Returns total orders that occupy this flight.
	 * 
	 * @return Integer that is the total number of orders in this Flight.
	 */
	public int getTotalOrders() {
		return this.totalOrders;
	}

	/**
	 * Returns boolean to show if the Flight has reached capacity for orders.
	 * 
	 * @return boolean to represent if the Flight has reached capacity for orders.
	 */
	public boolean isFull() {
		return this.totalOrders == MAX_ORDERS;
	}

	/**
	 * @return departure city of this Flight.
	 */
	public String getDeparture() {
		return this.start;
	}

}
