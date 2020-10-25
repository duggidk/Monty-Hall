/**
 * 
 */
package com.teksystems.montyhall.utils;

import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author duggi
 *
 */
public class MontyHallUtils {

	/**
	 * 
	 */
	public MontyHallUtils() {
		// TODO Auto-generated constructor stub
	}	
	
	public static void JSONFileCreate() {
		//to do
	}
	
	public static JSONObject JSONReader() {
		JSONParser parser = new JSONParser();
		//JsonParser to convert JSON string into Json Object
		JSONObject jsonObject = new JSONObject();
		try {
			Object obj = parser.parse(new FileReader("src\\main\\resources\\game-config.json"));
			jsonObject = (JSONObject) obj;
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	public static void JSONWrite() {
		JSONParser parser = new JSONParser();
		//JsonParser to convert JSON string into Json Object
		JSONObject jsonObject = new JSONObject();
		try {
			Object obj = parser.parse(new FileReader("src\\main\\resources\\game-config.json"));
			jsonObject = (JSONObject) obj;
			
			jsonObject.put("prizedObject","BMW");			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * <th>&#128016;</th>
    	<th>&#128659;</th>
	 */
	public static String[] stringToEmoji(String [] arr) {
		for(int i=0;i< arr.length; i++) {
			
			String element = arr[i].toUpperCase();
			System.out.println(element);
			if(element.equalsIgnoreCase("GOAT")  ) {arr[i] = "&#128016;";}
		    if(element.equalsIgnoreCase("BMW") ) {arr[i] = "&#128659;";}
	
		}
		return arr;
	}	

}
