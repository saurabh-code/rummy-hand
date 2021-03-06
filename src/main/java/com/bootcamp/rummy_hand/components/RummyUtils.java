package com.bootcamp.rummy_hand.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.bootcamp.rummy_hand.oldcard.Card;

public class RummyUtils {
	
	
	public static Map<String, List<Card>> createRunMaps(List<Card> hand) {
		Map<String, List<Card>> runMap = initMap(Arrays.asList("Club","Diamond","Heart","Spade"));
		for (Card c : hand) {
			String suit = c.getSuit();
			List<Card> cl = runMap.get(suit);
			cl.add(c);
			runMap.put(suit, cl);
		}
		return runMap;
	};
	
	public static Map<String, List<Card>> createSetMaps(List<Card> hand) {
		Map<String, List<Card>> runMap = initMap(Arrays.asList("Joker","A","2","3","4","5","6","7","8","9","10","J","Q","K"));
		for (Card c : hand) {
			String value = c.getValue();
			List<Card> cl = runMap.get(value);
			cl.add(c);
			runMap.put(value, cl);
		}
		return runMap;
	}
	
	public static List<List<Card>> getAllValidRuns(Map<String, List<Card>> runMaps) {
		return getAllRuns(runMaps, 3);
	}
	
	public static List<List<Card>> getAllRuns(Map<String, List<Card>> runMaps, int runSize) {
		List<List<Card>> result = new ArrayList<>();
		for (Entry<String, List<Card>> e : runMaps.entrySet()) {
			String suit = e.getKey();
			List<Integer> values = e.getValue().stream().map(c -> c.getNumberValue()).collect(Collectors.toList());

			Collections.sort(values);
			List<List<Integer>> allConsSubSeq = getConsecutiveSubSeq(values);
			List<List<Integer>> allValidRuns = allConsSubSeq.stream()
												.filter(l -> l.size() >= runSize)
												.collect(Collectors.toList());
			
			for (List<Integer> l : allValidRuns) {
				List<Card> asCards = l.stream()
										.map(i -> new Card(i, suit))
										.collect(Collectors.toList());
				result.add(asCards);
			}
		}
		
		return result;
	}
	
	public static List<List<Card>> getAllValidSets(Map<String, List<Card>> setMaps) {
		return getAllSets(setMaps, 3);
	}
	
	public static List<List<Card>> getAllSets(Map<String, List<Card>> setMaps, int setSize) {
		List<List<Card>> resultSets = new ArrayList<>();
		for (Entry<String, List<Card>> e : setMaps.entrySet()) {
			List<Card> set = new ArrayList<>();
			Set<String> suitsFound = new HashSet<>();
 			for (Card c : e.getValue()) {
				if (!suitsFound.contains(c.getSuit())) {
					set.add(c);
					suitsFound.add(c.getSuit());
				}
			}
 			
 			if (set.size() >= setSize) {
 				resultSets.add(set);
 			}
		}
		
		return resultSets;
	}
	
	private static Map<String, List<Card>> initMap (List<String> keys) {
		Map<String, List<Card>> m = new HashMap<>();
		for (String key : keys) {
			m.put(key, new ArrayList<>());
		}
		return m;
	}
	

	private static List<List<Integer>> getConsecutiveSubSeq(List<Integer> list) {
		List<List<Integer>> allConsSeq = new ArrayList<>();
		
		if (list.isEmpty()) {
			return allConsSeq;
		}
		
		List<Integer> consSeq = new ArrayList<>();
		consSeq.add(list.get(0));
		int prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			int elem = list.get(i);
			if (elem == prev + 1) {
				consSeq.add(elem);
				prev = elem;
			} else {
				allConsSeq.add(consSeq);
				consSeq = new ArrayList<>();
				consSeq.add(elem);
				prev = elem;
			}
		}
		allConsSeq.add(consSeq);
		return allConsSeq;
	}

}