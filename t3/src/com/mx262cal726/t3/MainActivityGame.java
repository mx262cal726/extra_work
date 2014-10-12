package com.example.t3;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
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

public class MainActivityGame extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.t3.MESSAGE";
	public final static String nameWin = "com.example.t3.win";
	private String[] names = {};
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;
    ImageView iV1;
    TextView tV1, tV2;
    Button newGame, exit;
    public String p1,p2;
    String winnerName, loserName,playerOne,playerTwo,player1,player2;
    long start, stop;
    
    public boolean player;
    public static int rowOne,rowTwo,rowThree,columnOne,columnTwo,columnThree,crossOne,crossTwo;
    public static int rowOnex,rowTwox,rowThreex,columnOnex,columnTwox,columnThreex,crossOnex,crossTwox;
    boolean one=true,two=true,three=true,four=true,five=true,
    		six=true,seven=true,eight=true,nine=true;
    
    public MainActivityGame()
    {
    	
    }
    public MainActivityGame(String player1, String player2)
    {
    	System.out.println(player1 + "  " + player2);
    	System.out.println(player1 + "  " + player2);
    	System.out.println(player1 + "  " + player2);
    	p1 =player1;
    	p2=player2;
    	System.out.println(player1 + "  " + player2);
    	System.out.println(player1 + "  " + player2);
    	System.out.println(player1 + "  " + player2);
    	
    	System.out.println(p1 + "  " + p2);
    	
        System.out.println(player1 + "  " + player2);

    }
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_intro);
		addButtonListener();
		iV1 = (ImageView) findViewById(R.id.iV1);
		tV1 = (TextView) findViewById(R.id.tV1);
		//tV2 = (TextView) findViewById(R.id.tV2);
		tV1.setTextSize(25);
    	System.out.println(p1 + " this is onCreate " + p2);

		//tV2.setTextSize(25);

		Intent intent = getIntent();
		names = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
		//playerOne = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		//String win = intent.getStringExtra(MainActivity.nameWin);
        player1=names[0];
        player2=names[1];
        tV1.setText(names[0]+" vs " + names[1]);
       // tV2.setText(names[1]);
		
	}


    /**
     * Assigns listeners to the buttons used for the individuals playing
     */
    public void addButtonListener() 
    {

        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2=(ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4=(ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton6=(ImageButton) findViewById(R.id.imageButton6);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton8=(ImageButton) findViewById(R.id.imageButton8);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);

        
        imageButton2.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             if(two)
             {
            	if(player)
            	{
            	  player = false;
            	  imageButton2.setImageResource(R.drawable.tic);
            	  columnTwo++;
            	  rowOne++;
            	  score("o");

             	}
            	else
            	{
                  imageButton2.setImageResource(R.drawable.tac);
            	  player = true;
            	  rowOnex++;
            	  columnTwox++;
            	  score("x");
            	}
            	two=false;
             }
            }
        });
        
        imageButton1.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             if(one)
             {
            	 
              	if(player)
            	{
                    player = false;
                	imageButton1.setImageResource(R.drawable.tic);
                	rowOne++;
                	columnOne++;
                	crossOne++;
                	score("o");
                }
            	else
            	{
            	  imageButton1.setImageResource(R.drawable.tac);
            	  player = true;
            	  rowOnex++;
            	  columnOnex++;
            	  crossOnex++;
            	  score("x");
            	}
              	one=false;
             }
            }

        });
        
        imageButton3.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             
            	if(three)
            	{
            	if(player)
            	{
                   player = false;
            	   imageButton3.setImageResource(R.drawable.tic);
            	   rowOne++;
            	   columnThree++;
            	   crossTwo++;
            	   score("o");
            	}
            	else 
            	{
            	  imageButton3.setImageResource(R.drawable.tac);
            	  player = true;
            	  rowOnex++;
            	  crossTwox++;
            	  columnThreex++;
            	  score("x");
            	}
            	three =false;
            	}
            }

            

        });      
        
        imageButton4.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             if(four)
             {
             	if(player)
            	{
            		
             	  player = false;
            	  imageButton4.setImageResource(R.drawable.tic);
                  rowTwo++;
                  columnOne++;
            	  score("o");
            	}
            	else
            	{
            	  imageButton4.setImageResource(R.drawable.tac);
            	  player = true;
                  rowTwox++;
                  columnOnex++;
                  score("x");
            	}
             	four=false;
             }
            }

        });       
        
        imageButton5.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             if(five)
             {
             	if(player)
            	{
            		
             	  player = false;
            	  imageButton5.setImageResource(R.drawable.tic);
                  rowTwo++;
                  columnTwo++;
                  crossOne++;
                  crossTwo++;
                  score("o");
            	
            	}
            	else
            	{
            	  imageButton5.setImageResource(R.drawable.tac);
            	  player = true;
                  rowTwox++;
                  columnOnex++;
                  crossOnex++;
                  crossTwox++;
                  score("x");
            	}
             	five=false;
             }
           }

        });      
        
        imageButton6.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             if(six)
             {
             	if(player)
            	{
            		
                  player = false;
            	  imageButton6.setImageResource(R.drawable.tic);
                  rowTwo++;
                  columnThree++;
            	  score("o");
            	}
            	else
            	{
            	  imageButton6.setImageResource(R.drawable.tac);
            	  player = true;
                  rowTwox++;
                  columnThreex++;
                  score("x");
            	}
             	six=false;
             }
            }

        });    
        
        imageButton7.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
             if(seven)
             {
             	if(player)
            	{
                  player = false;     	
                  imageButton7.setImageResource(R.drawable.tic);
                  rowThree++;
                  columnOne++;
                  crossTwo++;
            	  score("o");
            	}
            	else
            	{
            	  imageButton7.setImageResource(R.drawable.tac);
            	  player = true;
                  rowThreex++;
                  columnOnex++;
                  crossTwox++;
                  score("x");
            	}
             	seven=false;
             }
            }

        });     
        
        imageButton8.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
            	if(eight)
            	{
             	if(player)
            	{
            		
                    player = false; 	
            	imageButton8.setImageResource(R.drawable.tic);
                rowThree++;
                columnTwo++;
            	score("o");
            	}
            	else
            	{
            	  imageButton8.setImageResource(R.drawable.tac);
            	  player = true;
                  rowThreex++;
                  columnTwox++;
                  score("x");
            	}
             	eight=false;
            	}
            }

        });    
        
        imageButton9.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
            	if(nine)
            	{
            		
            	if(player)
            	{
            		
                  player = false;
            	  imageButton9.setImageResource(R.drawable.tic);
                  rowThree++;
                  columnThree++;
                  crossOne++;
                  score("o");

            	}
            	else
            	{
            	  imageButton9.setImageResource(R.drawable.tac);
            	  player = true;
                  rowThreex++;
                  columnThreex++;
                  crossOnex++;
                  score("x");
            	}
            	nine=false;
            	}
            }

        });
        if(one==false && two ==false && three ==false && four == false && five
        ==false && six == false && seven==false && eight==false && nine ==false)
        {
        	resetButtons();
        }
    }
    
    public void score(String player)
    {
      if(player.equals("o"))
      {
        if(rowOne==3 || rowTwo ==3 || rowThree == 3 || columnOne==3 || 
     	   columnTwo ==3 ||columnThree ==3 || crossOne==3 || crossTwo ==3)
        {
          victory(player);
        }

      }
  	  if(player.equals("x"))
  	  {
        if(rowOnex==3 || rowTwox ==3 || rowThreex == 3 || columnOnex==3 || 
	       columnTwox ==3 ||columnThreex ==3 || crossOnex==3 || crossTwox ==3)
        {
          victory(player);
        }
  	  }
    }
    public void victory(String exoro)
    {
    	
      if(exoro.equals("x"))
      {
        winnerName = player1;
        loserName = player2;
        names[0] = winnerName;
        names[1]= loserName;
        
	   // tV1.setText(R.string.win);
		//tV1.setTextSize(75);
	  //  iV1.setImageResource(R.drawable.tac);
	   // System.out.println("The tac is the winner!!!");
       // resetButtons();
	    //new DisplayMessageActivity(winnerName, (ImageView) findViewById(R.drawable.tic), R.drawable.tic);
	    sendMessage();
	    System.exit(1);
   	  }
      
      if(exoro.equals("o"))
      {
    	winnerName = player2;
    	loserName = player1;
        names[0] = winnerName;
        names[1]= loserName;
  	    //tV1.setText(R.string.win);
 	 	//tV1.setTextSize(75);
		//iV1.setImageResource(R.drawable.tic);
		//System.out.println("o is the winner!!!");
		// resetButtons();
	//	new DisplayMessageActivity(winnerName, (ImageView) findViewById(R.drawable.tic), R.drawable.tic);
	     sendMessage();
	     System.exit(1);
	    }
    }
    public void resetButtons()
    {

      		  one = true;
      		  two = true;
      		  three = true;
      		  four = true;
      		  five = true;
      		  six = true;
      		  seven = true;
      		  eight = true;
      		  nine = true;
      		  rowOne=0;
      		  rowTwo=0;
      		  rowThree=0;
      		  columnOne=0;
      		  columnTwo=0;
      		  columnThree=0;
      		  crossOne=0;
      		  crossTwo=0;
      		  rowOnex=0;
      		  rowTwox=0;
      		  rowThreex=0;
      		  columnOnex=0;
      		  columnTwox=0;
      		  columnThreex=0;
      		  crossOnex=0;
      		  crossTwox=0;
      		  tV2.setText(" ");
      		  iV1.setImageResource(R.drawable.tictactoe);
      		  imageButton1.setImageResource(R.drawable.toe);
      		  imageButton2.setImageResource(R.drawable.toe);
      		  imageButton3.setImageResource(R.drawable.toe);
      		  imageButton4.setImageResource(R.drawable.toe);
      		  imageButton5.setImageResource(R.drawable.toe);
      		  imageButton6.setImageResource(R.drawable.toe);
      		  imageButton7.setImageResource(R.drawable.toe);
      		  imageButton8.setImageResource(R.drawable.toe);
      		  imageButton9.setImageResource(R.drawable.toe);  
      exit = (Button) findViewById(R.id.exitGame);
      exit.setOnClickListener(new OnClickListener(){
    	  public void onClick(View view)
    	  {
    		onStop();
    	    System.exit(1);
    	  }
      });
      
    }
    
	public void sendMessage()
	{
	  Intent intent = new Intent(this, DisplayMessageActivity.class);

	  intent.putExtra(EXTRA_MESSAGE, names);
	  intent.putExtra(nameWin,winnerName);
	  startActivity(intent);
	  
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
	/////////////
	//////////////
	///////////////////



}
