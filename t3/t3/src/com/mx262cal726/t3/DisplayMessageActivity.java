package com.mx262cal726.t3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.w3c.dom.Text;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

@SuppressLint("NewApi") public class DisplayMessageActivity extends ActionBarActivity
{
  public final static String EXTRA_MESSAGE = "com.example.t3.MESSAGE";
  public final static String nameWin = "com.example.t3.winner";
  public static String[] playerList = {};
  ArrayList<String> addArray = new ArrayList<String>();
  private int[] winNum;
  private int[] loseNum;
  private String[] names ={};
  private FileOutputStream fos;
  private FileInputStream fis;
  private int placeInArray=0;
  private String numKey,tracker = "Count Track";
 // private int order = 0;
  Map <String,String> nameList,nameListLose;
  String nameTmp, winTmp,loseTmp;
  TextView winText;
  public static String winnerName,loserName;
  String p1,p2, fireworksVid;
  String urlpath,urlpath1,urlpath2,urlpath3,urlpath4;
  String namesFile;
  String tag ="Events";
  ImageView img;
  ImageView winPic;
    int x;
  VideoView vidPlayer;
  DisplayMetrics dMetric;
  SurfaceView surView;
  MediaController mControl;
  Button skip, mMenu,quitGame;
  HashMap scoresW, scoresL;
  boolean winnerHasName, loserHasName;
  File playerNames;
  
  
  public DisplayMessageActivity()
  {
	  
  }
  
  public void getInit()
  { 
	vidPlayer = (VideoView) findViewById(R.id.vidPlayer); 
	vidPlayer.setVideoURI(Uri.parse(fireworksVid));
    mControl = new MediaController(this); 
	 
    dMetric = new DisplayMetrics(); 
    this.getWindowManager().getDefaultDisplay().getMetrics(dMetric); 
    int height = dMetric.heightPixels; 
    int width = dMetric.widthPixels; 

    vidPlayer.setMinimumWidth(width); 
    vidPlayer.setMinimumHeight(height); 
    vidPlayer.setMediaController(mControl); 
  }
  
  public void onDestroy()
  {
	super.onDestroy();
	Log.d(tag, "on the onDestroy() event");
  }
  
  public void pickVid()
  {
	urlpath = "android.resource://" + getPackageName() + "/"+ R.raw.fireworks1;
	urlpath1 = "android.resource://" + getPackageName() + "/"+ R.raw.fireworks2;
	urlpath2 = "android.resource://" + getPackageName() + "/"+ R.raw.fireworks3;
	urlpath3 = "android.resource://" + getPackageName() + "/"+ R.raw.fireworks;
	urlpath4 = "android.resource://" + getPackageName() + "/"+ R.raw.shuffle;
	Random ran = new Random();
	    
	System.out.println(ran.nextInt(4));
	System.out.println(ran.nextInt(4));
	System.out.println(ran.nextInt(4));
	System.out.println(ran.nextInt(4));
	System.out.println(ran.nextInt(4));
	System.out.println(ran.nextInt(4));

	x = ran.nextInt(4)+1;
	
	switch(x)
	{

	  case 1:
	    fireworksVid = urlpath;
	    break;
	  case 2:
		fireworksVid = urlpath1;
		break;
	  case 3:
		fireworksVid = urlpath2;
		break;
	  case 4:
	    fireworksVid = urlpath3;
	    break;
      case 5:
		fireworksVid = urlpath4;
		break;
    }
	System.out.println("x = "+x);
  }
  public void skipMovie()
  {
    Intent intent = new Intent(this, MainActivityGame.class);
    intent.putExtra(EXTRA_MESSAGE, names);
    startActivity(intent);
  }
  public void mainMenu()
  {
    Intent menuIntent = new Intent(this, MainActivity.class);
	startActivity(menuIntent);

  }
  public void stopGame()
  {
    onDestroy();
   // System.exit(1);


  }
  public void save()
  {
	  try {
				fos.write(nameTmp.getBytes());
			    fos.write(loseTmp.getBytes());
			    fos.write(loseTmp.getBytes());
			} 
		    catch (FileNotFoundException e){
		    	e.printStackTrace();
		    }
		    catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		   
   }
  
