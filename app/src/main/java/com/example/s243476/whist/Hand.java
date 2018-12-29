package com.example.s243476.whist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Hand {
    ArrayList<Card>  mCards;
    boolean          mAuto;

    public Hand(boolean isAuto){
        mCards = new ArrayList<Card>();
        mAuto = isAuto;
        //Sort mCards
        //Collections.sort(mCards);
        Log.d("HandSort", mCards.toString());
    }

    //Add a card to mCards (for use when dealt a card)
    public void add(Card a){
        mCards.add(a);
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
