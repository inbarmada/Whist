package com.example.s243476.whist;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("In MainActivity", "super.oncreate done");

        setContentView(R.layout.activity_main);
        log("In MainActivity", "have set layout");

    }

    public void startIt(View view){
        log("In MainActivity", "In StartIt");
		// Intent start = new Intent(this, Game.class);
		// startActivity(start);
		Player p1 = new Player("Johnson");
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();

        log("In MainActivity", "Have Created Players");

        game = new Game(p1, p2, p3, p4);
        log("In MainActivity", "Have Created Game");

        setContentView(R.layout.activity_game);

        log("In MainActivity", "Have set content view");

        game.Play(13);
        log("In MainActivity", "Have game.play-ed");

    }

    public void createCardButton(final Player one, final Card i){
        log("In MainActivity", "Trying to create button");

        LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);
        log("In MainActivity", "Found view by id");

        Button b = new Button(this);
        log("In MainActivity", "Created button");

        b.setText(i.toString());
        log("In MainActivity", "Set text");

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                log("onClick", "Heyo I'm in onClick");
                //Card chosenOne = one.choose(i);
                //int type = chosenOne.mType;
                //game.playerOneChose(chosenOne);
            }
        });
        log("In MainActivity", "created listener");

        ll.addView(b);
        log("In MainActivity", "Added button to view");

    }

    static void log(String str1, String str2)
    {
    	Log.d(str1, str2);
    }
}
