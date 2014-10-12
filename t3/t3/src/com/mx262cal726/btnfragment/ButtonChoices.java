package com.mx262cal726.btnfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mx262cal726.t3.R;

public class ButtonChoices extends Fragment{

	
	public ButtonChoices()
	{
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			
			Bundle savedInstaceState)
	{
		
		View view = inflater.inflate(R.layout.game_pieces_layout, null);
        
		return  view;
	}

}
