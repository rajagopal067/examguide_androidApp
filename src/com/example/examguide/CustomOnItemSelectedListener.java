package com.example.examguide;

import java.util.Calendar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
	static int daysLeft;
	
	private Calendar calendar=Calendar.getInstance();
	 
	  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		  
		  switch (parent.getId()) 
		  {
		case R.id.date_spinner:
			daysLeft=(pos+1)-calendar.get(Calendar.DAY_OF_MONTH);
			break;

		case R.id.month_spinner:
			daysLeft= daysLeft + ((pos - calendar.get(Calendar.MONTH))*30);
			 break;
			 
		case R.id.year_spinner:
			daysLeft=daysLeft + (2013 + pos - calendar.get(Calendar.YEAR))*365;
			break;
		default:
			break;
		}
		
/*		  Toast.makeText(parent.getContext(), 
			"SelectedId : " + String.valueOf(pos+1),
			Toast.LENGTH_SHORT).show(); */
	  }
	 
	  @Override
	  public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	  }
	 
	}