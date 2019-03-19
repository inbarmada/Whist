package whist;

import java.lang.String;

public abstract class Player
{
	// Player Profile
	int    mAuto;
	String mName;
	int    mNumTakes; //This is the round score
	int mGameScore; //This is the running total of all games, updated at the end of each round
	static int mId = 0;
	// Player Profile
	Hand   mCurHand;
	Contract   mCurContract;

	static int mAutoId;

	public Player(){
		mAuto = 1;
        mName = "auto" + mId++;
        mNumTakes = 0;
    }

	public Player(String name){
		mAuto = 0;
        mName = name;
        mNumTakes = 0;
  }

  public void SetHand(Hand h){
    mCurHand = h;
  }

  public Card Choose(Card[] roundCards, CardSuit suit, CardSuit trump){
		if(mCurContract.Level() > mNumTakes)
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

	public int NumTakes(){
		return mNumTakes;
    }

	public int GameScore(){
		return mGameScore;
	}

	public int UpdateScore(int numTakes){
		return mNumTakes += numTakes;
  }

	public int UpdateGameScore(){
		if(mNumTakes == mCurContract.Level()){
			if(mNumTakes == 0)
				mGameScore += 50; //Must adjust for "up" games
			else
				mGameScore += mNumTakes*mNumTakes + 10;
		}else{
			if(mCurContract.Level() == 0){
				mGameScore -= 50;
				mGameScore += 10*(mNumTakes-1);
			}else{
				int difference = Math.abs(mNumTakes - mCurContract.Level());
				mGameScore -= difference*10;
			}
		}
		mNumTakes = 0;

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
				 return mNumTakes + "";
			return mNumTakes + "(" + mCurContract.Level() + ")";
    }

}
