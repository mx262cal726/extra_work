package com.mx262cal726.t3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglePlayActivity<E> extends ActionBarActivity {
/*
	public final static String EXTRA_MESSAGE = "com.example.t3.MESSAGE";
	public final static String nameWin = "com.example.t3.win";
	private String[] names = {};
	private int[][] game;
	
	private ArrayList<E> gameLocs;
	private int[] gameLocations;
	private String gamePieces;
    ImageButton imgB1;
    ImageButton imgB2;
    ImageButton imgB3;
    ImageButton imgB4;
    ImageButton imgB5;
    ImageButton imgB6;
    ImageButton imgB7;
    ImageButton imgB8;
    ImageButton imgB9;
    ImageView iV1;
    TextView tV1, tV2;
    Button newGame, exit;
    public String p1,p2;
    private int piecesValue;
    private int gamePieceTicInt, gamePieceTacInt;
    String winnerName, loserName,playerOne,playerTwo,player1,player2;
    long start, stop;
    
    public boolean player;
    public static int rowOne,rowTwo,rowThree,columnOne,columnTwo,
    columnThree,crossOne,crossTwo;
    public static int rowOnex,rowTwox,rowThreex,columnOnex,columnTwox,
    columnThreex,crossOnex,crossTwox;
    private boolean one=true,two=true,three=true,four=true,five=true,
    		six=true,seven=true,eight=true,nine=true;
    Random random;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_intro);
		
		for(int i= 0; i<9; i++)
		{
			int x = i+1;
			gameLocs.add((E) (""+i));
		}
		random = new Random();
		random.nextInt(2);
		imgB1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(x == 1)
				{
					if(one)
		              {
		                one = false;
		              	if(player)
		            	{
		                  player = false;
		                  imgB1.setBackgroundResource(gamePieceTicInt);

		                  rowOne++;
		                  columnOne++;
		                  crossOne++;
		                  gameLocs.remove(""+1);
		                  getPlacement();
		                
		                  if(rowOne==2)
		                  {
		                	  int i = getRow(1);
		                	  ("imgB"+""+i).setBackground(""+i);
		                  }
		                  if(columnOne == 2 )
		                  {
		                	  int i = getRow(2);
		                	  (imgB+""+i).remove(""+i);
		                  }
		                  if(crossOne== 2)
		                  {
		                	  int i = getRow(3);
		                	  (imgB+""+i).remove(""+i);
		                	  
		                  }
		                  else
		                  {
		                	setLocation();
		                  }
		                  score("o");
		                  
		                }
		            	else
		            	{
		            	  imageButton1.setBackgroundResource(gamePieceTacInt);
		            	  player = true;
		            	  rowOnex++;
		            	  columnOnex++;
		            	  crossOnex++;
		            	  score("x");
		            	}
		              }
		            }	
				}
				
			
		});
		
	}
public int getRow(int i)
{
	return i;
	
}
public ArrayList<E> getPlacement()
{
	gameLocs();
}
public setLocation()
{
	  while(tmp)
	  {
		  int y = random.nextInt(gameLocs.size());
		  if(gameLocs.contains(""+y) && (y!=(6 || 8)))
		  {
			  (imgB+""+y).setBackground(null);
			  gameLocs.remove(""+y);
			  tmp = false;
		  }
	  }
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_game, menu);
		return true;
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
	*/
}
