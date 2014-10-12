package com.mx262cal726.btnfragment;

import com.mx262cal726.t3.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

public class CatsGameDialog extends DialogFragment 
{
	int layoutId=0;
	boolean onePlayer = false;
	String name;
  public CatsGameDialog(boolean onePlayer)
  {
	this.onePlayer=onePlayer;
  }
  public CatsGameDialog()
  {
	  
  }
  public Dialog onCreateDialog(Bundle savedInstanceState)
  {
	AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
	LayoutInflater inflater = getActivity().getLayoutInflater();

	  layoutId = R.layout.cats_game_dialog_layout;
	

	builder.setView(inflater.inflate(layoutId, null))
	.setPositiveButton("Play", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int id) {
			iListener.onDialogPositiveClick(CatsGameDialog.this);

			
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
  
  public interface CatsDialogInterface
  {
	public void onDialogPositiveClick(DialogFragment dialog);
	public void onDialogNegativeClick(DialogFragment dialog);
  }
  CatsDialogInterface iListener;
  
  @Override
  public void onAttach(Activity activity)
  {
	super.onAttach(activity);
	try{
		iListener = (CatsDialogInterface) activity;
	}catch(ClassCastException e){
		throw new ClassCastException(activity.toString()+ " must implement " +
				"NamesDialogInterface");
		
	}
  }
  
}
