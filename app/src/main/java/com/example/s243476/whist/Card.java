package com.example.s243476.whist;/*package com.example.s243476.whist;

<<<<<<< HEAD*/
import java.util.Collection;
import android.util.Log;
public class Card {
//=======


public class Card implements Comparable<Card>{
>>>>>>> cf20c91f3e108d23d594798969a02f9afd2f7d2b
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

    public int compareTo(Card other){
        Log.d("compareTo", "Heyo I'm in compareTo" + other);
        return mValue.compareTo(other.mValue);
    }
}
