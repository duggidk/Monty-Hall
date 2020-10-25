package com.teksystems.montyhall.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;


public class JSONFileCreate {

	public static void main(String[] args) throws Exception{
		 
		try {
		      File myObj = new File("src\\main\\resources\\filename.json");
		      FileWriter myWriter = new FileWriter(myObj);
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }
		 

	}


