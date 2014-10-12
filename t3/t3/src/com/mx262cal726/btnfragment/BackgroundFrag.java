package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BackgroundFrag extends Fragment{

	
	public BackgroundFrag()
	{
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstaceState)
	{
		
		View view = inflater.inflate(R.layout.pieces_fragment_layout, container,false);

		return  view;
	}
}
