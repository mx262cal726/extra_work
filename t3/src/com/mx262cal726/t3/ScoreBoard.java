package com.example.t3;

import android.R;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ScoreBoard extends ActionBarActivity {

	TextView score;
	String leader;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_board);
		score = (TextView) findViewById(R.id.score);
		load();

	}
    public void load()
    {
     // SharedPrederences sp = PreferenceManager.getDefaultSharedPreferences(this);
     // String s = sp.getString("nameList", "jim");
  	//  System.out.println("s = "+s);
      //leader = s;
      score.setText("HI THERE")	;
      //score.setText(leader);
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
