package edu.autocar.mybatisex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsInfo {
	
	private String code;
	private String name;
	private int price;
	private String maker;
}
