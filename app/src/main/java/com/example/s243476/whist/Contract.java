package com.example.s243476.whist;

public class Contract 
{
    int      mLevel;
    CardSuit mTrump;

	public Contract(int trump, int level)
	{
        mTrump = new CardSuit(trump);
        mLevel = level;
    }
		
	public int Trump()
	{
		return mTrump.indexOf();
	}
	
	public int Level()
	{
		return mLevel;
	}

    public String toString(){
        return mTrump.toString() + " (" + mLevel + ")";
    }

}
