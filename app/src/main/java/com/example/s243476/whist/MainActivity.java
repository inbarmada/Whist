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
        setContentView(R.layout.activity_main);
    }

    public void startIt(View view){
		// Intent start = new Intent(this, Game.class);
		// startActivity(start);
		Player p1 = new Player("Johnson");
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();

		game = new Game(p1, p2, p3, p4);

        setContentView(R.layout.activity_game);

        game.Play(13);
    }

    public void createCardButton(final Player one, final Card i){
        LinearLayout ll = (LinearLayout) findViewById(R.id.buttonlayout);

        Button b = new Button(this);
        b.setText(i.toString());
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                Log.d("onClick", "Heyo I'm in onClick");
                Card chosenOne = one.choose(i);
                int type = chosenOne.mType;
                game.playerOneChose(chosenOne);
            }
        });
        ll.addView(b);
    }

}
