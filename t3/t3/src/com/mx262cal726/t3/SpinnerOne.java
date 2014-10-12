package com.mx262cal726.t3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerOne extends Activity implements OnItemSelectedListener { 

	   Spinner spinner;
	   Button buttonSubmit;
	    
	    public void onItemSelected(AdapterView<?> adapterView, View view, 
	            int i, long l) {
	    	TextView myText = (TextView) view;
	    	Toast.makeText(this, "You Selected" + myText.getText(), Toast.LENGTH_SHORT).show();
	    	System.out.println("get text = " + myText.getText());
	        // An item was selected. You can retrieve the selected item using
	        // parent.getItemAtPosition(pos)
	    	//spinner = (Spinner) findViewById(R.id.buttonChoice);

	    	// Create an ArrayAdapter using the string array and a default spinner layout
	    	//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	       // R.array.button_choices, R.layout.pieces_fragment_layout);
	    	// Specify the layout to use when the list of choices appears
	    	//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    	// Apply the adapter to the spinner
	    	//spinner.setAdapter(adapter);
	    	//spinner.setOnItemSelectedListener(this);
	      //  System.out.println(" onItemSelected  ");
	  	  /*buttonSelection =  (Spinner) findViewById(R.id.buttonChoice);
	  	  ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.button_choices,android.R.layout.simple_spinner_item);
	  	  buttonSelection.setAdapter(adapter);
	  	  buttonSelection.setOnItemSelectedListener(this);
	  	  */

	    }
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	 
	//        spinner = (Spinner) findViewById(R.id.buttonChoice);


        ///    ArrayAdapter<CharSequence> buttonAdapter = ArrayAdapter.createFromResource(this,
	   ///     R.array.button_choices, android.R.layout.simple_spinner_item);	 
            
	                      
	    //    buttonAdapter.setDropDownViewResource
	        //             (android.R.layout.simple_spinner_dropdown_item);
	                      
	   //     spinner.setAdapter(buttonAdapter);
	  //       
	        // Spinner item selection Listener  
	        //addListenerOnSpinnerItemSelection();
	//        spinner.setOnItemSelectedListener(this);
	////        // Button click Listener 
	 //       addListenerOnButton();
	         
	 
	    }

	    private void addListenerOnButton() {
			// TODO Auto-generated method stub
	//    	  spinner = (Spinner) findViewById(R.id.buttonChoice);
	     //     buttonSubmit.setOnClickListener(new OnClickListener() {
	   //
	    //          @Override
	    //          public void onClick(View v) {
	   
	     //             Toast.makeText(SpinnerOne.this,
	      //                    "On Button Click : " + 
	      //                    "\n" + String.valueOf(spinner.getSelectedItem()) ,
	//    /                      Toast.LENGTH_LONG).show();
	    ///          }
	  // 
	  //        });
	   
	      }
			
		
		private void addListenerOnSpinnerItemSelection() {
			// TODO Auto-generated method stub
	    	spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			
		}
		public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	        System.out.println("onNothingSelected" +
	        		" ");

	    }
	
}
