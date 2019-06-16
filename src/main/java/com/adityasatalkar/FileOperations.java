package com.adityasatalkar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperations {

	public static String toPrettyFormat(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(json);
	}

	public static final String CURRENT_DIR_PATH = System.getProperty("user.dir");

	public static void appendToFile(String textToAppend, String fileName) throws IOException {

		FileWriter fileWriter = new FileWriter(CURRENT_DIR_PATH + File.separator + fileName +".txt", true); //Set true for append mode
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(textToAppend);  //New line
		printWriter.close();
	}
}