package com.bootcamp.rummy_hand.cardLib;

import java.util.ArrayList;


public class Pack {
	

	public static ArrayList<BaseCard> createPack(int numJokers){
		ArrayList<BaseCard> cards = new ArrayList<BaseCard>();
		
		for(Suit s: Suit.values()){
			if(s.equals(Suit.JOKER)){
				continue;
			}
			
			for(Pip p: Pip.values()){
				if(p.equals(Pip.JOKER)){
					continue;
				}
				
				cards.add(new BaseCard(s,p));
			}
		}	
		
		for(int i = 0; i < numJokers; i++){
			cards.add(new BaseCard(Suit.JOKER, Pip.JOKER));
		}
		
		return cards;
	}
}
