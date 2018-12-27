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
        Hand one = new Hand();
        Hand two = new Hand();
        Hand three = new Hand();
        Hand four = new Hand();

        //Deal the cards
        theDeck.deal(one, two, three, four);

        //Show one's hand
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(one.showCards().toString());
    }


}
