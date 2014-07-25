package com.example.examguide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SuggestionsPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Intent intent=getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suggestions_page);
		// Show the Up button in the action bar.
		setupActionBar();
		TextView speak12=(TextView) findViewById(R.id.speaking12);
		speak12.setText(Html.fromHtml(
				"<a href=\"https://www.youtube.com/watch?v=OrZoJrivGew\">Speaking Questions 1 & 2</a>"));
		speak12.setMovementMethod(LinkMovementMethod.getInstance());
		
		TextView speak3=(TextView) findViewById(R.id.speaking3);
		speak3.setText(Html.fromHtml(
				"<a href=\"https://www.youtube.com/watch?v=jhpmFocy46Y\">Speaking Questions 3</a>"));
		speak3.setMovementMethod(LinkMovementMethod.getInstance());
		
		TextView speak4=(TextView) findViewById(R.id.speaking4);
		speak4.setText(Html.fromHtml(
				"<a href=\"https://www.youtube.com/watch?v=XzmkhKBqNYo\">Speaking Questions 4</a>"));
		speak4.setMovementMethod(LinkMovementMethod.getInstance());
		
		TextView speak5=(TextView) findViewById(R.id.speaking5);
		speak5.setText(Html.fromHtml(
				"<a href=\"https://www.youtube.com/watch?v=k7eYRJszDW0\">Speaking Questions 5</a>"));
		speak5.setMovementMethod(LinkMovementMethod.getInstance());
		
		TextView speak6=(TextView) findViewById(R.id.speaking6);
		speak6.setText(Html.fromHtml(
				"<a href=\"https://www.youtube.com/watch?v=k7eYRJszDW0\">Speaking Questions 6</a>"));
		speak6.setMovementMethod(LinkMovementMethod.getInstance());

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
		getMenuInflater().inflate(R.menu.suggestions_page, menu);
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
