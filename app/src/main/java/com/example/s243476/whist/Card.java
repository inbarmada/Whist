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

    Card decideWinner(Card one, Card two, int ruler)
    {
        Card winner = one;
        if(one.mType == two.mType)
        {
            if(one.mValue < two.mValue)
                winner = two;
        }
        else
        {
            if(two.mType == ruler)
                winner = two;
        }
		return winner;
	}
		

    public Card decideWinner(Card one, Card two, Card three, Card four, int ruler)
    {
        Card winner1 = decideWinner(one, two, ruler);
        Card winner2 = decideWinner(three, four, ruler);
        Card winner = decideWinner(winner1, winner2, ruler);
		return winner;
     }

    public String toString(){
        return "Type: " + mType + " mValue: " + mValue + "\n";
    }

    public int compareTo(Card other){
        Log.d("compareTo", "Heyo I'm in compareTo" + other);
        return mValue.compareTo(other.mValue);
    }
}
