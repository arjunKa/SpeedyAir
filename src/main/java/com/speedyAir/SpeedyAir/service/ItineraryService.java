/**
 * 
 */
package com.speedyAir.SpeedyAir.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.speedyAir.SpeedyAir.model.*;

/**
 * {@code ItineraryService} is a helper class used to make changes to an
 * {@code Itinerary}.
 */
public class ItineraryService {

	/**
	 * Load the JSON file for a flight schedule into this Itinerary.
	 * 
	 * @param jsonFilePath file path of flight schedule Json
	 * @param itinerary    itinerary to load to flight schedule into
	 */
	public void loadFlightSchedule(String jsonFilePath, Itinerary itinerary) {

		// Parse JSON String into a JSONObject
		try {
			JSONObject json = JSONLoader.getJson(jsonFilePath);

			// Access JSON values
			if (!json.has("flights")) {
				return;
			}
			JSONArray flightsArray = json.getJSONArray("flights");

			for (int i = 0; i < flightsArray.length(); i++) {
				JSONObject flightJson = flightsArray.getJSONObject(i);

				int day = flightJson.getInt("day");
				int number = flightJson.getInt("number");
				String start = flightJson.getString("start");
				String arrival = flightJson.getString("arrival");
				itinerary.addFlight(new Flight(number, day, start, arrival));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error loading flights from file: " + e.getMessage());
		}

	}

	/**
	 * Load orders from a JSON file into Itinerary.
	 * 
	 * @param n         number of orders to load from JSON
	 * @param path      path for the JSON file with orders
	 * @param itinerary Itinerary to load orders into
	 */
	public void loadOrders(int n, String path, Itinerary itinerary) {

		try {
			JSONObject json = JSONLoader.getJson(path);
			JSONObject orderJson;

			for (int i = 0; i <= n; i++) {

				String orderId = "order-" + String.format("%03d", i);
				if (!json.has(orderId)) {
					continue;
				}
				orderJson = json.getJSONObject(orderId);
				String arrival = orderJson.getString("destination");
				itinerary.addOrder(new Order(i, arrival));
			}
		} catch (IOException e) {
			System.err.println("Error loading orders from file: " + e.getMessage());

		}
	}

	/**
	 * Schedule the orders to available flights.
	 * 
	 * @param itinerary Itinerary to fill orders for.
	 */
	public void fillOrders(Itinerary itinerary) {

		List<Order> orders = itinerary.getOrders();
		List<Flight> flights = itinerary.getFlights();

		for (int i = 0; i < orders.size(); i++) {
			for (int j = 0; j < flights.size(); j++) {

				Flight flight = flights.get(j);

				if (flight.isFull()) {
					continue;
				} else if (flight.getDestination().equalsIgnoreCase(orders.get(i).getDestination())) {
					flight.addOrder(orders.get(i));
					break; // go to the next order in the list
				}
			} // end for loop
		} // end for loop
	}

}
