package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NamesDisplayFragment extends Fragment	
{
  TextView names;
  public String p1;
  String p2;
  public NamesDisplayFragment()
  {
	  
  }
  
  public NamesDisplayFragment(String p1, String p2)
  {
	this.p1 = p1;
	this.p2 = p2;
	System.out.println("WATCH ME P1 = "+ p1+ " p2 = "+p2);
  }
  
  @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstaceState)
	{
		
		View view = inflater.inflate(R.layout.names_display_fragment, container,false);
        names = (TextView) view.findViewById(R.id.playerTextNames);
        names.setText(p1 + " vs " + p2);
        
		return  view;
	}
}
