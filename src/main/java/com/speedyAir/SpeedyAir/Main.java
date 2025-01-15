
package com.speedyAir.SpeedyAir;

import com.speedyAir.SpeedyAir.model.Itinerary;
import com.speedyAir.SpeedyAir.service.ItineraryService;
import com.speedyAir.SpeedyAir.service.Printer;

/**
 * {@code Main} class for program execution.
 */
public class Main {

	/**
	 * Main method to run the application.
	 * 
	 * @param args String arguments.
	 */
	public static void main(String[] args) {
		Itinerary i = new Itinerary();
		ItineraryService itineraryService = new ItineraryService();
		Printer printer = new Printer();

		System.out.println("USER STORY #1:");
		itineraryService.loadFlightSchedule("src/main/resources/coding-assignment-flights.json", i);
		printer.printFlightSchedule(i);

		System.out.println("\nUSER STORY #2:");
		itineraryService.loadOrders(99, "src/main/resources/coding-assigment-orders.json", i);
		itineraryService.fillOrders(i);
		printer.printIntineray(i);

	}

}
