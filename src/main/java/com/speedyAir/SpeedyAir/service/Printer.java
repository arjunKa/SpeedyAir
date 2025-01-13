/**
 * 
 */
package com.speedyAir.SpeedyAir.service;

import com.speedyAir.SpeedyAir.model.Flight;
import com.speedyAir.SpeedyAir.model.Itinerary;
import com.speedyAir.SpeedyAir.model.Order;

/**
 * Printer class to print flights and orders.
 */
public class Printer {
	/**
	 * Print the Flight schedule into console.
	 * 
	 * @param i itinerary to print from.
	 */
	public void printFlightSchedule(Itinerary i) {
		// Print each flight
		for (Flight flight : i.getFlights()) {
			System.out.println(flight.toString());
		}
	}

	/**
	 * Print Itinerary into console.
	 * 
	 * @param i itinerary to print from.
	 */
	public void printIntineray(Itinerary i) {
		// Print each order
		for (Order order : i.getOrders()) {
			System.out.println(order.toString());
		}
	}
}