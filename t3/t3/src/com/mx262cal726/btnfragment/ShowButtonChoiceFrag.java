package com.mx262cal726.btnfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mx262cal726.t3.R;

public class ShowButtonChoiceFrag extends Fragment{

	public int button;
	public ImageView image;
	public int imageId;
	public ShowButtonChoiceFrag()
	{
	  
	}
	public ShowButtonChoiceFrag(int button)
	{
      this.button = button;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstaceState)
	{
		
	  View view = inflater.inflate(R.layout.show_button_choice_frag, container,false);
	  image = (ImageView) view.findViewById(R.id.showBtnChoiceImage);
	  if(button==1)
      {
		imageId = R.drawable.tic_choice;
	    image.setImageResource(imageId);
      }
	  else
	  {
		  imageId = R.drawable.button_choice;
		    image.setImageResource(imageId);
	  }
		return  view;
	}
}