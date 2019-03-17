package com.example.s243476.whist;

import java.lang.String;

public class AutoPlayer extends Player
{
    public Contract Bid(Contract curContract){
  		mCurContract = mCurHand.Evaluate(curContract);
  		UI.Log(Severity.DEBUG, "Player::Bid", this + ": " + mCurHand + "(" + mCurContract + ")");
  		return mCurContract;
    }

    public Contract SetContract(CardSuit trump, int count){
			if(count != 0)
			{
				int level = mCurHand.SetContract(trump, count);
				mCurContract = new Contract(trump, level);
			}

			UI.Log(Severity.DEBUG, "Player::SetContract", this.toString() + ", " + mCurContract);
			return mCurContract;
    }

  	public AutoPlayer(){
  		super();
      }

  	public AutoPlayer(String name){
  		super(name);
      }

}
