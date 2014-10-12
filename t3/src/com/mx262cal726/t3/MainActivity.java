package com.example.t3;

import com.example.t3.R.string;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import java.lang.System;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "com.example.t3.MESSAGE";
	public final static String[] names=new String[2];
	public final static String playerTwo = "com.example.t3.win";
	public String p1 = "mighty mouse",p2="robot man";
    EditText player1,player2;
    ImageView cover;
    TextView tV2, title;
    Button newGame, exit;
    HashMap hash;
    
    
    

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  
	  title = (TextView) findViewById(R.id.title);
	  cover = (ImageView) findViewById(R.id.cover);
	  
	  newGame = (Button)findViewById(R.id.startButton);
	//  tV2 = (TextView) findViewById(R.id.textView1);
	  player1 = (EditText) findViewById(R.id.player1);
	  player2 = (EditText) findViewById(R.id.player2);


     // System.exit(1);

	  
	 // player1.setText("Player 1 Name");
	}


    /**
     * Assigns listeners to the buttons used for the individuals playing
     */
    public void scoreSheet(View view)
    {
      Intent intent = new Intent(this, ScoreBoard.class);
      startActivity(intent);
    }
    
	public void play(View view)
	{
	  System.out.println(p1 + "  " + p2);
	  p1 = player1.getText().toString();

	  p2 = player2.getText().toString();
	  //hash = new HashMap();
      
      names[0]= p1;
      names[1]=p2;
	  Intent intent = new Intent(this, MainActivityGame.class);
	  String message = player1.getText().toString();
	  
     // intent.putExtra(EXTRA_MESSAGE,message);
      intent.putExtra(EXTRA_MESSAGE, names);
      startActivity(intent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
