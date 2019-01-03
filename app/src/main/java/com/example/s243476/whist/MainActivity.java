package com.example.s243476.whist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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

		Game game = new Game(p1, p2, p3, p4);
		
		game.Round();
    }
}
