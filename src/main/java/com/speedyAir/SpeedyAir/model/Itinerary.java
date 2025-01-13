package com.speedyAir.SpeedyAir.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code Itinerary} is a class to store Flights and Orders.
 */
public class Itinerary {

	private List<Flight> flights;
	private List<Order> orders;
	private int availableSpace = 0;

	/**
	 * 
	 * Instantiate Itinerary.
	 */
	public Itinerary() {
		flights = new ArrayList<Flight>();
		orders = new LinkedList<Order>();
	}

	/**
	 * Returns list of flights.
	 * 
	 * @return List of flights.
	 */
	public List<Flight> getFlights() {
		return flights;
	}

	/**
	 * Returns list of orders.
	 * 
	 * @return List of orders.
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * Returns integer representing amount of space available on a Flight for
	 * orders.
	 * 
	 * @return Integer representing available space for individual orders.
	 */
	public int getAvailableSpace() {
		return availableSpace;
	}

	/**
	 * Add a Flight to this Itinerary and increment available space for this
	 * Itinerary.
	 * 
	 * @param flight the Flight to add to itinerary
	 */
	public void addFlight(Flight flight) {
		flights.add(flight);
		this.availableSpace += Flight.MAX_ORDERS;
	}

	/**
	 * Add an order to this itinerary and decrement available space for this
	 * itinerary.
	 * 
	 * @param order Order to be added to Itinerary
	 */
	public void addOrder(Order order) {
		orders.add(order);
		this.availableSpace -= 1;

	}

}
