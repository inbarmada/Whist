package com.example.s243476.whist;

import android.util.Log;

public class Card implements Comparable<Card>{
    Integer mValue;
    Integer mType;

    public Card(int number){
        mType = number / 13;
        mValue = (number % 13) + 2;
    }

    public String toString(){
        return "Type: " + mType + " mValue: " + mValue + "\n";
    }

    public int compareTo(Card other){
        Log.d("compareTo", "Heyo I'm in compareTo");
        return mValue.compareTo(other.mValue);
    }
}
