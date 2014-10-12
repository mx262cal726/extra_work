package com.mx262cal726.t3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;



public class PiecesFragment extends Fragment {
	  //  Spinner buttonSelection;
        Button x;
		View view;
		Button button1;
		Spinner buttonSelection;
		@Override
		public void onCreate(Bundle savedInstanceState) 
		{
		  super.onCreate(savedInstanceState);
		  new SpinnerOne();
		}
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	  {
		view = inflater.inflate(R.layout.pieces_fragment_layout,container,false);
		return view;
	  }

	public void setNames(View view)
      {

		  
      }
      public void setPieces()
      {
          System.out.println("setPieces ");
      }
	}


