package com.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{

	@Override
	public String marshal(LocalDate localDate) throws Exception {
		
		return localDate.format(DateTimeFormatter.ISO_DATE);
	}

	@Override
	public LocalDate unmarshal(String date) throws Exception {
		
		return LocalDate.parse(date);
	}

	
	
}
