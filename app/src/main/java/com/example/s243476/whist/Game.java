package com.example.s243476.whist;

import android.util.Log;

public class Game{

	int mCurRuler;
    Player[] mPlayers = new Player[4];
	int mNextToPlay = 0;
	int mNextToBet = 0;
	MainActivity runner;

	public Game(Player p1, Player p2, Player p3, Player p4)
	{
		mPlayers[0] = p1;
		mPlayers[1] = p2;
		mPlayers[2] = p3;
		mPlayers[3] = p4;
		mNextToPlay = 0;
		mNextToBet = 0;

		runner = new MainActivity();
	}

	public void Play(int numOfRounds)
	{
		Log.d("In Game", "Trying to play");
	    for(int i=0; i<numOfRounds; i++)
		{
			PlayRound();
		}
	}
	
    private void PlayRound()
	{
		Log.d("In Game", "Starting PlayRound()");
	    Hand[] Hands = new Hand[4];
        Hands[0] = new Hand();
        Hands[1] = new Hand();
        Hands[2] = new Hand();
        Hands[3] = new Hand();
        Log.d("In Game", "Created Hand");

        //Create a deck
        Deck deck = new Deck();
        Log.d("In Game", "Created Deck");


        //Deal the cards
        deck.deal(Hands);
        Log.d("In Game", "Did Deck.deal");

        mPlayers[0].createHand(Hands[0]);
        mPlayers[1].createHand(Hands[1]);
        mPlayers[2].createHand(Hands[2]);
        mPlayers[3].createHand(Hands[3]);
        Log.d("In Game", "Created Hands");


        betting();
        Log.d("In Game", "betting()");


        playing();
        Log.d("In Game", "playing()");

    }
	
	private void betting()
	{
		int i = mNextToBet % 4;
		mNextToBet ++;
		int passCount = 0;
		int[] passTable = {0,0,0,0};

		do
		{
			if(passTable[i] == 0)
			{
				if(mPlayers[i].Declare() == 0)
				{
					passTable[i] = 1;
					passCount ++;
				}
			}
			if(i == 3)
				i = 0;
			else
				i++;
		} while(passCount < 3);
	}

	private void playing()
	{
        Log.d("In Game", "in playing");

        for(final Card i : mPlayers[0].mCurHand.showCards()) {
            Log.d("In Game", "Trying to create a card button");

            runner.createCardButton(mPlayers[0], i);
        }

	}

	public void playerOneChose(Card one){

	}

    public void getRoundCards(Card one, Card two, Card three, Card four, int ruler){
		Log.d("getRoundCards", "Heyo I'm in getRoundCards");

		Card winner = Card.Compare(one, two, three, four, ruler);
		if(winner.equals(one)){
			mPlayers[0].UpdateScore(1);
		}else if(winner.equals(two)){
		   mPlayers[1].UpdateScore(1);
		}else if(winner.equals(three)){
		   mPlayers[2].UpdateScore(1);
		}else if(winner.equals(four)){
		   mPlayers[3].UpdateScore(1);
	   }
    }

}
