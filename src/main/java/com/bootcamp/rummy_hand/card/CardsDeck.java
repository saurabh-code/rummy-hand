package com.bootcamp.rummy_hand.card;

import java.util.ArrayList;
import java.util.Random;

public class CardsDeck {
    public ArrayList<Card> cards;
    private int deckSize;

    public CardsDeck() {
        this.cards = new ArrayList<Card>();
        this.createDeck(52);
        this.deckSize = 52;
    }

    public CardsDeck(int size) {
        this.cards = new ArrayList<Card>();
        this.createDeck(size);
        this.deckSize = size;
    }

    private void createDeck(int size) {
        for(int i=1;i<=4;i++) {
            for (int j = 1; j <= 13; j++) {
                Card c = new Card(j, i);
                this.cards.add(c);
            }
        }
        if(size == 54) {
            for(int i=1;i<=2;i++) {
                Card c = new Card(0,0);
                this.cards.add(c);
            }
        }
    }

    public ArrayList<Card> getRandomCards(int numOfCards) {
        this.shuffle();
        ArrayList<Card> randomCards = new ArrayList<>();
        for(int i=0;i<numOfCards;i++)
            randomCards.add(this.cards.get(i));
        return randomCards;
    }

    public void shuffle() {
        Random rand = new Random();

        for (int i=0;i<this.deckSize;i++) {
            int r = i + rand.nextInt(this.deckSize - i);

            //swapping the elements
            Card temp = this.cards.get(r);
            this.cards.set(r, this.cards.get(i));
            this.cards.set(i, temp);
        }
    }

    public void printDeck() {
        for(Card c: this.cards) {
            c.printCard();
        }
    }
}