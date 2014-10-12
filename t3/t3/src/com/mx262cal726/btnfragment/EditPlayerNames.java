package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.MainActivity;
import com.mx262cal726.t3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class EditPlayerNames extends Fragment {

	EditText playerOne;
	EditText playerTwo;
    public static String p1="Mighty Mouse";
    public static String p2="VCR Repair Assistant";
    ImageButton enterName;
    Fragment fragNames;
    int five=5;
    public String stringOne="Mighty Mouse";
    public String stringTwo="VCR Repairman";
    FragmentTransaction fragNamesTransaction;
    Fragment fragRemove;
    FragmentTransaction fragRemoveTransaction;
	
	public EditPlayerNames(){
		
	}
	public void setNameOne(String s)
	{
		stringOne = s;
	}
	public String getNameOne()
	{
		
		return stringOne;
	}
	
	public void setNameTwo(String s)
	{
		stringTwo = s;
	}
	public String getNameTwo()
	{
		
		return stringTwo;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstaceState)
	{
		
		View view = inflater.inflate(R.layout.name_editor, container,false);
        playerOne = (EditText)view.findViewById(R.id.firstPlayer);
        playerTwo = (EditText)view.findViewById(R.id.secondPlayer);
        enterName = (ImageButton) view.findViewById(R.id.enterNames);
        
        enterName.setOnClickListener(new OnClickListener()
        {
		  @Override
		  public void onClick(View v) 
		  {
			
		    setNameOne(playerOne.getText().toString());
		    setNameTwo(playerTwo.getText().toString());
		  	  if(!(getNameOne().equals("")))
		  	  {
		  		  System.out.println("in the IF P1 = "+p1 );
		  		  setNameOne(playerOne.getText().toString());
		  	    p1 = playerOne.getText().toString();
		  	  System.out.println("in the AFTER IF P1 = "+p1 );
		  	  }
		  	  else
		  	  {
		  		p1 = "Mighty Mouse";
		  	  }
		  	  
		  	  if(!(getNameTwo().equals("")))
		  	  {
		  		System.out.println("in the IF P = "+p1 );
		  	    p2 = playerTwo.getText().toString();
		  	  System.out.println("in the AFTER IF P2 = "+p1 );
		  	  }
		  	  else
		  	  {
		  		p2 = "VCR Repair Assistant";
		  	  }
		  	  System.out.println(p1+p2);
			new MainActivity(p1, p2,five );
			fragRemove = new RemoveFrag();
			fragRemoveTransaction = getFragmentManager().beginTransaction().replace(R.id.container, fragRemove);
     	    fragRemoveTransaction.commit();
			fragNames = new NamesDisplayFragment(p1,p2);
			
            fragNamesTransaction = getFragmentManager().beginTransaction().replace(R.id.nameContainer, fragNames);
			fragNamesTransaction.commit();
		  }
		});
      
        return view;
	}
}
