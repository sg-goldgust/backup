package edu.autocar.tourguide.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TourGuide {
	
	private String tourId;
	private String name;
	private String city;
	private String region;
	private	String content;
	private String site;
	private String homepage;
	
}
