package com.example.examguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	public void openSuggestionsPage(View view)
	{
		Intent intent=new Intent(this, SuggestionsPage.class);
		startActivity(intent);
		
	}
	
	public void openNerdPage(View view)
	{
		Intent intent=new Intent(this, NerdPage.class);
		startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
