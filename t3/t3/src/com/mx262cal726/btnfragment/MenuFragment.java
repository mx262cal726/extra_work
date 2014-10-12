package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.R;
import com.mx262cal726.t3.R.layout;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;


public class MenuFragment extends Fragment 
{
	View view;
	Fragment frag, fragTwo,fragEditNames,fragGamePieces;
	FragmentTransaction fragTransaction,fragTwoTransaction;
	FragmentTransaction fragEditNamesTransaction,fragPiecesTransaction;
	Button buttonNames;
	Fragment dialogFrag;
	FragmentTransaction fragDialogFragTransaction;
	Button buttonPieces;
	public MenuFragment()
	{
		
	}
	
	
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
	view = inflater.inflate(R.layout.buttons_choices_layout,container,false);
    

    // fragTwo = new ButtonChoices();

    frag = new BackgroundFrag();
	
	fragTransaction=getFragmentManager().beginTransaction().replace(R.id.container,frag);
    fragTransaction.commit();
	buttonPieces = (Button)view.findViewById(R.id.pieceButton);
	
	
	buttonPieces.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View view)
		{
			System.out.println("buttons PIECES was clicked");
			//getFragmentManager().beginTransaction().remove(fragEditNames).commit();
			fragGamePieces = new ChooseGamePieces();
			fragPiecesTransaction=getFragmentManager().beginTransaction()
		      .replace(R.id.container, fragGamePieces);
			fragPiecesTransaction.commit();
		}
	});


	return view;
  }




}
