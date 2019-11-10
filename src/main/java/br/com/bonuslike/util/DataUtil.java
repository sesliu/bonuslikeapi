package br.com.bonuslike.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DataUtil {
	
	
	private String data = "dd/MM/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data);
	
	
	public String convertData(String data) {
		
		LocalDate date = LocalDate.parse(data);
		
		System.out.println(date);
		
		return simpleDateFormat.format(date);
	}
	

}
