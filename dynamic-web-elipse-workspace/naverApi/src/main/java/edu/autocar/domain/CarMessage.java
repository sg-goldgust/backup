package edu.autocar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarMessage {
	private String msgType ;
	private int target ;
	private double lat ;
	private double lng ;
}
