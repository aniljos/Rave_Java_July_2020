package com;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Application {

	public static void main(String[] args) {
		
		//Locale locale = Locale.getDefault();
		//Locale locale = Locale.GERMANY;
		Locale locale = Locale.JAPAN;
		//Locale locale = new Locale("hi", "IN");
		//Locale locale = new Locale("xx", "AA");
		
		Locale.setDefault(locale);
		System.out.println("Language: " + locale.getLanguage());
		System.out.println("Country: " + locale.getCountry());
		System.out.println("ISO Language: " + locale.getISO3Language());
		System.out.println("Display Language: " + locale.getDisplayCountry());
		System.out.println("Display Script: " + locale.getDisplayScript());
		
		//dateLocalization(locale);
		//numberLocalization();
		
		//propertiesResourceBundle();
		classResourceBundle();
		
	}

	private static void classResourceBundle() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("com.Messages");
		System.out.println("title: " + bundle.getString("title"));
		System.out.println("header: " + bundle.getString("header"));
		
	}

	private static void propertiesResourceBundle() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("app");
		System.out.println("Greetings: " + bundle.getString("greetings"));
		System.out.println("Message: " + bundle.getString("message"));
		
		
		MessageFormat formatter = new MessageFormat("");
		formatter.applyPattern(bundle.getString("greetings"));
		Object [] params = {"Sachin", "Morning"};
		System.out.println(formatter.format(params));
	
	}

	private static void numberLocalization() {
		
		double amount = 1_000_000_00;
		System.out.println("amount: " + amount);
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		System.out.println("Formatted amt: " + numberFormat.format(amount));
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		System.out.println("Currency amt: " + currencyFormat.format(amount));
		
	}

	private static void dateLocalization(Locale locale) {
		
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		System.out.println("CurrentDateTime: "+ currentDate);
		
		DateFormat dateFormat = DateFormat.getDateInstance();
		System.out.println("Date: " + dateFormat.format(currentDate));
		
		DateFormat timeFormat = DateFormat.getTimeInstance();
		System.out.println("Time: " + timeFormat.format(currentDate));
		
		
		DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		System.out.println("DateTime: " + dateTimeFormat.format(currentDate));
		
		DateFormat dateTimeFormat_fr = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.FRANCE);
		System.out.println("DateTime: " + dateTimeFormat_fr.format(currentDate));
		
		
		//Java 8
		LocalDate localDate = LocalDate.now();
		System.out.println("Local Date: " + localDate.toString());
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println("Localized Local Date: " + dateTimeFormatter.format(localDate));
		
		
	}

}

















