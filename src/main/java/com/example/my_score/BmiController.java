package com.example.my_score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {
	
	@Autowired//자동 주입
	BmiRepository bmiRepository;

	
	@GetMapping("/")
	public String input_bmi() {
		
		Bmi bmi = new Bmi();
		bmi.setHeight(174);
		bmi.setWeight(74);
		bmi.setBmi_value(24.4);
		bmi.setBmi_result("정상");
		bmiRepository.save(bmi);
	
		return "input_bmi";
	}
	
	@PostMapping("/result_bmi")
	public String result_bmi(
			Model model,
			@RequestParam int height,
			@RequestParam int weight) {
		//bmi 계산 = 몸무게(kg) / 키(m) ^ 2
		
		double meter = (double)height/100.0;
		
		double bmi_value = weight / Math.pow(meter, 2);
		bmi_value = Math.round(bmi_value*10)/10.0;
		
	
		String bmi_result = "";
		
		if(bmi_value < 20.0) {
			bmi_result = "저체중";
			
		}
		else if(bmi_value < 25.0) {
			bmi_result = "정상";
		}
		else if(bmi_value < 30.0) {
			bmi_result = "과체중";
		}
		else {
			bmi_result = "비만";
		}
		
		//오브젝트 생성 : 클래스명, 오브젝트명 = new 생성자();
		//오브젝트 생성 후 .을 찍어서 메소드 이용	
		//이렇게 하면 간단하게 나타낼 수 있음
		Bmi bmi = new Bmi();
		bmi.setHeight(height);
		bmi.setWeight(weight);
		bmi.setBmi_value(bmi_value);
		bmi.setBmi_result(bmi_result);
		
		model.addAttribute("bmi",bmi);
	
		return "result_bmi";
	}

}
