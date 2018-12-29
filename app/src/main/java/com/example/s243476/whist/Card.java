package com.example.s243476.whist;

public class Card {
    Integer mValue;
    Integer mType;

    public Card(int number){
        mType = number / 13;
        mValue = (number % 13) + 2;
    }

    public String toString(){
        return "Type: " + mType + " mValue: " + mValue + "\n";
    }
}
