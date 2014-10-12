package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.R;
import com.mx262cal726.t3.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;


public class BackgroundFragmentMenu extends Fragment
{
	View view;
	Fragment frag, fragTwo;
	FragmentTransaction fragTransaction,fragTwoTransaction;
	
	
	public BackgroundFragmentMenu()
	{
		
	}
	
	
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
	view = inflater.inflate(R.layout.activity_multi_fragment,container,false);
    
	frag = new BackgroundFrag();

	
	
	fragTransaction=getFragmentManager().beginTransaction().add(R.id.container, frag);
	//fragTransaction.commit();


	return view;
  }

}
