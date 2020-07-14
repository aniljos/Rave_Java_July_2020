package com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.Player;
import com.model.PlayerManger;
import com.model.Players;
import com.model.Role;

public class StreamsApp {

	public static void main(String[] args) {
		
		
		
		
//		List<Player> allPlayers = new ArrayList<Player>();
//		Player player = new Player("Rohit", Role.Batsman, 24000, (short)0, Optional.of("MI"), LocalDate.of(2009, 11, 23));
//		player.print();
//		
//		
//		allPlayers.add(player);
//		PlayerManger.save(allPlayers);
		
		
		Players players =  PlayerManger.fetch();
		for (Player player : players.getPlayers()) {
			player.print();
		}
		
	}

}