  public void load()
  {
	  SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
  }
       public static int stringToInt(String value, int _default) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return _default;
	    }
	  }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);

		Intent intent = getIntent();
		
		pickVid();
		
		SharedPreferences nameList = getSharedPreferences("NameListWithInts",Context.MODE_PRIVATE);
		Editor editNum = nameList.edit();

		winText = (TextView) findViewById(R.id.winText);
		winnerName = intent.getStringExtra(MainActivityGame.nameWin)+" ";
	    names = intent.getStringArrayExtra(MainActivityGame.EXTRA_MESSAGE);
		loserName = names[1]+" ";
		winText.setText(winnerName+" is the Winner!");
		SharedPreferences nameValue = getSharedPreferences("MyPreferencesWin",Context.MODE_PRIVATE);
		Editor editor = nameValue.edit();

		SharedPreferences numToName = getSharedPreferences("Translater",Context.MODE_PRIVATE);
		Editor editNumToName = numToName.edit();

		SharedPreferences lowerCaseNames = getSharedPreferences("LowerCasePref",Context.MODE_PRIVATE);
		Editor editLCN = lowerCaseNames.edit();

		SharedPreferences numTracker = getSharedPreferences("MyTrackPref",Context.MODE_PRIVATE);
		Editor editTracker = numTracker.edit();
		
		int x = numTracker.getInt(tracker, 0);
		
		
	    if(nameList.contains(winnerName) || lowerCaseNames.contains(winnerName.toLowerCase()))
		{
 
		  String stringNum = lowerCaseNames.getString(winnerName.toLowerCase(), ""+0);
		  String savedName = numToName.getString(stringNum, ""+0);
		  String tmpInt = nameValue.getString(savedName,""+0);
		  System.out.println("tmp value = "+ tmpInt);
		  placeInArray =  (Integer.parseInt(tmpInt))+1;
		  editor.putString(savedName, ""+placeInArray ); 
		  editor.commit();
		}
	    else
		{
		  editor.putString(winnerName, ""+1);
		  editor.commit();  
	      x = numTracker.getInt(tracker,0);
	      editNumToName.putString(""+x,winnerName);
	      editNumToName.commit();
	      editLCN.putString(winnerName.toLowerCase(),""+x);
	      editLCN.commit();
          editNum.putString(winnerName, ""+x);
          editNum.commit();
	      x = x+1;
          editTracker.putInt(tracker,x);
          editTracker.commit();
		}
		
		SharedPreferences nameLoseValue = getSharedPreferences("MyPreferencesLose",Context.MODE_PRIVATE);
		Editor editLose = nameLoseValue.edit();

	    if(nameList.contains(loserName) || lowerCaseNames.contains(loserName.toLowerCase()) )
		{	
		  String stringNumL = lowerCaseNames.getString(loserName.toLowerCase(), ""+0);
		  String savedNameL = numToName.getString(stringNumL, ""+0);
		  String tmpIntL = nameLoseValue.getString(savedNameL,""+0);
	      System.out.println("tmp value = "+ tmpIntL);
          placeInArray =  Integer.parseInt(tmpIntL)+1;
	      editLose.putString(savedNameL, ""+placeInArray ); 
		  editLose.commit();
        }
        else
	    {
        	
          editLose.putString(loserName, ""+1);
	      editLose.commit();
	      x = numTracker.getInt(tracker,0);
	      editNumToName.putString(""+x,loserName);
	      editNumToName.commit();
	      editLCN.putString(loserName.toLowerCase(),""+x);
	      editLCN.commit();
          editNum.putString(loserName, ""+x);
          editNum.commit();
	      x = x+1;
	      editTracker.putInt(tracker,x);
	      editTracker.commit();

   
	    }
	    
		p1 = names[0];
		p2 =names[1];
		
		skip= (Button)findViewById(R.id.skip);
		skip.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
			  skipMovie();
			}
		});
		
		mMenu= (Button)findViewById(R.id.mmenu);
		mMenu.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				new MainActivity(winnerName,loserName);
			  mainMenu();
			}
		});
		
		quitGame= (Button)findViewById(R.id.quit);
		quitGame.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{

			  System.exit(0);

			}
		});
		
	    System.out.println("check" );

		getInit();
		vidPlayer.setKeepScreenOn(true);
		vidPlayer.start(); 
		vidPlayer.requestFocus();

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
