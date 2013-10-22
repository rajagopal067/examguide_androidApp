package com.example.examguide;


import java.util.Calendar;
import java.util.GregorianCalendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NerdPage extends Activity {

	private Spinner date_spinner,month_spinner,year_spinner;
	private Button submitBtn;
	private TextView daysLeft;
	private ProgressBar progressBar;
	private int progressCount;
	
	Calendar calendar=Calendar.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent=getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nerd_page);
		// Show the Up button in the action bar.
		date_spinner=(Spinner)findViewById(R.id.date_spinner);
		date_spinner.setSelection(calendar.get(Calendar.DAY_OF_MONTH)-1);
		
		month_spinner=(Spinner) findViewById(R.id.month_spinner);
		month_spinner.setSelection(calendar.get(Calendar.MONTH));
		year_spinner=(Spinner) findViewById(R.id.year_spinner);
		year_spinner.setSelection(0);
		
		addListeneronSpinnerItemSelection();
		addListenerOnButton();
		setupActionBar();
		
		final TextView pracTest1=(TextView) findViewById(R.id.pracTest1);
		pracTest1.setText(Html.fromHtml(
				"<a href=\"http://www.examenglish.com/TOEFL/TOEFL_iBt.html\">Practice Test1</a>"));
		pracTest1.setMovementMethod(LinkMovementMethod.getInstance());
		pracTest1.setTextSize(20);
		
		final TextView pracTest2=(TextView) findViewById(R.id.pracTest2);
		pracTest2.setText(Html.fromHtml
				("<a href=\"http://www.testden.com/challenge/free-toefl.asp?refererid=goog2&gclid=CNCby4jpp7oCFacl4godfnEApA\">Practice Test2</a>"));
		pracTest2.setMovementMethod(LinkMovementMethod.getInstance());
		pracTest2.setTextSize(20);
		
		final TextView pracTest3=(TextView) findViewById(R.id.pracTest3);
		pracTest3.setText(Html.fromHtml
				("<a href=\"http://www.stuff.co.uk/toefl_structure_2.htm\">Practice Test3</a>"));
		pracTest3.setMovementMethod(LinkMovementMethod.getInstance());
		pracTest3.setTextSize(20);
		
		final TextView pracTest4=(TextView) findViewById(R.id.pracTest4);
		pracTest4.setText(Html.fromHtml
				("<a href=\"http://www.4tests.com/exams/questions.asp?exid=20986406&googlebot=57&beta=1\">Practice Test4</a>"));
		pracTest4.setMovementMethod(LinkMovementMethod.getInstance());
		pracTest4.setTextSize(20);
		
		pracTest1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pracTest1.setLinkTextColor(getResources().getColor(R.color.magenta));
				progressBar=(ProgressBar) findViewById(R.id.progressBar);
				progressCount+=25;
				progressBar.setProgress(progressCount);
				pracTest1.setClickable(false);
			}
		});
		
		pracTest2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pracTest2.setLinkTextColor(getResources().getColor(R.color.magenta));
				progressBar=(ProgressBar) findViewById(R.id.progressBar);
				progressCount+=25;
				progressBar.setProgress(progressCount);
				pracTest2.setClickable(false);
			}
		});
		
		pracTest3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pracTest3.setLinkTextColor(getResources().getColor(R.color.magenta));
				progressBar=(ProgressBar) findViewById(R.id.progressBar);
				progressCount+=25;
				progressBar.setProgress(progressCount);
				
			}
		});
		pracTest4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pracTest4.setLinkTextColor(getResources().getColor(R.color.magenta));
				progressBar=(ProgressBar) findViewById(R.id.progressBar);
				progressCount+=25;
				progressBar.setProgress(progressCount);
				if(progressBar.getProgress()==100)
				{
					onfinish();
				}
			}
		});
		
		
		
	}
	public void onfinish()
	{
		AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
		alertDialogBuilder.setTitle("Congratualions!! You are ready Now !!");
		alertDialogBuilder.setMessage("Click Yes to exit");

		alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				NerdPage.this.finish();
			}
		});
		alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		
		AlertDialog alertDialog=alertDialogBuilder.create();
		alertDialog.show();
	}
	
	
	public void addListeneronSpinnerItemSelection()
	{
		date_spinner=(Spinner)findViewById(R.id.date_spinner);
		date_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		month_spinner=(Spinner) findViewById(R.id.month_spinner);
		month_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		year_spinner=(Spinner)findViewById(R.id.year_spinner);
		year_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

	public void addListenerOnButton()
	{
		date_spinner=(Spinner) findViewById(R.id.date_spinner);
		month_spinner=(Spinner) findViewById(R.id.month_spinner);
		year_spinner=(Spinner) findViewById(R.id.year_spinner);
		submitBtn=(Button) findViewById(R.id.submitbtn);
		submitBtn.setClickable(true);
		submitBtn.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				Toast.makeText(NerdPage.this, "Day: "+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH))+"Month: "
				+String.valueOf(calendar.get(Calendar.MONTH+1)+"Year: "+String.valueOf(calendar.get(Calendar.YEAR))), Toast.LENGTH_SHORT).show();
//				int numberofdaysleft=date_spinner.
				
				daysLeft=(TextView) findViewById(R.id.daysLeft);
				daysLeft.setText("No of Days Left: "+CustomOnItemSelectedListener.daysLeft);
				daysLeft.setTextSize(15);
				submitBtn.setTextColor(getResources().getColor(R.color.white));
			}
		});
		
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nerd_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
