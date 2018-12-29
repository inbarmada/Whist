package com.example.s243476.whist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Hand two = new Hand(true);
        Hand three = new Hand(true);
        Hand four = new Hand(true);

        //Deal the cards
        theDeck.deal(one, two, three, four);

        //Show one's hand
        LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
        for(final Card i : one.showCards()) {
            Button b = new Button(this);
            b.setText(i.toString());
            b.setOnClickListener(new OnClickListener(){
                public void onClick(View arg0) {
                    TextView tv = (TextView) findViewById(R.id.textView);
                    tv.setText(one.choose(i).toString());
                }
            });

            ll.addView(b);
        }
    }

}
