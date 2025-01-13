/**
 * 
 */
package com.speedyAir.SpeedyAir.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

/**
 * {@code JSONLoader} is a helper class used to get a JSONObject from a Json
 * file path.
 */
public final class JSONLoader {

	/**
	 * Returns the String format of the JSON file at path jsonFileName.
	 * 
	 * @param jsonFilePath the file name of the JSON.
	 * @return a String which is the String format of the JSON text.
	 */
	public static JSONObject getJson(String jsonFilePath) throws IOException {
		JSONObject json = new JSONObject();

		// Read JSON file as a String
		String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		json = new JSONObject(content);

		return json;
	}

}
