package com.example.s243476.whist;

import java.util.ArrayList;

class Hand {
    ArrayList<Card>  mCards;
    boolean          mAuto;

    public Hand(boolean isAuto){
        mCards = new ArrayList<Card>();
        mAuto = isAuto;
    }

    public void add(Card a){
        mCards.add(a);
    }

    public Card choose(Card a){
        mCards.remove(a);
        return a;
    }

    public ArrayList<Card> showCards(){
        return mCards;
    }
}
