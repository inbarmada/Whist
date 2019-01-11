package com.example.s243476.whist;

import java.lang.String;

public class Player 
{
	// Player Profile
	int    mAuto;
	String mName;
	int    mTotalScore;
	static int mId = 0;
	// Player Profile
	Hand   mCurHand;
	Contract   mCurContract;

	static int mAutoId;

	public Player()
	{
		mAuto = 1;
        mName = "auto" + mId++;
        mTotalScore = 0;
    }
	
	public Player(String name)
	{
		mAuto = 0;
        mName = name;
        mTotalScore = 0;
    }

    public void SetHand(Hand h){
	    mCurHand = h;
    }

    public Card Choose()
	{
		return mCurHand.Choose();
	}
	
	public String Name()
	{
		return mName;
    }
	
	public int TotalScore()
	{
		return mTotalScore;
    }

	public int UpdateScore(int gameScore)
	{
		return mTotalScore += gameScore;
    }

    public Contract Bid(Contract curContract)
	{
		mCurContract = mCurHand.Evaluate(curContract);
		//UI.log("Player::Bid", this + ": " + mCurHand + "(" + mCurContract + ")");
		return mCurContract;
    }
    public int SetContract(CardSuit trump, int count)
	{
		if(count != 0)
		{
			int level = mCurHand.SetContract(trump, count);
			mCurContract = new Contract(trump.indexOf(), level);
		}
			
		UI.log("Player::SetContract", this.toString() + ", " + mCurContract);
		return mCurContract.Level();
    }
	
    public int DebugInfo()
	{
		UI.log(".....Player::DebugInfo", this + ": " + mCurHand);
		return 0;
    }
	
    public String toString()
	{
		return mName + "(" + mTotalScore + ")";
    }
	
}
