package com.bootcamp.rummy_hand.components;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootcamp.rummy_hand.oldcard.Card;

public class Test {

	@org.junit.Test
	public void testGetValidSets() {
		Map<String, List<Card>> input = new HashMap<>();
		input.put("5", Arrays.asList(new Card(5, 1),
									new Card(5, 2),
									new Card(5, 1),
									new Card(5, 3)));
		
		List<List<Card>> expected = new ArrayList<>();
		expected.add(Arrays.asList(new Card(5, 1), new Card(5, 2), new Card(5, 3)));
		
		assertEquals(expected, RummyUtils.getAllValidSets(input));
	}
	
	@org.junit.Test
	public void testRunMaps() {
		List<Card> c = Arrays.asList(new Card(1, 1),
									new Card(2, 2),
									new Card(3, 3),
									new Card(4, 4));
		Map<String, List<Card>> expected = new HashMap<>();
		expected.put("Club", Arrays.asList(new Card(1, 1)));
		expected.put("Diamond", Arrays.asList(new Card(2, 2)));
		expected.put("Heart", Arrays.asList(new Card(3, 3)));
		expected.put("Spade", Arrays.asList(new Card(4, 4)));
		
		assertEquals(expected, RummyUtils.createRunMaps(c));
	}
	
	@org.junit.Test
	public void testSetMaps() {
		List<Card> c = Arrays.asList(new Card(1, 1),
									new Card(1, 2),
									new Card(2, 3),
									new Card(2, 4));
		Map<String, List<Card>> expected = new HashMap<>();
		expected.put("A", Arrays.asList(new Card(1, 1), new Card(1, 2)));
		expected.put("2", Arrays.asList(new Card(2, 3), new Card(2, 4)));
		
		assertEquals(expected.get("A"), RummyUtils.createSetMaps(c).get("A"));
		assertEquals(expected.get("2"), RummyUtils.createSetMaps(c).get("2"));
	}
	
	@org.junit.Test
	public void testGetValidRuns() {
		Map<String, List<Card>> input = new HashMap<>();
		input.put("Club", Arrays.asList(new Card(4, 1), new Card(3, 1), new Card(5, 1), 
										   new Card(12, 1), new Card(11, 1)));
		List<List<Card>> expected = new ArrayList<>();
		expected.add(Arrays.asList(new Card(3, 1), new Card(4, 1), new Card(5, 1)));
		assertEquals(expected, RummyUtils.getAllValidRuns(input));
	}
	
}
