package com.bootcamp.rummy_hand.cardLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck<T> {
	private List<T> cards;
	private Integer numPacks;
	private Integer numJokers;
	
	public Deck(Map<String, Object> property, Function<Map<String, Object>, Function<BaseCard, T>> converter){
		this.numPacks = (Integer) property.get("numPacks");
		this.numJokers = (Integer) property.get("numJokers");
		
		Function<BaseCard, T> convertToT = converter.apply(property);
		cards = this.createDeck().stream()
								 .map(convertToT)
								 .collect(Collectors.toList());
	}

	private List<BaseCard> createDeck(){
		List<BaseCard> baseCards = new ArrayList<>();
		for(int i = 0; i < this.numPacks; i++){
			 baseCards.addAll(Pack.createPack(this.numJokers));
		}
		return baseCards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<List<T>> dealCard(int players, int handSize) {
		this.shuffle();
		List<List<T>> deals = Stream.generate(ArrayList<T>::new)
									.limit(players)
									.collect(Collectors.toList());
		
		for (int turn = 0; turn < handSize; turn++) {
			for (int player = 0; player < players; player++) {
				deals.get(player).add(cards.get(player + turn));
			}
		}
		
	    return deals;
	}
	
	public List<T> getDeck() {
		return this.cards;
	}
	
}

//BaseCard{
//	getObject(){
//		return new BaseCard()
//	}
//}
//
//RummyCard extends BaseCard{
//	bool isWild;
//	
//	@override
//	getObject(){
//		return new RummyCard();
//	}
//}
//
//class Deck<T>{
//	T c = T.getObject();
//	c.isWild;		
//}
//
//Deck<RummyCard> 