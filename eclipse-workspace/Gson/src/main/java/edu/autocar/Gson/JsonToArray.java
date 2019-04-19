package edu.autocar.Gson;

import java.util.Arrays;

import com.google.gson.Gson;

public class JsonToArray {
	public static void main(String[] args) {
		try {
			String json = FileUtil.readAll("c:/temp/json_array.json");
			Gson gson = new Gson();
			
			Sensor[] sensor = gson.fromJson(json, Sensor[].class);
			System.out.println(Arrays.toString(sensor));
		} catch(Exception e) {
			
		}
	}
}
