package com.example.s243476.whist;

public class Card{
    Integer mValue;
    Integer mType;

	public Card(int number){
        mType = number / 13;
        mValue = (number % 13) + 2;
    }

    static Card Compare(Card one, Card two, int ruler)
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
			{
                winner = two;
			}
        }
        UI.log("Compare", "Comparing " + one + " to " + two + ", and the winner is..." + winner);
		return winner;
	}
		

    public static Card Compare(Card one, Card two, Card three, Card four, int ruler)
    {
        Card winner1 = Compare(one, two, ruler);
        Card winner2 = Compare(three, four, ruler);
        Card winner = Compare(winner1, winner2, ruler);
		return winner;
     }

    public String toString(){
        return "Type: " + mType + " mValue: " + mValue + "\n";
    }

}
