package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class Messages_hi_IN extends ResourceBundle{

	private StringTokenizer tokenizer = new StringTokenizer("title header");
	
	@Override
	protected Object handleGetObject(String key) {
		
		switch (key) {
		case "title": {
			
			return "hindi: This is the title ";
		}
		case "header": {
			
			return "hindi: This is the Header";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}

	@Override
	public Enumeration<String> getKeys() {
		
		ArrayList<String> list = new ArrayList<String>();
		
		while (tokenizer.hasMoreElements()) {
			String token = (String) tokenizer.nextElement();
			list.add(token);
		}
		
		return Collections.enumeration(list);
	}

}
