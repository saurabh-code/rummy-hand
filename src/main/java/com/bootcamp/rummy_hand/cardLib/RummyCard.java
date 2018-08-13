package com.bootcamp.rummy_hand.cardLib;

public class RummyCard {
	
	private BaseCard card;
	private boolean isWildCard;

	public RummyCard(BaseCard card, boolean isWildCard) {
		super();
		this.card = card;
		this.isWildCard = isWildCard;
	}
	
	public BaseCard getCard() {
		return this.card;
	}
	
	public boolean isWildCard() {
		return this.isWildCard;
	}

	@Override
	public String toString() {
		return "RummyCard [card=" + card + ", isWildCard=" + isWildCard + "]";
	}
}
