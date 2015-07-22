package com.niitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.niitapp.library.UserFunctions;

public class OnlineAssessment extends Activity {

	UserFunctions userFunctions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String str = getIntent().getStringExtra("selectedrbtn");
		if(str.equalsIgnoreCase("cycle test"))
		{
			setContentView(R.layout.cycle_test);
		}
		else
		{
			setContentView(R.layout.sample_test);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.selection, menu);
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
		if(id == R.id.logout)
		{
			userFunctions.logoutUser(getApplicationContext());
			Intent login = new Intent(getApplicationContext(), Login.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
