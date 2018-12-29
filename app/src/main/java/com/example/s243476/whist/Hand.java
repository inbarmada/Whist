package com.example.s243476.whist;

import java.util.ArrayList;

class Hand {
    ArrayList<Card>  mCards;
    boolean          mAuto;

    public Hand(boolean isAuto){
        mCards = new ArrayList<Card>();
        mAuto = isAuto;
    }

    public void add(int a){
        mCards.add(a);
    }

    public int choose(int a){
        return mCards.remove(a);
    }

    public ArrayList<Integer> showCards(){
        return mCards;
    }
}
