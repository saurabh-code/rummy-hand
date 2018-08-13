package com.bootcamp.rummy_hand.cardLib;

public class BaseCard {
	
	private Suit suit;
	private Pip pip;
	
	public BaseCard(Suit suit, Pip pip) {
		this.suit = suit;
		this.pip = pip;
	}
	
	public int compareSuit(Suit s) {
		return this.suit.compareTo(s);
	}
	
	public int comparePip(Pip p) {
		return this.pip.compareTo(p);
	}
	
	public boolean isJoker() {
		return suit == Suit.JOKER;
	}
}
