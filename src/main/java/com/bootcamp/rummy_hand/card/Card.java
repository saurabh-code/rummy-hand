package com.bootcamp.rummy_hand.card;

public class Card{
    private final static String[] VALUES ={"Joker","A","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final static String[] SUITS ={"Joker","Club","Diamond","Heart","Spade"};

    
    private String value;
    private String suit;
    private int numberValue;
    
    public Card(int n1, int n2)
    {
        this.value=this.VALUES[n1];
        this.suit=this.SUITS[n2];
        this.numberValue = n1;
    }
    
    public Card(String value, String suit) {
    		this.value= value;
        this.suit= suit;
    }
    
    public Card(int value, String suit) {
		this.value= this.VALUES[value];
		this.suit= suit;
		this.numberValue = value;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public String getSuit()
    {
        return suit;
    }
    public boolean isNext(Card c)
    {
        if(c.getSuit().equals(this.suit))
        {
            for (int i = 1; i < VALUES.length; i++)
                if (value.equals(VALUES[i]))
                {
                    if (c.getValue().equals(VALUES[i + 1]))
                        return true;
                }
        }
        return false;
    }

    public boolean isSameValue(Card c)
    {
        return value.equals(c.getValue());
    }

    public boolean isSameSuit(Card c)
    {
        return suit.equals(c.getSuit());
    }

    public void printCard()
    {
        System.out.println(this.value + " of " + this.suit);
    }
    
    public int getNumberValue() {
    		return this.numberValue;
    }
    
	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
    
}


