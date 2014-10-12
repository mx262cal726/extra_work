package com.mx262cal726.t3;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.mx262cal726.btnfragment.BackgroundFrag;
import com.mx262cal726.btnfragment.BackgroundFragmentMenu;
import com.mx262cal726.btnfragment.ButtonChoices;
import com.mx262cal726.btnfragment.CatsGameDialog;
import com.mx262cal726.btnfragment.EditPlayerNames;
import com.mx262cal726.btnfragment.EnterPlayerNamesDialog;
import com.mx262cal726.btnfragment.MenuFragment;
import com.mx262cal726.t3.PiecesFragment;
import java.lang.System;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements OnItemSelectedListener, EnterPlayerNamesDialog.NamesDialogInterface {
	
	public final static String EXTRA_MESSAGE = "com.example.t3.MESSAGE";
	public static String[] names = new String[2];
	public final static String BUTTON_CHOICE = "com.example.t3.win";
	public static String p1 = "mighty mouse";
	public static String p2 = "VCR Repair Assistant";
	public static String winnerName, loserName;
	public boolean gamePlayed = false, playerCount;
	public static int gamePieceChoice;
	Fragment frag;
	String[] gamePieces;
	Spinner buttonSelection;
    EditText player1,player2;
    EditText firstPlayer, secondPlayer;
    PiecesFragment pieceFrag;
    ImageView cover;
    public String h="hi", j="bye";
    TextView tV2, title;
    Button newGame, exit,scoreboard;
    Button gamePiecesButton;
    Button playerNamesButton;
    Button playComp;
    HashMap hash;
    int nameGiven;
   // Drawable drawable;
    ImageView imageView;
    
    public MainActivity()
    {}
    public MainActivity(int gamePieceChoice)
    {
      this.gamePieceChoice = gamePieceChoice;
		System.out.println(" gamePieceChoice = " +gamePieceChoice);

    }
    
    public MainActivity(String p1, String p2, int nameGiven)
    {
     setNameOne(p1);
     setNameTwo(p2);
      this.p1 = p1;
      this.p2 = p2;
      System.out.println("this p1 = "+ p1+"  p2 = "+p2);
	  this.nameGiven = nameGiven;
    }
    
    public MainActivity(String win, String lose)
    {
      winnerName = win;
      loserName = lose;
      gamePlayed = true;
    }
 
    public void setButton(int i)
    {
      
    }
    
    public void setNameOne(String p1)
    {
      this.p1 =p1;
    }
    public void setNameTwo(String p2)
    {
      this.p2 =p2;
    }
    public String getNameOne()
    {
      return p1;
    }
    public String getNameTwo()
    {
      return p2;
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
		if(savedInstanceState==null)
		{
			getSupportFragmentManager().beginTransaction().add(R.id.menuContainer, new MenuFragment()).commit();
         //   getSupportFragmentManager().beginTransaction().add( R.id.container,new BackgroundFragmentMenu()).commit();
		}
	//  imageView.setBackground(drawable);
	//  imageView.setBackgroundDrawable(drawable);


	  /**
	   * Creates the control for the spinner
	   */
	  /*buttonSelection =  (Spinner) findViewById(R.id.buttonChoice);
	  ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.button_choices,android.R.layout.simple_spinner_item);
	  buttonSelection.setAdapter(adapter);
	  buttonSelection.setOnItemSelectedListener(this);
	  */
  //    FragmentManager fragManager = getFragmentManager();
//	  FragmentTransaction fragTransaction = fragManager.beginTransaction();
	  
    // pieceFrag = new PiecesFragment();
	//  fragTransaction.add(R.id.nameFrag,  pieceFrag);
//	  fragTransaction.commit();
  ///    gamePieces = getResources().getStringArray(R.array.button_choices);
  //    String label = gamePieces[0];

	  setTitle("Tic Tac Toe");
	//  title = (TextView) findViewById(R.id.title);
	

      newGame = (Button)findViewById(R.id.startButton);
	  scoreboard = (Button)findViewById(R.id.scoreBoard);
	  playComp = (Button) findViewById(R.id.playComp);
      scoreboard.setTextColor(Color.GREEN);

      gamePiecesButton = (Button) findViewById(R.id.pieceButton);

	  newGame.setTextColor(getResources().getColor(R.color.mycolor7));
	  newGame.setTextColor(Color.GREEN);
     
	}
	public void playComputer(View view)
	{     
		playerCount = true;
      onShowNameDialog(playerCount);

	}

	public void setNames(View view)
	{
   //   removeFragNames();
		System.out.println("setNames method");
	  Intent intent = new Intent(getApplicationContext(),FragmentActivity.class);
	  startActivity(intent);
    //  FragmentManager fragManager = getFragmentManager();
	//  FragmentTransaction fragTransaction = fragManager.beginTransaction();
	//  NamesFragment startFrag =new NamesFragment();
	//  fragTransaction.add(R.id.piecesfrag,  startFrag);
	//  fragTransaction.addToBackStack("NF");
	//  fragTransaction.commit();
	}
	public void setSpin()
	{
	
		
		
	}


    /**
     * 
     * Assigns listeners to the buttons used for the individuals playing
     */
    public void scoreSheet(View view)
    {
      Intent intent = new Intent(this, ScoreBoard.class);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
        if(true)
        {
          gamePlayed = false;
		  names[0] = winnerName;
          names[1] = loserName;
  		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
  		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
  		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
          intent.putExtra(EXTRA_MESSAGE, names);
        }

        
      startActivity(intent);
    }
    
	public void play(View view)
	{
      onShowNameDialog(false);
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
	
	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i,
			long l) {


		// TODO Auto-generated method stub
		TextView myText = (TextView) view;
		Toast.makeText(this, "You selected " + myText.getText(), Toast.LENGTH_SHORT).show();
		
	}
	public void onShowNameDialog(boolean playerCount)
	{
		
		  DialogFragment dg = new EnterPlayerNamesDialog(playerCount);
		  dg.show(getSupportFragmentManager(), "NamesDialogFrag");
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDialogPositiveClick(DialogFragment dialog,String string) 
	{
	  //System.out.println("string = "+string);
      Intent intent;
	  names[0]=string; 
	  names[1]=p2;
	  if(playerCount)
	  {
		intent = new Intent(this, ComputerActivity.class);  
	  }
	  else
	  {
	    intent = new Intent(this, MainActivityGame.class);
	  }
	  intent.putExtra(BUTTON_CHOICE,gamePieceChoice);
	  intent.putExtra(EXTRA_MESSAGE, names);
	  startActivity(intent);
		
	}
	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
