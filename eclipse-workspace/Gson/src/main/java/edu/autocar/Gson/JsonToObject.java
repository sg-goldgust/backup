package edu.autocar.Gson;

import com.google.gson.Gson;

public class JsonToObject {
	
	public static void main(String[] args) {
		try {
			String json = FileUtil.readAll("c:/temp/sensor.json");
			Gson gson = new Gson();
			
			Sensor sensor = gson.fromJson(json, Sensor.class);
			System.out.println(sensor);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
