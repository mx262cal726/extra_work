package com.mx262cal726.btnfragment;
import com.mx262cal726.t3.MainActivity;
import com.mx262cal726.t3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ChooseGamePieces extends Fragment 
{
	Button cartoonButton;
	Button orangeAndPurpleButton;
	Fragment frag, fragTwo,fragEditNames;
	FragmentTransaction fragTransaction,fragTwoTransaction;
	FragmentTransaction fragEditNamesTransaction;
	FragmentTransaction fragDisplayTransaction;
	FragmentTransaction fragRemoveTransaction;

	Fragment fragDisplay;
	Fragment fragRemove;
	public int piecesChoiceInt = 0;
	
	View view;

	
	public ChooseGamePieces()
	{
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstaceState)
	{
		
		View view = inflater.inflate(R.layout.game_pieces_layout, null);

	     cartoonButton = (Button)view.findViewById(R.id.ticButton);
	     orangeAndPurpleButton = (Button)view.findViewById(R.id.orangeButton);
	 	
	     cartoonButton.setOnClickListener(new OnClickListener(){
	 		@Override
	 		public void onClick(View view)
	 		{
				System.out.println("On button names");
				piecesChoiceInt =0;
				
				new MainActivity(piecesChoiceInt);
				
				fragRemove = new RemoveFrag();
				fragRemoveTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragRemove);
	     	    fragRemoveTransaction.commit();
	     	    fragDisplay = new ShowButtonChoiceFrag(piecesChoiceInt);
				fragDisplayTransaction = getFragmentManager().beginTransaction().replace(R.id.piecesPickedContainer, fragDisplay);
	     	    fragDisplayTransaction.commit();
	     	
				System.out.println("After call to main ");
	 		}
	 	});
	     orangeAndPurpleButton.setOnClickListener(new OnClickListener(){
	 		@Override
	 		public void onClick(View view)
	 		{
	 	      System.out.println("On button names");
	 	     piecesChoiceInt = 1;
			  new MainActivity(piecesChoiceInt);
			  
				
				fragRemove = new RemoveFrag();
				fragRemoveTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragRemove);
	     	    fragRemoveTransaction.commit();
	     	    
				fragDisplay = new ShowButtonChoiceFrag(piecesChoiceInt);
				fragDisplayTransaction = getFragmentManager().beginTransaction().replace(R.id.piecesPickedContainer, fragDisplay);
	     	    fragDisplayTransaction.commit();
			  System.out.println("After call to main ");
	 		}
	 	});

		return view;
	}
}
