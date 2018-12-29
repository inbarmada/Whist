package com.example.s243476.whist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        //Create a deck
        Deck theDeck = new Deck();

        //Create 4 hands
        Hand one = new Hand(false);
        Hand two = new Hand(true);
        Hand three = new Hand(true);
        Hand four = new Hand(true);

        //Deal the cards
        theDeck.deal(one, two, three, four);

        //Show one's hand
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(one.showCards().toString());
    }


}
