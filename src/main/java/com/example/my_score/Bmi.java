package com.example.my_score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//초기화를 하지 않으면 기본 생성자
public class Bmi {

	
	private int height; // cm로 해야함
	
	private int weight; //kg

	private double bmi_value;// 소수점 1째자리에서 반올림
	
	private String bmi_result;

}
