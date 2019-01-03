package com.example.s243476.whist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.*;


public class Game {

	int mCurRuler;
    Player mPlayers[4];
	int mNextToPlay = 0;
	int mNextToBet = 0;

	public Game(Player p1, Player p2, Player p3, Player p4)
	{
		mPlayer[0] = p1;
		mPlayer[1] = p2;
		mPlayer[2] = p3;
		mPlayer[3] = p4;
		mNextToPlay = 0;
		mNextToBet = 0;
	}
	
	public Play(int numOfRounds)
	{
		for(int i=0; i<numOfRounds; i++)
		{
			PlayRound();
		}
	}
	
    private int PlayRound() 
	{
        setContentView(R.layout.activity_game);
		Hand Hands[4];

        //Create a deck
        Deck deck = new Deck();

        //Deal the cards
        deck.deal(hands);
			
		betting();
		
		playing();
    }
	
	private int betting()
	{
		int i = mNextToBet % 4;
		mNextToBet ++;
		int passCount;
		int passTable[4] = {0,0,0,0};
		int 
					
		do
		{
			if(passTable[i] == 0)
			{
				if(mPlayer[i].Declare() == 0)
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

	private int playing()
	{
		LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
        for(final Card i : one.showCards()) {
            Button b = new Button(this);
            b.setText(i.toString());
            b.setOnClickListener(new OnClickListener(){
                public void onClick(View arg0) {
                    Log.d("onClick", "Heyo I'm in onClick");
                    Card chosenOne = one.choose(i);
                    int type = chosenOne.mType;
                    getRoundCards(chosenOne, two.choose(type), three.choose(type), four.choose(type));
                }
            });

            ll.addView(b);
        }
	}	
    public Hand getRoundCards(Card one, Card two, Card three, Card four){
        Log.d("getRoundCards", "Heyo I'm in getRoundCards");

        TextView tv = (TextView) findViewById(R.id.textView);

        if(one.compareTo(two) > 0 && one.compareTo(three) > 0  && one.compareTo(four) > 0 ) {
            tv.setText(one.toString() + " You won!");
            return new Hand(true);
        }
        tv.setText(one.toString() + " Nonono you lost :(");
        return new Hand(false);
    }

}
