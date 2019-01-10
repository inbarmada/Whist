package com.example.s243476.whist;

public class CardSuit 
{
	final String[] mStr = { "CL", "DI", "HE", "SP", "NT" };
	int mValue;

	public CardSuit(int value)
	{
        mValue = value;
    }
		
	public int indexOf()
	{
		return mValue;
	}

    public String toString(){
        return mStr[mValue];
    }
}
