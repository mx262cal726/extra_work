package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.R;
import com.mx262cal726.t3.R.id;
import com.mx262cal726.t3.R.layout;
import com.mx262cal726.t3.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FragmentActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multi_fragment);
		if(savedInstanceState==null)
		{
		//	getSupportFragmentManager().beginTransaction().add(R.id.container, new BackgroundFrag()).commit();
		}
		
	}
}
