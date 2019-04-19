package edu.autocar.iotmonitor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
	long   sensorId;
	String sensorType;
	double value;      
	String regDate; 	  
	String owner;		
	String place;
}
