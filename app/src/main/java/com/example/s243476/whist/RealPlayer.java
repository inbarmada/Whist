package com.example.s243476.whist;

import java.lang.String;

public class RealPlayer extends Player
{
    public Contract Bid(Contract curContract){
      UI.Log(Severity.INFO, "Player::Bid", this + ": hand:: " + mCurHand);

      UI.Log(Severity.INFO, "Player::Bid", this + "Do you want to place a bid (NO-0; YES-1)?");
      int bid = UI.readInt();
      mCurContract = curContract;
      if(bid == 1){
    		UI.Log(Severity.INFO, "Player::Bid", this + ": Choose suit (CL-0; DI-1; He-2; SP-3; NT-4):: ");
        int suit = UI.readInt();

        UI.Log(Severity.INFO, "Player::Bid", this + ": Choose takes:: ");
        int takes = UI.readInt();
        mCurContract = new Contract(CardSuit.values()[suit], takes);
      }
  		return mCurContract;
    }

    public Contract SetContract(CardSuit trump, int count){
			if(count != 0)
			{
        UI.Log(Severity.INFO, "Player::Bid", this + ": hand:: " + mCurHand);
        UI.Log(Severity.INFO, "Player::Bid", this + ": Choose takes:: ");
        int takes = UI.readInt();
				mCurContract = new Contract(trump, takes);
			}

			UI.Log(Severity.DEBUG, "Player::SetContract", this.toString() + ", " + mCurContract);
			return mCurContract;
    }


  	public RealPlayer(){
  		super();
      }

  	public RealPlayer(String name){
  		super(name);
      }

}
