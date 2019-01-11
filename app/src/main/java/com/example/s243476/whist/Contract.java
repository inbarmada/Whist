package com.example.s243476.whist;

public class Contract 
{
    int      mLevel;
    CardSuit mTrump;


	public Contract(CardSuit trump, int level)
	{
        mTrump = trump;
        mLevel = level;
    }
	
	public CardSuit Trump()
	{
		return mTrump;
	}
	
	public int Level()
	{
		return mLevel;
	}

    @Override
    public boolean equals(Object cmp) 
    {
		return((this.mTrump == ((Contract)cmp).mTrump) && (this.mLevel == ((Contract)cmp).mLevel));
	}
	
    public String toString(){
        return mTrump.toString() + " (" + mLevel + ")";
    }

}
