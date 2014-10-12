package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.MainActivity;
import com.mx262cal726.t3.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.EditText;

public class EnterPlayerNamesDialog extends DialogFragment 
{
	
	View view;
	public String name1=";lkasdjfj";
	int layoutId=0;
	 String name;
	boolean onePlayer = false;
  public EnterPlayerNamesDialog(boolean onePlayer)
  {
	this.onePlayer=onePlayer;
  }
  public EnterPlayerNamesDialog()
  {
	  
  }
  public Dialog onCreateDialog(Bundle savedInstanceState)
  {
	AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
	LayoutInflater inflater = getActivity().getLayoutInflater();
	if(onePlayer)
	{
	  layoutId = R.layout.one_player_dialog_layout;
	
	}
	else
	{
	  layoutId = R.layout.enter_player_names_dialog_layout;
	}
	view = inflater.inflate(layoutId,null);
	 
	final EditText input = (EditText)view.findViewById(R.id.singlePlayer);
	System.out.println("name1 = "+name1);
	
	System.out.println("name1 = "+getName());
    
	builder.setView(view)
	.setPositiveButton("Play", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int id) {
			iListener.onDialogPositiveClick(EnterPlayerNamesDialog.this, input.getText().toString());
			
			
		}
	}).setNeutralButton("Play as Guest", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int id) {
			// TODO Auto-generated method stub
			
		}
	});
	AlertDialog dialog = builder.create();
	
	
	return dialog;
	
  }
  public void setName(String name1)
  {
	this.name1 =name1;
  }
  public String getName()
  {
	  return name1;
  }
  public interface NamesDialogInterface
  {
	public void onDialogPositiveClick(DialogFragment dialog, String s);
	public void onDialogNegativeClick(DialogFragment dialog);
	public String getName();
  }
  NamesDialogInterface iListener;
  
  @Override
  public void onAttach(Activity activity)
  {
	super.onAttach(activity);
	try{
		iListener = (NamesDialogInterface) activity;
	}catch(ClassCastException e){
		throw new ClassCastException(activity.toString()+ " must implement " +
				"NamesDialogInterface");
		
	}
  }
  
}
