package com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		Players players = PlayerManger.fetch();
//		for (Player player : players.getPlayers()) {
//			player.print();
//		}
		//filter(players.getPlayers());
		//filter1(players.getPlayers());
		//map(players.getPlayers());
		//flatMap();
		//aggregates(players.getPlayers());
		//reduce(players.getPlayers());
		
		parallel();

	}
	
	private static void parallel() {
		
		//immutable
		List<Integer> numbers  = Arrays.asList(1,2,3,4,5,6,7,8,9);
		//numbers.add(11);
//		List<Integer> numbers = new ArrayList<Integer>();
//		
//		for (int i = 0; i < 100; i++) {
//			numbers.add(i);
//		}
		
		// pure functions
		// immutable data structures
		
		List<Integer> sqaures =  
				numbers
					.parallelStream()
					//.stream()
					//.map(n -> n * n)
					.map(n -> {
						
						System.out.println("Thread: " + Thread.currentThread().getName());
						return n * n;
					})
					.collect(Collectors.toList());
		
		sqaures.forEach(System.out::println);
		
	}






	private static void reduce(List<Player> players) {
		
		int sum = players.stream().mapToInt(p -> p.getTotalRuns()).reduce(0, (l, r) -> l  + r);
		System.out.println("Sum with reduce: " + sum);
		
		String names = players.stream().map(p -> p.getName()).reduce((l, r) -> l + ", " + r).get();
		System.out.println(names);
		
		
	}






	private static void aggregates(List<Player> players) {
		
		//Stream
		players.stream().map(p -> p.getTotalRuns()).forEach(System.out::println);
		
		int sum = players.stream().mapToInt(p -> p.getTotalRuns()).sum();
		System.out.println("Sum: " + sum);
		
		OptionalDouble average = players.stream().mapToInt(p -> p.getTotalRuns()).average();
		
		System.out.println("Average: " + average.orElse(-1));
		
		OptionalInt max = players.stream().mapToInt(p -> p.getTotalRuns()).max();
		System.out.println("Max: " + max.orElse(-1));
	
		OptionalInt min = players.stream().mapToInt(p -> p.getTotalRuns()).min();
		System.out.println("Min: " + min.orElse(-1));
		
		IntSummaryStatistics statistics =  players.stream().mapToInt(p -> p.getTotalRuns()).summaryStatistics();
		System.out.println(statistics);
		
	}


	



	private static void flatMap() {
		
		List<Integer> numList1 = Arrays.asList(1,2,3,4,5);
		List<Integer> numList2 = Arrays.asList(10,20,30,40);
		
		List<List<Integer>> list = Arrays.asList(numList1, numList2);
		System.out.println(list);
		
		List<Integer> flatList =  list.stream().flatMap(lst -> lst.stream()).collect(Collectors.toList());;
		//flatList.forEach(System.out::println);
		System.out.println(flatList);
	}



	private static void map(List<Player> players) {
		
		List<String> names =  players.stream().map(p -> p.getName()).collect(Collectors.toList());
		names.forEach(System.out::println);
		
		System.out.println("-----------Batsmen-------------");
		List<String> batsmen =  players.stream().filter(p -> p.getRole() == Role.Batsman).map(p -> p.getName()).collect(Collectors.toList());
		batsmen.forEach(System.out::println);
		
		
		
	}

	private static void filter(List<Player> players) {

		Stream<Player> playersStream = players.stream();
//		playersStream.filter(new Predicate<Player>() {
//			@Override
//			public boolean test(Player t) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		});

		Stream<Player> filteredStream = playersStream.filter(p -> p.getRole() == Role.Batsman);

		Player player = new Player("Pujara", Role.Batsman, 14000, (short) 0, Optional.of("MI"),
				LocalDate.of(2009, 11, 23));
		players.add(player);

		filteredStream.forEach(p -> p.print());

	}

	private static void filter1(List<Player> players) {

		players
			.stream()
			.filter(p -> p.getRole() == Role.Batsman)
			.forEach(p -> p.print());
	}

}










