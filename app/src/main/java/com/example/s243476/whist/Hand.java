package com.example.s243476.whist;

import android.util.Log;

import java.util.ArrayList;

class Hand {
    ArrayList<Card>  mCards;

    public Hand(){
        mCards = new ArrayList<Card>();
        //Sort mCards
        //Collections.sort(mCards);
        Log.d("HandSort", mCards.toString());
    }

    //Add a card to mCards (for use when dealt a card)
    public void add(Card a){
        Log.d("In Hand", "Trying to add(Card)" + a + "length " + mCards.size());

        mCards.add(a);
        Log.d("In Hand", "new length " + mCards.size());

    }

    //Choose a card, if not automatic
    public Card choose(Card a){
        Log.d("choose(card)", "Heyo I'm in choose(card)");
        mCards.remove(a);
        return a;
    }

    //Choose a card if automatic
    public Card choose(int type){
        Log.d("choose(type)", "Heyo I'm in choose(type)");

        for(int i = mCards.size() - 1; i >= 0; i--){
            Log.d("choose(type)", "Heyo I'm still there in choose(type)" + i + mCards.get(i));

            if(mCards.get(i).mType == type){
                return mCards.remove(i);
            }
            Log.d("choose(type)", "Heyo I'm still in choose(type)");

        }
        return mCards.remove(0);
    }

    //return a list of all cards to show the (non-automatic) player
    public ArrayList<Card> showCards(){
        Log.d("showCards", "Heyo I'm in showCards");

        return mCards;
    }
}
