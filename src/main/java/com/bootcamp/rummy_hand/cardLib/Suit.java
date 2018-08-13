package com.bootcamp.rummy_hand.cardLib;

public enum Suit {
	
	JOKER(0),
	CLUB(1),
	DIAMOND(2),
	HEART(3),
	SPADE(4);
	
	private int rank;
	
	private Suit(int rank) {
		this.rank = rank;
	}
	
	public int getRank() {
		return this.rank;
	}
}
