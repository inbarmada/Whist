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

    public void deal(Hand[] hands){
        UI.log("In Deck", "Trying to deal");
		int i = 0;
        while(!mDeck.isEmpty()){
            UI.log("In Deck", "In while loop");

            //Give playerOne a random card
            int rnd = (int)(Math.random()*mDeck.size());
            UI.log("In Deck", "got rnd" + rnd);

            hands[i].add((Card)mDeck.remove(rnd));
            UI.log("In Deck", "added card to hands[" + i + "] length: " + hands[i].mCards.size());


            if(i==3)
		i = 0;
            else
		i++;
        }
    }
}
