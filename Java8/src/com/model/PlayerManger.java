package com.model;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PlayerManger {

	//Save to XML
	public static void save(List<Player> allPlayers) {
		
		try {
			
			Players players = new Players();
			players.setPlayers(allPlayers);
			JAXBContext context = JAXBContext.newInstance(players.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(players, new File("players.xml"));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	//Fetch form XML
	public static Players fetch() {
		
		Players players = new Players();
		try {
			
			JAXBContext context = JAXBContext.newInstance(players.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			players = (Players) unmarshaller.unmarshal(new File("players.xml"));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return players;
	}
	
}












