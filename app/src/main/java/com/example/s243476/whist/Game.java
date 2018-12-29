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

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        //Create a deck
        Deck theDeck = new Deck();

        //Create 4 hands
        final Hand one = new Hand(false);
        final Hand two = new Hand(true);
        final Hand three = new Hand(true);
        final Hand four = new Hand(true);

        //Deal the cards
        theDeck.deal(one, two, three, four);

        //Show one's hand
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
