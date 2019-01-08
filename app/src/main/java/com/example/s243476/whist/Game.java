package com.example.s243476.whist;

public class Game{

	int mCurRuler;
    Player[] mPlayers = new Player[4];
	int mNextToPlay = 0;
	int mNextToBet = 0;

	public Game(Player p1, Player p2, Player p3, Player p4)
	{
		mPlayers[0] = p1;
		mPlayers[1] = p2;
		mPlayers[2] = p3;
		mPlayers[3] = p4;
		mNextToPlay = 0;
		mNextToBet = 0;

	}

	public void Play(int numOfRounds)
	{
		UI.log("Game::Play", "Trying to play");
	    for(int i=0; i<numOfRounds; i++)
		{
			PlayRound();
		}
	}
	private void Debug()
	{
		int i;
		for(i=0; i<4; i++)
		{
			mPlayers[i].DebugInfo();
		}

	}
    private void PlayRound()
	{
		int i;
		UI.log("Game::PlayRound", "Starting...");
        Deck deck = new Deck();
	    Hand[] Hands = new Hand[4];

		for(i=0; i<4; i++)
		{
			Hands[i] = new Hand();
			mPlayers[i].SetHand(Hands[i]);
		}
        UI.log("Game::PlayRound", "Created (Empty) Hand");
		Debug();

        //Deal the cards
        deck.Deal(Hands);
        UI.log("Game::PlayRound", "Deal the deck");
		Debug();
		
        UI.log("Game::PlayRound", "Time to bet...");
        Betting();

        UI.log("Game::PlayRound", "Let's start playing...");

        playing();

    }
	
	private void Betting()
	{
		int i = mNextToBet % 4;
		mNextToBet ++;
		int passCount = 0;
		int[] passTable = {0,0,0,0};

		do
		{
			UI.log("Game::Betting", "i = " + i);
			if(passTable[i] == 0)
			{
				UI.log("Game::Betting", "declare...");
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
		} while(passCount < 4);
	}

	private void playing()
	{
        UI.log("Game", "in playing");

        for(final Card i : mPlayers[0].mCurHand.showCards()) {
            UI.log("Game::Playing", "Trying to create a card button");

            UI.createCardButton(mPlayers[0], i);
        }

	}

	public void playerOneChose(Card one){

	}

    public void getRoundCards(Card one, Card two, Card three, Card four, int ruler){
		UI.log("getRoundCards", "Heyo I'm in getRoundCards");

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
