package com.mx262cal726.t3;

import java.util.HashMap;
import java.util.LinkedList;

import com.mx262cal726.t3.R.string;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreBoard<E> extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "com.example.t3.MESSAGE";
	public ImageView tardis;
	TextView score, leaderTitle,lose,counter,name;
	TextView loseView1,winView1 ,nameView1;
	TextView loseView2,winView2 ,nameView2;
	TextView loseView3,winView3 ,nameView3;
	TextView loseView4,winView4 ,nameView4;
	TextView loseView5,winView5 ,nameView5;
	TextView loseView6,winView6 ,nameView6;
	TextView loseView7,winView7 ,nameView7;
	TextView loseView8,winView8 ,nameView8;
	TextView loseView9,winView9 ,nameView9;
	TextView loseView10,winView10,nameView10;

	String[] names = new String[2];
	String winnerName, loserName;
	DisplayMetrics dMetrics;
	LinkedList<E> listOrder;
	String original =""+0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_board);
		//new MainActivity(winnerName,loserName);
		Intent intent = getIntent();
		names = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
		//tardis = (ImageView) findViewById(R.id.tardis);
		
		winnerName = names[0];
		loserName = names[1];
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		System.out.println("scoreboard side = "+ winnerName + " loserName = "+ loserName);
		
        listOrder = new LinkedList<E>();
	   // tardis.setMinimumWidth(width);
		score = (TextView) findViewById(R.id.name);
		lose = (TextView) findViewById(R.id.loses);
		name = (TextView) findViewById(R.id.name);
		nameView1 = (TextView)findViewById(R.id.name1);
		nameView2 = (TextView)findViewById(R.id.name2);
		nameView3 = (TextView)findViewById(R.id.name3);
		nameView4 = (TextView)findViewById(R.id.name4);
		nameView5 = (TextView)findViewById(R.id.name5);
		nameView6 = (TextView)findViewById(R.id.name6);
		nameView7 = (TextView)findViewById(R.id.name7);
		nameView8 = (TextView)findViewById(R.id.name8);
		nameView9 = (TextView)findViewById(R.id.name9);
		nameView10 = (TextView)findViewById(R.id.name10);
		
		winView1 = (TextView)findViewById(R.id.win1);
		winView2 = (TextView)findViewById(R.id.win2);
		winView3 = (TextView)findViewById(R.id.win3);
		winView4 = (TextView)findViewById(R.id.win4);
		winView5 = (TextView)findViewById(R.id.win5);
		winView6 = (TextView)findViewById(R.id.win6);
		winView7 = (TextView)findViewById(R.id.win7);
		winView8 = (TextView)findViewById(R.id.win8);
		winView9 = (TextView)findViewById(R.id.win9);
		winView10 = (TextView)findViewById(R.id.win10);
		
		loseView1 = (TextView)findViewById(R.id.loseView1);
		loseView2 = (TextView)findViewById(R.id.loseView2);
		loseView3 = (TextView)findViewById(R.id.loseView3);
		loseView4 = (TextView)findViewById(R.id.loseView4);
		loseView5 = (TextView)findViewById(R.id.loseView5);
		loseView6 = (TextView)findViewById(R.id.loseView6);
		loseView7 = (TextView)findViewById(R.id.loseView7);
		loseView8 = (TextView)findViewById(R.id.loseView8);
		loseView9 = (TextView)findViewById(R.id.loseView9);
		loseView10 = (TextView)findViewById(R.id.loseView10);		
		
		leaderTitle = (TextView)findViewById(R.id.leaderTitle);
		load();
		System.out.print("print line ")	;
	}

	public void load()
	{
      lose.setText(string.loses);
      score.setText(string.win);
      name.setText(string.name);
	  /*  dMetrics = new DisplayMetrics(); 
	    this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics); 
	    int height = dMetrics.heightPixels/4; 
	    System.out.println("height = "+ height);
	    int width = dMetrics.widthPixels; */
      int nameX = 0;
      int nameJ = 0;
      String zero = ""+0;
      SharedPreferences nameValueWin = getSharedPreferences("MyPreferencesWin", Context.MODE_PRIVATE);
      SharedPreferences nameValueLose = getSharedPreferences("MyPreferencesLose",Context.MODE_PRIVATE);
      SharedPreferences nameOrder = getSharedPreferences("NameListWithInts",Context.MODE_PRIVATE);
      SharedPreferences tracker = getSharedPreferences("MyTrackPref",Context.MODE_PRIVATE);
      SharedPreferences numToName = getSharedPreferences("Translater",Context.MODE_PRIVATE);
	  SharedPreferences listInOrder = getSharedPreferences("order",Context.MODE_PRIVATE);
	  SharedPreferences lowerCaseNames = getSharedPreferences("LowerCasePref", Context.MODE_PRIVATE);
	  Editor editProperOrder = listInOrder.edit();
	 // editProperOrder.clear();
	  
      //int mice = tracker.getInt(arg0, arg1)
     // winnerName = sp.getString(winnerName,""+0);
   //   loserName = sp.getString(loserName,""+0);
     // score.setText("THis is the new text");
     // score.setText(winnerName+"This is the Array showing all the wins = "+nameValueWin.getAll()+" order of the names in the list = "+ 
    //  nameOrder.getAll()+"  TRACKER = "+ tracker.getAll() +"  ");
      System.out.println(" numToName =  "+ numToName.getAll());
      int x = tracker.getInt("Count Track",0);
      int lastPlace = 0;
      if(listOrder.size()==0)
      {
        listOrder.addFirst( (E) numToName.getString(""+0,original));
      }
      System.out.println("listOrder Size = "+listOrder.size());
        // if()
      for(int i =0; i <  x; i++ )
      {
        int tmp = i;
    	String name = numToName.getString(""+tmp, original);
    	String points = nameValueWin.getString(name, original);
	    System.out.println(" points = "+ points+" x = "+x);
	    String lowerCaseName = name.toLowerCase();

    	int pointValue = Integer.parseInt(points);
    	//nameX = nameOrder.getString(""+i,""+0);
    	int listSize = listOrder.size();
    	bingo: for(int j = 0; j < listSize; j++)
    	{
  		  System.out.println(" for loop inner = "+ name);

            int temp2 = j;
            String listName = listOrder.get(j).toString();
            String lowerCaseName2 = listName.toLowerCase();
        	//String nameNext = numToName.getString(""+temp2, original);
        	String pointsNext = nameValueWin.getString(listName, original);
        	int pointValueNext = Integer.parseInt(pointsNext);
        //	if((tmp+1) <= x)
        //	{
    	
    		//int k = j+1;
    		//nameJ = nameOrder.getInt(""+k, 0);
    	  if(pointValue > pointValueNext && !(lowerCaseName2.equals(lowerCaseName)) && tmp > temp2)
    	  {
    		System.out.println(" for loop inner = "+ lowerCaseName);
    	    listOrder.add(temp2,(E)name);
    		//end = false;
    
    		break bingo;
    	  }
    	//  lastPlace =i;
    	  
    	  
    	//}
    	}
    	System.out.println(" LinkedList = "+ listOrder);

    	
    	if(!listOrder.contains(name) && !(listOrder.contains(lowerCaseName)))
    	{
    	  listOrder.addLast((E) name);
    	}
    	
      }
  	  System.out.println(" LinkedList = "+ listOrder);
  	  //listOrder.remove();
  	
  //(int counter = 1; counter < listOrder.size(); counter++ )
  //	{
  //	  String holder = ""+counter;
  //	  String tmpString = listOrder.get(counter).toString();
 // 	  TextView holder = (TextView) findViewById(R.id.holder);
 // 	  (""+counter).setText(tmpString);
 // 	}
  	  int size = listOrder.size();
  	  System.out.println(" list Size = " +size);
      for(int i=1; i<size; i++)
      {
      
    	String tmp  =(String) listOrder.get(i);
		  System.out.println(" listOrder Array = "+ tmp);

    	String temp = nameValueWin.getString(tmp, original);
		  System.out.println(" name = "+ tmp+" win streak = "+temp);
		  

    	editProperOrder.putString(tmp, temp);
    	editProperOrder.commit();
		 // System.out.println(" name = "+ tmp+" win streak = "+temp);
      }
  	  for(int n = 1; n <= size; n++)
  	  {
  	  	  System.out.println(" list Size = "+" n = "+n +size);
  	  }
  	  for(int n = 1; n <= size; n++)
  	  {
  	    switch(n)
  	    {
  	  
  	    case 1:
  	    	String one = listOrder.get(0).toString();
  	    	String oneWinScore = nameValueWin.getString(one, zero);
  	    	String oneLoseScore = nameValueLose.getString(one, zero);
  	    	loseView1.setText(oneLoseScore);
  	    	winView1.setText(oneWinScore);
  	    	nameView1.setText(one);
  		  break;
  		  
  	    case 2:
  	    	String two = listOrder.get(1).toString();
  	    	String twoWinScore = nameValueWin.getString(two, zero);
  	    	String twoLoseScore = nameValueLose.getString(two, zero);
  	    	loseView2.setText(twoLoseScore);
  	    	winView2.setText(twoWinScore);
  	    	nameView2.setText(two);
  		  break;
  		  
  	    case 3:
  	    	String three = listOrder.get(2).toString();
  	    	String threeWinScore = nameValueWin.getString(three, zero);
  	    	String threeLoseScore = nameValueLose.getString(three, zero);
  	    	loseView3.setText(threeLoseScore);
  	    	winView3.setText(threeWinScore);
  	    	nameView3.setText(three);
  		  break;
  		  
  	    case 4:
  	    	String four = listOrder.get(3).toString();
  	    	String fourWinScore = nameValueWin.getString(four, zero);
  	    	String fourLoseScore = nameValueLose.getString(four, zero);
  	    	loseView4.setText(fourLoseScore);
  	    	winView4.setText(fourWinScore);
  	    	nameView4.setText(four);
  		  break;
  		  
  	    case 5:
  	    	String five = listOrder.get(4).toString();
  	    	String fiveWinScore = nameValueWin.getString(five, zero);
  	    	String fiveLoseScore = nameValueLose.getString(five, zero);
  	    	loseView5.setText(fiveLoseScore);
  	    	winView5.setText(fiveWinScore);
  	    	nameView5.setText(five);
  		  break;
  		  
  	    case 6:
  	    	String six = listOrder.get(5).toString();
  	    	String sixWinScore = nameValueWin.getString(six, zero);
  	    	String sixLoseScore = nameValueLose.getString(six, zero);
  	    	loseView6.setText(sixLoseScore);
  	    	winView6.setText(sixWinScore);
  	    	nameView6.setText(six);
  		  break;
  		  
  	    case 7:
  	    	String seven = listOrder.get(6).toString();
  	    	String sevenWinScore = nameValueWin.getString(seven, zero);
  	    	String sevenLoseScore = nameValueLose.getString(seven, zero);
  	    	loseView7.setText(sevenLoseScore);
  	    	winView7.setText(sevenWinScore);
  	    	nameView7.setText(seven);
  		  break;
  		  
  	    case 8:
  	    	String eight = listOrder.get(7).toString();
  	    	String eightWinScore = nameValueWin.getString(eight, zero);
  	    	String eightLoseScore = nameValueLose.getString(eight, zero);
  	    	loseView8.setText(eightLoseScore);
  	    	winView8.setText(eightWinScore);
  	    	nameView8.setText(eight);
  		  break;
  		  
  	    case 9:
  	    	String nine = listOrder.get(8).toString();
  	    	String nineWinScore = nameValueWin.getString(nine, zero);
  	    	String nineLoseScore = nameValueLose.getString(nine, zero);
  	    	loseView9.setText(nineLoseScore);
  	    	winView9.setText(nineWinScore);
  	    	nameView9.setText(nine);
  		  break;
  		  
  	    case 10:
  	    	String ten = listOrder.get(9).toString();
  	    	String tenWinScore = nameValueWin.getString(ten, zero);
  	    	String tenLoseScore = nameValueLose.getString(ten, zero);
  	    	loseView10.setText(tenLoseScore);
  	    	winView10.setText(tenWinScore);
  	    	nameView10.setText(ten);
  		  break;
  	    }
  	  }
  	  

      for(int i=1; i<size; i++)
      {
      
    	String tmp  =(String) listOrder.get(i);
		  System.out.println(" listOrder Array = "+ tmp);

    	String temp = nameValueWin.getString(tmp, original);
		  System.out.println(" name = "+ tmp+" win streak = "+temp);
		  

    	editProperOrder.putString(tmp, temp);
    	editProperOrder.commit();
		 // System.out.println(" name = "+ tmp+" win streak = "+temp);
      }
   //   score.setText();
   //  score.setText("These should be in the correct order = "+listInOrder.getAll()+"loserNames = "+nameValueLose.getAll());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score_board, menu);
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
}
