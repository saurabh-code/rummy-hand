package com.bootcamp.rummy_hand.components;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.rummy_hand.oldcard.Card;
import com.bootcamp.rummy_hand.oldcard.CardsDeck;

public class Rummy {
	
	private int rummyHandSize;
	
	public Rummy(int rummyHandSize){
		this.rummyHandSize = rummyHandSize;
	}
	
	public int minNumOfCardsRequired(List<Card> hand){
		
		List<List<Card>> validRuns = RummyUtils.getAllValidRuns(RummyUtils.createRunMaps(hand));
		for(List<Card> runs: validRuns){
			for(Card card : runs){
				hand.remove(card);
			}
		}
		
		List<List<Card>> validSets = RummyUtils.getAllValidSets(RummyUtils.createSetMaps(hand));
		for(List<Card> runs: validSets){
			for(Card card : runs){
				hand.remove(card);
			}
		}
		
		return hand.size();
	}
	
	public static void main(String[] args){
		CardsDeck cd = new CardsDeck();
		Rummy rm = new Rummy(13);
		for(int i = 0;i<100 ; i++){
			List<Card> hand = cd.getRandomCards(13);
			for(Card card:hand){
				card.printCard();
			}
			System.out.println("min: " + rm.minNumOfCardsRequired(hand) + "\n");
		}
	}
}
