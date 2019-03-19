package whist;

import java.lang.String;

public abstract class Player
{
	// Player Profile
	int    mAuto;
	String mName;
	int    mRoundScore; //This is the round score
	int mGameScore; //This is the running total of all games, updated at the end of each round
	static int mId = 0;
	// Player Profile
	Hand   mCurHand;
	Contract   mCurContract;

	static int mAutoId;

	public Player(){
		mAuto = 1;
        mName = "auto" + mId++;
        mRoundScore = 0;
    }

	public Player(String name){
		mAuto = 0;
        mName = name;
        mRoundScore = 0;
  }

  public void SetHand(Hand h){
    mCurHand = h;
  }

  public Card Choose(Card[] roundCards, CardSuit suit, CardSuit trump){
		if(mCurContract.Level() > mRoundScore)
			return mCurHand.winChoose(roundCards, suit, trump);
		else
			return mCurHand.loseChoose(roundCards, suit, trump);
	}

	public Card Choose(){
		return mCurHand.Choose(/*trump*/);
	}

	public String Name(){
		return mName;
    }

	public int RoundScore(){
		return mRoundScore;
    }

	public int UpdateScore(int roundScore){
		return mRoundScore += roundScore;
  }

	public int UpdateGameScore(){
		if(mRoundScore == mCurContract.Level()){
			if(mRoundScore == 0)
				mGameScore += 50; //Must adjust for "up" games
			else
				mGameScore += mRoundScore*mRoundScore + 10;
		}else{
			if(mCurContract.Level() == 0){
				mGameScore -= 50;
				mGameScore += 10*(mRoundScore-1);
			}else{
				int difference = Math.abs(mRoundScore - mCurContract.Level());
				mGameScore -= difference*10;
			}
		}
		mRoundScore = 0;

		return mGameScore;
	}

    public abstract Contract Bid(Contract curContract);

    public abstract Contract SetContract(CardSuit trump, int count);

    public int DebugInfo(){
			UI.Log(Severity.DEBUG, ".....Player::DebugInfo", this + ": " + mCurHand);
			return 0;
    }

    public String toString(){
			if(mCurContract == null)
				 return mRoundScore + "";
			return mRoundScore + "(" + mCurContract.Level() + ")";
    }

}
