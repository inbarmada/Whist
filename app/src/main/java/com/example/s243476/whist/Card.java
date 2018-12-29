package com.example.s243476.whist;

import java.util.Collection;

public class Card {
    Integer mValue;
    Integer mType;

    public Card(int number){
        mType = number / 13;
        mValue = (number % 13) + 2;
    }

    public Card decideWinner(Card one, Card two, Card three, Card four, int ruler)
    {
        Card Win1 = one;
        Card Win2 = three;
        if(one.mType == two.mType)
        {
            if(one.mValue < two.mValue)
                Win1 = two;
        }
        else
        {
            if(two.mType == ruler)
                Win1 = two;
        }

        if(three.mType == four.mType)
        {
            if(three.mValue < four.mValue)
                Win2 = four;
        }
        else
        {
            if(four.mType == ruler)
                Win2 = four;
        }

        if(Win1.mType == Win2.mType)
        {
            if(Win1.mValue < Win2.mValue)
                return Win1;
            else
                return Win2;
        }
        else
        {
            if(Win2.mType == ruler)
                return Win2;
            else
                return Win1;
        }
    }

    public String toString(){
        return "Type: " + mType + " mValue: " + mValue + "\n";
    }
}
