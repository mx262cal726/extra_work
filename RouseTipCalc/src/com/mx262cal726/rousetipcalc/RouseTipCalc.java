package com.mx262cal726.rousetipcalc;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class RouseTipCalc extends Activity 
{
  private static final String TOTAL_BILL = "TOTAL_BILL";
  private static final String CURRENT_TIP = "CURRENT_TIP";
  private static final String BILL_WITHOUT_TIP = "BILL_WITHOUT_TIP";
  
  private double billBeforeTip;
  private double tipAmount;
  private double finalBill;
  
  EditText billBeforeTipET;
  EditText tipAmountET;
  EditText finalBillET;
  SeekBar tipSeekBar;
  
  private int[] checklistValues = new int[12];
  
  CheckBox friendlyCheckBox;
  CheckBox specialCheckBox;
  CheckBox opinionCheckBox;
  
  RadioGroup availableRadioGroup;
  RadioButton availableOKRadio;
  RadioButton availableBadRadio;
  RadioButton availableGoodRadio;
  
  Spinner problemsSpinner;
  Button startButton;
  Button pauseButton;
  Button resetButton;
  
  Chronometer timeWaiting;
  
  long secondsYouWaited=0;
  
  TextView timeWaitingText;
  
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rouse_tip_calc);

        if( savedInstanceState == null )
        {
          billBeforeTip =0.0;
          tipAmount =0.15;
          finalBill = 0.0;
        }
        else
        {
        	billBeforeTip =savedInstanceState.getDouble(BILL_WITHOUT_TIP);
            tipAmount =savedInstanceState.getDouble( CURRENT_TIP);
            finalBill = savedInstanceState.getDouble(TOTAL_BILL);
        	
        }
        billBeforeTipET = (EditText) findViewById(R.id.BilleditText);
        tipAmountET = (EditText)findViewById(R.id.TipEditText);
        finalBillET= (EditText)findViewById(R.id.finalBillEditText);       
        
        tipSeekBar = (SeekBar) findViewById(R.id.ChangeTipText);
        
        tipSeekBar.setOnSeekBarChangeListener(tipSeekBarListener);
        
        billBeforeTipET.addTextChangedListener(billBeforeTipListener);
        friendlyCheckBox= (CheckBox)findViewById(R.id.friendlyCheckBox);
        specialCheckBox=(CheckBox)findViewById(R.id.specialCheckBox);
        opinionCheckBox= (CheckBox)findViewById(R.id.opinionsCheckBox);
        
        setUpIntroCheckBoxes();
        
        availableRadioGroup = (RadioGroup) findViewById(R.id.availableRadioGroup);
        availableOKRadio= (RadioButton) findViewById(R.id.availableBadRadio);
        availableBadRadio=(RadioButton) findViewById(R.id.availableOKRadio);
        availableGoodRadio=(RadioButton) findViewById(R.id.availableGoodRadio);
        
        addChangeListenerToRadios();
        problemsSpinner = (Spinner)findViewById(R.id.problemsSpinner);
        
        addItemSelectedListenerToSpinner();
        
        startButton =(Button)findViewById(R.id.startButton);
        pauseButton =(Button)findViewById(R.id.pauseButton);
        resetButton =(Button)findViewById(R.id.resetButton);
        
        setButtonOnClickListeners();
        
        timeWaiting = (Chronometer)findViewById(R.id.timeWaiting);
        timeWaitingText = (TextView)findViewById(R.id.timeWaitingText);
        
    }
    private TextWatcher billBeforeTipListener = new TextWatcher()
    {

		@Override
		public void afterTextChanged(Editable arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int arg1, int arg2,
				int arg3) 
		{
			// TODO Auto-generated method stub
	      try
	      {
	    	billBeforeTip = Double.parseDouble(s.toString());  
	    	  
	      }
	      catch(NumberFormatException e )
	      {
	    	billBeforeTip = 0.0;
	    	
	      }
	      
	      updateTipAndFinalBill();
		}
     };
		
    	private void updateTipAndFinalBill()
    	{
    	  double tipAmount = Double.parseDouble(tipAmountET.getText().toString());
    	  
    	  double finalBill = billBeforeTip+(billBeforeTip*tipAmount);
    	  
    	  finalBillET.setText(String.format("%.02f", finalBill));
    	}
    	
    protected void onSaveInstanceState(Bundle outState)
    {
      super.onSaveInstanceState(outState);
      
      outState.putDouble(TOTAL_BILL, finalBill);
      outState.putDouble(CURRENT_TIP, tipAmount);
      outState.putDouble(BILL_WITHOUT_TIP, billBeforeTip);
    	
    }
    
    private OnSeekBarChangeListener tipSeekBarListener = new OnSeekBarChangeListener()
    {

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) 
		{
			
			tipAmount=( tipSeekBar.getProgress())*.01;
			tipAmountET.setText(String.format("%7.02f", tipAmount));
			updateTipAndFinalBill();
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) 
		{
			// TODO Auto-generated method stub
			
		}
		
    };
    private void setUpIntroCheckBoxes()
    {
    	friendlyCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
    	{

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			  
				checklistValues[0]=(friendlyCheckBox.isChecked())?4:0;
				
				setTipFromWaitressChecklist();
				
				updateTipAndFinalBill();
				
				
			}
    		
    	});
    	specialCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
    	{

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			  
				checklistValues[1]=(specialCheckBox.isChecked())?1:0;
				
				setTipFromWaitressChecklist();
				
				updateTipAndFinalBill();
				
				
			}
    		
    	});
    	opinionCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
    	{

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			  
				checklistValues[2]=(opinionCheckBox.isChecked())?2:0;
				
				setTipFromWaitressChecklist();
				
				updateTipAndFinalBill();
				
				
			}
    		
    	});    	
    }
    
    private void setTipFromWaitressChecklist()
    {
    	int checklistTotal = 0;
    	for(int item : checklistValues)
    	{
    		checklistTotal+=item;
    	}
    	tipAmountET.setText(String.format("%.02f", checklistTotal *.01));
    }
    
    private void addChangeListenerToRadios()
    {
      availableRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
      {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			checklistValues[3]=(availableBadRadio.isChecked())?-1:0;
			checklistValues[4]=(availableOKRadio.isChecked())?2:0;
			checklistValues[5]=(availableGoodRadio.isChecked())?4:0;
			setTipFromWaitressChecklist();
			
			updateTipAndFinalBill();			
		}
        
      });
    }
    
    private void addItemSelectedListenerToSpinner()
    {
      problemsSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			checklistValues[6]=(problemsSpinner.getSelectedItem()).equals("Bad")?-1:0;
			checklistValues[7]=(problemsSpinner.getSelectedItem()).equals("OK")?3:0;
			checklistValues[8]=(problemsSpinner.getSelectedItem()).equals("Good")?6:0;
			setTipFromWaitressChecklist();
			
			updateTipAndFinalBill();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0){}
		});
    	
      }
    
    
    private void setButtonOnClickListeners()
    {
      startButton.setOnClickListener(new OnClickListener()
      {

		@Override
		public void onClick(View arg0)
		{
		  int stoppedMilliseconds=0;
		  
		  String chronoText = timeWaiting.getText().toString();
		  String array[]= chronoText.split(":"); 
		  
		  if(array.length == 2)
		  {
			  stoppedMilliseconds = Integer.parseInt(array[0])*60*1000+Integer.parseInt(array[1])*1000;
			  
		  }
		  else if(array.length == 3)
		  {
		    stoppedMilliseconds=Integer.parseInt(array[0])*60*60*1000
		    +Integer.parseInt(array[1])*60*1000+ Integer.parseInt(array[2])*1000;
		  }
		  timeWaiting.setBase(SystemClock.elapsedRealtime()-stoppedMilliseconds);
		  
		  secondsYouWaited = Long.parseLong(array[1]);
		  
		  updateTipBasedOnTimeWaited(secondsYouWaited);
		  timeWaiting.start();
		  
		}
    	  
      });
      
      pauseButton.setOnClickListener(new OnClickListener()
      {

		@Override
		public void onClick(View v)
		{
		  timeWaiting.stop();
			
		}});
      
      resetButton.setOnClickListener(new OnClickListener()
      {

		@Override
		public void onClick(View v)
		{
		  timeWaiting.setBase(SystemClock.elapsedRealtime());
		  secondsYouWaited=0;
		}});
    	
    }
    
    private void updateTipBasedOnTimeWaited(long secondsYouWaited)
    {
      checklistValues[9]=(secondsYouWaited >10)?-2:2;
      setTipFromWaitressChecklist();
		
	  updateTipAndFinalBill();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rouse_tip_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}