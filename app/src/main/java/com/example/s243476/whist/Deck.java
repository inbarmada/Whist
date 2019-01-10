package com.example.s243476.whist;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> mDeck;
	
    public Deck(){
		mDeck = new ArrayList<Card>();
        for(int i = 0; i<52; i++){
            mDeck.add(new Card(i));
        }
    }

    public void Deal(Hand[] hands){
		int i = 0;
        while(!mDeck.isEmpty()){
            //Give playerOne a random card
            int rnd = (int)(Math.random()*mDeck.size());
            hands[i].Add(mDeck.remove(rnd));
			
			if(i==3)
				i = 0;
			else
				i++;
        }
		for(i=0; i<4; i++)
		{
			hands[i].Sort();
		}
    }
}
