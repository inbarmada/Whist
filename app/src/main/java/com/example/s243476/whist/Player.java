package com.example.s243476.whist;

import java.lang.String;

public abstract class Player
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

	public Player(){
		mAuto = 1;
        mName = "auto" + mId++;
        mTotalScore = 0;
    }

	public Player(String name){
		mAuto = 0;
        mName = name;
        mTotalScore = 0;
  }

  public void SetHand(Hand h){
    mCurHand = h;
  }

  public Card Choose(Card[] roundCards, CardSuit suit, CardSuit trump){
		return mCurHand.Choose(roundCards, suit, trump);
	}

	public Card Choose(){
		return mCurHand.Choose(/*trump*/);
	}

	public String Name(){
		return mName;
    }

	public int TotalScore(){
		return mTotalScore;
    }

	public int UpdateScore(int gameScore){
		return mTotalScore += gameScore;
    }

    public abstract Contract Bid(Contract curContract);

    public Contract SetContract(CardSuit trump, int count){
			if(count != 0)
			{
				int level = mCurHand.SetContract(trump, count);
				mCurContract = new Contract(trump, level);
			}

			UI.Log(Severity.DEBUG, "Player::SetContract", this.toString() + ", " + mCurContract);
			return mCurContract;
    }

    public int DebugInfo(){
			UI.Log(Severity.DEBUG, ".....Player::DebugInfo", this + ": " + mCurHand);
			return 0;
    }

    public String toString(){
			return mName + "(" + mTotalScore + ")";
    }

}
