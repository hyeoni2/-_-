package com.example.my_score;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="bmi")
//초기화를 하지 않으면 기본 생성자
public class Bmi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="height")
	private int height; // cm로 해야함
	
	@Column(name="weight")
	private int weight; //kg
	
	@Column(name="bmi_value")
	private double bmi_value;// 소수점 1째자리에서 반올림
	
	@Column(name="bmi_result")
	private String bmi_result;

}
