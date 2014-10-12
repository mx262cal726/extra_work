package com.example.t3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.w3c.dom.Text;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
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

public class DisplayMessageActivity extends ActionBarActivity
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
  String nameTmp, winTmp,loseTmp;
  TextView winText;
  String winnerName,loserName;
  String p1,p2, fireworksVid;
  String urlpath,urlpath1,urlpath2,urlpath3,urlpath4;
  String namesFile;
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
    System.exit(1);


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
    try {
		  fis = openFileInput("/home/rouse/Android/t3/src/k");
		  int read = -1;
		  StringBuffer buffer=new StringBuffer();
		  while((read=fis.read()) !=-1)
		  {
		    buffer.append((char)read);
		  }
		  Log.d("names = ",buffer.toString());
		  String name1 = buffer.substring(0, buffer.indexOf(" "));
		  String num1 = buffer.substring(buffer.indexOf(" ")+1);
	    } 
        catch (FileNotFoundException e) 
        {
		// TODO Auto-generated catch block
		  e.printStackTrace();
	    }
        catch (IOException e) 
        {
		// TODO Auto-generated catch block
		  e.printStackTrace();
	    }
        finally
        {
    	  try 
    	  {
		    fis.close();
		  }
    	  catch (IOException e) 
    	  {
			// TODO Auto-generated catch block
		    e.printStackTrace();
		  }
        }
      }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		Intent intent = getIntent();
		pickVid();
		playerList = new String[10];

		//load();
		winText = (TextView) findViewById(R.id.winText);
		winnerName = intent.getStringExtra(MainActivityGame.nameWin);
		SharedPreferences sPref = PreferenceManager("NameList",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sPref.edit();
		editor.putString("name", "");
		editor.putString("name", "");

		names = intent.getStringArrayExtra(MainActivityGame.EXTRA_MESSAGE);
		winnerName= names[0];
		loserName = names[1];

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
			  mainMenu();
			}
		});
		
		quitGame= (Button)findViewById(R.id.quit);
		quitGame.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
			  stopGame();
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
