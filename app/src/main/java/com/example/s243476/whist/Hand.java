package com.example.s243476.whist;

import java.util.ArrayList;

public class Hand {
    ArrayList<Integer> hand;
    public Hand(){
        hand = new ArrayList<Integer>();
    }

    public void add(int a){
        hand.add(a);
    }

    public int choose(int a){
        return hand.remove(a);
    }

    public ArrayList<Integer> showCards(){
        return hand;
    }
}
