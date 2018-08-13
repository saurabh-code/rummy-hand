package com.bootcamp.rummy_hand.cardLib;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<BaseCard> cards;
	private Integer numPacks;
	private Integer numJokers;
	
	public Deck(Integer numPacks,Integer numJokers){
		this.numPacks = numPacks;
		this.numJokers = numJokers;
		this.createDeck();
	}
	
	private void createDeck(){
		for(int i = 0; i < this.numPacks; i++){
			this.cards.addAll(Pack.createPack(this.numJokers));
		}
	}
	
	public void shuffle(){
		Random rand = new Random();

        for (int i=0;i<this.cards.size();i++) {
            int r = i + rand.nextInt( - i);

            BaseCard temp = this.cards.get(r);
            this.cards.set(r, this.cards.get(i));
            this.cards.set(i, temp);
        }
	}
	
	
	
}
