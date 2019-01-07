package com.example.s243476.whist;

import android.util.Log;

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
        Log.d("In Deck", "Trying to deal");
		int i = 0;
        while(!mDeck.isEmpty()){
            Log.d("In Deck", "In while loop");

            //Give playerOne a random card
            int rnd = (int)(Math.random()*mDeck.size());
            Log.d("In Deck", "got rnd" + rnd);

            hands[i].add((Card)mDeck.remove(rnd));
            Log.d("In Deck", "added card to hands[" + i + "] length: " + hands[i].mCards.size());


            if(i==3)
				i = 0;
			else
				i++;
        }
    }
}
